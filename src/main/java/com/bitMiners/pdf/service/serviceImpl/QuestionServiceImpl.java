package com.bitMiners.pdf.service.serviceImpl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.repository.repositoryImpl.QuestionRepository;
import com.bitMiners.pdf.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	public Integer save(Question question) {
		return questionRepository.add(question);
	}
	public Question getQuestionById(int id) {
		return questionRepository.findOne(id);
	}
	public void deleteQuestionById(int id) {
		questionRepository.delete(id);
		
	}

}
