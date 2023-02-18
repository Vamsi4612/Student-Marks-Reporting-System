package com.salesken.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.Entities.Student;
import com.salesken.Enums.BranchEnum;
import com.salesken.Enums.SemesterEnum;
import com.salesken.Enums.SubjectEnum;
import com.salesken.Service.AverageReportsService;

@RestController
public class ReportsController {
	
	@Autowired
	private AverageReportsService averageService;
	
	@GetMapping("/firstReport")
	public ResponseEntity<String> firstReportHandler(@Valid @RequestParam SemesterEnum semester,
																@RequestParam BranchEnum branch
																) {
		
		return new ResponseEntity<String>(averageService.avgPercentageOfClassBySemester(semester.name(),branch.name()),HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/secoundReport")
	public ResponseEntity<String> secoundReportHandler(@Valid @RequestParam Integer Student_Id,
																@RequestParam SubjectEnum subject
																) {
		
		return new ResponseEntity<String>(averageService.avgStudentMarksBySubject(Student_Id,subject.name()),HttpStatus.ACCEPTED);
	}
	
	
	
//	@GetMapping("/thirdReport")
//	public ResponseEntity<List<Student>> thirdReportHandler() {
//		
//		return new ResponseEntity<List<Student>>(averageService.topTwoStudentsByAllSemesters(),HttpStatus.ACCEPTED);
//	}
	
}
