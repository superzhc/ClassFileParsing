package com.superz.accessflag;

/**
 * 2020年04月14日 superz add
 */
public enum AccessFlagEnum
{
    ACC_PUBLIC("0x0001", "是否为public类型"), ACC_FINAL("0x0010", "是否被声明为final，只有类可设置"), ACC_SUPER("0x0020",
            "是否允许使用invokespecial字节码指令的新语意"), ACC_INTERFACE("0x0200", "标识这是一个接口"), ACC_ABSTRACT("0x0400",
                    "是否为abstract类型，对于接口或抽象类来说，此标志值为真，其他类值为假"), ACC_SYNTHETIC("0x1000",
                            "标识这个类并非由用户代码产生的"), ACC_ANNOTATION("0x2000", "标识这是一个注解"), ACC_ENUM("0x4000", "标识这是一个枚举");

    private String value;
    private String description;

    private AccessFlagEnum(String value) {
        this.value = value;
    }

    private AccessFlagEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
