package p131o;

import android.view.MotionEvent;

/* renamed from: o.N9 */
/* loaded from: classes.dex */
public class C2486N9 {

    /* renamed from: mjFkc */
    public final float[] f9705mjFkc = new float[20];

    /* renamed from: AZxh */
    public final long[] f9702AZxh = new long[20];

    /* renamed from: wA */
    public float f9706wA = 0.0f;

    /* renamed from: ZfxDd */
    public int f9704ZfxDd = 0;

    /* renamed from: KLFTb */
    public int f9703KLFTb = 0;

    /* renamed from: JHa */
    public static float m9639JHa(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    /* renamed from: AZxh */
    public final void m9640AZxh() {
        this.f9704ZfxDd = 0;
        this.f9706wA = 0.0f;
    }

    /* renamed from: KLFTb */
    public final float m9641KLFTb() {
        long[] jArr;
        long j;
        int i = this.f9704ZfxDd;
        if (i < 2) {
            return 0.0f;
        }
        int i2 = this.f9703KLFTb;
        int i3 = ((i2 + 20) - (i - 1)) % 20;
        long j2 = this.f9702AZxh[i2];
        while (true) {
            jArr = this.f9702AZxh;
            j = jArr[i3];
            if (j2 - j <= 100) {
                break;
            }
            this.f9704ZfxDd--;
            i3 = (i3 + 1) % 20;
        }
        int i4 = this.f9704ZfxDd;
        if (i4 < 2) {
            return 0.0f;
        }
        if (i4 == 2) {
            int i5 = (i3 + 1) % 20;
            if (j == jArr[i5]) {
                return 0.0f;
            }
            return this.f9705mjFkc[i5] / (r2 - j);
        }
        float fAbs = 0.0f;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f9704ZfxDd - 1; i7++) {
            int i8 = i7 + i3;
            long[] jArr2 = this.f9702AZxh;
            long j3 = jArr2[i8 % 20];
            int i9 = (i8 + 1) % 20;
            if (jArr2[i9] != j3) {
                i6++;
                float fM9639JHa = m9639JHa(fAbs);
                float f = this.f9705mjFkc[i9] / (this.f9702AZxh[i9] - j3);
                fAbs += (f - fM9639JHa) * Math.abs(f);
                if (i6 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return m9639JHa(fAbs);
    }

    /* renamed from: ZfxDd */
    public float m9642ZfxDd(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.f9706wA;
    }

    /* renamed from: mjFkc */
    public void m9643mjFkc(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f9704ZfxDd != 0 && eventTime - this.f9702AZxh[this.f9703KLFTb] > 40) {
            m9640AZxh();
        }
        int i = (this.f9703KLFTb + 1) % 20;
        this.f9703KLFTb = i;
        int i2 = this.f9704ZfxDd;
        if (i2 != 20) {
            this.f9704ZfxDd = i2 + 1;
        }
        this.f9705mjFkc[i] = motionEvent.getAxisValue(26);
        this.f9702AZxh[this.f9703KLFTb] = eventTime;
    }

    /* renamed from: wA */
    public void m9644wA(int i, float f) {
        float fM9641KLFTb = m9641KLFTb() * i;
        this.f9706wA = fM9641KLFTb;
        if (fM9641KLFTb < (-Math.abs(f))) {
            this.f9706wA = -Math.abs(f);
        } else if (this.f9706wA > Math.abs(f)) {
            this.f9706wA = Math.abs(f);
        }
    }
}
