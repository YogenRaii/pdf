package com.bitMiners.pdf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionType {
	@Id
	@GeneratedValue
	private int id;
	
	private String questionType;
	
	private String description;

}
