package com.superz.struct;

import java.util.ArrayList;
import java.util.List;

import com.superz.accessflag.FieldAccessFlagEnum;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public class FieldStruct extends AbstractFieldAndMethodStruct
{
    @Override
    public FieldAccessFlagEnum[] getAccessFlags() {
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
    public String info() {
        return "字段";
    }
}
