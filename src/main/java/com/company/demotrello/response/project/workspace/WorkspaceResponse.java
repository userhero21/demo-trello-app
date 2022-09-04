package com.company.demotrello.response.project.workspace;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class WorkspaceResponse<T, R> implements Serializable {
    private T myWorkspaces;
    private R joinWorkspaces;
}
