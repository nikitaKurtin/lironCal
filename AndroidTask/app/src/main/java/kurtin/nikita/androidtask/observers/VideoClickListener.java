package kurtin.nikita.androidtask.observers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import kurtin.nikita.androidtask.YoutubeCustomActivity;
import kurtin.nikita.androidtask.models.Video;

/**
 * Created by Nikita Kurtin on 11/17/18.
 */
public class VideoClickListener implements View.OnClickListener {

    private void showVideo(Video data, View view){
        Context context = view.getContext();
        //In real life - I suggest to use an implicit Intent, which is the best practice for this kind of things
        //Here is a perfectly working example
        showWithImplicitIntent(context, data.getId());
        //For second example uncomment next line
        //showWithCustomYoutubePlayer(context, data);
    }

    //As requested by Liron
    //Sending to a custom youtube player
    private void showWithCustomYoutubePlayer(Context context, Video data){
        Intent i = new Intent(context, YoutubeCustomActivity.class);
        i.putExtra(YoutubeCustomActivity.VIDEO_ID, data.getId());
        i.putExtra(YoutubeCustomActivity.VIDEO_TITLE, data.getTitle());
        context.startActivity(i);
    }

    private void showWithImplicitIntent(Context context, String vidId){
        String uri = "vnd.youtube:"+vidId;
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
    }

    @Override
    public void onClick(View videoView) {
        Video video = (Video)videoView.getTag();
        showVideo(video, videoView);
    }

}