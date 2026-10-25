package p131o;

import android.widget.ListView;

/* renamed from: o.b1 */
/* loaded from: classes.dex */
public class C3403b1 extends AbstractViewOnTouchListenerC3191XtE {

    /* renamed from: Pq */
    public final ListView f12844Pq;

    public C3403b1(ListView listView) {
        super(listView);
        this.f12844Pq = listView;
    }

    @Override // p131o.AbstractViewOnTouchListenerC3191XtE
    /* renamed from: AZxh */
    public boolean mo10960AZxh(int i) {
        ListView listView = this.f12844Pq;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // p131o.AbstractViewOnTouchListenerC3191XtE
    /* renamed from: Dt */
    public void mo10961Dt(int i, int i2) {
        this.f12844Pq.scrollListBy(i2);
    }

    @Override // p131o.AbstractViewOnTouchListenerC3191XtE
    /* renamed from: mjFkc */
    public boolean mo10974mjFkc(int i) {
        return false;
    }
}
