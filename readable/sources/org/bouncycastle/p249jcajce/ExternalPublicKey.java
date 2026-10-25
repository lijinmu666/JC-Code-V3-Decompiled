package org.bouncycastle.p249jcajce;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p135bc.ExternalValue;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.p280util.MessageDigestUtils;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ExternalPublicKey implements PublicKey {

    /* renamed from: digest */
    private final byte[] f21357digest;
    private final AlgorithmIdentifier digestAlg;
    private final GeneralName location;

    public ExternalPublicKey(PublicKey publicKey, GeneralName generalName, MessageDigest messageDigest) {
        this(generalName, MessageDigestUtils.getDigestAlgID(messageDigest.getAlgorithm()), messageDigest.digest(publicKey.getEncoded()));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ExternalKey";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(BCObjectIdentifiers.external_value), new ExternalValue(this.location, this.digestAlg, this.f21357digest)).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public ExternalPublicKey(ExternalValue externalValue) {
        this(externalValue.getLocation(), externalValue.getHashAlg(), externalValue.getHashValue());
    }

    public ExternalPublicKey(GeneralName generalName, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.location = generalName;
        this.digestAlg = algorithmIdentifier;
        this.f21357digest = C6238Arrays.m18231clone(bArr);
    }
}
