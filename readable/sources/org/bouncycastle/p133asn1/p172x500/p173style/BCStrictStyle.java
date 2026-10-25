package org.bouncycastle.p133asn1.p172x500.p173style;

import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;

/* loaded from: classes2.dex */
public class BCStrictStyle extends C5189BCStyle {
    public static final X500NameStyle INSTANCE = new BCStrictStyle();

    @Override // org.bouncycastle.p133asn1.p172x500.p173style.AbstractX500NameStyle, org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        if (x500Name.m14667size() != x500Name2.m14667size()) {
            return false;
        }
        C5188RDN[] c5188rdnArrM14665getRDNs = x500Name.m14665getRDNs();
        C5188RDN[] c5188rdnArrM14665getRDNs2 = x500Name2.m14665getRDNs();
        for (int i = 0; i != c5188rdnArrM14665getRDNs.length; i++) {
            if (!rdnAreEqual(c5188rdnArrM14665getRDNs[i], c5188rdnArrM14665getRDNs2[i])) {
                return false;
            }
        }
        return true;
    }
}
