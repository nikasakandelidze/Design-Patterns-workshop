package com.designpattern.gateway.service.security;

import org.springframework.stereotype.Component;

@Component
class ValidatorImpl implements SecurityValidator{
    @Override
    public boolean isInputRequestValid(String privateKey) {
        return privateKey.matches("[1-10]*.*.*.*.*");
    }
}
