# MyAndroid

#### 介绍
Android开发组件和模块功能DEMO，干货满满。拿来即用


#### 软件架构
1.  app模块为DEMOs集
2.  每个XXDemo对应一个XX库模块



#### 安装教程

1.  git clone https://gitee.com/lc951/my-android.git


#### 使用说明

1.  IDE:Android studio 构建
2.  如果xxx库满足需要即可import module 选中目标xxx库目录即可导入到自己工程
3.  如有问题请提交wiki里

#### 1）轮播图
![轮播图](./static/轮播图_2022-01-13-14-06-11.gif)
参考代码示例如下：

``
        
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
``


#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

