import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description 首次配置servlet
 * @author zcloud
 * @date 2013年10月29日
 * HttpServlet被容器调用，当客户端请求URL地址时
 * Servlet被调用会调用它的service()方法，service会调用doPost(),doGet()
 */
public class HelloServlet extends HttpServlet
{
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doDelete(req, resp);
	}

	//只想获得http的头信息（时间等）可以与本地缓存比较，是否更新
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException
	{
		super.doOptions(arg0, arg1);
	}

	//form里提交的方式为Post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doPost(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doPut(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException
	{
		super.doTrace(arg0, arg1);
	}

	@Override
	protected long getLastModified(HttpServletRequest req)
	{
		return super.getLastModified(req);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException
	{
		super.service(arg0, arg1);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException
	{
		super.service(arg0, arg1);
	}

	//输入url地址为get方式
	@Override							//req一系列请求				resp服务器响应
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		System.out.println("doGet");
		Writer w = resp.getWriter();
		w.write("<a href='http://localhost:8090/'>tomcat home</a>");
	}

}
