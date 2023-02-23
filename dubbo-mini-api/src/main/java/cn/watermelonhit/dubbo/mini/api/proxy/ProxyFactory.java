package cn.watermelonhit.dubbo.mini.api.proxy;

import cn.watermelonhit.dubbo.mini.api.balance.LoadBalance;
import cn.watermelonhit.dubbo.mini.api.model.Invocation;
import cn.watermelonhit.dubbo.mini.api.model.URL;
import cn.watermelonhit.dubbo.mini.api.protocol.IProtocol;
import cn.watermelonhit.dubbo.mini.api.protocol.ProtocolFactory;
import cn.watermelonhit.dubbo.mini.api.register.IRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Description 代理工厂
 * @Author watermelonhit
 * @Date 2023/2/22 17:03
 */
@Component
public class ProxyFactory {


    private static LoadBalance randomBalance;

    private static IRegister remoteRegister;

    @Autowired
    public ProxyFactory(LoadBalance loadBalance, IRegister remoteRegister) {
        ProxyFactory.randomBalance = loadBalance;
        ProxyFactory.remoteRegister = remoteRegister;
    }

    /**
     * 当服务调用方调用接口方法时，就会自动执行该方法（动态代理）
     * （1）在此方法中会获取相应的协议
     * （2）然后向注册中心拉取服务方的地址信息
     * （3）其次向服务方发起调用信息
     * （4）最后向服务调用方返回结果
     *
     * @param interfaceClass 接口类
     * @param <T>
     * @return
     */
    public static <T> T getProxy(final Class interfaceClass) {
        Object newProxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                IProtocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                List<URL> urlList = remoteRegister.getRemote(interfaceClass.getName());
                URL url = randomBalance.getInstance(urlList);
                String result = protocol.send(url, invocation);
                return result;
            }
        });
        return (T) newProxyInstance;
    }
}
