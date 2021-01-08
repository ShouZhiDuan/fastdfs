package com.nvxclouds.fastdfs.biz;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/23 12:36
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int i = 4;
        char[] chars = new char[i];
        System.out.println(chars);
        String s = new String(chars);
        System.out.println(s);
        s.replace('\0','n');
        System.out.println(s);

    }

}
