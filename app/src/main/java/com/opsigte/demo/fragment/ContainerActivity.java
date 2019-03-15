package com.opsigte.demo.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.opsigte.demo.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnclickMessage {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        tv = findViewById(R.id.container_tv);

        // 设置默认的Fragment
        // 向指定id的Framgent添加Fragment视图
        AFragment aFragment = AFragment.newInstance("我是动态传递的参数");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment1, aFragment,"a").commitAllowingStateLoss();
    }

    /**
     * 可以使用公开方法设置Activity视图中组件值
     * @param text
     */
    public void setData(String text){
        tv.setText(text);
    }

    /**
     * 也可以使用回调接口的方式设置Activity视图中组件值
     * @param text
     */
    @Override
    public void onclickSetData(String text) {
        tv.setText(text);
    }
}
