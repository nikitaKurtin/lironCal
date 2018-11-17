package kurtin.nikita.androidtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import kurtin.nikita.androidtask.utils.Api;

/**
 * Created by Nikita Kurtin on 11/17/18.
 */
public class YoutubeCustomActivity extends YouTubeBaseActivity {

    public static final String VIDEO_TITLE = "videoTitle";
    public static final String VIDEO_ID = "videoTitle";

    private String videoId;
    private String videoTitle;

    private YouTubePlayerView youTubePlayer;
    private TextView videoTtl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        videoTtl = findViewById(R.id.ttl);
        youTubePlayer = findViewById(R.id.youtubePlayer);

        youTubePlayer.initialize(Api.Youtube.API_KEY, initListener);

    }

    @Override
    protected void onStart() {
        super.onStart();

        videoTitle = getIntent().getStringExtra(VIDEO_TITLE);
        videoId = getIntent().getStringExtra(VIDEO_ID);

        videoTtl.setText(videoTitle);
    }

    private YouTubePlayer.OnInitializedListener initListener = new YouTubePlayer.OnInitializedListener() {
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
            //NOTE - this gives a network Error
            //From a quick search in the net, many people complaining about, for example:
            //https://www.imobie.com/support/how-to-fix-youtube-error-400.htm
            //https://productforums.google.com/forum/#!msg/youtube/FQoBYsObhBQ/7TVtMuGxyk8J
            player.loadVideo(videoId);

            //If you want to see a perfectly working example - use VideoClickListener.showWithImplicitIntent
            //Which is called at line VideoClickListener:20
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        }
    };
}
