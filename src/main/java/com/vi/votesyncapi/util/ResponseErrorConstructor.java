package com.vi.votesyncapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseErrorConstructor {
    private String errorMessage;
    private int statusCode;
    private List<String> otherLinks = new ArrayList<>();

    public ResponseErrorConstructor(String errorMessage, int statusCode, List<String> otherLinks) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.otherLinks = otherLinks;
    }

    public Map<String, Object> getResponseErrorConstructor() {
        HashMap<String, Object> errorContents = new HashMap<>();
        errorContents.put("errorMessage", errorMessage);
        errorContents.put("statusCode", statusCode);
        errorContents.put("otherLinks", otherLinks);
        return errorContents;
    }

    public String getErrorResponseJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(getResponseErrorConstructor());
        } catch (Exception e) {
            // Handle the exception according to your needs
            e.printStackTrace();
            return ""; // or throw a custom exception
        }
    }
}
