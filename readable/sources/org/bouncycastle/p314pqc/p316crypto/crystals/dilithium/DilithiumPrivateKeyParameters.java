package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DilithiumPrivateKeyParameters extends DilithiumKeyParameters {

    /* renamed from: k */
    final byte[] f23086k;

    /* renamed from: rho */
    final byte[] f23087rho;

    /* renamed from: s1 */
    final byte[] f23088s1;

    /* renamed from: s2 */
    final byte[] f23089s2;

    /* renamed from: t0 */
    final byte[] f23090t0;

    /* renamed from: t1 */
    private final byte[] f23091t1;

    /* renamed from: tr */
    final byte[] f23092tr;

    public DilithiumPrivateKeyParameters(DilithiumParameters dilithiumParameters, byte[] bArr, DilithiumPublicKeyParameters dilithiumPublicKeyParameters) {
        super(true, dilithiumParameters);
        DilithiumEngine engine = dilithiumParameters.getEngine(null);
        this.f23087rho = C6238Arrays.copyOfRange(bArr, 0, 32);
        this.f23086k = C6238Arrays.copyOfRange(bArr, 32, 64);
        this.f23092tr = C6238Arrays.copyOfRange(bArr, 64, 128);
        int dilithiumL = (engine.getDilithiumL() * engine.getDilithiumPolyEtaPackedBytes()) + 128;
        this.f23088s1 = C6238Arrays.copyOfRange(bArr, 128, dilithiumL);
        int dilithiumK = (engine.getDilithiumK() * engine.getDilithiumPolyEtaPackedBytes()) + dilithiumL;
        this.f23089s2 = C6238Arrays.copyOfRange(bArr, dilithiumL, dilithiumK);
        this.f23090t0 = C6238Arrays.copyOfRange(bArr, dilithiumK, (engine.getDilithiumK() * 416) + dilithiumK);
        if (dilithiumPublicKeyParameters != null) {
            this.f23091t1 = dilithiumPublicKeyParameters.m17524getT1();
        } else {
            this.f23091t1 = null;
        }
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(new byte[][]{this.f23087rho, this.f23086k, this.f23092tr, this.f23088s1, this.f23089s2, this.f23090t0});
    }

    /* renamed from: getK */
    public byte[] m17516getK() {
        return C6238Arrays.m18231clone(this.f23086k);
    }

    @Deprecated
    public byte[] getPrivateKey() {
        return getEncoded();
    }

    public byte[] getPublicKey() {
        return DilithiumPublicKeyParameters.getEncoded(this.f23087rho, this.f23091t1);
    }

    public DilithiumPublicKeyParameters getPublicKeyParameters() {
        return new DilithiumPublicKeyParameters(getParameters(), this.f23087rho, this.f23091t1);
    }

    /* renamed from: getRho */
    public byte[] m17517getRho() {
        return C6238Arrays.m18231clone(this.f23087rho);
    }

    /* renamed from: getS1 */
    public byte[] m17518getS1() {
        return C6238Arrays.m18231clone(this.f23088s1);
    }

    /* renamed from: getS2 */
    public byte[] m17519getS2() {
        return C6238Arrays.m18231clone(this.f23089s2);
    }

    /* renamed from: getT0 */
    public byte[] m17520getT0() {
        return C6238Arrays.m18231clone(this.f23090t0);
    }

    /* renamed from: getT1 */
    public byte[] m17521getT1() {
        return C6238Arrays.m18231clone(this.f23091t1);
    }

    /* renamed from: getTr */
    public byte[] m17522getTr() {
        return C6238Arrays.m18231clone(this.f23092tr);
    }

    public DilithiumPrivateKeyParameters(DilithiumParameters dilithiumParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        super(true, dilithiumParameters);
        this.f23087rho = C6238Arrays.m18231clone(bArr);
        this.f23086k = C6238Arrays.m18231clone(bArr2);
        this.f23092tr = C6238Arrays.m18231clone(bArr3);
        this.f23088s1 = C6238Arrays.m18231clone(bArr4);
        this.f23089s2 = C6238Arrays.m18231clone(bArr5);
        this.f23090t0 = C6238Arrays.m18231clone(bArr6);
        this.f23091t1 = C6238Arrays.m18231clone(bArr7);
    }
}
