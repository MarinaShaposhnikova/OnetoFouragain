package com.meier.marina.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.meier.marina.onetofouragain.OnetoFouragainLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> imagesUrls = new ArrayList<>();
        imagesUrls.add("https://static.pexels.com/photos/73756/fog-mist-golden-sunrise-73756.jpeg");
        imagesUrls.add("https://static.pexels.com/photos/206355/pexels-photo-206355.jpeg");
        imagesUrls.add("https://static.pexels.com/photos/141288/pexels-photo-141288.jpeg");
        imagesUrls.add("https://static.pexels.com/photos/100362/pexels-photo-100362.jpeg");
        imagesUrls.add("https://static.pexels.com/photos/680802/pexels-photo-680802.jpeg");


        OnetoFouragainLayout layout = findViewById(R.id.layout);
        layout.setSize(imagesUrls.size());

        for (int i = 0; i < layout.getImages().size(); i++) {
            layout.getImages().get(i).setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this)
                    .load(imagesUrls.get(i))
                    .into(layout.getImages().get(i));
        }
    }
}
