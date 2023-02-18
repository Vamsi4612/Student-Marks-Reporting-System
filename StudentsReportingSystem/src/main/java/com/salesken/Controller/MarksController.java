package com.salesken.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.Entities.Result;
import com.salesken.Enums.SemesterEnum;
import com.salesken.Enums.SubjectEnum;
import com.salesken.Exceptions.MarksException;
import com.salesken.Exceptions.StudentException;
import com.salesken.Service.MarksReportService;

@RestController
public class MarksController {
	
	@Autowired
	private MarksReportService marksService;
	
	@PostMapping("/marks")
	public ResponseEntity<Result> createReportHandler(@Valid @RequestParam Integer Student_Id,
													@RequestParam SemesterEnum Semester,
													@RequestParam SubjectEnum Subject,
													@RequestParam Integer Marks) throws MarksException, StudentException {
		
		return new ResponseEntity<Result>(marksService.setMarks(Student_Id,Semester.name(),Subject.name(),Marks),HttpStatus.ACCEPTED);
	}

}
