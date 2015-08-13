
public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int choice=0,day,month,year,adDays,adMonths,adYears;
		String ch="Y";
		Date objDate=new Date();
		while(ch.equals("Y")||ch.equals("y"))
		{
			System.out.println("--Menu--");
			System.out.println("1.Set Date");
			System.out.println("2.Add days");
			System.out.println("3.Add months");
			System.out.println("4.Add years");
			System.out.println("5.Exit");
			System.out.println("Enter the choice:");
			choice=ConsoleInput.getInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter the day:");
				day=ConsoleInput.getInt();
				System.out.println("Enter the month:");
				month=ConsoleInput.getInt();
				System.out.println("Enter the years");
				year=ConsoleInput.getInt();
				objDate.setDate(day,month,year);
				objDate.displayDate();
				break;
			case 2:
				System.out.println("Enter the number of  days to add :");
				addDays=ConsoleInput.getInt();
				objDate.addDays(adDays);
				objDate.displayDate();
				break;
			case 3:
				//objDate.addMonths();
				break;
			case 4:
				//objDate.addYears();
				break;
				
			}
			
			System.out.println("Do you want to continue(y/n)?");
			ch=ConsoleInput.getString();
		}
		

	}

}
