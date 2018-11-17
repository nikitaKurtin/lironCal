# Liron Cal Android Task

  ## [Task](https://bitbucket.org/caldigitalteam/calintreview#markdown-header-task) 
  
  1. Creating Github repository - [X]
  2. Android app that accomplishes the following:
    1. Load list of youtube videos grouped into playlists, from [this link](https://sandbox.cal-online.co.il/youtube/playlists.json) - [X]
    2. Create a [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView) that shows each of the playlists as list items - [X]
    3. When a playlist item is clicked, the app should drill down and show all video items of the selected playlist with their corresponding thumbnail image - [X]
    4. When a video item is clicked, the youtube video starts playing immediately - [X]
      - I've implemented both techniques, using an [implicit Intent](https://developer.android.com/training/basics/intents/sending#Build) and the custom [YouTubePlayerView](https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerView). 
    5. After viewing the video user is able to navigate back to the list view and continue from where he left off - [X]
  3. Adding a [debug APK](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask.apk) (No defense techniques used) - [X] 

  ## Implemented Design Patterns
   1. MVW - (Model-View-Whatever) Architectural pattern based on decoupling Model and View objects, that is flexible to be used not only for MVP, but any other MV combinations as well. 
   2. Adapter - Structural pattern allowing interaction between [Playlist](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/models/Playlist.java) and RecyclerView items.
   3. ViewHolder - pattern used for recycling and managing the playlist view.
   4. Observer - behavioral patter, used for handling custom events [PlaylistClickListener](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/observers/PlaylistClickListener.java) and [VideoClickListener](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/observers/VideoClickListener.java)
   5. Flyweight - structural pattern, implemented in [ImageManager](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/ImageManager.java) for improving performance in both computing resources & memory.
   6. Lazy Loading - combining with the flyweight in [ImageManager](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/ImageManager.java), the image wouldn't be loaded until it's actually necessary.
   7. Event-based asynchronous - concurrency pattern, implemented in [JSONLoadTask](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/JSONLoadTask.java) instead of blocking, the caller is notified back when the response has returned.  
   
  ## Showing video on click
    As I described previously in the email, Android platform has a built in mechanism for interaction between different apps, called an [implicit Intent](https://developer.android.com/training/basics/intents/sending#Build)
    This technique has many different benefits such as:
      - Compatibily - as it's fully supported from the API 1, which ensures support for 100% of the device
      - Loose coupling - using an implicit (system level built in) mechanism is a lot more decoupled, then implementing custom player for already existing app in every android device.
      - UX - opening the youtube video inside the youtube app is a lot more intuitive.
      - Simplicity - requires less code and dependencies.   
   Nevertheless - since Liron asked for adding a custom youtube player using the [youtube library](https://developers.google.com/youtube/android/player/), I've added that as well.



