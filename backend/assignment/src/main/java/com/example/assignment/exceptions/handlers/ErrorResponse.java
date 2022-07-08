package com.example.assignment.exceptions.handlers;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ErrorResponse {
    private Date timeStamp;
    private String message;
    private String errors;
}
