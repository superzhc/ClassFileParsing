package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public class CONSTANT_NameAndType_info_Struct extends CONSTANT_info_Struct
{
    // 指向该字段或方法名称常量项的索引
    private byte[] index1;
    // 指向该字段或方法描述符常量项的索引
    private byte[] index2;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int index = 0;

        // 标志位
        tag = byteCodes.get(cursor + index);
        index += 1;

        index1 = new byte[2];
        for (int i = 0; i < 2; i++) {
            index1[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        index2 = new byte[2];
        for (int i = 0; i < 2; i++) {
            index2[i] = byteCodes.get(cursor + index + i);
        }
        index += 2;

        return index;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append(TAB).append("指向该字段或方法名称常量项的索引（该索引内容是字段或方法名称）:#").append(Common.bytes2Dec(index1)).append(Enter);
        result.append(TAB).append("指向该字段或方法描述符常量项的索引（该索引内容是字段或方法返回字值类型）:#").append(Common.bytes2Dec(index2));
        return result.toString();
    }
}
