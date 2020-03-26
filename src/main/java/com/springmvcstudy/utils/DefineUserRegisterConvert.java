package com.springmvcstudy.utils;

import com.springmvcstudy.entity.UserRegister;
import org.springframework.core.convert.converter.Converter;

public class DefineUserRegisterConvert implements Converter<String, UserRegister> {
    @Override
    public UserRegister convert(String s) {
        String [] strings=s.split("-");
        return new UserRegister(strings[0],strings[1]);
    }
}
