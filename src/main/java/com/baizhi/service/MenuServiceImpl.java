package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MenuServiceImpl implements  MenuService {
    @Autowired
    MenuDao menuDao;
    @Override
    public List<Menu> queryAll() {
        return menuDao.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> queryBanner(Integer page,Integer rows){
        Jedis jedis=null;
        try {
            //每次查询先检查redis中是否存在缓存  存在直接返回不存在查询数据库
            jedis = new Jedis("192.168.163.128",6379);
            String keys = "findAll"+page+"-"+ rows;
            if (jedis.hexists("com.baizhi.service.MenuService",keys)) {
                //redis中存在数据直接获取并返回
                String json = jedis.hget("com.baizhi.service.MenuService",keys);
                return JSONObject.parseArray(json,Banner.class);
            }else{//redis没有查询数据库 查询结果存入redis中
                int start =  (page-1)*rows;
                List<Banner> results = menuDao.queryBanner(start,rows);
                String json = JSONObject.toJSONString(results);
                jedis.hset("com.baizhi.service.MenuService",keys,json);
                return results;
            }
        }catch (Exception e){
            int start =  (page-1)*rows;
            return menuDao.queryBanner(start,rows);
        }finally {
            jedis.close();
        }

    }

    public void del(String b_id){
        menuDao.del(b_id);
    }

    @Override
    public void insertBanner(Banner banner){
        banner.setB_id(UUID.randomUUID().toString());
        menuDao.insertBanner(banner);
    }
    @Override
    public void update(Banner banner){
        menuDao.update(banner);
    }

    @Override
    public Banner queryBan(String b_id) {
        Banner banner=menuDao.queryBan(b_id);
        return banner;
    }

    @Override
    public Long findTotals(){
        return menuDao.findTotals();
    }
}
