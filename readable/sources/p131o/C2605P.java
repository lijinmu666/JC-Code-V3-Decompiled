package p131o;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.SystemClock;
import java.nio.ByteBuffer;

/* renamed from: o.P */
/* loaded from: classes.dex */
public class C2605P implements InterfaceC4588t1 {

    /* renamed from: AZxh */
    public volatile ByteBuffer f10023AZxh;

    /* renamed from: JHa */
    public final int f10024JHa;

    /* renamed from: KLFTb */
    public final int f10025KLFTb;

    /* renamed from: ZfxDd */
    public final int f10026ZfxDd;

    /* renamed from: mjFkc */
    public volatile Bitmap f10027mjFkc;

    /* renamed from: wA */
    public final int f10028wA;

    /* renamed from: xJ */
    public final Matrix f10029xJ;

    public C2605P(Bitmap bitmap, int i) {
        this.f10027mjFkc = (Bitmap) AbstractC2138I3.m8648xJ(bitmap);
        this.f10028wA = bitmap.getWidth();
        this.f10026ZfxDd = bitmap.getHeight();
        m9925ETF(i);
        this.f10025KLFTb = i;
        this.f10024JHa = -1;
        this.f10029xJ = null;
    }

    /* renamed from: ETF */
    public static int m9925ETF(int i) {
        boolean z = true;
        if (i != 0 && i != 90 && i != 180) {
            if (i == 270) {
                i = 270;
            } else {
                z = false;
            }
        }
        AbstractC2138I3.m8639AZxh(z, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        return i;
    }

    /* renamed from: VA */
    public static void m9926VA(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        AbstractC3095WQ.m10836mjFkc(AbstractC2827SQ.m10149AZxh("vision-common"), i, i2, j, i3, i4, i5, i6);
    }

    /* renamed from: mjFkc */
    public static C2605P m9927mjFkc(Bitmap bitmap, int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C2605P c2605p = new C2605P(bitmap, i);
        m9926VA(-1, 1, jElapsedRealtime, bitmap.getHeight(), bitmap.getWidth(), bitmap.getAllocationByteCount(), i);
        return c2605p;
    }

    /* renamed from: AZxh */
    public Bitmap m9928AZxh() {
        return this.f10027mjFkc;
    }

    /* renamed from: Dt */
    public int m9929Dt() {
        return this.f10028wA;
    }

    /* renamed from: JHa */
    public int m9930JHa() {
        return this.f10026ZfxDd;
    }

    /* renamed from: KLFTb */
    public int m9931KLFTb() {
        return this.f10024JHa;
    }

    /* renamed from: ZfxDd */
    public Matrix m9932ZfxDd() {
        return this.f10029xJ;
    }

    /* renamed from: lgHUyS */
    public Image.Plane[] m9933lgHUyS() {
        return null;
    }

    /* renamed from: qdMbNW */
    public int m9934qdMbNW() {
        return this.f10025KLFTb;
    }

    /* renamed from: wA */
    public ByteBuffer m9935wA() {
        return this.f10023AZxh;
    }

    /* renamed from: xJ */
    public Image m9936xJ() {
        return null;
    }
}
