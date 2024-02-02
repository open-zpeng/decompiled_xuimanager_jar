package android.media.AudioFocus;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
/* loaded from: classes.dex */
public class AudioFocus {
    private static final String TAG = "AudioFocus";
    private AudioManager mAudioManager;

    public AudioFocus(Context context) {
        this.mAudioManager = null;
        if (context == null) {
            Log.e(TAG, "contex is null");
        } else {
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
        }
    }

    public void requestAudioFocusForCall(int streamType, int durationHint) {
        if (this.mAudioManager != null) {
            this.mAudioManager.requestAudioFocusForCall(streamType, durationHint);
        }
    }

    public void abandonAudioFocusForCall() {
        if (this.mAudioManager != null) {
            this.mAudioManager.abandonAudioFocusForCall();
        }
    }
}
