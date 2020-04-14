package com.superz.constanttypestruct;

import com.superz.IReader;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public abstract class CONSTANT_info_Struct implements IReader
{
    /* 每个常量项都又一个标志位 */
    protected byte tag;

    protected CONSTANT_Tag constant_tag;

    public void setConstant_tag(CONSTANT_Tag constant_tag) {
        this.constant_tag = constant_tag;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tag:").append(Common.bytes2Dec(tag));
        result.append("[" + constant_tag.name() + "(" + constant_tag.getDescription() + ")]").append(Enter);
        return result.toString();
    }
}
