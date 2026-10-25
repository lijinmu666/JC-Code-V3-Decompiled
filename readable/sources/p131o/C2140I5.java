package p131o;

/* renamed from: o.I5 */
/* loaded from: classes.dex */
public class C2140I5 {

    /* renamed from: mjFkc */
    public int f8684mjFkc = 0;

    /* renamed from: AZxh */
    public int f8679AZxh = 0;

    /* renamed from: wA */
    public int f8685wA = Integer.MIN_VALUE;

    /* renamed from: ZfxDd */
    public int f8682ZfxDd = Integer.MIN_VALUE;

    /* renamed from: KLFTb */
    public int f8681KLFTb = 0;

    /* renamed from: JHa */
    public int f8680JHa = 0;

    /* renamed from: xJ */
    public boolean f8686xJ = false;

    /* renamed from: lgHUyS */
    public boolean f8683lgHUyS = false;

    /* renamed from: AZxh */
    public int m8649AZxh() {
        return this.f8684mjFkc;
    }

    /* renamed from: JHa */
    public void m8650JHa(boolean z) {
        if (z == this.f8686xJ) {
            return;
        }
        this.f8686xJ = z;
        if (!this.f8683lgHUyS) {
            this.f8684mjFkc = this.f8681KLFTb;
            this.f8679AZxh = this.f8680JHa;
            return;
        }
        if (z) {
            int i = this.f8682ZfxDd;
            if (i == Integer.MIN_VALUE) {
                i = this.f8681KLFTb;
            }
            this.f8684mjFkc = i;
            int i2 = this.f8685wA;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f8680JHa;
            }
            this.f8679AZxh = i2;
            return;
        }
        int i3 = this.f8685wA;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f8681KLFTb;
        }
        this.f8684mjFkc = i3;
        int i4 = this.f8682ZfxDd;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f8680JHa;
        }
        this.f8679AZxh = i4;
    }

    /* renamed from: KLFTb */
    public void m8651KLFTb(int i, int i2) {
        this.f8683lgHUyS = false;
        if (i != Integer.MIN_VALUE) {
            this.f8681KLFTb = i;
            this.f8684mjFkc = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f8680JHa = i2;
            this.f8679AZxh = i2;
        }
    }

    /* renamed from: ZfxDd */
    public int m8652ZfxDd() {
        return this.f8686xJ ? this.f8679AZxh : this.f8684mjFkc;
    }

    /* renamed from: mjFkc */
    public int m8653mjFkc() {
        return this.f8686xJ ? this.f8684mjFkc : this.f8679AZxh;
    }

    /* renamed from: wA */
    public int m8654wA() {
        return this.f8679AZxh;
    }

    /* renamed from: xJ */
    public void m8655xJ(int i, int i2) {
        this.f8685wA = i;
        this.f8682ZfxDd = i2;
        this.f8683lgHUyS = true;
        if (this.f8686xJ) {
            if (i2 != Integer.MIN_VALUE) {
                this.f8684mjFkc = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f8679AZxh = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f8684mjFkc = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f8679AZxh = i2;
        }
    }
}
