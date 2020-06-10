package com.niit.curdOperations;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf=cfg.buildSessionFactory();
    	Session session=sf.openSession();
    	Session session1=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	System.out.println("1. Insert records");
    	System.out.println("2. delete record");
        System.out.println("3. update record");
        System.out.println("4. select all records");
        System.out.println("5. Search");
        System.out.println("select any one option");
        Scanner s=new Scanner(System.in);
        int opt=s.nextInt();
        if(opt==1)
        {
        	Student obj=new Student();
        	obj.setSid("s103");
        	obj.setName("karthik");
        	obj.setMarks(90);
        	obj.setEmail("karthik@gmail.com");
        	obj.setCity("hyderabad");
        	session.save(obj);
        }
        else if(opt==2)
        {
        	Student st=new Student();
        	System.out.println("Enter student id to delete");
        	st.setSid(s.next());
        	session.delete(st);
        }
        else if(opt==3)
        {
        	Student st=new Student();
        	st.setName("harish varma");
        	st.setCity("bglr");
        	st.setEmail("harish12@gmail.com");
        	st.setMarks(75);
        	System.out.println("Enter student id to update");
        	st.setSid(s.next());
        	session.update(st);
        }
        else if(opt==4)
        {
        	ArrayList<Student> al=new ArrayList<Student>();
        	al=(ArrayList<Student>)session.createQuery("from Student").list();
        	for(Student s1:al)
        	{
        		System.out.println(s1.getSid()+" "+s1.getName()+" "+s1.getMarks()+" "+s1.getCity()+" "+s1.getEmail());
        	}
        }
        else if(opt==5)
        {
        	Student s2=new Student();
        	Student s3=new Student();
        	System.out.println("Enter student id to search");
        	String sid=s.next();
        	s2=(Student)session.get(Student.class, sid);
        	s2=(Student)session.get(Student.class, sid);
        	
        	s3=(Student)session1.get(Student.class, sid);
        	System.out.println(s2.toString());
        	System.out.println(s3.toString());
        	
        }
        tx.commit();
        session.close();
    }
}
