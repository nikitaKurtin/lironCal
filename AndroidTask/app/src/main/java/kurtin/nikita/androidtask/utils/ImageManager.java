package kurtin.nikita.androidtask.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import kurtin.nikita.androidtask.R;

/**
 * Created by Nikita Kurtin on 11/16/18.
 */
public class ImageManager {

    //Encapsulated custom flyweight pattern implementation
    private static final Map <String, Bitmap> imagesFlyweight = new HashMap<>();

    public static void showImage(ImageView img, String url){
        Bitmap bm = imagesFlyweight.get(url);
        //If already loaded - reuse
        if(bm != null){
            img.setImageBitmap(bm);
            return;
        }
        //If not loaded yet
        asyncLoadImage(img, url);
    }

    private static void asyncLoadImage(final ImageView img, final String url){
        //First - show some temp image (placeholder)
        img.setImageResource(R.mipmap.youtube_default);
        //Second - load asynchronously
        new Thread(){
            @Override
            public void run() {
                try {
                    final Bitmap bm = BitmapFactory.decodeStream(new URL(url).openStream());
                    imagesFlyweight.put(url, bm);//Store for the future reuse
                    img.post(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageBitmap(bm);//Show loaded image
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
