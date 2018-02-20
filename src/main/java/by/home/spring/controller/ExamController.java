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

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public String getCarEntity(String examType, String examTopic, int ticketsNumber) {
        ExamEntity exam = new ExamEntity();
        logger.debug("Create new object ExamEntity", exam);
        exam.setExamType(examType);
        exam.setExamTopic(examTopic);
        exam.setTicketNumber(ticketsNumber);
        examService.saveAndFlush(exam);
        logger.debug("Object successfully saved", exam);
        return "Exam successfully added" + exam;
    }

    @RequestMapping(value = "/getAllExams", method = RequestMethod.GET)
    public List<ExamEntity> getAllExams(ModelMap model) {
        return examService.findAll();
    }

    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateExamEntity(int ticketNumber, String examType, ModelMap model) {
        examService.updateExamEntityTichetNumber(ticketNumber, examType);
        return "Ticket number are updated!";
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteExamEntity(int examId) {
        return "Entity - " + examService.deleteExamEntityByExamId(examId) + "was deleted";
    }

    @RequestMapping(value = "/getNames", method = RequestMethod.GET)
    public String getNames(ModelMap model) {
        Locale ruLocale = new Locale("ru", "RU");
        Locale.setDefault(ruLocale);
        return messageSource.getMessage("customer.name", new Object[]{"25"}, Locale.getDefault());
    }
}