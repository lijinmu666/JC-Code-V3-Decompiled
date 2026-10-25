package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class SimpleLookupTable extends AbstractECLookupTable {

    /* renamed from: points */
    private final AbstractC5820ECPoint[] f22142points;

    public SimpleLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, int i2) {
        this.f22142points = m16370copy(abstractC5820ECPointArr, i, i2);
    }

    /* renamed from: copy */
    private static AbstractC5820ECPoint[] m16370copy(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, int i2) {
        AbstractC5820ECPoint[] abstractC5820ECPointArr2 = new AbstractC5820ECPoint[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            abstractC5820ECPointArr2[i3] = abstractC5820ECPointArr[i + i3];
        }
        return abstractC5820ECPointArr2;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
    /* renamed from: getSize */
    public int mo16300getSize() {
        return this.f22142points.length;
    }

    @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
    /* renamed from: lookup */
    public AbstractC5820ECPoint mo16301lookup(int i) {
        throw new UnsupportedOperationException("Constant-time lookup not supported");
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
    public AbstractC5820ECPoint lookupVar(int i) {
        return this.f22142points[i];
    }
}
