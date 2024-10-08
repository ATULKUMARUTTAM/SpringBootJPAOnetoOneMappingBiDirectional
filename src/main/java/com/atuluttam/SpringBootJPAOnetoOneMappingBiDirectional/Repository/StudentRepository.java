package com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Repository;

import com.atuluttam.SpringBootJPAOnetoOneMappingBiDirectional.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
