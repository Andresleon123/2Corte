package app.program.a2corte;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2corte.R;

import app.program.a2corte.data.Daolibreria;
import app.program.a2corte.data.Persona;


public class InicioFragment extends Fragment implements View.OnClickListener,PersonaRecyclerViewAdapter.OnItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button registrar;
    private Button login;
    private RecyclerView listaPersonas;
    private PersonaRecyclerViewAdapter adaptadorPersona;
    private LinearLayoutManager linearLayoutManager;
    private Daolibreria dbLibreria;

    public InicioFragment() {
        // Required empty public constructor
    }

    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_inicio, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        registrar = (Button) view.findViewById( R.id.entrar );
        login = (Button) view.findViewById( R.id.registrarse );
        registrar.setOnClickListener( this );
        login.setOnClickListener( this );
        // RecyclerView
        listaPersonas = (RecyclerView) view.findViewById( R.id.listaPersonasRV );
        dbLibreria = new Daolibreria( this.getContext() );
        listaPersonas.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( this.getContext() );
        listaPersonas.setLayoutManager( linearLayoutManager );
        adaptadorPersona = new PersonaRecyclerViewAdapter( this );
        listaPersonas.setAdapter( adaptadorPersona );
        loadUsuarios();
        super.onViewCreated( view, savedInstanceState );
    }

    private void loadUsuarios() {
        new UsuarioLoaderTask().execute( );
    }

    private class UsuarioLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbLibreria.getAllPersonas();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptadorPersona.swapCursor( cursor );
            }
        }
    }

    @Override
    public void onClick(PersonaRecyclerViewAdapter.ViewHolder view, Persona personaActualizado) {
        dbLibreria.updatePersona(personaActualizado,Integer.toString(personaActualizado.getIdPersona()));
        loadUsuarios();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.entrar:
                Navigation.findNavController( view ).navigate( R.id.terceraBlankFragment );
                break;
            case R.id.registrarse:
                Navigation.findNavController( view ).navigate( R.id.segundoBlankFragment );
                break;
        }
    }
}