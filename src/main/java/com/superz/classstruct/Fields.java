package com.superz.classstruct;

import com.superz.AbstractCountDataItem;
import com.superz.AbstractMultiDataItem;
import com.superz.AbstractStruct;
import com.superz.struct.FieldStruct;

/**
 * 2020年04月14日 superz add
 */
public class Fields extends AbstractMultiDataItem
{
    @Override
    protected void init() {
        name = "fields";
        description = "字段集合";
    }

    @Override
    protected AbstractCountDataItem initCountDataItem() {
        return new FieldsCount();
    }

    @Override
    protected AbstractStruct initStruct() {
        return new FieldStruct();
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
