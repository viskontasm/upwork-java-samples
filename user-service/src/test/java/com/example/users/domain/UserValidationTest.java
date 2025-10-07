package com.example.users.domain;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserValidationTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void invalidEmail_failsValidation() {
        var u = new User();
        u.setFullName("Bad Email");
        u.setEmail("not-an-email");

        var violations = validator.validate(u);
        assertThat(violations)
            .anyMatch(v -> v.getPropertyPath().toString().equals("email"));
    }

    @Test
    void blankName_failsValidation() {
        var u = new User();
        u.setFullName("");
        u.setEmail("ok@example.com");

        var violations = validator.validate(u);
        assertThat(violations)
            .anyMatch(v -> v.getPropertyPath().toString().equals("fullName"));
    }
}