package com.xmj.ssm.service;

import com.xmj.ssm.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有
     *
     * @return List<Account>
     */
    public List<Account> findAll();

    /**
     * 添加账户
     *
     * @param account
     * @return
     */
    public void addAccount(Account account);
}
