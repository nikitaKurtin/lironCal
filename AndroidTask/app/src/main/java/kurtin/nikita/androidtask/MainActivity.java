package kurtin.nikita.androidtask;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.TextView;

import org.json.JSONObject;

import kurtin.nikita.androidtask.adapters.PlaylistsAdapter;
import kurtin.nikita.androidtask.models.Playlist;
import kurtin.nikita.androidtask.utils.Api;
import kurtin.nikita.androidtask.utils.CustomParser;
import kurtin.nikita.androidtask.utils.HttpRequest;
import kurtin.nikita.androidtask.utils.JSONLoadTask;

public class MainActivity extends AppCompatActivity {

    private static JSONObject initJson;
    private static Playlist [] playlistsData;

    private PlaylistsAdapter adapter;

    private RecyclerView playlistsView;
    private TextView ttl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttl = findViewById(R.id.ttl);
        playlistsView = findViewById(R.id.playlists);
        playlistsView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }

    //Load initial data asynchronously
    private void loadData(){
        new InitJSONTask(playlistsView).execute(Api.taskUrl);
    }

    private static class InitJSONTask extends JSONLoadTask{

        private RecyclerView playlistsView;

        private InitJSONTask(RecyclerView playlistsView){
            this.playlistsView = playlistsView;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            if(json != null){
                initJson = json;//store for reuse
                playlistsData = CustomParser.parse(json);//parse all data
                playlistsView.setAdapter(new PlaylistsAdapter(playlistsView.getContext(), playlistsData));
            }
        }
    };

}
