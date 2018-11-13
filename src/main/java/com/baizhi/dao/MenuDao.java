package com.baizhi.dao;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    public List<Menu> queryAll();
    public List<Banner> queryBanner(@Param("start") Integer start, @Param("rows") Integer rows);
    public Long findTotals();
    public void del(String b_id);
    public void insertBanner(Banner banner);
    public void update(Banner banner);
    public Banner queryBan(String b_id);
}
