package by.home.spring.service;

import by.home.spring.entity.StudentEntity;
import by.home.spring.repository.StudentEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentServiceImplTestConfig.class})
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentEntityRepository studentRepository;

    @Test
    public void getOneByFio () throws Exception{
        StudentEntity testStudent = new StudentEntity("SomeFio", 44, 42);
        when(studentRepository.findByFio(testStudent.getFio())).thenReturn(testStudent);

        StudentEntity found = studentService.findByFio(testStudent.getFio());
        assertNotNull(found);
    }
}
