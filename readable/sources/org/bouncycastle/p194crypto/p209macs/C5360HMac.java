package org.bouncycastle.p194crypto.p209macs;

import java.util.Hashtable;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Memoable;

/* renamed from: org.bouncycastle.crypto.macs.HMac */
/* loaded from: classes2.dex */
public class C5360HMac implements InterfaceC5278Mac {

    /* renamed from: IPAD */
    private static final byte f20451IPAD = 54;

    /* renamed from: OPAD */
    private static final byte f20452OPAD = 92;
    private static Hashtable blockLengths;
    private int blockLength;

    /* renamed from: digest */
    private InterfaceC5277Digest f20453digest;
    private int digestSize;
    private byte[] inputPad;
    private Memoable ipadState;
    private Memoable opadState;
    private byte[] outputBuf;

    static {
        Hashtable hashtable = new Hashtable();
        blockLengths = hashtable;
        hashtable.put("GOST3411", Integers.m18296valueOf(32));
        blockLengths.put("MD2", Integers.m18296valueOf(16));
        blockLengths.put("MD4", Integers.m18296valueOf(64));
        blockLengths.put("MD5", Integers.m18296valueOf(64));
        blockLengths.put("RIPEMD128", Integers.m18296valueOf(64));
        blockLengths.put("RIPEMD160", Integers.m18296valueOf(64));
        blockLengths.put("SHA-1", Integers.m18296valueOf(64));
        blockLengths.put("SHA-224", Integers.m18296valueOf(64));
        blockLengths.put(XMSSKeyParameters.f23621SHA_256, Integers.m18296valueOf(64));
        blockLengths.put("SHA-384", Integers.m18296valueOf(128));
        blockLengths.put(XMSSKeyParameters.f23622SHA_512, Integers.m18296valueOf(128));
        blockLengths.put("Tiger", Integers.m18296valueOf(64));
        blockLengths.put("Whirlpool", Integers.m18296valueOf(64));
    }

    public C5360HMac(InterfaceC5277Digest interfaceC5277Digest) {
        this(interfaceC5277Digest, getByteLength(interfaceC5277Digest));
    }

    private static int getByteLength(InterfaceC5277Digest interfaceC5277Digest) {
        if (interfaceC5277Digest instanceof ExtendedDigest) {
            return ((ExtendedDigest) interfaceC5277Digest).getByteLength();
        }
        Integer num = (Integer) blockLengths.get(interfaceC5277Digest.getAlgorithmName());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + interfaceC5277Digest.getAlgorithmName());
    }

    /* renamed from: xorPad */
    private static void m15585xorPad(byte[] bArr, int i, byte b) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        this.f20453digest.mo14967doFinal(this.outputBuf, this.blockLength);
        Memoable memoable = this.opadState;
        if (memoable != null) {
            ((Memoable) this.f20453digest).mo14824reset(memoable);
            InterfaceC5277Digest interfaceC5277Digest = this.f20453digest;
            interfaceC5277Digest.mo14970update(this.outputBuf, this.blockLength, interfaceC5277Digest.getDigestSize());
        } else {
            InterfaceC5277Digest interfaceC5277Digest2 = this.f20453digest;
            byte[] bArr2 = this.outputBuf;
            interfaceC5277Digest2.mo14970update(bArr2, 0, bArr2.length);
        }
        int iMo14967doFinal = this.f20453digest.mo14967doFinal(bArr, i);
        int i2 = this.blockLength;
        while (true) {
            byte[] bArr3 = this.outputBuf;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        Memoable memoable2 = this.ipadState;
        if (memoable2 != null) {
            ((Memoable) this.f20453digest).mo14824reset(memoable2);
        } else {
            InterfaceC5277Digest interfaceC5277Digest3 = this.f20453digest;
            byte[] bArr4 = this.inputPad;
            interfaceC5277Digest3.mo14970update(bArr4, 0, bArr4.length);
        }
        return iMo14967doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20453digest.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.digestSize;
    }

    public InterfaceC5277Digest getUnderlyingDigest() {
        return this.f20453digest;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        byte[] bArr;
        this.f20453digest.mo14968reset();
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        int length = bArrM15773getKey.length;
        if (length > this.blockLength) {
            this.f20453digest.mo14970update(bArrM15773getKey, 0, length);
            this.f20453digest.mo14967doFinal(this.inputPad, 0);
            length = this.digestSize;
        } else {
            System.arraycopy(bArrM15773getKey, 0, this.inputPad, 0, length);
        }
        while (true) {
            bArr = this.inputPad;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.outputBuf, 0, this.blockLength);
        m15585xorPad(this.inputPad, this.blockLength, f20451IPAD);
        m15585xorPad(this.outputBuf, this.blockLength, f20452OPAD);
        InterfaceC5277Digest interfaceC5277Digest = this.f20453digest;
        if (interfaceC5277Digest instanceof Memoable) {
            Memoable memoableMo14823copy = ((Memoable) interfaceC5277Digest).mo14823copy();
            this.opadState = memoableMo14823copy;
            ((InterfaceC5277Digest) memoableMo14823copy).mo14970update(this.outputBuf, 0, this.blockLength);
        }
        InterfaceC5277Digest interfaceC5277Digest2 = this.f20453digest;
        byte[] bArr2 = this.inputPad;
        interfaceC5277Digest2.mo14970update(bArr2, 0, bArr2.length);
        InterfaceC5277Digest interfaceC5277Digest3 = this.f20453digest;
        if (interfaceC5277Digest3 instanceof Memoable) {
            this.ipadState = ((Memoable) interfaceC5277Digest3).mo14823copy();
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        Memoable memoable = this.ipadState;
        if (memoable != null) {
            ((Memoable) this.f20453digest).mo14824reset(memoable);
            return;
        }
        this.f20453digest.mo14968reset();
        InterfaceC5277Digest interfaceC5277Digest = this.f20453digest;
        byte[] bArr = this.inputPad;
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20453digest.mo14969update(b);
    }

    private C5360HMac(InterfaceC5277Digest interfaceC5277Digest, int i) {
        this.f20453digest = interfaceC5277Digest;
        int digestSize = interfaceC5277Digest.getDigestSize();
        this.digestSize = digestSize;
        this.blockLength = i;
        this.inputPad = new byte[i];
        this.outputBuf = new byte[i + digestSize];
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        this.f20453digest.mo14970update(bArr, i, i2);
    }
}
