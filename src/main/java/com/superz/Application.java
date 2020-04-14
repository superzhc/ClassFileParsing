package com.superz;

import com.superz.classstruct.ConstantPool;
import com.superz.classstruct.Magic;
import com.superz.classstruct.MajorVersion;
import com.superz.classstruct.MinorVersion;
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

        // 魔数
        Magic magic = new Magic();
        int offset = magic.read(byteCodes, cursor);
        // System.out.println(magic.toString());
        magic.print();
        cursor += offset;

        // 次版本号
        MinorVersion minor_version = new MinorVersion();
        offset = minor_version.read(byteCodes, cursor);
        minor_version.print();
        cursor += offset;

        // 主版本号
        MajorVersion major_version = new MajorVersion();
        offset = major_version.read(byteCodes, cursor);
        major_version.print();
        cursor += offset;

        // 常量池
        ConstantPool constant_pool = new ConstantPool();
        offset = constant_pool.read(byteCodes, cursor);
        constant_pool.print();
        cursor += offset;
    }
}
