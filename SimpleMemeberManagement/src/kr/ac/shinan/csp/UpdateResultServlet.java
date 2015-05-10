package kr.ac.shinan.csp;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateResultServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/plain");

		req.setCharacterEncoding("EUC-KR");
		String Name = req.getParameter("name");
		String Hak = req.getParameter("hak");
		String Num = req.getParameter("num");
		String Email = req.getParameter("email");
		String Kakao = req.getParameter("kakao");

		Long key = Long.parseLong(req.getParameter("key"));

		String Leader;
		if (req.getParameter("leader") != null)
			Leader = "Leader";

		else
		
			Leader = "Member";
		String GitID = req.getParameter("gitid");

		TeamMember newMember = new TeamMember(Name, Hak, Num, Email, Kakao,
				Leader, GitID);
	//	PersistenceManager pm = MyPersistenceManger.getManager();
		
		TeamMember original = MemberManager.getMember(key);
		 MemberManager.updateMember(newMember, original);
		 MemberManager.updateMember2(newMember, key);
	/*	original.setName(Name);
		original.setHak(Hak);
		original.setNum(Num);
		original.setEmail(Email);
		original.setKakao(Kakao);
		original.setLeader(Leader);
		original.setGitid(GitID);
	pm.close();
	*/
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("이름: " + original.getName() + "<br>");
		resp.getWriter().println("학번: " + original.getHak() + "<br>");
		resp.getWriter().println("전화번호: " + original.getNum() + "<br>");
		resp.getWriter().println("메일주소: " + original.getEmail() + "<br>");
		resp.getWriter().println("카톡ID: " + original.getKakao() + "<br>");
		resp.getWriter().println("팀장여부: " + original.getLeader() + "<br>");
		resp.getWriter().println("GitHubID: " + original.getGitid() + "<br>");
		resp.getWriter().println("정보가 수정되었습니다.!!22 " + "<br>");
		
		
		resp.getWriter().println(
				"<td><a href=\"index.html\" target=\"_blank\"> 처음으로 </a></td>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}