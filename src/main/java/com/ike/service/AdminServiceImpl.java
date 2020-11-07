package com.ike.service;

import com.ike.dao.AdminMapper;
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
}
