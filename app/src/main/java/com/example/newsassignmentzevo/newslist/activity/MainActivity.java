package com.example.newsassignmentzevo.newslist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsassignmentzevo.R;
import com.example.newsassignmentzevo.databinding.ActivityMainBinding;
import com.example.newsassignmentzevo.newslist.fragment.NewsList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getSupportFragmentManager().getBackStackEntryCount() > 0){
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                }else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });
        LoadNewsListFragment();
    }

    public void LoadNewsListFragment(){
        Fragment fragment = new NewsList();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                FragmentManager fm = getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                    return true;
                }
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}