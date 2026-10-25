package p131o;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: o.wJVbdd */
/* loaded from: classes.dex */
public class C4807wJVbdd implements InterfaceMenuItemC4860x7 {

    /* renamed from: AZxh */
    public final int f17187AZxh;

    /* renamed from: ETF */
    public Drawable f17189ETF;

    /* renamed from: JHa */
    public Intent f17191JHa;

    /* renamed from: KLFTb */
    public CharSequence f17192KLFTb;

    /* renamed from: MiMN */
    public MenuItem.OnMenuItemClickListener f17193MiMN;

    /* renamed from: VA */
    public Context f17195VA;

    /* renamed from: YoKzxo */
    public CharSequence f17196YoKzxo;

    /* renamed from: ZfxDd */
    public CharSequence f17197ZfxDd;

    /* renamed from: mjFkc */
    public final int f17201mjFkc;

    /* renamed from: qdMbNW */
    public char f17203qdMbNW;

    /* renamed from: rkYL */
    public CharSequence f17204rkYL;

    /* renamed from: wA */
    public final int f17205wA;

    /* renamed from: xJ */
    public char f17206xJ;

    /* renamed from: lgHUyS */
    public int f17200lgHUyS = 4096;

    /* renamed from: Dt */
    public int f17188Dt = 4096;

    /* renamed from: qGY */
    public ColorStateList f17202qGY = null;

    /* renamed from: fehf */
    public PorterDuff.Mode f17199fehf = null;

    /* renamed from: IEE */
    public boolean f17190IEE = false;

    /* renamed from: Pq */
    public boolean f17194Pq = false;

    /* renamed from: diqgf */
    public int f17198diqgf = 16;

    public C4807wJVbdd(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f17195VA = context;
        this.f17201mjFkc = i2;
        this.f17187AZxh = i;
        this.f17205wA = i4;
        this.f17197ZfxDd = charSequence;
    }

    @Override // android.view.MenuItem
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: ZfxDd, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f17188Dt;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f17203qdMbNW;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f17196YoKzxo;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f17187AZxh;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f17189ETF;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f17202qGY;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f17199fehf;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f17191JHa;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f17201mjFkc;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f17200lgHUyS;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f17206xJ;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f17205wA;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f17197ZfxDd;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f17192KLFTb;
        return charSequence != null ? charSequence : this.f17197ZfxDd;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f17204rkYL;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f17198diqgf & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f17198diqgf & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f17198diqgf & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f17198diqgf & 8) == 0;
    }

    /* renamed from: mjFkc */
    public final void m13848mjFkc() {
        Drawable drawable = this.f17189ETF;
        if (drawable != null) {
            if (this.f17190IEE || this.f17194Pq) {
                Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(drawable);
                this.f17189ETF = drawableM13077VA;
                Drawable drawableMutate = drawableM13077VA.mutate();
                this.f17189ETF = drawableMutate;
                if (this.f17190IEE) {
                    AbstractC4332pCk.m13081qdMbNW(drawableMutate, this.f17202qGY);
                }
                if (this.f17194Pq) {
                    AbstractC4332pCk.m13073Dt(this.f17189ETF, this.f17199fehf);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f17203qdMbNW = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f17198diqgf = (z ? 1 : 0) | (this.f17198diqgf & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f17198diqgf = (z ? 2 : 0) | (this.f17198diqgf & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f17198diqgf = (z ? 16 : 0) | (this.f17198diqgf & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f17189ETF = drawable;
        m13848mjFkc();
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f17202qGY = colorStateList;
        this.f17190IEE = true;
        m13848mjFkc();
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f17199fehf = mode;
        this.f17194Pq = true;
        m13848mjFkc();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f17191JHa = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f17206xJ = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f17193MiMN = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f17206xJ = c;
        this.f17203qdMbNW = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f17197ZfxDd = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f17192KLFTb = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f17198diqgf = (this.f17198diqgf & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC4860x7 setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f17203qdMbNW = Character.toLowerCase(c);
        this.f17188Dt = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC4860x7 setContentDescription(CharSequence charSequence) {
        this.f17196YoKzxo = charSequence;
        return this;
    }

    @Override // p131o.InterfaceMenuItemC4860x7, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f17206xJ = c;
        this.f17200lgHUyS = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f17197ZfxDd = this.f17195VA.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC4860x7 setTooltipText(CharSequence charSequence) {
        this.f17204rkYL = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f17189ETF = AbstractC4294ofHOBL.m12997wA(this.f17195VA, i);
        m13848mjFkc();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f17206xJ = c;
        this.f17200lgHUyS = KeyEvent.normalizeMetaState(i);
        this.f17203qdMbNW = Character.toLowerCase(c2);
        this.f17188Dt = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
