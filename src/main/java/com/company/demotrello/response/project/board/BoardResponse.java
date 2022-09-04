package com.company.demotrello.response.project.board;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class BoardResponse<T, R> implements Serializable {
    private T myBoards;
    private R joinBoards;
}
