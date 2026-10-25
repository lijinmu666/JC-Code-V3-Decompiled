package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfParams;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.EciesHkdfKemParams;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EciesAeadHkdfHybridEncrypt;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class EciesAeadHkdfPublicKeyManager extends KeyTypeManager<EciesAeadHkdfPublicKey> {
    public EciesAeadHkdfPublicKeyManager() {
        super(EciesAeadHkdfPublicKey.class, new PrimitiveFactory<HybridEncrypt, EciesAeadHkdfPublicKey>(HybridEncrypt.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPublicKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public HybridEncrypt getPrimitive(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
                EciesAeadHkdfParams params = eciesAeadHkdfPublicKey.getParams();
                EciesHkdfKemParams kemParams = params.getKemParams();
                return new EciesAeadHkdfHybridEncrypt(EllipticCurves.getEcPublicKey(HybridUtil.toCurveType(kemParams.getCurveType()), eciesAeadHkdfPublicKey.mo3614getX().toByteArray(), eciesAeadHkdfPublicKey.mo3615getY().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
            }
        });
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
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
    public EciesAeadHkdfPublicKey parseKey(ByteString byteString) {
        return EciesAeadHkdfPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
        Validators.validateVersion(eciesAeadHkdfPublicKey.getVersion(), getVersion());
        HybridUtil.validate(eciesAeadHkdfPublicKey.getParams());
    }
}
