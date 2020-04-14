package com.superz.struct;

import java.util.List;

import com.superz.IReader;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public abstract class AbstractFieldAndMethodStruct implements IReader
{
    protected byte[] access_flags;
    protected byte[] name_index;
    protected byte[] descriptor_index;
    protected byte[] attributes_count;
    protected byte[] attributes;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        // access_flags:u2
        access_flags = Common.subBytesArray(byteCodes, cursor + offset, 2);
        offset += 2;

        // name_index:u2
        name_index = Common.subBytesArray(byteCodes, cursor + offset, 2);
        offset += 2;

        // descriptor_index:u2
        descriptor_index = Common.subBytesArray(byteCodes, cursor + offset, 2);
        offset += 2;

        // attribute_count:u2
        attributes_count = Common.subBytesArray(byteCodes, cursor + offset, 2);
        offset += 2;

        // attributes
        // TODO 属性的解析

        return offset;
    }

    public abstract Enum[] getAccessFlags();

    public abstract String info();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(info() + "访问标志：");
        for (Enum accessFlagEnum : getAccessFlags()) {
            sb.append(accessFlagEnum.name()).append(",");// Fixme 最后会多一个逗号~~
        }
        sb.append(Enter);

        sb.append(info() + "的简单名称").append(":").append(name_index).append(Enter);
        sb.append(info() + "的描述符").append(":").append(descriptor_index).append(Enter);

        return sb.toString();
    }
}
