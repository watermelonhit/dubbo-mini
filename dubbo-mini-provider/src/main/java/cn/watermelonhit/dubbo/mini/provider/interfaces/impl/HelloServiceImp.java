package cn.watermelonhit.dubbo.mini.provider.interfaces.impl;


import cn.watermelonhit.dubbo.mini.rpc.interfaces.HelloService;

/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/22 15:54
 */
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "provider say: "+userName+" hello!";
    }
}
