package com.example.tareaui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register form
        setContentView(R.layout.register_form);
        registerForm();

        // Login form
        // setContentView(R.layout.login_form);
        // loginForm();
    }

    private void registerForm() {
        // Password vars init
        Button registerButton;
        EditText editTextUsername, editTextEmail, editTextPassword, editTextConfirmPassword;

        // Spinner vars init
        Spinner spinner;
        List<String> roles;
        ArrayAdapter<String> adapter;

        // Register logic
        editTextUsername = findViewById(R.id.username);
        editTextEmail    = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextConfirmPassword = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            String password = editTextPassword.getText().toString().trim();
            String confirmPassword = editTextConfirmPassword.getText().toString().trim();

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Por favor ingresa una contraseña.", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden, por favor inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
                editTextPassword.setText("");
                editTextConfirmPassword.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Registro exitoso!", Toast.LENGTH_SHORT).show();

                editTextUsername.setText("");
                editTextEmail.setText("");
                editTextPassword.setText("");
                editTextConfirmPassword.setText("");
            }
        });


        // Spinner logic
        spinner = (Spinner) findViewById(R.id.role_list);
        roles = new ArrayList<>(Arrays.asList("-", "faa", "fee", "fii", "foo", "fuu"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (position != 0) {
                    Toast.makeText(parent.getContext(), "Rol seleccionado: " + selectedItem, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(parent.getContext(), "No has seleccionado un rol", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void loginForm() {
        // Find layout elements
        EditText editTextUsername = findViewById(R.id.username);
        EditText editTextPassword = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.loginButton);

        // Logic
        buttonLogin.setOnClickListener(v -> {
            String email = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();

                editTextUsername.setText("");
                editTextPassword.setText("");
            }
        });
    }
}
