package com.sennikov.dz1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {

    private final String fileName;

    public QuestionReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getQuestions(){
        BufferedReader csvReader = null;
        File csvFile = new File(getClass().getClassLoader().getResource(fileName).getFile());
        try {
            csvReader = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> questions = new ArrayList<>(5);
        String row;
        while (true) {
            try {
                if ((row = csvReader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            questions.add(row.split(",")[0]);
        }

        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return questions;
    }
}
