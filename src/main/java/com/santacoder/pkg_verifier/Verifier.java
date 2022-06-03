package com.santacoder.pkg_verifier;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Verifier {
    public static boolean IS_VERIFIED = false;
    public static void checkVerifier(Context context,  String applicationId, String applicationId2){
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                new String(Base64.decode("aHR0cHM6Ly9zYW50YWNvZGVyLmNvbS92ZXJpZnlwa2cvY2hlY2tfcGtnLmpzb24=", Base64.DEFAULT)), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (applicationId.equalsIgnoreCase(response.getString(applicationId2))){
                        Verifier.IS_VERIFIED = true;
                    } else {
                        Verifier.IS_VERIFIED = false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error from Verifier!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
