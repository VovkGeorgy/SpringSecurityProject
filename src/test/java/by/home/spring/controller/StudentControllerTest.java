package by.home.spring.controller;

import by.home.spring.entity.StudentEntity;
import by.home.spring.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentControllerTestConfig.class})
@WebAppConfiguration
public class StudentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentController studentController;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void getAllStudents() throws Exception {

        List<StudentEntity> students = new ArrayList<>();
        students.add(new StudentEntity("SomeFio1", 41, 141));
        students.add(new StudentEntity("SomeFio2", 42, 142));
        students.add(new StudentEntity("SomeFio3", 43, 143));
        when(studentService.findAll()).thenReturn(students);
        students.get(0).setStudentId(1);
        when(studentService.deleteByStudentId(1)).thenReturn("Stringgggg");

//        mockMvc.perform(post("/student/deleteEntity/{id}", 1)
//               .content(objectMapper.writeValueAsString(1))
// )
        mockMvc.perform(get("/student/getAllStudents")
//                .content(objectMapper.writeValueAsString(""))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(students.size()))
                .andExpect(jsonPath("$[0].fio").value(students.get(0).getFio()));

        verify(studentService, times(1)).findAll();
        verifyNoMoreInteractions(studentService);
    }
}
