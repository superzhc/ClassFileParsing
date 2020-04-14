package com.superz.constanttypestruct;

public enum CONSTANT_Tag
{
    CONSTANT_Utf8_info(CONSTANT_Utf8_info_Struct.class, 1, "UTF-8编码的字符串"), //
    CONSTANT_Integer_info(CONSTANT_Integer_info_Struct.class, 3, "整型字面量"), //
    CONSTANT_Float_info(CONSTANT_Float_info_Struct.class, 4, "浮点型字面量"), //
    CONSTANT_Long_info(CONSTANT_Long_info_Struct.class, 5, "长整型字面量"), //
    CONSTANT_Double_info(CONSTANT_Double_info_Struct.class, 6, "双精度浮点型字面量"), //
    CONSTANT_Class_info(CONSTANT_Class_info_Struct.class, 7, "类或接口的符号引用"), //
    CONSTANT_String_info(CONSTANT_String_info_Struct.class, 8, "字符串类型字面量"), //
    CONSTANT_Fieldref_info(CONSTANT_Fieldref_info_Struct.class, 9, "字段的符号引用"), //
    CONSTANT_Methodref_info(CONSTANT_Methodref_info_Struct.class, 10, "类中方法的符号引用"), //
    CONSTANT_InterfaceMethod_info(CONSTANT_InterfaceMethod_info_Struct.class, 11, "接口中方法的符号引用"), //
    CONSTANT_NameAndType_info(CONSTANT_NameAndType_info_Struct.class, 12, "字段或方法的部分符号引用"), //
    CONSTANT_MethodHandle_info(CONSTANT_MethodHandle_info_Struct.class, 15, "表示方法句柄"), //
    CONSTANT_MethodType_info(CONSTANT_MethodType_info_Struct.class, 16, "标识方法类型"), //
    CONSTANT_InvokeDynamic_info(CONSTANT_InvokeDynamic_info_Struct.class, 18, "标识一个动态方法调用点");

    private Class<? extends CONSTANT_info_Struct> clazz;
    private int tag;
    private String description = "";

    private CONSTANT_Tag(Class<? extends CONSTANT_info_Struct> clazz, int tag) {
        this.clazz = clazz;
        this.tag = tag;
    }

    private CONSTANT_Tag(Class<? extends CONSTANT_info_Struct> clazz, int tag, String description) {
        this.clazz = clazz;
        this.tag = tag;
        this.description = description;
    }

    public Class<CONSTANT_info_Struct> getClazz() {
        return (Class<CONSTANT_info_Struct>) this.clazz;
    }

    public String getDescription() {
        return this.description;
    }

    public static CONSTANT_Tag getByTag(int tag) {
        for (CONSTANT_Tag value : CONSTANT_Tag.values()) {
            if (tag == value.tag)
                return value;
        }
        System.out.println("未匹配的Tag:" + tag);
        return null;
    }
}
