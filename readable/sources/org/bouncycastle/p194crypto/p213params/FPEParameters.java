package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p221util.RadixConverter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class FPEParameters implements CipherParameters {

    /* renamed from: key */
    private final KeyParameter f20751key;
    private final RadixConverter radixConverter;

    /* renamed from: tweak */
    private final byte[] f20752tweak;
    private final boolean useInverse;

    public FPEParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, false);
    }

    /* renamed from: getKey */
    public KeyParameter m15748getKey() {
        return this.f20751key;
    }

    public int getRadix() {
        return this.radixConverter.getRadix();
    }

    public RadixConverter getRadixConverter() {
        return this.radixConverter;
    }

    public byte[] getTweak() {
        return C6238Arrays.m18231clone(this.f20752tweak);
    }

    public boolean isUsingInverseFunction() {
        return this.useInverse;
    }

    public FPEParameters(KeyParameter keyParameter, int i, byte[] bArr, boolean z) {
        this(keyParameter, new RadixConverter(i), bArr, z);
    }

    public FPEParameters(KeyParameter keyParameter, RadixConverter radixConverter, byte[] bArr, boolean z) {
        this.f20751key = keyParameter;
        this.radixConverter = radixConverter;
        this.f20752tweak = C6238Arrays.m18231clone(bArr);
        this.useInverse = z;
    }
}
