package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p139cms.p140ecc.ECCCMSSharedInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
class RFC5753KeyMaterialGenerator implements KeyMaterialGenerator {
    @Override // org.bouncycastle.p191cms.p193jcajce.KeyMaterialGenerator
    public byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
        try {
            return new ECCCMSSharedInfo(algorithmIdentifier, bArr, AbstractC6245Pack.intToBigEndian(i)).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create KDF material: " + e);
        }
    }
}
