package p131o;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;

/* renamed from: o.s9 */
/* loaded from: classes.dex */
public abstract class AbstractC4529s9 {
    /* renamed from: AZxh */
    public static Typeface m13491AZxh(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, AbstractC2868T1.m10211AZxh(typeface.getWeight() + configuration.fontWeightAdjustment, 1, NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE), typeface.isItalic());
    }

    /* renamed from: mjFkc */
    public static Typeface m13492mjFkc(Context context, Typeface typeface) {
        return m13491AZxh(context.getResources().getConfiguration(), typeface);
    }
}
