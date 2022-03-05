package com.example.kids_game;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class loginadapter extends FragmentStateAdapter {

  private String[] titles=new String[]{"LOGIN","SIGNUP"};

    public loginadapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new loginfrag();
            case 1:
                return new signup();
            default:
                loginfrag loginFragdefault = new loginfrag();
                return loginFragdefault;

        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
