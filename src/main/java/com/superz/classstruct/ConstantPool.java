package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class ConstantPool extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "constant_pool";
        description = "常量池";
    }

    public static class ConstantPoolCount extends AbstractDataItem
    {

        @Override
        protected void init() {
            name = "constant_pool_count";
            length = 2;
            description = "常量池大小";
        }
    }
}
