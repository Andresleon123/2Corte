package com.example.a2corte.data;

import android.content.ContentValues;
import android.database.Cursor;

import static com.example.a2corte.data.LibreriaCont.LibreriaEntry;

public class Libreria {
    private int codigo;
    private String libroCompra;
    private String autor;

    public Libreria(int Codigo, String LibroCompra, String Autor) {
        this.codigo = Codigo;
        this.libroCompra = LibroCompra;
        this.autor = Autor;
    }

    public Libreria(Cursor cursor) {
        codigo = cursor.getInt(cursor.getColumnIndex(LibreriaCont.LibreriaEntry.CODIGO));
        libroCompra= cursor.getString(cursor.getColumnIndex( LibreriaCont.LibreriaEntry.LIBROCOMPRA));
        autor = cursor.getString( cursor.getColumnIndex( LibreriaCont.LibreriaEntry.AUTOR ) );
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
            values.put( LibreriaCont.LibreriaEntry.CODIGO, codigo);
        values.put(LibreriaCont.LibreriaEntry.LIBROCOMPRA, libroCompra);
        values.put(LibreriaCont.LibreriaEntry.AUTOR, autor);
        return values;
    }

    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getlibroCompra() {
        return libroCompra;
    }

    public void setlibroCompra(String libroCompra) {
        this.libroCompra = libroCompra;
    }

    public String getautorr() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }
}