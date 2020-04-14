package com.superz;

import com.superz.classstruct.*;
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

        // 访问标志
        AccessFlags accessFlags = new AccessFlags();
        offset = accessFlags.read(byteCodes, cursor);
        accessFlags.print();
        cursor += offset;

        // 类索引
        ThisClass thisClass = new ThisClass();
        offset = thisClass.read(byteCodes, cursor);
        thisClass.print();
        cursor += offset;

        // 父类索引
        SuperClass superClass = new SuperClass();
        offset = superClass.read(byteCodes, cursor);
        superClass.print();
        cursor += offset;

        // 接口索引
        Interfaces interfaces = new Interfaces();
        offset = interfaces.read(byteCodes, cursor);
        interfaces.print();
        cursor += offset;
    }
}
