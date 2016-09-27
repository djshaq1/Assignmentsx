package org.ssa.createmajor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.entity.Major;


public class MajorList {
	static public void ListMajors(){
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session=factory.getCurrentSession();
	try{
		session.beginTransaction();
		List<Major> major=session.createQuery("from Major").list();
		
		//display major
		display(major);
		System.out.println("Records printed out");
		
		List<Major>major1=session.createQuery("from Major m where m.description='Sports Management'").list();
		System.out.println("Single Record");
		display(major1);
		
		session.getTransaction().commit();
				
	
}catch(Exception ex){ ex.printStackTrace();}
finally{
	factory.close();
}
}
	private static void display(List<Major> majors) {
		  for(Major maj: majors)
		   System.out.println(maj);
	}

}



