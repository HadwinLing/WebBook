package com.hadwinling.service;

import com.hadwinling.entity.Admin;

public interface AdminService {
	//登录功能
	Admin login(String username,String pwd);
}

