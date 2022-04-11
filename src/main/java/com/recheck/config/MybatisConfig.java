package com.recheck.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.recheck.mapper")
public class MybatisConfig {

}
