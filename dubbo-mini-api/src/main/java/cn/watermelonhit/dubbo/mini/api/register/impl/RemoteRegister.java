package cn.watermelonhit.dubbo.mini.api.register.impl;

import cn.watermelonhit.dubbo.mini.api.model.URL;
import cn.watermelonhit.dubbo.mini.api.register.RegisterConfig;
import cn.watermelonhit.dubbo.mini.api.util.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Description 远程注册中心（模拟），通过读写本地文件来实现。
 * 可以通过zookeeper并继承RegisterConfig重写相应的方法来自定义一个远程注册中心
 * @Author watermelonhit
 * @Date 2023/2/22 15:33
 */
@Service
public class RemoteRegister extends RegisterConfig {

    @Override
    public void registRemote(String interfaceName, URL url) {

        List<URL> urls = remoteMap.getOrDefault(interfaceName, new ArrayList<>());
        urls.add(url);
        remoteMap.put(interfaceName, urls);

        FileUtils.saveProvidersFile(remoteMap);
    }

    @Override
    public List<URL> getRemote(String interfaceName) {
        Map<String, List<URL>> providersFile = FileUtils.getProvidersFile();
        remoteMap = providersFile;
        return remoteMap.get(interfaceName);
    }

}
