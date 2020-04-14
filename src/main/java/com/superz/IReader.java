package com.superz;

import java.util.List;

public interface IReader
{
    int read(final List<Byte> byteCodes,final int cursor);

    /**
     * 添加个打印
     */
    default void print(){
        System.out.println(this.toString());
    }
}
