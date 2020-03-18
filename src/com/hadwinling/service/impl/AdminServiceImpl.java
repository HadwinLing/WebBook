package com.hadwinling.service.impl;

import com.hadwinling.dao.AdminDAO;
import com.hadwinling.dao.impl.AdminDAOImpl;
import com.hadwinling.entity.Admin;
import com.hadwinling.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO=new AdminDAOImpl();
	/* (non-Javadoc)
	 * @see com.gem.demo.service.AdminService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin login(String username, String pwd) {
		// TODO Auto-generated method stub
		return adminDAO.findAdmin(username, pwd);
	}

}
