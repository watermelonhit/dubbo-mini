package cn.watermelonhit.dubbo.mini.api.util;

import cn.watermelonhit.dubbo.mini.api.model.URL;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Description 文件读写工具
 * @Author watermelonhit
 * @Date 2023/2/22 20:53
 */
public class FileUtils {

    public static final String FILE_PATH = "C:\\Users\\watermelonhit\\Desktop\\providers.txt";


    public static void saveProvidersFile(Map<String, List<URL>> providersInfo) {
        File file = createIfNotExist(FILE_PATH);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(providersInfo);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<URL>> getProvidersFile() {
        File file = createIfNotExist(FILE_PATH);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Map<String, List<URL>>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static File createIfNotExist(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
