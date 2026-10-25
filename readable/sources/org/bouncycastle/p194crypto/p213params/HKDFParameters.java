package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HKDFParameters implements DerivationParameters {

    /* renamed from: ikm */
    private final byte[] f20764ikm;

    /* renamed from: info */
    private final byte[] f20765info;

    /* renamed from: salt */
    private final byte[] f20766salt;
    private final boolean skipExtract;

    private HKDFParameters(byte[] bArr, boolean z, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            throw new IllegalArgumentException("IKM (input keying material) should not be null");
        }
        this.f20764ikm = C6238Arrays.m18231clone(bArr);
        this.skipExtract = z;
        if (bArr2 == null || bArr2.length == 0) {
            this.f20766salt = null;
        } else {
            this.f20766salt = C6238Arrays.m18231clone(bArr2);
        }
        if (bArr3 == null) {
            this.f20765info = new byte[0];
        } else {
            this.f20765info = C6238Arrays.m18231clone(bArr3);
        }
    }

    public static HKDFParameters defaultParameters(byte[] bArr) {
        return new HKDFParameters(bArr, false, null, null);
    }

    public static HKDFParameters skipExtractParameters(byte[] bArr, byte[] bArr2) {
        return new HKDFParameters(bArr, true, null, bArr2);
    }

    /* renamed from: getIKM */
    public byte[] m15760getIKM() {
        return C6238Arrays.m18231clone(this.f20764ikm);
    }

    /* renamed from: getInfo */
    public byte[] m15761getInfo() {
        return C6238Arrays.m18231clone(this.f20765info);
    }

    /* renamed from: getSalt */
    public byte[] m15762getSalt() {
        return C6238Arrays.m18231clone(this.f20766salt);
    }

    public boolean skipExtract() {
        return this.skipExtract;
    }

    public HKDFParameters(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this(bArr, false, bArr2, bArr3);
    }
}
