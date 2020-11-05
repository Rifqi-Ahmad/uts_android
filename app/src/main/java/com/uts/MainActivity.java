package com.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //inisiasi input
    private EditText ETtt, ETut, ETnom, ETjt;

    //inisiasi button
    private Button Btntambah, Btnreport;

    //inisiasi listdata
    private ListView LVdata;
    private DataAdapter adapter;

    //inisiasi random int
    private Random rand = new Random();

    private ArrayList<Data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LVdata = (ListView) findViewById(R.id.LVdata);

        ETtt = (EditText) findViewById(R.id.ETtt);
        ETut = (EditText) findViewById(R.id.ETut);
        ETnom = (EditText) findViewById(R.id.ETnom);
        ETjt = (EditText) findViewById(R.id.ETjt);

        list = new ArrayList<Data>();
        adapter = new DataAdapter(getApplicationContext(), R.layout.list_data, list);

        Btntambah = (Button) findViewById(R.id.Btntambah);
        Btnreport = (Button) findViewById(R.id.Btnreport);

        Btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int r = rand.nextInt(9999 - 1000) + 1000;

                String id = String.valueOf(r);
                String tgl = ETtt.getText().toString();
                String uraian = ETut.getText().toString();
                String nom = ETnom.getText().toString();
                String jenis = ETjt.getText().toString();

                Data item = new Data();

                item.setId(id);
                item.setTgl(tgl);
                item.setUraian(uraian);
                item.setNom(nom);
                item.setJenis(jenis);

                list.add(item);

                LVdata.setAdapter(adapter);
            }
        });
        LVdata.setAdapter(adapter);

    }

}