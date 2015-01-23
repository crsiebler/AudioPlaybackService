package edu.asu.bscs.csiebler.audioplaybackservice;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import java.io.IOException;

/**
 * Copyright 2015 Cory Siebler
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author Cory Siebler csiebler@asu.edu
 * @version Jan 22, 2015
 */
public class MediaPlayerService extends Service implements MediaPlayer.OnCompletionListener {

    public static final String COMMAND = "CMD";
    public static final int START = 0;
    public static final int STOP = 1;
    public static final int PAUSE = 2;
    public static final int RESUME = 3;
    public static final int NONE = 4;

    private MediaPlayer mMediaPlayer;
    private boolean isPlaying = false;

    /**
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getClass().getSimpleName(), "in onCreate()");

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.twentythree);
        mMediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setOnCompletionListener(this);
        isPlaying = false;
    }

    /**
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(getClass().getSimpleName(), "in onStartCommand()");

        switch(intent.getIntExtra(COMMAND, NONE)) {
            case START:
                if (isPlaying) {
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                }

                mMediaPlayer.start();
                isPlaying = true;
                break;
            case STOP:
                if (mMediaPlayer != null) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                }

                isPlaying = false;
                break;
            case PAUSE:
                if (mMediaPlayer != null && isPlaying) {
                    mMediaPlayer.pause();
                    isPlaying = false;
                }
                break;
            case RESUME:
                mMediaPlayer.start();
                isPlaying = true;
                break;
            default:
                break;
        }

        return START_NOT_STICKY;
    }

    /**
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     *
     */
    @Override
    public void onDestroy() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }

        super.onDestroy();
    }

    /**
     *
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
        mp.start();
        isPlaying = true;
    }

}
