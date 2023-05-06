package com.example.a2corte.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.a2corte.data.PersonaCont.PersonaEntry;

public class Daolibreria extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Libreria.db";

    public Daolibreria(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PersonaEntry.TABLE_NAME + " ("
                + PersonaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaEntry.ID + " INTEGER NOT NULL,"
                + PersonaEntry.NAME + " TEXT NOT NULL,"
                + PersonaEntry.PASSWORD + " TEXT NOT NULL,"
                + "UNIQUE (" + PersonaEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long savePersona(Persona persona) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                PersonaEntry.TABLE_NAME,
                null,
                persona.toContentValues());

    }

    public Cursor getAllPersonas() {
        return getReadableDatabase()
                .query(
                        PersonaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getPersonaById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                PersonaEntry.TABLE_NAME,
                null,
                PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public int deletePersona(String lawyerId) {
        return getWritableDatabase().delete(
                PersonaEntry.TABLE_NAME,
                PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId});
    }

    public int updatePersona(Persona persona, String lawyerId) {
        return getWritableDatabase().update(
                PersonaEntry.TABLE_NAME,
                persona.toContentValues(),
                PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId}
        );
    }
}
