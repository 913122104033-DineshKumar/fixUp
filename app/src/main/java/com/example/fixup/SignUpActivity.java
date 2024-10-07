package com.example.fixup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fixup.utils.AndroidUtil;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private EditText userName, userEmail, userContactNo, userState, userCity, userPassword, userReEnteredPassword;
    private Button register;
    public static final String USERNAME_REGEX = "^[A-Za-z\\s]{3,30}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String CONTACT_NO_REGEX = "^[6-9]\\d{9}$";
    public static final String STATE_REGEX = "^[A-Za-z\\s]{2,20}$";
    public static final String CITY_REGEX = "^[A-Za-z\\s]{2,20}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.sign_up_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userContactNo = findViewById(R.id.userContactNo);
        userState = findViewById(R.id.userState);
        userCity = findViewById(R.id.userCity);
        userPassword = findViewById(R.id.userPassword);
        userReEnteredPassword = findViewById(R.id.userRePassword);
        register = findViewById(R.id.register_button);
        register.setOnClickListener(v -> {
            if(evaluateForm()) {
                AndroidUtil.showDialog(
                        this,
                        "Confirmation",
                        "Do you want to submit the form",
                        "Cancel",
                        "Yes",
                        () -> {},
                        () -> {
                            Toast.makeText(this, "Registration Complete", Toast.LENGTH_SHORT).show();
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(() -> AndroidUtil.switchActivity(
                                            getApplicationContext(),
                                            OTPVerificationActivity.class
                                    ));
                                }
                            }, 2000);
                        }
                );
            }
        });
    }
    private boolean evaluateForm() {
        if(userName.getText().toString().trim().length() > 0) {
            if(!userName.getText().toString().matches(USERNAME_REGEX)) {
                userName.setText("");
                userName.setHint("Name is Incorrect");
                userName.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userName.setHint("Name is Required");
            userName.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(userEmail.getText().toString().trim().length() > 0) {
            if(!userEmail.getText().toString().matches(EMAIL_REGEX)) {
                userEmail.setText("");
                userEmail.setHint("Email is Incorrect");
                userEmail.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userEmail.setHint("Email is Required");
            userEmail.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(userContactNo.getText().toString().trim().length() > 0) {
            if(!userContactNo.getText().toString().matches(CONTACT_NO_REGEX)) {
                userContactNo.setText("");
                userContactNo.setHint("Contact must be Numbers");
                userContactNo.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userContactNo.setHint("ContactNo is Required");
            userContactNo.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(userState.getText().toString().trim().length() > 0) {
            if(!userState.getText().toString().matches(STATE_REGEX)) {
                userState.setText("");
                userState.setHint("State must be Alphabets");
                userState.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userState.setHint("State is Required");
            userState.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(userCity.getText().toString().trim().length() > 0) {
            if(!userCity.getText().toString().matches(CITY_REGEX)) {
                userCity.setHint("City must be Alphabets");
                userCity.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userCity.setHint("City is Required");
            userCity.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(userPassword.getText().toString().trim().length() > 0) {
            if(!userPassword.getText().toString().matches(PASSWORD_REGEX)) {
                userPassword.setText("");
                userPassword.setHint("Password is weak");
                userPassword.setTextColor(ContextCompat.getColor(this, R.color.colorError));
                return false;
            }
        } else {
            userPassword.setHint("Password is Required");
            userPassword.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        if(!userReEnteredPassword.getText().toString().equals(userPassword.getText().toString())) {
            userReEnteredPassword.setText("");
            userReEnteredPassword.setHint("Password is not matched");
            userReEnteredPassword.setTextColor(ContextCompat.getColor(this, R.color.colorError));
            return false;
        }
        return true;
    }
}
