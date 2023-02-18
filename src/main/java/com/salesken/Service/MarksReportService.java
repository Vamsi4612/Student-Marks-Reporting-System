package com.salesken.Service;

import com.salesken.Entities.Result;
import com.salesken.Exceptions.MarksException;
import com.salesken.Exceptions.StudentException;

public interface MarksReportService {
	
	public Result setMarks(Integer Id,String Semester,String SubjectName,Integer Marks)throws MarksException,StudentException;
	
}
