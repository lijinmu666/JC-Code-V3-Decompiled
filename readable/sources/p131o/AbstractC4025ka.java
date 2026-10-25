package p131o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;

/* renamed from: o.ka */
/* loaded from: classes.dex */
public abstract class AbstractC4025ka extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: AZxh */
    public int f14544AZxh;

    /* renamed from: mjFkc */
    public C4092la f14545mjFkc;

    /* renamed from: wA */
    public int f14546wA;

    public AbstractC4025ka() {
        this.f14544AZxh = 0;
        this.f14546wA = 0;
    }

    /* renamed from: OjSQV */
    public void mo12548OjSQV(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.m462Ne(view, i);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        mo12548OjSQV(coordinatorLayout, view, i);
        if (this.f14545mjFkc == null) {
            this.f14545mjFkc = new C4092la(view);
        }
        this.f14545mjFkc.m12699wA();
        this.f14545mjFkc.m12698mjFkc();
        int i2 = this.f14544AZxh;
        if (i2 != 0) {
            this.f14545mjFkc.m12696KLFTb(i2);
            this.f14544AZxh = 0;
        }
        int i3 = this.f14546wA;
        if (i3 == 0) {
            return true;
        }
        this.f14545mjFkc.m12697ZfxDd(i3);
        this.f14546wA = 0;
        return true;
    }

    /* renamed from: mByQ */
    public int mo2449mByQ() {
        C4092la c4092la = this.f14545mjFkc;
        if (c4092la != null) {
            return c4092la.m12695AZxh();
        }
        return 0;
    }

    public AbstractC4025ka(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14544AZxh = 0;
        this.f14546wA = 0;
    }
}
