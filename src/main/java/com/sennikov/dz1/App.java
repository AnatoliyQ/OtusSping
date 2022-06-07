package com.sennikov.dz1;

import com.sennikov.dz1.service.QuestionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuestionReader service = context.getBean(QuestionReader.class);

        List<String> questionsList = service.getQuestions();

        questionsList.forEach(System.out::println);
        context.close();
    }
}