package com.jsj.dao;

import com.jsj.entity.Admin;

public interface AdminDao {

    Admin getAdminByPassword(String username,String password) throws Exception;
}
