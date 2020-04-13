package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class AccessFlags extends AbstractDataItem
{
    @Override protected void init() {
        name="access_flags";
        length=2;
        description="访问标志";
    }
}
