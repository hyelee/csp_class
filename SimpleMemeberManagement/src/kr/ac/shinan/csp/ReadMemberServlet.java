package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

public class ReadMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name = req.getParameter("name");

		List<TeamMember> namedMemberList = MemberManager.getMemberByName(name);
		TeamMember m = namedMemberList.get(0);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<hl>팀멤버수정</h1>");
		resp.getWriter().println("<table>");


		resp.getWriter().println(
				"<form method=\"post\"action=\"/UpdateResultServlet?key="
						+ m.getKey() + "\">");
		resp.getWriter().println(
				"<tr><td>" + "이름 : " + "</td><td>"
						+ "<input type = \"text\" name = \"name\" value= \" "
						+ m.getName() + "\"> </td></tr>");
		resp.getWriter().println(
				"<tr><td>" + "학번 : " + "</td><td>"
						+ "<input type = \"text\" name = \"hak\" value= \" "
						+ m.getHak() + "\" ></td></tr>");
		resp.getWriter().println(
				"<tr><td>" + "전화번호 : " + "</td><td>"
						+ "<input type = \"text\" name = \"num\" value= \" "
						+ m.getNum() + "\"> </td></tr>");
		resp.getWriter().println(
				"<tr><td>" + "이메일 : " + "</td><td>"
						+ "<input type = \"text\" name = \"email\" value= \" "
						+ m.getEmail() + "\"> </td></tr>");
		resp.getWriter().println(
				"<tr><td>" + "카카오톡ID : " + "</td><td>"
						+ "<input type = \"text\" name = \"kakao\" value= \" "
						+ m.getKakao() + "\"> </td></tr>");
		resp.getWriter()
				.println(
						"<tr><td>"
								+ "팀장여부 : "
								+ "</td><td>"
								+ "<input type = \"checkbox\" name = \"leader\" </td></tr>");
		resp.getWriter().println(
				"<tr><td>" + "GitHubID : " + "</td><td>"
						+ "<input type = \"text\" name = \"gitid\" value= \" "
						+ m.getGitid() + "\"> </td></tr>");
		
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"수정\"</td></tr>");
		

		resp.getWriter().println("</form>");
		resp.getWriter().println(
				"<form method=\"post\"action=\"/index.html\">");
		resp.getWriter().println(
				"<tr><td><input type =\"submit\" value=\"메인\"</td></tr>");
		resp.getWriter().println("</form>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	
	}

}
