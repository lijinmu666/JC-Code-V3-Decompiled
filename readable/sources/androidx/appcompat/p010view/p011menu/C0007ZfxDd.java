package androidx.appcompat.p010view.p011menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import p131o.AbstractC3141X9;
import p131o.AbstractC4294ofHOBL;
import p131o.InterfaceMenuC4661u7;

/* renamed from: androidx.appcompat.view.menu.ZfxDd */
/* loaded from: classes.dex */
public class C0007ZfxDd implements InterfaceMenuC4661u7 {

    /* renamed from: VocHEe */
    public static final int[] f320VocHEe = {1, 4, 5, 3, 2, 0};

    /* renamed from: AZxh */
    public final Resources f321AZxh;

    /* renamed from: Gd */
    public C0006KLFTb f324Gd;

    /* renamed from: KLFTb */
    public mjFkc f328KLFTb;

    /* renamed from: MiMN */
    public ContextMenu.ContextMenuInfo f329MiMN;

    /* renamed from: YoKzxo */
    public CharSequence f333YoKzxo;

    /* renamed from: ZfxDd */
    public boolean f334ZfxDd;

    /* renamed from: mjFkc */
    public final Context f340mjFkc;

    /* renamed from: qGY */
    public View f341qGY;

    /* renamed from: rkYL */
    public Drawable f343rkYL;

    /* renamed from: vI */
    public boolean f344vI;

    /* renamed from: wA */
    public boolean f345wA;

    /* renamed from: VA */
    public int f332VA = 0;

    /* renamed from: fehf */
    public boolean f337fehf = false;

    /* renamed from: IEE */
    public boolean f326IEE = false;

    /* renamed from: Pq */
    public boolean f330Pq = false;

    /* renamed from: diqgf */
    public boolean f335diqgf = false;

    /* renamed from: eyqo */
    public boolean f336eyqo = false;

    /* renamed from: Ucbh */
    public ArrayList f331Ucbh = new ArrayList();

    /* renamed from: huTpC */
    public CopyOnWriteArrayList f338huTpC = new CopyOnWriteArrayList();

    /* renamed from: HGpJ */
    public boolean f325HGpJ = false;

    /* renamed from: JHa */
    public ArrayList f327JHa = new ArrayList();

    /* renamed from: xJ */
    public ArrayList f346xJ = new ArrayList();

    /* renamed from: lgHUyS */
    public boolean f339lgHUyS = true;

    /* renamed from: qdMbNW */
    public ArrayList f342qdMbNW = new ArrayList();

    /* renamed from: Dt */
    public ArrayList f322Dt = new ArrayList();

    /* renamed from: ETF */
    public boolean f323ETF = true;

    /* renamed from: androidx.appcompat.view.menu.ZfxDd$AZxh */
    public interface AZxh {
        /* renamed from: mjFkc */
        boolean mo55mjFkc(C0006KLFTb c0006KLFTb);
    }

