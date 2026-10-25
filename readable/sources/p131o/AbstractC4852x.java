package p131o;

import java.util.Arrays;

/* renamed from: o.x */
/* loaded from: classes.dex */
public abstract class AbstractC4852x extends C3776gjvQ implements InterfaceC4718v {

    /* renamed from: tjSezt */
    public C3776gjvQ[] f17300tjSezt = new C3776gjvQ[4];

    /* renamed from: yX */
    public int f17301yX = 0;

    @Override // p131o.InterfaceC4718v
    /* renamed from: AZxh */
    public void mo13741AZxh(C3776gjvQ c3776gjvQ) {
        if (c3776gjvQ == this || c3776gjvQ == null) {
            return;
        }
        int i = this.f17301yX + 1;
        C3776gjvQ[] c3776gjvQArr = this.f17300tjSezt;
        if (i > c3776gjvQArr.length) {
            this.f17300tjSezt = (C3776gjvQ[]) Arrays.copyOf(c3776gjvQArr, c3776gjvQArr.length * 2);
        }
        C3776gjvQ[] c3776gjvQArr2 = this.f17300tjSezt;
        int i2 = this.f17301yX;
        c3776gjvQArr2[i2] = c3776gjvQ;
        this.f17301yX = i2 + 1;
    }

    /* renamed from: mjFkc */
    public void mo8019mjFkc(C4052kw c4052kw) {
    }

    @Override // p131o.InterfaceC4718v
    /* renamed from: wA */
    public void mo13742wA() {
        this.f17301yX = 0;
        Arrays.fill(this.f17300tjSezt, (Object) null);
    }
}
