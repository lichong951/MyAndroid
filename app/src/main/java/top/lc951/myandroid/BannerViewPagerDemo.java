package top.lc951.myandroid;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chenyu.library.bannerViewPager.BannerViewPager;
import com.chenyu.library.bannerViewPager.OnPageClickListener;
import com.chenyu.library.bannerViewPager.ViewPagerAdapter;
import com.example.indicatorlib.views.PageIndicatorView;
import com.example.indicatorlib.views.animation.type.AnimationType;

import java.util.ArrayList;
import java.util.List;

public class BannerViewPagerDemo extends AppCompatActivity {

    private BannerViewPager bannerViewPager;

    public static void actionActivity(Context context){
        Intent intent=new Intent(context,BannerViewPagerDemo.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_view_pager_demo);

        ImageView iv1 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv2 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv3 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv4 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);
        ImageView iv5 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);
        final ImageView iv6 = (ImageView) LayoutInflater.from(this).inflate(R.layout.banner_item,bannerViewPager,false);


        iv1.setImageResource(R.mipmap.ic_img01);
        iv2.setImageResource(R.mipmap.ic_img02);
        iv3.setImageResource(R.mipmap.ic_img03);
        iv4.setImageResource(R.mipmap.ic_img04);
        iv5.setImageResource(R.mipmap.ic_img05);
        iv6.setImageResource(R.mipmap.ic_img06);

        //一开始只添加5个Item
        final List<ImageView> mViews = new ArrayList<>();
        mViews.add(iv1);
        mViews.add(iv2);
        mViews.add(iv3);
        mViews.add(iv4);
        mViews.add(iv5);

        bannerViewPager = findViewById(R.id.banner);

        ViewPagerAdapter  mAdapter = new ViewPagerAdapter(mViews, new OnPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Log.d("cylog","position:"+position);
            }
        });
        bannerViewPager.setAdapter(mAdapter);
        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(bannerViewPager.getViewPager());
        pageIndicatorView.setAnimationType(AnimationType.WORM);


    }
}