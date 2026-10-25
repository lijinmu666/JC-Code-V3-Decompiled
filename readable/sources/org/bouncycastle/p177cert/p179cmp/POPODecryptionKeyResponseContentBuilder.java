package org.bouncycastle.p177cert.p179cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.POPODecKeyRespContent;

/* loaded from: classes2.dex */
public class POPODecryptionKeyResponseContentBuilder {

    /* renamed from: v */
    private ASN1EncodableVector f18814v = new ASN1EncodableVector();

    public POPODecryptionKeyResponseContentBuilder addChallengeResponse(byte[] bArr) {
        this.f18814v.m14420add(new ASN1Integer(new BigInteger(bArr)));
        return this;
    }

    /* renamed from: build */
    public POPODecryptionKeyResponseContent m14764build() {
        return new POPODecryptionKeyResponseContent(POPODecKeyRespContent.getInstance(new DERSequence(this.f18814v)));
    }
}
