package androidx.appcompat.p010view.p011menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2545O4;
import p131o.AbstractC4133mByQ;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4768vjlshU;
import p131o.InterfaceMenuItemC4860x7;

/* renamed from: androidx.appcompat.view.menu.KLFTb */
/* loaded from: classes.dex */
public final class C0006KLFTb implements InterfaceMenuItemC4860x7 {

    /* renamed from: AZxh */
    public final int f273AZxh;

    /* renamed from: BAnRFn */
    public MenuItem.OnActionExpandListener f274BAnRFn;

    /* renamed from: Dt */
    public char f275Dt;

    /* renamed from: IEE */
    public CharSequence f279IEE;

    /* renamed from: JHa */
    public CharSequence f280JHa;

    /* renamed from: KLFTb */
    public CharSequence f281KLFTb;

    /* renamed from: Pq */
    public CharSequence f283Pq;

    /* renamed from: VA */
    public Drawable f285VA;

    /* renamed from: VocHEe */
    public View f286VocHEe;

    /* renamed from: YoKzxo */
    public C0007ZfxDd f287YoKzxo;

    /* renamed from: ZfxDd */
    public final int f288ZfxDd;

    /* renamed from: fehf */
    public MenuItem.OnMenuItemClickListener f291fehf;

    /* renamed from: lgHUyS */
    public char f294lgHUyS;

    /* renamed from: mjFkc */
    public final int f295mjFkc;

    /* renamed from: qGY */
    public Runnable f296qGY;

    /* renamed from: rkYL */
    public SubMenuC0004Dt f298rkYL;

    /* renamed from: vI */
    public int f299vI;

    /* renamed from: wA */
    public final int f300wA;

    /* renamed from: wJVbdd */
    public ContextMenu.ContextMenuInfo f301wJVbdd;

    /* renamed from: xJ */
    public Intent f302xJ;

    /* renamed from: qdMbNW */
    public int f297qdMbNW = 4096;

    /* renamed from: ETF */
    public int f276ETF = 4096;

    /* renamed from: MiMN */
    public int f282MiMN = 0;

    /* renamed from: diqgf */
    public ColorStateList f289diqgf = null;

    /* renamed from: eyqo */
    public PorterDuff.Mode f290eyqo = null;

    /* renamed from: Ucbh */
    public boolean f284Ucbh = false;

    /* renamed from: huTpC */
    public boolean f292huTpC = false;

    /* renamed from: Gd */
    public boolean f277Gd = false;

    /* renamed from: HGpJ */
    public int f278HGpJ = 16;

    /* renamed from: lB */
    public boolean f293lB = false;

    public C0006KLFTb(C0007ZfxDd c0007ZfxDd, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f287YoKzxo = c0007ZfxDd;
        this.f295mjFkc = i2;
        this.f273AZxh = i;
        this.f300wA = i3;
        this.f288ZfxDd = i4;
        this.f281KLFTb = charSequence;
        this.f299vI = i5;
    }

