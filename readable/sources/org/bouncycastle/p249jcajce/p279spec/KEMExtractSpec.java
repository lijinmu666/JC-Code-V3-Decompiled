package org.bouncycastle.p249jcajce.p279spec;

import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KEMExtractSpec extends KEMKDFSpec implements AlgorithmParameterSpec {
    private final byte[] encapsulation;
    private final PrivateKey privateKey;
    private static final byte[] EMPTY_OTHER_INFO = new byte[0];

    /* renamed from: DefKdf */
    private static AlgorithmIdentifier f21926DefKdf = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));

    /* renamed from: org.bouncycastle.jcajce.spec.KEMExtractSpec$Builder */
    public static final class C5798Builder {
        private final String algorithmName;
        private final byte[] encapsulation;
        private final int keySizeInBits;
        private final PrivateKey privateKey;
        private AlgorithmIdentifier kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
        private byte[] otherInfo = KEMExtractSpec.EMPTY_OTHER_INFO;

        public C5798Builder(PrivateKey privateKey, byte[] bArr, String str, int i) {
            this.privateKey = privateKey;
            this.encapsulation = C6238Arrays.m18231clone(bArr);
            this.algorithmName = str;
            this.keySizeInBits = i;
        }

        /* renamed from: build */
        public KEMExtractSpec m16202build() {
            return new KEMExtractSpec(this.privateKey, this.encapsulation, this.algorithmName, this.keySizeInBits, this.kdfAlgorithm, this.otherInfo);
        }

        public C5798Builder withKdfAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
            this.kdfAlgorithm = algorithmIdentifier;
            return this;
        }

        public C5798Builder withNoKdf() {
            this.kdfAlgorithm = null;
            return this;
        }

        public C5798Builder withOtherInfo(byte[] bArr) {
            this.otherInfo = bArr == null ? KEMExtractSpec.EMPTY_OTHER_INFO : C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    public KEMExtractSpec(PrivateKey privateKey, byte[] bArr, String str) {
        this(privateKey, bArr, str, 256);
    }

    public byte[] getEncapsulation() {
        return C6238Arrays.m18231clone(this.encapsulation);
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public KEMExtractSpec(PrivateKey privateKey, byte[] bArr, String str, int i) {
        this(privateKey, bArr, str, i, f21926DefKdf, EMPTY_OTHER_INFO);
    }

    private KEMExtractSpec(PrivateKey privateKey, byte[] bArr, String str, int i, AlgorithmIdentifier algorithmIdentifier, byte[] bArr2) {
        super(algorithmIdentifier, bArr2, str, i);
        this.privateKey = privateKey;
        this.encapsulation = C6238Arrays.m18231clone(bArr);
    }
}
