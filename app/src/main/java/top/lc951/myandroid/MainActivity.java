package top.lc951.myandroid;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTOBannerVP1(View view){
        BannerViewPagerDemo.actionActivity(this);
    }
    public void goTOBannerVP2(View view){
        BannerViewPagerDemo2.actionActivity(this);
    }
}