package org.ssa.createmajor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.entity.Major;



public class CreateMajor {
	public static void MajorCreation(){
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session=factory.getCurrentSession();
	
	
	try{
		Major maj1= new Major("Film/Video", 1000);
		Major maj2= new Major("Graphic Design", 1000);
		Major maj3= new Major("African American Studies", 950);
		Major maj4= new Major("Sports Management", 850);
		Major maj= new Major("Software Development", 1600);
		//begin transaction
		session.beginTransaction();
		
		
		session.save(maj);session.save(maj1);session.save(maj2);session.save(maj3);session.save(maj4);
		System.out.println("New Record" + maj);
		session.getTransaction().commit();
		System.out.println("New Major Created");
		
	}catch(Exception ex){ ex.printStackTrace();}
	finally{
		factory.close();
	}
}
}



