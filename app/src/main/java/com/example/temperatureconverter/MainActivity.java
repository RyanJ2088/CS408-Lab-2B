package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.temperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void onClickConvert(View view) {
        String fText = binding.etFahrenheit.getText().toString();
        String cText = binding.etCelsius.getText().toString();

        if (fText.isEmpty() && cText.isEmpty()) {
            return;
        }

        double fahrenheitValue = 0.0;
        double celsiusValue = 0.0;
        boolean isFNumeric = true;
        boolean isCNumeric = true;

        try {
            fahrenheitValue = Double.parseDouble(fText);
        } catch (NumberFormatException e) {
            isFNumeric = false;
        }

        try {
            celsiusValue = Double.parseDouble(cText);
        } catch (NumberFormatException e) {
            isCNumeric = false;
        }

        if (!fText.isEmpty()) {
            // Fahrenheit to Celsius
            if (isFNumeric) {
                double result = (fahrenheitValue - 32) * 5.0 / 9.0;
                binding.etCelsius.setText(String.valueOf(result));
            }
        } else {
            // Celsius to Fahrenheit
            if (isCNumeric) {
                double result = (celsiusValue * 9.0 / 5.0) + 32;
                binding.etFahrenheit.setText(String.valueOf(result));
            }
        }
    }

}