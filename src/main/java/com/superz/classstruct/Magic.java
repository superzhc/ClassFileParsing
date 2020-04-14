package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.util.Common;

import java.util.List;

/**
 * 魔数
 * 2020年04月14日 superz add
 */
public class Magic extends AbstractDataItem implements IReader
{
    private byte[] magic;

    @Override
    protected void init() {
        name = "magic";
        length = 4;
        description = "魔数";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        magic = Common.subBytesArray(byteCodes, cursor, length);
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(description).append(":").append(Common.bytes2Hex(magic));
        return sb.toString();
    }
}
