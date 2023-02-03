package system_design;

import java.net.InetAddress;

public class DNSSample {
    public static void main(String args[]) throws Exception {
        InetAddress address = InetAddress.getByName("yingjiang-I7");// wxh-PC是我的计算机名
        System.out.println(address);
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println(address1);
        System.out.println("-----");

        InetAddress[] addresses = InetAddress
                .getAllByName("www.baidu.com");
        System.out.println(addresses.length);
        for (InetAddress addr : addresses) {
            System.out.println(addr);
        }
        System.out.println("-----");

        addresses = InetAddress
                .getAllByName("www.microsoft.com");
        System.out.println(addresses.length);
        for (InetAddress addr : addresses) {
            System.out.println(addr);
        }
    }
}
