package com.ubpost.swipebackactivitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * SwipeBackLayout 的使用
 * 实现滑动退出Activity的效果
 * 1-导入依赖Jar包
 * 2-Activity继承自库中的SwipeBackActivity
 * 3-所有滑动退出Activity的主题的windowIsTranslucent设置为true，这样滑动时屏幕不会变黑
 * 4-可以添加窗体进入/退出动画，实现更好的效果（参考本Demo的styles.xml）
 */
public class MainActivity extends SwipeBackActivity {

    private MainActivity activity;
    private Button btn01;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        btn01 = (Button) findViewById(R.id.btn01);
        setSwipeBack();//设置滑动退出
        setOnclick();
    }

    private void setSwipeBack() {
        //可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);
        swipeBackLayout = getSwipeBackLayout();
        //设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        //滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        //该方法也会使得上下边界300距离不能滑动退出（当左滑退出时）
        //swipeBackLayout.setEdgeSize(300);
    }

    private void setOnclick() {
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Btn01Activity.class);
                startActivity(intent);
            }
        });
    }
}
