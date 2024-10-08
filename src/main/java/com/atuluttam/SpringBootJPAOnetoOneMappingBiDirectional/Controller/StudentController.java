package com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Controller;

import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Address;
import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Student;
import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET endpoint to retrieve all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET endpoint to retrieve a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }


    @GetMapping("/address/{addressId}")
    public Student findStudentByAddressId(@PathVariable Long addressId) {
       return studentService.getStudentByAddressId(addressId);
    }

    // POST endpoint to create a new student with an address
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveOrUpdateStudent(student);
    }

    // PUT endpoint to update an existing student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAddress(studentDetails.getAddress());
            return studentService.saveOrUpdateStudent(student);
        }
        return null; // Handle case if student doesn't exist
    }

    // DELETE endpoint to delete a student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}