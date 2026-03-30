package com.bestbuy.inventory.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private Map<String, String> details;
}


/*
@JsonInclude(JsonInclude.Include.NON_NULL): This is an incredibly smart addition from the Jackson library (the tool that translates Java code into internet JSON text).

    What it does: It tells the translator: "If any field in this letter is blank (null), just completely delete that line from the letter before you mail it."

{
  "timestamp": "2024-05-10T14:30:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Insufficient stock for product SONY-123. Requested: 5, Available: 2"
}

 */