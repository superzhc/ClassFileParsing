package com.superz.classstruct;

import com.superz.AbstractDataItem;

/**
 * 魔数
 * 2020年04月14日 superz add
 */
public class Magic extends AbstractDataItem
{
    @Override
    protected void init() {
        name = "magic";
        length = 4;
        description = "魔数，固定：0x CAFE BABE";
    }
}
