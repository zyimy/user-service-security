package com.cloud.security.userservice.exception;

public class UserException extends RuntimeException{

  private final ErrorCode errorCode;

  public UserException (ErrorCode errorCode){
    this.errorCode = errorCode;
  }

  public UserException(ErrorCode errorCode,String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public UserException(ErrorCode errorCode,String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }



  public ErrorCode getErrorCode() {
    return errorCode;
  }
}

