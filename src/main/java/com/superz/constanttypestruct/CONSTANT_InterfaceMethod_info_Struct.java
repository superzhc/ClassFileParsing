package com.superz.constanttypestruct;

import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月13日 superz add
 */
public class CONSTANT_InterfaceMethod_info_Struct extends CONSTANT_info_Struct
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

    @Override public String toString() {
        StringBuilder result=new StringBuilder();
        result.append(super.toString());
        result.append(TAB).append("index1:").append(Common.bytes2Hex(index1)).append(Enter);
        result.append(TAB).append("index2:").append(Common.bytes2Hex(index2));
        return result.toString();
    }
}
