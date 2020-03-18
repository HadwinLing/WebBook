package com.hadwinling.dao;

import com.hadwinling.entity.Admin;

public interface AdminDAO {
	//登录功能
	Admin findAdmin(String username,String pwd);
}
