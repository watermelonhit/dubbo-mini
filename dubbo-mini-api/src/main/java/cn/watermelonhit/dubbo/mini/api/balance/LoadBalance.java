package cn.watermelonhit.dubbo.mini.api.balance;

import cn.watermelonhit.dubbo.mini.api.model.URL;

import java.util.List;

/**
 * @Description 负载均衡接口
 * @Author watermelonhit
 * @Date 2023/2/23 9:30
 */
public interface LoadBalance {

    URL getInstance(List<URL> urlList);
}
