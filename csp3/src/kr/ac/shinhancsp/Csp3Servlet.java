package kr.ac.shinhancsp;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Csp3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.setBufferSize(30);
		resp.getWriter().println("¹Ý°©½À´Ï´Ù.");
	}
}
