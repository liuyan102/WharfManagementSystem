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
public class ShipRegistry { //单船登记帐实体类
    private int ShipRegistrationID; //单船登记帐编号
    private String  RegistrationDate; //登记日期
    private int ShipID; //船舶编号
    private int PortID; //港口编号
    private String TCNum; //营运证号码
    private String TCValidity; //营运证有效期
    private String ShipType; //船舶类型
    private int CargoWeight; //货物重量
    private String PrincipalName; //负责人姓名
    private String PrincipalPhone; //负责人电话
    private String AdminName; //管理员姓名
    private String AdminPhone; //管理员电话
    private String Notes; //备注

}
