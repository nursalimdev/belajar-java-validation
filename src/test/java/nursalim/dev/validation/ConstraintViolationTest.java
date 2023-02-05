package nursalim.dev.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {
    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp(){
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown(){
        validatorFactory.close();
    }

    @Test
    void testValidationFailedNotBlank(){
        Person person = new Person();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Annotation : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationFailedSize(){
        Person person = new Person("Nursalim Al Farizi AL Barbasi Al Indonesiawi Al Duniawi Al Bumi", "Last Name Last Name Last Name Last Name Last Name Last Name Last Name Last Name Last Name Last Name");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Annotation : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationSuccess(){
        Person person = new Person("Nursalim", "Al Farizi");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Annotation : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Path : " + violation.getPropertyPath());
        }
    }
}
