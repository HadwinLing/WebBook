package com.hadwinling.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hadwinling.entity.Book;
import com.hadwinling.service.BookService;
import com.hadwinling.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book/*")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService=new BookServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过url区分不同的用户请求
		String pathInfo=request.getPathInfo();
		HttpSession session=request.getSession();
		if("/findAll".equals(pathInfo)) {
			//查询所有书籍
			List<Book> books=bookService.findAllBooks();
			//保存session域中
			session.setAttribute("books",books);
			//转发到main.jsp
			//跳转到main.jsp
			//转发访问WEB-INF
			request.getRequestDispatcher("/WEB-INF/page/main.jsp").forward(request, response);
			
		}
		if("/del".equals(pathInfo)) {
			//获取要删除的书籍的id
			int id=Integer.parseInt(request.getParameter("id"));
			bookService.delBook(id);
			//重新查询  显示最新信息
			response.sendRedirect("findAll");
		}
		//
		if("/add".equals(pathInfo)) {
			//转发到addbook.jsp
			request.getRequestDispatcher("/WEB-INF/page/addbook.jsp").forward(request, response);
		}
		if("/doadd".equals(pathInfo)) {
			//获取输入的书籍信息
			String bno=request.getParameter("bno");
			String bname=request.getParameter("bname");
			String author=request.getParameter("author");
			double price=Double.parseDouble(request.getParameter("price"));
			String mark=request.getParameter("remark");
			
			Book book=new Book(0, bno, bname, author, price, mark);
			//添加到数据库中
			bookService.addBook(book);
			//重新查询
			response.sendRedirect("findAll");
		}
		if ("/update".equals(pathInfo)) {
			//转发到updatebook.jsp
			int id=Integer.parseInt(request.getParameter("id"));
			Book book =bookService.findBookById(id);
			//存储数据到request域中
			session.setAttribute("currBook", book);
			request.getRequestDispatcher("/WEB-INF/page/updatebook.jsp").forward(request, response);
		}
		if ("/doupdate".equals(pathInfo)) {
			//获取修改的书籍信息
			String bno = request.getParameter("bno");
			String bname=request.getParameter("bname");
			String author=request.getParameter("author");
			double price=Double.parseDouble(request.getParameter("price"));
			String mark=request.getParameter("mark");
			Book book=new Book(0, bno, bname, author, price, mark);
//			System.out.println(book);
			//修改到数据库中
			bookService.updateBook(book);
			//重新查询
			response.sendRedirect("findAll");
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
