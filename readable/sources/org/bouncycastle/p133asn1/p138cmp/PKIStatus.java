package org.bouncycastle.p133asn1.p138cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes.dex */
public class PKIStatus extends ASN1Object {

    /* renamed from: GRANTED */
    public static final int f18146GRANTED = 0;
    public static final int GRANTED_WITH_MODS = 1;
    public static final int KEY_UPDATE_WARNING = 6;
    public static final int REJECTION = 2;
    public static final int REVOCATION_NOTIFICATION = 5;
    public static final int REVOCATION_WARNING = 4;

    /* renamed from: WAITING */
    public static final int f18147WAITING = 3;

    /* renamed from: value */
    private final ASN1Integer f18150value;

    /* renamed from: granted */
    public static final PKIStatus f18148granted = new PKIStatus(0);
    public static final PKIStatus grantedWithMods = new PKIStatus(1);
    public static final PKIStatus rejection = new PKIStatus(2);

    /* renamed from: waiting */
    public static final PKIStatus f18149waiting = new PKIStatus(3);
    public static final PKIStatus revocationWarning = new PKIStatus(4);
    public static final PKIStatus revocationNotification = new PKIStatus(5);
    public static final PKIStatus keyUpdateWaiting = new PKIStatus(6);

    private PKIStatus(int i) {
        this(ASN1Integer.m14429valueOf(i));
    }

    public static PKIStatus getInstance(Object obj) {
        if (obj instanceof PKIStatus) {
            return (PKIStatus) obj;
        }
        if (obj != null) {
            return new PKIStatus(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.f18150value.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18150value;
    }

    private PKIStatus(ASN1Integer aSN1Integer) {
        this.f18150value = aSN1Integer;
    }
}
