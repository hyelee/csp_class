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
		
		resp.getWriter().println("�̸�: " + original.getName() + "<br>");
		resp.getWriter().println("�й�: " + original.getHak() + "<br>");
		resp.getWriter().println("��ȭ��ȣ: " + original.getNum() + "<br>");
		resp.getWriter().println("�����ּ�: " + original.getEmail() + "<br>");
		resp.getWriter().println("ī��ID: " + original.getKakao() + "<br>");
		resp.getWriter().println("���忩��: " + original.getLeader() + "<br>");
		resp.getWriter().println("GitHubID: " + original.getGitid() + "<br>");
		resp.getWriter().println("������ �����Ǿ����ϴ�.!!22 " + "<br>");
		
		
		resp.getWriter().println(
				"<td><a href=\"index.html\" target=\"_blank\"> ó������ </a></td>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}