package com.hadwinling.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hadwinling.entity.Admin;
import com.hadwinling.service.AdminService;
import com.hadwinling.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private AdminService adminService=new AdminServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登录功能
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		//jdbc 数据库查询
		Admin admin=adminService.login(username, pwd);
		HttpSession session=request.getSession();
		if(admin!=null) {
			//登录成功
			//保存当前用户信息
			session.setAttribute("currAdmin", admin);
			//相对路径
			//查询所有书籍
			response.sendRedirect("book/findAll");
			
		}else {
			//重新登录  
			response.sendRedirect("login.jsp?info=1");//相当于  url地址直接访问
		}
	}

}
