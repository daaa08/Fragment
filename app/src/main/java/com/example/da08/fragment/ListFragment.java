package com.example.da08.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    MainActivity activity;

    public ListFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity activity){

        this.activity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프래그먼트의 메인 레이아웃을 인플레이트하고
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // 안의 위젯들을 코드에 연결한다
        Button btnDetail = (Button)view.findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.addDetail();
            }
        });
        return view;
    }

}
