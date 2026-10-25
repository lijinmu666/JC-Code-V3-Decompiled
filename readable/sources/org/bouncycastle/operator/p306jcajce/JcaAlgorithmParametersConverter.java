package org.bouncycastle.operator.p306jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSAESOAEPparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class JcaAlgorithmParametersConverter {
    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        try {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier, ASN1Primitive.fromByteArray(algorithmParameters.getEncoded()));
        } catch (IOException e) {
            throw new InvalidAlgorithmParameterException("unable to encode parameters object: " + e.getMessage());
        }
    }

    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new InvalidAlgorithmParameterException("unknown parameter spec passed.");
        }
        OAEPParameterSpec oAEPParameterSpec = OAEPParameterSpec.DEFAULT;
        if (algorithmParameterSpec.equals(oAEPParameterSpec)) {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier, new RSAESOAEPparams(RSAESOAEPparams.DEFAULT_HASH_ALGORITHM, RSAESOAEPparams.DEFAULT_MASK_GEN_FUNCTION, RSAESOAEPparams.DEFAULT_P_SOURCE_ALGORITHM));
        }
        OAEPParameterSpec oAEPParameterSpec2 = (OAEPParameterSpec) algorithmParameterSpec;
        PSource pSource = oAEPParameterSpec2.getPSource();
        if (!oAEPParameterSpec2.getMGFAlgorithm().equals(oAEPParameterSpec.getMGFAlgorithm())) {
            throw new InvalidAlgorithmParameterException("only " + oAEPParameterSpec.getMGFAlgorithm() + " mask generator supported.");
        }
        AlgorithmIdentifier algorithmIdentifierMo17380find = new DefaultDigestAlgorithmIdentifierFinder().mo17380find(oAEPParameterSpec2.getDigestAlgorithm());
        if (algorithmIdentifierMo17380find.getParameters() == null) {
            algorithmIdentifierMo17380find = new AlgorithmIdentifier(algorithmIdentifierMo17380find.getAlgorithm(), C5103DERNull.INSTANCE);
        }
        AlgorithmIdentifier algorithmIdentifierMo17380find2 = new DefaultDigestAlgorithmIdentifierFinder().mo17380find(((MGF1ParameterSpec) oAEPParameterSpec2.getMGFParameters()).getDigestAlgorithm());
        if (algorithmIdentifierMo17380find2.getParameters() == null) {
            algorithmIdentifierMo17380find2 = new AlgorithmIdentifier(algorithmIdentifierMo17380find2.getAlgorithm(), C5103DERNull.INSTANCE);
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, new RSAESOAEPparams(algorithmIdentifierMo17380find, new AlgorithmIdentifier(PKCSObjectIdentifiers.f18498id_mgf1, algorithmIdentifierMo17380find2), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(((PSource.PSpecified) pSource).getValue()))));
    }
}
