package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * tag:u1
 * bytes:u4
 * 2020年04月13日 superz add
 */
public class CONSTANT_Float_info_Struct extends CONSTANT_info_Struct
{
    private byte[] bytes;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor);
        index += 1;

        bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = byteCodes.get(cursor + index + i);
        }
        index += 4;

        return index;
    }

    @Override public String toString() {
        StringBuilder result=new StringBuilder();
        result.append(super.toString());
        result.append(TAB).append("bytes:").append(Common.bytes2Hex(bytes));
        return result.toString();
    }
}
