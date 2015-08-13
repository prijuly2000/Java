package sun.krd.polling;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HbUtil {

	public static SessionFactory factory;
	
	static{
		//this obj can read info from annotations
		
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		System.out.println("1");
		//read hibernate.cnf.xml file to get info abt db & entity classes
		
		cfg.configure();
		System.out.println("Configured");
		//create session factory using this conf.
		
		factory=cfg.buildSessionFactory();
		System.out.println("SessionFactory  created...");
	}
}
