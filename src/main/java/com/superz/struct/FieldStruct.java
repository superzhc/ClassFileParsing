package com.superz.struct;

import com.superz.IReader;
import com.superz.accessflag.FieldAccessFlagEnum;
import com.superz.util.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class FieldStruct implements IReader
{
    private byte[] access_flags;
    private byte[] name_index;
    private byte[] descriptor_index;
    private byte[] attributes_count;
    private byte[] attributes;

    private FieldAccessFlagEnum[] getAccessFlags() {
        String hex = Common.bytes2Hex(access_flags);

        List<FieldAccessFlagEnum> lst = new ArrayList<>();
        // 第一位
        char first = hex.charAt(3);
        switch (first) {
            // 以上是互斥的
            case '1':
                lst.add(FieldAccessFlagEnum.ACC_PUBLIC);
                break;
            case '2':
                lst.add(FieldAccessFlagEnum.ACC_PRIVATE);
                break;
            case '4':
                lst.add(FieldAccessFlagEnum.ACC_PROTECTED);
                break;
            // 以上是互斥的
            case '9':
                lst.add(FieldAccessFlagEnum.ACC_PUBLIC);
                lst.add(FieldAccessFlagEnum.ACC_STATIC);
                break;
            case 'a':
                lst.add(FieldAccessFlagEnum.ACC_PRIVATE);
                lst.add(FieldAccessFlagEnum.ACC_STATIC);
                break;
            case 'c':
                lst.add(FieldAccessFlagEnum.ACC_PROTECTED);
                lst.add(FieldAccessFlagEnum.ACC_STATIC);
                break;
        }

        // 第二位
        char second = hex.charAt(2);
        switch (second) {
            // 以下是互斥的
            case '1':
                lst.add(FieldAccessFlagEnum.ACC_FINAL);
                break;
            case '4':
                lst.add(FieldAccessFlagEnum.ACC_VOLATILE);
                break;
            case '8':
                lst.add(FieldAccessFlagEnum.ACC_TRANSIENT);
                break;
        }

        // 第三位，没有占位，即不需要处理
        // char third = hex.charAt(1);

        // 第四位
        char fourth = hex.charAt(0);
        switch (fourth) {
            case '1':
                lst.add(FieldAccessFlagEnum.ACC_SYNTHETIC);
                break;
            case '4':
                lst.add(FieldAccessFlagEnum.ACC_ENUM);
                break;
        }

        return lst.toArray(new FieldAccessFlagEnum[lst.size()]);
    }

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

    @Override public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("字段访问标志：");
        for(FieldAccessFlagEnum accessFlagEnum:getAccessFlags()){
            sb.append(accessFlagEnum.name()).append(",");// Fixme 最后会多一个逗号~~
        }
        sb.append(Enter);

        sb.append("字段的简单名称").append(":").append(name_index).append(Enter);
        sb.append("字段和方法的描述符").append(":").append(descriptor_index).append(Enter);

        return sb.toString();
    }
}
