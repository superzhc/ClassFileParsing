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

    public AbstractDataItem(){
        init();
    }

    protected abstract void init();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
