package com.salesken.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesken.Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
