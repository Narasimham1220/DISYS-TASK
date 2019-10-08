package com.example.disystask.validators;


import androidx.annotation.NonNull;
import com.rengwuxian.materialedittext.validation.METValidator;



public class NameValidator extends METValidator {

    public NameValidator(String defaultErrString) {
        super(defaultErrString);
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        return !isEmpty;
    }
}
