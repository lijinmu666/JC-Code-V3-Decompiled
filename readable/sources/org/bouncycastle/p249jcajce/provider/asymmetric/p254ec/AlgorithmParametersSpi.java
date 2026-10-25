package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    private String curveName;
    private ECParameterSpec ecParameterSpec;

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        return engineGetEncoded("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.ecParameterSpec;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.curveName;
            if (str != null) {
                ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(str);
                return namedCurveOid != null ? new ECGenParameterSpec(namedCurveOid.m14433getId()) : new ECGenParameterSpec(this.curveName);
            }
            ASN1ObjectIdentifier namedCurveOid2 = C5618ECUtil.getNamedCurveOid(C5617EC5Util.convertSpec(this.ecParameterSpec));
            if (namedCurveOid2 != null) {
                return new ECGenParameterSpec(namedCurveOid2.m14433getId());
            }
        }
        throw new InvalidParameterSpecException("EC AlgorithmParameters cannot convert to " + cls.getName());
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof ECGenParameterSpec)) {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.curveName = algorithmParameterSpec instanceof ECNamedCurveSpec ? ((ECNamedCurveSpec) algorithmParameterSpec).m16267getName() : null;
                this.ecParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                return;
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }
        ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
        X9ECParameters domainParametersFromGenSpec = C5518ECUtils.getDomainParametersFromGenSpec(eCGenParameterSpec, BouncyCastleProvider.CONFIGURATION);
        if (domainParametersFromGenSpec != null) {
            this.curveName = eCGenParameterSpec.getName();
            ECParameterSpec eCParameterSpecConvertToSpec = C5617EC5Util.convertToSpec(domainParametersFromGenSpec);
            this.ecParameterSpec = new ECNamedCurveSpec(this.curveName, eCParameterSpecConvertToSpec.getCurve(), eCParameterSpecConvertToSpec.getGenerator(), eCParameterSpecConvertToSpec.getOrder(), BigInteger.valueOf(eCParameterSpecConvertToSpec.getCofactor()));
        } else {
            throw new InvalidParameterSpecException("EC curve name not recognized: " + eCGenParameterSpec.getName());
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "EC Parameters";
    }

    public boolean isASN1FormatString(String str) {
        return str == null || str.equals("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        X962Parameters x962Parameters;
        if (!isASN1FormatString(str)) {
            throw new IOException("Unknown parameters format in AlgorithmParameters object: " + str);
        }
        ECParameterSpec eCParameterSpec = this.ecParameterSpec;
        if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
        } else {
            String str2 = this.curveName;
            if (str2 != null) {
                x962Parameters = new X962Parameters(C5618ECUtil.getNamedCurveOid(str2));
            } else {
                org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpecConvertSpec = C5617EC5Util.convertSpec(eCParameterSpec);
                x962Parameters = new X962Parameters(new X9ECParameters(eCParameterSpecConvertSpec.getCurve(), new X9ECPoint(eCParameterSpecConvertSpec.m16269getG(), false), eCParameterSpecConvertSpec.m16271getN(), eCParameterSpecConvertSpec.m16270getH(), eCParameterSpecConvertSpec.m16272getSeed()));
            }
        }
        return x962Parameters.getEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (!isASN1FormatString(str)) {
            throw new IOException("Unknown encoded parameters format in AlgorithmParameters object: " + str);
        }
        X962Parameters x962Parameters = X962Parameters.getInstance(bArr);
        AbstractC5817ECCurve curve = C5617EC5Util.getCurve(BouncyCastleProvider.CONFIGURATION, x962Parameters);
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
            String strM14727getName = ECNamedCurveTable.m14727getName(aSN1ObjectIdentifier);
            this.curveName = strM14727getName;
            if (strM14727getName == null) {
                this.curveName = aSN1ObjectIdentifier.m14433getId();
            }
        }
        this.ecParameterSpec = C5617EC5Util.convertToSpec(x962Parameters, curve);
    }
}
