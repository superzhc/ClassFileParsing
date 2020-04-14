package com.superz.struct;

import com.superz.accessflag.FieldAccessFlagEnum;
import com.superz.accessflag.MethodAccessFlagEnum;
import com.superz.util.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class MethodStruct extends AbstractFieldAndMethodStruct
{
    @Override
    public MethodAccessFlagEnum[] getAccessFlags() {
        String hex = Common.bytes2Hex(access_flags);

        List<MethodAccessFlagEnum> lst = new ArrayList<>();
        // 第一位
        char first = hex.charAt(3);
        switch (first) {
            // 以上是互斥的
            case '1':
                lst.add(MethodAccessFlagEnum.ACC_PUBLIC);
                break;
            case '2':
                lst.add(MethodAccessFlagEnum.ACC_PRIVATE);
                break;
            case '4':
                lst.add(MethodAccessFlagEnum.ACC_PROTECTED);
                break;
            // 以上是互斥的
            case '9':
                lst.add(MethodAccessFlagEnum.ACC_PUBLIC);
                lst.add(MethodAccessFlagEnum.ACC_STATIC);
                break;
            case 'a':
                lst.add(MethodAccessFlagEnum.ACC_PRIVATE);
                lst.add(MethodAccessFlagEnum.ACC_STATIC);
                break;
            case 'c':
                lst.add(MethodAccessFlagEnum.ACC_PROTECTED);
                lst.add(MethodAccessFlagEnum.ACC_STATIC);
                break;
        }

        // 第二位
        char second = hex.charAt(2);
        switch (second) {
            case '1':
                lst.add(MethodAccessFlagEnum.ACC_FINAL);
                break;
            case '2':
                lst.add(MethodAccessFlagEnum.ACC_SYNCHRONIZED);
                break;
            case '4':
                lst.add(MethodAccessFlagEnum.ACC_BRIDGE);
                break;
            case '8':
                lst.add(MethodAccessFlagEnum.ACC_VARARGS);
                break;
            case '3':
                lst.add(MethodAccessFlagEnum.ACC_FINAL);
                lst.add(MethodAccessFlagEnum.ACC_SYNCHRONIZED);
                break;
            case '9':
                lst.add(MethodAccessFlagEnum.ACC_FINAL);
                lst.add(MethodAccessFlagEnum.ACC_VARARGS);
                break;
            case 'a':
                lst.add(MethodAccessFlagEnum.ACC_SYNCHRONIZED);
                lst.add(MethodAccessFlagEnum.ACC_VARARGS);
                break;
            case 'b':
                lst.add(MethodAccessFlagEnum.ACC_FINAL);
                lst.add(MethodAccessFlagEnum.ACC_SYNCHRONIZED);
                lst.add(MethodAccessFlagEnum.ACC_VARARGS);
                break;
            // TODO 未全罗列，关于桥接方法都未进行组合
        }

        // 第三位，没有占位，即不需要处理
        char third = hex.charAt(1);
        switch (third) {
            case '1':
                lst.add(MethodAccessFlagEnum.ACC_NATIVE);
                break;
            case '4':
                lst.add(MethodAccessFlagEnum.ACC_ABSTRACT);
                break;
            case '8':
                lst.add(MethodAccessFlagEnum.ACC_STRICTFP);
                break;
            // TODO 相关选项是否可以组合
        }

        // 第四位
        char fourth = hex.charAt(0);
        switch (fourth) {
            case '1':
                lst.add(MethodAccessFlagEnum.ACC_SYNTHETIC);
                break;
        }

        return lst.toArray(new MethodAccessFlagEnum[lst.size()]);
    }

    @Override
    public String info() {
        return "方法";
    }
}
