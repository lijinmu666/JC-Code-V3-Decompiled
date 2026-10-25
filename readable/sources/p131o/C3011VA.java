package p131o;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: o.VA */
/* loaded from: classes.dex */
public final class C3011VA extends ClickableSpan {

    /* renamed from: AZxh */
    public final C2971Ucbh f11304AZxh;

    /* renamed from: mjFkc */
    public final int f11305mjFkc;

    /* renamed from: wA */
    public final int f11306wA;

    public C3011VA(int i, C2971Ucbh c2971Ucbh, int i2) {
        this.f11305mjFkc = i;
        this.f11304AZxh = c2971Ucbh;
        this.f11306wA = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f11305mjFkc);
        this.f11304AZxh.m10596uHVRx(this.f11306wA, bundle);
    }
}
