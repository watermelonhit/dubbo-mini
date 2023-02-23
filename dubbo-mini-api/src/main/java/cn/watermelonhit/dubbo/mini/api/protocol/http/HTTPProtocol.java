package cn.watermelonhit.dubbo.mini.api.protocol.http;

import cn.watermelonhit.dubbo.mini.api.model.Invocation;
import cn.watermelonhit.dubbo.mini.api.model.URL;
import cn.watermelonhit.dubbo.mini.api.protocol.IProtocol;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/23 9:50
 */
@Component
public class HTTPProtocol implements IProtocol {

    @Resource
    private HttpServer httpServer;

    @Override
    public void start(URL url) {
        httpServer.start(url);
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
    }
}
