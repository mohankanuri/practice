package com.edureka;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {
		// Object Construction done by developer		
		Employee eRef = new Employee();
		eRef.setEid(101);
		eRef.setEname("Anvesh");
		eRef.setEaddress("Cameroon Blvd");
		
		System.out.println("Employee Details:" +eRef);
		
		// Object Construction in Spring IoC way
		
		Resource resource = new ClassPathResource("employeebean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//Resource resource = new ClassPathResource("employeebean.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
		
		Employee e1 = (Employee) factory.getBean("emp1");
		Employee e2 = (Employee) factory.getBean("emp2", Employee.class);
		
		System.out.println("Employee1 Details: " +e1);
		System.out.println("Employee2 Details: " +e2);
		
	}

}
