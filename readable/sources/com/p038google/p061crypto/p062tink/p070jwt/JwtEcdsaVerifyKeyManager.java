package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p070jwt.JwtFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.EcdsaVerifyJce;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Optional;
import p131o.C4385q0;

/* loaded from: classes.dex */
class JwtEcdsaVerifyKeyManager extends KeyTypeManager<JwtEcdsaPublicKey> {

    /* renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$1 */
    public static /* synthetic */ class C04351 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;

        static {
            int[] iArr = new int[JwtEcdsaAlgorithm.m3676values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr;
            try {
                iArr[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class JwtPublicKeyVerifyFactory extends PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtEcdsaPublicKey> {
        public JwtPublicKeyVerifyFactory() {
            super(JwtPublicKeyVerifyInternal.class);
        }

        @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
        public JwtPublicKeyVerifyInternal getPrimitive(JwtEcdsaPublicKey jwtEcdsaPublicKey) {
            final EcdsaVerifyJce ecdsaVerifyJce = new EcdsaVerifyJce(EllipticCurves.getEcPublicKey(JwtEcdsaVerifyKeyManager.getCurve(jwtEcdsaPublicKey.getAlgorithm()), jwtEcdsaPublicKey.mo3684getX().toByteArray(), jwtEcdsaPublicKey.mo3685getY().toByteArray()), JwtEcdsaVerifyKeyManager.hashForEcdsaAlgorithm(jwtEcdsaPublicKey.getAlgorithm()), EllipticCurves.EcdsaEncoding.IEEE_P1363);
            final String strName = jwtEcdsaPublicKey.getAlgorithm().name();
            final Optional optionalOf = jwtEcdsaPublicKey.hasCustomKid() ? Optional.of(jwtEcdsaPublicKey.getCustomKid().getValue()) : Optional.empty();
            return new JwtPublicKeyVerifyInternal() { // from class: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager.JwtPublicKeyVerifyFactory.1
                @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeyVerifyInternal
                public VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException {
                    JwtFormat.C0437Parts c0437PartsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
                    ecdsaVerifyJce.mo3387verify(c0437PartsSplitSignedCompact.signatureOrMac, c0437PartsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                    C4385q0 json = JsonUtil.parseJson(c0437PartsSplitSignedCompact.f3125header);
                    JwtFormat.validateHeader(strName, optional, optionalOf, json);
                    return jwtValidator.validate(C0454RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), c0437PartsSplitSignedCompact.f3126payload));
                }
            };
        }
    }

    public JwtEcdsaVerifyKeyManager() {
        super(JwtEcdsaPublicKey.class, new JwtPublicKeyVerifyFactory());
    }

    public static final EllipticCurves.CurveType getCurve(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        int i = C04351.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    public static C0864Enums.HashType hashForEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        int i = C04351.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i == 1) {
            return C0864Enums.HashType.SHA256;
        }
        if (i == 2) {
            return C0864Enums.HashType.SHA384;
        }
        if (i == 3) {
            return C0864Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    public static final void validateEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) throws GeneralSecurityException {
        hashForEcdsaAlgorithm(jwtEcdsaAlgorithm);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public JwtEcdsaPublicKey parseKey(ByteString byteString) {
        return JwtEcdsaPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(jwtEcdsaPublicKey.getVersion(), getVersion());
        validateEcdsaAlgorithm(jwtEcdsaPublicKey.getAlgorithm());
    }
}
