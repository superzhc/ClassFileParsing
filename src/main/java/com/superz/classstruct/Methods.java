package com.superz.classstruct;

import java.util.List;

import com.superz.AbstractCountDataItem;
import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.struct.MethodStruct;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public class Methods extends AbstractDataItem implements IReader
{
    private MethodsCount methodsCount;
    private MethodStruct[] methods;

    @Override
    protected void init() {
        name = "methods";
        description = "方法集合";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        methodsCount = new MethodsCount();
        offset = methodsCount.read(byteCodes, cursor);

        // 字段集合开始的游标
        int field_cursor = cursor + offset;

        // 字段数量
        int count = Common.bytes2Dec(methodsCount.getCount());

        // 初始化字段容器
        methods = new MethodStruct[count];
        for (int i = 0; i < count; i++) {
            MethodStruct method = new MethodStruct();
            int offset1 = method.read(byteCodes, field_cursor);
            methods[i] = method;

            offset += offset1;
            field_cursor += offset1;
        }

        return offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(methodsCount.toString());
        for (int i = 0, len = methods.length; i < len; i++) {
            MethodStruct method = methods[i];
            sb.append(method.toString());
            sb.append("--------------------------");
        }
        return sb.toString();
    }

    public static class MethodsCount extends AbstractCountDataItem
    {
        @Override
        protected void init() {
            name = "methods_count";
            length = 2;
            description = "方法个数";
        }
    }
}
