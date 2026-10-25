package org.bouncycastle.p296mime;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6250Strings;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class BoundaryLimitedInputStream extends InputStream {
    private final byte[] boundary;

    /* renamed from: buf */
    private final byte[] f22493buf;

    /* renamed from: bufOff */
    private int f22494bufOff;

    /* renamed from: lastI */
    private int f22497lastI;

    /* renamed from: src */
    private final InputStream f22498src;

    /* renamed from: index */
    private int f22496index = 0;

    /* renamed from: ended */
    private boolean f22495ended = false;

    public BoundaryLimitedInputStream(InputStream inputStream, String str) {
        this.f22494bufOff = 0;
        this.f22498src = inputStream;
        this.boundary = C6250Strings.toByteArray(str);
        this.f22493buf = new byte[str.length() + 3];
        this.f22494bufOff = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read() throws IOException {
        int i;
        int i2;
        int i3;
        if (this.f22495ended) {
            return -1;
        }
        int i4 = this.f22496index;
        int i5 = this.f22494bufOff;
        if (i4 < i5) {
            byte[] bArr = this.f22493buf;
            int i6 = i4 + 1;
            this.f22496index = i6;
            i = bArr[i4] & C1126UByte.MAX_VALUE;
            if (i6 < i5) {
                return i;
            }
            this.f22494bufOff = 0;
            this.f22496index = 0;
        } else {
            i = this.f22498src.read();
        }
        this.f22497lastI = i;
        if (i < 0) {
            return -1;
        }
        if (i == 13 || i == 10) {
            this.f22496index = 0;
            if (i != 13) {
                i2 = this.f22498src.read();
                if (i2 == 45) {
                    byte[] bArr2 = this.f22493buf;
                    int i7 = this.f22494bufOff;
                    this.f22494bufOff = i7 + 1;
                    bArr2[i7] = 45;
                    i2 = this.f22498src.read();
                }
                if (i2 != 45) {
                    byte[] bArr3 = this.f22493buf;
                    int i8 = this.f22494bufOff;
                    int i9 = i8 + 1;
                    this.f22494bufOff = i9;
                    bArr3[i8] = 45;
                    while (true) {
                        if (this.f22494bufOff - i9 == this.boundary.length || (i3 = this.f22498src.read()) < 0) {
                            break;
                        }
                        byte[] bArr4 = this.f22493buf;
                        int i10 = this.f22494bufOff;
                        byte b = (byte) i3;
                        bArr4[i10] = b;
                        if (b != this.boundary[i10 - i9]) {
                            this.f22494bufOff = i10 + 1;
                            break;
                        }
                        this.f22494bufOff = i10 + 1;
                    }
                    if (this.f22494bufOff - i9 == this.boundary.length) {
                        this.f22495ended = true;
                        return -1;
                    }
                } else if (i2 >= 0) {
                    byte[] bArr5 = this.f22493buf;
                    int i11 = this.f22494bufOff;
                    this.f22494bufOff = i11 + 1;
                    bArr5[i11] = (byte) i2;
                }
            } else {
                i2 = this.f22498src.read();
                if (i2 == 10) {
                    byte[] bArr6 = this.f22493buf;
                    int i12 = this.f22494bufOff;
                    this.f22494bufOff = i12 + 1;
                    bArr6[i12] = 10;
                    i2 = this.f22498src.read();
                }
                if (i2 == 45) {
                }
                if (i2 != 45) {
                }
            }
        }
        return i;
    }
}
