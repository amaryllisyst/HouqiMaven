package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
    public Admin queryAdmin(Admin admin);
    public void upd(Admin admin);
}
