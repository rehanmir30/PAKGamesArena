package co.yactech.pakgamesarena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    LinearLayout toptab;
    TextView fragment_name;
    ImageView back;

    FragmentProfile profile;
    FragmentWallet wallet;
    FragmentLive live;
    FragmentSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.nav);
        frameLayout = findViewById(R.id.main_frame);
        toptab = findViewById(R.id.toptab);
        fragment_name = findViewById(R.id.fragment_name);
        back = findViewById(R.id.back);

        profile = new FragmentProfile();
        wallet = new FragmentWallet();
        live = new FragmentLive();
        settings = new FragmentSettings();

        firstfragment(profile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                setfragment(profile);

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.profile:
                        setfragment(profile);
                        return true;

                    case R.id.wallet:
                        setfragment(wallet);
                        return true;

                    case R.id.live:
                        setfragment(live);
                        return true;

                    case R.id.settings:
                        setfragment(settings);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void firstfragment(Fragment fragment) {
        toptab.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    private void setfragment(Fragment fragment) {

        if (fragment == profile) {
            toptab.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();
        }
        if (fragment == wallet) {
            toptab.setVisibility(View.VISIBLE);
            fragment_name.setText("Wallet");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();
        }
        if (fragment == live) {
            toptab.setVisibility(View.VISIBLE);
            fragment_name.setText("Live");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();
        }
        if (fragment == settings) {
            toptab.setVisibility(View.VISIBLE);
            fragment_name.setText("Settings");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, fragment);
            fragmentTransaction.commit();
        }

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.main_frame, fragment);
//        fragmentTransaction.commit();
    }

}
