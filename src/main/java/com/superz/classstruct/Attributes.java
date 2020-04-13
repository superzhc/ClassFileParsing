package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class Attributes extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "attributes";
        description = "属性集合";
    }

    public static class AttributesCount extends AbstractDataItem
    {
        @Override
        protected void init() {
            name = "attributes_count";
            length = 2;
            description = "属性计数器";
        }
    }
}
