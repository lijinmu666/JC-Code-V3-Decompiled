package org.bouncycastle.p194crypto.p200ec;

import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* renamed from: org.bouncycastle.crypto.ec.ECPair */
/* loaded from: classes2.dex */
public class C5332ECPair {

    /* renamed from: x */
    private final AbstractC5820ECPoint f19634x;

    /* renamed from: y */
    private final AbstractC5820ECPoint f19635y;

    public C5332ECPair(AbstractC5820ECPoint abstractC5820ECPoint, AbstractC5820ECPoint abstractC5820ECPoint2) {
        this.f19634x = abstractC5820ECPoint;
        this.f19635y = abstractC5820ECPoint2;
    }

    /* renamed from: equals */
    public boolean m15220equals(Object obj) {
        if (obj instanceof C5332ECPair) {
            return m15221equals((C5332ECPair) obj);
        }
        return false;
    }

    /* renamed from: getX */
    public AbstractC5820ECPoint m15222getX() {
        return this.f19634x;
    }

    /* renamed from: getY */
    public AbstractC5820ECPoint m15223getY() {
        return this.f19635y;
    }

    public int hashCode() {
        return this.f19634x.hashCode() + (this.f19635y.hashCode() * 37);
    }

    /* renamed from: equals */
    public boolean m15221equals(C5332ECPair c5332ECPair) {
        return c5332ECPair.m15222getX().m16333equals(m15222getX()) && c5332ECPair.m15223getY().m16333equals(m15223getY());
    }
}
