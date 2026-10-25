package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
public abstract class AbstractECLookupTable implements ECLookupTable {
    @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
    public AbstractC5820ECPoint lookupVar(int i) {
        return mo16301lookup(i);
    }
}
