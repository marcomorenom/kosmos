/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample.framework.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.domain.Word
import com.example.android.roomwordssample.domain.utils.WordValidatorImpl
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

/**
 * Activity for entering a word.
 */

@AndroidEntryPoint
class NewWordActivity : AppCompatActivity() {

    private lateinit var word: Word
    private var wordValidator = WordValidatorImpl()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        val editWordView = findViewById<EditText>(R.id.edit_word)

        editWordView.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let { word = Word(
                    word = s.toString(),
                    country = Locale.getDefault().country,
                    timeStamp = Calendar.getInstance().time.time
                )
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (!wordValidator.isWordValid(word)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val wordJsonString = Gson().toJson(word)
                replyIntent.putExtra(EXTRA_REPLY, wordJsonString)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
