package com.labo.prueba.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorMessage {

    private ZonedDateTime timeStamp;
    private HttpStatus httpStatus;
    private String errorText;
    private String requestURL;

    private ErrorMessage() {
        this.timeStamp = ZonedDateTime.now();
    }

    public static ErrorMessageBuilder.HttpStatusType builder() {
        return new Builder();
    }

    public String getHttpStatus() {
        return httpStatus.toString();
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public static class Builder implements ErrorMessageBuilder.HttpStatusType,
            ErrorMessageBuilder.ErrorText,
            ErrorMessageBuilder.RequestURL,
            ErrorMessageBuilder.Optionals {

        private ErrorMessage errorMessage;

        public Builder() {
            this.errorMessage = new ErrorMessage();
        }

        @Override
        public ErrorMessageBuilder.ErrorText httpStatus(HttpStatus httpStatus) {
            this.errorMessage.setHttpStatus(httpStatus);
            return this;
        }

        @Override
        public ErrorMessageBuilder.RequestURL errorText(String errorText) {
            this.errorMessage.setErrorText(errorText);
            return this;
        }

        @Override
        public ErrorMessageBuilder.Optionals requestURL(String requestURL) {
            this.errorMessage.setRequestURL(requestURL);
            return this;
        }

        @Override
        public ErrorMessage build() {
            return this.errorMessage;
        }

    }
}
