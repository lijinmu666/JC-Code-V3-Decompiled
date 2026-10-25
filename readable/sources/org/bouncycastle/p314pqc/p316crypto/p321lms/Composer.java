package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class Composer {

    /* renamed from: bos */
    private final ByteArrayOutputStream f23213bos = new ByteArrayOutputStream();

    private Composer() {
    }

    /* renamed from: compose */
    public static Composer m17598compose() {
        return new Composer();
    }

    /* renamed from: bool */
    public Composer m17599bool(boolean z) {
        this.f23213bos.write(z ? 1 : 0);
        return this;
    }

    /* renamed from: build */
    public byte[] m17600build() {
        return this.f23213bos.toByteArray();
    }

    /* renamed from: bytes */
    public Composer m17601bytes(Encodable encodable) throws IOException {
        try {
            this.f23213bos.write(encodable.getEncoded());
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: pad */
    public Composer m17607pad(int i, int i2) {
        while (i2 >= 0) {
            try {
                this.f23213bos.write(i);
                i2--;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return this;
    }

    public Composer padUntil(int i, int i2) {
        while (this.f23213bos.size() < i2) {
            this.f23213bos.write(i);
        }
        return this;
    }

    /* renamed from: u16str */
    public Composer m17608u16str(int i) {
        int i2 = i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        this.f23213bos.write((byte) (i2 >>> 8));
        this.f23213bos.write((byte) i2);
        return this;
    }

    /* renamed from: u32str */
    public Composer m17609u32str(int i) {
        this.f23213bos.write((byte) (i >>> 24));
        this.f23213bos.write((byte) (i >>> 16));
        this.f23213bos.write((byte) (i >>> 8));
        this.f23213bos.write((byte) i);
        return this;
    }

    /* renamed from: u64str */
    public Composer m17610u64str(long j) {
        m17609u32str((int) (j >>> 32));
        m17609u32str((int) j);
        return this;
    }

    /* renamed from: bytes */
    public Composer m17602bytes(byte[] bArr) throws IOException {
        try {
            this.f23213bos.write(bArr);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: bytes */
    public Composer m17603bytes(byte[] bArr, int i, int i2) {
        try {
            this.f23213bos.write(bArr, i, i2);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: bytes */
    public Composer m17604bytes(Encodable[] encodableArr) throws IOException {
        try {
            for (Encodable encodable : encodableArr) {
                this.f23213bos.write(encodable.getEncoded());
            }
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: bytes */
    public Composer m17605bytes(byte[][] bArr) throws IOException {
        try {
            for (byte[] bArr2 : bArr) {
                this.f23213bos.write(bArr2);
            }
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: bytes */
    public Composer m17606bytes(byte[][] bArr, int i, int i2) throws IOException {
        while (i != i2) {
            try {
                this.f23213bos.write(bArr[i]);
                i++;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return this;
    }
}
