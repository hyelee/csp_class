package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// �α׾ƿ� ó�� uuid ���� ����Ű���� ���ǻ���
		// login.html�� ���ư��� ��ư �����
		
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");
		PersistenceManager um= MyPersistenceManger.getManager();
		Query qry = MyPersistenceManger.getManager().newQuery(
				UserLoginToken.class);
		List<UserLoginToken> ult = (List<UserLoginToken>) qry.execute();
		Cookie[] cookieList = req.getCookies();
/*
		for (UserLoginToken a : ult) {
			for (Cookie c : cookieList) {
				if (c.getValue().equals(a.getToken())) {

					c.setValue(null);
					c.setMaxAge(0);
					resp.addCookie(c);
				
					a.setToken(null);
					a.setExpireDate(null);
				}
			}
		}
	//	for (UserLoginToken a : ult) {
	//		if(a.getToken()==null)
	//			um.deletePersistent(a);
				
	//	}
		
		HttpSession session = req.getSession();
		session.invalidate();
	//	resp.sendRedirect("login.html");
	}
}
*/
		String uuid=null;
		for (Cookie c : cookieList) {
		if(c.getName().equals("token")){
			uuid=c.getValue();
			c.setValue(null);
			c.setMaxAge(0);
			resp.addCookie(c);
			}
		}
		
		for (UserLoginToken a : ult) {
		if(a.getToken()!=null){
			a.setToken(null);
			a.setExpireDate(null);
			
		}
		}
		HttpSession session = req.getSession();
		session.invalidate();
	//	resp.getWriter().println("�α׾ƿ��ϼ̽��ϴ�.");
		resp.sendRedirect("login.html");
		
	}
	
}
		