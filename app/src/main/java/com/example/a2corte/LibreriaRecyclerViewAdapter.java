package com.example.a2corte;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a2corte.data.Libreria;

public class LibreriaRecyclerViewAdapter extends RecyclerView.Adapter<LibreriaRecyclerViewAdapter.ViewHolder>{

    private Cursor cursorListaLibros;
    private OnItemClickListener listenerClick;

    public LibreriaRecyclerViewAdapter(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, Libreria libreriaActualizada);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.usuario_item_layout,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cursorListaLibros.moveToPosition(position);
        Libreria personaSeleccionada = new Libreria( cursorListaLibros );
        holder.codigo.setText( Integer.toString(personaSeleccionada.getcodigo()) );
        holder.libroCompra.setText( personaSeleccionada.getlibroCompra() );
        holder.autor.setText( personaSeleccionada.getautorr() );
    }

    @Override
    public int getItemCount() {
        if (cursorListaLibros!=null)
            return cursorListaLibros.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaLibros = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView codigo;
        TextView libroCompra;
        TextView autor;

        public ViewHolder(View itemView) {
            super( itemView );
            codigo = (TextView) itemView.findViewById( R.id.codigo );
            libroCompra = (TextView) itemView.findViewById( R.id.libroCompra );
            autor = (TextView) itemView.findViewById( R.id.autor );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            Libreria libreriaActualizada = obtenerUsuario( getAdapterPosition() );
            libreriaActualizada.setNombrelibro( "LEON" );
            listenerClick.onClick( this,LibreriaActualizada );
        }
    }

    private Libreria obtenerUsuario (int posicion){
        if (cursorListaLibros!=null){
            cursorListaLibros.moveToPosition( posicion );
            Libreria nuevoUsuario = new Libreria( cursorListaLibros );
            return nuevoUsuario;
        }
        return null;
    }

}