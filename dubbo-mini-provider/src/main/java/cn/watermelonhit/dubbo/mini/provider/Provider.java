package cn.watermelonhit.dubbo.mini.provider;

import cn.watermelonhit.dubbo.mini.api.model.URL;
import cn.watermelonhit.dubbo.mini.api.protocol.IProtocol;
import cn.watermelonhit.dubbo.mini.api.protocol.ProtocolFactory;
import cn.watermelonhit.dubbo.mini.api.protocol.http.HttpServer;
import cn.watermelonhit.dubbo.mini.api.register.IRegister;
import cn.watermelonhit.dubbo.mini.api.register.impl.LocalRegister;
import cn.watermelonhit.dubbo.mini.api.register.impl.RemoteRegister;
import cn.watermelonhit.dubbo.mini.provider.interfaces.impl.HelloServiceImp;
import cn.watermelonhit.dubbo.mini.rpc.interfaces.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/22 14:20
 */
@Component
public class Provider {

    @Resource
    private LocalRegister localRegister;

    @Resource
    private IRegister remoteRegister;

    @Resource
    private ProtocolFactory protocolFactory;

    public void toStart() {

        //1 本地注册
        //{服务名：实现类}
        localRegister.registLocal(HelloService.class.getName(), HelloServiceImp.class);

        //2 远程注册中心
        //{服务名：list<URL>}
        URL url = new URL("localhost", 8080);
        remoteRegister.registRemote(HelloService.class.getName(), url);

        //3 读取配置，按配置启动服务器
        IProtocol protocol = protocolFactory.getProtocol();
        protocol.start(url);

    }

}
