import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionInfoServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		//get current session or create
		HttpSession mSession = req.getSession();
		//MIME type to return is HTML
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>SessionInfoServlet</title>");
		pw.println("<body>");
		pw.println("<h2>Session Info</h2>");
		pw.println("New Session: " + mSession.isNew());
		pw.println("<br> Sesssion ID:" + mSession.getId());
		pw.println("<br> Session Creation Time: " + mSession.getCreationTime());
		pw.println("<br> Session Last Accessed Time: " + mSession.getLastAccessedTime());
		pw.println("<h2>Request Info</h2>");
		pw.println("Session ID from Request: " + req.getSession().getId());
		pw.println("<br> Session ID via cookie: " + req.isRequestedSessionIdFromCookie());
		pw.println("<br> Session ID via rewritten URL: " + req.isRequestedSessionIdFromURL());
		pw.println("<br> Valid Session ID :" + req.isRequestedSessionIdValid());
		pw.println("<br> <a href=" + resp.encodeURL("SessionInfoServlet") +">refresh</a>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
