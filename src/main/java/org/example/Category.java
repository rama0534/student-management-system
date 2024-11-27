package org.example;

import org.example.contoller.StudentController;

public class Category {
    static void category(int choice, StudentController sc) {
        switch (choice) {
            case 1: // Add a new student
                sc.addStudent();
                break;
            case 2: // view all students
                sc.viewStudents();
                break;
            case 3: // 3. Search Student by ID
                sc.searchStudentByIdStreams();
                break;
            case 4: // 4. Update Student Details
                sc.updateStudent();
                break;
            case 5: // 5. Delete Student Record
                sc.deleteStudents();
                break;
        }
    }
}