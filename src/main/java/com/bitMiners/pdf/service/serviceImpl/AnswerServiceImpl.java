package com.bitMiners.pdf.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.repository.repositoryImpl.AnswerRepository;
import com.bitMiners.pdf.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired 
	private AnswerRepository answerRepository;
	
	public Integer saveAnswer(Answer answer) {
		return answerRepository.add(answer);
	}

}