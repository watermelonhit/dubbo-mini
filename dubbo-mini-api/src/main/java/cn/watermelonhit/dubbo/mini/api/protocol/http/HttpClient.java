package cn.watermelonhit.dubbo.mini.api.protocol.http;

import cn.watermelonhit.dubbo.mini.api.model.Invocation;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/22 16:25
 */

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {
        try {

            // 建立http连接
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            // 参数调用信息
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            // 同步获取结果
            InputStream inputStream = httpURLConnection.getInputStream();
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            String result = (String) stream.readObject();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
