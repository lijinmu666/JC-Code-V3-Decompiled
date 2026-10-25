package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class NistCurvesHpkeKemPrivateKey implements HpkeKemPrivateKey {
    private final C0878Bytes privateKey;
    private final C0878Bytes publicKey;

    private NistCurvesHpkeKemPrivateKey(byte[] bArr, byte[] bArr2) {
        this.privateKey = C0878Bytes.copyFrom(bArr);
        this.publicKey = C0878Bytes.copyFrom(bArr2);
    }

    public static NistCurvesHpkeKemPrivateKey fromBytes(byte[] bArr, byte[] bArr2, EllipticCurves.CurveType curveType) throws GeneralSecurityException {
        EllipticCurves.validatePublicKey(EllipticCurves.getEcPublicKey(curveType, EllipticCurves.PointFormatType.UNCOMPRESSED, bArr2), EllipticCurves.getEcPrivateKey(curveType, bArr));
        return new NistCurvesHpkeKemPrivateKey(bArr, bArr2);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeKemPrivateKey
    public C0878Bytes getSerializedPrivate() {
        return this.privateKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.HpkeKemPrivateKey
    public C0878Bytes getSerializedPublic() {
        return this.publicKey;
    }
}
