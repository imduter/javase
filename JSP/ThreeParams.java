import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ThreeParams extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println(req.getParameter("param1"));
		pw.print("<br>");
		pw.println(req.getParameter("param2"));
		pw.print("<br>");
		pw.println(req.getParameter("param3"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doPost(req, resp);
	}

}
