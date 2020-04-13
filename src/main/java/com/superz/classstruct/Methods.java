package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class Methods extends AbstractDataItem
{
    @Override protected void init() {
        name="methods";
        description="方法集合";
    }

    public static class MethodsCount extends AbstractDataItem{
        @Override protected void init() {
            name="methods_count";
            length=2;
            description="方法个数";
        }
    }
}
