package kurtin.nikita.androidtask.utils;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public final class Api {

    public final static class Youtube{
        public static final String API_KEY = "AIzaSyAaGqg8DvqEZTDDsW_-bJDQNMEwJqH3Brc";
    }

    //Base url - for easy maintenance, in case the api moves to another domain
    private static final String baseUrl = "https://sandbox.cal-online.co.il";

    //Including endpoint for the given task
    public static final String taskUrl = baseUrl+"/youtube/playlists.json";



}
