package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * tag:u1
 * length:u2
 * bytes:u1*length
 * 2020年04月13日 superz add
 */
public class CONSTANT_Utf8_info_Struct extends CONSTANT_info_Struct
{
    private byte[] length;
    private byte[] bytes;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor + index);
        index += 1;

        // utf-8编码的字符串占用的字节数
        length = new byte[2];
        length[0] = byteCodes.get(cursor + index);
        length[1] = byteCodes.get(cursor + index + 1);
        index += 2;

        // 长度为length的utf8的字符串
        int i_length = Common.bytes2Dec(length);
        bytes = new byte[i_length];
        for (int i = 0; i < i_length; i++) {
            bytes[i] = byteCodes.get(cursor + index + i);
        }
        index += i_length;

        return index;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append(TAB).append("UTF-8编码的字符串占用的字节数:").append(Common.bytes2Dec(length)).append(Enter);
        result.append(TAB).append("bytes:").append(new String(bytes));
        return result.toString();
    }
}
