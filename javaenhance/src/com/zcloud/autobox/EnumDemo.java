package com.zcloud.autobox;


/*
//��һ������ģ��һ��ö������
class WeekDay
{
	public final static WeekDay MONDAY = new WeekDay();
	public final static WeekDay TUESDAY = new WeekDay();
	public final static WeekDay WEDNESDAY = new WeekDay();
	public final static WeekDay TURSDAY = new WeekDay();
	public final static WeekDay FRIDAY = new WeekDay();
	public final static WeekDay SATURDAY = new WeekDay();
	public static final WeekDay SUNDAY = new WeekDay();
	
	public WeekDay nextDay()
	{
		if(this == MONDAY)
		{
			return TUESDAY;
		}
		else if(this == TUESDAY)
		{
			return WEDNESDAY;
		}
		else if(this == WEDNESDAY)
		{
			return TURSDAY;
		}
		else if(this == TURSDAY)
		{
			return FRIDAY;
		}
		else if(this == FRIDAY)
		{
			return SATURDAY;
		}
		else
		{
			return SUNDAY;
		}
	}
	
}

*/

//ö����--�ɿ���Դ������д�Ƿ�ֵ
//ÿһ��Ԫ���൱�ڸ����һ��ʵ��
enum WeekDay
{
	MONDAY, TUESDAY, WEDNESDAY, TURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumDemo 
{

	public static void main(String[] args) 
	{
		System.out.println(WeekDay.MONDAY.name());
		System.out.println(WeekDay.TUESDAY.toString());
	}

}

//ö��ӵ�з���
//ö��ӵ�й��췽��
//ö��ӵ�г��󷽷�
enum TrafficLamp
{
	RED(200)
	{
		public TrafficLamp nextLamp()
		{
			return GREEN;
		}
	},
	GREEN(100)
	{
		public TrafficLamp nextLamp()
		{
			return YELLOW;
		}
	}, 
	YELLOW(300)
	{
		public TrafficLamp nextLamp()
		{
			return RED;
		}
	};
	
	public abstract TrafficLamp nextLamp();
	
	
	int time;
	private TrafficLamp(int time)
	{
		this.time = time;
	}
	
}