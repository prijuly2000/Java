import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;


public class SecondApplet extends Applet
{
	AudioClip audio;
	
	@Override
	public void init()
	{
		try
		{
			
			AppletContext context=getAppletContext();
			String audioFile=getParameter("fileName");
			URL audioURL=new URL(getCodeBase()+audioFile);
			audio=context.getAudioClip(audioURL);
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start()
	{
		
		
		audio.loop();
	}

	@Override
	public void stop()
	{
		System.out.println("audio stoped");
		audio.stop();
	}

	@Override
	public void destroy()
	{
		audio=null;
	}
	
}
