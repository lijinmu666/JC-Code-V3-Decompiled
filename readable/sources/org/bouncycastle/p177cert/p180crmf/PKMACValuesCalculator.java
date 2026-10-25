package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface PKMACValuesCalculator {
    byte[] calculateDigest(byte[] bArr);

    byte[] calculateMac(byte[] bArr, byte[] bArr2);

    /* renamed from: setup */
    void mo14792setup(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2);
}
