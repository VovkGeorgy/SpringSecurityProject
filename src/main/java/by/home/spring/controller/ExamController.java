package by.home.spring.controller;

import by.home.spring.entity.ExamEntity;
import by.home.spring.service.ExamService;
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
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

    /**
     * Method add Exam entity with @params
     * @param examType - type of exam
     * @param examTopic - exam topic
     * @param ticketsNumber - exam tickets number
     * @return - message
     */
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String examType, String examTopic, int ticketsNumber) {
        ExamEntity exam = new ExamEntity();
        exam.setExamType(examType);
        exam.setExamTopic(examTopic);
        exam.setTicketNumber(ticketsNumber);
        examService.saveAndFlush(exam);
        logger.info(messageSource.getMessage("object.create.ok", new Object[]{exam}, Locale.getDefault()));
        return messageSource.getMessage("object.create.ok", new Object[]{exam}, Locale.getDefault());
    }

    /**
     * Method return all Exam entity from dataBase to view page at JSON format
     * @param model - model
     * @return List<ExamEntity>
     */
    @RequestMapping(value = "/getAllExams", method = RequestMethod.GET)
    public List<ExamEntity> getAllExams(ModelMap model) {
        return examService.findAll();
    }

    /**
     * Method select Exam entity by the input examType, and update it ticket Number
     * @param ticketNumber - needen ticket number
     * @param examType - current exam type
     * @param model - model
     * @return
     */
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateExamEntity(int ticketNumber, String examType, ModelMap model) {
        examService.updateExamEntityTichetNumber(ticketNumber, examType);
        logger.info(messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault()));
        return messageSource.getMessage("object.field.updating.ок", new Object[]{null}, Locale.getDefault());
    }

    /**
     * Method delete Exam Entity by examId
     * @param examId - exam ID in data base
     * @return - message
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteExamEntity(int examId) {
        return "Entity - " + examService.deleteExamEntityByExamId(examId) + "was deleted";
    }

}