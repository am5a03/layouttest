package dnomyar.layouttest.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dnomyar.layouttest.R;

/**
 * Created by Raymond on 2015-07-31.
 */
public class MainListFragment extends Fragment {

    private MainPostListAdapter adapter;

    public static MainListFragment newInstance() {

        Bundle args = new Bundle();

        MainListFragment fragment = new MainListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list_view, null);

        setToolbar(view);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        adapter = new MainPostListAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main_list);
        toolbar.setTitle("Main List");
    }

    protected static class MainPostListAdapter extends FragmentStatePagerAdapter {

        public MainPostListAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HotNewsListFragment.newInstance("hot");
                case 1:
                    return ListFragment.newInstance("trending");
                case 2:
                    return ListFragment.newInstance("fresh");
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Hot";
                case 1:
                    return "Trending";
                case 2:
                    return "Fresh";
            }
            return "";
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
