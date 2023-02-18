package com.salesken.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesken.Entities.MarksReport;
import com.salesken.Entities.Student;

public interface MarksRepo extends JpaRepository<MarksReport, Integer> {
	public MarksReport findByStudentAndSemester(Student student,String semester);
	
	
	@Query("select round((sum(english)+sum(maths)+sum(science))/(count(*)*300)*100,2) from MarksReport where semester= :sem and student_fk in(select student_Id from Student where branch = :class )")
	public double firstRecord(@Param("sem") String semester,@Param("class") String branch);
	
	@Query("select avg(english) from MarksReport where student_fk= :sid")
	public double secoundRecordForEnglish(@Param("sid") Integer id);
	
	@Query("select avg(maths) from MarksReport where student_fk= :sid")
	public double secoundRecordForMaths(@Param("sid") Integer id);
	
	@Query("select avg(science) from MarksReport where student_fk= :sid")
	public double secoundRecordForScience(@Param("sid") Integer id);
	
//	@Query("SELECT student_fk, AVG(maths + science + english) AS average_score FROM marks_report GROUP BY student_fk ORDER BY average_score DESC LIMIT 2")
//	public List<Object[]> thirdRecord();
	
	
}
