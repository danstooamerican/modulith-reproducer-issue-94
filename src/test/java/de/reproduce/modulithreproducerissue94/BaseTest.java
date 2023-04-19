package de.reproduce.modulithreproducerissue94;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class BaseTest {
    protected static MySQLContainer<?> database = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("reproducer")
            .withUsername("root")
            .withPassword("test")
            .withEnv("MYSQL_ROOT_PASSWORD", "test")
            .withReuse(true);

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
        registry.add("spring.datasource.driver-class-name", database::getDriverClassName);
    }
}
