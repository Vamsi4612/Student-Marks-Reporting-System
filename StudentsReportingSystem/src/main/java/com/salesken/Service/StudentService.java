package com.salesken.Service;

import com.salesken.Entities.Student;
import com.salesken.Exceptions.StudentException;

public interface StudentService {
	
	public Student addStudent(Student student)throws StudentException;
	public Student studentIsPresent(Integer studentId) throws StudentException;
	

}
