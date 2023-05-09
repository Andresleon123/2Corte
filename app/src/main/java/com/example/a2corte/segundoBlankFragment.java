package com.example.a2corte;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a2corte.data.Daolibreria;
import com.example.a2corte.data.Persona;

public class segundoBlankFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnRegistrar;
    private EditText id;
    private EditText name;
    private EditText password;
    private Daolibreria Dao;


    public segundoBlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
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
        return inflater.inflate( R.layout.fragment_segundo_blank, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Daolibreria DAO = new Daolibreria( view.getContext());
        id = (EditText) view.findViewById( R.id.id );
        EditText usuarioR = (EditText) view.findViewById(R.id.usuarioR);
        name = (EditText) view.findViewById( R.id.contrasena) ;
        btnRegistrar = (Button) view.findViewById( R.id.ingresar );
        btnRegistrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona personaagardar = new Persona(
                        Integer.parseInt(id.getText().toString()),
                        usuarioR.getText().toString(),
                        name.getText().toString()
                );
                DAO.savePersona(personaagardar);
            }
        } );
        super.onViewCreated( view, savedInstanceState );
    }
}