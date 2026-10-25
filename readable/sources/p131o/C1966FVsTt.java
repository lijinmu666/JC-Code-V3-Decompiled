package p131o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* renamed from: o.FVsTt */
/* loaded from: classes.dex */
public class C1966FVsTt extends ContextWrapper {

    /* renamed from: JHa */
    public static Configuration f8203JHa;

    /* renamed from: AZxh */
    public Resources.Theme f8204AZxh;

    /* renamed from: KLFTb */
    public Resources f8205KLFTb;

    /* renamed from: ZfxDd */
    public Configuration f8206ZfxDd;

    /* renamed from: mjFkc */
    public int f8207mjFkc;

    /* renamed from: wA */
    public LayoutInflater f8208wA;

    /* renamed from: o.FVsTt$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static Context m8305mjFkc(C1966FVsTt c1966FVsTt, Configuration configuration) {
            return c1966FVsTt.createConfigurationContext(configuration);
        }
    }

    public C1966FVsTt(Context context, int i) {
        super(context);
        this.f8207mjFkc = i;
    }

    /* renamed from: ZfxDd */
    public static boolean m8300ZfxDd(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f8203JHa == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f8203JHa = configuration2;
        }
        return configuration.equals(f8203JHa);
    }

    /* renamed from: AZxh */
    public int m8301AZxh() {
        return this.f8207mjFkc;
    }

    /* renamed from: KLFTb */
    public void m8302KLFTb(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m8303mjFkc();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f8208wA == null) {
            this.f8208wA = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f8208wA;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f8204AZxh;
        if (theme != null) {
            return theme;
        }
        if (this.f8207mjFkc == 0) {
            this.f8207mjFkc = AbstractC2871T4.f10639mjFkc;
        }
        m8304wA();
        return this.f8204AZxh;
    }

    /* renamed from: mjFkc */
    public final Resources m8303mjFkc() {
        if (this.f8205KLFTb == null) {
            Configuration configuration = this.f8206ZfxDd;
            if (configuration == null || m8300ZfxDd(configuration)) {
                this.f8205KLFTb = super.getResources();
            } else {
                this.f8205KLFTb = mjFkc.m8305mjFkc(this, this.f8206ZfxDd).getResources();
            }
        }
        return this.f8205KLFTb;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f8207mjFkc != i) {
            this.f8207mjFkc = i;
            m8304wA();
        }
    }

    /* renamed from: wA */
    public final void m8304wA() {
        boolean z = this.f8204AZxh == null;
        if (z) {
            this.f8204AZxh = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f8204AZxh.setTo(theme);
            }
        }
        m8302KLFTb(this.f8204AZxh, this.f8207mjFkc, z);
    }
}
