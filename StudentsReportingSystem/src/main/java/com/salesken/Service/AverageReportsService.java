package com.salesken.Service;

import java.util.List;

import com.salesken.Entities.Student;

public interface AverageReportsService {
	
	public String avgPercentageOfClassBySemester(String semester,String branch);
	public String avgStudentMarksBySubject(Integer id,String subject);
//	public List<Student> topTwoStudentsByAllSemesters();
	
	
}
