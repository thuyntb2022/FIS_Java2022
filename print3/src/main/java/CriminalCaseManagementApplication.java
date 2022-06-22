

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.CriminalCaseService;

@SpringBootApplication
public class CriminalCaseManagementApplication {
    private static final Logger log = LoggerFactory.getLogger(CriminalCaseManagementApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CriminalCaseManagementApplication.class,args);
    }


    @Autowired
    private CriminalCaseService orderService;
    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Welcome to spring application. Pls write test method in here to run for testing only");
                log.info("Total order with wating status : ");
            }
        };
    }
}
