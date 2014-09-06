import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description servlet只new一个
 * 生命全过程：加载->实例化-〉初始化-〉处理服务请求-〉退出服务
 * @author zcloud
 * @date 2014年2月16日
 */
public class TestLifeCycleServlet extends HttpServlet
{
	public TestLifeCycleServlet()
	{
		System.out.println("constructor");
	}
	
	//web-app退出时
	@Override
	public void destroy()
	{
		System.out.println("--->>destroy()");
	}
	
	@Override
	public void init()
	{
		System.out.println("--->>init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException
	{
		System.out.println("----->>doGet()");
	}
}
