package com.opsigte.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.opsigte.demo.R;

public class AFragment extends Fragment {

    private TextView tv;
    private Button btn,btn2,btn3;
    private BFragment bFragment;
    private IOnclickMessage iOnclickMessage;

    public static AFragment newInstance(String text){
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    // 此方法在Activity与Fragment刚发生关系时调用
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 因为ContainerActivity已经实现了IOnClickMessage接口，所以可以强制转换
        try {
            iOnclickMessage = (IOnclickMessage) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity必须实现IOnClickMessage接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("onCreateView", "----onCreateView----");
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv = view.findViewById(R.id.afragment_tv);
//        tv.setText("我是AFragment");
        // 动态获取，在Activity调用此Fragment时传递
        if (getArguments() != null) {
            tv.setText(getArguments().getString("text"));
        }

        btn = view.findViewById(R.id.change_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                /**
                 * 使用replace会先remove掉之前的Fragment，然后在新增一个Fragment,
                 * 所以会导致在bFragment点击返回时，重新回调了onViewCreated方法，之前的视图上的数据也被清空了
                 * 解决方法：使用hide() 和 add()来代替replace()
                 */
//                getFragmentManager().beginTransaction().replace(R.id.fragment1, bFragment).addToBackStack(null).commitAllowingStateLoss();
                // 根据tag找到fragment(此时就是AFragment)
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fragment1, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.fragment1, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });

        btn2 = view.findViewById(R.id.change_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("更换为新文字");
            }
        });


        btn3 = view.findViewById(R.id.change_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用Activity中定义的公共方法赋值给Activity
//                ((ContainerActivity)getActivity()).setData("改变后的Activity组件值");

                // 使用回调接口的方式赋值给Activity
                iOnclickMessage.onclickSetData("更新的Activity组件值");
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public interface IOnclickMessage{
        void onclickSetData(String text);
    }

}
