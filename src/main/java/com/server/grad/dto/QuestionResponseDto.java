package com.server.grad.dto;

import com.server.grad.domain.Question;
import com.server.grad.dto.answers.AnswersResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class QuestionResponseDto {
    private Long id;
    private String question;
    private LocalDate date;
    private Boolean complete;
    private List<AnswersResponseDto> answers;

    public QuestionResponseDto(Question entity){
        this.id = entity.getId();
        this.question = entity.getQuestion();
        this.date = entity.getDate();
        this.complete = entity.getComplete();
        this.answers = entity.getAnswers().stream().map(AnswersResponseDto::new).collect(Collectors.toList());
    }
}