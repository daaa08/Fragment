package com.example.da08.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListFragment list;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFragments();
        addList();

    }

    private void createFragments(){
        list = new ListFragment();  // ListFragment 연결
        list.setActivity(this);
        detail = new DetailFragment();  // DetailFragment 연결
        detail.setActivity(this);
    }

    public void addList(){
        /*
          Fragment 화면에 넣기
        */
        // 1 프래그먼트 트랜잭션 시작하기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 2 화면에 프래그먼트 넣
        transaction.add(R.id.container, list);
        // 3 트랜젝션 완료
        transaction.commit();
    }
    public void addDetail(){
        // 하위 버전 호환성을 감안
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, detail);
        // 트랜젝션 처리 전체를 스택에 담아놨다가 안드로이드의 백 버튼으로 뒤로가기를 할 수 있다
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void backToList(){
        super.onBackPressed();  // 뒤로가기 효과를 줌
    }
}
