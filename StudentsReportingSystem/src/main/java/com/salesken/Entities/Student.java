package com.salesken.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer student_Id;
	private String first_Name;
	private String last_Name;
	private String email;
	private String mobile_Number;
	private String branch;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<MarksReport> marks = new ArrayList<>();
}
