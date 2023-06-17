package com.group.demo.pojo;

import lombok.*;

import java.util.Date;

@Getter //自动生成Get方法
@Setter //自动生成Set方法
@ToString //自动生成ToString方法
@Data //@Data : 注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@AllArgsConstructor //@AllArgsConstructor会生成一个包含所有变量，
                    //同时如果变量使用了NotNull annotation ， 会进行是否为空的校验，全部参数的构造函数的自动生成，
                    //该注解的作用域也是只有在实体类上，参数的顺序与属性定义的顺序一致。
@NoArgsConstructor //@NoArgsConstructor无参构造函数
public class Employ { //员工实体类
    private int EmployID; //员工编号
    private String Username; //员工账号
    private String Password; //员工密码
    private String EmployName; //员工姓名
    private String EmploySex; //员工性别
    private int EmployAge; //员工年龄
    private String EmployBirth; //员工生日
    private String EmployPhone; //员工电话
    private String EmployMail; //员工邮箱
    private String EmployPosition; //员工职位

}
