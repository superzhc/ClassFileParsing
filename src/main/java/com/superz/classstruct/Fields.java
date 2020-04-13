package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class Fields extends AbstractDataItem
{
    @Override protected void init() {
        name="fields";
        description="字段集合";
    }

    public static class FieldsCount extends AbstractDataItem{
        @Override protected void init() {
            name="fields_count";
            length=2;
            description="字段个数";
        }
    }
}
