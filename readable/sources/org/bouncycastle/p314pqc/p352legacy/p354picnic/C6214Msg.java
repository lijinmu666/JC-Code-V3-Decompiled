package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.lang.reflect.Array;

/* renamed from: org.bouncycastle.pqc.legacy.picnic.Msg */
/* loaded from: classes2.dex */
class C6214Msg {

    /* renamed from: msgs */
    byte[][] f23968msgs;

    /* renamed from: pos */
    int f23969pos = 0;
    int unopened = -1;

    public C6214Msg(PicnicEngine picnicEngine) {
        this.f23968msgs = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, picnicEngine.numMPCParties, picnicEngine.andSizeBytes);
    }
}
