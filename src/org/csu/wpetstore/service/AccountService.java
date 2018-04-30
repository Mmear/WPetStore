package org.csu.wpetstore.service;

import org.csu.wpetstore.persistence.impl.AccountDAOImpl;
import org.csu.wpetstore.domain.Account;
/**
 * Created by WZF on 2018/4/26.
 */
public class AccountService {

    private AccountDAOImpl accountMapper;
    public AccountService() {
        accountMapper = new AccountDAOImpl();
    }
    public Account getAccount(String username) {
        return accountMapper.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);
        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountMapper.updateSignon(account);
        }
    }

}
