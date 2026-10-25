package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
class LMSSignedPubKey implements Encodable {
    private final LMSPublicKeyParameters publicKey;
    private final LMSSignature signature;

    public LMSSignedPubKey(LMSSignature lMSSignature, LMSPublicKeyParameters lMSPublicKeyParameters) {
        this.signature = lMSSignature;
        this.publicKey = lMSPublicKeyParameters;
    }

    /* renamed from: equals */
    public boolean m17652equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSSignedPubKey lMSSignedPubKey = (LMSSignedPubKey) obj;
        LMSSignature lMSSignature = this.signature;
        if (lMSSignature == null ? lMSSignedPubKey.signature != null : !lMSSignature.m17649equals(lMSSignedPubKey.signature)) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        return lMSPublicKeyParameters != null ? lMSPublicKeyParameters.m17645equals(lMSSignedPubKey.publicKey) : lMSSignedPubKey.publicKey == null;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return Composer.m17598compose().m17602bytes(this.signature.getEncoded()).m17602bytes(this.publicKey.getEncoded()).m17600build();
    }

    public LMSPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public int hashCode() {
        LMSSignature lMSSignature = this.signature;
        int iHashCode = (lMSSignature != null ? lMSSignature.hashCode() : 0) * 31;
        LMSPublicKeyParameters lMSPublicKeyParameters = this.publicKey;
        return iHashCode + (lMSPublicKeyParameters != null ? lMSPublicKeyParameters.hashCode() : 0);
    }
}
