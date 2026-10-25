package p131o;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: o.my */
/* loaded from: classes.dex */
public abstract class AbstractC4183my {

    /* renamed from: AZxh */
    public static final byte[] f15286AZxh;

    /* renamed from: mjFkc */
    public static final Charset f15287mjFkc;

    static {
        Charset.forName("US-ASCII");
        f15287mjFkc = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f15286AZxh = bArr;
        ByteBuffer.wrap(bArr);
        int i = AbstractC1795Cx.f7766mjFkc;
        try {
            new C1659Ax(bArr, 0, 0, false, null).m7641wA(0);
        } catch (C4315oy e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: AZxh */
    public static int m12815AZxh(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: ZfxDd */
    public static boolean m12816ZfxDd(InterfaceC2341Ky interfaceC2341Ky) {
        return false;
    }

    /* renamed from: mjFkc */
    public static int m12817mjFkc(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: wA */
    public static Object m12818wA(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }
}
