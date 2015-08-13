import java.io.IOException;


public class ConsoleInput
{
	public static String getString()
	{
		try
		{
			byte []arrInput=new byte[50];
			int length=System.in.read(arrInput);
			byte []arrFinal=new byte[length-2];
			System.arraycopy(arrInput, 0, arrFinal, 0, length-2);
			String objString=new String(arrFinal);
			return objString;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int getInt()
	{
		String data =getString();
		return Integer.parseInt(data);
		
	}
	public static float getFloat()
	{
		String data=getString();
		return Float.parseFloat(data);
		
	}

}
