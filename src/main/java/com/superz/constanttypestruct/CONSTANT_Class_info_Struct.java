package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * tag:u1
 * index:u2
 * 2020年04月13日 superz add
 */
public class CONSTANT_Class_info_Struct extends CONSTANT_info_Struct
{
    private byte[] indexs;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor);
        index += 1;

        this.indexs = new byte[2];
        for (int i = 0; i < 2; i++) {
            this.indexs[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        return index;
    }

    @Override public String toString() {
        StringBuilder result=new StringBuilder();
        result.append(super.toString());
        result.append(TAB).append("indexs:"+ Common.bytes2Hex(indexs));
        return result.toString();
    }
}
