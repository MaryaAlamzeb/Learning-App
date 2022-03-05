package com.example.kids_game;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter{
    AnimalFragment animalFragment=new AnimalFragment();
    Context context;
    public ImageAdapter(Context context) {

        this.context=context;
    }

    @Override
    public int getCount() {
        return  animalFragment.animal.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv=new ImageView(context);
        iv.setImageResource(animalFragment.animal[i]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(120,120));
        return iv;
    }
}
