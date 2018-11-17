package kurtin.nikita.androidtask.models;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class Playlist {

    private final String id;
    private final String title;
    private final Video [] videos;

    private boolean isActive;

    public Playlist(String id, String title, Video[] videos) {
        this.id = id;
        this.title = title;
        this.videos = videos;
        this.isActive = false;
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

    public void toggleIsActive(){
        isActive = !isActive;
    }

    public boolean getIsActive(){
        return isActive;
    }
}
