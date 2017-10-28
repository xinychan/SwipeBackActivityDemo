package com.ubpost.swipebackactivitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class Btn01Activity extends SwipeBackActivity {

    private Btn01Activity activity;
    private Button btn02;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01);
        activity = this;
        btn02 = (Button) findViewById(R.id.btn02);
        setSwipeBack();
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
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Btn02Activity.class);
                startActivity(intent);
            }
        });
    }
}