    /* renamed from: AZxh */
    public static void m71AZxh(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: Dt */
    public boolean m72Dt() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f291fehf;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        C0007ZfxDd c0007ZfxDd = this.f287YoKzxo;
        if (c0007ZfxDd.mo54xJ(c0007ZfxDd, this)) {
            return true;
        }
        Runnable runnable = this.f296qGY;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f302xJ == null) {
            return false;
        }
        try {
            this.f287YoKzxo.m119Pq().startActivity(this.f302xJ);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            return false;
        }
    }

    /* renamed from: ETF */
    public boolean m73ETF() {
        return (this.f278HGpJ & 32) == 32;
    }

    /* renamed from: Gd */
    public boolean m74Gd(boolean z) {
        int i = this.f278HGpJ;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.f278HGpJ = i2;
        return i != i2;
    }

    /* renamed from: HGpJ */
    public boolean m75HGpJ() {
        return this.f287YoKzxo.m131huTpC();
    }

    /* renamed from: IEE */
    public void m76IEE(boolean z) {
        int i = this.f278HGpJ;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.f278HGpJ = i2;
        if (i != i2) {
            this.f287YoKzxo.m117Ne(false);
        }
    }

    /* renamed from: JHa */
    public String m77JHa() {
        char cM78KLFTb = m78KLFTb();
        if (cM78KLFTb == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        Resources resources = this.f287YoKzxo.m119Pq().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f287YoKzxo.m119Pq()).hasPermanentMenuKey()) {
            sb.append(resources.getString(AbstractC2545O4.f9906ETF));
        }
        int i = this.f287YoKzxo.mo51lB() ? this.f276ETF : this.f297qdMbNW;
        m71AZxh(sb, i, PKIFailureInfo.notAuthorized, resources.getString(AbstractC2545O4.f9915xJ));
        m71AZxh(sb, i, 4096, resources.getString(AbstractC2545O4.f9914wA));
        m71AZxh(sb, i, 2, resources.getString(AbstractC2545O4.f9904AZxh));
        m71AZxh(sb, i, 1, resources.getString(AbstractC2545O4.f9911lgHUyS));
        m71AZxh(sb, i, 4, resources.getString(AbstractC2545O4.f9905Dt));
        m71AZxh(sb, i, 8, resources.getString(AbstractC2545O4.f9907JHa));
        if (cM78KLFTb == '\b') {
            sb.append(resources.getString(AbstractC2545O4.f9910ZfxDd));
        } else if (cM78KLFTb == '\n') {
            sb.append(resources.getString(AbstractC2545O4.f9908KLFTb));
        } else if (cM78KLFTb != ' ') {
            sb.append(cM78KLFTb);
        } else {
            sb.append(resources.getString(AbstractC2545O4.f9913qdMbNW));
        }
        return sb.toString();
    }

    /* renamed from: KLFTb */
    public char m78KLFTb() {
        return this.f287YoKzxo.mo51lB() ? this.f275Dt : this.f294lgHUyS;
    }

    /* renamed from: MiMN */
    public boolean m79MiMN() {
        return (this.f299vI & 1) == 1;
    }

    /* renamed from: Pq */
    public void m80Pq(boolean z) {
        this.f278HGpJ = (z ? 4 : 0) | (this.f278HGpJ & (-5));
    }

    @Override // android.view.MenuItem
    /* renamed from: Ucbh, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    /* renamed from: VA */
    public boolean m82VA() {
        return (this.f278HGpJ & 4) != 0;
    }

    /* renamed from: VocHEe */
    public boolean m83VocHEe() {
        return (this.f299vI & 4) == 4;
    }

    /* renamed from: YoKzxo */
    public boolean m84YoKzxo() {
        return (this.f299vI & 2) == 2;
    }

    /* renamed from: ZfxDd */
    public int m85ZfxDd() {
        return this.f288ZfxDd;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f299vI & 8) == 0) {
            return false;
        }
        if (this.f286VocHEe == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f274BAnRFn;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f287YoKzxo.mo49KLFTb(this);
        }
        return false;
    }

    /* renamed from: diqgf */
    public void m86diqgf(boolean z) {
        if (z) {
            this.f278HGpJ |= 32;
        } else {
            this.f278HGpJ &= -33;
        }
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        if (!m93qdMbNW()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f274BAnRFn;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f287YoKzxo.mo47Dt(this);
        }
        return false;
    }

    /* renamed from: eyqo */
    public void m87eyqo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f301wJVbdd = contextMenuInfo;
    }

    /* renamed from: fehf */
    public void m88fehf(boolean z) {
        this.f293lB = z;
        this.f287YoKzxo.m117Ne(false);
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.f286VocHEe;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f276ETF;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f275Dt;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f279IEE;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f273AZxh;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f285VA;
        if (drawable != null) {
            return m96wA(drawable);
        }
        if (this.f282MiMN == 0) {
            return null;
        }
        Drawable drawableM13794AZxh = AbstractC4768vjlshU.m13794AZxh(this.f287YoKzxo.m119Pq(), this.f282MiMN);
        this.f282MiMN = 0;
        this.f285VA = drawableM13794AZxh;
        return m96wA(drawableM13794AZxh);
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f289diqgf;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f290eyqo;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f302xJ;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f295mjFkc;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f301wJVbdd;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f297qdMbNW;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f294lgHUyS;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f300wA;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f298rkYL;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f281KLFTb;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f280JHa;
        return charSequence != null ? charSequence : this.f281KLFTb;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f283Pq;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f298rkYL != null;
    }

    /* renamed from: huTpC */
    public void m89huTpC(SubMenuC0004Dt subMenuC0004Dt) {
        this.f298rkYL = subMenuC0004Dt;
        subMenuC0004Dt.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f293lB;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f278HGpJ & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f278HGpJ & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f278HGpJ & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f278HGpJ & 8) == 0;
    }

    /* renamed from: lgHUyS */
    public CharSequence m90lgHUyS(InterfaceC0008lgHUyS.mjFkc mjfkc) {
        return (mjfkc == null || !mjfkc.mo42wA()) ? getTitle() : getTitleCondensed();
    }

    /* renamed from: mjFkc */
    public void m91mjFkc() {
        this.f287YoKzxo.m133mByQ(this);
    }

    @Override // android.view.MenuItem
    /* renamed from: qGY, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setActionView(View view) {
        int i;
        this.f286VocHEe = view;
        if (view != null && view.getId() == -1 && (i = this.f295mjFkc) > 0) {
            view.setId(i);
        }
        this.f287YoKzxo.m133mByQ(this);
        return this;
    }

    /* renamed from: qdMbNW */
    public boolean m93qdMbNW() {
        return ((this.f299vI & 8) == 0 || this.f286VocHEe == null) ? false : true;
    }

    @Override // android.view.MenuItem
    /* renamed from: rkYL, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setActionView(int i) {
        Context contextM119Pq = this.f287YoKzxo.m119Pq();
        setActionView(LayoutInflater.from(contextM119Pq).inflate(i, (ViewGroup) new LinearLayout(contextM119Pq), false));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f275Dt == c) {
            return this;
        }
        this.f275Dt = Character.toLowerCase(c);
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f278HGpJ;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.f278HGpJ = i2;
        if (i != i2) {
            this.f287YoKzxo.m117Ne(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f278HGpJ & 4) != 0) {
            this.f287YoKzxo.m138rWxwaT(this);
        } else {
            m76IEE(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f278HGpJ |= 16;
        } else {
            this.f278HGpJ &= -17;
        }
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f282MiMN = 0;
        this.f285VA = drawable;
        this.f277Gd = true;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f289diqgf = colorStateList;
        this.f284Ucbh = true;
        this.f277Gd = true;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f290eyqo = mode;
        this.f292huTpC = true;
        this.f277Gd = true;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f302xJ = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f294lgHUyS == c) {
            return this;
        }
        this.f294lgHUyS = c;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f274BAnRFn = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f291fehf = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f294lgHUyS = c;
        this.f275Dt = Character.toLowerCase(c2);
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f299vI = i;
        this.f287YoKzxo.m133mByQ(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f281KLFTb = charSequence;
        this.f287YoKzxo.m117Ne(false);
        SubMenuC0004Dt subMenuC0004Dt = this.f298rkYL;
        if (subMenuC0004Dt != null) {
            subMenuC0004Dt.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f280JHa = charSequence;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m74Gd(z)) {
            this.f287YoKzxo.m118OjSQV(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f281KLFTb;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: vI */
    public boolean m95vI() {
        return this.f287YoKzxo.mo53wJVbdd() && m78KLFTb() != 0;
    }

    /* renamed from: wA */
    public final Drawable m96wA(Drawable drawable) {
        if (drawable != null && this.f277Gd && (this.f284Ucbh || this.f292huTpC)) {
            drawable = AbstractC4332pCk.m13077VA(drawable).mutate();
            if (this.f284Ucbh) {
                AbstractC4332pCk.m13081qdMbNW(drawable, this.f289diqgf);
            }
            if (this.f292huTpC) {
                AbstractC4332pCk.m13073Dt(drawable, this.f290eyqo);
            }
            this.f277Gd = false;
        }
        return drawable;
    }

    /* renamed from: xJ */
    public AbstractC4133mByQ m97xJ() {
        return null;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC4860x7 setContentDescription(CharSequence charSequence) {
        this.f279IEE = charSequence;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC4860x7 setTooltipText(CharSequence charSequence) {
        this.f283Pq = charSequence;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f275Dt == c && this.f276ETF == i) {
            return this;
        }
        this.f275Dt = Character.toLowerCase(c);
        this.f276ETF = KeyEvent.normalizeMetaState(i);
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f294lgHUyS == c && this.f297qdMbNW == i) {
            return this;
        }
        this.f294lgHUyS = c;
        this.f297qdMbNW = KeyEvent.normalizeMetaState(i);
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f294lgHUyS = c;
        this.f297qdMbNW = KeyEvent.normalizeMetaState(i);
        this.f275Dt = Character.toLowerCase(c2);
        this.f276ETF = KeyEvent.normalizeMetaState(i2);
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f285VA = null;
        this.f282MiMN = i;
        this.f277Gd = true;
        this.f287YoKzxo.m117Ne(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f287YoKzxo.m119Pq().getString(i));
    }
}
