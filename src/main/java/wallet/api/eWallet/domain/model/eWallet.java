package wallet.api.eWallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * An eWallet
 *
 * @author Mirlind Murati
 */
@Entity
@Data
//@Table(name="eWallet")
public class eWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="WALLET_ID")
    Long id;

   //@Column(name="ACCOUNT_BALANCE")
    BigDecimal balance;

    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    List<Transaction> transactions;

    public eWallet() {
       balance = new BigDecimal(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction tempTransaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }

        transactions.add(tempTransaction);

        tempTransaction.setWallet(this);
    }



}
