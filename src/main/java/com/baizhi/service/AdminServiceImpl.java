package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryAdmin(Admin admin){
        Admin admin1=adminDao.queryAdmin(admin);
        return admin1;
    }

    @Override
    public void upd(Admin admin){
        adminDao.upd(admin);
    }

}
