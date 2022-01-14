package top.lc951.myandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chenyu.library.bannerViewPager.OnPageClickListener;
import com.chenyu.library.bannerViewPager.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BannerViewPagerDemo2 extends AppCompatActivity {
    public static String TAG = BannerViewPagerDemo2.class.getName();
    private ViewPager viewPager;
    private LinearLayout indicatorLayout;
    private List<ImageView> mViews;

    public static void actionActivity(Context context) {
        Intent intent = new Intent(context, BannerViewPagerDemo2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_view_pager_demo2);

        initViews();
        initData();
        setSelectedIndicator(0);
    }

    private void setSelectedIndicator(int index) {
        indicatorLayout.removeAllViews();
        for (int i = 0; i < mViews.size(); i++) {
            ImageView imageView = (ImageView) LayoutInflater.from(this).inflate(R.layout.indicator_item, indicatorLayout, false);
            if (index == i) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_rectangle_solid_fff_8_4));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_c_solid_d3d3d3_4_4));
            }
            indicatorLayout.addView(imageView);
        }
    }

    private void initData() {
        ImageView iv1 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);
        ImageView iv2 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);
        ImageView iv3 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);
        ImageView iv4 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);
        ImageView iv5 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);
        final ImageView iv6 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item, viewPager, false);


        iv1.setImageResource(R.mipmap.ic_img01);
        iv2.setImageResource(R.mipmap.ic_img02);
        iv3.setImageResource(R.mipmap.ic_img03);
        iv4.setImageResource(R.mipmap.ic_img04);
        iv5.setImageResource(R.mipmap.ic_img05);
        iv6.setImageResource(R.mipmap.ic_img06);

        //一开始只添加5个Item
        mViews = new ArrayList<>();
        mViews.add(iv1);
        mViews.add(iv2);
        mViews.add(iv3);
        mViews.add(iv4);
        mViews.add(iv5);

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(mViews, new OnPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Log.d(TAG, "position:" + position);
            }
        });
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    int scrollState = ViewPager.SCROLL_STATE_IDLE;
    private int lastValue = -1;
    private boolean canMove = true;
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.i(TAG, "position=" + position + ",positionOffset=" + positionOffset + " ,positionOffsetPixels=" + positionOffsetPixels);
            if (scrollState == ViewPager.SCROLL_STATE_DRAGGING) {
                if (lastValue > positionOffsetPixels) {
                    Log.d(TAG, "向右滑动");
                } else if (lastValue < positionOffsetPixels) {
                    Log.d(TAG, "向左滑动");
                } else {
                    Log.e(TAG, "暂无法判断滑动方向");
                }
                if (0.0f == positionOffset && 0 == positionOffsetPixels) {
                    canMove = false;
                } else {
                    canMove = true;
                }
            }
            lastValue = positionOffsetPixels;
        }

        @Override
        public void onPageSelected(int i) {
            Log.d(TAG, "onPageSelected index=" + i);
            setSelectedIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            Log.d(TAG, "onPageScrollStateChanged i=" + i);

            if (ViewPager.SCROLL_STATE_DRAGGING == scrollState
                    && i == ViewPager.SCROLL_STATE_IDLE
                    && !canMove
            ) {
                if ( 0==viewPager.getCurrentItem() ) {
                    Log.d(TAG, "已在第一页了" + viewPager.getCurrentItem());
                }else{
                    Log.d(TAG, "已在最后一页了" + viewPager.getCurrentItem());
                    viewPager.setCurrentItem(0);
                }
            }
            scrollState = i;
        }
    };

    private void initViews() {
        viewPager = findViewById(R.id.view_pager);
        indicatorLayout = findViewById(R.id.layout_indicator);
    }
}