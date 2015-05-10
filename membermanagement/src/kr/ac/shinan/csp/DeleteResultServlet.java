package kr.ac.shinan.csp;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Transaction;

public class DeleteResultServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");

		Long key = Long.parseLong(req.getParameter("key"));

		PersistenceManager tm = MyPersistenceManger.getManager();
		TeamMember m = MemberManager.getMember(key);

		TeamMember t = tm.getObjectById(TeamMember.class, key);

		tm.deletePersistent(t);

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println(
				"<form method=\"Get\"action=\"/RetrieveTeamMember\">");
		resp.getWriter().println(
				"<td>" + "�̸�: " + m.getName() + "<br></td>" + "<td>" + "�й� : "
						+ m.getHak() + "<br></td>" + "<td>" + "��ȭ��ȣ : "
						+ m.getNum() + "<br></td>" + "<td>" + "�̸��� : "
						+ m.getEmail() + "<br></td>" + "<td>" + "īī����ID: "
						+ m.getKakao() + "<br></td>" + "<td>" + "���忩�� : "
						+ m.getLeader() + "<br></td>" + "<td>" + "GitHubID : "
						+ m.getGitid() + "<br></td>");
		resp.getWriter().println("���� ������ �����Ǿ����ϴ�.");
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"���\"</td></tr>");
		resp.getWriter().println("</form>");
		resp.getWriter().println(
				"<form method=\"post\"action=\"/index.html\">");
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"����\"</td></tr>");
		resp.getWriter().println("</form>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}