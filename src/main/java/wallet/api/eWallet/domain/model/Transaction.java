package wallet.api.eWallet.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;



/**
 * A Transaction
 *
 * @author Mirlind Murati
 */
@Entity
@Data
//@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="TRANSACTION_ID")
    Long id;

    //@Column(name="TRANSACTION_TYPE")
    String type;

    //@Column(name="TRANSACTION_AMOUNT")
    BigDecimal amount;

    //@Column(name="TRANSACTION_TIME")
    String timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    eWallet wallet;

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
