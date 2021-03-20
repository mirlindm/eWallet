package wallet.api.eWallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;



/**
 * A Transaction
 *
 * @author Mirlind Murati
 */
@Entity
//@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="TRANSACTION_ID")
    private Long id;

    //@Column(name="TRANSACTION_TYPE")
    private String type;

    //@Column(name="TRANSACTION_AMOUNT")
    private BigDecimal amount;

    //@Column(name="TRANSACTION_TIME")
    private String timestamp;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="WALLET_ID")
    private eWallet wallet;

    public Transaction() {

    }

    public Transaction(String type, BigDecimal amount, String timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public eWallet getWallet() {
        return wallet;
    }

    public void setWallet(eWallet wallet) {
        this.wallet = wallet;
    }

}
