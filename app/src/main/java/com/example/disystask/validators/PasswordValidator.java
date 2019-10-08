package com.example.disystask.validators;

import androidx.annotation.NonNull;
import com.rengwuxian.materialedittext.validation.METValidator;



public class PasswordValidator extends METValidator {

    public PasswordValidator(String defaultErrString) {
        super(defaultErrString);
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        return text.length() >= 6 && text.length() <= 15;
    }
}
