package com.salesken.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.Entities.Student;
import com.salesken.Repository.MarksRepo;

@Service
public class AverageReportsServiceImpl implements AverageReportsService{
	
	
	@Autowired
	private MarksRepo marksRepo;

	@Override
	public String avgPercentageOfClassBySemester(String semester, String branch) {
		Double output = marksRepo.firstRecord(semester,branch);
		return "Average percentage of class by semester ; "+output;
	}
	
	
	
	@Override
	public String avgStudentMarksBySubject(Integer id, String subject) {
		double output = 0;
		if(subject.equalsIgnoreCase("English"))
				output = marksRepo.secoundRecordForEnglish(id);
		
		else if(subject.equalsIgnoreCase("MAths"))
			output = marksRepo.secoundRecordForMaths(id);
		
		if(subject.equalsIgnoreCase("Science"))
			output = marksRepo.secoundRecordForScience(id);
		
		
		return "Average marks of student in subject "+subject+" : "+output;
	}
	
	
	
//	@Override
//	public List<Student> topTwoStudentsByAllSemesters() {
//		List<Object[]> output = marksRepo.thirdRecord();
//		
//		
//	}

	
}
