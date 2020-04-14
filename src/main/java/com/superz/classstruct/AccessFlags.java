package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.accessflag.AccessFlagEnum;
import com.superz.util.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class AccessFlags extends AbstractDataItem implements IReader
{
    private byte[] bytes;

    @Override
    protected void init() {
        name = "access_flags";
        length = 2;
        description = "访问标志";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        bytes = Common.subBytesArray(byteCodes, cursor, length);
        return length;
    }

    public AccessFlagEnum[] get() {
        List<AccessFlagEnum> flags = new ArrayList<>();

        String s = Common.bytes2Hex(bytes);
        // 第一位
        char first = s.charAt(3);
        if (first == '1')
            flags.add(AccessFlagEnum.ACC_PUBLIC);

        // 第二位
        char second = s.charAt(2);
        switch (second) {
            case '3':
                flags.add(AccessFlagEnum.ACC_FINAL);
                flags.add(AccessFlagEnum.ACC_SUPER);
                break;
            case '2':
                flags.add(AccessFlagEnum.ACC_SUPER);
                break;
            case '1':
                flags.add(AccessFlagEnum.ACC_FINAL);
                break;
        }

        // 第三位
        char third = s.charAt(1);
        switch (third) {
            case '6':
                flags.add(AccessFlagEnum.ACC_INTERFACE);
                flags.add(AccessFlagEnum.ACC_ABSTRACT);
                break;
            case '4':
                flags.add(AccessFlagEnum.ACC_ABSTRACT);
                break;
            case '2':
                flags.add(AccessFlagEnum.ACC_INTERFACE);
                break;
        }

        // 最后一位
        char fourth = s.charAt(0);
        switch (fourth) {
            case '7':
                flags.add(AccessFlagEnum.ACC_ENUM);
                flags.add(AccessFlagEnum.ACC_ANNOTATION);
                flags.add(AccessFlagEnum.ACC_SYNTHETIC);
                break;
            case '6':
                flags.add(AccessFlagEnum.ACC_ENUM);
                flags.add(AccessFlagEnum.ACC_ANNOTATION);
                break;
            case '5':
                flags.add(AccessFlagEnum.ACC_ENUM);
                flags.add(AccessFlagEnum.ACC_SYNTHETIC);
                break;
            case '3':
                flags.add(AccessFlagEnum.ACC_ANNOTATION);
                flags.add(AccessFlagEnum.ACC_SYNTHETIC);
                break;
            case '4':
                flags.add(AccessFlagEnum.ACC_ENUM);
                break;
            case '2':
                flags.add(AccessFlagEnum.ACC_ANNOTATION);
                break;
            case '1':
                flags.add(AccessFlagEnum.ACC_SYNTHETIC);
                break;
        }

        AccessFlagEnum[] arr = new AccessFlagEnum[flags.size()];
        return flags.toArray(arr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.toUpperCase()).append("(" + description + ")").append(":");
        for (AccessFlagEnum flag : get()) {
            sb.append(flag.name()).append(",");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}
