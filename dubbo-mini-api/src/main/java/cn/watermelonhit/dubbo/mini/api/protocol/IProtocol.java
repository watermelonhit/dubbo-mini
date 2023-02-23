package cn.watermelonhit.dubbo.mini.api.protocol;

import cn.watermelonhit.dubbo.mini.api.model.Invocation;
import cn.watermelonhit.dubbo.mini.api.model.URL;

/**
 * @Description 协议接口
 * @Author watermelonhit
 * @Date 2023/2/23 9:48
 */
public interface IProtocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
