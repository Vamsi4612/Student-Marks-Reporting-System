package com.salesken.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.Entities.MarksReport;
import com.salesken.Entities.Result;
import com.salesken.Entities.Student;
import com.salesken.Exceptions.MarksException;
import com.salesken.Exceptions.StudentException;
import com.salesken.Repository.MarksRepo;
import com.salesken.Repository.StudentRepo;

@Service
public class MarksReportServiceImpl implements MarksReportService {
	
	@Autowired
	private MarksRepo marksRepo;
	
	@Autowired
	private StudentService studentService;
	
	//To Add Marks of Student to MarksReport by taking ---> id, semester, subjectName, marks
	
	@Override
	public Result setMarks(Integer id, String semester, String subjectName, Integer marks) throws MarksException, StudentException {
		Result result = new Result();
		MarksReport report = null;
		
		Student student = studentService.studentIsPresent(id);   
		
		if(marksReportingStatus(student, semester) == "notStarted") {
			report  =  insertMarks(student,semester,subjectName,marks);

		}
		else {
			 report = updateMarks(student,semester,subjectName,marks);
		}
		
		report.setStudent(student);
		student.getMarks().add(report);
		
		Object obj = marksRepo.save(report);
		result.setObj(obj);
		result.setOutput("Success");
		
		return result;
	}
	
	
	//Utility functions
	
	public String marksReportingStatus(Student student, String semester) {
		MarksReport marks = marksRepo.findByStudentAndSemester(student, semester);
		if(marks != null) return "started";
		else return "notStarted";
		
	}
	
	public MarksReport insertMarks(Student student,String semester,String subjectName,Integer marks) {
		MarksReport report = new MarksReport();
		report.setSemester(semester);
		report = setMarksBySubject(report, subjectName, marks);
		return report;

	}
	
	public MarksReport setMarksBySubject(MarksReport report,String subject,Integer marks) {
		if(subject.equalsIgnoreCase("English")) report.setEnglish(marks);
		else if(subject.equalsIgnoreCase("Maths")) report.setMaths(marks);
		else report.setScience(marks);
		return report;
	}
	
	public MarksReport updateMarks(Student student,String semester,String subjectName,Integer marks) {
		MarksReport report = marksRepo.findByStudentAndSemester(student, semester);
		report = setMarksBySubject(report, subjectName, marks);
		return report;
		
	}


}
