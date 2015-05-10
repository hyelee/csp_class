package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		// String check = req.getParameter("check");
		// int check = 0;
		boolean success = true;
		MyPersistenceManger.getManager();
		Query qry = MyPersistenceManger.getManager()
				.newQuery(UserAccount.class);
		List<UserAccount> userAccount = (List<UserAccount>) qry.execute();
		for (UserAccount a : userAccount) {
			if (a.getUserID().equals(id)) {
				resp.getWriter().println("<html>");

				resp.getWriter().println("<script>");
				resp.getWriter().println("alert('have same name, return!!!');");
				resp.getWriter().println("</script>");
				success = false;
				resp.getWriter().println("<body>");
				resp.getWriter().println("</body>");
				resp.getWriter().println("</html>");

			}

			else {

				success = true;

			}
		}

		if (success) {

			UserAccount ua = new UserAccount(id, password, name);

			MyPersistenceManger.getManager().makePersistent(ua);
			resp.sendRedirect("login.html");
		} else if (!success) {
			resp.sendRedirect("signup.html");
		}

	}
}
