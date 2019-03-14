package com.opsigte.demo.jump;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.opsigte.demo.R;

public class ActivityJumpActivity extends AppCompatActivity {

    private Button jumpBtn,jumpBtn2,jumpBtn3,jumpBtn4;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        tv = findViewById(R.id.jump_tv1);

        jumpBtn = findViewById(R.id.jump_btn1);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式跳转到ActivityJump2Activity
//                Intent intent = new Intent(ActivityJumpActivity.this, ActivityJump2Activity.class);
//                startActivity(intent);

                // 隐式跳转（必须在要跳转的Activity的AndroidManifest.xml中声明action android:name 和category android:name）
                Intent intent2 = new Intent();
                intent2.setAction("com.opsigte.demo.jump.ActivityJump2Activity");
                Bundle bundle = new Bundle();
                bundle.putString("value","我是隐式跳转传来的值");
                intent2.putExtras(bundle);
                startActivity(intent2);
            }
        });

        jumpBtn2 = findViewById(R.id.jump_btn2);
        jumpBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转并赋值
                Intent intent = new Intent(ActivityJumpActivity.this, ActivityJump2Activity.class);

                Bundle bundle = new Bundle();
                bundle.putString("value","我是ActivityJumpActivity传来的值");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        jumpBtn3 = findViewById(R.id.jump_btn3);
        jumpBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 传值并且接受下一个Activity返回的值
                Intent intent = new Intent(ActivityJumpActivity.this, ActivityJump2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("reqValue","传给你的值，麻烦返回通知我一声");
                intent.putExtras(bundle);
                // requestCode 是为了判断下一个Activity返回的是点击哪一个按钮跳转的（万一有多个按钮）
                startActivityForResult(intent,1);

            }
        });

        jumpBtn4 = findViewById(R.id.jump_btn4);
        jumpBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用系统通讯录应用
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.PICK");
//                intent.addCategory("android.intent.category.DEFAULT");
//                intent.setType("vnd.android.cursor.dir/phone_v2");
//                startActivityForResult(intent, 0x30);

                // 调用系统拨号功能 （要给权限）
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:13697103161"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        /**
         * 此时，点击返回键时也会回调此方法，并且resultCode=0,data=null
         * 所以要做判断时应该判断这两个是否匹配
         */
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("onActivityResult", "testtest");
        if (resultCode == 1) {
            Bundle bundle = data.getExtras();
            Log.d("resultCode:", bundle.getString("resValue"));

            tv.setText(bundle.getString("resValue"));
        }
    }
}
