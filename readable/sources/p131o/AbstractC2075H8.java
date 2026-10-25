package p131o;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.p012widget.C0044Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: o.H8 */
/* loaded from: classes.dex */
public abstract class AbstractC2075H8 {

    /* renamed from: mjFkc */
    public static final Comparator f8545mjFkc = new mjFkc();

    /* renamed from: o.H8$mjFkc */
    public class mjFkc implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    /* renamed from: AZxh */
    public static ImageView m8517AZxh(C0044Toolbar c0044Toolbar) {
        return m8520mjFkc(c0044Toolbar, c0044Toolbar.m302getLogo());
    }

    /* renamed from: KLFTb */
    public static TextView m8518KLFTb(C0044Toolbar c0044Toolbar) {
        List listM8519ZfxDd = m8519ZfxDd(c0044Toolbar, c0044Toolbar.getTitle());
        if (listM8519ZfxDd.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(listM8519ZfxDd, f8545mjFkc);
    }

    /* renamed from: ZfxDd */
    public static List m8519ZfxDd(C0044Toolbar c0044Toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0044Toolbar.getChildCount(); i++) {
            View childAt = c0044Toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: mjFkc */
    public static ImageView m8520mjFkc(C0044Toolbar c0044Toolbar, Drawable drawable) {
        ImageView imageView;
        Drawable drawable2;
        if (drawable == null) {
            return null;
        }
        for (int i = 0; i < c0044Toolbar.getChildCount(); i++) {
            View childAt = c0044Toolbar.getChildAt(i);
            if ((childAt instanceof ImageView) && (drawable2 = (imageView = (ImageView) childAt).getDrawable()) != null && drawable2.getConstantState() != null && drawable2.getConstantState().equals(drawable.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    /* renamed from: wA */
    public static TextView m8521wA(C0044Toolbar c0044Toolbar) {
        List listM8519ZfxDd = m8519ZfxDd(c0044Toolbar, c0044Toolbar.getSubtitle());
        if (listM8519ZfxDd.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(listM8519ZfxDd, f8545mjFkc);
    }
}
