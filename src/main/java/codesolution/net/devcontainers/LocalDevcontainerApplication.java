package codesolution.net.devcontainers;


import codesolution.net.devcontainers.model.DevcontainerInitializer;

public class LocalDevcontainerApplication {

    public static void main(String[] args) {
        DevcontainerInitializer.getProperties().forEach((k, v) -> System.setProperty(k, String.valueOf(v)));
        DevcontainersApplication.main(args);
    }
}
