package kurtin.nikita.androidtask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import kurtin.nikita.androidtask.R;
import kurtin.nikita.androidtask.viewHolders.PlaylistViewHolder;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private final Context context;
    private final String [] playlists;

    public PlaylistsAdapter(Context context, String[] playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder playlistViewHolder, int i) {
        TextView myCustomPlaylistView = playlistViewHolder.getPlaylistView();
        myCustomPlaylistView.setText(playlists[i]);
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView myCustomPlaylistView = (TextView) LayoutInflater.from(context).inflate(R.layout.item_playlist, viewGroup, false);
        return new PlaylistViewHolder(myCustomPlaylistView);
    }
}
