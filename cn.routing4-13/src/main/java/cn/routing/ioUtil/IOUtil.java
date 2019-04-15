package cn.routing.ioUtil;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lulu
 * @date 2019-04-08 18:35
 */
public class IOUtil {
    /**
     * 读取文件并按行输出
     *
     * @param filePath
     * @param spec     允许解析的最大行数， spec==null时，解析所有行
     * @return
     * @author Lulu
     * @version 2019-3-27
     */
    public static String[] read(final String filePath, final Integer spec) {
        File file = new File(filePath);
        /**
         *当文件不存在或者不可读时
         */
        if ((!isFileExists(file)) || (!file.canRead())) {
            System.out.println("file " + filePath + " is not exist or cannot read!!!");
            return null;
        }

        List<String> lines = new LinkedList<>();
        try (FileReader fb = new FileReader(file); BufferedReader br = new BufferedReader(fb)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                lines.add(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successful file" + filePath + " reading!!!");
        if (lines.get(lines.size() - 1).equals("")) {
            lines.remove(lines.size() - 1);

        }

        return lines.toArray(new String[lines.size()]);
    }


    /**
     *
     * @param filePath 输出文件路径
     * @param contents 要写入的内容
     * @param append 是否追加
     */
    public static void write(final String filePath, final String[] contents, final boolean append) {
        File file = new File(filePath);
        if (contents == null) {
            System.out.println("file " + filePath + " invalid!!!");

        }

        /**
         * 当文件存在但不可写时
         */
        if (isFileExists(file) && (!file.canRead())) {
            System.out.println("file [" + filePath + "] is readonly!!!");
        }
        try (FileWriter fw = new FileWriter(file, append); BufferedWriter bw = new BufferedWriter(fw);) {
            if (!isFileExists(file)) {
                file.createNewFile();
            }
            for (String content : contents) {
                if (content == null) {
                    continue;
                }
                bw.write(content);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println("Successful file " + filePath + " writing!!!");
    }


    private static boolean isFileExists(final File file) {
        if (file.exists() && file.isFile()) {
            return true;
        }

        return false;
    }

}
