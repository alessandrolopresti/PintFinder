package com.example.pintfinder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListBookingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListBookingsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bookings);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Booking> bookings = SingletonUsers.Instance().getBookings();


        adapter = new ListBookingsAdapter(this, bookings);
        recyclerView.setAdapter(adapter);


        if (adapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            findViewById(R.id.no_tasted_beers).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ListBookingsActivity.this, HomePageLover.class);
        startActivity(i);
    }
}