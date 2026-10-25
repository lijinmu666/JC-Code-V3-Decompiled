package org.bouncycastle.p191cms;

import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public abstract class RecipientId implements Selector {

    /* renamed from: kek */
    public static final int f19033kek = 1;

    /* renamed from: kem */
    public static final int f19034kem = 4;
    public static final int keyAgree = 2;
    public static final int keyTrans = 0;
    public static final int password = 3;

    /* renamed from: type */
    private final int f19035type;

    public RecipientId(int i) {
        this.f19035type = i;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public abstract Object mo14740clone();

    /* renamed from: getType */
    public int m14891getType() {
        return this.f19035type;
    }
}
