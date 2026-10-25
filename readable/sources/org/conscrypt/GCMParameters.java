package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* loaded from: classes2.dex */
public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;

    /* renamed from: iv */
    private byte[] f24372iv;

    /* renamed from: tLen */
    private int f24373tLen;

    public GCMParameters() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws Throwable {
        long jAsn1_write_init;
        long j;
        long jAsn1_write_sequence = 0;
        try {
            jAsn1_write_init = NativeCrypto.asn1_write_init();
        } catch (IOException e) {
            e = e;
            j = 0;
        } catch (Throwable th) {
            th = th;
            jAsn1_write_init = 0;
        }
        try {
            jAsn1_write_sequence = NativeCrypto.asn1_write_sequence(jAsn1_write_init);
            NativeCrypto.asn1_write_octetstring(jAsn1_write_sequence, this.f24372iv);
            if (this.f24373tLen != 96) {
                NativeCrypto.asn1_write_uint64(jAsn1_write_sequence, r8 / 8);
            }
            byte[] bArrAsn1_write_finish = NativeCrypto.asn1_write_finish(jAsn1_write_init);
            NativeCrypto.asn1_write_free(jAsn1_write_sequence);
            NativeCrypto.asn1_write_free(jAsn1_write_init);
            return bArrAsn1_write_finish;
        } catch (IOException e2) {
            e = e2;
            long j2 = jAsn1_write_sequence;
            jAsn1_write_sequence = jAsn1_write_init;
            j = j2;
            try {
                NativeCrypto.asn1_write_cleanup(jAsn1_write_sequence);
                throw e;
            } catch (Throwable th2) {
                th = th2;
                long j3 = jAsn1_write_sequence;
                jAsn1_write_sequence = j;
                jAsn1_write_init = j3;
                NativeCrypto.asn1_write_free(jAsn1_write_sequence);
                NativeCrypto.asn1_write_free(jAsn1_write_init);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            NativeCrypto.asn1_write_free(jAsn1_write_sequence);
            NativeCrypto.asn1_write_free(jAsn1_write_init);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            return cls.cast(Platform.toGCMParameterSpec(this.f24373tLen, this.f24372iv));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws NoSuchMethodException, InvalidParameterSpecException, ClassNotFoundException, SecurityException {
        GCMParameters gCMParametersFromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (gCMParametersFromGCMParameterSpec == null) {
            throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
        }
        this.f24373tLen = gCMParametersFromGCMParameterSpec.f24373tLen;
        this.f24372iv = gCMParametersFromGCMParameterSpec.f24372iv;
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt GCM AlgorithmParameters";
    }

    /* renamed from: getIV */
    public byte[] m18440getIV() {
        return this.f24372iv;
    }

    /* renamed from: getTLen */
    public int m18441getTLen() {
        return this.f24373tLen;
    }

    public GCMParameters(int i, byte[] bArr) {
        this.f24373tLen = i;
        this.f24372iv = bArr;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws Throwable {
        long jAsn1_read_init;
        try {
            jAsn1_read_init = NativeCrypto.asn1_read_init(bArr);
            try {
                long jAsn1_read_sequence = NativeCrypto.asn1_read_sequence(jAsn1_read_init);
                byte[] bArrAsn1_read_octetstring = NativeCrypto.asn1_read_octetstring(jAsn1_read_sequence);
                int iAsn1_read_uint64 = !NativeCrypto.asn1_read_is_empty(jAsn1_read_sequence) ? ((int) NativeCrypto.asn1_read_uint64(jAsn1_read_sequence)) * 8 : 96;
                if (NativeCrypto.asn1_read_is_empty(jAsn1_read_sequence) && NativeCrypto.asn1_read_is_empty(jAsn1_read_init)) {
                    this.f24372iv = bArrAsn1_read_octetstring;
                    this.f24373tLen = iAsn1_read_uint64;
                    NativeCrypto.asn1_read_free(jAsn1_read_sequence);
                    NativeCrypto.asn1_read_free(jAsn1_read_init);
                    return;
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(0L);
                NativeCrypto.asn1_read_free(jAsn1_read_init);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            jAsn1_read_init = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws Throwable {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        engineInit(bArr);
    }
}
