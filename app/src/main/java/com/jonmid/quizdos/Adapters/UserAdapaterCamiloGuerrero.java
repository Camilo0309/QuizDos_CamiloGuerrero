package com.jonmid.quizdos.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.quizdos.Models.UserModelCamiloGuerrero;
import com.jonmid.quizdos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CAMILO on 10/10/2017.
 */

public class UserAdapaterCamiloGuerrero  extends RecyclerView.Adapter<UserAdapaterCamiloGuerrero.ViewHolder>{

    List<UserModelCamiloGuerrero> userModelCamiloGuerreroList = new ArrayList<>();
    Context context;
    // Constructor de la clase
    public UserAdapaterCamiloGuerrero(List<UserModelCamiloGuerrero> userModelCamiloGuerreroList, Context context) {
        this.userModelCamiloGuerreroList = userModelCamiloGuerreroList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Configuracion del ViewAdapter
// Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_user, parent, false);
// Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Encargado de trabajar con el item.xml y sus componentes
        holder.textViewName.setText(userModelCamiloGuerreroList.get(position).getName());
        holder.textusername.setText(userModelCamiloGuerreroList.get(position).getUsername());
        holder.textemail.setText(userModelCamiloGuerreroList.get(position).getEmail());
        holder.textphone.setText(userModelCamiloGuerreroList.get(position).getPhone());
        holder.textnamecompany.setText(userModelCamiloGuerreroList.get(position).getNamecompany());
        holder.textaddress.setText(userModelCamiloGuerreroList.get(position).getAddress());

    }
    @Override
    public int getItemCount() {
        return userModelCamiloGuerreroList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textusername, textemail, textphone, textnamecompany, textaddress;


        public ViewHolder(View item) {
            super(item);
            textViewName = (TextView) item.findViewById(R.id.id_tv_userinput_name);
            textusername = (TextView) item.findViewById(R.id.id_tv_userinput_name);
            textemail = (TextView) item.findViewById(R.id.id_tv_userinput_name);
            textphone = (TextView) item.findViewById(R.id.id_tv_userinput_name);
            textnamecompany = (TextView) item.findViewById(R.id.id_tv_userinput_name);
            textaddress = (TextView) item.findViewById(R.id.id_tv_userinput_name);


        }
    }
}

