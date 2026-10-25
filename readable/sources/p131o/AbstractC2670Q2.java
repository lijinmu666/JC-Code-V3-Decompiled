package p131o;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* renamed from: o.Q2 */
/* loaded from: classes.dex */
public abstract class AbstractC2670Q2 {
    /* renamed from: mjFkc */
    public static ObjectAnimator m9996mjFkc(Object obj, Property property, Path path) {
        return ObjectAnimator.ofObject(obj, (Property<Object, V>) property, (TypeConverter) null, path);
    }
}
