# Liron Cal Android Task

  ## [Task](https://bitbucket.org/caldigitalteam/calintreview#markdown-header-task) 
  
  1. Creating Github repository.
  2. Android app that accomplishes the following:
     - [X] Load list of youtube videos grouped into playlists, from [this link](https://sandbox.cal-online.co.il/youtube/playlists.json) 
     - [X] Create a [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView) that shows each of the playlists as list items.
     - [X] When a playlist item is clicked, the app should drill down and show all video items of the selected playlist with their corresponding thumbnail image.
     - [X] When a video item is clicked, the youtube video starts playing immediately.
       - I've implemented both techniques, using an [implicit Intent](https://developer.android.com/training/basics/intents/sending#Build) and the custom [YouTubePlayerView](https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerView). 
     - [X] After viewing the video user is able to navigate back to the list view and continue from where he left off.
  3. Adding a [debug APK](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask.apk) (No defense techniques used).

  ## Implemented Design Patterns
   1. MVW - (Model-View-Whatever) architectural pattern based on decoupling Model and View objects, that is flexible to be used not only for MVP, but any other MV combinations as well. 
   2. Adapter - structural pattern allowing interaction between [Playlist](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/models/Playlist.java) and RecyclerView items.
   3. ViewHolder - pattern used for recycling and managing the playlist view, implemented in [PlaylistViewHolder](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/viewHolders/PlaylistViewHolder.java).
   4. Observer - behavioral patter, used for handling custom events [PlaylistClickListener](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/observers/PlaylistClickListener.java) and [VideoClickListener](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/observers/VideoClickListener.java)
   5. Flyweight - structural pattern, implemented in [ImageManager](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/ImageManager.java) for improving performance in both computing resources & memory.
   6. Lazy Loading - combining with the flyweight in [ImageManager](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/ImageManager.java), the image wouldn't be loaded until it's actually necessary.
   7. Event-based asynchronous - concurrency pattern, implemented in [JSONLoadTask](https://github.com/nikitaKurtin/lironCal/blob/master/AndroidTask/app/src/main/java/kurtin/nikita/androidtask/utils/JSONLoadTask.java) instead of blocking, the caller is notified back when the response has returned.  
   
  ## Showing video on click
   As I described previously in the email, Android platform has a built in mechanism for interaction between different apps, called an [implicit Intent](https://developer.android.com/training/basics/intents/sending#Build)
   This technique has many different benefits such as:
   
   1. Compatibily - as it's fully supported from the API 1, which ensures support for 100% of the device
   2. Loose coupling - using an implicit (system level built in) mechanism is a lot more decoupled, then implementing custom player for already existing app in every android device.
   3. UX - opening the youtube video inside the youtube app is a lot more intuitive.
   4. Simplicity - requires less code and dependencies.   
   
   Nevertheless - since Liron asked for adding a custom youtube player using the [youtube library](https://developers.google.com/youtube/android/player/), I've added that as well.



