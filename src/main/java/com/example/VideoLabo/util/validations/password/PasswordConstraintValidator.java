package com.example.VideoLabo.util.validations.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.EnglishEnums;
import org.hibernate.validator.constraints.Length;
import org.passay.*;
import org.w3c.dom.css.CSSCharsetRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0){

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
//                new UppercaseCharacterRule(1),
//                new DigitCharacterRule(1),
//                new SpecialCharacterRule(1),
//                new NumericalSequenceRule(3, false),
//                new AlphabeticalSequenceRule(3, false),
//                new QwertySequenceRule(3, false),
                new CharacterRule(EnglishCharacterData.UpperCase,1),
                new CharacterRule(EnglishCharacterData.Digit,1),
                new CharacterRule(EnglishCharacterData.Special,1),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 3, false),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical,3,false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 3, false),
                new WhitespaceRule()
        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if(result.isValid()){
            return true;
        }
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

}
