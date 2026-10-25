package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KTSParameterSpec extends KEMKDFSpec implements AlgorithmParameterSpec {
    private final AlgorithmParameterSpec parameterSpec;

    /* renamed from: org.bouncycastle.jcajce.spec.KTSParameterSpec$Builder */
    public static final class C5801Builder {
        private final String algorithmName;
        private AlgorithmIdentifier kdfAlgorithm;
        private final int keySizeInBits;
        private byte[] otherInfo;
        private AlgorithmParameterSpec parameterSpec;

        public C5801Builder(String str, int i) {
            this(str, i, null);
        }

        /* renamed from: build */
        public KTSParameterSpec m16204build() {
            return new KTSParameterSpec(this.algorithmName, this.keySizeInBits, this.parameterSpec, this.kdfAlgorithm, this.otherInfo);
        }

        public C5801Builder withKdfAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
            if (algorithmIdentifier == null) {
                throw new NullPointerException("kdfAlgorithm cannot be null");
            }
            this.kdfAlgorithm = algorithmIdentifier;
            return this;
        }

        public C5801Builder withNoKdf() {
            this.kdfAlgorithm = null;
            return this;
        }

        public C5801Builder withParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            this.parameterSpec = algorithmParameterSpec;
            return this;
        }

        public C5801Builder(String str, int i, byte[] bArr) {
            this.algorithmName = str;
            this.keySizeInBits = i;
            this.kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
            this.otherInfo = bArr == null ? new byte[0] : C6238Arrays.m18231clone(bArr);
        }
    }

    public KTSParameterSpec(String str, int i, AlgorithmParameterSpec algorithmParameterSpec, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        super(algorithmIdentifier, bArr, str, i);
        this.parameterSpec = algorithmParameterSpec;
    }

    public AlgorithmParameterSpec getParameterSpec() {
        return this.parameterSpec;
    }
}
