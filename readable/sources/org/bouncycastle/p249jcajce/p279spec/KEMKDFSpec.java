package org.bouncycastle.p249jcajce.p279spec;

import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KEMKDFSpec {
    private final AlgorithmIdentifier kdfAlgorithm;
    private final String keyAlgorithmName;
    private final int keySizeInBits;
    private final byte[] otherInfo;

    public KEMKDFSpec(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, String str, int i) {
        this.keyAlgorithmName = str;
        this.keySizeInBits = i;
        this.kdfAlgorithm = algorithmIdentifier;
        this.otherInfo = bArr;
    }

    public AlgorithmIdentifier getKdfAlgorithm() {
        return this.kdfAlgorithm;
    }

    public String getKeyAlgorithmName() {
        return this.keyAlgorithmName;
    }

    public int getKeySize() {
        return this.keySizeInBits;
    }

    public byte[] getOtherInfo() {
        return C6238Arrays.m18231clone(this.otherInfo);
    }
}
