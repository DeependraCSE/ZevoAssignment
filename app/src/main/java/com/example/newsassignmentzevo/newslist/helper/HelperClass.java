package com.example.newsassignmentzevo.newslist.helper;

import android.widget.ImageView;

import com.example.newsassignmentzevo.R;
import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class HelperClass {
    @BindingAdapter({"bind:imageUrl"})
    public static void LoadImage(ImageView imageView, String imageUrl){
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(imageView);
    }
}
