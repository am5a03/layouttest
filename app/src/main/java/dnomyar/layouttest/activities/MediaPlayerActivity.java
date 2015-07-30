package dnomyar.layouttest.activities;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultHttpDataSource;

import dnomyar.layouttest.R;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener, ExoPlayer.Listener, TextureView.SurfaceTextureListener {

    private static final String TAG = "MediaPlayerActivity";
    private static final int BUFFER_SEGMENT_SIZE = 64 * 1024;
    private static final int BUFFER_SEGMENT_COUNT = 160;

    private ExoPlayer mPlayer;
    private TextureView mTextureView;
    private SurfaceView surfaceView;
    private Surface surface;

    private Uri contentUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        mTextureView = (TextureView) findViewById(R.id.texture_view);
        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startBasicPlayback();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.release();
//        surface.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_media_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPlayerStateChanged(boolean b, int i) {
        String playerState = "";
        switch (mPlayer.getPlaybackState()) {
            case ExoPlayer.STATE_BUFFERING:
                playerState = "buffering";
                break;
            case ExoPlayer.STATE_ENDED:
                playerState = "ended";
                mPlayer.seekTo(0);
                break;
            case ExoPlayer.STATE_IDLE:
                playerState = "idle";
                break;
            case ExoPlayer.STATE_PREPARING:
                playerState = "preparing";
                break;
            case ExoPlayer.STATE_READY:
                playerState = "ready";
                break;
        }
        Log.d(TAG, playerState);
    }

    @Override
    public void onPlayWhenReadyCommitted() {

    }

    @Override
    public void onPlayerError(ExoPlaybackException e) {

    }

    @Override
    public void onClick(View v) {

    }

    private void startBasicPlayback() {
        final String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like"
                + " Gecko) Chrome/38.0.2125.104 Safari/537.36";
        mPlayer = ExoPlayer.Factory.newInstance(1);
        mPlayer.addListener(this);
        ExtractorSampleSource extractorSampleSource = new ExtractorSampleSource(
                Uri.parse("http://img-9gag-fun.9cache.com/photo/anBb6qE_460sv.mp4"),
                new DefaultHttpDataSource(userAgent, null),
                new Mp4Extractor(),
                new DefaultAllocator(BUFFER_SEGMENT_SIZE), BUFFER_SEGMENT_SIZE * BUFFER_SEGMENT_COUNT);
        MediaCodecVideoTrackRenderer renderer = new MediaCodecVideoTrackRenderer(extractorSampleSource, MediaCodec.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
//        SurfaceTexture surfaceTexture = mTextureView.getSurfaceTexture();
//        surface = new Surface(surfaceTexture);
        mPlayer.sendMessage(renderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, surfaceView.getHolder().getSurface());
//        surfaceView.setVisibility(View.GONE);
        mPlayer.prepare(renderer);
        mPlayer.setPlayWhenReady(true);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
