package org.example;

import org.example.contoller.StudentController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentController sc = new StudentController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        showMenu();
        while (true) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == 6){
                sc.saveStudents();
                System.out.println("Thank you!");
                break;
            }
            else {
                Category.category(choice, sc);
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Details");
        System.out.println("5. Delete Student Record");
        System.out.println("6. Exit");
    }

}