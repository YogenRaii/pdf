package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.QuestionTypeRepository;
import com.bitMiners.pdf.services.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    public Long saveQuestionType(QuestionType questionType) {
        return questionTypeRepository.add(questionType);
    }

    public QuestionType updateQuestionType(QuestionType questionType) {
        QuestionType dbRecord = this.questionTypeRepository.findOne(questionType.getId());
        if (Objects.isNull(dbRecord)) {
            throw new PdfApiException("No Question Type found with id: " + questionType.getId(), 404);
        }
        return questionTypeRepository.update(questionType);
    }

    public void deleteQuestionType(Long id) {
        QuestionType dbRecord = this.questionTypeRepository.findOne(id);
        if (Objects.isNull(dbRecord)) {
            throw new PdfApiException("No Question Type found with id: " + id, 404);
        }
        questionTypeRepository.delete(id);
    }

    public List<QuestionType> getAllQuestionTypes() {
        return questionTypeRepository.findAll();
    }
}
