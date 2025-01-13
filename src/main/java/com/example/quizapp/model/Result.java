package com.example.quizapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "quiz_results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quiz_name", nullable = false)
    private String quizName;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "passed", nullable = false)
    private boolean passed;

    @Column(name = "question_results", nullable = false, length = 1000)
    private String questionResults;
}
