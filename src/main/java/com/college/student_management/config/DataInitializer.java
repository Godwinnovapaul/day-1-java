package com.college.student_management.config;

import com.college.student_management.entity.Student;
import com.college.student_management.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final StudentRepository studentRepository;

    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed initial data if the database is empty
        if (studentRepository.count() == 0) {
            List<Student> initialStudents = Arrays.asList(
                new Student("Muthu", "muthu@college.edu", "Computer Science"),
                new Student("Moorthy", "moorthy@college.edu", "Information Technology"),
                new Student("Suhail", "suhail@college.edu", "Electronics & Communication"),
                new Student("Kanish", "kanish@college.edu", "Mechanical Engineering"),
                new Student("Anand", "anand@college.edu", "Civil Engineering")
            );

            studentRepository.saveAll(initialStudents);
            logger.info("--> Successfully initialized 5 student records into studentdb!");
        }
    }
}
