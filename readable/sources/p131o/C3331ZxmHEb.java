package p131o;

import java.util.Arrays;

/* renamed from: o.ZxmHEb */
/* loaded from: classes.dex */
public final class C3331ZxmHEb {

    /* renamed from: AZxh */
    public final byte[] f12262AZxh;

    /* renamed from: mjFkc */
    public final C3569dXmy f12263mjFkc;

    public C3331ZxmHEb(C3569dXmy c3569dXmy, byte[] bArr) {
        if (c3569dXmy == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f12263mjFkc = c3569dXmy;
        this.f12262AZxh = bArr;
    }

    /* renamed from: AZxh */
    public C3569dXmy m11233AZxh() {
        return this.f12263mjFkc;
    }

    /* renamed from: equals */
    public boolean m11234equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3331ZxmHEb)) {
            return false;
        }
        C3331ZxmHEb c3331ZxmHEb = (C3331ZxmHEb) obj;
        if (this.f12263mjFkc.m11729equals(c3331ZxmHEb.f12263mjFkc)) {
            return Arrays.equals(this.f12262AZxh, c3331ZxmHEb.f12262AZxh);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12262AZxh) ^ ((this.f12263mjFkc.hashCode() ^ 1000003) * 1000003);
    }

    /* renamed from: mjFkc */
    public byte[] m11235mjFkc() {
        return this.f12262AZxh;
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f12263mjFkc + ", bytes=[...]}";
    }
}
