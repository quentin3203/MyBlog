package com.blog.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.blog.domain.User;
import com.blog.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class MyTest {
private static Logger logger=Logger.getLogger(MyTest.class);
@Resource
private IUserService userService=null;
@Test
public void test1(){
	User user=userService.selectByPrimaryKey(1);
	System.out.println(user);
	logger.info(JSON.toJSONString(user));
}
}
