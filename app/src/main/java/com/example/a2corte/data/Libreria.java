package com.example.a2corte.data;

import android.content.ContentValues;
import android.database.Cursor;

import static com.example.a2corte.data.PersonaCont.PersonaEntry;

public class Libreria {
    private int codigo;
    private String libroCompra;
    private String autorr;

    public Libreria(int Codigo, String LibroCompra, String Autor) {
        this.codigo = Codigo;
        this.libroCompra = LibroCompra;
        this.autorr = Autor;
    }

    public Libreria(Cursor cursor) {
        codigo = cursor.getInt(cursor.getColumnIndex(PersonaEntry.CODIGO));
        libroCompra= cursor.getString(cursor.getColumnIndex( PersonaEntry.LIBROCOMPRA));
        autorr = cursor.getString( cursor.getColumnIndex( PersonaEntry.AUTOR ) );
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
            values.put( PersonaEntry.CODIGO, codigo);
        values.put(PersonaEntry.LIBROCOMPRA, libroCompra);
        values.put(PersonaEntry.AUTOR,autorr);
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
        return autorr;
    }

    public void setautorr(String autorr) {
        this.autorr = autorr;
    }
}