package com.salesken.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DynamicInsert
public class MarksReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rowNum;
	
	private String semester;
	
	@ColumnDefault("0")
	private Integer english;
	
	@ColumnDefault("0")
	private Integer maths;
	
	@ColumnDefault("0")
	private Integer science;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_FK")
	@JsonIgnore
	private Student student;

}
