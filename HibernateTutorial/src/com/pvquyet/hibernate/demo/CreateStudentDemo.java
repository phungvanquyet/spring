package com.pvquyet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pvquyet.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			Student temStudent = new Student("Quyet", "Phung", "phungvanquyet94@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object 
			session.save(temStudent);
			
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
