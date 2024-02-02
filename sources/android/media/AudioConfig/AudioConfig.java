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
        if (this.mAudioManager != null) {
            this.mAudioManager.setSoundField(mode, xSound, ySound);
        }
    }

    public SoundFieldData getSoundField(int mode) {
        if (this.mAudioManager != null) {
            SoundField data = this.mAudioManager.getSoundField(mode);
            if (data == null) {
                return new SoundFieldData(0, 0);
            }
            return new SoundFieldData(data.x, data.y);
        }
        return null;
    }

    public void setSoundEffectMode(int mode) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setSoundEffectMode(mode);
        }
    }

    public int getSoundEffectMode() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getSoundEffectMode();
        }
        return -1;
    }

    public void setSoundEffectType(int mode, int type) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setSoundEffectType(mode, type);
        }
    }

    public int getSoundEffectType(int mode) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getSoundEffectType(mode);
        }
        return -1;
    }

    public void setSoundEffectScene(int mode, int type) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setSoundEffectScene(mode, type);
        }
    }

    public int getSoundEffectScene(int mode) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getSoundEffectScene(mode);
        }
        return -1;
    }

    public void setSoundEffectParms(int effectType, int nativeValue, int softValue, int innervationValue) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setSoundEffectParms(effectType, nativeValue, softValue, innervationValue);
        }
    }

    public SoundEffectParms getSoundEffectParms(int effectType, int modeType) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getSoundEffectParms(effectType, modeType);
        }
        return null;
    }

    public void enableSystemSound() {
        if (this.mAudioManager != null) {
            this.mAudioManager.enableSystemSound();
        }
    }

    public void disableSystemSound() {
        if (this.mAudioManager != null) {
            this.mAudioManager.disableSystemSound();
        }
    }

    public boolean isSystemSoundEnabled() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isSystemSoundEnabled();
        }
        return true;
    }

    public void setStereoAlarm(boolean enable) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setStereoAlarm(enable);
        }
    }

    public void setSpeechSurround(boolean enable) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setSpeechSurround(enable);
        }
    }

    public void setMainDriver(boolean enable) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setMainDriver(enable);
        }
    }

    public void setBtHeadPhone(boolean enable) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBtHeadPhone(enable);
        }
    }

    public boolean isStereoAlarmOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isStereoAlarmOn();
        }
        return false;
    }

    public boolean isSpeechSurroundOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isSpeechSurroundOn();
        }
        return false;
    }

    public boolean isMainDriverOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isMainDriverOn();
        }
        return false;
    }

    public boolean isBtHeadPhoneOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isBtHeadPhoneOn();
        }
        return false;
    }

    public boolean isAnyStreamActive() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isAnyStreamActive();
        }
        return false;
    }

    public void setMusicLimitMode(boolean mode) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setMusicLimitMode(mode);
        }
    }

    public boolean isMusicLimitMode() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isMusicLimitMode();
        }
        return false;
    }

    public static boolean isHighConfig() {
        String ampConfig = SystemProperties.get("persist.sys.xiaopeng.AMP", "0");
        return ampConfig.equals("1");
    }

    public void setBtCallOn(boolean enable) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBtCallOn(enable);
        }
    }

    public void setBtCallOnFlag(int flag) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBtCallOnFlag(flag);
        }
    }

    public int getBtCallOnFlag() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getBtCallOnFlag();
        }
        return 0;
    }

    public boolean isBtCallOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isBtCallOn();
        }
        return false;
    }

    public void setBtCallMode(int mode) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBtCallMode(mode);
        }
    }

    public int getBtCallMode() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getBtCallMode();
        }
        return 0;
    }

    public void setKaraokeOn(boolean on) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setKaraokeOn(on);
        }
    }

    public boolean isKaraokeOn() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isKaraokeOn();
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
        if (this.mAudioManager != null) {
            this.mAudioManager.setVoiceStatus(status);
        }
    }

    public int getVoiceStatus() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getVoiceStatus();
        }
        return 0;
    }

    public boolean setFixedVolume(boolean enable, int vol, int streamType) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.setFixedVolume(enable, vol, streamType);
        }
        return true;
    }

    public boolean isFixedVolume(int streamType) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isFixedVolume(streamType);
        }
        return false;
    }

    public String getCurrentAudioFocusPackageName() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getCurrentAudioFocusPackageName();
        }
        return null;
    }

    public List<String> getAudioFocusPackageNameList() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getAudioFocusPackageNameList();
        }
        return null;
    }

    public void doZenVolumeProcess(boolean in) {
        if (this.mAudioManager != null) {
            this.mAudioManager.doZenVolumeProcess(in);
        }
    }

    public boolean isZenVolume() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.isZenVolume();
        }
        return false;
    }

    public void setVoicePosition(int position, int flag) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setVoicePosition(position, flag);
        }
    }

    public int getVoicePosition() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getVoicePosition();
        }
        return 0;
    }

    public boolean supportSurroundSoundEffect() {
        return false;
    }

    public void forceChangeToAmpChannel(int channelBits, int activeBits, int volume, boolean stop) {
        if (this.mAudioManager != null) {
            this.mAudioManager.forceChangeToAmpChannel(channelBits, activeBits, volume, stop);
        }
    }

    public void restoreMusicVolume() {
        if (this.mAudioManager != null) {
            this.mAudioManager.restoreMusicVolume();
        }
    }

    public void setMainDriverMode(int mode) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setMainDriverMode(mode);
        }
    }

    public int getMainDriverMode() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getMainDriverMode();
        }
        return 0;
    }

    public void setBanVolumeChangeMode(int streamType, int mode) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBanVolumeChangeMode(streamType, mode);
        }
    }

    public int getBanVolumeChangeMode(int streamType) {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getBanVolumeChangeMode(streamType);
        }
        return 0;
    }

    public void setDangerousTtsStatus(int on) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setDangerousTtsStatus(on);
        }
    }

    public int getDangerousTtsStatus() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getDangerousTtsStatus();
        }
        return 0;
    }

    public void setDangerousTtsVolLevel(int level) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setDangerousTtsVolLevel(level);
        }
    }

    public int getDangerousTtsVolLevel() {
        if (this.mAudioManager != null) {
            return this.mAudioManager.getDangerousTtsVolLevel();
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
        mAudioServiceListener = callBackFunc;
        if (this.mAudioManager != null && mXpAudioCallBack != null) {
            try {
                this.mAudioManager.registerCallback(mXpAudioCallBack);
            } catch (Exception e) {
                Log.e(TAG, "registerCallback " + e);
            }
        }
    }

    public void unRegisterCallback() {
        mAudioServiceListener = null;
        if (this.mAudioManager != null) {
            try {
                this.mAudioManager.unRegisterCallback();
            } catch (Exception e) {
                Log.e(TAG, "unRegisterCallback " + e);
            }
        }
    }
}
