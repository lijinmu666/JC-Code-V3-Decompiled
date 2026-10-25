package p131o;

import java.io.OutputStream;

/* renamed from: o.mF */
/* loaded from: classes.dex */
public final class C4137mF extends OutputStream {

    /* renamed from: mjFkc */
    public long f14890mjFkc = 0;

    /* renamed from: ZfxDd */
    public final long m12762ZfxDd() {
        return this.f14890mjFkc;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f14890mjFkc++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f14890mjFkc += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i >= 0 && i <= (length = bArr.length) && i2 >= 0 && (i3 = i + i2) <= length && i3 >= 0) {
            this.f14890mjFkc += i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
