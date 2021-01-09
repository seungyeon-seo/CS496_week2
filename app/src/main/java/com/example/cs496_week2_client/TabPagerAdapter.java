package com.example.cs496_week2_client;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cs496_week2_client.models.User;
import com.example.cs496_week2_client.ui.gallery.GalleryFragment;
import com.example.cs496_week2_client.ui.contacts.ContactFragment;
import com.example.cs496_week2_client.ui.feed.FeedFragment;

import org.jetbrains.annotations.NotNull;

public class TabPagerAdapter extends FragmentStateAdapter {
    private int tabCount;
    User user;
    String token;


    public TabPagerAdapter(FragmentActivity fa, int count, User user,
                           String token
    ) {
        super(fa);
        tabCount = count;
        this.user = user;
        this.token = token;
    }

    @NotNull
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
            default:
                return ContactFragment.newInstance();
            case 1:
                return GalleryFragment.newInstance();
            case 2:
                return FeedFragment.newInstance(user, token);
        }
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
