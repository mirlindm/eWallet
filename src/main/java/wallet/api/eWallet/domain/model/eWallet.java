package wallet.api.eWallet.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="eWALLET")
public class eWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WALLET_ID")
    private Long id;

    @Column(name="ACCOUNT_BALANCE")
    private BigDecimal balance;

    @OneToMany()
    private List<Transaction> transactions;

    public eWallet() {
       balance = new BigDecimal(0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getbalance() {
        return balance;
    }

    public void setbalance(BigDecimal balance) {
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
