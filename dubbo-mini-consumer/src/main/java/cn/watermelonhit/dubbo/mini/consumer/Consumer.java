package cn.watermelonhit.dubbo.mini.consumer;

import cn.watermelonhit.dubbo.mini.api.proxy.ProxyFactory;
import cn.watermelonhit.dubbo.mini.rpc.interfaces.HelloService;
import org.springframework.stereotype.Component;


/**
 * @Description 服务调用方
 * @Author watermelonhit
 * @Date 2023/2/22 16:36
 */
@Component
public class Consumer {

    public void toUse() {
        // 获取代理类
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        // 调用接口方法，获取返回值
        String result = helloService.sayHello("watermelonhit");
        System.out.println("===========>" + result);
    }

}
