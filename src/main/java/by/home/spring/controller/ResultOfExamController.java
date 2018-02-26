package by.home.spring.controller;

import by.home.spring.entity.ResultOfExamEntity;
import by.home.spring.service.ExamService;
import by.home.spring.service.ResultOfExamService;
import by.home.spring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/result")
public class ResultOfExamController {

    @Autowired
    ResultOfExamService resultOfExamService;

    @Autowired
    ExamService examService;

    @Autowired
    StudentService studentService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(ResultOfExamController.class);

    /**
     * Method add ResultOfExam entity with @params
     * @param examId - exam ID
     * @param studentId - student ID
     * @param passing - pass or not (true/false)
     * @return - message
     */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String addEntity(int examId, int studentId, boolean passing) {
        ResultOfExamEntity resultOfExam = new ResultOfExamEntity();
        resultOfExam.setExam(examService.getOne(examId));
        resultOfExam.setStudent(studentService.getOne(studentId));
        resultOfExam.setPassing(passing);
        resultOfExamService.saveAndFlush(resultOfExam);
        logger.info(messageSource.getMessage("object.create.ok", new Object[]{resultOfExam}, Locale.getDefault()));
        return messageSource.getMessage("object.create.ok", new Object[]{resultOfExam}, Locale.getDefault());
    }

    /**
     * Method return all ResultOfExam entity from dataBase to view page at JSON format
     * @param model - model
     * @return List<ResultOfExamEntity>
     */
    @RequestMapping(value = "/getAllResultsOfExam", method = RequestMethod.GET)
    public List<ResultOfExamEntity> getAllResultsOfExam(ModelMap model) {
        return resultOfExamService.findAll();
    }

    /**
     * Method select ResultOfExam entity by the input PK, and update it passing
     * @param passing - true or false
     * @param pk - pk of result
     * @param model - model
     * @return - message
     */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updatResultOfExamEntity(boolean passing, int pk, ModelMap model) {
        resultOfExamService.updateResultOfCurrentExam(passing, pk);
        logger.info(messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault()));
        return messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault());
    }

    /**
     * Method delete ResultOfExam Entity by passing
     * @param passing - pass or not (true/false)
     * @return - message
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteResultOfExamEntity(boolean passing) {
        return "Entity - " + resultOfExamService.deleteByPassing(passing) + "was deleted";

    }
}
