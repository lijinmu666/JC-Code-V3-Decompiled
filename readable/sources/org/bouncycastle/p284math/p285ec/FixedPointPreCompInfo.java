package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public class FixedPointPreCompInfo implements PreCompInfo {

    /* renamed from: offset */
    protected AbstractC5820ECPoint f22129offset = null;
    protected ECLookupTable lookupTable = null;

    /* renamed from: width */
    protected int f22130width = -1;

    public ECLookupTable getLookupTable() {
        return this.lookupTable;
    }

    public AbstractC5820ECPoint getOffset() {
        return this.f22129offset;
    }

    public int getWidth() {
        return this.f22130width;
    }

    public void setLookupTable(ECLookupTable eCLookupTable) {
        this.lookupTable = eCLookupTable;
    }

    public void setOffset(AbstractC5820ECPoint abstractC5820ECPoint) {
        this.f22129offset = abstractC5820ECPoint;
    }

    public void setWidth(int i) {
        this.f22130width = i;
    }
}
