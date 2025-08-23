package com.lbx.cloudgallery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.lbx.cloudgallery.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class CloudGalleryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGalleryBackendApplication.class, args);
    }

}
