package com.example.pmdmej5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.pmdmej5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.isEnabled = false

        binding.editText1.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()
            }
        })
        binding.editText2.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()
            }
        })

        binding.editText1.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                binding.textFocus.text = "editText1"
            }
        }
        binding.editText2.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                binding.textFocus.text = "editText2"
            }
        }
        binding.button.setOnClickListener{
            val texto = binding.editText1.text.toString() + binding.editText2.text.toString()
            binding.editText1.setText(texto)
            binding.editText2.setText("")
        }
    }
}