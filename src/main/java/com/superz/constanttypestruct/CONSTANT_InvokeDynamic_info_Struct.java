package com.superz.constanttypestruct;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public class CONSTANT_InvokeDynamic_info_Struct extends CONSTANT_info_Struct
{
    private byte[] bootstrap_method_attr_index;
    private byte[] name_and_type_index;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor + index);
        index += 1;

        bootstrap_method_attr_index = new byte[2];
        for (int i = 0; i < 2; i++) {
            bootstrap_method_attr_index[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        name_and_type_index = new byte[2];
        for (int i = 0; i < 2; i++) {
            name_and_type_index[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        return index;
    }
}
