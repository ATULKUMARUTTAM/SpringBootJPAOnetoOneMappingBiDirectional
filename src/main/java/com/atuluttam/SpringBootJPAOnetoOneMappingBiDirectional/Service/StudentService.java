package com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Service;

import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Address;
import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Student;
import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Repository.AddressRepository;
import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

   public List<Student> getAllStudents()
   {
     return   studentRepository.findAll();
   }

    // Fetch a student by ID
    public Student getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElse(null); // Return null if student not found
    }

    // Create or update a student
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    // Delete a student by ID
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }


    public Student getStudentByAddressId(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        // Fetch the student from the address entity
        return address.getStudent();
    }

}
