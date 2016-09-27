package org.ssa.createmajor;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ssa.entity.Major;


public class UpdateMajor {
	public static void MajorUpdate(){
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session=factory.getCurrentSession();
	try{
		
//		int MajorId=9;
//		session.beginTransaction();
//		//query major
//		Major major=session.get(Major.class, MajorId);
//		majorstudent.setscore(1100);
//		
//		session.getTransaction().commit();
	//New code for updating new transaction
		
	//	session.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Major set req_sat=1200 where id=9 ").executeUpdate();
		System.out.println("Update Record");
		
		
		session.getTransaction().commit();
		
	}catch(Exception ex){ ex.printStackTrace();}
	finally{
		factory.close();
		}

}
}



