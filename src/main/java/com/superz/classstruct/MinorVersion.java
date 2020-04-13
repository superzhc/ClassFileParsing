package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class MinorVersion extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "minor_version";
        length = 2;
        description = "次版本号";
    }
}
