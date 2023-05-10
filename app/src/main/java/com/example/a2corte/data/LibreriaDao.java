package com.example.a2corte.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.a2corte.data.LibreriaCont.LibreriaEntry;

public class LibreriaDao extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION2 = 1;
    public static final String TABLE_LIBRERIA = "Libreria.db";

    public LibreriaDao(Context context) {
        super(context, TABLE_LIBRERIA, null, DATABASE_VERSION2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LibreriaEntry.TABLE_LIBRERIA2 + " ("
                + LibreriaEntry._COUNT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LibreriaEntry.CODIGO + " INTEGER NOT NULL,"
                + LibreriaEntry.LIBROCOMPRA + " TEXT NOT NULL,"
                + LibreriaEntry.AUTOR + " TEXT NOT NULL,"
                + "UNIQUE (" + LibreriaEntry.CODIGO + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveLibreria(Libreria ComprarL) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                LibreriaEntry.TABLE_LIBRERIA2,
                null,
                libreria.toContentValues());

    }

    public Cursor getAllLibreria() {
        return getReadableDatabase()
                .query(
                        LibreriaEntry.TABLE_LIBRERIA2,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLibreriaById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                LibreriaEntry.TABLE_LIBRERIA2,
                null,
                LibreriaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public int deleteLibreria(String lawyerId) {
        return getWritableDatabase().delete(
                LibreriaEntry.TABLE_LIBRERIA2,
                LibreriaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId});
    }

    public int updateLibreria(Libreria persona, String lawyerId) {
        return getWritableDatabase().update(
                LibreriaEntry.TABLE_LIBRERIA2,
                persona.toContentValues(),
                LibreriaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId}
        );
    }
}
