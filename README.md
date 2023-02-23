## 项目简述

&nbsp;&nbsp;一个简洁迷你版的dubbo，通过该迷你版dubbo，你可以清楚地了解到rpc框架的大致原理，如服务调用方调用接口方法名后如何获取到数据，而服务提供方是如何接收数据并返回的。本项目将通过源码带你清晰地了解这些中间过程。

&nbsp;&nbsp;此外，本项目点到为止，为了便于大家理解和学习，并没有涉及到很深入的层面。读者可以以此作为铺垫，若有兴趣的话可以去dubbo官网或阅读dubbo源码进行深入学习。

## 项目功能

- 动态代理服务调用方，屏蔽底层细节，完成向服务端发起请求；
- 简单封装使用http协议进行消息的传输。可扩展性号，可以自定义协议进行传输；
- 简单实现负载均衡，可自行实现接口；
- 基于本地文件来模拟向远程注册中心进行注册，可以自行实现接口基于zookeeper/redis来搭建注册中心；

## 项目结构

- dubbo-mini
    - dubbo-mini-api ：dubbo主体内容模块
        - balance：负载均衡
        - model：模型对象
        - protocol：传输协议
        - proxy：动态代理
        - register：注册中心
        - util： 工具包
    - dubbo-mini-consumer：服务调用方模块
    - dubbo-mini-provider：服务提供方模块
    - dubbo-mini-rpc：rpc接口模块
    - dubbo-mini-test：测试及配置中心模块

整体上，代码结构划分比较清晰，不同模块对应了不同的对象。在设计时，尽可能做到模块之间相互独立。

**模块之间的引用关系：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/3b6928f3836d413bb925db1b63776e8a.png#pic_center)

## 快速开始

1. 拉取项目到本地
2. 加载maven依赖
3. 运行test模块中的测试方法，先运行start方法，再运行consumer方法。

正常运行结果：

 ```java
 // 消费端控制台会打印
===========>provider say:watermelonhit hello!

 ```
 
## 详细介绍
[请查看本篇博客](http://watermelonhit.cn:9014/#/view/1628696981703110657)
