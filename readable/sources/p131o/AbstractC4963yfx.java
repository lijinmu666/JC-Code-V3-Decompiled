package p131o;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import p131o.C1901EcuP;

/* renamed from: o.yfx */
/* loaded from: classes.dex */
public abstract class AbstractC4963yfx {

    /* renamed from: o.yfx$mjFkc */
    public static final class mjFkc {
        /* renamed from: AZxh */
        public static boolean m14045AZxh(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            AbstractC2876T9.m10237JrJO(view, new C1901EcuP.mjFkc(dragEvent.getClipData(), 3).m8164mjFkc());
            return true;
        }

        /* renamed from: mjFkc */
        public static boolean m14046mjFkc(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                AbstractC2876T9.m10237JrJO(textView, new C1901EcuP.mjFkc(dragEvent.getClipData(), 3).m8164mjFkc());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }
    }

    /* renamed from: AZxh */
    public static boolean m14042AZxh(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 31 || AbstractC2876T9.m10292vI(textView) == null || !(i == 16908322 || i == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            AbstractC2876T9.m10237JrJO(textView, new C1901EcuP.mjFkc(primaryClip, 1).m8165wA(i != 16908322 ? 1 : 0).m8164mjFkc());
        }
        return true;
    }

    /* renamed from: mjFkc */
    public static boolean m14043mjFkc(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && AbstractC2876T9.m10292vI(view) != null) {
            Activity activityM14044wA = m14044wA(view);
            if (activityM14044wA == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? mjFkc.m14046mjFkc(dragEvent, (TextView) view, activityM14044wA) : mjFkc.m14045AZxh(dragEvent, view, activityM14044wA);
            }
        }
        return false;
    }

    /* renamed from: wA */
    public static Activity m14044wA(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
