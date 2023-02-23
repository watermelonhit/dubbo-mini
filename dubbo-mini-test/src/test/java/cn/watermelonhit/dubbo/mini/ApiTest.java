package cn.watermelonhit.dubbo.mini;


import cn.watermelonhit.dubbo.mini.consumer.Consumer;
import cn.watermelonhit.dubbo.mini.provider.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description
 * @Author watermelonhit
 * @Date 2023/2/23 10:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ApiTest {


    @Resource
    private Provider provider;
    @Resource
    private Consumer consumer;

    @Test
    public void start() {
        provider.toStart();
    }

    @Test
    public void consumer() {
        consumer.toUse();
    }

}
