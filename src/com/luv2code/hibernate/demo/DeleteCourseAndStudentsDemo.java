package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;
import com.luv2code.hibernate.entity.Student;

public class DeleteCourseAndStudentsDemo {

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
			
			// delete course
//			int courseId = 10;
//			Course theCourse = session.get(Course.class, courseId);
//			
//			System.out.println("Student is: " + theCourse);
//			System.out.println("Student Courses are: " + theCourse.getStudents());
//			
//			// delete course
//			System.out.println("Deleting the course");
//			session.delete(theCourse);
			
			// delete student
			int studentId = 2;
			Student thestudent = session.get(Student.class, studentId);
			
			System.out.println("Student is: " + thestudent);
			System.out.println("Student Courses are: " + thestudent.getCourses());
			
			// delete course
			System.out.println("Deleting the course");
			session.delete(thestudent);
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
