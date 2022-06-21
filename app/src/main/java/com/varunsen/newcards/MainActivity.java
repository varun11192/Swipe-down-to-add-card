package com.varunsen.newcards;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    ArrayList<Integer> list;
    ArrayAdapter<Integer> adapter;
    TextView cardCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        cardCount = findViewById(R.id.card_count);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        cardCount.setText("Total Cards : " + list.size());

        adapter = new ArrayAdapter<>(this, R.layout.card, list);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.add(list.size() + 1);
                adapter.notifyDataSetChanged();
                cardCount.setText("Total Cards : " + list.size());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
