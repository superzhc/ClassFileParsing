package com.superz.classstruct;

import java.util.List;

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
        int count = Common.bytes2Dec(fields_count.count);

        for (int i = 0; i < count; i++) {

        }

        return offset;
    }

    public static class FieldsCount extends AbstractDataItem implements IReader
    {
        private byte[] count;

        @Override
        protected void init() {
            name = "fields_count";
            length = 2;
            description = "字段个数";
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
