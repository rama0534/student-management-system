package org.example.contoller;

import org.example.Grade;
import org.example.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class StudentController {
    public StudentController() throws IOException {
        students = fileHandling.readFromFile("students.txt");
    }
    ArrayList<Student> students = new ArrayList<>();
    FileHandling fileHandling = new FileHandling();
    Scanner sc = new Scanner(System.in);

    // Option 1 to add a new Student
    public void addStudent() {
        System.out.println("Choice 1 for add a student..");
        Student student = new Student();
        int id = students.isEmpty() ? 1 : students.get(students.size() - 1).getId() + 1;
        student.setId(id);

        getStudentDetails(student);

        System.out.println("New student added");
        System.out.println("id,name,age,grade");
        System.out.println(student);
    }

    // Option 2 View All Students
    public void viewStudents() {
        if(students.isEmpty()){
            System.out.println("Students list is empty");
        }else {
            System.out.println("Students List....");
            System.out.println("id,name,age,grade");
            for(Student student: students){
                System.out.println(student);
            }
            System.out.println();
        }
    }

    // Option 3 Search Student By ID
    public void searchStudentByIdStreams(){
        System.out.println("Enter student ID to search....");
        int id = sc.nextInt();
        Optional<Student> findStudent = students.stream().filter(student -> student.getId() == id).findFirst();
        findStudent.ifPresentOrElse(
                student -> System.out.println("Student found: " + student),
                () -> System.out.println("Student with ID " + id + " not found.")
        );
    }

    // Option 4 Update Student By ID
    public void updateStudent() {
        System.out.println("Enter Student ID to update");
        int id = sc.nextInt();
        updateStudent(id);
    }

    // Option 5 to delete a Student.
    public void deleteStudents() {
        System.out.print("Enter the student Id to delete....");
        int removeId = sc.nextInt();
        if(students.removeIf((student) -> student.getId() == removeId)) {
            System.out.println("Student with id " + removeId + " has been removed.");
        } else {
            System.out.println("Student with  ID: " + removeId + " not found");
        }
    }

    public void saveStudents() throws IOException {
        fileHandling.saveToFile(students, "students.txt");
    }

    // Helper method
    private static boolean isValidGrade(String grade) {
        try {
            Grade.valueOf(grade.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Helper method
    private void updateStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                inputStudentDetails(student);
                viewStudents();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Helper Method
    private void inputStudentDetails(Student student) {
        System.out.println("Enter student name");
        String name = sc.next();
        student.setName(name);
        System.out.println("Enter student age");
        int age = sc.nextInt();
        student.setAge(age);
        System.out.println("Enter student grade");
        String gradeInput = sc.next();
        while (!isValidGrade(gradeInput)) {
            System.out.println("Invalid grade. Please enter again:");
            gradeInput = sc.next();
        }
        student.setGrade(Grade.valueOf(gradeInput.toUpperCase()));
    }

    // Helper method
    private void getStudentDetails(Student student) {
        inputStudentDetails(student);
        students.add(student);
    }

}
