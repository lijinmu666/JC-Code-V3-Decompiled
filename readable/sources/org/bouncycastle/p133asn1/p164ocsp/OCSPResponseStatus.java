package org.bouncycastle.p133asn1.p164ocsp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class OCSPResponseStatus extends ASN1Object {
    public static final int INTERNAL_ERROR = 2;
    public static final int MALFORMED_REQUEST = 1;
    public static final int SIG_REQUIRED = 5;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_LATER = 3;
    public static final int UNAUTHORIZED = 6;

    /* renamed from: value */
    private ASN1Enumerated f18441value;

    public OCSPResponseStatus(int i) {
        this(new ASN1Enumerated(i));
    }

    public static OCSPResponseStatus getInstance(Object obj) {
        if (obj instanceof OCSPResponseStatus) {
            return (OCSPResponseStatus) obj;
        }
        if (obj != null) {
            return new OCSPResponseStatus(ASN1Enumerated.getInstance(obj));
        }
        return null;
    }

    public int getIntValue() {
        return this.f18441value.intValueExact();
    }

    public BigInteger getValue() {
        return this.f18441value.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18441value;
    }

    private OCSPResponseStatus(ASN1Enumerated aSN1Enumerated) {
        this.f18441value = aSN1Enumerated;
    }
}
