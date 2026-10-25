package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HMacDSAKCalculator implements DSAKCalculator {

    /* renamed from: K */
    private final byte[] f20967K;

    /* renamed from: V */
    private final byte[] f20968V;

    /* renamed from: hMac */
    private final C5360HMac f20969hMac;

    /* renamed from: n */
    private BigInteger f20970n;

    public HMacDSAKCalculator(InterfaceC5277Digest interfaceC5277Digest) {
        C5360HMac c5360HMac = new C5360HMac(interfaceC5277Digest);
        this.f20969hMac = c5360HMac;
        int macSize = c5360HMac.getMacSize();
        this.f20968V = new byte[macSize];
        this.f20967K = new byte[macSize];
    }

    private BigInteger bitsToInt(byte[] bArr) {
        int length = bArr.length * 8;
        int iBitLength = this.f20970n.bitLength();
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr);
        return length > iBitLength ? bigIntegerFromUnsignedByteArray.shiftRight(length - iBitLength) : bigIntegerFromUnsignedByteArray;
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: init */
    public void mo15858init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f20970n = bigInteger;
        BigInteger bigIntegerBitsToInt = bitsToInt(bArr);
        if (bigIntegerBitsToInt.compareTo(bigInteger) >= 0) {
            bigIntegerBitsToInt = bigIntegerBitsToInt.subtract(bigInteger);
        }
        int unsignedByteLength = BigIntegers.getUnsignedByteLength(bigInteger);
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(unsignedByteLength, bigInteger2);
        byte[] bArrAsUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(unsignedByteLength, bigIntegerBitsToInt);
        C6238Arrays.m18249fill(this.f20967K, (byte) 0);
        C6238Arrays.m18249fill(this.f20968V, (byte) 1);
        this.f20969hMac.mo14976init(new KeyParameter(this.f20967K));
        C5360HMac c5360HMac = this.f20969hMac;
        byte[] bArr2 = this.f20968V;
        c5360HMac.mo14979update(bArr2, 0, bArr2.length);
        this.f20969hMac.mo14978update((byte) 0);
        this.f20969hMac.mo14979update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        this.f20969hMac.mo14979update(bArrAsUnsignedByteArray2, 0, bArrAsUnsignedByteArray2.length);
        initAdditionalInput0(this.f20969hMac);
        this.f20969hMac.mo14975doFinal(this.f20967K, 0);
        this.f20969hMac.mo14976init(new KeyParameter(this.f20967K));
        C5360HMac c5360HMac2 = this.f20969hMac;
        byte[] bArr3 = this.f20968V;
        c5360HMac2.mo14979update(bArr3, 0, bArr3.length);
        this.f20969hMac.mo14975doFinal(this.f20968V, 0);
        C5360HMac c5360HMac3 = this.f20969hMac;
        byte[] bArr4 = this.f20968V;
        c5360HMac3.mo14979update(bArr4, 0, bArr4.length);
        this.f20969hMac.mo14978update((byte) 1);
        this.f20969hMac.mo14979update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        this.f20969hMac.mo14979update(bArrAsUnsignedByteArray2, 0, bArrAsUnsignedByteArray2.length);
        initAdditionalInput1(this.f20969hMac);
        this.f20969hMac.mo14975doFinal(this.f20967K, 0);
        this.f20969hMac.mo14976init(new KeyParameter(this.f20967K));
        C5360HMac c5360HMac4 = this.f20969hMac;
        byte[] bArr5 = this.f20968V;
        c5360HMac4.mo14979update(bArr5, 0, bArr5.length);
        this.f20969hMac.mo14975doFinal(this.f20968V, 0);
    }

    public void initAdditionalInput0(C5360HMac c5360HMac) {
    }

    public void initAdditionalInput1(C5360HMac c5360HMac) {
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    public boolean isDeterministic() {
        return true;
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: nextK */
    public BigInteger mo15860nextK() {
        int unsignedByteLength = BigIntegers.getUnsignedByteLength(this.f20970n);
        byte[] bArr = new byte[unsignedByteLength];
        while (true) {
            int i = 0;
            while (i < unsignedByteLength) {
                C5360HMac c5360HMac = this.f20969hMac;
                byte[] bArr2 = this.f20968V;
                c5360HMac.mo14979update(bArr2, 0, bArr2.length);
                this.f20969hMac.mo14975doFinal(this.f20968V, 0);
                int iMin = Math.min(unsignedByteLength - i, this.f20968V.length);
                System.arraycopy(this.f20968V, 0, bArr, i, iMin);
                i += iMin;
            }
            BigInteger bigIntegerBitsToInt = bitsToInt(bArr);
            if (bigIntegerBitsToInt.signum() > 0 && bigIntegerBitsToInt.compareTo(this.f20970n) < 0) {
                return bigIntegerBitsToInt;
            }
            C5360HMac c5360HMac2 = this.f20969hMac;
            byte[] bArr3 = this.f20968V;
            c5360HMac2.mo14979update(bArr3, 0, bArr3.length);
            this.f20969hMac.mo14978update((byte) 0);
            this.f20969hMac.mo14975doFinal(this.f20967K, 0);
            this.f20969hMac.mo14976init(new KeyParameter(this.f20967K));
            C5360HMac c5360HMac3 = this.f20969hMac;
            byte[] bArr4 = this.f20968V;
            c5360HMac3.mo14979update(bArr4, 0, bArr4.length);
            this.f20969hMac.mo14975doFinal(this.f20968V, 0);
        }
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: init */
    public void mo15859init(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }
}
