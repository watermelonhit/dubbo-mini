package cn.watermelonhit.dubbo.mini.api.register.impl;


import cn.watermelonhit.dubbo.mini.api.register.RegisterConfig;
import org.springframework.stereotype.Service;


/**
 * @Description 本地注册中心
 * @Author watermelonhit
 * @Date 2023/2/22 14:22
 */
@Service
public class LocalRegister extends RegisterConfig {
    @Override
    public void registLocal(String interfaceName, Class implClass) {
        super.localMap.put(interfaceName, implClass);
    }

    @Override
    public Class getLocal(String interfaceName) {
        return localMap.get(interfaceName);
    }
}
