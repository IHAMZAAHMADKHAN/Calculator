package com.hamza.mycaculator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.hamza.mycaculator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String firstNumber = "";
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        onClick();
    }

    private void onClick(){
        binding.buttonPlus.setOnClickListener(view -> {
            firstNumber = binding.textViewScreen.getText().toString();
            operator = "+";
            binding.textViewScreen.setText("0");
        });
        binding.buttonMinus.setOnClickListener(view -> {
            firstNumber = binding.textViewScreen.getText().toString();
            operator = "-";
            binding.textViewScreen.setText("0");
        });
        binding.buttonMultiply.setOnClickListener(view -> {
            firstNumber = binding.textViewScreen.getText().toString();
            operator = "*";
            setTextView("0");
        });
        binding.buttonDivide.setOnClickListener(view -> {
            firstNumber = binding.textViewScreen.getText().toString();
            operator = "/";
            binding.textViewScreen.setText("0");
        });
        binding.buttonC.setOnClickListener(view -> {
            binding.textViewScreen.setText("0");
        });
        binding.buttonDot.setOnClickListener(view -> {
            setTextView(".");
        });
        binding.buttonEqual.setOnClickListener(view -> {
            String secondNumber = binding.textViewScreen.getText().toString();
            if(firstNumber.equals("")){
                binding.textViewScreen.setText("Error");
                return;
            }
            if(secondNumber.equals("")){
                binding.textViewScreen.setText(firstNumber);
                return;
            }
            switch (operator){
                case "+":
                    binding.textViewScreen.setText(String.valueOf(Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber)));
                    break;
                case "-":
                    binding.textViewScreen.setText(String.valueOf(Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber)));
                    break;
                case "*":
                    binding.textViewScreen.setText(String.valueOf(Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber)));
                    break;
                case "/":
                    binding.textViewScreen.setText(String.valueOf(Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber)));
                    break;
            }
        });

        // numbers click listeners
        binding.button0.setOnClickListener(view -> {
            setTextView("0");
        });
        binding.button1.setOnClickListener(view -> {
            setTextView("1");
        });
        binding.button2.setOnClickListener(view -> {
            setTextView("2");
        });
        binding.button3.setOnClickListener(view -> {
            setTextView("3");
        });
        binding.button4.setOnClickListener(view -> {
            setTextView("4");
        });
        binding.button5.setOnClickListener(view -> {
            setTextView("5");
        });
        binding.button6.setOnClickListener(view -> {
            setTextView("6");
        });
        binding.button7.setOnClickListener(view -> {
            setTextView("7");
        });
        binding.button8.setOnClickListener(view -> {
            setTextView("8");
        });
        binding.button9.setOnClickListener(view -> {
            setTextView("9");
        });
    }

    private void setTextView(String text){
        String screen = binding.textViewScreen.getText().toString();
        if(screen.equals("0")){
            binding.textViewScreen.setText(text);
        }else{
            binding.textViewScreen.setText( screen + text);
        }
    }

}





