package com.baizhi.test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminTest {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;

    @Test
    public void test1(){
        Admin admin=new Admin();
        admin.setA_id("1");
        admin.setA_password("123456");
        adminService.upd(admin);
    }

    @Test
    public void test2(){
        Admin admin=new Admin();
        admin.setA_username("xiaohei");
        admin.setA_password("123456");
        Admin admin1=adminService.queryAdmin(admin);
        System.out.print(admin1);
    }

}
