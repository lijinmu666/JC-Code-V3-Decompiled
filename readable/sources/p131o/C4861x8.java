package p131o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: o.x8 */
/* loaded from: classes.dex */
public class C4861x8 extends ContextWrapper {

    /* renamed from: ZfxDd */
    public static ArrayList f17325ZfxDd;

    /* renamed from: wA */
    public static final Object f17326wA = new Object();

    /* renamed from: AZxh */
    public final Resources.Theme f17327AZxh;

    /* renamed from: mjFkc */
    public final Resources f17328mjFkc;

    public C4861x8(Context context) {
        super(context);
        if (!C2353L9.m9360wA()) {
            this.f17328mjFkc = new C4993z8(this, context.getResources());
            this.f17327AZxh = null;
            return;
        }
        C2353L9 c2353l9 = new C2353L9(this, context.getResources());
        this.f17328mjFkc = c2353l9;
        Resources.Theme themeNewTheme = c2353l9.newTheme();
        this.f17327AZxh = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    /* renamed from: AZxh */
    public static Context m13900AZxh(Context context) {
        if (!m13901mjFkc(context)) {
            return context;
        }
        synchronized (f17326wA) {
            try {
                ArrayList arrayList = f17325ZfxDd;
                if (arrayList == null) {
                    f17325ZfxDd = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f17325ZfxDd.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f17325ZfxDd.remove(size);
                        }
                    }
                    for (int size2 = f17325ZfxDd.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f17325ZfxDd.get(size2);
                        C4861x8 c4861x8 = weakReference2 != null ? (C4861x8) weakReference2.get() : null;
                        if (c4861x8 != null && c4861x8.getBaseContext() == context) {
                            return c4861x8;
                        }
                    }
                }
                C4861x8 c4861x82 = new C4861x8(context);
                f17325ZfxDd.add(new WeakReference(c4861x82));
                return c4861x82;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static boolean m13901mjFkc(Context context) {
        if ((context instanceof C4861x8) || (context.getResources() instanceof C4993z8) || (context.getResources() instanceof C2353L9)) {
            return false;
        }
        return C2353L9.m9360wA();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f17328mjFkc.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f17328mjFkc;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f17327AZxh;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f17327AZxh;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
