package org.bouncycastle.p194crypto.p217signers;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.ECCSIPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECCSIPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECCSISigner implements InterfaceC5282Signer {

    /* renamed from: G */
    private final AbstractC5820ECPoint f20937G;

    /* renamed from: N */
    private final int f20938N;

    /* renamed from: Y */
    private AbstractC5820ECPoint f20939Y;

    /* renamed from: digest */
    private final InterfaceC5277Digest f20940digest;
    private boolean forSigning;

    /* renamed from: id */
    private final byte[] f20941id;

    /* renamed from: j */
    private BigInteger f20942j;

    /* renamed from: kpak */
    private final AbstractC5820ECPoint f20943kpak;

    /* renamed from: param */
    private CipherParameters f20944param;

    /* renamed from: q */
    private final BigInteger f20945q;

    /* renamed from: r */
    private BigInteger f20946r;

    /* renamed from: stream */
    private ByteArrayOutputStream f20947stream;

    public ECCSISigner(AbstractC5820ECPoint abstractC5820ECPoint, X9ECParameters x9ECParameters, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr) {
        this.f20943kpak = abstractC5820ECPoint;
        this.f20941id = bArr;
        this.f20945q = x9ECParameters.getCurve().getOrder();
        this.f20937G = x9ECParameters.m14735getG();
        this.f20940digest = interfaceC5277Digest;
        interfaceC5277Digest.mo14968reset();
        this.f20938N = (x9ECParameters.getCurve().getOrder().bitLength() + 7) >> 3;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        byte[] bArr = new byte[this.f20940digest.getDigestSize()];
        this.f20940digest.mo14967doFinal(bArr, 0);
        ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) ((ParametersWithRandom) this.f20944param).getParameters();
        BigInteger bigIntegerMod = new BigInteger(1, bArr).add(this.f20946r.multiply(eCCSIPrivateKeyParameters.m15717getSSK())).mod(this.f20945q);
        if (bigIntegerMod.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Invalid j, retry");
        }
        return C6238Arrays.concatenate(BigIntegers.asUnsignedByteArray(this.f20938N, this.f20946r), BigIntegers.asUnsignedByteArray(this.f20938N, bigIntegerMod.modInverse(this.f20945q).multiply(this.f20942j).mod(this.f20945q)), eCCSIPrivateKeyParameters.getPublicKeyParameters().m15718getPVT().getEncoded(false));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        this.f20944param = cipherParameters;
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        SecureRandom random;
        AbstractC5820ECPoint abstractC5820ECPointM15718getPVT;
        AbstractC5820ECPoint abstractC5820ECPointMultiply;
        this.f20940digest.mo14968reset();
        CipherParameters parameters = this.f20944param;
        if (parameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) parameters;
            random = parametersWithRandom.getRandom();
            parameters = parametersWithRandom.getParameters();
        } else {
            random = null;
        }
        if (this.forSigning) {
            ECCSIPrivateKeyParameters eCCSIPrivateKeyParameters = (ECCSIPrivateKeyParameters) parameters;
            abstractC5820ECPointM15718getPVT = eCCSIPrivateKeyParameters.getPublicKeyParameters().m15718getPVT();
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(this.f20945q.bitLength(), random);
            this.f20942j = bigIntegerCreateRandomBigInteger;
            this.f20946r = this.f20937G.multiply(bigIntegerCreateRandomBigInteger).normalize().getAffineXCoord().toBigInteger().mod(this.f20945q);
            abstractC5820ECPointMultiply = this.f20937G.multiply(eCCSIPrivateKeyParameters.m15717getSSK());
        } else {
            AbstractC5820ECPoint abstractC5820ECPointM15718getPVT2 = ((ECCSIPublicKeyParameters) parameters).m15718getPVT();
            this.f20947stream = new ByteArrayOutputStream();
            abstractC5820ECPointM15718getPVT = abstractC5820ECPointM15718getPVT2;
            abstractC5820ECPointMultiply = null;
        }
        byte[] encoded = this.f20937G.getEncoded(false);
        this.f20940digest.mo14970update(encoded, 0, encoded.length);
        byte[] encoded2 = this.f20943kpak.getEncoded(false);
        this.f20940digest.mo14970update(encoded2, 0, encoded2.length);
        InterfaceC5277Digest interfaceC5277Digest = this.f20940digest;
        byte[] bArr = this.f20941id;
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        byte[] encoded3 = abstractC5820ECPointM15718getPVT.getEncoded(false);
        this.f20940digest.mo14970update(encoded3, 0, encoded3.length);
        int digestSize = this.f20940digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.f20940digest.mo14967doFinal(bArr2, 0);
        BigInteger bigIntegerMod = new BigInteger(1, bArr2).mod(this.f20945q);
        this.f20940digest.mo14970update(bArr2, 0, digestSize);
        if (!this.forSigning) {
            this.f20939Y = abstractC5820ECPointM15718getPVT.multiply(bigIntegerMod).mo16330add(this.f20943kpak).normalize();
        } else {
            if (!abstractC5820ECPointMultiply.subtract(abstractC5820ECPointM15718getPVT.multiply(bigIntegerMod)).normalize().m16333equals(this.f20943kpak)) {
                throw new IllegalArgumentException("Invalid KPAK");
            }
            byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.f20938N, this.f20946r);
            this.f20940digest.mo14970update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        if (this.forSigning) {
            this.f20940digest.mo14969update(b);
        } else {
            this.f20947stream.write(b);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrM18242copyOf = C6238Arrays.m18242copyOf(bArr, this.f20938N);
        int i = this.f20938N;
        BigInteger bigInteger = new BigInteger(1, C6238Arrays.copyOfRange(bArr, i, i << 1));
        this.f20946r = new BigInteger(1, bArrM18242copyOf).mod(this.f20945q);
        this.f20940digest.mo14970update(bArrM18242copyOf, 0, this.f20938N);
        byte[] byteArray = this.f20947stream.toByteArray();
        this.f20940digest.mo14970update(byteArray, 0, byteArray.length);
        byte[] bArr2 = new byte[this.f20940digest.getDigestSize()];
        this.f20940digest.mo14967doFinal(bArr2, 0);
        return this.f20937G.multiply(new BigInteger(1, bArr2).mod(this.f20945q)).normalize().mo16330add(this.f20939Y.multiply(this.f20946r).normalize()).normalize().multiply(bigInteger).normalize().getAffineXCoord().toBigInteger().mod(this.f20945q).equals(this.f20946r.mod(this.f20945q));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        if (this.forSigning) {
            this.f20940digest.mo14970update(bArr, i, i2);
        } else {
            this.f20947stream.write(bArr, i, i2);
        }
    }
}
