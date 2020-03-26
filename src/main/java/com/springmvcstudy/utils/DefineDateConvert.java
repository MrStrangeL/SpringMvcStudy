package com.springmvcstudy.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将String类型转换为Date
 */
public class DefineDateConvert implements Converter<String, Date> {
    private String pattern;

    public DefineDateConvert(String pattern){
        this.pattern=pattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
