package org.bouncycastle.p133asn1.p134anssi;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes.dex */
public class ANSSINamedCurves {
    static X9ECParametersHolder FRP256v1 = new X9ECParametersHolder() { // from class: org.bouncycastle.asn1.anssi.ANSSINamedCurves.1
        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public AbstractC5817ECCurve createCurve() {
            return ANSSINamedCurves.configureCurve(new AbstractC5817ECCurve.Fp(ANSSINamedCurves.m14480fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03"), ANSSINamedCurves.m14480fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00"), ANSSINamedCurves.m14480fromHex("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F"), ANSSINamedCurves.m14480fromHex("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1"), BigInteger.valueOf(1L), true));
        }

        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public X9ECParameters createParameters() {
            AbstractC5817ECCurve abstractC5817ECCurveCreateCurve = createCurve();
            return new X9ECParameters(abstractC5817ECCurveCreateCurve, ANSSINamedCurves.configureBasepoint(abstractC5817ECCurveCreateCurve, "04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB"), abstractC5817ECCurveCreateCurve.getOrder(), abstractC5817ECCurveCreateCurve.getCofactor(), null);
        }
    };

    /* renamed from: objIds */
    static final Hashtable f18012objIds = new Hashtable();

    /* renamed from: curves */
    static final Hashtable f18010curves = new Hashtable();

    /* renamed from: names */
    static final Hashtable f18011names = new Hashtable();

    static {
        defineCurve("FRP256v1", ANSSIObjectIdentifiers.FRP256v1, FRP256v1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X9ECPoint configureBasepoint(AbstractC5817ECCurve abstractC5817ECCurve, String str) {
        X9ECPoint x9ECPoint = new X9ECPoint(abstractC5817ECCurve, C6255Hex.decodeStrict(str));
        WNafUtil.configureBasepoint(x9ECPoint.getPoint());
        return x9ECPoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AbstractC5817ECCurve configureCurve(AbstractC5817ECCurve abstractC5817ECCurve) {
        return abstractC5817ECCurve;
    }

    public static void defineCurve(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        f18012objIds.put(C6250Strings.toLowerCase(str), aSN1ObjectIdentifier);
        f18011names.put(aSN1ObjectIdentifier, str);
        f18010curves.put(aSN1ObjectIdentifier, x9ECParametersHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fromHex */
    public static BigInteger m14480fromHex(String str) {
        return new BigInteger(1, C6255Hex.decodeStrict(str));
    }

    public static X9ECParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14482getOID = m14482getOID(str);
        if (aSN1ObjectIdentifierM14482getOID == null) {
            return null;
        }
        return getByOID(aSN1ObjectIdentifierM14482getOID);
    }

    public static X9ECParametersHolder getByNameLazy(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14482getOID = m14482getOID(str);
        if (aSN1ObjectIdentifierM14482getOID == null) {
            return null;
        }
        return getByOIDLazy(aSN1ObjectIdentifierM14482getOID);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder byOIDLazy = getByOIDLazy(aSN1ObjectIdentifier);
        if (byOIDLazy == null) {
            return null;
        }
        return byOIDLazy.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (X9ECParametersHolder) f18010curves.get(aSN1ObjectIdentifier);
    }

    /* renamed from: getName */
    public static String m14481getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) f18011names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return f18011names.elements();
    }

    /* renamed from: getOID */
    public static ASN1ObjectIdentifier m14482getOID(String str) {
        return (ASN1ObjectIdentifier) f18012objIds.get(C6250Strings.toLowerCase(str));
    }
}
