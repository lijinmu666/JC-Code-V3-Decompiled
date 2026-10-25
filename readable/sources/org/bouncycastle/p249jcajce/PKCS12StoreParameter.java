package org.bouncycastle.p249jcajce;

import java.io.OutputStream;
import java.security.KeyStore;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    private final boolean forDEREncoding;
    private final AlgorithmIdentifier macAlgorithm;

    /* renamed from: out */
    private final OutputStream f21363out;
    private final boolean overwriteFriendlyName;
    private final KeyStore.ProtectionParameter protectionParameter;
    private final boolean useISO8859d1ForDecryption;

    /* renamed from: org.bouncycastle.jcajce.PKCS12StoreParameter$Builder */
    public static class C5475Builder {
        private boolean forDEREncoding;
        private AlgorithmIdentifier macAlgorithm;

        /* renamed from: out */
        private final OutputStream f21364out;
        private boolean overwriteFriendlyName;
        private final KeyStore.ProtectionParameter protectionParameter;
        private boolean useISO8859d1ForDecryption;

        private C5475Builder(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.forDEREncoding = true;
            this.overwriteFriendlyName = true;
            this.useISO8859d1ForDecryption = false;
            this.macAlgorithm = new AlgorithmIdentifier(OIWObjectIdentifiers.f21282idSHA1, C5103DERNull.INSTANCE);
            this.f21364out = outputStream;
            this.protectionParameter = protectionParameter;
        }

        /* renamed from: build */
        public PKCS12StoreParameter m16067build() {
            return new PKCS12StoreParameter(this.f21364out, this.protectionParameter, this.forDEREncoding, this.overwriteFriendlyName, this.macAlgorithm, this.useISO8859d1ForDecryption);
        }

        public C5475Builder setDEREncoding(boolean z) {
            this.forDEREncoding = z;
            return this;
        }

        public C5475Builder setMacAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
            this.macAlgorithm = algorithmIdentifier;
            return this;
        }

        public C5475Builder setOverwriteFriendlyName(boolean z) {
            this.overwriteFriendlyName = z;
            return this;
        }

        public C5475Builder setUseISO8859d1ForDecryption(boolean z) {
            this.useISO8859d1ForDecryption = z;
            return this;
        }
    }

    public static class PBMAC1WithPBKDF2Builder {
        private int iterationCount = 16384;

        /* renamed from: salt */
        private byte[] f21367salt = null;
        private int keySizeinBits = 256;

        /* renamed from: prf */
        private ASN1ObjectIdentifier f21366prf = PKCSObjectIdentifiers.id_hmacWithSHA256;

        /* renamed from: mac */
        private ASN1ObjectIdentifier f21365mac = PKCSObjectIdentifiers.id_hmacWithSHA512;

        /* renamed from: build */
        public AlgorithmIdentifier m16068build() {
            if (this.f21367salt == null) {
                throw new IllegalStateException("salt must be non-null");
            }
            return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBMAC1, new PBMAC1Params(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(this.f21367salt, this.iterationCount, this.keySizeinBits, new AlgorithmIdentifier(this.f21366prf))), new AlgorithmIdentifier(this.f21365mac)));
        }

        public PBMAC1WithPBKDF2Builder setIterationCount(int i) {
            this.iterationCount = i;
            return this;
        }

        public PBMAC1WithPBKDF2Builder setKeySize(int i) {
            this.keySizeinBits = i;
            return this;
        }

        /* renamed from: setMac */
        public PBMAC1WithPBKDF2Builder m16069setMac(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            this.f21365mac = aSN1ObjectIdentifier;
            return this;
        }

        /* renamed from: setPrf */
        public PBMAC1WithPBKDF2Builder m16070setPrf(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            this.f21366prf = aSN1ObjectIdentifier;
            return this;
        }

        /* renamed from: setSalt */
        public PBMAC1WithPBKDF2Builder m16071setSalt(byte[] bArr) {
            this.f21367salt = C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(outputStream, protectionParameter, false, true);
    }

    /* renamed from: builder */
    public static C5475Builder m16065builder(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        return new C5475Builder(outputStream, protectionParameter);
    }

    public static PBMAC1WithPBKDF2Builder pbmac1WithPBKDF2Builder() {
        return new PBMAC1WithPBKDF2Builder();
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public OutputStream getOutputStream() {
        return this.f21363out;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public boolean isForDEREncoding() {
        return this.forDEREncoding;
    }

    public boolean isOverwriteFriendlyName() {
        return this.overwriteFriendlyName;
    }

    public boolean useISO8859d1ForDecryption() {
        return this.useISO8859d1ForDecryption;
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z) {
        this(outputStream, protectionParameter, z, true);
    }

    /* renamed from: builder */
    public static C5475Builder m16066builder(OutputStream outputStream, char[] cArr) {
        return m16065builder(outputStream, new KeyStore.PasswordProtection(cArr));
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z, boolean z2) {
        this(outputStream, protectionParameter, z, z2, new AlgorithmIdentifier(OIWObjectIdentifiers.f21282idSHA1, C5103DERNull.INSTANCE), false);
    }

    private PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z, boolean z2, AlgorithmIdentifier algorithmIdentifier, boolean z3) {
        this.f21363out = outputStream;
        this.protectionParameter = protectionParameter;
        this.forDEREncoding = z;
        this.overwriteFriendlyName = z2;
        this.macAlgorithm = algorithmIdentifier;
        this.useISO8859d1ForDecryption = z3;
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr) {
        this(outputStream, cArr, false);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr, boolean z) {
        this(outputStream, (KeyStore.ProtectionParameter) new KeyStore.PasswordProtection(cArr), z, true);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr, boolean z, boolean z2) {
        this(outputStream, new KeyStore.PasswordProtection(cArr), z, z2);
    }
}
