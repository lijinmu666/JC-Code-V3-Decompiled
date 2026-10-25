package org.bouncycastle.p194crypto.agreement.p197kdf;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.DerivationParameters;

/* loaded from: classes2.dex */
public class DHKDFParameters implements DerivationParameters {
    private ASN1ObjectIdentifier algorithm;
    private byte[] extraInfo;

    /* renamed from: keySize */
    private int f19212keySize;

    /* renamed from: z */
    private byte[] f19213z;

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr) {
        this(aSN1ObjectIdentifier, i, bArr, null);
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }

    public int getKeySize() {
        return this.f19212keySize;
    }

    /* renamed from: getZ */
    public byte[] m15028getZ() {
        return this.f19213z;
    }

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.algorithm = aSN1ObjectIdentifier;
        this.f19212keySize = i;
        this.f19213z = bArr;
        this.extraInfo = bArr2;
    }
}
