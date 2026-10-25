package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6244Objects;
import org.bouncycastle.p361util.Encodable;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
class LMOtsPublicKey implements Encodable {

    /* renamed from: I */
    private final byte[] f23234I;

    /* renamed from: K */
    private final byte[] f23235K;
    private final LMOtsParameters parameter;

    /* renamed from: q */
    private final int f23236q;

    public LMOtsPublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.f23234I = bArr;
        this.f23236q = i;
        this.f23235K = bArr2;
    }

    public static LMOtsPublicKey getInstance(Object obj) throws Throwable {
        if (obj instanceof LMOtsPublicKey) {
            return (LMOtsPublicKey) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMOtsParameters parametersForType = LMOtsParameters.getParametersForType(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            int i = dataInputStream.readInt();
            byte[] bArr2 = new byte[parametersForType.m17622getN()];
            dataInputStream.readFully(bArr2);
            return new LMOtsPublicKey(parametersForType, bArr, i, bArr2);
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
                LMOtsPublicKey lMOtsPublicKey = getInstance(dataInputStream3);
                dataInputStream3.close();
                return lMOtsPublicKey;
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

    public LMSContext createOtsContext(LMOtsSignature lMOtsSignature) {
        InterfaceC5277Digest digest = DigestUtil.getDigest(this.parameter);
        LmsUtils.byteArray(this.f23234I, digest);
        LmsUtils.m17659u32str(this.f23236q, digest);
        LmsUtils.m17658u16str((short) -32383, digest);
        LmsUtils.byteArray(lMOtsSignature.m17633getC(), digest);
        return new LMSContext(this, lMOtsSignature, digest);
    }

    /* renamed from: equals */
    public boolean m17628equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMOtsPublicKey lMOtsPublicKey = (LMOtsPublicKey) obj;
        return this.f23236q == lMOtsPublicKey.f23236q && C6244Objects.areEqual(this.parameter, lMOtsPublicKey.parameter) && C6238Arrays.areEqual(this.f23234I, lMOtsPublicKey.f23234I) && C6238Arrays.areEqual(this.f23235K, lMOtsPublicKey.f23235K);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return Composer.m17598compose().m17609u32str(this.parameter.m17624getType()).m17602bytes(this.f23234I).m17609u32str(this.f23236q).m17602bytes(this.f23235K).m17600build();
    }

    /* renamed from: getI */
    public byte[] m17629getI() {
        return this.f23234I;
    }

    /* renamed from: getK */
    public byte[] m17630getK() {
        return this.f23235K;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    /* renamed from: getQ */
    public int m17631getQ() {
        return this.f23236q;
    }

    public int hashCode() {
        return (((((this.f23236q * 31) + C6244Objects.hashCode(this.parameter)) * 31) + C6238Arrays.hashCode(this.f23234I)) * 31) + C6238Arrays.hashCode(this.f23235K);
    }

    public LMSContext createOtsContext(LMSSignature lMSSignature) {
        InterfaceC5277Digest digest = DigestUtil.getDigest(this.parameter);
        LmsUtils.byteArray(this.f23234I, digest);
        LmsUtils.m17659u32str(this.f23236q, digest);
        LmsUtils.m17658u16str((short) -32383, digest);
        LmsUtils.byteArray(lMSSignature.getOtsSignature().m17633getC(), digest);
        return new LMSContext(this, lMSSignature, digest);
    }
}
