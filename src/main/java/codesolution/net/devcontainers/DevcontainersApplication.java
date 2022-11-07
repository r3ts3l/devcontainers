package codesolution.net.devcontainers;

import codesolution.net.devcontainers.model.DevcontainerInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevcontainersApplication {

    public static void main(String[] args) {
        if (System.getenv("ENV").equals("local")) {
            DevcontainerInitializer.getProperties().forEach((k, v) -> System.setProperty(k, String.valueOf(v)));
        }
        SpringApplication.run(DevcontainersApplication.class, args);
    }
}
