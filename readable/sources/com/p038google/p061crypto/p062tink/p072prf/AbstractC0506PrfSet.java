package com.p038google.p061crypto.p062tink.p072prf;

import java.util.Map;

/* renamed from: com.google.crypto.tink.prf.PrfSet */
/* loaded from: classes.dex */
public abstract class AbstractC0506PrfSet {
    public byte[] computePrimary(byte[] bArr, int i) {
        return mo3553getPrfs().get(Integer.valueOf(getPrimaryId())).mo3552compute(bArr, i);
    }

    /* renamed from: getPrfs */
    public abstract Map<Integer, InterfaceC0504Prf> mo3553getPrfs();

    public abstract int getPrimaryId();
}
