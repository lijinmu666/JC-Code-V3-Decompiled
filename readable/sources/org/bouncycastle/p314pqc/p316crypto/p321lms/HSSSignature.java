package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6244Objects;
import org.bouncycastle.p361util.Encodable;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
class HSSSignature implements Encodable {

    /* renamed from: lMinus1 */
    private final int f23223lMinus1;
    private final LMSSignature signature;
    private final LMSSignedPubKey[] signedPubKey;

    public HSSSignature(int i, LMSSignedPubKey[] lMSSignedPubKeyArr, LMSSignature lMSSignature) {
        this.f23223lMinus1 = i;
        this.signedPubKey = lMSSignedPubKeyArr;
        this.signature = lMSSignature;
    }

    public static HSSSignature getInstance(Object obj, int i) throws Throwable {
        if (obj instanceof HSSSignature) {
            return (HSSSignature) obj;
        }
        if (obj instanceof DataInputStream) {
            int i2 = ((DataInputStream) obj).readInt();
            if (i2 != i - 1) {
                throw new IllegalStateException("nspk exceeded maxNspk");
            }
            LMSSignedPubKey[] lMSSignedPubKeyArr = new LMSSignedPubKey[i2];
            if (i2 != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    lMSSignedPubKeyArr[i3] = new LMSSignedPubKey(LMSSignature.getInstance(obj), LMSPublicKeyParameters.getInstance(obj));
                }
            }
            return new HSSSignature(i2, lMSSignedPubKeyArr, LMSSignature.getInstance(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(C6257Streams.m18363readAll((InputStream) obj), i);
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                HSSSignature hSSSignature = getInstance(dataInputStream2, i);
                dataInputStream2.close();
                return hSSSignature;
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
    public boolean m17620equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSSignature hSSSignature = (HSSSignature) obj;
        return this.f23223lMinus1 == hSSSignature.f23223lMinus1 && C6238Arrays.areEqual(this.signedPubKey, hSSSignature.signedPubKey) && C6244Objects.areEqual(this.signature, hSSSignature.signature);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() throws IOException {
        Composer composerM17598compose = Composer.m17598compose();
        composerM17598compose.m17609u32str(this.f23223lMinus1);
        LMSSignedPubKey[] lMSSignedPubKeyArr = this.signedPubKey;
        if (lMSSignedPubKeyArr != null) {
            for (LMSSignedPubKey lMSSignedPubKey : lMSSignedPubKeyArr) {
                composerM17598compose.m17601bytes(lMSSignedPubKey);
            }
        }
        composerM17598compose.m17601bytes(this.signature);
        return composerM17598compose.m17600build();
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKey() {
        return this.signedPubKey;
    }

    public int getlMinus1() {
        return this.f23223lMinus1;
    }

    public int hashCode() {
        return (((this.f23223lMinus1 * 31) + C6238Arrays.hashCode(this.signedPubKey)) * 31) + C6244Objects.hashCode(this.signature);
    }
}
