package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class LMSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {

    /* renamed from: I */
    private final byte[] f23254I;

    /* renamed from: T1 */
    private final byte[] f23255T1;
    private final LMOtsParameters lmOtsType;
    private final LMSigParameters parameterSet;

    public LMSPublicKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        super(false);
        this.parameterSet = lMSigParameters;
        this.lmOtsType = lMOtsParameters;
        this.f23254I = C6238Arrays.m18231clone(bArr2);
        this.f23255T1 = C6238Arrays.m18231clone(bArr);
    }

    public static LMSPublicKeyParameters getInstance(Object obj) throws Throwable {
        if (obj instanceof LMSPublicKeyParameters) {
            return (LMSPublicKeyParameters) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMSigParameters parametersForType = LMSigParameters.getParametersForType(dataInputStream.readInt());
            LMOtsParameters parametersForType2 = LMOtsParameters.getParametersForType(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[parametersForType.m17654getM()];
            dataInputStream.readFully(bArr2);
            return new LMSPublicKeyParameters(parametersForType, parametersForType2, bArr2, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(C6257Streams.m18363readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                LMSPublicKeyParameters lMSPublicKeyParameters = getInstance(dataInputStream3);
                dataInputStream3.close();
                return lMSPublicKeyParameters;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: equals */
    public boolean m17645equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKeyParameters = (LMSPublicKeyParameters) obj;
        if (this.parameterSet.equals(lMSPublicKeyParameters.parameterSet) && this.lmOtsType.equals(lMSPublicKeyParameters.lmOtsType) && C6238Arrays.areEqual(this.f23254I, lMSPublicKeyParameters.f23254I)) {
            return C6238Arrays.areEqual(this.f23255T1, lMSPublicKeyParameters.f23255T1);
        }
        return false;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedVerifier
    public LMSContext generateLMSContext(byte[] bArr) {
        try {
            return generateOtsContext(LMSSignature.getInstance(bArr));
        } catch (IOException e) {
            throw new IllegalStateException("cannot parse signature: " + e.getMessage());
        }
    }

    public LMSContext generateOtsContext(LMSSignature lMSSignature) {
        int iM17624getType = getOtsParameters().m17624getType();
        if (lMSSignature.getOtsSignature().m17634getType().m17624getType() == iM17624getType) {
            return new LMOtsPublicKey(LMOtsParameters.getParametersForType(iM17624getType), this.f23254I, lMSSignature.m17650getQ(), null).createOtsContext(lMSSignature);
        }
        throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters, org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    /* renamed from: getI */
    public byte[] m17646getI() {
        return C6238Arrays.m18231clone(this.f23254I);
    }

    public LMSParameters getLMSParameters() {
        return new LMSParameters(getSigParameters(), getOtsParameters());
    }

    public LMOtsParameters getOtsParameters() {
        return this.lmOtsType;
    }

    public LMSigParameters getSigParameters() {
        return this.parameterSet;
    }

    /* renamed from: getT1 */
    public byte[] m17647getT1() {
        return C6238Arrays.m18231clone(this.f23255T1);
    }

    public int hashCode() {
        return (((((this.parameterSet.hashCode() * 31) + this.lmOtsType.hashCode()) * 31) + C6238Arrays.hashCode(this.f23254I)) * 31) + C6238Arrays.hashCode(this.f23255T1);
    }

    public boolean matchesT1(byte[] bArr) {
        return C6238Arrays.constantTimeAreEqual(this.f23255T1, bArr);
    }

    /* renamed from: refI */
    public byte[] m17648refI() {
        return this.f23254I;
    }

    public byte[] toByteArray() {
        return Composer.m17598compose().m17609u32str(this.parameterSet.m17655getType()).m17609u32str(this.lmOtsType.m17624getType()).m17602bytes(this.f23254I).m17602bytes(this.f23255T1).m17600build();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedVerifier
    /* renamed from: verify */
    public boolean mo17619verify(LMSContext lMSContext) {
        return C6068LMS.verifySignature(this, lMSContext);
    }
}
