package com.example.actividadpaises;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class paises {
    String Nombre, imgpais;
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getimgpais() {
        return imgpais;
    }

    public void setimgpais(String img) {
        imgpais = imgpais;
    }


    public paises(String refPaises, JSONObject a) throws JSONException {
        Nombre =  a.getString("Name").toString();
        imgpais= "http://www.geognos.com/api/en/countries/flag/" +
                refPaises + ".png";
    }

    public static ArrayList<paises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<paises> lstpaises = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String refPaises = keys.next();
            JSONObject a = datos.getJSONObject(refPaises);
            lstpaises.add(new paises(refPaises, a));

        }
        return lstpaises;

    }
}

