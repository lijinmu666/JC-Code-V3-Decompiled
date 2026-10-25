package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class HSSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {

    /* renamed from: l */
    private final int f23222l;
    private final LMSPublicKeyParameters lmsPublicKey;

    public HSSPublicKeyParameters(int i, LMSPublicKeyParameters lMSPublicKeyParameters) {
        super(false);
        if (lMSPublicKeyParameters == null) {
            throw new NullPointerException("lmsPublicKey");
        }
        this.f23222l = i;
        this.lmsPublicKey = lMSPublicKeyParameters;
    }

    public static HSSPublicKeyParameters getInstance(Object obj) throws Throwable {
        if (obj instanceof HSSPublicKeyParameters) {
            return (HSSPublicKeyParameters) obj;
        }
        if (obj instanceof DataInputStream) {
            return new HSSPublicKeyParameters(((DataInputStream) obj).readInt(), LMSPublicKeyParameters.getInstance(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(C6257Streams.m18363readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                HSSPublicKeyParameters hSSPublicKeyParameters = getInstance(dataInputStream2);
                dataInputStream2.close();
                return hSSPublicKeyParameters;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: equals */
    public boolean m17617equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters) obj;
        if (this.f23222l != hSSPublicKeyParameters.f23222l) {
            return false;
        }
        return this.lmsPublicKey.m17645equals(hSSPublicKeyParameters.lmsPublicKey);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedVerifier
    public LMSContext generateLMSContext(byte[] bArr) throws Throwable {
        try {
            HSSSignature hSSSignature = HSSSignature.getInstance(bArr, m17618getL());
            LMSSignedPubKey[] signedPubKey = hSSSignature.getSignedPubKey();
            return (signedPubKey.length != 0 ? signedPubKey[signedPubKey.length - 1].getPublicKey() : getLMSPublicKey()).generateOtsContext(hSSSignature.getSignature()).withSignedPublicKeys(signedPubKey);
        } catch (IOException e) {
            throw new IllegalStateException("cannot parse signature: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters, org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return Composer.m17598compose().m17609u32str(this.f23222l).m17602bytes(this.lmsPublicKey.getEncoded()).m17600build();
    }

    /* renamed from: getL */
    public int m17618getL() {
        return this.f23222l;
    }

    public LMSPublicKeyParameters getLMSPublicKey() {
        return this.lmsPublicKey;
    }

    public int hashCode() {
        return (this.f23222l * 31) + this.lmsPublicKey.hashCode();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedVerifier
    /* renamed from: verify */
    public boolean mo17619verify(LMSContext lMSContext) {
        LMSSignedPubKey[] signedPubKeys = lMSContext.getSignedPubKeys();
        boolean zVerifySignature = true;
        if (signedPubKeys.length != m17618getL() - 1) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKey = getLMSPublicKey();
        for (int i = 0; i < signedPubKeys.length; i++) {
            zVerifySignature &= C6068LMS.verifySignature(lMSPublicKey, signedPubKeys[i].getSignature(), signedPubKeys[i].getPublicKey().toByteArray());
            lMSPublicKey = signedPubKeys[i].getPublicKey();
        }
        return lMSPublicKey.mo17619verify(lMSContext) & zVerifySignature;
    }
}
