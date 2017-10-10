package com.jonmid.quizdos;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.jonmid.quizdos.Fragments.CommentFragment;
import com.jonmid.quizdos.Fragments.UserFragment;

public class IndexActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.id_bn_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.id_menu_bn_user:
                        UserFragment userFragment = new UserFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.id_fl_views, userFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        Toast.makeText(IndexActivity.this, "Listar usuarios", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_menu_bn_comment:
                        CommentFragment commentFragment = new CommentFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.id_fl_views, commentFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        Toast.makeText(IndexActivity.this, "Listar comentarios", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
