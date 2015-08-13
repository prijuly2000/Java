
public class Derived extends Base
{
	public Derived()
	{
		super(10);
		System.out.println("Derived class default constructor");
	}
	@Override
	public void display()
	{
		System.out.println("Derived Display Called");
	}
}
