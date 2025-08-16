package mainpkg.lawfirm.Sojib.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class PayFees implements Serializable {
    private String cardNumber;
    private String paymentMethod;
    private Integer enterAmount;
    private LocalDate paymentDate;

    public PayFees(String cardNumber, String paymentMethod, Integer enterAmount, LocalDate paymentDate) {
        this.cardNumber = cardNumber;
        this.paymentMethod = paymentMethod;
        this.enterAmount = enterAmount;
        this.paymentDate = paymentDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PayFees{" +
                "cardNumber='" + cardNumber + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", enterAmount=" + enterAmount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
