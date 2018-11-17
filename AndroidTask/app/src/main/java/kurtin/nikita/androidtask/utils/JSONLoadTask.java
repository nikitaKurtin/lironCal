package kurtin.nikita.androidtask.utils;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Nikita Kurtin on 11/17/18.
 */
public class JSONLoadTask extends AsyncTask<String, Void, JSONObject> {

    @Override
    protected JSONObject doInBackground(String... url) {
        try {
            //Load json from given url and return created JSON
            return new HttpRequest(url[0]).prepare().sendAndReadJSON();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;//In case of any failure return null
    }
}
