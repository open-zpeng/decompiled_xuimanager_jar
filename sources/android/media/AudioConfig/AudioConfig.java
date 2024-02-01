package android.media.AudioConfig;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundEffectParms;
import android.media.SoundField;
import android.os.SystemProperties;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class AudioConfig {
    public static final int BAN_VOLCONTROL_MODE_LEVEL_1 = 1;
    public static final int BAN_VOLCONTROL_MODE_LEVEL_2 = 2;
    public static final int BAN_VOLCONTROL_MODE_NO_ACTIVE = 0;
    public static final int BTCALL_CALLING_OUT = 3;
    public static final int BTCALL_CONNECTTED = 2;
    public static final int BTCALL_NOT_CONNECTTED = 0;
    public static final int BTCALL_RINGING = 1;
    public static final int BTCAllMODE_CDU = 1;
    public static final int BTCAllMODE_PHONE = 0;
    public static final int DANGEROUSTTS_VOLUME_HIGH = 3;
    public static final int DANGEROUSTTS_VOLUME_LOW = 1;
    public static final int DANGEROUSTTS_VOLUME_NORMAL = 2;
    public static final int DISABLE_DANGEROUSTTS_MODE = 0;
    public static final int ENABLE_DANGEROUSTTS_MODE = 1;
    public static final int MAIN_DRIVER_MODE_DRIVER = 1;
    public static final int MAIN_DRIVER_MODE_NO_ACTIVE = 0;
    public static final int MAIN_DRIVER_MODE_SILENCE = 2;
    public static final int SOUND_STYLE_LIVE_DYNAMIC = 3;
    public static final int SOUND_STYLE_STRESS = 1;
    public static final int SOUND_STYLE_SURROUND = 4;
    public static final int SOUND_STYLE_VOICE = 2;
    private static final String TAG = "AudioConfig";
    public static final int TEMPVOLCHANGE_FLAG_AEB = 128;
    public static final int TEMPVOLCHANGE_FLAG_BOOT = 64;
    public static final int TEMPVOLCHANGE_FLAG_BTCALL = 4;
    public static final int TEMPVOLCHANGE_FLAG_DANGERTTS = 8;
    public static final int TEMPVOLCHANGE_FLAG_DOOR = 2;
    public static final int TEMPVOLCHANGE_FLAG_GEAR = 1;
    public static final int TEMPVOLCHANGE_FLAG_XUIALARM = 16;
    public static final int TEMPVOLCHANGE_FLAG_ZENMODE = 32;
    public static final int VOICE_POSITION_CENTER = 0;
    public static final int VOICE_POSITION_FRONTLEFT = 1;
    public static final int VOICE_POSITION_FRONTRIGHT = 2;
    public static final int VOICE_POSITION_INVALID = -1;
    public static final int VOICE_POSITION_REARLEFT = 3;
    public static final int VOICE_POSITION_REARRIGHT = 4;
    public static final int XUI_DYNAUDIO_TYPE_DYNAMIC = 3;
    public static final int XUI_DYNAUDIO_TYPE_HUMAN = 4;
    public static final int XUI_DYNAUDIO_TYPE_REAL = 1;
    public static final int XUI_DYNAUDIO_TYPE_SOFT = 2;
    public static final int XUI_SCENE_KTV = 3;
    public static final int XUI_SCENE_LIVE = 2;
    public static final int XUI_SCENE_STUDIO = 4;
    public static final int XUI_SCENE_THEATRE = 1;
    public static final int XUI_SOUND_MODE_DYNAUDIO = 3;
    public static final int XUI_SOUND_MODE_ORIGIN = 4;
    public static final int XUI_SOUND_MODE_SMART = 2;
    public static final int XUI_SOUND_MODE_XSOUND = 1;
    public static final int XUI_XSOUND_TYPE_CLASIC = 6;
    public static final int XUI_XSOUND_TYPE_COMMON = 1;
    public static final int XUI_XSOUND_TYPE_DISCO = 5;
    public static final int XUI_XSOUND_TYPE_HUMAN = 2;
    public static final int XUI_XSOUND_TYPE_JAZZ = 3;
    public static final int XUI_XSOUND_TYPE_ORIGIN = 0;
    public static final int XUI_XSOUND_TYPE_ROCK = 4;
    private static AudioServiceListener mAudioServiceListener;
    private static XpAudioCallBack mXpAudioCallBack;
    private AudioManager mAudioManager;

    /* loaded from: classes.dex */
    public interface AudioServiceListener {
        void AudioServiceCallBack(int i, int i2);

        void onErrorEvent(int i, int i2);
    }

    public AudioConfig(Context context) {
        this.mAudioManager = null;
        if (context == null) {
            Log.e(TAG, "contex is null");
            return;
        }
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        mXpAudioCallBack = new XpAudioCallBack();
    }

    public void setSoundField(int mode, int xSound, int ySound) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSoundField(mode, xSound, ySound);
        }
    }

    public SoundFieldData getSoundField(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            SoundField data = audioManager.getSoundField(mode);
            if (data == null) {
                return new SoundFieldData(0, 0);
            }
            return new SoundFieldData(data.x, data.y);
        }
        return null;
    }

    public void setSoundEffectMode(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSoundEffectMode(mode);
        }
    }

    public int getSoundEffectMode() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getSoundEffectMode();
        }
        return -1;
    }

    public void setSoundEffectType(int mode, int type) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSoundEffectType(mode, type);
        }
    }

    public int getSoundEffectType(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getSoundEffectType(mode);
        }
        return -1;
    }

    public void setSoundEffectScene(int mode, int type) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSoundEffectScene(mode, type);
        }
    }

    public int getSoundEffectScene(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getSoundEffectScene(mode);
        }
        return -1;
    }

    public void setSoundEffectParms(int effectType, int nativeValue, int softValue, int innervationValue) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSoundEffectParms(effectType, nativeValue, softValue, innervationValue);
        }
    }

    public SoundEffectParms getSoundEffectParms(int effectType, int modeType) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getSoundEffectParms(effectType, modeType);
        }
        return null;
    }

    public void enableSystemSound() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.enableSystemSound();
        }
    }

    public void disableSystemSound() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.disableSystemSound();
        }
    }

    public boolean isSystemSoundEnabled() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isSystemSoundEnabled();
        }
        return true;
    }

    public void setStereoAlarm(boolean enable) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setStereoAlarm(enable);
        }
    }

    public void setSpeechSurround(boolean enable) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setSpeechSurround(enable);
        }
    }

    public void setMainDriver(boolean enable) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setMainDriver(enable);
        }
    }

    public void setBtHeadPhone(boolean enable) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setBtHeadPhone(enable);
        }
    }

    public boolean isStereoAlarmOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isStereoAlarmOn();
        }
        return false;
    }

    public boolean isSpeechSurroundOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isSpeechSurroundOn();
        }
        return false;
    }

    public boolean isMainDriverOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isMainDriverOn();
        }
        return false;
    }

    public boolean isBtHeadPhoneOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isBtHeadPhoneOn();
        }
        return false;
    }

    public boolean isAnyStreamActive() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isAnyStreamActive();
        }
        return false;
    }

    public void setMusicLimitMode(boolean mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setMusicLimitMode(mode);
        }
    }

    public boolean isMusicLimitMode() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isMusicLimitMode();
        }
        return false;
    }

    public static boolean isHighConfig() {
        String ampConfig = SystemProperties.get("persist.sys.xiaopeng.AMP", "0");
        return ampConfig.equals("1");
    }

    public void setBtCallOn(boolean enable) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setBtCallOn(enable);
        }
    }

    public void setBtCallOnFlag(int flag) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setBtCallOnFlag(flag);
        }
    }

    public int getBtCallOnFlag() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getBtCallOnFlag();
        }
        return 0;
    }

    public boolean isBtCallOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isBtCallOn();
        }
        return false;
    }

    public void setBtCallMode(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setBtCallMode(mode);
        }
    }

    public int getBtCallMode() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getBtCallMode();
        }
        return 0;
    }

    public void setKaraokeOn(boolean on) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setKaraokeOn(on);
        }
    }

    public boolean isKaraokeOn() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isKaraokeOn();
        }
        return false;
    }

    public void setXiaoPOn(boolean on) {
        setVoiceStatus(on ? 1 : 0);
    }

    public boolean isXiaoPOn() {
        return getVoiceStatus() > 0;
    }

    public void setVoiceStatus(int status) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setVoiceStatus(status);
        }
    }

    public int getVoiceStatus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getVoiceStatus();
        }
        return 0;
    }

    public boolean setFixedVolume(boolean enable, int vol, int streamType) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.setFixedVolume(enable, vol, streamType);
        }
        return true;
    }

    public boolean isFixedVolume(int streamType) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isFixedVolume(streamType);
        }
        return false;
    }

    public String getCurrentAudioFocusPackageName() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getCurrentAudioFocusPackageName();
        }
        return null;
    }

    public List<String> getAudioFocusPackageNameList() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getAudioFocusPackageNameList();
        }
        return null;
    }

    public void doZenVolumeProcess(boolean in) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.doZenVolumeProcess(in);
        }
    }

    public boolean isZenVolume() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.isZenVolume();
        }
        return false;
    }

    public void setVoicePosition(int position, int flag) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setVoicePosition(position, flag);
        }
    }

    public int getVoicePosition() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getVoicePosition();
        }
        return 0;
    }

    public boolean supportSurroundSoundEffect() {
        return false;
    }

    public void forceChangeToAmpChannel(int channelBits, int activeBits, int volume, boolean stop) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.forceChangeToAmpChannel(channelBits, activeBits, volume, stop);
        }
    }

    public void restoreMusicVolume() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.restoreMusicVolume();
        }
    }

    public void setMainDriverMode(int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setMainDriverMode(mode);
        }
    }

    public int getMainDriverMode() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getMainDriverMode();
        }
        return 0;
    }

    public void setBanVolumeChangeMode(int streamType, int mode) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setBanVolumeChangeMode(streamType, mode);
        }
    }

    public int getBanVolumeChangeMode(int streamType) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getBanVolumeChangeMode(streamType);
        }
        return 0;
    }

    public void setDangerousTtsStatus(int on) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setDangerousTtsStatus(on);
        }
    }

    public int getDangerousTtsStatus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getDangerousTtsStatus();
        }
        return 0;
    }

    public void setDangerousTtsVolLevel(int level) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.setDangerousTtsVolLevel(level);
        }
    }

    public int getDangerousTtsVolLevel() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getDangerousTtsVolLevel();
        }
        return 0;
    }

    /* loaded from: classes.dex */
    private class XpAudioCallBack implements AudioManager.AudioCallBack {
        private XpAudioCallBack() {
        }

        public void AudioServiceCallBack(int msg, int value) {
            if (AudioConfig.mAudioServiceListener != null) {
                AudioConfig.mAudioServiceListener.AudioServiceCallBack(msg, value);
            }
        }

        public void onErrorEvent(int errorCode, int operation) {
            if (AudioConfig.mAudioServiceListener != null) {
                AudioConfig.mAudioServiceListener.onErrorEvent(errorCode, operation);
            }
        }
    }

    public void registerCallback(AudioServiceListener callBackFunc) {
        XpAudioCallBack xpAudioCallBack;
        mAudioServiceListener = callBackFunc;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && (xpAudioCallBack = mXpAudioCallBack) != null) {
            try {
                audioManager.registerCallback(xpAudioCallBack);
            } catch (Exception e) {
                Log.e(TAG, "registerCallback " + e);
            }
        }
    }

    public void unRegisterCallback() {
        mAudioServiceListener = null;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            try {
                audioManager.unRegisterCallback();
            } catch (Exception e) {
                Log.e(TAG, "unRegisterCallback " + e);
            }
        }
    }
}
