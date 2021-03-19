package wallet.api.eWallet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wallet.api.eWallet.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
