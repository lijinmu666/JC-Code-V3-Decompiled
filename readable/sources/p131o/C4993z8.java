package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: o.z8 */
/* loaded from: classes.dex */
public class C4993z8 extends AbstractC4791w5 {

    /* renamed from: AZxh */
    public final WeakReference f17636AZxh;

    public C4993z8(Context context, Resources resources) {
        super(resources);
        this.f17636AZxh = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawableM13817mjFkc = m13817mjFkc(i);
        Context context = (Context) this.f17636AZxh.get();
        if (drawableM13817mjFkc != null && context != null) {
            C4525s5.m13462xJ().m13469Ucbh(context, i, drawableM13817mjFkc);
        }
        return drawableM13817mjFkc;
    }
}
