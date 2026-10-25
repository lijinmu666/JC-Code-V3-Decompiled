package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.SavableDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class TupleHash implements InterfaceC5284Xof, SavableDigest {
    private static final byte[] N_TUPLE_HASH = C6250Strings.toByteArray("TupleHash");
    private int bitLength;

    /* renamed from: cshake */
    private final CSHAKEDigest f19595cshake;
    private boolean firstOutput;
    private int outputLength;

    public TupleHash(int i, byte[] bArr) {
        this(i, bArr, i * 2);
    }

    /* renamed from: copyIn */
    private void m15207copyIn(TupleHash tupleHash) {
        this.f19595cshake.mo14824reset(tupleHash.f19595cshake);
        int i = this.f19595cshake.fixedOutputLength;
        this.bitLength = i;
        this.outputLength = (i * 2) / 8;
        this.firstOutput = tupleHash.firstOutput;
    }

    /* renamed from: wrapUp */
    private void m15208wrapUp(int i) {
        byte[] bArrRightEncode = XofUtils.rightEncode(i * 8);
        this.f19595cshake.mo14970update(bArrRightEncode, 0, bArrRightEncode.length);
        this.firstOutput = false;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new TupleHash(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        if (this.firstOutput) {
            m15208wrapUp(getDigestSize());
        }
        int iMo14998doFinal = this.f19595cshake.mo14998doFinal(bArr, i, getDigestSize());
        mo14968reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            m15208wrapUp(0);
        }
        return this.f19595cshake.doOutput(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "TupleHash" + this.f19595cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.f19595cshake.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        byte[] encodedState = this.f19595cshake.getEncodedState();
        byte[] bArr = new byte[9];
        AbstractC6245Pack.intToBigEndian(this.bitLength, bArr, 0);
        AbstractC6245Pack.intToBigEndian(this.outputLength, bArr, 4);
        bArr[8] = this.firstOutput;
        return C6238Arrays.concatenate(encodedState, bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19595cshake.mo14968reset();
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArrM15211encode = XofUtils.m15211encode(b);
        this.f19595cshake.mo14970update(bArrM15211encode, 0, bArrM15211encode.length);
    }

    public TupleHash(int i, byte[] bArr, int i2) {
        this.f19595cshake = new CSHAKEDigest(i, N_TUPLE_HASH, bArr);
        this.bitLength = i;
        this.outputLength = (i2 + 7) / 8;
        mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            m15208wrapUp(getDigestSize());
        }
        int iMo14998doFinal = this.f19595cshake.mo14998doFinal(bArr, i, i2);
        mo14968reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15207copyIn((TupleHash) memoable);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        byte[] bArrM15212encode = XofUtils.m15212encode(bArr, i, i2);
        this.f19595cshake.mo14970update(bArrM15212encode, 0, bArrM15212encode.length);
    }

    public TupleHash(TupleHash tupleHash) {
        this.f19595cshake = new CSHAKEDigest(tupleHash.f19595cshake);
        this.bitLength = tupleHash.bitLength;
        this.outputLength = tupleHash.outputLength;
        this.firstOutput = tupleHash.firstOutput;
    }

    public TupleHash(byte[] bArr) {
        this.f19595cshake = new CSHAKEDigest(C6238Arrays.copyOfRange(bArr, 0, bArr.length - 9));
        this.bitLength = AbstractC6245Pack.bigEndianToInt(bArr, bArr.length - 9);
        this.outputLength = AbstractC6245Pack.bigEndianToInt(bArr, bArr.length - 5);
        this.firstOutput = bArr[bArr.length - 1] != 0;
    }
}
