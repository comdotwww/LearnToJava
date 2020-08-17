package com.xmj.ssm.controller;

import com.xmj.ssm.domain.Account;
import com.xmj.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("这是控制层————查询所有账户的方法");
        List<Account> list = accountService.findAll();
        model.addAttribute("accounts",list);
        return "list_account";
    }

    @RequestMapping("/add")
    public void add(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.addAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

}
