package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.exceptions.DataException;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.AnswerRepository;
import com.bitMiners.pdf.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Integer saveAnswer(Answer answer) {
        Integer id = answerRepository.add(answer);
        if (id < 1) {
            throw new PdfApiException("Error while saving answer!", 500);
        }
        return id;
    }

    public Answer updateAnswer(Answer answer) {
        if (answerRepository.findOne(answer.getId()) == null) {
            throw new PdfApiException("Invalid answer id : " + answer.getId(), 404);
        }
        return answerRepository.update(answer);
    }

    public void deleteAnswer(int id) {
        if (Objects.isNull(answerRepository.findOne(id))) {
            throw new PdfApiException("Invalid answer id : " + id, 404);
        }
        answerRepository.delete(id);
    }
}
