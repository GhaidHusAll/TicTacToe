package com.example.tictactoe_ghh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe_ghh.databinding.ActivitySittingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySittingsBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySittingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val xResults = sharedPreferences.getInt("x", 0)
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val oResults = sharedPreferences.getInt("o", 0)
        println("$xResults  $oResults")

        binding.tvOResult.text = oResults.toString()
        binding.tvXResult.text = xResults.toString()

        binding.btnBackToMain.setOnClickListener {
            val toMain = Intent(this, HomeActivity::class.java)
            startActivity(toMain)
        }
    }

}