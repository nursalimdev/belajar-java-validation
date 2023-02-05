package nursalim.dev.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest {

    @Test
    void testHibernateValidationConstraintInvalid(){
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("0001");
        payment.setCreditCard("wrong");

        validate(payment);
    }

    @Test
    void testHibernateValidationConstraintValid(){
        Payment payment = new Payment();
        payment.setAmount(10000L);
        payment.setOrderId("0001");
        payment.setCreditCard("4481035250402589");

        validate(payment);
    }
}
