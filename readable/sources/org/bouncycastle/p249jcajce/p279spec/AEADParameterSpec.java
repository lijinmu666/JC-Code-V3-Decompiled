package org.bouncycastle.p249jcajce.p279spec;

import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class AEADParameterSpec extends IvParameterSpec {
    private final byte[] associatedData;
    private final int macSizeInBits;

    public AEADParameterSpec(byte[] bArr, int i) {
        this(bArr, i, null);
    }

    public byte[] getAssociatedData() {
        return C6238Arrays.m18231clone(this.associatedData);
    }

    public int getMacSizeInBits() {
        return this.macSizeInBits;
    }

    public byte[] getNonce() {
        return getIV();
    }

    public AEADParameterSpec(byte[] bArr, int i, byte[] bArr2) {
        super(bArr);
        this.macSizeInBits = i;
        this.associatedData = C6238Arrays.m18231clone(bArr2);
    }
}
