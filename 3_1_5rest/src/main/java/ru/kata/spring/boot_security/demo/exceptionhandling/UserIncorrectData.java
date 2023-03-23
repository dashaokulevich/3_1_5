package ru.kata.spring.boot_security.demo.exceptionhandling;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserIncorrectData {

    private String info;

    public UserIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}