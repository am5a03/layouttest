package dnomyar.layouttest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dnomyar.layouttest.activities.MediaPlayerActivity;
import dnomyar.layouttest.activities.SingleFragmentActivity;
import dnomyar.layouttest.news.News;
import dnomyar.layouttest.news.NewsAdapter;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchException;

public class MainActivity extends AppCompatActivity {


    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private List<News> mNewsList;
    private NewsAdapter mNewsAdapter;
    private Branch sBranch;

    private Context mApplicationContext;

    @Override
    protected void onStart() {
        super.onStart();
        sBranch = MyApplication.sBranch;
        JSONObject latest = sBranch.getLatestReferringParams();
        Log.i("branchioLatest", latest.toString());
        sBranch.initSession(new Branch.BranchReferralInitListener() {

            @Override
            public void onInitFinished(JSONObject jsonObject, BranchError branchError) {
                Log.i("branchio", jsonObject.toString());
            }
        }, this.getIntent().getData(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        this.setIntent(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        mApplicationContext = getApplicationContext();

        setContentView(R.layout.activity_main);
        setWindows();
        initNewsFeed();
        setActionbar();
        setupRecyclerView();
        loadAppbarImage();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MediaPlayerActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_single_fragment) {
            Intent intent = new Intent(this, SingleFragmentActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setWindows() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.indigo_700));
    }

    private void initNewsFeed() {
        mNewsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            News news = News.Builder.newBuilder()
                    .setHeader("Headline " + i)
                    .setContent("Content " + i)
                    .setThumbnail("http://pooyak.com/p/progjpeg/jpegload.cgi?o=1")
                    .build();
            mNewsList.add(news);
        }
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mNewsAdapter = new NewsAdapter(mNewsList);
        mRecyclerView.setAdapter(mNewsAdapter);

    }

    private void setActionbar() {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.hello_world));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
        ab.setTitle(getString(R.string.hello_world)); //Not working if using CollapsingToolbarLayout

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_item_1, R.string.drawer_item_2) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState(); //Hamburger menu animation!
    }

    private void loadAppbarImage() {
        String uri = "@drawable/example";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        ImageView imageView = (ImageView) findViewById(R.id.headerImg);
        Drawable res = getResources().getDrawable(imageResource);
        imageView.setImageDrawable(res);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
