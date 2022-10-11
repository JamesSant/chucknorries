package com.example.testchucknorris.common

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun bindingIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}