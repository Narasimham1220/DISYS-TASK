package com.example.disystask.validators;


import androidx.annotation.NonNull;
import com.rengwuxian.materialedittext.validation.METValidator;


public class PhoneValidator extends METValidator {

    public PhoneValidator(String defaultErrString) {
        super(defaultErrString);
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        // Ideally phone numbers should be validated via Google phonelib library.
        // This is just for demo purpose.
        String regex = "[^\\d]";
        String PhoneDigits = text.toString().replaceAll(regex, "");
        return (!isEmpty && PhoneDigits.length() >= 10);
    }
}
