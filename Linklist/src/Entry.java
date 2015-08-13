import edu.utility.Linklist;


public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Linklist objLink=new Linklist();
		objLink.add("First");
		objLink.add("Second");
		objLink.add("Third");
		objLink.add("Fourth");
		
		objLink.delete(3);//delete last element
		objLink.delete(0);//delete first element
		objLink.delete(6);//out of bound index
		
		String data=(String)objLink.getFirst();
		
		while(data!=null)
		{
			System.out.println(data);
			data=(String)objLink.getNext();			
			
		}
	}

}
