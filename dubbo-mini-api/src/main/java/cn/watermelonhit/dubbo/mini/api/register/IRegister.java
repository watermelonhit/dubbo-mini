package cn.watermelonhit.dubbo.mini.api.register;

import cn.watermelonhit.dubbo.mini.api.model.URL;

import java.util.List;

/**
 * @Description 注册接口
 * @Author watermelonhit
 * @Date 2023/2/22 14:21
 */
public interface IRegister {
    void registLocal(String interfaceName, Class implClass);

    Class getLocal(String interfaceName);

    void registRemote(String interfaceName, URL url);

    List<URL> getRemote(String interfaceName);

}
