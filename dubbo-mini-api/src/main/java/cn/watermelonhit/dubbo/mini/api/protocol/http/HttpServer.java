package cn.watermelonhit.dubbo.mini.api.protocol.http;

import cn.watermelonhit.dubbo.mini.api.model.URL;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/22 16:27
 */
@Component
public class HttpServer {
    
    @Resource(name = "myDispatcherServlet")
    private DispatcherServlet dispatcherServlet;

    public void start(URL url) {

        String hostname = url.getHostname();
        Integer port = url.getPort();

        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);

        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostname);

        Host host = new StandardHost();
        host.setName(hostname);

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        // 绑定servlet进行处理，tomcat接收到http请求后，就转发给DispatcherServlet进行处理
        tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
