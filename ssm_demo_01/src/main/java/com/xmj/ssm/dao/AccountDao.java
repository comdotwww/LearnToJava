package com.xmj.ssm.dao;

import com.xmj.ssm.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户
     *
     * @return List<Account>
     */
    public List<Account> findAll();

    /**
     * 添加新账户
     *
     * @param account
     */
    public void addAccount(Account account);

}
