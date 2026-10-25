package org.bouncycastle.p177cert.p179cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p138cmp.RevDetails;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class RevocationDetails {
    private RevDetails revDetails;

    public RevocationDetails(RevDetails revDetails) {
        this.revDetails = revDetails;
    }

    public X500Name getIssuer() {
        return this.revDetails.getCertDetails().getIssuer();
    }

    public BigInteger getSerialNumber() {
        return this.revDetails.getCertDetails().getSerialNumber().getValue();
    }

    public X500Name getSubject() {
        return this.revDetails.getCertDetails().getSubject();
    }

    public RevDetails toASN1Structure() {
        return this.revDetails;
    }
}
