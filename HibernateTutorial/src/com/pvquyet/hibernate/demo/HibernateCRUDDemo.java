package com.pvquyet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pvquyet.hibernate.demo.entity.Student;

public class HibernateCRUDDemo {
	
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
			System.out.println("Create student...");
			Student temStudent = new Student("Thanh", "Nguyen", "Thanh@gmail.com");
			Student temStudent2 = new Student("Lan", "Nguyen", "Lan@gmail.com");
			Student temStudent3 = new Student("Hanh", "Pham", "Hanh@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object 
//			System.out.println("Save student...");
//			session.save(temStudent);
//			session.save(temStudent2);
//			session.save(temStudent3);
			
			
			  // read a student with id 
//			  int studentId = temStudent3.getId(); 
//			  Student readStudent = session.get(Student.class, studentId);
//			  System.out.println("Student with id :" + studentId + " = " + readStudent);
			 
			// query student 
			
//			List<Student> theStudents = session.createQuery("from Student s where "
//															+ "s.email like  '%@gmail.com'")
//												.getResultList();
//			
			// display student
//			for (Student student : theStudents) {
//				System.out.println(student);
//			}
			
			// update student
//			Student studentUpdate = session.get(Student.class, 1);
//			System.out.println("Updating student...");
//			studentUpdate.setEmail("quyetphung94@gmail.com");
			
			// update all email for student
//			session.createQuery("update Student set email = 'quyet.phung@gmail.com'").executeUpdate();
			
			// delete the student
			System.out.println("get the Student with id: 6");
			Student deleteStudent = session.get(Student.class, 6);
			System.out.println("Delete the Student: " +deleteStudent);
			session.delete(deleteStudent);
			
//			System.out.println("Delete the Student with id: 2");
//			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