    /* renamed from: androidx.appcompat.view.menu.ZfxDd$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        void mo145AZxh(C0007ZfxDd c0007ZfxDd);

        /* renamed from: mjFkc */
        boolean mo146mjFkc(C0007ZfxDd c0007ZfxDd, MenuItem menuItem);
    }

    public C0007ZfxDd(Context context) {
        this.f340mjFkc = context;
        this.f321AZxh = context.getResources();
        m115KRTLGT(true);
    }

    /* renamed from: Gd */
    public static int m105Gd(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f320VocHEe;
            if (i2 < iArr.length) {
                return (i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: MiMN */
    public static int m106MiMN(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0006KLFTb) arrayList.get(size)).m85ZfxDd() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: AZxh */
    public void m107AZxh(InterfaceC0012xJ interfaceC0012xJ, Context context) {
        this.f338huTpC.add(new WeakReference(interfaceC0012xJ));
        interfaceC0012xJ.mo156wA(context, this);
        this.f323ETF = true;
    }

    /* renamed from: BAnRFn */
    public boolean mo46BAnRFn() {
        return this.f325HGpJ;
    }

    /* renamed from: CqaNbM */
    public boolean m108CqaNbM(MenuItem menuItem, int i) {
        return m143xrEuO(menuItem, null, i);
    }

    /* renamed from: Dt */
    public boolean mo47Dt(C0006KLFTb c0006KLFTb) {
        boolean zMo148ETF = false;
        if (this.f338huTpC.isEmpty()) {
            return false;
        }
        m140uHVRx();
        Iterator it = this.f338huTpC.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0012xJ interfaceC0012xJ = (InterfaceC0012xJ) weakReference.get();
            if (interfaceC0012xJ == null) {
                this.f338huTpC.remove(weakReference);
            } else {
                zMo148ETF = interfaceC0012xJ.mo148ETF(this, c0006KLFTb);
                if (zMo148ETF) {
                    break;
                }
            }
        }
        m110GMIER();
        if (zMo148ETF) {
            this.f324Gd = c0006KLFTb;
        }
        return zMo148ETF;
    }

    /* renamed from: ETF */
    public int m109ETF(int i) {
        return m121VA(i, 0);
    }

    /* renamed from: GMIER */
    public void m110GMIER() {
        this.f337fehf = false;
        if (this.f326IEE) {
            this.f326IEE = false;
            m117Ne(this.f330Pq);
        }
    }

    /* renamed from: HGpJ */
    public Resources m111HGpJ() {
        return this.f321AZxh;
    }

    /* renamed from: IEE */
    public ArrayList m112IEE() {
        m130fehf();
        return this.f342qdMbNW;
    }

    /* renamed from: JHa */
    public final C0006KLFTb m113JHa(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0006KLFTb(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: KLFTb */
    public boolean mo49KLFTb(C0006KLFTb c0006KLFTb) {
        boolean zMo154qdMbNW = false;
        if (!this.f338huTpC.isEmpty() && this.f324Gd == c0006KLFTb) {
            m140uHVRx();
            Iterator it = this.f338huTpC.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                InterfaceC0012xJ interfaceC0012xJ = (InterfaceC0012xJ) weakReference.get();
                if (interfaceC0012xJ == null) {
                    this.f338huTpC.remove(weakReference);
                } else {
                    zMo154qdMbNW = interfaceC0012xJ.mo154qdMbNW(this, c0006KLFTb);
                    if (zMo154qdMbNW) {
                        break;
                    }
                }
            }
            m110GMIER();
            if (zMo154qdMbNW) {
                this.f324Gd = null;
            }
        }
        return zMo154qdMbNW;
    }

    /* renamed from: KLMXS */
    public final void m114KLMXS(int i, boolean z) {
        if (i < 0 || i >= this.f327JHa.size()) {
            return;
        }
        this.f327JHa.remove(i);
        if (z) {
            m117Ne(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* renamed from: KRTLGT */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m115KRTLGT(boolean z) {
        boolean z2;
        if (z) {
            z2 = this.f321AZxh.getConfiguration().keyboard != 1 && AbstractC3141X9.m10896Dt(ViewConfiguration.get(this.f340mjFkc), this.f340mjFkc);
        }
        this.f334ZfxDd = z2;
    }

    /* renamed from: NPj */
    public C0007ZfxDd m116NPj(Drawable drawable) {
        m141vadzgd(0, null, 0, drawable, null);
        return this;
    }

    /* renamed from: Ne */
    public void m117Ne(boolean z) {
        if (this.f337fehf) {
            this.f326IEE = true;
            if (z) {
                this.f330Pq = true;
                return;
            }
            return;
        }
        if (z) {
            this.f339lgHUyS = true;
            this.f323ETF = true;
        }
        m132lgHUyS(z);
    }

    /* renamed from: OjSQV */
    public void m118OjSQV(C0006KLFTb c0006KLFTb) {
        this.f339lgHUyS = true;
        m117Ne(true);
    }

    /* renamed from: Pq */
    public Context m119Pq() {
        return this.f340mjFkc;
    }

    /* renamed from: Ucbh */
    public ArrayList m120Ucbh() {
        m130fehf();
        return this.f322Dt;
    }

    /* renamed from: VA */
    public int m121VA(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((C0006KLFTb) this.f327JHa.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: Vnb */
    public C0007ZfxDd m122Vnb(int i) {
        m141vadzgd(0, null, i, null, null);
        return this;
    }

    /* renamed from: VocHEe */
    public ArrayList m123VocHEe() {
        if (!this.f339lgHUyS) {
            return this.f346xJ;
        }
        this.f346xJ.clear();
        int size = this.f327JHa.size();
        for (int i = 0; i < size; i++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i);
            if (c0006KLFTb.isVisible()) {
                this.f346xJ.add(c0006KLFTb);
            }
        }
        this.f339lgHUyS = false;
        this.f323ETF = true;
        return this.f346xJ;
    }

    /* renamed from: WrLQs */
    public C0007ZfxDd m124WrLQs(View view) {
        m141vadzgd(0, null, 0, null, view);
        return this;
    }

    /* renamed from: YoKzxo */
    public int m125YoKzxo(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0006KLFTb) this.f327JHa.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: ZfxDd */
    public final void m126ZfxDd(boolean z) {
        if (this.f336eyqo) {
            return;
        }
        this.f336eyqo = true;
        Iterator it = this.f338huTpC.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0012xJ interfaceC0012xJ = (InterfaceC0012xJ) weakReference.get();
            if (interfaceC0012xJ == null) {
                this.f338huTpC.remove(weakReference);
            } else {
                interfaceC0012xJ.mo7AZxh(this, z);
            }
        }
        this.f336eyqo = false;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m134mjFkc(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f340mjFkc.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: aqHPIZ */
    public C0007ZfxDd m127aqHPIZ(CharSequence charSequence) {
        m141vadzgd(0, charSequence, 0, null, null);
        return this;
    }

    /* renamed from: cMLeY */
    public void mo50cMLeY(mjFkc mjfkc) {
        this.f328KLFTb = mjfkc;
    }

    @Override // android.view.Menu
    public void clear() {
        C0006KLFTb c0006KLFTb = this.f324Gd;
        if (c0006KLFTb != null) {
            mo49KLFTb(c0006KLFTb);
        }
        this.f327JHa.clear();
        m117Ne(true);
    }

    public void clearHeader() {
        this.f343rkYL = null;
        this.f333YoKzxo = null;
        this.f341qGY = null;
        m117Ne(false);
    }

    @Override // android.view.Menu
    public void close() {
        m126ZfxDd(true);
    }

    /* renamed from: diqgf */
    public C0006KLFTb m128diqgf() {
        return this.f324Gd;
    }

    /* renamed from: eyqo */
    public CharSequence m129eyqo() {
        return this.f333YoKzxo;
    }

    /* renamed from: fehf */
    public void m130fehf() {
        ArrayList arrayListM123VocHEe = m123VocHEe();
        if (this.f323ETF) {
            Iterator it = this.f338huTpC.iterator();
            boolean zMo27lgHUyS = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                InterfaceC0012xJ interfaceC0012xJ = (InterfaceC0012xJ) weakReference.get();
                if (interfaceC0012xJ == null) {
                    this.f338huTpC.remove(weakReference);
                } else {
                    zMo27lgHUyS |= interfaceC0012xJ.mo27lgHUyS();
                }
            }
            if (zMo27lgHUyS) {
                this.f342qdMbNW.clear();
                this.f322Dt.clear();
                int size = arrayListM123VocHEe.size();
                for (int i = 0; i < size; i++) {
                    C0006KLFTb c0006KLFTb = (C0006KLFTb) arrayListM123VocHEe.get(i);
                    if (c0006KLFTb.m73ETF()) {
                        this.f342qdMbNW.add(c0006KLFTb);
                    } else {
                        this.f322Dt.add(c0006KLFTb);
                    }
                }
            } else {
                this.f342qdMbNW.clear();
                this.f322Dt.clear();
                this.f322Dt.addAll(m123VocHEe());
            }
            this.f323ETF = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i2);
            if (c0006KLFTb.getItemId() == i) {
                return c0006KLFTb;
            }
            if (c0006KLFTb.hasSubMenu() && (menuItemFindItem = c0006KLFTb.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return (MenuItem) this.f327JHa.get(i);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f344vI) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0006KLFTb) this.f327JHa.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: huTpC */
    public boolean m131huTpC() {
        return this.f335diqgf;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m139rkYL(i, keyEvent) != null;
    }

    /* renamed from: lB */
    public boolean mo51lB() {
        return this.f345wA;
    }

    /* renamed from: lgHUyS */
    public final void m132lgHUyS(boolean z) {
        if (this.f338huTpC.isEmpty()) {
            return;
        }
        m140uHVRx();
        Iterator it = this.f338huTpC.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0012xJ interfaceC0012xJ = (InterfaceC0012xJ) weakReference.get();
            if (interfaceC0012xJ == null) {
                this.f338huTpC.remove(weakReference);
            } else {
                interfaceC0012xJ.mo31xJ(z);
            }
        }
        m110GMIER();
    }

    /* renamed from: mByQ */
    public void m133mByQ(C0006KLFTb c0006KLFTb) {
        this.f323ETF = true;
        m117Ne(true);
    }

    /* renamed from: mjFkc */
    public MenuItem m134mjFkc(int i, int i2, int i3, CharSequence charSequence) {
        int iM105Gd = m105Gd(i3);
        C0006KLFTb c0006KLFTbM113JHa = m113JHa(i, i2, i3, iM105Gd, charSequence, this.f332VA);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f329MiMN;
        if (contextMenuInfo != null) {
            c0006KLFTbM113JHa.m87eyqo(contextMenuInfo);
        }
        ArrayList arrayList = this.f327JHa;
        arrayList.add(m106MiMN(arrayList, iM105Gd), c0006KLFTbM113JHa);
        m117Ne(true);
        return c0006KLFTbM113JHa;
    }

    /* renamed from: oCFDzJ */
    public C0007ZfxDd m135oCFDzJ(int i) {
        m141vadzgd(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m108CqaNbM(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0006KLFTb c0006KLFTbM139rkYL = m139rkYL(i, keyEvent);
        boolean zM108CqaNbM = c0006KLFTbM139rkYL != null ? m108CqaNbM(c0006KLFTbM139rkYL, i2) : false;
        if ((i2 & 2) != 0) {
            m126ZfxDd(true);
        }
        return zM108CqaNbM;
    }

    /* renamed from: qGY */
    public void m136qGY(List list, int i, KeyEvent keyEvent) {
        boolean zMo51lB = mo51lB();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f327JHa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i2);
                if (c0006KLFTb.hasSubMenu()) {
                    ((C0007ZfxDd) c0006KLFTb.getSubMenu()).m136qGY(list, i, keyEvent);
                }
                char alphabeticShortcut = zMo51lB ? c0006KLFTb.getAlphabeticShortcut() : c0006KLFTb.getNumericShortcut();
                if ((modifiers & 69647) == ((zMo51lB ? c0006KLFTb.getAlphabeticModifiers() : c0006KLFTb.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zMo51lB && alphabeticShortcut == '\b' && i == 67)) && c0006KLFTb.isEnabled()) {
                        list.add(c0006KLFTb);
                    }
                }
            }
        }
    }

    /* renamed from: qdMbNW */
    public final boolean m137qdMbNW(SubMenuC0004Dt subMenuC0004Dt, InterfaceC0012xJ interfaceC0012xJ) {
        if (this.f338huTpC.isEmpty()) {
            return false;
        }
        boolean zMo11JHa = interfaceC0012xJ != null ? interfaceC0012xJ.mo11JHa(subMenuC0004Dt) : false;
        Iterator it = this.f338huTpC.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0012xJ interfaceC0012xJ2 = (InterfaceC0012xJ) weakReference.get();
            if (interfaceC0012xJ2 == null) {
                this.f338huTpC.remove(weakReference);
            } else if (!zMo11JHa) {
                zMo11JHa = interfaceC0012xJ2.mo11JHa(subMenuC0004Dt);
            }
        }
        return zMo11JHa;
    }

    /* renamed from: rWxwaT */
    public void m138rWxwaT(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f327JHa.size();
        m140uHVRx();
        for (int i = 0; i < size; i++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i);
            if (c0006KLFTb.getGroupId() == groupId && c0006KLFTb.m82VA() && c0006KLFTb.isCheckable()) {
                c0006KLFTb.m76IEE(c0006KLFTb == menuItem);
            }
        }
        m110GMIER();
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM109ETF = m109ETF(i);
        if (iM109ETF >= 0) {
            int size = this.f327JHa.size() - iM109ETF;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0006KLFTb) this.f327JHa.get(iM109ETF)).getGroupId() != i) {
                    break;
                }
                m114KLMXS(iM109ETF, false);
                i2 = i3;
            }
            m117Ne(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m114KLMXS(m125YoKzxo(i), true);
    }

    /* renamed from: rkYL */
    public C0006KLFTb m139rkYL(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f331Ucbh;
        arrayList.clear();
        m136qGY(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (C0006KLFTb) arrayList.get(0);
        }
        boolean zMo51lB = mo51lB();
        for (int i2 = 0; i2 < size; i2++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) arrayList.get(i2);
            char alphabeticShortcut = zMo51lB ? c0006KLFTb.getAlphabeticShortcut() : c0006KLFTb.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zMo51lB && alphabeticShortcut == '\b' && i == 67))) {
                return c0006KLFTb;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f327JHa.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i2);
            if (c0006KLFTb.getGroupId() == i) {
                c0006KLFTb.m80Pq(z2);
                c0006KLFTb.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f325HGpJ = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f327JHa.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i2);
            if (c0006KLFTb.getGroupId() == i) {
                c0006KLFTb.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f327JHa.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C0006KLFTb c0006KLFTb = (C0006KLFTb) this.f327JHa.get(i2);
            if (c0006KLFTb.getGroupId() == i && c0006KLFTb.m74Gd(z)) {
                z2 = true;
            }
        }
        if (z2) {
            m117Ne(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f345wA = z;
        m117Ne(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f327JHa.size();
    }

    /* renamed from: uHVRx */
    public void m140uHVRx() {
        if (this.f337fehf) {
            return;
        }
        this.f337fehf = true;
        this.f326IEE = false;
        this.f330Pq = false;
    }

    /* renamed from: vI */
    public C0007ZfxDd mo52vI() {
        return this;
    }

    /* renamed from: vadzgd */
    public final void m141vadzgd(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesM111HGpJ = m111HGpJ();
        if (view != null) {
            this.f341qGY = view;
            this.f333YoKzxo = null;
            this.f343rkYL = null;
        } else {
            if (i > 0) {
                this.f333YoKzxo = resourcesM111HGpJ.getText(i);
            } else if (charSequence != null) {
                this.f333YoKzxo = charSequence;
            }
            if (i2 > 0) {
                this.f343rkYL = AbstractC4294ofHOBL.m12997wA(m119Pq(), i2);
            } else if (drawable != null) {
                this.f343rkYL = drawable;
            }
            this.f341qGY = null;
        }
        m117Ne(false);
    }

    /* renamed from: wA */
    public void m142wA() {
        mjFkc mjfkc = this.f328KLFTb;
        if (mjfkc != null) {
            mjfkc.mo145AZxh(this);
        }
    }

    /* renamed from: wJVbdd */
    public boolean mo53wJVbdd() {
        return this.f334ZfxDd;
    }

    /* renamed from: xJ */
    public boolean mo54xJ(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
        mjFkc mjfkc = this.f328KLFTb;
        return mjfkc != null && mjfkc.mo146mjFkc(c0007ZfxDd, menuItem);
    }

    /* renamed from: xrEuO */
    public boolean m143xrEuO(MenuItem menuItem, InterfaceC0012xJ interfaceC0012xJ, int i) {
        C0006KLFTb c0006KLFTb = (C0006KLFTb) menuItem;
        if (c0006KLFTb == null || !c0006KLFTb.isEnabled()) {
            return false;
        }
        boolean zM72Dt = c0006KLFTb.m72Dt();
        c0006KLFTb.m97xJ();
        if (c0006KLFTb.m93qdMbNW()) {
            zM72Dt |= c0006KLFTb.expandActionView();
            if (zM72Dt) {
                m126ZfxDd(true);
            }
        } else if (c0006KLFTb.hasSubMenu()) {
            if ((i & 4) == 0) {
                m126ZfxDd(false);
            }
            if (!c0006KLFTb.hasSubMenu()) {
                c0006KLFTb.m89huTpC(new SubMenuC0004Dt(m119Pq(), this, c0006KLFTb));
            }
            zM72Dt |= m137qdMbNW((SubMenuC0004Dt) c0006KLFTb.getSubMenu(), interfaceC0012xJ);
            if (!zM72Dt) {
                m126ZfxDd(true);
            }
        } else if ((i & 1) == 0) {
            m126ZfxDd(true);
        }
        return zM72Dt;
    }

    /* renamed from: zvd */
    public void m144zvd(InterfaceC0012xJ interfaceC0012xJ) {
        Iterator it = this.f338huTpC.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0012xJ interfaceC0012xJ2 = (InterfaceC0012xJ) weakReference.get();
            if (interfaceC0012xJ2 == null || interfaceC0012xJ2 == interfaceC0012xJ) {
                this.f338huTpC.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m134mjFkc(0, 0, 0, this.f321AZxh.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f321AZxh.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m134mjFkc(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0006KLFTb c0006KLFTb = (C0006KLFTb) m134mjFkc(i, i2, i3, charSequence);
        SubMenuC0004Dt subMenuC0004Dt = new SubMenuC0004Dt(this.f340mjFkc, this, c0006KLFTb);
        c0006KLFTb.m89huTpC(subMenuC0004Dt);
        return subMenuC0004Dt;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m134mjFkc(i, i2, i3, this.f321AZxh.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f321AZxh.getString(i4));
    }
}
