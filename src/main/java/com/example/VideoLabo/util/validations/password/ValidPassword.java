package com.example.VideoLabo.util.validations.password;

import com.example.VideoLabo.models.Player;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(
        validatedBy = {PasswordConstraintValidator.class}
)

@Target({ TYPE, FIELD, ANNOTATION_TYPE  })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Ivalid password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
