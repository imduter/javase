//ExpressDemo1.java

public class ExpressDemo
{
	public static void main(String args[])
	{
		// 简单认识正则表达式--字符匹配
		// p("abc"matches("..."));
		// \d----digit[0,9]
		// p("a8729a".replaceAll("\\d", "-"));
		// 字符串需要匹配模式
		// 匹配一个具有3个字母,而字母是在[a-z]中的
		// Pattern p = Pattern.compile("[a-z]{3}");
		// 匹配器---匹配结果保存在m中
		// Matcher m = p.matcher("fgh");
		// p(m.matches());
		// p("fgha".matches("[a-z]{3}"));
		
		//初步认识 . * + ?
		//.一个字符
		//*0个或多个
		//+一个或多个
		//？一个或0个
		p("a".matches("."));
		p("aa".matches("aa"));
		//零长度匹配
		
		p("".matches("a?"));
		//^除了abc
		p("a".matches("[^abc]"));
		p("A".matches("[a-zA-Z]"));
		p("A".matches("[a-z]|[A-Z]"));
		p("A".matches("[a-z[A-Z]]"));
		p("R".matches("[A-Z&&[RFG]]"));;
	}
	public static void p(Object o)
	{
		System.out.println(o);
	}
}