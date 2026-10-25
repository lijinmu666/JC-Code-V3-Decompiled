package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.ECUtils */
/* loaded from: classes2.dex */
class C5518ECUtils {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) {
        return privateKey instanceof BCECPrivateKey ? ((BCECPrivateKey) privateKey).engineGetKeyParameters() : C5618ECUtil.generatePrivateKeyParameter(privateKey);
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) {
        return publicKey instanceof BCECPublicKey ? ((BCECPublicKey) publicKey).engineGetKeyParameters() : C5618ECUtil.generatePublicKeyParameter(publicKey);
    }

    public static X9ECParameters getDomainParametersFromGenSpec(ECGenParameterSpec eCGenParameterSpec, ProviderConfiguration providerConfiguration) {
        return getDomainParametersFromName(eCGenParameterSpec.getName(), providerConfiguration);
    }

    public static X962Parameters getDomainParametersFromName(ECParameterSpec eCParameterSpec, boolean z) {
        if (!(eCParameterSpec instanceof ECNamedCurveSpec)) {
            if (eCParameterSpec == null) {
                return new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
            }
            AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
            return new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, eCParameterSpec.getGenerator()), z), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
        ECNamedCurveSpec eCNamedCurveSpec = (ECNamedCurveSpec) eCParameterSpec;
        ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(eCNamedCurveSpec.m16267getName());
        if (namedCurveOid == null) {
            namedCurveOid = new ASN1ObjectIdentifier(eCNamedCurveSpec.m16267getName());
        }
        return new X962Parameters(namedCurveOid);
    }

    public static X9ECParameters getDomainParametersFromName(String str, ProviderConfiguration providerConfiguration) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int iIndexOf = str.indexOf(32);
        if (iIndexOf > 0) {
            str = str.substring(iIndexOf + 1);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
        if (aSN1ObjectIdentifierTryFromID == null) {
            return C5618ECUtil.getNamedCurveByName(str);
        }
        X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifierTryFromID);
        return (namedCurveByOid != null || providerConfiguration == null) ? namedCurveByOid : (X9ECParameters) providerConfiguration.getAdditionalECParameters().get(aSN1ObjectIdentifierTryFromID);
    }
}
