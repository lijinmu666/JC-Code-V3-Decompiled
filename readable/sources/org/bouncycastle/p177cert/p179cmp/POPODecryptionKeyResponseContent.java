package org.bouncycastle.p177cert.p179cmp;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.POPODecKeyRespContent;

/* loaded from: classes2.dex */
public class POPODecryptionKeyResponseContent {
    private final POPODecKeyRespContent respContent;

    public POPODecryptionKeyResponseContent(POPODecKeyRespContent pOPODecKeyRespContent) {
        this.respContent = pOPODecKeyRespContent;
    }

    public static POPODecryptionKeyResponseContent fromPKIBody(C5114PKIBody c5114PKIBody) {
        if (c5114PKIBody.m14517getType() == 6) {
            return new POPODecryptionKeyResponseContent(POPODecKeyRespContent.getInstance(c5114PKIBody.getContent()));
        }
        throw new IllegalArgumentException("content of PKIBody wrong type: " + c5114PKIBody.m14517getType());
    }

    public byte[][] getResponses() {
        ASN1Integer[] aSN1IntegerArray = this.respContent.toASN1IntegerArray();
        byte[][] bArr = new byte[aSN1IntegerArray.length][];
        for (int i = 0; i != aSN1IntegerArray.length; i++) {
            bArr[i] = aSN1IntegerArray[i].getValue().toByteArray();
        }
        return bArr;
    }

    public POPODecKeyRespContent toASN1Structure() {
        return this.respContent;
    }
}
