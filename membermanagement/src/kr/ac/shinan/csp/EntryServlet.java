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
//welcome 으로 시작하는부분
	//쿠키에서 uuid와 토큰의 uuid를 비교후 없으면 login.html 
	//uuid가 있으면  index로 넘어감 
	//있으면 바로 index로 간다.
	//잇을때 쿠키와 토큰의 uuid를 다시 random으로 받아와 set해줘야함
		
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
//	resp.getWriter().println("entryservlet입니다.");	
	}
}
