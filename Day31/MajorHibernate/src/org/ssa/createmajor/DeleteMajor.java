package org.ssa.createmajor;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.ssa.entity.Major;


public class DeleteMajor {
	public static void MajorDeletion(){
			SessionFactory factory=new  Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Major.class)
					.buildSessionFactory();
			
			//create session
			Session session=factory.getCurrentSession();
			
			try{
				//
			//	int MajorId=7;
				session.beginTransaction();
				//query Major
			//	Major major=session.get(Major.class, MajorId);
			//	session.delete(major);
				//alternate way to delete data
				session.createQuery("delete Major where id=9").executeUpdate();
				System.out.println("Delete Major");
				//commiting the transaction
				session.getTransaction().commit();	
				
				
				//
				
			}finally{
				factory.close();
			}
		}
	}



