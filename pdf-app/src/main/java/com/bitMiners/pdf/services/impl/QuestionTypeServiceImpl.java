package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.repositories.QuestionTypeRepository;
import com.bitMiners.pdf.services.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    public Long saveQuestionType(QuestionType questionType) {
        return questionTypeRepository.add(questionType);
    }

    public QuestionType updateQuestionType(QuestionType questionType) {
        return questionTypeRepository.update(questionType);
    }

    public void deleteQuestionType(Long id) {
        questionTypeRepository.delete(id);
    }

    public List<QuestionType> getAllQuestionTypes() {
        return questionTypeRepository.findAll();
    }
}
