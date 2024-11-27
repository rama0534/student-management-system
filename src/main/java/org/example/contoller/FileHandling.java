package org.example.contoller;

import org.example.Grade;
import org.example.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileHandling {
    private static final Logger logger = Logger.getLogger(FileHandling.class.getName());
    private final String basePath = "src/main/resources/";


    public void saveToFile(ArrayList<Student> list, String fileName) {
        System.out.println("Saving to file " + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(basePath + fileName))) {
            for (Student item : list) {
                writer.write(String.valueOf(item));
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            logger.warning("File not found: " + basePath + fileName);
        } catch (IOException e) {
            logger.severe("Error reading file: " + e.getMessage());
        }
    }

    public ArrayList<Student> readFromFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(basePath+fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    Grade grade = Grade.valueOf(parts[3]);
                    students.add(new Student(id, name, age, grade));
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in the file.");
        }
        return students;
    }
}
