package p131o;

/* renamed from: o.Dx */
/* loaded from: classes.dex */
public final class C1856Dx extends AbstractC2063Gx {

    /* renamed from: JHa */
    public int f7922JHa;

    /* renamed from: KLFTb */
    public final int f7923KLFTb;

    /* renamed from: ZfxDd */
    public final byte[] f7924ZfxDd;

    public C1856Dx(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.f7924ZfxDd = bArr;
        this.f7922JHa = 0;
        this.f7923KLFTb = i2;
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: BAnRFn */
    public final void mo8066BAnRFn(int i, int i2) throws C1926Ex {
        mo8090wJVbdd((i << 3) | i2);
    }

    /* renamed from: CqaNbM */
    public final void m8067CqaNbM(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.f7924ZfxDd, this.f7922JHa, i2);
            this.f7922JHa += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), Integer.valueOf(i2)), e);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: Dt */
    public final void mo8068Dt(byte b) throws C1926Ex {
        try {
            byte[] bArr = this.f7924ZfxDd;
            int i = this.f7922JHa;
            this.f7922JHa = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), 1), e);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: ETF */
    public final void mo8069ETF(int i, boolean z) throws C1926Ex {
        mo8090wJVbdd(i << 3);
        mo8068Dt(z ? (byte) 1 : (byte) 0);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: Gd */
    public final void mo8070Gd(int i, InterfaceC2341Ky interfaceC2341Ky) throws C1926Ex {
        mo8090wJVbdd(11);
        mo8084lB(2, i);
        mo8090wJVbdd(26);
        mo8083huTpC(interfaceC2341Ky);
        mo8090wJVbdd(12);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: HGpJ */
    public final void mo8071HGpJ(int i, AbstractC4981yx abstractC4981yx) throws C1926Ex {
        mo8090wJVbdd(11);
        mo8084lB(2, i);
        mo8073MiMN(3, abstractC4981yx);
        mo8090wJVbdd(12);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: IEE */
    public final void mo8072IEE(long j) throws C1926Ex {
        try {
            byte[] bArr = this.f7924ZfxDd;
            int i = this.f7922JHa;
            int i2 = i + 1;
            this.f7922JHa = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.f7922JHa = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.f7922JHa = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.f7922JHa = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.f7922JHa = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.f7922JHa = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.f7922JHa = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f7922JHa = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), 1), e);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: MiMN */
    public final void mo8073MiMN(int i, AbstractC4981yx abstractC4981yx) throws C1926Ex {
        mo8090wJVbdd((i << 3) | 2);
        mo8079YoKzxo(abstractC4981yx);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: OjSQV */
    public final void mo8074OjSQV(long j) throws C1926Ex {
        if (!AbstractC2063Gx.f8463wA || this.f7923KLFTb - this.f7922JHa < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.f7924ZfxDd;
                    int i = this.f7922JHa;
                    this.f7922JHa = i + 1;
                    bArr[i] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), 1), e);
                }
            }
            byte[] bArr2 = this.f7924ZfxDd;
            int i2 = this.f7922JHa;
            this.f7922JHa = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while (true) {
            int i3 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.f7924ZfxDd;
                int i4 = this.f7922JHa;
                this.f7922JHa = i4 + 1;
                AbstractC4518rz.m13412Pq(bArr3, i4, (byte) i3);
                return;
            }
            byte[] bArr4 = this.f7924ZfxDd;
            int i5 = this.f7922JHa;
            this.f7922JHa = i5 + 1;
            AbstractC4518rz.m13412Pq(bArr4, i5, (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: Pq */
    public final void mo8075Pq(int i, int i2) throws C1926Ex {
        mo8090wJVbdd(i << 3);
        mo8080diqgf(i2);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: Ucbh */
    public final void mo8076Ucbh(int i, InterfaceC2341Ky interfaceC2341Ky, InterfaceC2998Uy interfaceC2998Uy) throws C1926Ex {
        mo8090wJVbdd((i << 3) | 2);
        mo8090wJVbdd(((AbstractC3657ex) interfaceC2341Ky).mo11769qdMbNW(interfaceC2998Uy));
        interfaceC2998Uy.mo9771qdMbNW(interfaceC2341Ky, this.f8464mjFkc);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: VA */
    public final void mo8077VA(byte[] bArr, int i, int i2) throws C1926Ex {
        mo8090wJVbdd(i2);
        m8067CqaNbM(bArr, 0, i2);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: VocHEe */
    public final void mo8078VocHEe(String str) throws C1926Ex {
        int i = this.f7922JHa;
        try {
            int iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(str.length() * 3);
            int iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(str.length());
            if (iM8470ZfxDd2 != iM8470ZfxDd) {
                mo8090wJVbdd(AbstractC4717uz.m13740wA(str));
                byte[] bArr = this.f7924ZfxDd;
                int i2 = this.f7922JHa;
                this.f7922JHa = AbstractC4717uz.m13737AZxh(str, bArr, i2, this.f7923KLFTb - i2);
                return;
            }
            int i3 = i + iM8470ZfxDd2;
            this.f7922JHa = i3;
            int iM13737AZxh = AbstractC4717uz.m13737AZxh(str, this.f7924ZfxDd, i3, this.f7923KLFTb - i3);
            this.f7922JHa = i;
            mo8090wJVbdd((iM13737AZxh - i) - iM8470ZfxDd2);
            this.f7922JHa = iM13737AZxh;
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(e);
        } catch (C4652tz e2) {
            this.f7922JHa = i;
            m8475xJ(str, e2);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: YoKzxo */
    public final void mo8079YoKzxo(AbstractC4981yx abstractC4981yx) throws C1926Ex {
        mo8090wJVbdd(abstractC4981yx.mo13326JHa());
        abstractC4981yx.mo13975qdMbNW(this);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: diqgf */
    public final void mo8080diqgf(int i) throws C1926Ex {
        if (i >= 0) {
            mo8090wJVbdd(i);
        } else {
            mo8074OjSQV(i);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: eyqo */
    public final void mo8081eyqo(byte[] bArr, int i, int i2) {
        m8067CqaNbM(bArr, 0, i2);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: fehf */
    public final void mo8082fehf(int i, long j) throws C1926Ex {
        mo8090wJVbdd((i << 3) | 1);
        mo8072IEE(j);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: huTpC */
    public final void mo8083huTpC(InterfaceC2341Ky interfaceC2341Ky) throws C1926Ex {
        mo8090wJVbdd(interfaceC2341Ky.mo9296mjFkc());
        interfaceC2341Ky.mo9293AZxh(this);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: lB */
    public final void mo8084lB(int i, int i2) throws C1926Ex {
        mo8090wJVbdd(i << 3);
        mo8090wJVbdd(i2);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: mByQ */
    public final void mo8085mByQ(int i, long j) throws C1926Ex {
        mo8090wJVbdd(i << 3);
        mo8074OjSQV(j);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: qGY */
    public final void mo8086qGY(int i) throws C1926Ex {
        try {
            byte[] bArr = this.f7924ZfxDd;
            int i2 = this.f7922JHa;
            int i3 = i2 + 1;
            this.f7922JHa = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.f7922JHa = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.f7922JHa = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f7922JHa = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), 1), e);
        }
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: qdMbNW */
    public final int mo8087qdMbNW() {
        return this.f7923KLFTb - this.f7922JHa;
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: rkYL */
    public final void mo8088rkYL(int i, int i2) throws C1926Ex {
        mo8090wJVbdd((i << 3) | 5);
        mo8086qGY(i2);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: vI */
    public final void mo8089vI(int i, String str) throws C1926Ex {
        mo8090wJVbdd((i << 3) | 2);
        mo8078VocHEe(str);
    }

    @Override // p131o.AbstractC2063Gx
    /* renamed from: wJVbdd */
    public final void mo8090wJVbdd(int i) throws C1926Ex {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.f7924ZfxDd;
                int i2 = this.f7922JHa;
                this.f7922JHa = i2 + 1;
                bArr[i2] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new C1926Ex(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7922JHa), Integer.valueOf(this.f7923KLFTb), 1), e);
            }
        }
        byte[] bArr2 = this.f7924ZfxDd;
        int i3 = this.f7922JHa;
        this.f7922JHa = i3 + 1;
        bArr2[i3] = (byte) i;
    }
}
