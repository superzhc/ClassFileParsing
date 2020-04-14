package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.constanttypestruct.CONSTANT_Class_info_Struct;
import com.superz.constanttypestruct.CONSTANT_Tag;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class Interfaces extends AbstractDataItem implements IReader
{
    private InterfacesCount interface_count;
    // private CONSTANT_Class_info_Struct[] interfaces;
    private byte[][] interfaces;

    @Override
    protected void init() {
        name = "interfaces";
        description = "接口索引集合";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        interface_count = new InterfacesCount();
        offset = interface_count.read(byteCodes, cursor);

        // 获取接口的起始游标
        int interface_cursor = cursor + offset;

        // 获取接口数量
        int count = Common.bytes2Dec(interface_count.count);
        if (count > 0) {
            interfaces = new byte[count][2];
            for (int i = 0; i < count; i++) {
                // Fixme 这样读是有问题的
                // CONSTANT_Class_info_Struct constant_class_info_struct = new
                // CONSTANT_Class_info_Struct();
                // constant_class_info_struct.setConstant_tag(CONSTANT_Tag.CONSTANT_Class_info);
                // int offset1 = constant_class_info_struct.read(byteCodes, interface_cursor);
                // interfaces[i] = constant_class_info_struct;

                interfaces[i] = Common.subBytesArray(byteCodes, interface_cursor, 2);

                offset += 2;
                interface_cursor += 2;
            }
        }

        return offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(interface_count.toString()).append(Enter);
        if (null != interfaces && 0 != interfaces.length) {
            sb.append(name.toUpperCase()).append("(" + description + ")").append(":").append(Enter);
            for (int i = 0, len = interfaces.length; i < len; i++) {
                sb.append(TAB).append((i + 1) + ".").append("描述接口的常量地址：").append(Common.bytes2Dec(interfaces[i]));
            }
        }
        return sb.toString();
    }

    public static class InterfacesCount extends AbstractDataItem implements IReader
    {
        private byte[] count;

        @Override
        protected void init() {
            name = "interfaces_count";
            length = 2;
            description = "接口计数器";
        }

        @Override
        public int read(List<Byte> byteCodes, int cursor) {
            count = Common.subBytesArray(byteCodes, cursor, length);
            return length;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name.toUpperCase()).append("(" + description + ")").append(":").append(Common.bytes2Dec(count));
            return sb.toString();
        }
    }
}
