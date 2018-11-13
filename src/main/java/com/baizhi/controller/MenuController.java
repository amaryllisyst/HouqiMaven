package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping("/queryAll")
    public @ResponseBody List<Menu> querymenu(){
        List<Menu> menus = menuService.queryAll();
        return menus;
    }

    @RequestMapping("/queryBanner")
    public @ResponseBody Map<String,Object> queryBanner(Integer page,Integer rows){
        page= page==null?1:page;
        rows= rows==null?2:rows;
        Map<String,Object> result = new HashMap<String,Object>();
        List<Banner> banners=menuService.queryBanner(page, rows);
        result.put("rows",banners);
        result.put("total",menuService.findTotals());
        return result;
    }

    @RequestMapping("/save")
    public String save(Banner banner, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //获取项目绝对路径
        String realPath=request.getSession().getServletContext().getRealPath("/banner_img");
        //上传音频到绝对路径
        multipartFile.transferTo(new File(realPath,multipartFile.getOriginalFilename()));
        banner.setB_date(new Date());
        banner.setB_imgPath("/banner_img/"+multipartFile.getOriginalFilename());
        menuService.insertBanner(banner);
        return "redirect:/menu/queryBanner";
    }

    @RequestMapping("/del")
    public String del(String b_id){
        menuService.del(b_id);
        System.out.println(b_id);
        return "redirect:/menu/queryBanner";
    }

    @RequestMapping("/delMore")
    public String delMore(String[] b_id){
        for (String i : b_id) {
            menuService.del(i);
        }
        return "redirect:/menu/queryBanner";
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Banner banner){
        System.out.println(banner);
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            menuService.update(banner);
            map.put("success", "修改成功");
        }catch(Exception e){
            e.printStackTrace();
            map.put("massage",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/queryBan")
    public @ResponseBody Banner queryBan(String b_id){
        Banner banner=menuService.queryBan(b_id);
        return banner;
    }
}
