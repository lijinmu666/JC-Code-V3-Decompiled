package org.bouncycastle.p133asn1.p148gm;

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

/* loaded from: classes2.dex */
public class GMNamedCurves {
    static X9ECParametersHolder sm2p256v1 = new X9ECParametersHolder() { // from class: org.bouncycastle.asn1.gm.GMNamedCurves.1
        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public AbstractC5817ECCurve createCurve() {
            return GMNamedCurves.configureCurve(new AbstractC5817ECCurve.Fp(GMNamedCurves.m14611fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"), GMNamedCurves.m14611fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC"), GMNamedCurves.m14611fromHex("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93"), GMNamedCurves.m14611fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"), BigInteger.valueOf(1L), true));
        }

        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public X9ECParameters createParameters() {
            AbstractC5817ECCurve curve = getCurve();
            return new X9ECParameters(curve, GMNamedCurves.configureBasepoint(curve, "0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"), curve.getOrder(), curve.getCofactor(), null);
        }
    };
    static X9ECParametersHolder wapip192v1 = new X9ECParametersHolder() { // from class: org.bouncycastle.asn1.gm.GMNamedCurves.2
        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public AbstractC5817ECCurve createCurve() {
            return GMNamedCurves.configureCurve(new AbstractC5817ECCurve.Fp(GMNamedCurves.m14611fromHex("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F"), GMNamedCurves.m14611fromHex("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985"), GMNamedCurves.m14611fromHex("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1"), GMNamedCurves.m14611fromHex("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677"), BigInteger.valueOf(1L), true));
        }

        @Override // org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder
        public X9ECParameters createParameters() {
            AbstractC5817ECCurve curve = getCurve();
            return new X9ECParameters(curve, GMNamedCurves.configureBasepoint(curve, "044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2"), curve.getOrder(), curve.getCofactor(), null);
        }
    };

    /* renamed from: objIds */
    static final Hashtable f18382objIds = new Hashtable();

    /* renamed from: curves */
    static final Hashtable f18380curves = new Hashtable();

    /* renamed from: names */
    static final Hashtable f18381names = new Hashtable();

    static {
        defineCurve("wapip192v1", GMObjectIdentifiers.wapip192v1, wapip192v1);
        defineCurve("wapi192v1", GMObjectIdentifiers.wapi192v1, wapip192v1);
        defineCurve("sm2p256v1", GMObjectIdentifiers.sm2p256v1, sm2p256v1);
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
        f18382objIds.put(C6250Strings.toLowerCase(str), aSN1ObjectIdentifier);
        f18381names.put(aSN1ObjectIdentifier, str);
        f18380curves.put(aSN1ObjectIdentifier, x9ECParametersHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fromHex */
    public static BigInteger m14611fromHex(String str) {
        return new BigInteger(1, C6255Hex.decodeStrict(str));
    }

    public static X9ECParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14613getOID = m14613getOID(str);
        if (aSN1ObjectIdentifierM14613getOID == null) {
            return null;
        }
        return getByOID(aSN1ObjectIdentifierM14613getOID);
    }

    public static X9ECParametersHolder getByNameLazy(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14613getOID = m14613getOID(str);
        if (aSN1ObjectIdentifierM14613getOID == null) {
            return null;
        }
        return getByOIDLazy(aSN1ObjectIdentifierM14613getOID);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder byOIDLazy = getByOIDLazy(aSN1ObjectIdentifier);
        if (byOIDLazy == null) {
            return null;
        }
        return byOIDLazy.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (X9ECParametersHolder) f18380curves.get(aSN1ObjectIdentifier);
    }

    /* renamed from: getName */
    public static String m14612getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) f18381names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return f18381names.elements();
    }

    /* renamed from: getOID */
    public static ASN1ObjectIdentifier m14613getOID(String str) {
        return (ASN1ObjectIdentifier) f18382objIds.get(C6250Strings.toLowerCase(str));
    }
}
