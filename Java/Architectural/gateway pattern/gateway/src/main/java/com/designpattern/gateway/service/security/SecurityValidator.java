package com.designpattern.gateway.service.security;

public interface SecurityValidator {
    boolean isInputRequestValid(String privateKey);
}
