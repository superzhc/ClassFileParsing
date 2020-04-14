package com.superz;

import java.util.List;

import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public abstract class AbstractMultiDataItem extends AbstractDataItem implements IReader
{
    protected AbstractCountDataItem countDataItem;
    protected AbstractStruct[] structs;

    @Override
    public int read(List<Byte> byteCodes, int cursor) {
        int offset = 0;

        countDataItem = initCountDataItem();
        offset = countDataItem.read(byteCodes, cursor);

        // 开始的游标
        int new_cursor = cursor + offset;

        // 获取元素的数量
        int count = getCount();
        structs = new AbstractStruct[count];
        for (int i = 0; i < count; i++) {
            AbstractStruct abstractStruct = initStruct();
            int offset1 = abstractStruct.read(byteCodes, new_cursor);
            structs[i] = abstractStruct;

            offset += offset1;
            new_cursor += offset1;
        }

        return offset;
    }

    protected int getCount() {
        return Common.bytes2Dec(countDataItem.getCount());
    }

    protected abstract AbstractCountDataItem initCountDataItem();

    protected abstract AbstractStruct initStruct();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SPLIT).append(Enter);
        sb.append(countDataItem.toString());
        for (int i = 0, len = structs.length; i < len; i++) {
            AbstractStruct struct = structs[i];
            sb.append(TAB).append(SPLIT).append(Enter);
            sb.append(TAB).append((i + 1) + ".").append(struct.toString());
        }
        return sb.toString();
    }
}
