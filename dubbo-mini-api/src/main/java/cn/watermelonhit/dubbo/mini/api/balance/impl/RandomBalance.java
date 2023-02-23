package cn.watermelonhit.dubbo.mini.api.balance.impl;

import cn.watermelonhit.dubbo.mini.api.balance.LoadBalance;
import cn.watermelonhit.dubbo.mini.api.model.URL;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @Description 随机负载均衡
 * @Author watermelonhit
 * @Date 2023/2/23 9:31
 */
@Component
public class RandomBalance implements LoadBalance {
    @Override
    public URL getInstance(List<URL> urlList) {
        int index = new Random().nextInt(urlList.size());
        return urlList.get(index);
    }
}
