package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECNamedCurveParameterSpec extends ECParameterSpec {

    /* renamed from: name */
    private String f22056name;

    public ECNamedCurveParameterSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        super(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger);
        this.f22056name = str;
    }

    /* renamed from: getName */
    public String m16266getName() {
        return this.f22056name;
    }

    public ECNamedCurveParameterSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, bigInteger2);
        this.f22056name = str;
    }

    public ECNamedCurveParameterSpec(String str, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, bigInteger2, bArr);
        this.f22056name = str;
    }
}
