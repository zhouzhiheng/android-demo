package com.opsigte.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.opsigte.demo.fragment.ContainerActivity;
import com.opsigte.demo.gridview.GridViewActivity;
import com.opsigte.demo.jump.ActivityJumpActivity;
import com.opsigte.demo.listView.ListViewActivity;
import com.opsigte.demo.recyclerview.RecyclerActivity;
import com.opsigte.demo.toast.ToastActivity;
import com.opsigte.demo.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnTextView;
    private Button btnButtonView;
    private Button btnEditTextView;
    private Button btnRadioButtonView;
    private Button btnCheckButtonView;
    private Button btnImageView;
    private Button btnListView;
    private Button btnGridView;
    private Button btnRecyclerView;
    private Button btnWebView;
    private Button btnToastView;
    private Button btnJumpView;
    private Button btnFragmentView;

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnTextView.setOnClickListener(onClick);
        btnButtonView.setOnClickListener(onClick);
        btnEditTextView.setOnClickListener(onClick);
        btnRadioButtonView.setOnClickListener(onClick);
        btnCheckButtonView.setOnClickListener(onClick);
        btnImageView.setOnClickListener(onClick);
        btnListView.setOnClickListener(onClick);
        btnGridView.setOnClickListener(onClick);
        btnRecyclerView.setOnClickListener(onClick);
        btnWebView.setOnClickListener(onClick);
        btnToastView.setOnClickListener(onClick);
        btnJumpView.setOnClickListener(onClick);
        btnFragmentView.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_text_view:
                    intent = new Intent(MainActivity.this,TextVIewActivity.class);
                    break;
                case R.id.btn_button_view:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext_view:
                    intent = new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radioButton_view:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_CheckButton_view:
                    intent = new Intent(MainActivity.this, CheckButtonActivity.class);
                    break;
                case R.id.btn_Image_view:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_list_view:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_grid_view:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recycler_view:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.btn_webview_view:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast_view:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_jump_view:
                    intent = new Intent(MainActivity.this, ActivityJumpActivity.class);
                    break;
                case R.id.btn_fragment_view:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("main");
        btnTextView = findViewById(R.id.btn_text_view);
        btnButtonView = findViewById(R.id.btn_button_view);
        btnEditTextView = findViewById(R.id.btn_edittext_view);
        btnRadioButtonView = findViewById(R.id.btn_radioButton_view);
        btnCheckButtonView = findViewById(R.id.btn_CheckButton_view);
        btnImageView = findViewById(R.id.btn_Image_view);
        btnListView = findViewById(R.id.btn_list_view);
        btnGridView = findViewById(R.id.btn_grid_view);
        btnRecyclerView = findViewById(R.id.btn_recycler_view);
        btnWebView = findViewById(R.id.btn_webview_view);
        btnToastView = findViewById(R.id.btn_toast_view);
        btnJumpView = findViewById(R.id.btn_jump_view);
        btnFragmentView = findViewById(R.id.btn_fragment_view);
        setListeners();
    }
}
