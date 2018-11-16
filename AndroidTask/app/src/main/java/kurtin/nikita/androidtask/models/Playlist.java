package kurtin.nikita.androidtask.models;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class Playlist {

    private final String id;
    private final String title;
    private final Video [] videos;

    public Playlist(String id, String title, Video[] videos) {
        this.id = id;
        this.title = title;
        this.videos = videos;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Video[] getVideos() {
        return videos;
    }
}
