package p131o;

import sun.misc.Unsafe;

/* renamed from: o.pz */
/* loaded from: classes.dex */
public final class C4383pz extends AbstractC4452qz {
    public C4383pz(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: AZxh */
    public final float mo13050AZxh(Object obj, long j) {
        return Float.intBitsToFloat(this.f16272mjFkc.getInt(obj, j));
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: JHa */
    public final void mo13051JHa(Object obj, long j, float f) {
        this.f16272mjFkc.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: KLFTb */
    public final void mo13052KLFTb(Object obj, long j, double d) {
        this.f16272mjFkc.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: ZfxDd */
    public final void mo13053ZfxDd(Object obj, long j, byte b) {
        if (AbstractC4518rz.f16403lgHUyS) {
            AbstractC4518rz.m13417ZfxDd(obj, j, b);
        } else {
            AbstractC4518rz.m13410KLFTb(obj, j, b);
        }
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: mjFkc */
    public final double mo13054mjFkc(Object obj, long j) {
        return Double.longBitsToDouble(this.f16272mjFkc.getLong(obj, j));
    }

    /* JADX WARN: Failed to inline method: o.rz.YoKzxo(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: o.rz.rkYL(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: o.rz.YoKzxo(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: o.rz.rkYL(java.lang.Object, long, boolean):void */
    @Override // p131o.AbstractC4452qz
    /* renamed from: wA */
    public final void mo13055wA(Object obj, long j, boolean z) {
        if (AbstractC4518rz.f16403lgHUyS) {
            AbstractC4518rz.m13416YoKzxo(obj, j, z);
        } else {
            AbstractC4518rz.m13428rkYL(obj, j, z);
        }
    }

    @Override // p131o.AbstractC4452qz
    /* renamed from: xJ */
    public final boolean mo13056xJ(Object obj, long j) {
        return AbstractC4518rz.f16403lgHUyS ? AbstractC4518rz.m13407HGpJ(obj, j) : AbstractC4518rz.m13429vI(obj, j);
    }
}
