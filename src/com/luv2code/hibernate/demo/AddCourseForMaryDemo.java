package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;
import com.luv2code.hibernate.entity.Student;

public class AddCourseForMaryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int studentId = 2;
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("Student is: " + theStudent);
			System.out.println("Student Courses are: " + theStudent.getCourses());
			
			Course tempCourse1 = new Course("Rubik's Cube - How to speed cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			Course tempCourse3 = new Course("Sony - Legend of Zelda");
			Course tempCourse4 = new Course("Sony - Super Mario World");
			
			// Associating the student with the courses
			System.out.println("Adding the student to the list of courses.");
			tempCourse1.addStudent(theStudent);
			tempCourse2.addStudent(theStudent);
			tempCourse3.addStudent(theStudent);
			tempCourse4.addStudent(theStudent);
			
			
			// Saving the courses
			System.out.println("Saving the courses.");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			session.save(tempCourse4);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
