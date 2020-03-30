package com.springmvcstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJSR {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Length(min = 6,max = 18,message = "密码长度在6-18为之间")
    private String password;

    @Email(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message = "请输入正确的邮箱格式")
    private String email;

    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$",message = "请输入正确的电话号码格式")
    private String phone;
}
