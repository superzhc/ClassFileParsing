package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * tag:u1
 * index:u2
 * index:u2
 * 2020年04月13日 superz add
 */
public class CONSTANT_Fieldref_info_Struct extends CONSTANT_info_Struct
{
    // 指向声明字段的类或者接口描述符 CONSTANT_Class_info 的索引项
    private byte[] index1;
    // 指向字段描述符 CONSTANT_NameAndType 的索引项
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
        result.append(TAB).append("指向该字段所在类或者接口的描述符CONSTANT_Class_info的索引:#").append(Common.bytes2Dec(index1))
                .append(Enter);
        result.append(TAB).append("指向该字段描述符CONSTANT_NameAndType_info的索引:#").append(Common.bytes2Dec(index2));
        return result.toString();
    }
}
