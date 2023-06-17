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
public class Contract { //合同实体类
    private int ContractID; //合同编号
    private String ProjectName; //项目名称
    private String PartA; //甲方
    private String RepresentA; //甲方法定代表人
    private String PhoneA; //甲方电话
    private String AddressA; //甲方地址
    private String PartB; //乙方
    private String RepresentB; //乙方法定代表人
    private String PhoneB; //乙方电话
    private String AddressB; //乙方地址
    private String Law; //法律
    private String ContractContent; //合同内容
    private String SignDate; //签订日期
    private String BeginDate; //生效日期
    private String EndDate; //结束日期
    private String Notes; //备注

}
