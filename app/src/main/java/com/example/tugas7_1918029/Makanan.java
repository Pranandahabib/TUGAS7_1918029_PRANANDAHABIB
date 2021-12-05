package com.example.tugas7_1918029;

public class Makanan {
    private String _id, _nama, _harga;
    public Makanan (String id, String nama, String harga) {
        this._id = id;
        this._nama = nama;
        this._harga = harga;
    }
    public Makanan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama_makanan() {
        return _nama;
    }
    public void set_nama_makanan(String _nama) {
        this._nama = _nama;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
