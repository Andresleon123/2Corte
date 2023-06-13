package app.program.a2corte.data;

import android.content.ContentValues;
import android.database.Cursor;

public class Persona {
    private int idPersona;
    private String nombrePersona;
    private String passwordPersona;

    public Persona(int idPersona, String nombrePersona, String passwordPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.passwordPersona = passwordPersona;
    }

    public Persona(Cursor cursor) {
        idPersona = cursor.getInt(cursor.getColumnIndex(PersonaCont.PersonaEntry.ID));
        nombrePersona= cursor.getString(cursor.getColumnIndex( PersonaCont.PersonaEntry.NAME));
        passwordPersona = cursor.getString( cursor.getColumnIndex( PersonaCont.PersonaEntry.PASSWORD ) );
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put( PersonaCont.PersonaEntry.ID, idPersona);
        values.put(PersonaCont.PersonaEntry.NAME, nombrePersona);
        values.put(PersonaCont.PersonaEntry.PASSWORD,passwordPersona);
        return values;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }
}