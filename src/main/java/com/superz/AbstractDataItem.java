package com.superz;

/**
 * 2020年04月14日 superz add
 */
public abstract class AbstractDataItem
{
    /* 数据项名称 */
    protected String name;
    /* 数据项占用的字节 */
    protected int length;
    /* 数据项描述 */
    protected String description;

    protected abstract void init();
}
