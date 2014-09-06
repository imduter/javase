import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowCookies extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter pw = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies != null)
		{
			Cookie c = null;
			for(int i = 0; i < cookies.length; i++)
			{
				c = cookies[i];
				pw.println("name = " + c.getName() + ":" + "value=" + c.getValue());
			}
		}
	}

}
