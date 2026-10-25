package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class X9ECPoint extends ASN1Object {

    /* renamed from: c */
    private AbstractC5817ECCurve f18783c;
    private final ASN1OctetString encoding;

    /* renamed from: p */
    private AbstractC5820ECPoint f18784p;

    public X9ECPoint(AbstractC5817ECCurve abstractC5817ECCurve, ASN1OctetString aSN1OctetString) {
        this(abstractC5817ECCurve, aSN1OctetString.getOctets());
    }

    public synchronized AbstractC5820ECPoint getPoint() {
        try {
            if (this.f18784p == null) {
                this.f18784p = this.f18783c.decodePoint(this.encoding.getOctets()).normalize();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18784p;
    }

    public byte[] getPointEncoding() {
        return C6238Arrays.m18231clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        byte b = octets[0];
        return b == 2 || b == 3;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }

    public X9ECPoint(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        this.f18783c = abstractC5817ECCurve;
        this.encoding = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public X9ECPoint(AbstractC5820ECPoint abstractC5820ECPoint, boolean z) {
        this.f18784p = abstractC5820ECPoint.normalize();
        this.encoding = new DEROctetString(abstractC5820ECPoint.getEncoded(z));
    }
}
