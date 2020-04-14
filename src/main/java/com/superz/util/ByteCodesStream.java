package com.superz.util;

import com.superz.IReader;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class ByteCodesStream
{
    /* 文件地址 */
    private String path;
    /* 获取的字节列表 */
    private List<Byte> byteCodes;
    /* 当前游标 */
    private int cursor = 0;

    public ByteCodesStream(String path) {
        this.path = path;
        init();
    }

    private void init() {
        try {
            byteCodes = Common.getBytes(path);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String read(IReader reader) {
        int offset = reader.read(byteCodes, cursor);
        cursor += offset;
        return reader.toString();
    }

    public String readAndPrint(IReader reader) {
        String content = read(reader);
        reader.print();
        return content;
    }

    public List<Byte> getByteCodes() {
        return byteCodes;
    }

    public int getCursor() {
        return cursor;
    }
}
