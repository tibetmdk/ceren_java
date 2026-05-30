package com.example.java_project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;

    private AppCompatButton loginButton;
    private TextView registerLinkText;
    private LinearLayout loginPageBackButton;

    private DatabaseHelper databaseHelper;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        registerLinkText = findViewById(R.id.registerLinkText);
        loginPageBackButton = findViewById(R.id.login_page_back_button);

        loginButton.setOnClickListener(view -> {
            loginUser();
        });

        registerLinkText.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        loginPageBackButton.setOnClickListener(view -> {
            finish();
        });

        setupPasswordEyeToggle();
    }

    private void loginUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isValidUser = databaseHelper.checkUser(email, password);

        if (isValidUser) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupPasswordEyeToggle() {
        passwordInput.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Drawable drawableEnd = passwordInput.getCompoundDrawables()[2];

                if (drawableEnd != null) {
                    int drawableWidth = drawableEnd.getBounds().width();
                    float touchX = event.getRawX();
                    int inputRight = passwordInput.getRight();

                    if (touchX >= inputRight - drawableWidth - passwordInput.getPaddingEnd()) {
                        togglePasswordVisibility();
                        return true;
                    }
                }
            }

            return false;
        });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_crossed, 0);
            isPasswordVisible = false;
        } else {
            passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            passwordInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_crossed, 0);
            isPasswordVisible = true;
        }

        passwordInput.setSelection(passwordInput.getText().length());
    }
}