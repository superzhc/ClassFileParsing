package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.constanttypestruct.CONSTANT_Tag;
import com.superz.constanttypestruct.CONSTANT_info_Struct;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class ConstantPool extends AbstractDataItem implements IReader
{
    private ConstantPoolCount constant_pool_count;
    private CONSTANT_info_Struct[] infos;

    @Override
    protected void init() {
        name = "constant_pool";
        description = "常量池";
    }

    public ConstantPool() {
        constant_pool_count = new ConstantPoolCount();
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;
        // 先读取获取数量
        offset = constant_pool_count.read(byteCodes, cursor);

        // 对于常量池的起始游标
        int constant_pool_cursor = cursor + offset;

        // 获取常量池的数量
        int count = Common.bytes2Dec(constant_pool_count.count);
        try {
            infos = new CONSTANT_info_Struct[count];
            for (int i = 0; i < count - 1; i++) {
                // 常量标志位
                // Fixme 通过javap来查看,常量项是跳跃式的，跳过了7和9之间的8???
                int tag = Common.bytes2Dec(Common.subBytesArray(byteCodes, constant_pool_cursor, 1));
                CONSTANT_Tag constant_tag = CONSTANT_Tag.getByTag(tag);
                if (null == constant_tag)// 先跳过处理
                    break;
                CONSTANT_info_Struct struct = constant_tag.getClazz().newInstance();
                struct.setConstant_tag(constant_tag);
                int offset1 = struct.read(byteCodes, constant_pool_cursor);
                infos[i] = struct;

                // 记录偏移量
                offset += offset1;
                // 获取下一个常量项的起始游标
                constant_pool_cursor += offset1;
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SPLIT).append(Enter);
        sb.append(constant_pool_count.toString()).append(Enter);
        for (int i = 0, len = infos.length; i < len; i++) {
            CONSTANT_info_Struct info = infos[i];
            if (null == info)
                continue;

            // 加个分隔符
            sb.append(TAB).append(SPLIT).append(Enter);

            sb.append(TAB).append((i + 1) + ".").append(info.toString()).append(Enter);
        }
        return sb.toString();
    }

    public static class ConstantPoolCount extends AbstractDataItem implements IReader
    {
        private byte[] count;

        @Override
        protected void init() {
            name = "constant_pool_count";
            length = 2;
            description = "常量池大小";
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
