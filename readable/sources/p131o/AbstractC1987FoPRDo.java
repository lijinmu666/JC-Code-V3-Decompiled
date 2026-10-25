package p131o;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import p131o.C2542O1;

/* renamed from: o.FoPRDo */
/* loaded from: classes.dex */
public abstract class AbstractC1987FoPRDo extends C2542O1 {

    /* renamed from: vI */
    public AZxh f8254vI;

    /* renamed from: o.FoPRDo$wA */
    public static class wA extends AbstractC1987FoPRDo {
        public wA(AZxh aZxh) {
            super(aZxh);
        }

        @Override // p131o.C2542O1
        /* renamed from: IEE */
        public void mo8330IEE(Canvas canvas) {
            if (this.f8254vI.f8255huTpC.isEmpty()) {
                super.mo8330IEE(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.f8254vI.f8255huTpC);
            super.mo8330IEE(canvas);
            canvas.restore();
        }
    }

    /* renamed from: dm */
    public static AbstractC1987FoPRDo m8323dm(AZxh aZxh) {
        return new wA(aZxh);
    }

    /* renamed from: tQ */
    public static AbstractC1987FoPRDo m8324tQ(C2141I6 c2141i6) {
        if (c2141i6 == null) {
            c2141i6 = new C2141I6();
        }
        return m8323dm(new AZxh(c2141i6, new RectF()));
    }

    /* renamed from: IVlxe */
    public void m8325IVlxe(RectF rectF) {
        m8327xROA(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // p131o.C2542O1, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f8254vI = new AZxh(this.f8254vI);
        return this;
    }

    /* renamed from: vjlshU */
    public void m8326vjlshU() {
        m8327xROA(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: xROA */
    public void m8327xROA(float f, float f2, float f3, float f4) {
        if (f == this.f8254vI.f8255huTpC.left && f2 == this.f8254vI.f8255huTpC.top && f3 == this.f8254vI.f8255huTpC.right && f4 == this.f8254vI.f8255huTpC.bottom) {
            return;
        }
        this.f8254vI.f8255huTpC.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* renamed from: yfx */
    public boolean m8328yfx() {
        return !this.f8254vI.f8255huTpC.isEmpty();
    }

    /* renamed from: o.FoPRDo$AZxh */
    public static final class AZxh extends C2542O1.wA {

        /* renamed from: huTpC */
        public final RectF f8255huTpC;

        @Override // p131o.C2542O1.wA, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AbstractC1987FoPRDo abstractC1987FoPRDoM8323dm = AbstractC1987FoPRDo.m8323dm(this);
            abstractC1987FoPRDoM8323dm.invalidateSelf();
            return abstractC1987FoPRDoM8323dm;
        }

        public AZxh(C2141I6 c2141i6, RectF rectF) {
            super(c2141i6, null);
            this.f8255huTpC = rectF;
        }

        public AZxh(AZxh aZxh) {
            super(aZxh);
            this.f8255huTpC = aZxh.f8255huTpC;
        }
    }

    public AbstractC1987FoPRDo(AZxh aZxh) {
        super(aZxh);
        this.f8254vI = aZxh;
    }
}
