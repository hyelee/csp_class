package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IDCheckServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");

		int check = 0;
		String id = req.getParameter("id");
		resp.getWriter().println(id);

		MyPersistenceManger.getManager();
		Query qry = MyPersistenceManger.getManager()
				.newQuery(UserAccount.class);
		List<UserAccount> userAccount = (List<UserAccount>) qry.execute();
	
		for (UserAccount a : userAccount) {
			//userAccount.get(i)
		if (a.getUserID().equals(id)) {

		check= 1;
		resp.getWriter().println("이미사용중입니다.");
			return;
		}
			else  {
				check=-1;	
			}			
		}

			 if(check==-1)
				resp.getWriter().println("사용가능합니다.");
	
	}
}