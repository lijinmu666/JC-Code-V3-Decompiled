package org.bouncycastle.p249jcajce.provider.asymmetric.p253dstu;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p170ua.DSTU4145Params;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.GOST3411Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p217signers.DSTU4145Signer;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey;

/* loaded from: classes2.dex */
public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {

    /* renamed from: digest */
    private InterfaceC5277Digest f21468digest;

    /* renamed from: signer */
    private InterfaceC5276DSAExt f21469signer = new DSTU4145Signer();

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    @Override // java.security.SignatureSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePrivateKeyParameter;
        SecureRandom secureRandom;
        if (!(privateKey instanceof BCDSTU4145PrivateKey) && !(privateKey instanceof InterfaceC5809ECKey)) {
            asymmetricKeyParameterGeneratePrivateKeyParameter = null;
            secureRandom = ((java.security.SignatureSpi) this).appRandom;
            InterfaceC5276DSAExt interfaceC5276DSAExt = this.f21469signer;
            if (secureRandom == null) {
                interfaceC5276DSAExt.mo14965init(true, new ParametersWithRandom(asymmetricKeyParameterGeneratePrivateKeyParameter, secureRandom));
                return;
            } else {
                interfaceC5276DSAExt.mo14965init(true, asymmetricKeyParameterGeneratePrivateKeyParameter);
                return;
            }
        }
        asymmetricKeyParameterGeneratePrivateKeyParameter = C5618ECUtil.generatePrivateKeyParameter(privateKey);
        GOST3411Digest gOST3411Digest = new GOST3411Digest(expandSbox(DSTU4145Params.getDefaultDKE()));
        this.f21468digest = gOST3411Digest;
        secureRandom = ((java.security.SignatureSpi) this).appRandom;
        InterfaceC5276DSAExt interfaceC5276DSAExt2 = this.f21469signer;
        if (secureRandom == null) {
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters cipherParametersGeneratePublicKeyParameter;
        if (publicKey instanceof BCDSTU4145PublicKey) {
            BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) publicKey;
            cipherParametersGeneratePublicKeyParameter = bCDSTU4145PublicKey.engineGetKeyParameters();
            this.f21468digest = new GOST3411Digest(expandSbox(bCDSTU4145PublicKey.m16096getSbox()));
        } else {
            cipherParametersGeneratePublicKeyParameter = C5618ECUtil.generatePublicKeyParameter(publicKey);
            this.f21468digest = new GOST3411Digest(expandSbox(DSTU4145Params.getDefaultDKE()));
        }
        this.f21469signer.mo14965init(false, cipherParametersGeneratePublicKeyParameter);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f21468digest.getDigestSize()];
        this.f21468digest.mo14967doFinal(bArr, 0);
        try {
            BigInteger[] bigIntegerArrGenerateSignature = this.f21469signer.generateSignature(bArr);
            byte[] byteArray = bigIntegerArrGenerateSignature[0].toByteArray();
            byte[] byteArray2 = bigIntegerArrGenerateSignature[1].toByteArray();
            int length = (byteArray.length > byteArray2.length ? byteArray.length : byteArray2.length) * 2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(byteArray2, 0, bArr2, (length / 2) - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr2, length - byteArray.length, byteArray.length);
            return new DEROctetString(bArr2).getEncoded();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21468digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f21468digest.getDigestSize()];
        this.f21468digest.mo14967doFinal(bArr2, 0);
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(bArr)).getOctets();
            byte[] bArr3 = new byte[octets.length / 2];
            byte[] bArr4 = new byte[octets.length / 2];
            System.arraycopy(octets, 0, bArr4, 0, octets.length / 2);
            System.arraycopy(octets, octets.length / 2, bArr3, 0, octets.length / 2);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.f21469signer.verifySignature(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public byte[] expandSbox(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr2[i2] = (byte) ((bArr[i] >> 4) & 15);
            bArr2[i2 + 1] = (byte) (bArr[i] & 15);
        }
        return bArr2;
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21468digest.mo14970update(bArr, i, i2);
    }
}
