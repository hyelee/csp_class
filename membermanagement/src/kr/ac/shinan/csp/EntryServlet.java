package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//welcome ���� �����ϴºκ�
	//��Ű���� uuid�� ��ū�� uuid�� ���� ������ login.html 
	//uuid�� ������  index�� �Ѿ 
	//������ �ٷ� index�� ����.
	//������ ��Ű�� ��ū�� uuid�� �ٽ� random���� �޾ƿ� set�������
		
		Cookie[] cookieList= req.getCookies();
		MyPersistenceManger.getManager();
		Query qry = MyPersistenceManger.getManager()
				.newQuery(UserLoginToken.class);    
		List<UserLoginToken> ult = (List<UserLoginToken>) qry.execute();
	String uuid= null;
	String nextuuid= UUID.randomUUID().toString();
	
	
	
	/*	for (UserLoginToken a : ult) {
		if(a.getToken()!=null){
			uuid= a.getToken();
			a.setToken(nextuuid);
		}
		}
		
		
		
		for(Cookie c: cookieList){
	//		if(c.getName().equals("token")){
			if(c.getValue().equals(uuid)){
				
				resp.sendRedirect("/index.html");
				c.setValue(nextuuid);
			}
			else{
				resp.sendRedirect("/login.html");
			}
		//	}
		//	else{
		//		resp.sendRedirect("/login.html");
		//	}
		}

	*/
	for (UserLoginToken a : ult) {
		if(a.getToken()!=null){
		for(Cookie c: cookieList){
			if(c.getName().equals("token")){
				if(c.getValue().equals(a.getToken())){
					a.setToken(nextuuid);
					c.setValue(nextuuid);
					resp.addCookie(c);
					resp.sendRedirect("/index.html");
				}
				else{
					resp.sendRedirect("/login.html");
				}
				
			}
	
		}
	}	
}
	resp.sendRedirect("/login.html");
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/plain");

	//	resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/plain");
//	resp.getWriter().println("entryservlet�Դϴ�.");	
	}
}
