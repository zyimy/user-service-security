package com.cloud.security.userservice.exception;

public enum ErrorCode {
    USER_NOT_FOUND(1,"El usuario que busca no existe");

    private  Integer code;
    private String descripcion;

    ErrorCode(Integer code, String descripcion) {
        this.code = code;
        this.descripcion = descripcion;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
