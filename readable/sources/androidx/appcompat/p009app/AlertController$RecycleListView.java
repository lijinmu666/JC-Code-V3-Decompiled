package androidx.appcompat.p009app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import p131o.AbstractC3407b5;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: AZxh */
    public final int f204AZxh;

    /* renamed from: mjFkc */
    public final int f205mjFkc;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12931VfB);
        this.f204AZxh = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3407b5.f12874Htq, -1);
        this.f205mjFkc = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3407b5.f12853BxruE, -1);
    }
}
