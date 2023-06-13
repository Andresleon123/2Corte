package app.program.a2corte.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Daolibreria extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Libreria.db";

    public Daolibreria(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PersonaCont.PersonaEntry.TABLE_NAME + " ("
                + PersonaCont.PersonaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaCont.PersonaEntry.ID + " INTEGER NOT NULL,"
                + PersonaCont.PersonaEntry.NAME + " TEXT NOT NULL,"
                + PersonaCont.PersonaEntry.PASSWORD + " TEXT NOT NULL,"
                + "UNIQUE (" + PersonaCont.PersonaEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long savePersona(Persona persona) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                PersonaCont.PersonaEntry.TABLE_NAME,
                null,
                persona.toContentValues());

    }

    public Cursor getAllPersonas() {
        return getReadableDatabase()
                .query(
                        PersonaCont.PersonaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getPersonaById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                PersonaCont.PersonaEntry.TABLE_NAME,
                null,
                PersonaCont.PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

    public int deletePersona(String lawyerId) {
        return getWritableDatabase().delete(
                PersonaCont.PersonaEntry.TABLE_NAME,
                PersonaCont.PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId});
    }

    public int updatePersona(Persona persona, String lawyerId) {
        return getWritableDatabase().update(
                PersonaCont.PersonaEntry.TABLE_NAME,
                persona.toContentValues(),
                PersonaCont.PersonaEntry.ID + " LIKE ?",
                new String[]{lawyerId}
        );
    }
}
