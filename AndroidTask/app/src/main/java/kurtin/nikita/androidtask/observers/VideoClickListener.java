package kurtin.nikita.androidtask.observers;

import android.view.View;

import kurtin.nikita.androidtask.R;
import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.models.Video;
import kurtin.nikita.androidtask.viewHolders.PlaylistViewHolder;

/**
 * Created by Nikita Kurtin on 11/17/18.
 */
public class VideoClickListener implements View.OnClickListener {


    private void showVideo(Video video){

    }

    @Override
    public void onClick(View videoView) {
        Video video = (Video)videoView.getTag();
        showVideo(video);
    }

}