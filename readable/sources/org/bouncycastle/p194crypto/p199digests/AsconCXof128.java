package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class AsconCXof128 extends AsconXofBase {

    /* renamed from: z0 */
    private final long f19266z0;

    /* renamed from: z1 */
    private final long f19267z1;

    /* renamed from: z2 */
    private final long f19268z2;

    /* renamed from: z3 */
    private final long f19269z3;

    /* renamed from: z4 */
    private final long f19270z4;

    public AsconCXof128() {
        this(new byte[0], 0, 0);
    }

    private void initState(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.f19265p.m15268set(5768210384618244584L, 6623958265790276749L, 4252419465292010770L, 1238191464582506891L, 56353695744608240L);
        } else {
            this.f19265p.m15268set(7445901275803737603L, 4886737088792722364L, -1616759365661982283L, 3076320316797452470L, -8124743304765850554L);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19265p;
            asconPermutation.f19740x0 ^= i2 << 3;
            asconPermutation.m15266p(12);
            mo14970update(bArr, i, i2);
            padAndAbsorb();
        }
        super.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.InterfaceC5284Xof
    public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i, int i2) {
        return super.doOutput(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.ExtendedDigest
    public /* bridge */ /* synthetic */ int getByteLength() {
        return super.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ int getDigestSize() {
        return super.getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToLong(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    /* renamed from: pad */
    public long mo15040pad(int i) {
        return 1 << (i << 3);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19265p.m15268set(this.f19266z0, this.f19267z1, this.f19268z2, this.f19269z3, this.f19270z4);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i) {
        AbstractC6245Pack.longToLittleEndian(j, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    public AsconCXof128(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14998doFinal(byte[] bArr, int i, int i2) {
        return super.mo14998doFinal(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public long loadBytes(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return 0L;
        }
        return AbstractC6245Pack.littleEndianToLong_Low(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconBaseDigest
    public void setBytes(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            AbstractC6245Pack.longToLittleEndian_Low(j, bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.AsconXofBase, org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }

    public AsconCXof128(byte[] bArr, int i, int i2) {
        this.algorithmName = "Ascon-CXOF128";
        ensureSufficientInputBuffer(bArr, i, i2);
        if (i2 > 256) {
            throw new DataLengthException("customized string is too long");
        }
        initState(bArr, i, i2);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f19265p;
        this.f19266z0 = asconPermutation.f19740x0;
        this.f19267z1 = asconPermutation.f19741x1;
        this.f19268z2 = asconPermutation.f19742x2;
        this.f19269z3 = asconPermutation.f19743x3;
        this.f19270z4 = asconPermutation.f19744x4;
    }
}
