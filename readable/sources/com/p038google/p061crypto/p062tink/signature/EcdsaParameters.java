package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.internal.EllipticCurvesUtil;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Objects;
import org.bouncycastle.p133asn1.ASN1Encoding;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class EcdsaParameters extends SignatureParameters {
    private final CurveType curveType;
    private final HashType hashType;
    private final SignatureEncoding signatureEncoding;

    /* renamed from: variant */
    private final C0815Variant f3847variant;

    /* renamed from: com.google.crypto.tink.signature.EcdsaParameters$Builder */
    public static final class C0814Builder {
        private CurveType curveType;
        private HashType hashType;
        private SignatureEncoding signatureEncoding;

        /* renamed from: variant */
        private C0815Variant f3848variant;

        /* renamed from: build */
        public EcdsaParameters m4196build() throws GeneralSecurityException {
            SignatureEncoding signatureEncoding = this.signatureEncoding;
            if (signatureEncoding == null) {
                throw new GeneralSecurityException("signature encoding is not set");
            }
            CurveType curveType = this.curveType;
            if (curveType == null) {
                throw new GeneralSecurityException("EC curve type is not set");
            }
            HashType hashType = this.hashType;
            if (hashType == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            C0815Variant c0815Variant = this.f3848variant;
            if (c0815Variant == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (curveType == CurveType.NIST_P256 && hashType != HashType.f3851SHA256) {
                throw new GeneralSecurityException("NIST_P256 requires SHA256");
            }
            if (curveType == CurveType.NIST_P384 && hashType != HashType.f3852SHA384 && hashType != HashType.f3853SHA512) {
                throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
            }
            if (curveType != CurveType.NIST_P521 || hashType == HashType.f3853SHA512) {
                return new EcdsaParameters(signatureEncoding, curveType, hashType, c0815Variant);
            }
            throw new GeneralSecurityException("NIST_P521 requires SHA512");
        }

        public C0814Builder setCurveType(CurveType curveType) {
            this.curveType = curveType;
            return this;
        }

        public C0814Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public C0814Builder setSignatureEncoding(SignatureEncoding signatureEncoding) {
            this.signatureEncoding = signatureEncoding;
            return this;
        }

        public C0814Builder setVariant(C0815Variant c0815Variant) {
            this.f3848variant = c0815Variant;
            return this;
        }

        private C0814Builder() {
            this.signatureEncoding = null;
            this.curveType = null;
            this.hashType = null;
            this.f3848variant = C0815Variant.NO_PREFIX;
        }
    }

    public static final class CurveType {
        public static final CurveType NIST_P256 = new CurveType("NIST_P256", EllipticCurvesUtil.NIST_P256_PARAMS);
        public static final CurveType NIST_P384 = new CurveType("NIST_P384", EllipticCurvesUtil.NIST_P384_PARAMS);
        public static final CurveType NIST_P521 = new CurveType("NIST_P521", EllipticCurvesUtil.NIST_P521_PARAMS);

        /* renamed from: name */
        private final String f3849name;

        /* renamed from: spec */
        private final ECParameterSpec f3850spec;

        private CurveType(String str, ECParameterSpec eCParameterSpec) {
            this.f3849name = str;
            this.f3850spec = eCParameterSpec;
        }

        public static CurveType fromParameterSpec(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
            CurveType curveType = NIST_P256;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType.toParameterSpec())) {
                return curveType;
            }
            CurveType curveType2 = NIST_P384;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType2.toParameterSpec())) {
                return curveType2;
            }
            CurveType curveType3 = NIST_P521;
            if (EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, curveType3.toParameterSpec())) {
                return curveType3;
            }
            throw new GeneralSecurityException("unknown ECParameterSpec");
        }

        public ECParameterSpec toParameterSpec() {
            return this.f3850spec;
        }

        public String toString() {
            return this.f3849name;
        }
    }

    public static final class HashType {

        /* renamed from: SHA256 */
        public static final HashType f3851SHA256 = new HashType("SHA256");

        /* renamed from: SHA384 */
        public static final HashType f3852SHA384 = new HashType("SHA384");

        /* renamed from: SHA512 */
        public static final HashType f3853SHA512 = new HashType("SHA512");

        /* renamed from: name */
        private final String f3854name;

        private HashType(String str) {
            this.f3854name = str;
        }

        public String toString() {
            return this.f3854name;
        }
    }

    public static final class SignatureEncoding {

        /* renamed from: name */
        private final String f3856name;
        public static final SignatureEncoding IEEE_P1363 = new SignatureEncoding("IEEE_P1363");

        /* renamed from: DER */
        public static final SignatureEncoding f3855DER = new SignatureEncoding(ASN1Encoding.f17902DER);

        private SignatureEncoding(String str) {
            this.f3856name = str;
        }

        public String toString() {
            return this.f3856name;
        }
    }

    /* renamed from: com.google.crypto.tink.signature.EcdsaParameters$Variant */
    public static final class C0815Variant {

        /* renamed from: name */
        private final String f3860name;

        /* renamed from: TINK */
        public static final C0815Variant f3859TINK = new C0815Variant("TINK");

        /* renamed from: CRUNCHY */
        public static final C0815Variant f3857CRUNCHY = new C0815Variant("CRUNCHY");

        /* renamed from: LEGACY */
        public static final C0815Variant f3858LEGACY = new C0815Variant("LEGACY");
        public static final C0815Variant NO_PREFIX = new C0815Variant("NO_PREFIX");

        private C0815Variant(String str) {
            this.f3860name = str;
        }

        public String toString() {
            return this.f3860name;
        }
    }

    /* renamed from: builder */
    public static C0814Builder m4194builder() {
        return new C0814Builder();
    }

    /* renamed from: equals */
    public boolean m4195equals(Object obj) {
        if (!(obj instanceof EcdsaParameters)) {
            return false;
        }
        EcdsaParameters ecdsaParameters = (EcdsaParameters) obj;
        return ecdsaParameters.getSignatureEncoding() == getSignatureEncoding() && ecdsaParameters.getCurveType() == getCurveType() && ecdsaParameters.getHashType() == getHashType() && ecdsaParameters.getVariant() == getVariant();
    }

    public CurveType getCurveType() {
        return this.curveType;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public SignatureEncoding getSignatureEncoding() {
        return this.signatureEncoding;
    }

    public C0815Variant getVariant() {
        return this.f3847variant;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return this.f3847variant != C0815Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(this.signatureEncoding, this.curveType, this.hashType, this.f3847variant);
    }

    public String toString() {
        return "ECDSA Parameters (variant: " + this.f3847variant + ", hashType: " + this.hashType + ", encoding: " + this.signatureEncoding + ", curve: " + this.curveType + ")";
    }

    private EcdsaParameters(SignatureEncoding signatureEncoding, CurveType curveType, HashType hashType, C0815Variant c0815Variant) {
        this.signatureEncoding = signatureEncoding;
        this.curveType = curveType;
        this.hashType = hashType;
        this.f3847variant = c0815Variant;
    }
}
