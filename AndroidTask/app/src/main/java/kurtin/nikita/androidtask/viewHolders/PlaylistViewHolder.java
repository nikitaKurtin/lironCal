package kurtin.nikita.androidtask.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private final TextView playlistView;

    public PlaylistViewHolder(TextView v){
        super(v);
        this.playlistView = v;
    }

    public TextView getPlaylistView(){
        return this.playlistView;
    }

}
