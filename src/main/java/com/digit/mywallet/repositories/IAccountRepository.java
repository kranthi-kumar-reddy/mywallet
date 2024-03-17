package com.digit.mywallet.repositories;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.digit.mywallet.entities.BankAccount;

@Repository
public interface IAccountRepository extends JpaRepository<BankAccount, Integer> {

	@Query(value = "select * from bank_account where wallet_id=? order by wallet_id limit 1", nativeQuery = true)
	public BankAccount viewAccount(int id);

	@Query(value = "select * from bank_account where wallet_id=?", nativeQuery = true)
	public List<BankAccount> viewAllAccounts(int id);

	@Transactional
	@Modifying
	@Query(value = "delete from bank_account where account_no=?", nativeQuery = true)
	public void deleteAccount(long id);
	
	@Query(value = "select * from bank_account where wallet_id=?",nativeQuery = true)
	public List<BankAccount> getAccount(int walletId);
}
