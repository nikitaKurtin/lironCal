package kurtin.nikita.androidtask.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.models.Video;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class CustomParser {

    private static final String ID = "id";
    private static final String VIDEO_ID = "videoId";
    private static final String TITLE = "title";
    private static final String CONTENT_DETAILS = "contentDetails";
    private static final String SNIPPET = "snippet";
    private static final String ITEMS = "items";
    private static final String PLAYLIST_ITEMS = "playlistItems";
    private static final String THUMBNAILS = "thumbnails";
    private static final String DEFAULT = "default";
    private static final String URL = "url";

    private static Video [] getAllVideos(JSONObject videoItemsJson){
        JSONArray videoItems = videoItemsJson.optJSONArray(ITEMS);
        Video [] videos = new Video[videoItems.length()];
        for(int i=0; i<videoItems.length(); i++){
            videos[i] = parseVideo(videoItems.optJSONObject(i));
        }
        return videos;
    }

    private static Playlist parsePlaylist(JSONObject playlistJson){
        JSONObject snippetJson = playlistJson.optJSONObject(SNIPPET);
        String playListId = playlistJson.optString(ID);
        String title = snippetJson.optString(TITLE);
        Video [] videos = getAllVideos(playlistJson.optJSONObject(PLAYLIST_ITEMS));
        return new Playlist(playListId, title, videos);
    }

    private static Video parseVideo(JSONObject videoJson){
        JSONObject snippetJson = videoJson.optJSONObject(SNIPPET);
        String id = videoJson.optJSONObject(CONTENT_DETAILS).optString(VIDEO_ID);
        String title = snippetJson.optString(TITLE);
        String imgUrl = snippetJson.optJSONObject(THUMBNAILS).optJSONObject(DEFAULT).optString(URL);
        return new Video(id, title, imgUrl);
    }

    public static Playlist [] parse(JSONObject json){
        JSONArray playlistItems =  json.optJSONArray(ITEMS);
        Playlist [] playlists = new Playlist[playlistItems.length()];
        for(int i=0; i<playlistItems.length(); i++){
            playlists[i] = parsePlaylist(playlistItems.optJSONObject(i));
            //TODO - finish from here
        }
    }

}
