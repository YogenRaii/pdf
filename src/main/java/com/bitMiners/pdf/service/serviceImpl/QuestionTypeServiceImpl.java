package com.bitMiners.pdf.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.repository.QuestionTypeRepository;
import com.bitMiners.pdf.service.QuestionTypeService;
@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	@Autowired
	private QuestionTypeRepository questionTypeRepository;
	
	public Integer saveQuestionType(QuestionType questionType) {
		return questionTypeRepository.add(questionType);
	}

	public Integer updateQuestionType(QuestionType questionType) {
		return questionTypeRepository.update(questionType)?1:0;
	}

	public void deleteQuestionType(int id) {
		 questionTypeRepository.delete(id);
		
	}

	public List<QuestionType> getAllQuestionTypes() {
		return questionTypeRepository.findAll();
	}

}
