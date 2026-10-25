package p131o;

import android.util.Log;
import java.io.Writer;

/* renamed from: o.l1 */
/* loaded from: classes.dex */
public final class C4058l1 extends Writer {

    /* renamed from: AZxh */
    public StringBuilder f14660AZxh = new StringBuilder(128);

    /* renamed from: mjFkc */
    public final String f14661mjFkc;

    public C4058l1(String str) {
        this.f14661mjFkc = str;
    }

    /* renamed from: ZfxDd */
    public final void m12650ZfxDd() {
        if (this.f14660AZxh.length() > 0) {
            Log.d(this.f14661mjFkc, this.f14660AZxh.toString());
            StringBuilder sb = this.f14660AZxh;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m12650ZfxDd();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m12650ZfxDd();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m12650ZfxDd();
            } else {
                this.f14660AZxh.append(c);
            }
        }
    }
}
