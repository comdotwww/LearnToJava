package com.xmj.ssm.dao;

import com.xmj.ssm.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    /**
     * 查询所有账户
     *
     * @return List<Account>
     */
    @Select("SELECT * FROM account")
    public List<Account> findAll();

    /**
     * 添加新账户
     *
     * @param account
     */
    @Select("INSERT INTO account (name,balance) VALUES (#{name},#{balance})")
    public void addAccount(Account account);

}
