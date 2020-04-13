package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 2020年04月14日 superz add
 */
public class MajorVersion extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "major_version";
        length = 2;
        description = "主版本号";
    }
}
