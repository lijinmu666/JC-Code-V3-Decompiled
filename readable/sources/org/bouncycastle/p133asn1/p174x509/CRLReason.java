package org.bouncycastle.p133asn1.p174x509;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class CRLReason extends ASN1Object {
    public static final int AA_COMPROMISE = 10;
    public static final int AFFILIATION_CHANGED = 3;
    public static final int CA_COMPROMISE = 2;
    public static final int CERTIFICATE_HOLD = 6;
    public static final int CESSATION_OF_OPERATION = 5;
    public static final int KEY_COMPROMISE = 1;
    public static final int PRIVILEGE_WITHDRAWN = 9;
    public static final int REMOVE_FROM_CRL = 8;
    public static final int SUPERSEDED = 4;
    public static final int UNSPECIFIED = 0;
    public static final int aACompromise = 10;
    public static final int affiliationChanged = 3;
    public static final int cACompromise = 2;
    public static final int certificateHold = 6;
    public static final int cessationOfOperation = 5;
    public static final int keyCompromise = 1;
    public static final int privilegeWithdrawn = 9;
    public static final int removeFromCRL = 8;
    public static final int superseded = 4;
    public static final int unspecified = 0;

    /* renamed from: value */
    private ASN1Enumerated f18632value;
    private static final String[] reasonString = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* renamed from: table */
    private static final Hashtable f18631table = new Hashtable();

    private CRLReason(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid CRL reason : not in (0..MAX)");
        }
        this.f18632value = new ASN1Enumerated(i);
    }

    public static CRLReason getInstance(Object obj) {
        if (obj instanceof CRLReason) {
            return (CRLReason) obj;
        }
        if (obj != null) {
            return m14676lookup(ASN1Enumerated.getInstance(obj).intValueExact());
        }
        return null;
    }

    /* renamed from: lookup */
    public static CRLReason m14676lookup(int i) {
        Integer numM18296valueOf = Integers.m18296valueOf(i);
        Hashtable hashtable = f18631table;
        if (!hashtable.containsKey(numM18296valueOf)) {
            hashtable.put(numM18296valueOf, new CRLReason(i));
        }
        return (CRLReason) hashtable.get(numM18296valueOf);
    }

    public BigInteger getValue() {
        return this.f18632value.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18632value;
    }

    public String toString() {
        int iIntValue = getValue().intValue();
        return "CRLReason: " + ((iIntValue < 0 || iIntValue > 10) ? "invalid" : reasonString[iIntValue]);
    }
}
