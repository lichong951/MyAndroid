package top.lc951.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class BannerViewPagerDemo extends AppCompatActivity {

    public static void actionActivity(Context context){
        Intent intent=new Intent(context,BannerViewPagerDemo.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_view_pager_demo);
    }
}