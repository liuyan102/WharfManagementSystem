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
public class Delegation { //作业委托单实体类
    private int DelegationID; //作业委托单编号
    private String DelegationDate; //作业委托单日期
    private String DelegationContent; //作业委托单内容
    private String EnterDate; //进港时间
    private String EnterLocation; //进港地点
    private String Carrier; //承运人
    private String CarrierPhone; //承运人电话
    private String AppointDate; //约定作业预期
    private String AppointDuring; //约定作业期限
    private String Examine; //审核人
    private String Handle; //经办人
    private String Notes; //备注

}

