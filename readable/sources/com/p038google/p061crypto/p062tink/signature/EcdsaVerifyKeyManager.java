package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EcdsaVerifyJce;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class EcdsaVerifyKeyManager extends KeyTypeManager<EcdsaPublicKey> {
    public EcdsaVerifyKeyManager() {
        super(EcdsaPublicKey.class, new PrimitiveFactory<PublicKeyVerify, EcdsaPublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.EcdsaVerifyKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeyVerify getPrimitive(EcdsaPublicKey ecdsaPublicKey) {
                return new EcdsaVerifyJce(EllipticCurves.getEcPublicKey(C0839SigUtil.toCurveType(ecdsaPublicKey.getParams().getCurve()), ecdsaPublicKey.mo3596getX().toByteArray(), ecdsaPublicKey.mo3597getY().toByteArray()), C0839SigUtil.toHashType(ecdsaPublicKey.getParams().getHashType()), C0839SigUtil.toEcdsaEncoding(ecdsaPublicKey.getParams().getEncoding()));
            }
        });
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
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
    public EcdsaPublicKey parseKey(ByteString byteString) {
        return EcdsaPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPublicKey.getVersion(), getVersion());
        C0839SigUtil.validateEcdsaParams(ecdsaPublicKey.getParams());
    }
}
