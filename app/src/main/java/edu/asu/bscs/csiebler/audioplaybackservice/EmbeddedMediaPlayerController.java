//package edu.asu.bscs.csiebler.audioplaybackservice;
//
//import android.app.Activity;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.MotionEvent;
//import android.widget.MediaController;
//import android.widget.VideoView;
//
///**
// * Copyright 2015 Cory Siebler
// * <p/>
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// * <p/>
// * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
// * <p/>
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// *
// * @author Cory Siebler csiebler@asu.edu
// * @version Jan 22, 2015
// */
//public class EmbeddedMediaPlayerController extends Activity implements MediaController.MediaPlayerControl {
//
//    private MediaPlayer player;
//    private MediaController controller;
//    private VideoView audioView;
//    private static final String TAG = "CSE494 Audio Player";
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d(
//                getClass().getSimpleName(),
//                "in onTouch.. action: "
//                        + event.actionToString(event.getAction())
//                        + " at X: " + event.getX()
//                        + " at Y: " + event.getY()
//        );
//
//        controller.show();
//
//        return false;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        audioView = (VideoView) findViewById(R.id.player_view);
//        player = MediaPlayer.create(this, R.raw.whenthelightsgoout);
//        controller = new MediaController(this);
//        controller.setAnchorView(audioView);
//        controller.setMediaPlayer(this);
//        player.start();
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void start() {
//        player.start();
//    }
//
//    @Override
//    public void pause() {
//        player.pause();
//    }
//
//    @Override
//    public int getDuration() {
//        return player.getDuration();
//    }
//
//    @Override
//    public int getCurrentPosition() {
//        return player.getCurrentPosition();
//    }
//
//    @Override
//    public void seekTo(int pos) {
//        player.seekTo(pos);
//    }
//
//    @Override
//    public boolean isPlaying() {
//        return player.isPlaying();
//    }
//
//    @Override
//    public int getBufferPercentage() {
//        return 0;
//    }
//
//    @Override
//    public boolean canPause() {
//        return true;
//    }
//
//    @Override
//    public boolean canSeekBackward() {
//        return true;
//    }
//
//    @Override
//    public boolean canSeekForward() {
//        return true;
//    }
//
//    @Override
//    public int getAudioSessionId() {
//        // Representing the internal speaker
//        return 0;
//    }
//}
