package com.example.tictactoe_ghh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.tictactoe_ghh.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var isPlayerXTurn = true
    private var isClicked = arrayListOf(false,false,false,false,false,false,false,false,false)
    private var setGame = arrayListOf("noOne","noOne","noOne","noOne","noOne","noOne","noOne","noOne","noOne")
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var endAnim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        endAnim = AnimationUtils.loadAnimation(this, R.anim.winning)
        binding.btn1.setOnClickListener {
            if(!isClicked[0]) {
                if (isPlayerXTurn) {
                    binding.btn1.setBackgroundResource(R.drawable.x)
                    setGame[0] = "x"
                } else {
                    setGame[0] = "o"
                    binding.btn1.setBackgroundResource(R.drawable.o2)
                }
                isClicked[0] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }

        binding.btn2.setOnClickListener {
            if(!isClicked[1]) {
                if (isPlayerXTurn) {
                    binding.btn2.setBackgroundResource(R.drawable.x)
                    setGame[1] = "x"
                } else {
                    setGame[1] = "o"
                    binding.btn2.setBackgroundResource(R.drawable.o2)
                }
                isClicked[1] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn3.setOnClickListener {
            if(!isClicked[2]) {
                if (isPlayerXTurn) {
                    binding.btn3.setBackgroundResource(R.drawable.x)
                    setGame[2] = "x"
                } else {
                    setGame[2] = "o"
                    binding.btn3.setBackgroundResource(R.drawable.o2)
                }
                isClicked[2] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn4.setOnClickListener {
            if(!isClicked[3]) {
                if (isPlayerXTurn) {
                    binding.btn4.setBackgroundResource(R.drawable.x)
                    setGame[3] = "x"
                } else {
                    setGame[3] = "o"
                    binding.btn4.setBackgroundResource(R.drawable.o2)
                }
                isClicked[3] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn5.setOnClickListener {
            if(!isClicked[4]) {
                if (isPlayerXTurn) {
                    binding.btn5.setBackgroundResource(R.drawable.x)
                    setGame[4] = "x"
                } else {
                    setGame[4] = "o"
                    binding.btn5.setBackgroundResource(R.drawable.o2)
                }
                isClicked[4] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn6.setOnClickListener {
            if(!isClicked[5]) {
                if (isPlayerXTurn) {
                    binding.btn6.setBackgroundResource(R.drawable.x)
                    setGame[5] = "x"
                } else {
                    setGame[5] = "o"
                    binding.btn6.setBackgroundResource(R.drawable.o2)
                }
                isClicked[5] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn7.setOnClickListener {
            if(!isClicked[6]) {
                if (isPlayerXTurn) {
                    binding.btn7.setBackgroundResource(R.drawable.x)
                    setGame[6] = "x"
                } else {
                    setGame[6] = "o"
                    binding.btn7.setBackgroundResource(R.drawable.o2)
                }
                isClicked[6] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn8.setOnClickListener {
            if(!isClicked[7]) {
                if (isPlayerXTurn) {
                    binding.btn8.setBackgroundResource(R.drawable.x)
                    setGame[7] = "x"
                } else {
                    setGame[7] = "o"
                    binding.btn8.setBackgroundResource(R.drawable.o2)
                }
                isClicked[7] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
        binding.btn9.setOnClickListener {
            if(!isClicked[8]) {
                if (isPlayerXTurn) {
                    binding.btn9.setBackgroundResource(R.drawable.x)
                    setGame[8] = "x"
                } else {
                    setGame[8] = "o"
                    binding.btn9.setBackgroundResource(R.drawable.o2)
                }
                isClicked[8] = true
                checkTurn()
                isPlayerXTurn = !isPlayerXTurn
            }
        }
    }
    private fun checkTurn(){
        if (isPlayerXTurn){
            binding.ivTurn.setBackgroundResource(R.drawable.x)
        }else{
            binding.ivTurn.setBackgroundResource(R.drawable.o2)
        }
        checkGamePlay()
    }
    private fun checkGamePlay(){
        if (isWin()){
            // endGame  with win
                var winner = "O"
            if (isPlayerXTurn){winner = "X"}
            endGame("Player $winner Wins",true)
        } else if (isDraw()){
            // endGame  with Draw
                endGame("Draw",false)
        }

    }
    private fun isDraw(): Boolean{
        for (one in isClicked) if (!one) return false
        return true
    }
    private fun isWin(): Boolean{
        return when {
            ((setGame[0]==setGame[1])&&(setGame[1]==setGame[2]))&&(isClicked[0]&&isClicked[1]&&isClicked[2]) ->{true }
            ((setGame[3]==setGame[4])&&(setGame[4]==setGame[5]))&&(isClicked[3]&&isClicked[4]&&isClicked[5]) ->{true }
            ((setGame[6]==setGame[7])&&(setGame[7]==setGame[8]))&&(isClicked[6]&&isClicked[7]&&isClicked[8]) ->{true }
            ((setGame[0]==setGame[3])&&(setGame[3]==setGame[6]))&&(isClicked[0]&&isClicked[3]&&isClicked[6]) ->{true }
            ((setGame[1]==setGame[4])&&(setGame[4]==setGame[7]))&&(isClicked[1]&&isClicked[4]&&isClicked[7]) ->{true }
            ((setGame[2]==setGame[5])&&(setGame[5]==setGame[8]))&&(isClicked[2]&&isClicked[5]&&isClicked[8]) ->{true }
            ((setGame[0]==setGame[4])&&(setGame[4]==setGame[8]))&&(isClicked[0]&&isClicked[4]&&isClicked[8]) ->{true }
            ((setGame[2]==setGame[4])&&(setGame[4]==setGame[6]))&&(isClicked[2]&&isClicked[4]&&isClicked[6]) ->{true }
            else ->{false}
        }
    }
    private fun endGame(msg:String, isWin : Boolean){
        if (isWin) {
            if (isPlayerXTurn) {
                sharedPreferences = this.getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE
                )
                val xResults = sharedPreferences.getInt("x", 0)
                with(sharedPreferences.edit()) {
                    putInt("x", xResults + 1)
                    apply()
                }
            } else {
                sharedPreferences = this.getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE
                )
                val oResults = sharedPreferences.getInt("o", 0)
                with(sharedPreferences.edit()) {
                    putInt("o", oResults + 1)
                    apply()
                }
            }
        }
        binding.llResult.isVisible = true
        binding.tvEnd.text = msg
        binding.tvEnd.startAnimation(endAnim)
        binding.btnToMain.setOnClickListener {
            val toMain = Intent(this,HomeActivity::class.java)
            startActivity(toMain)
        }
    }
}