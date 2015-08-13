
public class Entry 
{
	public static void main(String[] args) 
	{
		String ch="y";
		int result=0,choice,num1=0,num2=0;
		float num3=0,num4=0,floatResult=0;
		Calculator objCalculator=new Calculator();
		do
		{
				
			System.out.println("---Menu---");
			System.out.println("1.Interger Addition");
			System.out.println("2.Integer Subtraction");
			System.out.println("3.Interger Multiplication");
			System.out.println("4.Integer Division");
			System.out.println("5.Float Addition");
			System.out.println("6.Float Subtraction");
			System.out.println("Enter the choice:");
			choice=ConsoleInput.getInt();
			if(choice>=1 && choice<=4)
			{
				System.out.println("Enter the first number");
				num1=ConsoleInput.getInt();
			
				System.out.println("Enter the second number");
				num2=ConsoleInput.getInt();
			}
			else
			{
				System.out.println("Enter the first number");
				num3=ConsoleInput.getFloat();
				
				System.out.println("Enter the second number");
				num4=ConsoleInput.getFloat();
			}
				
			switch (choice)
			{
			case 1:
				result=objCalculator.addInt(num1, num2);
				break;
			case 2:
				result=objCalculator.subtractInt(num1, num2);
				break;
			case 3:
				result=objCalculator.multiplicationInt(num1, num2);
				break;
			case 4:
				floatResult=objCalculator.divisionInt(num1, num2);
				break;
			case 5:
				floatResult=objCalculator.addFloat(num3, num4);
				break;
			case 6:
				floatResult=objCalculator.subtractFloat(num3, num4);
				break;
			default:
				System.out.println("Enter the correct choice");
						
			}		
			
			if(choice>=1 && choice<=3)
				System.out.println("Result is " +result);
			else
				System.out.println("float Result is "+floatResult);
				
			System.out.println("Do you want to continue(y/n)?");
			ch=ConsoleInput.getString();
				
		}while(ch.equals("Y") || ch.equals("y"));
		
				
	}

}
