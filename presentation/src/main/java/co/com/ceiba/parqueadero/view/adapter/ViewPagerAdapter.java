package co.com.ceiba.parqueadero.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.com.ceiba.parqueadero.view.fragment.CarFragment;
import co.com.ceiba.parqueadero.view.fragment.MotorcycleFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = new CarFragment();
        }

        if (position == 1){
            fragment = new MotorcycleFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        //Todo colocar la constantes aca
        if (position == 0){
            title = "Cars";
        }

        if (position == 1){
            title = "Motorcycles";
        }

        return title;
    }
}
