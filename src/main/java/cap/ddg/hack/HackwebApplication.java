package cap.ddg.hack;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("cap.ddg.hack")
public class HackwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackwebApplication.class, args);
		//ApplicationContext context = new AnnotationConfigApplicationContext(RESTConfiguration.class);

	}


}
