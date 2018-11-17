package kurtin.nikita.androidtask.observers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import kurtin.nikita.androidtask.R;
import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.models.Video;
import kurtin.nikita.androidtask.viewHolders.PlaylistViewHolder;

/**
 * Created by Nikita Kurtin on 11/17/18.
 */
public class PlaylistClickListener implements View.OnClickListener {
    private final PlaylistViewHolder viewHolder;

    public PlaylistClickListener(PlaylistViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    @Override
    public void onClick(View view) {
        Playlist playlist = viewHolder.getPlaylist();
        playlist.toggleIsActive();
        View videosView = viewHolder.getPlaylistView().findViewById(R.id.playlistVideos);
        boolean isActive = playlist.getIsActive();
        videosView.setVisibility(isActive ? View.VISIBLE : View.GONE);
        if(isActive)viewHolder.showPlaylistVideos();
    }
}