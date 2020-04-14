package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class ThisClass extends AbstractDataItem implements IReader
{
    private byte[] bytes;

    @Override
    protected void init() {
        name = "this_class";
        length = 2;
        description = "类索引";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        bytes = Common.subBytesArray(byteCodes, cursor, length);
        return length;
    }

    @Override public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(name.toUpperCase()).append("("+description+")").append(":").append(Common.bytes2Dec(bytes));
        return sb.toString();
    }
}
