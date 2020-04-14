package com.superz.accessflag;

public enum MethodAccessFlagEnum
{
    ACC_PUBLIC("0x0001", "方法是否为public"), ACC_PRIVATE("0x0002", "方法是否为private"), ACC_PROTECTED("0x0004",
            "方法是否为protected"), ACC_STATIC("0x0008", "方法是否为static"), ACC_FINAL("0x0010",
                    "方法是否为final"), ACC_SYNCHRONIZED("0x0020", "方法是否为synchronized"), ACC_BRIDGE("0x0040",
                            "方法是否是由编译器产生的桥接方法"), ACC_VARARGS("0x0080", "方法是否接受不定参数"), ACC_NATIVE("0x0100",
                                    "方法是否为native"), ACC_ABSTRACT("0x0400", "方法是否为abstract"), ACC_STRICTFP("0x0800",
                                            "方法是否为strictfp"), ACC_SYNTHETIC("0x1000", "方法是否是由编译器自动产生的");
    private String value;
    private String description;

    private MethodAccessFlagEnum(String value) {
        this.value = value;
    }

    private MethodAccessFlagEnum(String value, String description) {

    }
}
