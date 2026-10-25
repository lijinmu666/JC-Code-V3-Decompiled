package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public final class InputStreamWithMAC extends InputStream {

    /* renamed from: base */
    private final InputStream f19014base;
    private boolean baseFinished = false;

    /* renamed from: index */
    private int f19015index = 0;

    /* renamed from: mac */
    private byte[] f19016mac;
    private MACProvider macProvider;

    public InputStreamWithMAC(InputStream inputStream, MACProvider mACProvider) {
        this.f19014base = inputStream;
        this.macProvider = mACProvider;
    }

    /* renamed from: getMAC */
    public byte[] m14882getMAC() {
        if (this.baseFinished) {
            return C6238Arrays.m18231clone(this.f19016mac);
        }
        throw new IllegalStateException("input stream not fully processed");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte b;
        if (this.baseFinished) {
            int i = this.f19015index;
            byte[] bArr = this.f19016mac;
            if (i >= bArr.length) {
                return -1;
            }
            this.f19015index = i + 1;
            b = bArr[i];
        } else {
            int i2 = this.f19014base.read();
            if (i2 >= 0) {
                return i2;
            }
            this.baseFinished = true;
            MACProvider mACProvider = this.macProvider;
            if (mACProvider != null) {
                mACProvider.mo14848init();
                this.f19016mac = this.macProvider.mo14847getMAC();
            }
            byte[] bArr2 = this.f19016mac;
            int i3 = this.f19015index;
            this.f19015index = i3 + 1;
            b = bArr2[i3];
        }
        return b & C1126UByte.MAX_VALUE;
    }

    public InputStreamWithMAC(InputStream inputStream, byte[] bArr) {
        this.f19014base = inputStream;
        this.f19016mac = bArr;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("input array is null");
        }
        if (i < 0 || bArr.length < i + i2) {
            throw new IndexOutOfBoundsException("invalid off(" + i + ") and len(" + i2 + ")");
        }
        if (this.baseFinished) {
            int i3 = this.f19015index;
            byte[] bArr2 = this.f19016mac;
            if (i3 >= bArr2.length) {
                return -1;
            }
            if (i2 >= bArr2.length - i3) {
                System.arraycopy(bArr2, i3, bArr, i, bArr2.length - i3);
                byte[] bArr3 = this.f19016mac;
                int length = bArr3.length - this.f19015index;
                this.f19015index = bArr3.length;
                return length;
            }
            System.arraycopy(bArr2, i3, bArr, i, i2);
        } else {
            int i4 = this.f19014base.read(bArr, i, i2);
            if (i4 >= 0) {
                return i4;
            }
            this.baseFinished = true;
            MACProvider mACProvider = this.macProvider;
            if (mACProvider != null) {
                mACProvider.mo14848init();
                this.f19016mac = this.macProvider.mo14847getMAC();
            }
            byte[] bArr4 = this.f19016mac;
            if (i2 >= bArr4.length) {
                System.arraycopy(bArr4, 0, bArr, i, bArr4.length);
                byte[] bArr5 = this.f19016mac;
                this.f19015index = bArr5.length;
                return bArr5.length;
            }
            System.arraycopy(bArr4, 0, bArr, i, i2);
        }
        this.f19015index += i2;
        return i2;
    }
}
