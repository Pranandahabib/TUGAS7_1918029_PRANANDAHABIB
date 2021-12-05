package com.example.tugas7_1918029;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Makanan> Listmakanan = new
            ArrayList<Makanan>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, Listmakanan
        );
        mListView = (ListView) findViewById(R.id.list_kaoskaki);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        Listmakanan.clear();
        List<Makanan> kaoskakiList = db.Readmakanan();
        for (Makanan mhs : kaoskakiList) {
            Makanan daftar = new Makanan();
            daftar.set_id(mhs.get_id());
            daftar.set_nama_makanan(mhs.get_nama_makanan());
            daftar.set_harga(mhs.get_harga());
            Listmakanan.add(daftar);
            if ((Listmakanan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Makanan detailMhs = (Makanan) o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama_makanan();
        String Sharga = detailMhs.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama produk", Snama);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Listmakanan.clear();
        mListView.setAdapter(adapter_off);
        List<Makanan> makanan = db.Readmakanan();
        for (Makanan mhs : makanan) {
            Makanan daftar = new Makanan();
            daftar.set_id(mhs.get_id());
            daftar.set_nama_makanan(mhs.get_nama_makanan());
            daftar.set_harga(mhs.get_harga());
            Listmakanan.add(daftar);
            if ((Listmakanan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

