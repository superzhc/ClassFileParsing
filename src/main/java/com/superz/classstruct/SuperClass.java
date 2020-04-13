package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class SuperClass extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "super_class";
        length = 2;
        description = "父类索引";
    }
}
