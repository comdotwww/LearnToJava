package com.moeau.network.study.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址 /*返回一个自身对象*/
            InetAddress inetAddresses1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddresses1);
            InetAddress inetAddresses3 = InetAddress.getByName("localhost");
            System.out.println(inetAddresses3);
            InetAddress inetAddresses4 = InetAddress.getByName("localhost");
            System.out.println(inetAddresses4);

            //查询网站 IP 地址
            InetAddress inetAddresses2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddresses2);

            //常用方法
            System.out.println(inetAddresses2.getAddress());
            System.out.println(inetAddresses2.getCanonicalHostName());
            System.out.println(inetAddresses2.getHostAddress());
            System.out.println(inetAddresses2.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
