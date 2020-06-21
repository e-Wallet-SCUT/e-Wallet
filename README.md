# e-Wallet

项目更新流程：
首先在本地，打开Git bash，找一个目录，git clone https://github.com/JSYBruce/e-Wallet
这就获取了该项目的内容。

然后，用IntelliJ打开项目，对项目进行修改，右上角有一个Commit选项，在Commit的时候，选择Commit and Pull即可自动更新项目。

切记：在进行任何更新操作前，首先pull一下最新内容，以防覆盖。（不过github会自动检测这种情况）



·····
Elasticsearch在配置文件中进行连接，通过service进行具体操作实现。

前端index为商场界面，pay是支付界面。

目前支付页面跳转的api是 /pay/{title}/{price}/{traget}  当然还需要获取用户的账户名，可以考虑用你之前说的api，不过我还没试过。
支付的api是 /getpay/ 然后传一些数据到后台处理。之后跳转到支付成功页面。
电子商城就目前在index ；
elasticsearch的数据库会有4个字段，title, price, img, target。
mysql负责写入支付信息。
····

## 2020/6/10 庞子翔修改日志
* 添加了主页
* 添加了spring security
* 注意：为了让其他微服务不受spring security拦截，需要在每个启动类的@SpringBootApplication
更改为
```java
@SpringBootApplication(exclude={SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
```
* 将思远的index.html更名为goodsIndex.html
* 还没有设置思远微服务的拦截器
* 主页连接了思远的微服务
* 将整个主页的启动端口号设为了80
* 其他同学如果添加了微服务，可以在启动类中添加
```java_holder_method_tree
@Bean
public WebServerFactoryCustomizer<ConfigurableWebServerFactory> myCustomizer(){
    return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
        @Override
        public void customize(ConfigurableWebServerFactory factory) {
            factory.setPort(80); //这里设置你想要的端口号，大家不要重复
        }
    };
}
```
比如，我的主页启动类更改为80端口：
```java
package com.bruceking.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

//暂时不用数据库，如果用，删掉exclude内容!
//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class MainApplication{

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> myCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(80);
            }
        };
    }

}
```
目前已经使用的端口号有80，8080.

转账查询使用了端口8181
使用/bill/{id}查询某一id下所有银行卡账户的转账数据
