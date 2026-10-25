package org.bouncycastle.p249jcajce.p279spec;

import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KEMGenerateSpec extends KEMKDFSpec implements AlgorithmParameterSpec {
    private final PublicKey publicKey;
    private static final byte[] EMPTY_OTHER_INFO = new byte[0];

    /* renamed from: DefKdf */
    private static AlgorithmIdentifier f21927DefKdf = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));

    /* renamed from: org.bouncycastle.jcajce.spec.KEMGenerateSpec$Builder */
    public static final class C5800Builder {
        private final String algorithmName;
        private final int keySizeInBits;
        private final PublicKey publicKey;
        private AlgorithmIdentifier kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
        private byte[] otherInfo = KEMGenerateSpec.EMPTY_OTHER_INFO;

        public C5800Builder(PublicKey publicKey, String str, int i) {
            this.publicKey = publicKey;
            this.algorithmName = str;
            this.keySizeInBits = i;
        }

        /* renamed from: build */
        public KEMGenerateSpec m16203build() {
            return new KEMGenerateSpec(this.publicKey, this.algorithmName, this.keySizeInBits, this.kdfAlgorithm, this.otherInfo);
        }

        public C5800Builder withKdfAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
            this.kdfAlgorithm = algorithmIdentifier;
            return this;
        }

        public C5800Builder withNoKdf() {
            this.kdfAlgorithm = null;
            return this;
        }

        public C5800Builder withOtherInfo(byte[] bArr) {
            this.otherInfo = bArr == null ? KEMGenerateSpec.EMPTY_OTHER_INFO : C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    public KEMGenerateSpec(PublicKey publicKey, String str) {
        this(publicKey, str, 256, f21927DefKdf, EMPTY_OTHER_INFO);
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public KEMGenerateSpec(PublicKey publicKey, String str, int i) {
        this(publicKey, str, i, f21927DefKdf, EMPTY_OTHER_INFO);
    }

    private KEMGenerateSpec(PublicKey publicKey, String str, int i, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        super(algorithmIdentifier, bArr, str, i);
        this.publicKey = publicKey;
    }
}
