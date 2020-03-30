package com.springmvcstudy.validator;

import com.springmvcstudy.entity.UserRegister;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 自定义数据校验器
 * 实现Validator接口
 */
@Component
public class UserRegisterValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegister.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"userName",null,"用户名不能为空！");
        ValidationUtils.rejectIfEmpty(errors,"userPwd",null,"用户密码不能为空！");
    }
}
