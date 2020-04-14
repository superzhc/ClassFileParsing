package com.superz.classstruct;

import com.superz.AbstractDataItem;
import com.superz.IReader;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class MajorVersion extends AbstractDataItem implements IReader
{
    private byte[] version;

    @Override
    protected void init() {
        name = "major_version";
        length = 2;
        description = "主版本号";
    }

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        version = Common.subBytesArray(byteCodes, cursor, length);
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.toUpperCase()).append("(" + description + ")").append(":").append(Common.bytes2Dec(version));
        return sb.toString();
    }
}
