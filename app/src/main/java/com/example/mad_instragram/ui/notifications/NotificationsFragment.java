package com.example.mad_instragram.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_instragram.EditProfile;
import com.example.mad_instragram.FragmentContent;
import com.example.mad_instragram.FragmentProfile;
import com.example.mad_instragram.R;
import com.example.mad_instragram.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment{

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TabLayout tabLayout= root.findViewById(R.id.tablayout);
        final Button button= root.findViewById(R.id.edit);
        final  ViewPager viewPager=root.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new FragmentProfile(),"Profile");
        adapter.AddFragment(new FragmentContent(),"Content");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getContext(), EditProfile.class);
                startActivity(i);
            }
        });
        return root;
    }
}