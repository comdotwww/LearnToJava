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
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
        as.addAccount(new Account());
    }
}
