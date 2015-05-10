package kr.ac.shinan.csp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//welcome 으로 시작하는부분
	//쿠키에서 uuid가있는지확인후 없으면 login.html 
	//있으면 바로 index로 간다.
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/plain");
	resp.getWriter().println("entryservlet입니다.");
	}
}
