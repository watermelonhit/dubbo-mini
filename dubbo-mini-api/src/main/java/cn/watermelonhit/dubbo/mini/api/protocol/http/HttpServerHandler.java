package cn.watermelonhit.dubbo.mini.api.protocol.http;

import cn.watermelonhit.dubbo.mini.api.model.Invocation;
import cn.watermelonhit.dubbo.mini.api.register.IRegister;
import cn.watermelonhit.dubbo.mini.api.register.impl.LocalRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description http请求处理器
 * @Author watermelonhit
 * @Date 2023/2/22 16:27
 */
@Component
public class HttpServerHandler {

    @Resource
    private IRegister localRegister;

    public void handler(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        InputStream inputStream = req.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        // 读取调用信息
        Invocation invocation = (Invocation) ois.readObject();
        Class implClass = localRegister.getLocal(invocation.getInterfaceName());
        Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());

        // 调用方法
        String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

        // 写回结果
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(resp.getOutputStream());
        objectOutputStream.writeObject(result);
        objectOutputStream.flush();
        objectOutputStream.close();

    }
}
