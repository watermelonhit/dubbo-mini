package cn.watermelonhit.dubbo.mini.api.register;

import cn.watermelonhit.dubbo.mini.api.model.URL;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 注册中心
 * @Author watermelonhit
 * @Date 2023/2/22 14:25
 */
public abstract class RegisterConfig implements IRegister {

    /**
     * 本地注册表
     */
    protected static Map<String, Class> localMap = new ConcurrentHashMap<>();

    /**
     * 远程注册表
     */
    protected static Map<String, List<URL>> remoteMap = new ConcurrentHashMap<>();

    @Override
    public void registLocal(String interfaceName, Class implClass) {
    }

    @Override
    public Class getLocal(String interfaceName) {
        return null;
    }

    @Override
    public void registRemote(String interfaceName, URL url) {
    }

    @Override
    public List<URL> getRemote(String interfaceName) {
        return null;
    }
}
