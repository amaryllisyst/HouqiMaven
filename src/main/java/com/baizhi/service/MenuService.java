package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> queryAll();
    public List<Banner> queryBanner(Integer page,Integer rows);
    public Long findTotals();
    public void del(String b_id);
    public void insertBanner(Banner banner);
    public void update(Banner banner);
    public Banner queryBan(String b_id);
}
