package com.king;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Package: com.king
 * @ClassName: UserApplication
 * @author: zhangkanglei
 * @createTime: 2022-10-17 14:46
 * @Description:
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,
                                  DataSourceAutoConfiguration.class})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

}
