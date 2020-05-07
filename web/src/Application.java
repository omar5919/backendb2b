
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.incloud.tgestiona.b2b.audit.AuditorAwareImpl;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan({ "com.incloud.tgestiona.b2b.services" })
@ComponentScan({"com.incloud.tgestiona"})
@EnableJpaRepositories("com.incloud.tgestiona.b2b.repository")
@EntityScan("com.incloud.tgestiona.b2b.model")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableScheduling

public class Application extends SpringBootServletInitializer {

    private static ConfigurableApplicationContext context;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
        log.info(String.format("\n\n    _____\\    _______\n" + "   /      \\  |      /\\\n" + "  /_______/  |_____/  \\\n"
                + " |   \\   /        /   /\n" + "  \\   \\         \\/   /\n" + "   \\  /          \\__/_\n"
                + "    \\/ ____    /\\\n" + "      /  \\    /  \\\n" + "     /\\   \\  /   /\n"
                + "       \\   \\/   /\n" + "        \\___\\__/\n\n:: Business 2 Business - Provisioner :: \n\n ", context));
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void perform() throws Exception {
        /// log.info(String.format("@Scheduled Iniciando -----> %s.", context));
    }

    @PostConstruct
    public void init() {
        // Setting Spring Boot Init
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(Application.class, args.getSourceArgs());
        });
        thread.setDaemon(false);
        thread.start();
    }

}