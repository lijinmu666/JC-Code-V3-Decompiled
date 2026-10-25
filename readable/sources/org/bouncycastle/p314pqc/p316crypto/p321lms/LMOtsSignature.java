package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.p361util.Encodable;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
class LMOtsSignature implements Encodable {

    /* renamed from: C */
    private final byte[] f23237C;

    /* renamed from: type */
    private final LMOtsParameters f23238type;

    /* renamed from: y */
    private final byte[] f23239y;

    public LMOtsSignature(LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        this.f23238type = lMOtsParameters;
        this.f23237C = bArr;
        this.f23239y = bArr2;
    }

    public static LMOtsSignature getInstance(Object obj) throws Throwable {
        if (obj instanceof LMOtsSignature) {
            return (LMOtsSignature) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            LMOtsParameters parametersForType = LMOtsParameters.getParametersForType(dataInputStream.readInt());
            byte[] bArr = new byte[parametersForType.m17622getN()];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[parametersForType.m17623getP() * parametersForType.m17622getN()];
            dataInputStream.readFully(bArr2);
            return new LMOtsSignature(parametersForType, bArr, bArr2);
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
                LMOtsSignature lMOtsSignature = getInstance(dataInputStream3);
                dataInputStream3.close();
                return lMOtsSignature;
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
    public boolean m17632equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMOtsSignature lMOtsSignature = (LMOtsSignature) obj;
        LMOtsParameters lMOtsParameters = this.f23238type;
        if (lMOtsParameters == null ? lMOtsSignature.f23238type != null : !lMOtsParameters.equals(lMOtsSignature.f23238type)) {
            return false;
        }
        if (Arrays.equals(this.f23237C, lMOtsSignature.f23237C)) {
            return Arrays.equals(this.f23239y, lMOtsSignature.f23239y);
        }
        return false;
    }

    /* renamed from: getC */
    public byte[] m17633getC() {
        return this.f23237C;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return Composer.m17598compose().m17609u32str(this.f23238type.m17624getType()).m17602bytes(this.f23237C).m17602bytes(this.f23239y).m17600build();
    }

    /* renamed from: getType */
    public LMOtsParameters m17634getType() {
        return this.f23238type;
    }

    /* renamed from: getY */
    public byte[] m17635getY() {
        return this.f23239y;
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.f23238type;
        return ((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.f23237C)) * 31) + Arrays.hashCode(this.f23239y);
    }
}
