package com.group.demo.pojo;

import lombok.*;

@Getter //自动生成Get方法
@Setter //自动生成Set方法
@ToString //自动生成ToString方法
@Data //@Data : 注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@AllArgsConstructor //@AllArgsConstructor会生成一个包含所有变量，
                    //同时如果变量使用了NotNull annotation ， 会进行是否为空的校验，全部参数的构造函数的自动生成，
                    //该注解的作用域也是只有在实体类上，参数的顺序与属性定义的顺序一致。
@NoArgsConstructor //@NoArgsConstructor无参构造函数
public class Owner { //货主实体类
    private int OwnerID; //货主编号
    private String OwnerName; //货主姓名
    private String Username; //货主账号
    private String Password; //货主密码
    private String OwnerPhone; //货主电话
    private String OwnerMail; //货主邮箱

}
