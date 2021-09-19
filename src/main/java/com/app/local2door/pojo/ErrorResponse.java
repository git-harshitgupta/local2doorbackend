package com.app.local2door.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse implements Serializable{
	private String message;
    private LocalDateTime timestamp;

}
