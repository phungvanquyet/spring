package com.pvquyet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pvquyet.hibernate.demo.entity.Instructor;
import com.pvquyet.hibernate.demo.entity.InstructorDetail;

public class CRUDDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {					
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("temIntructorDetail: " + tempInstructorDetail);
			// print the instructor 
			System.out.println("temIntructor: " + tempInstructorDetail.getInstructor());
			
			// remove the associated object reference
			// break bi-direction link 
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// delete instructor detail
			session.delete(tempInstructorDetail); // delete both instructor detail and instrucor
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
