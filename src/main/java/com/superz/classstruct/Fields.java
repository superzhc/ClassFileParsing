package com.superz.classstruct;

import java.util.List;

import com.superz.AbstractCountDataItem;
import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.struct.FieldStruct;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public class Fields extends AbstractDataItem implements IReader
{
    private FieldsCount fields_count;
    private FieldStruct[] fields;

    @Override
    protected void init() {
        name = "fields";
        description = "字段集合";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        fields_count = new FieldsCount();
        offset = fields_count.read(byteCodes, cursor);

        // 字段集合开始的游标
        int field_cursor = cursor + offset;

        // 字段数量
        int count = Common.bytes2Dec(fields_count.getCount());

        // 初始化字段容器
        fields = new FieldStruct[count];
        for (int i = 0; i < count; i++) {
            FieldStruct field = new FieldStruct();
            int offset1 = field.read(byteCodes, field_cursor);
            fields[i] = field;

            offset += offset1;
            field_cursor += offset1;
        }

        return offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(fields_count.toString());
        for (int i = 0, len = fields.length; i < len; i++) {
            FieldStruct field = fields[i];
            sb.append(field.toString());
            sb.append("--------------------------");
        }
        return sb.toString();
    }

    public static class FieldsCount extends AbstractCountDataItem
    {
        @Override
        protected void init() {
            name = "fields_count";
            length = 2;
            description = "字段个数";
        }
    }
}
