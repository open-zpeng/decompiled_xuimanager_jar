package com.xiaopeng.xuimanager.mediacenter.visualizer;
/* loaded from: classes.dex */
public class TypeVisualizerData {
    private byte[] mFftData;
    private int mSamplingRate;
    private int mType;

    public TypeVisualizerData(int type, byte[] fft, int samplingRate) {
        this.mType = type;
        this.mFftData = fft;
        this.mSamplingRate = samplingRate;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public byte[] getFftData() {
        return this.mFftData;
    }

    public void setFftData(byte[] fftData) {
        this.mFftData = fftData;
    }

    public int getSamplingRate() {
        return this.mSamplingRate;
    }

    public void setSamplingRate(int samplingRate) {
        this.mSamplingRate = samplingRate;
    }
}
