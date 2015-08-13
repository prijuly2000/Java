
public class Date
{
	private int day;
	private int month;
	private int year;
	
	{
		day=1;
		month=1;
		year=1;
	}
	
	public void displayDate()
	{
		System.out.println("Date : "+day+"/"+month+"/"+year);
	}
	
	private boolean leapYear(int year)
	{
		if(year%4==0)
			return true;
		return false;
	}
	
	public boolean validDate(int day,int month,int year)
	{
		if(month<1 || month>12)
			//this.month=1;
			return false;
		//else
			//this.month=month;
		
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
		{
			if(day>31 ||  day<1)
			//	this.day=1;
				return false;
			//else
				//this.day=day;
		}
		else if(month==4 || month==6 || month==9 || month==11 )
		{
			if(day>30 ||  day<1)
				//this.day=1;
				return false;
			//else
				//this.day=day;
		}
		else
		{
			if(leapYear(year) && month==2)
			{
				if(day<1 || day>29)
					//this.day=1;
					return false;
				//else
					//this.day=day;
			}
			else
			{
				if(day<1 || day>28)
					//this.day=1;
					return false;
				//else
					//this.day=day;			
			}
		
		}
		return true;
	}
	public void setDate(int day,int month,int year)
	{
		boolean valid;
		if(validDate(day, month, year))
		{
			this.day=day;
			this.month=month;
			this.year=year;
		}
		else
		{
			this.day=1;
			this.month=1;
			this.year=1;
		}	
				
	}
	
	public void addDays(int adDays)
	{
		
		if(day + adDays>30)
		{
			month++;
			day+=adDays-30;
		}
		else
			day+=adDays;
		
		
		
	}
}
