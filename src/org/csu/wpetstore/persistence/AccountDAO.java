package org.csu.wpetstore.persistence;
import org.csu.wpetstore.domain.Account;
/**
 * Created by WZF on 2018/4/29.
 */
public interface AccountDAO {

    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);

    String getBannerByName(String favName);
}
