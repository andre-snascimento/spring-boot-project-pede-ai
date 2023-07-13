package net.snascimento.pedeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DBConfigProperties.class)
public class PedeAiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PedeAiApplication.class, args);
  }
}
