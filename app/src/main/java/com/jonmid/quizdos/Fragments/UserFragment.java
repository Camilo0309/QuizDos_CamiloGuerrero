package com.jonmid.quizdos.Fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jonmid.quizdos.Adapters.UserAdapaterCamiloGuerrero;
import com.jonmid.quizdos.Connection.HttpManagerCamiloGuerrero;
import com.jonmid.quizdos.Models.UserModelCamiloGuerrero;
import com.jonmid.quizdos.Parser.UserJsonCamiloGuerrero;
import com.jonmid.quizdos.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    UserModelCamiloGuerrero userModelCamiloGuerrero;
    UserAdapaterCamiloGuerrero userAdapaterCamiloGuerrero;
    List<UserModelCamiloGuerrero> userModelCamiloGuerreroList;
    RecyclerView recyclerView;
    ProgressBar progressBar;



    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);


    }

    public class TaskCountry extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManagerCamiloGuerrero.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                userModelCamiloGuerreroList = UserJsonCamiloGuerrero.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            processData();
            progressBar.setVisibility(View.GONE);
            super.onPostExecute(s);


        }
    }


    public void processData(){
        userAdapaterCamiloGuerrero = new UserAdapaterCamiloGuerrero(userModelCamiloGuerreroList, getActivity());
        recyclerView.setAdapter(userAdapaterCamiloGuerrero);
    }
    /*public Boolean isOnLine(){
// Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager)

// Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
// Validar el estado obtenido de la conexion
        if (networkInfo != null){
            return true;
        }else {
            return false;
        }
    }
    */
    public void loadData(View view){

            TaskCountry taskCountry = new TaskCountry();
            taskCountry.execute("https://jsonplaceholder.typicode.com/users");

    }



}
