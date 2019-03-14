package com.opsigte.demo.jump;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.opsigte.demo.R;

public class ActivityJump2Activity extends AppCompatActivity {

    private TextView tv1, tv2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump2);

        // 接受上一个Activity传过来的值
        tv1 = findViewById(R.id.jump2_tv);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("value") != null) {
            tv1.setText(bundle.getString("value"));
        }


        // 接受上一个Activity传过来的值，并返回给消息
        tv2 = findViewById(R.id.jump2_tv2);
        Bundle bundle2 = getIntent().getExtras();
        if (bundle2.getString("reqValue") != null) {
            tv2.setText(bundle2.getString("reqValue"));
        }

        btn = findViewById(R.id.jump2_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 此时，没有Inter也可以使用setResult返回到上一个Activity，但是必须使用finish()
                 */
//                setResult(1);
//                finish();


                Intent intent = new Intent(ActivityJump2Activity.this, ActivityJumpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("resValue", "我返回给你了");
                intent.putExtras(bundle);
                setResult(1, intent);
                finish();
            }
        });

    }
}
