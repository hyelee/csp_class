package kr.ac.shinan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SimpleMemberManagementServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// request
		req.setCharacterEncoding("EUC-KR");

		String key = req.getParameter("key");
		String Name = req.getParameter("name");
		String Hak = req.getParameter("hak");
		String Num = req.getParameter("num");
		String Email = req.getParameter("email");
		String Kakao = req.getParameter("kakao");
		String Leader;
		if (req.getParameter("leader") != null)
			Leader = "Leader";

		else

			Leader = "Member";
		String GitID = req.getParameter("gitid");

		// database insert

		TeamMember tm = new TeamMember(Name, Hak, Num, Email, Kakao, Leader,
				GitID);
		PersistenceManager pm = MyPersistenceManger.getManager();
		pm.makePersistent(tm);

		// response
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("�̸�: " + Name + "<br>");
		resp.getWriter().println("�й�: " + Hak + "<br>");
		resp.getWriter().println("��ȭ��ȣ: " + Num + "<br>");
		resp.getWriter().println("�����ּ�: " + Email + "<br>");
		resp.getWriter().println("ī��ID: " + Kakao + "<br>");
		resp.getWriter().println("���忩��: " + Leader + "<br>");
		resp.getWriter().println("GitHubID: " + GitID + "<br>");
		resp.getWriter().println("������ ����Ǿ����ϴ�. " + "<br>");
		resp.getWriter().println(
				"<td><a href=\"index.html\" target=\"_blank\"> ó������ </a></td>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}
}
