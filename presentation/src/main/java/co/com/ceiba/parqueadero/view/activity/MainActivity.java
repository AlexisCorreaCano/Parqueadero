package co.com.ceiba.parqueadero.view.activity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.view.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabVehicle = findViewById(R.id.tab_vehicles);
        ViewPager viewPager = findViewById(R.id.view_pager_vehicles);
        
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabVehicle.setupWithViewPager(viewPager);

    }

}