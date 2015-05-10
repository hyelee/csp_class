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
				"<td>" + "이름: " + m.getName() + "<br></td>" + "<td>" + "학번 : "
						+ m.getHak() + "<br></td>" + "<td>" + "전화번호 : "
						+ m.getNum() + "<br></td>" + "<td>" + "이메일 : "
						+ m.getEmail() + "<br></td>" + "<td>" + "카카오톡ID: "
						+ m.getKakao() + "<br></td>" + "<td>" + "팀장여부 : "
						+ m.getLeader() + "<br></td>" + "<td>" + "GitHubID : "
						+ m.getGitid() + "<br></td>");
		resp.getWriter().println("위의 정보가 삭제되었습니다.");
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"목록\"</td></tr>");
		resp.getWriter().println("</form>");
		resp.getWriter().println(
				"<form method=\"post\"action=\"/index.html\">");
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"메인\"</td></tr>");
		resp.getWriter().println("</form>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}