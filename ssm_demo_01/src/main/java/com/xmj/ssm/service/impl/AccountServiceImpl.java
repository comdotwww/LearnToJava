package com.xmj.ssm.service.impl;

import com.xmj.ssm.domain.Account;
import com.xmj.ssm.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("这是业务层————查询所有账户方法  List<Account> findAll()");
        return null;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("这是业务层————添加账户方法  void addAccount(Account account)");

    }
}
