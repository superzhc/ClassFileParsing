package com.superz;

import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public abstract class AbstractCountDataItem extends AbstractDataItem implements IReader
{
    protected byte[] count;

    public byte[] getCount() {
        return count;
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
