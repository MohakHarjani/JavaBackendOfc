package vw.nama.springcontainer.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import vw.nama.springcontainer.di.model.Dept;
import vw.nama.springcontainer.di.model.Emp;



//@SpringBootApplication

@PropertySource("application.properties")
@Component
public class Springbootdemo1Application //implements CommandLineRunner 
{
	
	public static void main(String[] args) {
		 var ctx = new AnnotationConfigApplicationContext();
	        ctx.scan("vw.nama.springcontainer.di");
	        ctx.refresh();
	        
	        Dept d1 = (Dept)ctx.getBean("dep");
	        Dept d2 = (Dept)ctx.getBean("dep");
	        System.out.println(d1 == d2); //default singleton
		
		Emp emp = (Emp) ctx.getBean("emp2");
		System.out.println(emp.getEmpid());
		System.out.println(emp.calcAnnSal());
		System.out.println(emp);
		
		 Dept d = emp.getDept();
		System.out.println(d.getDeptid());
		System.out.println(ctx.containsBean("dep2"));
		System.out.println(ctx.containsBean("emp2"));
				
		d = (Dept) ctx.getBean("dep2");
		System.out.println(d.getDeptid());
		System.out.println(d.getLocation());
		
		ctx.close();
		
	}

	
	
}
