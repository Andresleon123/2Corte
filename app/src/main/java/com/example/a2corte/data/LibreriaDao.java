package com.example.a2corte.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.a2corte.data.PersonaCont.PersonaEntry;

public class LibreriaDao extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION2 = 1;
    public static final String TABLE_LIBRERIA = "Libreria.db";

    public LibreriaDao(Context context) {
        super(context, TABLE_LIBRERIA, null, DATABASE_VERSION2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PersonaEntry.TABLE_LIBRERIA2 + " ("
                + PersonaEntry._CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaEntry.CODIGO + " INTEGER NOT NULL,"
                + PersonaEntry.LIBROCOMPRA + " TEXT NOT NULL,"
                + PersonaEntry.AUTOR + " TEXT NOT NULL,"
                + "UNIQUE (" + PersonaEntry.CODIGO + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveLibreria(Libreria ComprarL) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                PersonaEntry.TABLE_LIBRERIA2,
                null,
                persona.toContentValues());

    }

    public Cursor getAllLibreria() {
        return getReadableDatabase()
                .query(
                        PersonaEntry.TABLE_LIBRERIA2,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLibreriaById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                PersonaEntry.TABLE_LIBRERIA2,
                null,
                PersonaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public int deleteLibreria(String lawyerId) {
        return getWritableDatabase().delete(
                PersonaEntry.TABLE_LIBRERIA2,
                PersonaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId});
    }

    public int updateLibreria(Libreria persona, String lawyerId) {
        return getWritableDatabase().update(
                PersonaEntry.TABLE_LIBRERIA2,
                persona.toContentValues(),
                PersonaEntry.CODIGO + " LIKE ?",
                new String[]{lawyerId}
        );
    }
}
