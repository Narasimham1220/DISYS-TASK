package com.example.disystask.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.disystask.R;
import com.example.disystask.preference.SharePref;
import com.example.disystask.response.ArticleResponse;
import com.example.disystask.view_model.UserViewModel;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Objects;

public class Register_Activity extends AppCompatActivity implements View.OnClickListener {
    private UserViewModel userViewModel;
    private MaterialEditText et_phone, et_email, et_name, et_unified, et_eid, et_idbarahno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        // View Model
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


    }

    private void init() {
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_name = findViewById(R.id.et_name);
        et_unified = findViewById(R.id.et_unified);
        et_eid = findViewById(R.id.et_eid);
        et_idbarahno = findViewById(R.id.et_idbarahno);
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    private void userRegister() {
        userViewModel.getUserRegisterResponseLiveData(Objects.requireNonNull(et_phone.getText()).toString(), Objects.requireNonNull(et_email.getText()).toString(), Objects.requireNonNull(et_name.getText()).toString(), Objects.requireNonNull(et_unified.getText()).toString(), Objects.requireNonNull(et_eid.getText()).toString(), Objects.requireNonNull(et_idbarahno.getText()).toString()).observe(this, new Observer<ArticleResponse>() {
            @Override
            public void onChanged(ArticleResponse articleResponse) {

                if (articleResponse != null) {
                    // For Successful result  storing data in sharedpreference
                    storingValues();
                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
                    finish();
                } else {
                    //For Testing & API not Working
                    storingValues();
                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
                    finish();
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (validations()) {
            userRegister();
        }
    }


    private boolean validations() {
        boolean invalid = false;
         // We have choice to use TextUtils.isEmpty function also
        if (Objects.requireNonNull(et_phone.getText()).length() != 10) {
            et_phone.setError("Invalid Phone number");
        } else if (Objects.requireNonNull(et_email.getText()).length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(et_email.getText()).matches()) {
            et_email.setError("Invalid Email  Address");
        } else if (Objects.requireNonNull(et_name.getText()).length() < 3) {
            et_name.setError("Please Enter atleast  3 characters");
        } else if (Objects.requireNonNull(et_unified.getText()).length() == 0) {
            et_unified.setError("Invalid unified  Number");
        } else if (Objects.requireNonNull(et_eid.getText()).length() == 0) {
            et_eid.setError("Invalid EID  Number");
        } else if (Objects.requireNonNull(et_idbarahno.getText()).length() == 0) {
            et_idbarahno.setError("Invalid idbarahno  Number");
        } else {
            invalid = true;
        }
        return invalid;
    }

    private void storingValues() {
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_Mobile, Objects.requireNonNull(et_phone.getText()).toString());
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_EMAIL, Objects.requireNonNull(et_email.getText()).toString());
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_NAME, Objects.requireNonNull(et_name.getText()).toString());
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_UNIFIED, Objects.requireNonNull(et_unified.getText()).toString());
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_EID, Objects.requireNonNull(et_eid.getText()).toString());
        SharePref.getInstance(Register_Activity.this).saveData(SharePref.KEY_IDBARAHNO, Objects.requireNonNull(et_idbarahno.getText()).toString());

    }
}


