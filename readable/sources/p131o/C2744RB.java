package p131o;

import java.io.OutputStream;

/* renamed from: o.RB */
/* loaded from: classes.dex */
public final class C2744RB extends OutputStream {

    /* renamed from: mjFkc */
    public long f10395mjFkc = 0;

    /* renamed from: ZfxDd */
    public final long m10058ZfxDd() {
        return this.f10395mjFkc;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f10395mjFkc++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f10395mjFkc += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i >= 0 && i <= (length = bArr.length) && i2 >= 0 && (i3 = i + i2) <= length && i3 >= 0) {
            this.f10395mjFkc += i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
