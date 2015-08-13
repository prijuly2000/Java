package sun.krd.polling;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Global implements ServletContextListener {
	ServletContext ctx;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		ctx=e.getServletContext();
		ctx.setAttribute("yes", 0);
		ctx.setAttribute("no", 0);
		ctx.setAttribute("cantsay", 0);
		//ctx.setAttribute("total", 0);
		System.out.println("contextInitialized...");
	}

}
