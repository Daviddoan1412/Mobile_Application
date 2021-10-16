package vn.edu.usth.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        //Add tabs icon with setIcon() or simple text with .setText()
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.home_tap));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.group_tap));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.user_tap));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.video_tap));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.menu_tap));

        //Add fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home());
        adapter.addFragment(new Group());
        adapter.addFragment(new Profile());
        adapter.addFragment(new Watch());
        adapter.addFragment(new Menu());

        //Setting adapter
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
}