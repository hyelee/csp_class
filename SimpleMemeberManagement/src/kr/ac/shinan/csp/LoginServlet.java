package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
String id = req.getParameter("id");
String pass = req.getParameter("password");
boolean success = false;
HttpSession session= req.getSession();
if(session.isNew())
	session.setMaxInactiveInterval(1000);
session.setAttribute("sid",id);

MyPersistenceManger.getManager();
Query qry = MyPersistenceManger.getManager().newQuery(UserAccount.class);

qry.setFilter("userID == idParam");
qry.declareParameters("String idParam");

List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);

if(userAccount.size()==0)
{
	success=false;
}

else if(userAccount.get(0).getPassword().equals(pass))
{
	success=true;
}

else
{
	success=false;
}

resp.getWriter().println("<html>");
resp.getWriter().println("<body>");

if(!success)
{
	resp.getWriter().println("Fail to login");
	resp.getWriter().println("<a href='login.html'>Login Again</a>");
}

if(success)
{
	if(req.getParameter("remeber")!=null){
	String uuid= UUID.randomUUID().toString();
	Cookie cookie = new Cookie("token",uuid);
	String date = null;
	UserLoginToken ult = new UserLoginToken(uuid,id,date);
	MyPersistenceManger.getManager().makePersistent(ult);
//쿠키 30일동안 저장하는 거
	
	
	}
	
	resp.sendRedirect("/index.html");
}

resp.getWriter().println("</body>");
resp.getWriter().println("</html>");
	}
}