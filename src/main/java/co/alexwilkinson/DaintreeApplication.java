package co.alexwilkinson;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DaintreeApplication{
	
	public static void main(String[] args){
		SpringApplication.run(DaintreeApplication.class, args);
	}
	

	
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
//		
//		return args ->{
//			
//			System.out.println("Beans in Java Spring");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for(String beanName : beanNames){
//				System.out.println(beanName);
//			}
//		};
//		
//	}
	
	
}
