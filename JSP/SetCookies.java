import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetCookies extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		for(int i = 0; i < 3; i++)
		{
			//Default maxAge is -1, indicating cookie
			//applies only to current browsing session.
			Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
			resp.addCookie(cookie);
			cookie = new Cookie("Persistent-Cookie" + i, "Cookie-Value-S" + i);
			//Cookie is valid for an hour, regardless of whether
			//user quits browser, reboots computer, or whatever.
			cookie.setMaxAge(3600);
			resp.addCookie(cookie);
		}
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter out = resp.getWriter();
		String title = "Setting cookies";
		out.println("<html><head><title>设置Cookie</title></head>"
				+ "<body bgcolor=\"#fdf536\">\n" + "<h1 align=\"center\">"
				+ title + "</h1>\n"
				+ "There are six cookies associated with this page.\n"
				+ "To see them, visit the\n" + "<a href=\"ShowCookies\">\n"
				+ "<code>ShowCookies</code>servlet</a>.\n" + "<p>\n"
				+ "current seesion, while three are persistent.\n"
				+ "Quit the browser, restart, and return to the\n"
				+ "<code>ShowCookies</code> servlet to verify that\n"
				+ "the three long-lived ones persist across sessions.\n"
				+ "</body>"
				+ "</html>");
	}
	
}
