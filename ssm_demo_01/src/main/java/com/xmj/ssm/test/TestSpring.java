package com.xmj.ssm.test;

import com.xmj.ssm.domain.Account;
import com.xmj.ssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void testFindAll(){
        //加载配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
        accountService.addAccount(new Account());
    }
}
