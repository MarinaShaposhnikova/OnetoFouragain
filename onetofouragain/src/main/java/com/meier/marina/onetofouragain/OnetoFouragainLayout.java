package com.meier.marina.onetofouragain;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class OnetoFouragainLayout extends LinearLayout {

    private final static int MIN_COUNT = 1;
    private final static int MAX_COUNT = 4;

    private int size;
    private LinearLayout.LayoutParams mainParams;
    private LinearLayout.LayoutParams secondaryParams;

    public OnetoFouragainLayout(Context context) {
        this(context, null);
    }

    public OnetoFouragainLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnetoFouragainLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void setSize(int size) {
        this.size = size;
        removeAllViews();
        handleSize();
    }

    public List<ImageView> getImages() {
        List<ImageView> images = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {

            if (getChildAt(i) instanceof ImageView) {
                images.add((ImageView) getChildAt(i));

            } else if (getChildAt(i) instanceof LinearLayout) {
                LinearLayout secondaryLayout = (LinearLayout) getChildAt(i);
                for (int j = 0; j < secondaryLayout.getChildCount(); j++) {
                    images.add((ImageView) secondaryLayout.getChildAt(j));
                }
            }
        }

        return images;
    }

    private void init(AttributeSet attrs) {
        setOrientation(VERTICAL);
        mainParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        mainParams.weight = 1;
        secondaryParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        secondaryParams.weight = 1;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.OnetoFouragainLayout);
        size = a.getInt(R.styleable.OnetoFouragainLayout_countImages, 0);
        a.recycle();

        handleSize();
    }

    private void handleSize() {
        if (size == 0) return;
        int condition = MAX_COUNT;
        int temporarySize = size;
        for (int i = 0; i < size; i += condition) {
            if (temporarySize >= MAX_COUNT) {
                temporarySize -= MAX_COUNT;
                addViews(MAX_COUNT);
                condition = MAX_COUNT;
            } else {
                addViews(temporarySize);
                condition = temporarySize;
            }
        }
    }

    private void addViews(int count) {
        if (count != MIN_COUNT) {
            addSecondaryImages(count);
        }
        addMainImage();

    }

    private void addMainImage() {
        ImageView mainImage = new ImageView(getContext());
        mainImage.setLayoutParams(mainParams);
        addView(mainImage);
    }

    private void addSecondaryImages(int count) {
        LinearLayout secondaryImagesLayout = new LinearLayout(getContext());
        secondaryImagesLayout.setOrientation(HORIZONTAL);
        secondaryImagesLayout.setLayoutParams(mainParams);

        for (int i = 0; i < count - MIN_COUNT; i++) {
            ImageView secondaryImage = new ImageView(getContext());
            secondaryImage.setLayoutParams(secondaryParams);
            secondaryImagesLayout.addView(secondaryImage);
        }

        addView(secondaryImagesLayout);
    }
}
