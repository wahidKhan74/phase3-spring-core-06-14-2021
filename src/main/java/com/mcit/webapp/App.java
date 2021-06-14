package com.mcit.webapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mcit.webapp.bean.Employee;

/**
 * Main App file.
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
    	// Tightly coupled class 
//    	Employee employee =  new Employee();
//    	employee.setEmpId(101);
//    	employee.setName("John Doe");
//    	employee.setSalary(3435.435);
//    	employee.setDept("Finance");
//    	
//    	System.out.println(employee);
    	
    	// IOC : Inversion of control => DI  dependency Injection.
    	
    	// 1. Application Context container type
    	ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    	Employee emp1 = (Employee) context.getBean("emp1");
    	Employee emp2 =  context.getBean("emp2", Employee.class);
    	System.out.println(emp1);
    	System.out.println(emp2);
    	System.out.println("--------------------");
    	
    	// 2. Bean Factory Container
    	Resource resource = new ClassPathResource("appContext.xml");
    	BeanFactory factory = new XmlBeanFactory(resource);
    	
    	Employee employee1 = (Employee) factory.getBean("emp1");
    	System.out.println(employee1);
    	
    	Employee employee2 =factory.getBean("emp2",Employee.class);
    	System.out.println(employee2);
    }
}
