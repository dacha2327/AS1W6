package com.example.as1w6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.as1w6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        val launcherData =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                    val data =
                        result.data?.getStringExtra(SecondActivity.KEYFORDATA)
                    binding.et.setText(data)
                }
            }

        binding.btn.setOnClickListener {
            if (binding.et.text.isEmpty()) {
                Toast.makeText(this , R.string.toast , Toast.LENGTH_SHORT).show()
            }else {
                Intent(this@MainActivity , SecondActivity::class.java).apply {
                    putExtra(KEYFORINTENT , binding.et.text.toString())
                    launcherData.launch(this)
                }
            }
        }
    }

    companion object {
        const val KEYFORINTENT = "DataKey"
    }


}