package com.superz.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 2020年04月14日 superz add
 */
public class Common
{
    /**
     * 获取类路径下的所有字节
     * @param classpath
     * @return
     * @throws Exception
     */
    public static List<Byte> getBytes(String classpath) throws Exception {
        List<Byte> byteCodes = null;
        try (InputStream in = new FileInputStream(classpath)) {
            byteCodes = new ArrayList<>();
            byte[] bytes = new byte[1024];
            int bs = 0;
            while ((bs = in.read(bytes)) != -1) {
                for (byte b : bytes) {
                    byteCodes.add(b);
                }
            }
        }
        return byteCodes;
    }

    /**
     * 获取子字节
     * @param bytes
     * @param start
     * @param length
     * @return
     */
    public static List<Byte> subBytes(List<Byte> bytes, int start, int length) {
        List<Byte> bs = new ArrayList<>();
        int i = 0;
        while (i < length) {
            bs.add(bytes.get(start + i));
            i++;
        }
        return bs;
    }

    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }
}
