package com.jonmid.quizdos.Parser;

import com.jonmid.quizdos.Models.UserModelCamiloGuerrero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CAMILO on 10/10/2017.
 */

public class UserJsonCamiloGuerrero {

    public static List<UserModelCamiloGuerrero> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<UserModelCamiloGuerrero> userModelCamiloGuerreroList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            UserModelCamiloGuerrero userModelCamiloGuerrero = new UserModelCamiloGuerrero();
            userModelCamiloGuerrero.setName(item.getString("name"));
            userModelCamiloGuerrero.setUsername(item.getString("username"));
            userModelCamiloGuerrero.setEmail(item.getString("email"));
            userModelCamiloGuerrero.setPhone(item.getString("phone"));
            JSONObject company = item.getJSONObject("company");
            company.getString("name");
            JSONObject address = item.getJSONObject("address");




            photosList.add(photos);
        }
        return photosList;
    }

}
