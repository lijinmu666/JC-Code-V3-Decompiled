package org.bouncycastle.p314pqc.p316crypto.p317cmce;

/* renamed from: org.bouncycastle.pqc.crypto.cmce.GF */
/* loaded from: classes2.dex */
abstract class AbstractC6054GF {
    /* renamed from: gf_frac */
    public abstract short mo17504gf_frac(short s, short s2);

    /* renamed from: gf_inv */
    public abstract short mo17505gf_inv(short s);

    public final short gf_iszero(short s) {
        return (short) ((s - 1) >> 31);
    }

    /* renamed from: gf_mul */
    public abstract short mo17506gf_mul(short s, short s2);

    public abstract int gf_mul_ext(short s, short s2);

    public abstract void gf_mul_poly(int i, int[] iArr, short[] sArr, short[] sArr2, short[] sArr3, int[] iArr2);

    public abstract short gf_reduce(int i);

    /* renamed from: gf_sq */
    public abstract short mo17507gf_sq(short s);

    public abstract int gf_sq_ext(short s);

    public abstract void gf_sqr_poly(int i, int[] iArr, short[] sArr, short[] sArr2, int[] iArr2);
}
