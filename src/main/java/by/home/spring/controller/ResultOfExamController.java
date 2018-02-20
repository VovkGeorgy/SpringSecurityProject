package by.home.spring.controller;

import by.home.spring.entity.ResultOfExamEntity;
import by.home.spring.service.ExamService;
import by.home.spring.service.ResultOfExamService;
import by.home.spring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultOfExamController {

    @Autowired
    ResultOfExamService resultOfExamService;

    @Autowired
    ExamService examService;

    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(ResultOfExamController.class);

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String addEntity(int examId, int studentId, boolean passing) {
        ResultOfExamEntity resultOfExam = new ResultOfExamEntity();
        logger.debug("Create new object ResultOfExamEntity", resultOfExam);
        resultOfExam.setExam(examService.getOne(examId));
        resultOfExam.setStudent(studentService.getOne(studentId));
        resultOfExam.setPassing(passing);
        resultOfExamService.saveAndFlush(resultOfExam);
        logger.debug("Object successfully saved", resultOfExam);
        return "Result of exam successfully added" + resultOfExam;
    }

    @RequestMapping(value = "/getAllResultsOfExam", method = RequestMethod.GET)
    public List<ResultOfExamEntity> getAllResultsOfExam(ModelMap model) {
        return resultOfExamService.findAll();
    }

    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateCarEntity(boolean passing, int pk, ModelMap model) {
        resultOfExamService.updateResultOfCurrentExam(passing, pk);
        return "Result of current exam are updated!";
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteCarEntity(boolean passing) {
        return "Entity - " + resultOfExamService.deleteByPassing(passing) + "was deleted";

    }
}
