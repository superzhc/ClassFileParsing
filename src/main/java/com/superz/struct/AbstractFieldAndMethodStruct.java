package com.superz.struct;

import java.util.List;

import com.superz.AbstractStruct;
import com.superz.classstruct.Attributes;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public abstract class AbstractFieldAndMethodStruct extends AbstractStruct
{
    protected byte[] access_flags;
    protected byte[] name_index;
    protected byte[] descriptor_index;
    protected Attributes attributes;

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

        attributes = new Attributes();
        int offset1 = attributes.read(byteCodes, cursor + offset);
        offset += offset1;

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

        sb.append(TAB).append(info() + "的简单名称").append(":").append(new String(name_index)).append(Enter);
        sb.append(TAB).append(info() + "的描述符").append(":").append(new String(descriptor_index)).append(Enter);
        sb.append(TAB).append(info() + "的属性信息").append(":").append(Enter).append(TAB).append(TAB)
                .append(attributes.toString());

        return sb.toString();
    }
}
