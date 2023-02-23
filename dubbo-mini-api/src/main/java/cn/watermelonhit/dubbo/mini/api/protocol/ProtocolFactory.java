package cn.watermelonhit.dubbo.mini.api.protocol;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 协议工厂
 * @Author watermelonhit
 * @Date 2023/2/23 9:52
 */
@Component
public class ProtocolFactory {

    /**
     * 注入默认的http协议
     */
    @Resource
    private IProtocol hTTPProtocol;

    /**
     * 协议名称，默认采用基于tomcat的http协议。
     * 如果要扩展的话，可以实现IProtocal接口，并在init方法中将协议放入PROTOCOL_MAP中
     */
    private static String protocolName;

    public final static Map<String, IProtocol> PROTOCOL_MAP = new HashMap();

    @PostConstruct
    public void init() {
        PROTOCOL_MAP.put("http", hTTPProtocol);
    }

    /**
     * 读取test模块中配置文件中的协议名称
     *
     * @param protocolName
     */
    @Value("${dubbo-mini.protocolName}")
    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    /**
     * 向外界返回协议对象
     *
     * @return
     */
    public static IProtocol getProtocol() {
        if (protocolName == null || protocolName.equals("")) {
            protocolName = "http";
        }
        return PROTOCOL_MAP.get(protocolName);
    }
}
