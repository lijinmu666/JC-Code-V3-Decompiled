package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssParams;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import com.p038google.p061crypto.p062tink.p075subtle.RsaSsaPssVerifyJce;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* loaded from: classes.dex */
class RsaSsaPssVerifyKeyManager extends KeyTypeManager<RsaSsaPssPublicKey> {
    public RsaSsaPssVerifyKeyManager() {
        super(RsaSsaPssPublicKey.class, new PrimitiveFactory<PublicKeyVerify, RsaSsaPssPublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.RsaSsaPssVerifyKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeyVerify getPrimitive(RsaSsaPssPublicKey rsaSsaPssPublicKey) {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPssPublicKey.mo3897getN().toByteArray()), new BigInteger(1, rsaSsaPssPublicKey.mo3896getE().toByteArray())));
                RsaSsaPssParams params = rsaSsaPssPublicKey.getParams();
                return new RsaSsaPssVerifyJce(rSAPublicKey, C0839SigUtil.toHashType(params.getSigHash()), C0839SigUtil.toHashType(params.getMgf1Hash()), params.getSaltLength());
            }
        });
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey";
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
    public RsaSsaPssPublicKey parseKey(ByteString byteString) {
        return RsaSsaPssPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(rsaSsaPssPublicKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, rsaSsaPssPublicKey.mo3897getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, rsaSsaPssPublicKey.mo3896getE().toByteArray()));
        C0839SigUtil.validateRsaSsaPssParams(rsaSsaPssPublicKey.getParams());
    }
}
