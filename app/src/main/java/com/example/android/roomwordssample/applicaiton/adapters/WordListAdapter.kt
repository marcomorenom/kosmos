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

package com.example.android.roomwordssample.applicaiton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.applicaiton.adapters.WordListAdapter.WordViewHolder
import com.example.android.roomwordssample.domain.businessEntities.Word
import java.text.SimpleDateFormat
import java.util.*

class WordListAdapter : ListAdapter<Word, WordViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemValue: TextView = itemView.findViewById(R.id.item_word_value)
        private val wordItemTime: TextView = itemView.findViewById(R.id.item_word_time)
        private val wordItemCountry: TextView = itemView.findViewById(R.id.item_word_country)

        fun bind(word: Word?) {
            word?.run {
                wordItemValue.text = this.word
                wordItemTime.text = parseDate(timeStamp)
                wordItemCountry.text = parseCountry(
                    itemView.context.resources.getString(R.string.default_word),
                    country
                )
            }
        }

        private fun parseCountry(default: String, country: String): String{
            return if (country == "US" || country == "MX") country
            else return default
        }

        private fun parseDate(timeStamp: Long): String{
            val date = Date()
            date.time = timeStamp
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date)
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.word == newItem.word
            }
        }
    }
}
