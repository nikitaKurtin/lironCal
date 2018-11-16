package kurtin.nikita.androidtask.models;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public final class Video {


    private final String id;
    private final String title;
    private final String imgUrl;

    public Video(String id, String title, String imgUrl) {

        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

}
