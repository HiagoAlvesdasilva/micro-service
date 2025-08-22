package br.com.hiago.user_api.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestemp;
    private String error;
    private Integer status;
    private String path;
}
