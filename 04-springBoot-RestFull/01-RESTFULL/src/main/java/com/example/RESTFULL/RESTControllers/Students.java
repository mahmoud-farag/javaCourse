package com.example.RESTFULL.RESTControllers;

import com.example.RESTFULL.Entities.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Students {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void injectinitialData () {
        students = new ArrayList<>();

        students.add(new Student("Ali", "Ahmed"));
        students.add(new Student("Hend", "Mahamad"));
        students.add(new Student("Joe", "Jack"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents () {
        return students;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent (@PathVariable int studentID) {

        if ( (studentID > students.size()) || (studentID < 0) ) {

            throw new StudentNotFoundExecption("Student ID not found: " + studentID);
        }

        return students.get(studentID);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrResponse> handleException (StudentNotFoundExecption  err){

        StudentErrResponse error = new StudentErrResponse();


        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(err.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);

    }



//    @ExceptionHandler
//    public ResponseEntity<StudentErrResponse> handleException (Exception  err){
//
//        StudentErrResponse error = new StudentErrResponse();
//
//        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(err.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
//    }
}
