package codesolution.net.devcontainers.model;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;


public abstract class DevcontainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:latest");

    public static Map<String, Object> getProperties() {
        Startables.deepStart(Stream.of(POSTGRES_SQL_CONTAINER)).join();

        return Map.of(
                "spring.datasource.url", POSTGRES_SQL_CONTAINER.getJdbcUrl(),
                "spring.datasource.username", POSTGRES_SQL_CONTAINER.getUsername(),
                "spring.datasource.password", POSTGRES_SQL_CONTAINER.getPassword()
        );
    }

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        var env = context.getEnvironment();
        env.getPropertySources().addFirst(new MapPropertySource("devcontainers", getProperties()));
    }
}
