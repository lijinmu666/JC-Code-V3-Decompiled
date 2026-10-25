package p131o;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.AbstractC1234Lambda;
import p094kotlin.p105jvm.internal.p106markers.KMutableIterator;
import p094kotlin.sequences.Sequence;

/* renamed from: o.aa */
/* loaded from: classes.dex */
public abstract class AbstractC3371aa {

    /* renamed from: o.aa$AZxh */
    public static final class AZxh extends AbstractC1234Lambda implements Function1 {

        /* renamed from: mjFkc */
        public static final AZxh f12767mjFkc = new AZxh();

        public AZxh() {
            super(1);
        }

        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public final Iterator mo2237invoke(View view) {
            Sequence sequenceM11325mjFkc;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup == null || (sequenceM11325mjFkc = AbstractC3371aa.m11325mjFkc(viewGroup)) == null) {
                return null;
            }
            return sequenceM11325mjFkc.iterator();
        }
    }

    /* renamed from: o.aa$ZfxDd */
    public static final class ZfxDd implements Sequence {

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f12768mjFkc;

        public ZfxDd(ViewGroup viewGroup) {
            this.f12768mjFkc = viewGroup;
        }

        @Override // p094kotlin.sequences.Sequence
        public Iterator iterator() {
            return new C3805h9(AbstractC3371aa.m11325mjFkc(this.f12768mjFkc).iterator(), AZxh.f12767mjFkc);
        }
    }

    /* renamed from: o.aa$mjFkc */
    public static final class mjFkc implements Sequence {

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f12769mjFkc;

        public mjFkc(ViewGroup viewGroup) {
            this.f12769mjFkc = viewGroup;
        }

        @Override // p094kotlin.sequences.Sequence
        public Iterator iterator() {
            return AbstractC3371aa.m11326wA(this.f12769mjFkc);
        }
    }

    /* renamed from: o.aa$wA */
    public static final class wA implements Iterator, KMutableIterator {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewGroup f12770AZxh;

        /* renamed from: mjFkc */
        public int f12771mjFkc;

        public wA(ViewGroup viewGroup) {
            this.f12770AZxh = viewGroup;
        }

        @Override // java.util.Iterator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f12770AZxh;
            int i = this.f12771mjFkc;
            this.f12771mjFkc = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12771mjFkc < this.f12770AZxh.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f12770AZxh;
            int i = this.f12771mjFkc - 1;
            this.f12771mjFkc = i;
            viewGroup.removeViewAt(i);
        }
    }

    /* renamed from: AZxh */
    public static final Sequence m11324AZxh(ViewGroup viewGroup) {
        return new ZfxDd(viewGroup);
    }

    /* renamed from: mjFkc */
    public static final Sequence m11325mjFkc(ViewGroup viewGroup) {
        return new mjFkc(viewGroup);
    }

    /* renamed from: wA */
    public static final Iterator m11326wA(ViewGroup viewGroup) {
        return new wA(viewGroup);
    }
}
