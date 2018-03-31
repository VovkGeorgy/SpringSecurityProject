package by.home.spring.service;

import by.home.spring.repository.StudentEntityRepository;
import by.home.spring.service.impl.StudentServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.mock;

@Configuration
public class StudentServiceImplTestConfig {

    @Bean
    public MessageSource messageSource(){
        return mock(MessageSource.class);
    }

    @Bean
    public StudentEntityRepository studentEntityRepository(){
        return mock(StudentEntityRepository.class);
    }

    @Bean
    public StudentService studentService(){
        return (StudentService) new StudentServiceImpl();
    }

    @Bean
    public EntityManager entityManager(){
        return mock(EntityManager.class);
    }
}
