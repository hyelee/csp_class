package kr.ac.shinan.csp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//welcome ���� �����ϴºκ�
	//��Ű���� uuid���ִ���Ȯ���� ������ login.html 
	//������ �ٷ� index�� ����.
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/plain");
	resp.getWriter().println("entryservlet�Դϴ�.");
	}
}
