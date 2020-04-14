package com.superz.accessflag;

/**
 * 2020年04月14日 superz add
 */
public enum FieldAccessFlagEnum
{
    ACC_PUBLIC("0x0001", "字段是否public"), ACC_PRIVATE("0x0002", "字段是否private"), ACC_PROTECTED("0x0004",
            "字段是否protected"), ACC_STATIC("0x0008", "字段是否static"), ACC_FINAL("0x0010",
                    "字段是否final"), ACC_VOLATILE("0x0040", "字段是否volatile"), ACC_TRANSIENT("0x0080",
                            "字段是否transient"), ACC_SYNTHETIC("0x1000", "字段是否由编译器自动产生的"), ACC_ENUM("0x4000", "字段是否enum");

    private String value;
    private String description;

    private FieldAccessFlagEnum(String value) {
        this.value = value;
    }

    private FieldAccessFlagEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
