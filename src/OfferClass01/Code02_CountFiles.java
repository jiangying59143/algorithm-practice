package OfferClass01;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 给定一个文件目录的路径，写一个函数统计这个目录下所有的文件数量并返回，隐藏文件也算，但是文件夹不算
 */
public class Code02_CountFiles {

    public static int countFile(File file){
        if(!file.exists()){
            return 0;
        }

        if(file.isFile()){
            return 1;
        }
        File[] subfiles = file.listFiles();
        int count = 0;
        for (File subfile : subfiles) {
            count +=countFile(subfile);
        }
        return count;
    }

    public static int countFileStack(File file){
        if(!file.exists()){
            return 0;
        }

        if(file.isFile()){
            return 1;
        }

        LinkedList<File> stack = new LinkedList<>();
        stack.push(file);
        int count = 0;
        while(!stack.isEmpty()){
            File curFile = stack.pop();
            if(curFile.isFile()){
                count++;
                continue;
            }
            File[] subfiles = curFile.listFiles();
            int subCount=0;
            for (File subfile : subfiles) {
                if(subfile.isFile()){
//                    System.out.println(subfile.getAbsolutePath());
                    subCount++;
                }else{
                    stack.push(subfile);
                }
            }
            count += subCount;
        }
        return count;
    }

    public static int countFileQueue(File file){
        if(!file.exists()){
            return 0;
        }

        if(file.isFile()){
            return 1;
        }

        LinkedList<File> queue = new LinkedList<>();
        queue.add(file);
        int count = 0;
        while(!queue.isEmpty()){
            File curFile = queue.poll();
            if(curFile.isFile()){
                count++;
                continue;
            }
            File[] subfiles = curFile.listFiles();
            int subCount=0;
            for (File subfile : subfiles) {
                if(subfile.isFile()){
                    subCount++;
                    System.out.println(subfile.getAbsolutePath());
                }else{
                    queue.add(subfile);
                }
            }
            count += subCount;
        }
        return count;
    }

    public static File generateFiles() throws IOException {
        File root = new File("test_1");
        if(!root.exists() || !root.isDirectory()){
            root.mkdir();
        }

        LinkedList<File> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            File curFile = queue.poll();
            String[] names = curFile.getName().split("_");
            int curIndex = Integer.parseInt(names[1]);
            for (int i = 1; i <= 10; i++) {
                File file = new File(curFile.getAbsolutePath() + "/test_" + curIndex + "" + i);
                if(file.exists()){
                    if(file.isDirectory()){
                        queue.add(file);
                    }
                    continue;
                }
                if(i==1 || i==10) {
                    file.mkdir();
                    queue.add(file);
                }else{
                    file.createNewFile();
                }
            }
            if(curIndex == 1101010) break;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        File file = generateFiles();
        System.out.println(countFile(file));
        System.out.println(countFileStack(file));
        System.out.println(countFileQueue(file));
    }
}
