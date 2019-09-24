package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TitlesDao;

/**
 * Servlet implementation class GetTitlesListDistinctServlet
 */
@WebServlet("/titles/getTitlesListDistinct")
public class GetTitlesListDistinctServlet extends HttpServlet {
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		titlesDao = new TitlesDao(); //titlesDao 객체생성.
		
		List<String> list = titlesDao.selectTitlesListDistinct(); //titles테이블의 title중복값을 제거하고 출력하는 메소드를 불러와 list에 저장.
		
		request.setAttribute("list",list);	//list를 "list"에 저장하고 request로 받음
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesListDistinct.jsp").forward(request, response);
		///WEB-INF/views/titles/titlesListDistinct.jsp로 request, response를 포워딩.
	}

}
