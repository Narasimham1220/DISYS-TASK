package com.example.disystask.validators;


import androidx.annotation.NonNull;
import com.rengwuxian.materialedittext.validation.METValidator;



public class EmailValidator extends METValidator {

    public EmailValidator(String defaultErrString) {
        super(defaultErrString);
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return (!isEmpty && text.toString().matches(regex));
    }
}
