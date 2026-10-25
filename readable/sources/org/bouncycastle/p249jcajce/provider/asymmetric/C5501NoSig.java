package org.bouncycastle.p249jcajce.provider.asymmetric;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureSpi;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.NoSig */
/* loaded from: classes2.dex */
public class C5501NoSig {

    /* renamed from: PREFIX */
    private static final String f21401PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.NoSig$";

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.NoSig$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("Signature." + X509ObjectIdentifiers.id_alg_noSignature, "org.bouncycastle.jcajce.provider.asymmetric.NoSig$SigSpi");
            configurableProvider.addAlgorithm("Signature." + X509ObjectIdentifiers.id_alg_unsigned, "org.bouncycastle.jcajce.provider.asymmetric.NoSig$SigSpi");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.NoSig$SigSpi */
    public static class SigSpi extends SignatureSpi {
        @Override // java.security.SignatureSpi
        public Object engineGetParameter(String str) {
            return null;
        }

        @Override // java.security.SignatureSpi
        public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            throw new InvalidKeyException("attempt to pass private key to NoSig");
        }

        @Override // java.security.SignatureSpi
        public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            throw new InvalidKeyException("attempt to pass public key to NoSig");
        }

        @Override // java.security.SignatureSpi
        public void engineSetParameter(String str, Object obj) {
        }

        @Override // java.security.SignatureSpi
        public byte[] engineSign() {
            return new byte[0];
        }

        @Override // java.security.SignatureSpi
        public void engineUpdate(byte b) {
        }

        @Override // java.security.SignatureSpi
        public boolean engineVerify(byte[] bArr) {
            return false;
        }

        @Override // java.security.SignatureSpi
        public void engineUpdate(byte[] bArr, int i, int i2) {
        }
    }
}
