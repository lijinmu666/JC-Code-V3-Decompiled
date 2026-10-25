package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: height */
    private final int f23650height;

    /* renamed from: value */
    private final byte[] f23651value;

    public XMSSNode(int i, byte[] bArr) {
        this.f23650height = i;
        this.f23651value = bArr;
    }

    public int getHeight() {
        return this.f23650height;
    }

    public byte[] getValue() {
        return XMSSUtil.cloneArray(this.f23651value);
    }
}
