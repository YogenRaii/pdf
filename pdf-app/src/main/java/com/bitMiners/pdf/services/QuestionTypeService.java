package com.bitMiners.pdf.services;

import com.bitMiners.pdf.domain.QuestionType;

import java.util.List;

public interface QuestionTypeService {

    Long saveQuestionType(QuestionType questionType);

    Long updateQuestionType(QuestionType questionType);

    void deleteQuestionType(Long id);

    List<QuestionType> getAllQuestionTypes();
}
