package com.bitMiners.pdf.domain;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "question_type")
public class QuestionType {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty @Lob
	private String description;
	
	public QuestionType(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
