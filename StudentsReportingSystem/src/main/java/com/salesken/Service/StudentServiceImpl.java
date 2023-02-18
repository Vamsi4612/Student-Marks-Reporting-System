package com.salesken.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.Entities.Student;
import com.salesken.Exceptions.StudentException;
import com.salesken.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
		//For adding a Student
		@Override
		public Student addStudent(Student student)throws StudentException {
			if (student != null) {
				
				Student e = studentRepo.save(student);
				return e;
			} else {
				throw new StudentException("given Student details are not valid");
			}
		}
		
		
		//Get student by Id		
		@Override
		public Student studentIsPresent(Integer studentId) throws StudentException {
			Optional<Student> opt = studentRepo.findById(studentId);
			if(opt.isPresent()) {
				return opt.get();
			}
			else {
				throw new StudentException("No student present with id : "+studentId);
			}
		}
}
