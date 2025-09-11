package com.example.infogram.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.infogram.R;
import com.example.infogram.view.fractmen.homeFragment;
import com.example.infogram.view.fractmen.profileFragment;
import com.example.infogram.view.fractmen.searchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class containeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containe);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation_view);

        // Mostrar fragment por defecto (opcional)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_frame, new homeFragment())
                .commit();
        // y opcionalmente marcar el item correspondiente en el BottomNavigation:
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int id = item.getItemId();
                if (id == R.id.search) {
                    selectedFragment = new searchFragment();
                } else if (id == R.id.home) {
                    selectedFragment = new homeFragment();
                } else if (id == R.id.profile) {
                    selectedFragment = new profileFragment();
                }

                // Solo hacer la transacción si tenemos un fragment válido
                if (selectedFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_frame, selectedFragment)
                            .commit();
                }

                return true;
            }
        });
    }
}
