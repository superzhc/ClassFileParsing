package com.superz.classstruct;

import com.superz.AbstractCountDataItem;
import com.superz.AbstractMultiDataItem;
import com.superz.AbstractStruct;
import com.superz.struct.AttributeStruct;

/**
 * 2020年04月14日 superz add
 */
public class Attributes extends AbstractMultiDataItem
{
    @Override
    protected void init() {
        name = "attributes";
        description = "属性集合";
    }

    @Override
    protected AbstractCountDataItem initCountDataItem() {
        return new AttributesCount();
    }

    @Override
    protected AbstractStruct initStruct() {
        return new AttributeStruct();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(countDataItem.toString());
        for (int i = 0, len = structs.length; i < len; i++) {
            AbstractStruct struct = structs[i];
            sb.append(TAB).append(TAB).append((i + 1) + ".").append(struct.toString());
        }
        return sb.toString();
    }

    public static class AttributesCount extends AbstractCountDataItem
    {
        @Override
        protected void init() {
            name = "attributes_count";
            length = 2;
            description = "属性计数器";
        }
    }
}
