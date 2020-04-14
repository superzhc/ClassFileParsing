package com.superz.constanttypestruct;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public class CONSTANT_MethodType_info_Struct extends CONSTANT_info_Struct
{
    private byte[] descriptor_index;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor + index);
        index += 1;

        descriptor_index = new byte[2];
        for (int i = 0; i < 2; i++) {
            descriptor_index[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        return index;
    }
}
