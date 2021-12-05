package com.miqdad.portfolio.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.miqdad.portfolio.data.Portfolio


@BindingAdapter("experienceTitle")
    fun TextView.setExperienceTitle(data : Portfolio?){
        data?.let {
            text = data.title
        }
    }

    @BindingAdapter("experienceDetail")
    fun TextView.setExperienceDetail(data: Portfolio?){
        data?.let {
            text = data.title
        }
    }

    @BindingAdapter("experienceImage")
    fun ImageView.setExperienceImage(data: Portfolio){
        load(data.image){
            crossfade(1000)
        }
    }
