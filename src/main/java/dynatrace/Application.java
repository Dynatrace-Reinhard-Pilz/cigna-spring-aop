package dynatrace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	Controller controller = ctx.getBean(Controller.class);
        	controller.execute();
        };
    }
    
    @Bean
    public Driver createDriver() {
    	return new Driver();
    }
    
    @Bean
    public DBContext createDBContext() {
    	return new DBContext();
    }

    @Bean
    public TransactionAspect createTransactionAspect() {
    	return new TransactionAspect();
    }

}