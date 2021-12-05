package com.example.tugas7_1918029;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_makanan";
    private static final String tb_makanan = "tb_makanan";
    private static final String getTb_makanan_id = "id";
    private static final String getTb_makanan_nama = "nama";
    private static final String getTb_makanan_harga = "harga";
    private static final String CREATE_TABLE_MAKANAN = "CREATE TABLE " + tb_makanan +"("
            + getTb_makanan_id + " INTEGER PRIMARY KEY ,"
            + getTb_makanan_nama + " TEXT ,"
            + getTb_makanan_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAKANAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void Createmakanan(Makanan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_makanan_id, data.get_id());
        values.put(getTb_makanan_nama, data.get_nama_makanan());
        values.put(getTb_makanan_harga, data.get_harga());
        db.insert(tb_makanan, null, values);
        db.close();
    }
    public List<Makanan> Readmakanan() {
        List<Makanan> listMhs = new ArrayList<Makanan>();
        String selectQuery = "SELECT * FROM " + tb_makanan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Makanan data = new Makanan();
                data.set_id(cursor.getString(0));
                data.set_nama_makanan(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int Updatemakanan (Makanan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_makanan_nama, data.get_nama_makanan());
        values.put(getTb_makanan_harga, data.get_harga());
        return db.update(tb_makanan, values, getTb_makanan_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMakanan(Makanan data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_makanan,getTb_makanan_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

