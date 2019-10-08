package com.example.disystask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.disystask.R;
import com.example.disystask.model.Article;
import com.example.disystask.response.ArticleResponse;
import com.example.disystask.validators.EmailValidator;
import com.example.disystask.validators.NameValidator;
import com.example.disystask.validators.PasswordValidator;
import com.example.disystask.validators.PhoneValidator;
import com.example.disystask.view_model.ArticleViewModel;
import com.example.disystask.view_model.UserViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;
import java.util.Objects;

public class Register_Activity extends AppCompatActivity implements View.OnClickListener {

    private PhoneValidator mPhoneValidator;
    private EmailValidator mEmailValidator;
    private NameValidator mNameValidator;
    private PasswordValidator mPasswordValidator;

    private UserViewModel userViewModel;
    private MaterialEditText et_phone, et_email, et_name, et_unified, et_eid, et_idbarahno;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        init();



        et_phone.setAutoValidate(true);
        et_email.setAutoValidate(true);
        et_name.setAutoValidate(true);
        et_unified.setAutoValidate(true);
        et_eid.setAutoValidate(true);
        et_idbarahno.setAutoValidate(true);

        btn_register.setOnClickListener(this);
        //et_phone.addValidator(new PhoneValidator(et_phone.getText().toString()));
        // et_phone.addValidator((new EmailValidator()));
        // emailEditText.addValidator(viewModel.getEmailValidator());
        // nameEditText.addValidator(viewModel.getmNameValidator());
        // passwordEditText.addValidator(viewModel.getPasswordValidator());
    }

    private void init() {
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_name = findViewById(R.id.et_name);
        et_unified = findViewById(R.id.et_unified);
        et_eid = findViewById(R.id.et_eid);
        et_idbarahno = findViewById(R.id.et_idbarahno);
        btn_register = findViewById(R.id.btn_register);
    }

    private void userRegister() {
        userViewModel.getUserRegisterResponseLiveData().observe(this, new Observer<ArticleResponse>() {
            @Override
            public void onChanged(ArticleResponse articleResponse) {

                if (articleResponse != null) {
                    // progress_circular_movie_article.setVisibility(View.GONE);

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        userRegister();
    }


   /* public boolean isInputValid() {
        return mPhoneValidator.isValid(mPhone, mPhone.length() == 0) && mEmailValidator.isValid(mEmail, mEmail.length() == 0) &&
                mNameValidator.isValid(mName, mName.length() == 0) &&
                mPasswordValidator.isValid(mPassword, mPassword.length() == 0);
    }
*/

}


