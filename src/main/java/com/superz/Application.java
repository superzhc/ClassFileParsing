package com.superz;

import com.superz.classstruct.Magic;
import com.superz.util.Common;

import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class Application
{
    public static void main(String[] args) throws Exception {
        if (args.length < 1)
            throw new RuntimeException("请输入待解析的文件");

        String classpath = args[0];
        List<Byte> byteCodes = Common.getBytes(classpath);

        // 定义游标
        int cursor = 0;
        Magic magic = new Magic();
        int offset = magic.read(byteCodes, cursor);
        System.out.println(magic.toString());
        cursor += offset;
    }
}
