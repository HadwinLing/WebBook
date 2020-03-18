package com.hadwinling.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hadwinling.dao.AdminDAO;
import com.hadwinling.entity.Admin;
import com.hadwinling.util.JDBCTemplate;
import com.hadwinling.util.PreparedStatementCreator;
import com.hadwinling.util.ResultSetExtractor;

public class AdminDAOImpl implements AdminDAO{

	/* (non-Javadoc)
	 * @see com.gem.demo.dao.AdminDAO#findAdmin(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin findAdmin(String username, String pwd) {
		// TODO Auto-generated method stub
		return (Admin)JDBCTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement create(Connection conn) throws SQLException {
				String sql="select * from admin where username=? and password=?";
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, username);
				psmt.setString(2, pwd);
				return psmt;
			}
		}, new ResultSetExtractor() {
			
			@Override
			public Object extractor(ResultSet rs) throws SQLException {
				Admin admin=null;
				if(rs.next()) {
					int id=rs.getInt(1);
					 String username=rs.getString(2);
					 String pwd=rs.getString(3);
					 admin=new Admin(id, username, pwd);
				}
				return admin;
			}
		});
	}

}