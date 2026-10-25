package p131o;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;

/* renamed from: o.I */
/* loaded from: classes.dex */
public class C2134I {

    /* renamed from: mjFkc */
    public static final C3401b f8664mjFkc = new C3401b("MLKitImageUtils", BuildConfig.f24315FLAVOR);

    /* renamed from: AZxh */
    public static final C2134I f8663AZxh = new C2134I();

    /* renamed from: AZxh */
    public static C2134I m8634AZxh() {
        return f8663AZxh;
    }

    /* renamed from: KLFTb */
    public Matrix m8635KLFTb(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* renamed from: ZfxDd */
    public int m8636ZfxDd(C2605P c2605p) {
        if (c2605p.m9931KLFTb() == -1) {
            return ((Bitmap) AbstractC2138I3.m8648xJ(c2605p.m9928AZxh())).getAllocationByteCount();
        }
        if (c2605p.m9931KLFTb() == 17 || c2605p.m9931KLFTb() == 842094169) {
            return ((ByteBuffer) AbstractC2138I3.m8648xJ(c2605p.m9935wA())).limit();
        }
        if (c2605p.m9931KLFTb() != 35) {
            return 0;
        }
        return (((Image.Plane[]) AbstractC2138I3.m8648xJ(c2605p.m9933lgHUyS()))[0].getBuffer().limit() * 3) / 2;
    }

    /* renamed from: mjFkc */
    public InterfaceC1929F m8637mjFkc(C2605P c2605p) throws C3993k2 {
        int iM9931KLFTb = c2605p.m9931KLFTb();
        if (iM9931KLFTb == -1) {
            return BinderC2869T2.m10213Ucbh((Bitmap) AbstractC2138I3.m8648xJ(c2605p.m9928AZxh()));
        }
        if (iM9931KLFTb != 17) {
            if (iM9931KLFTb == 35) {
                return BinderC2869T2.m10213Ucbh(c2605p.m9936xJ());
            }
            if (iM9931KLFTb != 842094169) {
                throw new C3993k2("Unsupported image format: " + c2605p.m9931KLFTb(), 3);
            }
        }
        return BinderC2869T2.m10213Ucbh((ByteBuffer) AbstractC2138I3.m8648xJ(c2605p.m9935wA()));
    }

    /* renamed from: wA */
    public int m8638wA(C2605P c2605p) {
        return c2605p.m9931KLFTb();
    }
}
