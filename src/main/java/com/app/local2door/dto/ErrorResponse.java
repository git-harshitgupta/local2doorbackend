package com.app.local2door.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private LocalDateTime timestamp;

}
