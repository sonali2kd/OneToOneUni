package com.greatlearning.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class Insert{
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Teacher tempTeacher = new Teacher("Harshit", "Choudhary", "HarshitChoudhary@greatlearning.com");
			
			TeacherDetails tempTeacherDetails = new TeacherDetails("Gurugram", "Reading Books");
			
			tempTeacher.setTeacherDetails(tempTeacherDetails);
			
			session.beginTransaction();
			
			session.save(tempTeacher);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}
	
}