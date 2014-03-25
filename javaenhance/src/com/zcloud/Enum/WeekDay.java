package com.zcloud.Enum;

//用java类模拟枚举

// public class WeekDay
// {
	// private WeekDay(){}
	
	// public static WeekDay MON = new WeekDay();
	// public static WeekDay SUN = new WeekDay();

	// public WeekDay nextDay()
	// {
		// if(this == MON)
		// {
			// return MON;
		// }
		// else
		// {
			// return MON;
		// }
	// }
	
	// public String toString()
	// {
		// if(this == MON)
		// {
			// return "MON";
		// }
		// else
		// {
			// return "SUN";
		// }
	// }	
// }

public abstract class WeekDay
{
	private WeekDay(){}
	public abstract WeekDay nextDay();
	
	public static final WeekDay MON = new WeekDay(){
		@Override
		public WeekDay nextDay()
		{
			return SUN;
		}
	};
	
	public static final WeekDay SUN = new WeekDay(){
		@Override
		public WeekDay nextDay()
		{
			return MON;
		}
	};

	public String toString()
	{
		if(this == MON)
		{
			return "MON";
		}
		else
		{
			return "SUN";
		}
	}	
}

