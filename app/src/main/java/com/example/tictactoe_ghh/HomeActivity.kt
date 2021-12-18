package com.example.tictactoe_ghh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.tictactoe_ghh.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var shakeAnim : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.my_anime)
        binding.btnPlay.startAnimation(shakeAnim)
        binding.btnPlay.setOnClickListener {
            val toGamePlay = Intent(this,MainActivity::class.java)
            startActivity(toGamePlay)
        }
        binding.btnSettings.setOnClickListener {
            val toSettings = Intent(this,SettingsActivity::class.java)
            startActivity(toSettings)
        }
    }
}