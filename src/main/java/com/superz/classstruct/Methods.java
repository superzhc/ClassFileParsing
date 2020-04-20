package com.superz.classstruct;

import java.util.List;

import com.superz.*;
import com.superz.struct.MethodStruct;
import com.superz.util.Common;

/**
 * 2020年04月14日 superz add
 */
public class Methods extends AbstractMultiDataItem
{
    @Override
    protected void init() {
        name = "methods";
        description = "方法集合";
    }

    @Override protected AbstractCountDataItem initCountDataItem() {
        return new MethodsCount();
    }

    @Override protected AbstractStruct initStruct() {
        return new MethodStruct();
    }

    public static class MethodsCount extends AbstractCountDataItem
    {
        @Override
        protected void init() {
            name = "methods_count";
            length = 2;
            description = "方法个数";
        }
    }
}
