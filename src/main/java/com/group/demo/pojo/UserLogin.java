package com.group.demo.pojo;

import lombok.*;

@Getter //自动生成Get方法
@Setter //自动生成Set方法
@ToString //自动生成ToString方法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {  //老师模板
    private String username;
    private String password;


}
