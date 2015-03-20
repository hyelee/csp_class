package kr.ac.shinhancsp;

import java.io.IOException;

import javax.servlet.http.*;

public class CurrentTime extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setBufferSize(20);
		
		resp.getWriter().println("¹Ý°©½À´Ï´Ù.");
	}

	}