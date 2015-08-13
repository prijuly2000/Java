
public abstract   class Base
{
	
	public Base()
	{		
		System.out.println("Base Class Default Constructor");
	}
	
	public Base(int data)
	{
		this();
		System.out.println("Base Class Parameterized Constructor");
	
	}
	
//	 public abstract void display();
////	{
////		System.out.println("Base Display Called");
////	}
	
	
	
	 public void display()
	 {
		System.out.println("Base Display Called");
	 }
	 public void displayName()
	 {
		 System.out.println("Neeraj-Pritz");
	 }
}
