package com.superz.constanttypestruct;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public class CONSTANT_MethodHandle_info_Struct extends CONSTANT_info_Struct
{
    private byte[] reference_kind;
    private byte[] reference_index;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor + index);
        index += 1;

        reference_kind = new byte[1];
        for (int i = 0; i < 1; i++) {
            reference_kind[i] = byteCodes.get(cursor + index + i);
        }
        index += 1;

        reference_index = new byte[2];
        for (int i = 0; i < 2; i++) {
            reference_index[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        return index;
    }
}
