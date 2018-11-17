package kurtin.nikita.androidtask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kurtin.nikita.androidtask.R;
import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.observers.PlaylistClickListener;
import kurtin.nikita.androidtask.viewHolders.PlaylistViewHolder;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private final Context context;
    private final Playlist[] playlists;

    public PlaylistsAdapter(Context context, Playlist[] playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    public Playlist getPlaylistAt(int i){
        return playlists[i];
    }

    @Override
    public int getItemCount() {
        return playlists.length;
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder playlistViewHolder, int i) {
        playlistViewHolder.setPlaylist(getPlaylistAt(i));
        playlistViewHolder.showPlaylistTitle();
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View playlistView = LayoutInflater.from(context).inflate(R.layout.item_playlist, viewGroup, false);
        PlaylistViewHolder viewHolder = new PlaylistViewHolder(playlistView);
        playlistView.setOnClickListener(new PlaylistClickListener(viewHolder));
        return viewHolder;
    }
}