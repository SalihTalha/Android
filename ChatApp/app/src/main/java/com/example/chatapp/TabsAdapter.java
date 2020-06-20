package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                RequestsFragment rf = new RequestsFragment();
                return rf;
            case 1:
                ChatsFragment cf = new ChatsFragment();
                return cf;
            case 2:
                FriendsFragment ff = new FriendsFragment();
                return ff;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Requests";
            case 1:
                return "Chat";
            case 2:
                return "Friends";

            default:
                return null;
        }
    }
}
