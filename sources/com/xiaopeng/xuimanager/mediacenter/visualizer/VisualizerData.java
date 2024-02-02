package com.xiaopeng.xuimanager.mediacenter.visualizer;
/* loaded from: classes.dex */
public class VisualizerData {
    private byte[] mFftData;
    private int mSamplingRate;

    public VisualizerData(byte[] fft, int samplingRate) {
        this.mFftData = fft;
        this.mSamplingRate = samplingRate;
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
