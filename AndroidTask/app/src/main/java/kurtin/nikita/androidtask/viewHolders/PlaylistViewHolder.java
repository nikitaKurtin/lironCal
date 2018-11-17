package kurtin.nikita.androidtask.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kurtin.nikita.androidtask.R;
import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.models.Video;
import kurtin.nikita.androidtask.observers.VideoClickListener;
import kurtin.nikita.androidtask.utils.ImageManager;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private Playlist playlist;
    private final View playlistView;

    public PlaylistViewHolder(View v){
        super(v);
        playlistView = v;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public View getPlaylistView(){
        return this.playlistView;
    }

    public void showPlaylistTitle(){
        TextView playlistTitle = playlistView.findViewById(R.id.playlistTitle);
        playlistTitle.setText(playlist.getTitle());
    }

    public void showPlaylistVideos(){
        ViewGroup allVideos = playlistView.findViewById(R.id.playlistVideos);
        for(Video video : playlist.getVideos()){
            View videoView = LayoutInflater.from(playlistView.getContext()).inflate(R.layout.item_video, null);
            videoView.setTag(video);
            TextView videoTtl = videoView.findViewById(R.id.videoTtl);
            videoTtl.setText(video.getTitle());
            ImageView videoImg = videoView.findViewById(R.id.videoImg);
            ImageManager.showImage(videoImg, video.getImgUrl());
            videoView.setOnClickListener(new VideoClickListener());
            allVideos.addView(videoView);
        }
    }

}
