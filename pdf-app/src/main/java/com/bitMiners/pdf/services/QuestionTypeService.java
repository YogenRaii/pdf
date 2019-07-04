package com.bitMiners.pdf.services;

import com.bitMiners.pdf.domain.QuestionType;

import java.util.List;

public interface QuestionTypeService {

    Long saveQuestionType(QuestionType questionType);

    QuestionType updateQuestionType(QuestionType questionType);

    void deleteQuestionType(Long id);

    List<QuestionType> getAllQuestionTypes();
}
