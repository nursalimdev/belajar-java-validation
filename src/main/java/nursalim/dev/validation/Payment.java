package nursalim.dev.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {
    @NotBlank(message = "Order id cannot blank")
    private String orderId;
    @Range(min = 10_000L, max = 100_000_000L, message = "Amount must between 10.000 and 100.000.000")
    @NotNull(message = "Amount cannot null")
    private Long amount;
    @LuhnCheck(message = "Invalid credit card number")
    @NotBlank(message = "Credit card cannot blank")
    private String creditCard;

    public Payment(){}

    public Payment(String orderId, Long amount, String creditCard) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
