package wallet.api.eWallet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wallet.api.eWallet.domain.model.eWallet;

public interface eWalletRepository extends JpaRepository<eWallet, Long> {
}
