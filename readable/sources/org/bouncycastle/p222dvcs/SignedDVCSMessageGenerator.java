package org.bouncycastle.p222dvcs;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSProcessableByteArray;
import org.bouncycastle.p191cms.CMSSignedData;
import org.bouncycastle.p191cms.CMSSignedDataGenerator;

/* loaded from: classes2.dex */
public class SignedDVCSMessageGenerator {
    private final CMSSignedDataGenerator signedDataGen;

    public SignedDVCSMessageGenerator(CMSSignedDataGenerator cMSSignedDataGenerator) {
        this.signedDataGen = cMSSignedDataGenerator;
    }

    /* renamed from: build */
    public CMSSignedData m15944build(DVCSMessage dVCSMessage) throws DVCSException {
        try {
            return this.signedDataGen.generate(new CMSProcessableByteArray(dVCSMessage.getContentType(), dVCSMessage.getContent().toASN1Primitive().getEncoded(ASN1Encoding.f17902DER)), true);
        } catch (IOException e) {
            throw new DVCSException("Could not encode DVCS request", e);
        } catch (CMSException e2) {
            throw new DVCSException("Could not sign DVCS request", e2);
        }
    }
}
