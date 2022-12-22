package com.example.as1w6

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class ActivityContract : ActivityResultContract<CharSequence , CharSequence?>() {
    override fun createIntent(context: Context, input: CharSequence): Intent {
        return Intent(context , SecondActivity::class.java).putExtra("KEY" , input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CharSequence? {
        if (intent == null) return null
        if (resultCode != Activity.RESULT_OK) return null

        return intent.getCharSequenceExtra("KEY")
    }

}