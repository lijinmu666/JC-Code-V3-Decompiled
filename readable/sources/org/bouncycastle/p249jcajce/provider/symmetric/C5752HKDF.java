package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.p279spec.HKDFParameterSpec;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BCPBEKey;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF */
/* loaded from: classes2.dex */
public class C5752HKDF {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF$HKDFBase */
    public static class HKDFBase extends BaseSecretKeyFactory {

        /* renamed from: algName */
        protected String f21802algName;

        /* renamed from: hkdf */
        protected HKDFBytesGenerator f21803hkdf;

        public HKDFBase(String str, InterfaceC5277Digest interfaceC5277Digest, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            super(str, aSN1ObjectIdentifier);
            this.f21802algName = str;
            this.f21803hkdf = new HKDFBytesGenerator(interfaceC5277Digest);
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof HKDFParameterSpec)) {
                throw new InvalidKeySpecException("invalid KeySpec: expected HKDFParameterSpec, but got " + keySpec.getClass().getName());
            }
            HKDFParameterSpec hKDFParameterSpec = (HKDFParameterSpec) keySpec;
            int outputLength = hKDFParameterSpec.getOutputLength();
            this.f21803hkdf.mo14966init(new HKDFParameters(hKDFParameterSpec.m16198getIKM(), hKDFParameterSpec.m16200getSalt(), hKDFParameterSpec.m16199getInfo()));
            byte[] bArr = new byte[outputLength];
            this.f21803hkdf.generateBytes(bArr, 0, outputLength);
            return new BCPBEKey(this.f21802algName, new KeyParameter(bArr));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF$HKDFwithSHA256 */
    public static class HKDFwithSHA256 extends HKDFBase {
        public HKDFwithSHA256() {
            super("HKDF-SHA256", new SHA256Digest(), PKCSObjectIdentifiers.id_alg_hkdf_with_sha256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF$HKDFwithSHA384 */
    public static class HKDFwithSHA384 extends HKDFBase {
        public HKDFwithSHA384() {
            super("HKDF-SHA384", new SHA384Digest(), PKCSObjectIdentifiers.id_alg_hkdf_with_sha384);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF$HKDFwithSHA512 */
    public static class HKDFwithSHA512 extends HKDFBase {
        public HKDFwithSHA512() {
            super("HKDF-SHA512", new SHA512Digest(), PKCSObjectIdentifiers.id_alg_hkdf_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.HKDF$Mappings */
    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21804PREFIX = C5752HKDF.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21804PREFIX;
            sb.append(str);
            sb.append("$HKDFwithSHA256");
            configurableProvider.addAlgorithm("SecretKeyFactory.HKDF-SHA256", sb.toString());
            configurableProvider.addAlgorithm("SecretKeyFactory.HKDF-SHA384", str + "$HKDFwithSHA384");
            configurableProvider.addAlgorithm("SecretKeyFactory.HKDF-SHA512", str + "$HKDFwithSHA512");
        }
    }

    private C5752HKDF() {
    }
}
