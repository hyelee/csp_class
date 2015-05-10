package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RetrieveTeamMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String reader;
		HttpSession session= req.getSession();
		List<TeamMember> memberList = MemberManager.getAllMembers();
		String sid = (String) session.getAttribute("sid");
		
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");
		resp.getWriter().println("welcome !!  "+sid+"¥‘");
		resp.getWriter().println("<head><style>");
		resp.getWriter().println(
				"table,th,td{  border: 1px solid black\n;"
						+ "border-collapse: collapse \n;}"
						+ "th,th{padding=15px\n;}");
		resp.getWriter().println("</head></style>");
		resp.getWriter().println("<html><body>");
		resp.getWriter().println("<table style=\"width:100\">");

		resp.getWriter()
				.println(
						"<tr><th>Name</td><th>Hak</td><th>Num</td><th>Email</td><th>Kakao</td><th>Leader</td><th>GitID</td><th>Delete</td></tr>");

		for (TeamMember tm : memberList) {

			resp.getWriter().println("<tr>");

			resp.getWriter().println(
					"<td>" + "<a href = '/ReadMemberServlet?name="
							+ tm.getName() + "'>" + tm.getName() + "</a>"
							+ "</td>" + "<td>" + tm.getHak() + "</td>" + "<td>"
							+ tm.getNum() + "</td>" + "<td>" + tm.getEmail()
							+ "</td>" + "<td>" + tm.getKakao() + "</td>"
							+ "<td>" + tm.getLeader() + "</td>" + "<td>"
							+ tm.getGitid() + "</td>");
			resp.getWriter().println(
					"<td>" + "<a href = '/DeleteResultServlet?key="
							+ tm.getKey() + "'>" + "ªË¡¶ " + "</a>" + "</td>");
			resp.getWriter().println("</tr>");
		}

		resp.getWriter().println("</table>");
		resp.getWriter().println("</html></body>");

	}
}
