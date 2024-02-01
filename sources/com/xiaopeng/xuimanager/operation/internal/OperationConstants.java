package com.xiaopeng.xuimanager.operation.internal;

import android.util.SparseArray;
import com.xiaopeng.xuimanager.operation.OperationType;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class OperationConstants {
    private static final String TAG = OperationConstants.class.getSimpleName();
    private static SparseArray<String> mResourceFolderNameArray = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class Legacy {
        public static final String KEY_CONTENT = "content";
        public static final String KEY_EFFECT_NAME = "effectName";
        public static final String KEY_EXTRA_INFO = "legacyContent";
        public static final String KEY_ID = "id";
        public static final String KEY_TYPE = "category";
        public static final String KEY_TYPE_MP3 = "mp3";
        public static final String KEY_TYPE_MP4 = "mp4";
        public static final String KEY_VIDEO_PATH = "videoPath";
    }

    /* loaded from: classes.dex */
    public static class MetaData {
        public static final String KEY_CREATE_TIME = "createTime";
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_DOWNLOAD_EXTRA_INFO = "extraInfo";
        public static final String KEY_DOWNLOAD_STATUS = "downloadStatus";
        public static final String KEY_DOWNLOAD_URL = "downloadUrl";
        public static final String KEY_EFFECT_TIME = "effectTime";
        public static final String KEY_EXPIRE_TIME = "expireTime";
        public static final String KEY_EXTRA_DATA = "extraData";
        public static final String KEY_FAILED_REASON = "failedReason";
        public static final String KEY_HASH_VALUE = "md5Hash";
        public static final String KEY_ID = "id";
        public static final String KEY_META_DATA = "metaData";
        public static final String KEY_MODULE_DATA = "moduleData";
        public static final String KEY_NAME = "resourceName";
        public static final String KEY_PRICE = "price";
        public static final String KEY_PROGRESS = "progress";
        public static final String KEY_RESOURCE_FROM = "resourceFrom";
        public static final String KEY_RESOURCE_ICON = "resourceIcon";
        public static final String KEY_STATUS = "status";
        public static final String KEY_TARGET_PATH = "targetPath";
        public static final String KEY_TYPE = "resourceType";
        public static final String KEY_UPDATE_TIME = "updateTime";
        public static final String META_DATA_FILE_NAME = "description.json";
    }

    /* loaded from: classes.dex */
    public static class OperateResult {
        public static final int CODE_RESULT_FAIL = 0;
        public static final int CODE_RESULT_SUCCESS = 1;
    }

    /* loaded from: classes.dex */
    public static class PresetPath {
        public static final String KEY_SPEECH_SETTING_PROVIDER = "key_unzipped_speech";
        public static final String KEY_TTS_SETTING_PROVIDER = "key_unzipped_tts";
        public static final String PATH_DANCE_RSC = "/system/etc/xuiservice/dance/";
        public static final String PATH_DANCE_TARGET = "/data/xuiservice/rsc/llu/";
        public static final String PATH_OPERATION = "/data/xuiservice/rsc/";
        public static final String PATH_OPERATION_DOWNLOAD = "/data/operation/resource/";
        public static final String PATH_PRESET_DANCE_INFO = "/system/etc/xuiservice/dance/LocalDance_Info.json";
        public static final String PATH_SPEECH_RSC = "/system/speech/";
        public static final String PATH_SPEECH_TARGET = "/sdcard/speech/";
        public static final String PATH_TTS_RSC = "/system/tts/";
        public static final String PATH_TTS_TARGET = "/mnt/tts/";
    }

    static {
        mResourceFolderNameArray.put(OperationType.LLU, "llu");
        mResourceFolderNameArray.put(OperationType.AI_SPEECH, "aispeech");
        mResourceFolderNameArray.put(OperationType.EGG, "egg");
        mResourceFolderNameArray.put(OperationType.WELCOME_SOUND, "welcome_sound");
        mResourceFolderNameArray.put(OperationType.AVATAR, "avatar");
        mResourceFolderNameArray.put(OperationType.NAVI_RESOURCE, "navi");
    }

    public static String getPathByType(int type) {
        String folderName = mResourceFolderNameArray.get(type);
        if (folderName == null) {
            String folderName2 = generateDefaultTypeFolder(type);
            synchronized (mResourceFolderNameArray) {
                mResourceFolderNameArray.put(type, folderName2);
            }
            folderName = folderName2;
        }
        return PresetPath.PATH_OPERATION_DOWNLOAD + folderName + "/";
    }

    private static String generateDefaultTypeFolder(int type) {
        Field[] fields = OperationType.class.getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Field field = fields[i];
            try {
            } catch (Exception e) {
                String str = TAG;
                LogUtil.w(str, "type not support:" + type);
            }
            if (field.getInt(OperationType.class) != type) {
                continue;
            } else {
                return field.getName();
            }
        }
        return String.valueOf(type);
    }
}
