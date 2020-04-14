package com.superz.util;

public enum DescriptorMeaning
{
    B("基本类型byte"), C("基本类型char"), D("基本类型double"), F("基本类型float"), I("基本类型int"), J("基本类型long"), S("基本类型short"), Z(
            "基本类型boolean"), V("特殊类型void"), L("对象类型，如Ljava/lang/Object")
    /* 对于数组类型，每一维度将使用一个前置的 “[” 字符来描述，每增加一个维度将会新增一个 “[” */;
    private String description;

    private DescriptorMeaning(String description) {
        this.description = description;
    }
}
