package com.superz.struct;

import java.util.List;

import com.superz.AbstractStruct;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public class AttributeStruct extends AbstractStruct
{
    // private byte[] attribute_name_index;
    // 属性的长度
    private byte[] attribute_length;
    // private byte[] info;

    private int dataLength=0;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        // attribute_name_index
        offset += 2;

        // attribute_length
        attribute_length = Common.subBytesArray(byteCodes, cursor + offset, 4);
        offset += 4;

        // 获取属性值的位数
        offset += Common.bytes2Dec(attribute_length);

        dataLength=offset;
        return offset;
    }

    @Override public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("属性的所占字节为：").append(dataLength);
        return sb.toString();
    }
}
