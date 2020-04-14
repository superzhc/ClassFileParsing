package com.superz;

import com.superz.classstruct.*;
import com.superz.util.ByteCodesStream;

/**
 * 2020年04月14日 superz add
 */
public class Application
{
    public static void main(String[] args) {
        if (args.length < 1)
            throw new RuntimeException("请输入待解析的文件");

        String classpath = args[0];
        ByteCodesStream byteCodesStream = new ByteCodesStream(classpath);

        // 魔数
        Magic magic = new Magic();
        byteCodesStream.readAndPrint(magic);

        // 次版本号
        MinorVersion minor_version = new MinorVersion();
        byteCodesStream.readAndPrint(minor_version);

        // 主版本号
        MajorVersion major_version = new MajorVersion();
        byteCodesStream.readAndPrint(major_version);

        // 常量池
        ConstantPool constant_pool = new ConstantPool();
        byteCodesStream.readAndPrint(constant_pool);

        // 访问标志
        AccessFlags accessFlags = new AccessFlags();
        byteCodesStream.readAndPrint(accessFlags);

        // 类索引
        ThisClass thisClass = new ThisClass();
        byteCodesStream.readAndPrint(thisClass);

        // 父类索引
        SuperClass superClass = new SuperClass();
        byteCodesStream.readAndPrint(superClass);

        // 接口索引
        Interfaces interfaces = new Interfaces();
        byteCodesStream.readAndPrint(interfaces);

        // 字段集合
        Fields fields = new Fields();
        byteCodesStream.readAndPrint(fields);
    }
}
