package by.home.spring.controller;

import by.home.spring.service.StudentService;
import by.home.spring.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.mock;

@Configuration
public class StudentControllerTestConfig {

    @Bean
    public MessageSource messageSource() {
        return mock(MessageSource.class);
    }

    @Bean
    public StudentService studentService() {
        return mock(StudentService.class);
    }

    @Bean
    public EntityManager entityManager() {
        return mock(EntityManager.class);
    }

    @Bean
    public StudentController studentController() {
        return new StudentController();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return mock(ObjectMapper.class);
    }

    @Bean
    public TeacherService teacherService(){
        return mock(TeacherService.class);
    }
}
