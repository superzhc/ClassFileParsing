package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class Interfaces extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "interfaces";
        description = "接口索引集合";
    }

    public static class InterfacesCount extends AbstractDataItem
    {
        @Override
        protected void init() {
            name = "interfaces_count";
            length = 2;
            description = "接口计数器";
        }
    }
}
