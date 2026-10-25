package p131o;

import p132okio.C5066Utf8;

/* renamed from: o.sz */
/* loaded from: classes.dex */
public abstract class AbstractC4585sz {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /* renamed from: AZxh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* bridge */ /* synthetic */ void m13532AZxh(byte b, byte b2, byte b3, char[] cArr, int i) throws C4315oy {
        if (!m13533KLFTb(b2)) {
            if (b != -32) {
                if (b != -19) {
                    if (!m13533KLFTb(b3)) {
                        cArr[i] = (char) (((b & 15) << 12) | ((b2 & C5066Utf8.REPLACEMENT_BYTE) << 6) | (b3 & C5066Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                } else if (b2 < -96) {
                    b = -19;
                    if (!m13533KLFTb(b3)) {
                    }
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b != -19) {
                }
            }
        }
        throw new C4315oy("Protocol message had invalid UTF-8.");
    }

    /* renamed from: KLFTb */
    public static boolean m13533KLFTb(byte b) {
        return b > -65;
    }

    /* renamed from: ZfxDd */
    public static /* bridge */ /* synthetic */ boolean m13534ZfxDd(byte b) {
        return b >= 0;
    }

    /* renamed from: mjFkc */
    public static /* bridge */ /* synthetic */ void m13535mjFkc(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws C4315oy {
        if (m13533KLFTb(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m13533KLFTb(b3) || m13533KLFTb(b4)) {
            throw new C4315oy("Protocol message had invalid UTF-8.");
        }
        int i2 = ((b & 7) << 18) | ((b2 & C5066Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & C5066Utf8.REPLACEMENT_BYTE) << 6) | (b4 & C5066Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + C5066Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + C5066Utf8.LOG_SURROGATE_HEADER);
    }

    /* renamed from: wA */
    public static /* bridge */ /* synthetic */ void m13536wA(byte b, byte b2, char[] cArr, int i) throws C4315oy {
        if (b < -62 || m13533KLFTb(b2)) {
            throw new C4315oy("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & C5066Utf8.REPLACEMENT_BYTE));
    }
}
