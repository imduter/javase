//ExpressDemo1.java

public class ExpressDemo
{
	public static void main(String args[])
	{
		// ����ʶ������ʽ--�ַ�ƥ��
		// p("abc"matches("..."));
		// \d----digit[0,9]
		// p("a8729a".replaceAll("\\d", "-"));
		// �ַ�����Ҫƥ��ģʽ
		// ƥ��һ������3����ĸ,����ĸ����[a-z]�е�
		// Pattern p = Pattern.compile("[a-z]{3}");
		// ƥ����---ƥ����������m��
		// Matcher m = p.matcher("fgh");
		// p(m.matches());
		// p("fgha".matches("[a-z]{3}"));
		
		//������ʶ . * + ?
		//.һ���ַ�
		//*0������
		//+һ������
		//��һ����0��
		p("a".matches("."));
		p("aa".matches("aa"));
		//�㳤��ƥ��
		
		p("".matches("a?"));
		//^����abc
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