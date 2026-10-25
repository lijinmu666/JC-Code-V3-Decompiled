package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p217signers.DSAEncoding;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.DSABase */
/* loaded from: classes2.dex */
public abstract class AbstractC5616DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {

    /* renamed from: digest */
    protected InterfaceC5277Digest f21642digest;
    protected DSAEncoding encoding;

    /* renamed from: signer */
    protected InterfaceC5276DSAExt f21643signer;

    public AbstractC5616DSABase(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5276DSAExt interfaceC5276DSAExt, DSAEncoding dSAEncoding) {
        this.f21642digest = interfaceC5277Digest;
        this.f21643signer = interfaceC5276DSAExt;
        this.encoding = dSAEncoding;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f21642digest.getDigestSize()];
        this.f21642digest.mo14967doFinal(bArr, 0);
        try {
            BigInteger[] bigIntegerArrGenerateSignature = this.f21643signer.generateSignature(bArr);
            return this.encoding.mo15857encode(this.f21643signer.getOrder(), bigIntegerArrGenerateSignature[0], bigIntegerArrGenerateSignature[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21642digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f21642digest.getDigestSize()];
        this.f21642digest.mo14967doFinal(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrMo15856decode = this.encoding.mo15856decode(this.f21643signer.getOrder(), bArr);
            return this.f21643signer.verifySignature(bArr2, bigIntegerArrMo15856decode[0], bigIntegerArrMo15856decode[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21642digest.mo14970update(bArr, i, i2);
    }
}
