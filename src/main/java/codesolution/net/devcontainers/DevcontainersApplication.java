package codesolution.net.devcontainers;

import codesolution.net.devcontainers.model.DevcontainerInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevcontainersApplication {

    public static void main(String[] args) {
        if ("local".equals(System.getProperty("ENV"))) {
            DevcontainerInitializer.getProperties().forEach((k, v) -> System.setProperty(k, String.valueOf(v)));
        }
        SpringApplication.run(DevcontainersApplication.class, args);
    }
}
