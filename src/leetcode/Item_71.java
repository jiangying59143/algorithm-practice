package leetcode;

import java.util.LinkedList;

public class Item_71 {
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        String[] dbLinkedQueue = new String[paths.length];
        int size = 0;
        for (int i = 0; i < paths.length; i++) {
            if("..".equals(paths[i])){
                if(size > 0) {
                    size--;
                }
            }else if(!".".equals(paths[i]) && !"".equals(paths[i])){
                dbLinkedQueue[size++]=paths[i];
            }
        }
        if(size <= 0){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("/").append(dbLinkedQueue[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path;
        path = "/home/";
        System.out.println(simplifyPath(path));
        path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
        path = "/../";
        System.out.println(simplifyPath(path));
        path = "/home//foo/";
        System.out.println(simplifyPath(path));
        path = "/a/../../b/../c//.//";
        System.out.println(simplifyPath(path));
    }
}
