package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p070jwt.JwtFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import com.p038google.p061crypto.p062tink.p075subtle.RsaSsaPssVerifyJce;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Optional;
import p131o.C4385q0;

/* loaded from: classes.dex */
class JwtRsaSsaPssVerifyKeyManager extends KeyTypeManager<JwtRsaSsaPssPublicKey> {

    /* renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPssVerifyKeyManager$2 */
    public static /* synthetic */ class C04512 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.m3744values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public JwtRsaSsaPssVerifyKeyManager() {
        super(JwtRsaSsaPssPublicKey.class, new PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtRsaSsaPssPublicKey>(JwtPublicKeyVerifyInternal.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssVerifyKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public JwtPublicKeyVerifyInternal getPrimitive(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
                RSAPublicKey rSAPublicKeyCreatePublicKey = JwtRsaSsaPssVerifyKeyManager.createPublicKey(jwtRsaSsaPssPublicKey);
                C0864Enums.HashType hashTypeHashForPssAlgorithm = JwtRsaSsaPssVerifyKeyManager.hashForPssAlgorithm(jwtRsaSsaPssPublicKey.getAlgorithm());
                final RsaSsaPssVerifyJce rsaSsaPssVerifyJce = new RsaSsaPssVerifyJce(rSAPublicKeyCreatePublicKey, hashTypeHashForPssAlgorithm, hashTypeHashForPssAlgorithm, JwtRsaSsaPssVerifyKeyManager.saltLengthForPssAlgorithm(jwtRsaSsaPssPublicKey.getAlgorithm()));
                final String strName = jwtRsaSsaPssPublicKey.getAlgorithm().name();
                final Optional optionalOf = jwtRsaSsaPssPublicKey.hasCustomKid() ? Optional.of(jwtRsaSsaPssPublicKey.getCustomKid().getValue()) : Optional.empty();
                return new JwtPublicKeyVerifyInternal() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssVerifyKeyManager.1.1
                    @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeyVerifyInternal
                    public VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException {
                        JwtFormat.C0437Parts c0437PartsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
                        rsaSsaPssVerifyJce.mo3387verify(c0437PartsSplitSignedCompact.signatureOrMac, c0437PartsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                        C4385q0 json = JsonUtil.parseJson(c0437PartsSplitSignedCompact.f3125header);
                        JwtFormat.validateHeader(strName, optional, optionalOf, json);
                        return jwtValidator.validate(C0454RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), c0437PartsSplitSignedCompact.f3126payload));
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RSAPublicKey createPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
        return (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, jwtRsaSsaPssPublicKey.mo3781getN().toByteArray()), new BigInteger(1, jwtRsaSsaPssPublicKey.mo3780getE().toByteArray())));
    }

    public static final C0864Enums.HashType hashForPssAlgorithm(JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm) throws GeneralSecurityException {
        int i = C04512.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[jwtRsaSsaPssAlgorithm.ordinal()];
        if (i == 1) {
            return C0864Enums.HashType.SHA256;
        }
        if (i == 2) {
            return C0864Enums.HashType.SHA384;
        }
        if (i == 3) {
            return C0864Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtRsaSsaPssAlgorithm.name());
    }

    public static final int saltLengthForPssAlgorithm(JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm) throws GeneralSecurityException {
        int i = C04512.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[jwtRsaSsaPssAlgorithm.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 64;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtRsaSsaPssAlgorithm.name());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";
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
    public JwtRsaSsaPssPublicKey parseKey(ByteString byteString) {
        return JwtRsaSsaPssPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(jwtRsaSsaPssPublicKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, jwtRsaSsaPssPublicKey.mo3781getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, jwtRsaSsaPssPublicKey.mo3780getE().toByteArray()));
    }
}
