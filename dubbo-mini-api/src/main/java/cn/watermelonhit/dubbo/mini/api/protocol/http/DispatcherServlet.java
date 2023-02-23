package cn.watermelonhit.dubbo.mini.api.protocol.http;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Description 处理请求的servlet
 * @Author watermelonhit
 * @Date 2023/2/22 16:25
 */
@Component("myDispatcherServlet")
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 6367781122331203400L;
    @Resource
    private HttpServerHandler httpServerHandler;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            httpServerHandler.handler(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
