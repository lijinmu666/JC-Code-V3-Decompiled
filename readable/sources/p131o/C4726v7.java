package p131o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.v7 */
/* loaded from: classes.dex */
public class C4726v7 extends MenuInflater {

    /* renamed from: JHa */
    public static final Class[] f16946JHa;

    /* renamed from: KLFTb */
    public static final Class[] f16947KLFTb;

    /* renamed from: AZxh */
    public final Object[] f16948AZxh;

    /* renamed from: ZfxDd */
    public Object f16949ZfxDd;

    /* renamed from: mjFkc */
    public final Object[] f16950mjFkc;

    /* renamed from: wA */
    public Context f16951wA;

    /* renamed from: o.v7$AZxh */
    public class AZxh {

        /* renamed from: AZxh */
        public int f16952AZxh;

        /* renamed from: BAnRFn */
        public CharSequence f16953BAnRFn;

        /* renamed from: Dt */
        public int f16954Dt;

        /* renamed from: ETF */
        public CharSequence f16955ETF;

        /* renamed from: Gd */
        public String f16956Gd;

        /* renamed from: HGpJ */
        public String f16957HGpJ;

        /* renamed from: IEE */
        public int f16958IEE;

        /* renamed from: JHa */
        public boolean f16959JHa;

        /* renamed from: KLFTb */
        public int f16960KLFTb;

        /* renamed from: MiMN */
        public int f16961MiMN;

        /* renamed from: Pq */
        public boolean f16962Pq;

        /* renamed from: Ucbh */
        public int f16963Ucbh;

        /* renamed from: VA */
        public CharSequence f16964VA;

        /* renamed from: VocHEe */
        public CharSequence f16965VocHEe;

        /* renamed from: YoKzxo */
        public char f16966YoKzxo;

        /* renamed from: ZfxDd */
        public int f16967ZfxDd;

        /* renamed from: diqgf */
        public boolean f16968diqgf;

        /* renamed from: eyqo */
        public boolean f16969eyqo;

        /* renamed from: fehf */
        public int f16970fehf;

        /* renamed from: huTpC */
        public int f16971huTpC;

        /* renamed from: lgHUyS */
        public boolean f16973lgHUyS;

        /* renamed from: mjFkc */
        public Menu f16975mjFkc;

        /* renamed from: qGY */
        public char f16976qGY;

        /* renamed from: qdMbNW */
        public int f16977qdMbNW;

        /* renamed from: rkYL */
        public int f16978rkYL;

        /* renamed from: vI */
        public String f16979vI;

        /* renamed from: wA */
        public int f16980wA;

        /* renamed from: xJ */
        public boolean f16982xJ;

        /* renamed from: lB */
        public ColorStateList f16972lB = null;

        /* renamed from: wJVbdd */
        public PorterDuff.Mode f16981wJVbdd = null;

        public AZxh(Menu menu) {
            this.f16975mjFkc = menu;
            m13755lgHUyS();
        }

        /* renamed from: AZxh */
        public SubMenu m13751AZxh() {
            this.f16973lgHUyS = true;
            SubMenu subMenuAddSubMenu = this.f16975mjFkc.addSubMenu(this.f16952AZxh, this.f16977qdMbNW, this.f16954Dt, this.f16955ETF);
            m13757qdMbNW(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* renamed from: JHa */
        public void m13752JHa(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C4726v7.this.f16951wA.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12972giT);
            this.f16952AZxh = typedArrayObtainStyledAttributes.getResourceId(AbstractC3407b5.f12939XD, 0);
            this.f16980wA = typedArrayObtainStyledAttributes.getInt(AbstractC3407b5.f12858Dp, 0);
            this.f16967ZfxDd = typedArrayObtainStyledAttributes.getInt(AbstractC3407b5.f12968fLidf, 0);
            this.f16960KLFTb = typedArrayObtainStyledAttributes.getInt(AbstractC3407b5.f12976hvGY, 0);
            this.f16959JHa = typedArrayObtainStyledAttributes.getBoolean(AbstractC3407b5.f12974gtr, true);
            this.f16982xJ = typedArrayObtainStyledAttributes.getBoolean(AbstractC3407b5.f13010sRqPfw, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: KLFTb */
        public final Object m13753KLFTb(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, C4726v7.this.f16951wA.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* renamed from: ZfxDd */
        public boolean m13754ZfxDd() {
            return this.f16973lgHUyS;
        }

        /* renamed from: lgHUyS */
        public void m13755lgHUyS() {
            this.f16952AZxh = 0;
            this.f16980wA = 0;
            this.f16967ZfxDd = 0;
            this.f16960KLFTb = 0;
            this.f16959JHa = true;
            this.f16982xJ = true;
        }

        /* renamed from: mjFkc */
        public void m13756mjFkc() {
            this.f16973lgHUyS = true;
            m13757qdMbNW(this.f16975mjFkc.add(this.f16952AZxh, this.f16977qdMbNW, this.f16954Dt, this.f16955ETF));
        }

        /* renamed from: qdMbNW */
        public final void m13757qdMbNW(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f16962Pq).setVisible(this.f16968diqgf).setEnabled(this.f16969eyqo).setCheckable(this.f16958IEE >= 1).setTitleCondensed(this.f16964VA).setIcon(this.f16961MiMN);
            int i = this.f16963Ucbh;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f16979vI != null) {
                if (C4726v7.this.f16951wA.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new mjFkc(C4726v7.this.m13748AZxh(), this.f16979vI));
            }
            if (this.f16958IEE >= 2 && (menuItem instanceof C0006KLFTb)) {
                ((C0006KLFTb) menuItem).m80Pq(true);
            }
            String str = this.f16956Gd;
            if (str != null) {
                menuItem.setActionView((View) m13753KLFTb(str, C4726v7.f16947KLFTb, C4726v7.this.f16950mjFkc));
                z = true;
            }
            int i2 = this.f16971huTpC;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            AbstractC3069W1.m10745AZxh(menuItem, this.f16965VocHEe);
            AbstractC3069W1.m10746JHa(menuItem, this.f16953BAnRFn);
            AbstractC3069W1.m10749mjFkc(menuItem, this.f16966YoKzxo, this.f16978rkYL);
            AbstractC3069W1.m10747KLFTb(menuItem, this.f16976qGY, this.f16970fehf);
            PorterDuff.Mode mode = this.f16981wJVbdd;
            if (mode != null) {
                AbstractC3069W1.m10748ZfxDd(menuItem, mode);
            }
            ColorStateList colorStateList = this.f16972lB;
            if (colorStateList != null) {
                AbstractC3069W1.m10750wA(menuItem, colorStateList);
            }
        }

        /* renamed from: wA */
        public final char m13758wA(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* renamed from: xJ */
        public void m13759xJ(AttributeSet attributeSet) {
            C1606A8 c1606a8M7574Pq = C1606A8.m7574Pq(C4726v7.this.f16951wA, attributeSet, AbstractC3407b5.f12915Rc);
            this.f16977qdMbNW = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12940XDdeP, 0);
            this.f16954Dt = (c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12981jtz, this.f16980wA) & (-65536)) | (c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12944XgAT, this.f16967ZfxDd) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
            this.f16955ETF = c1606a8M7574Pq.m7591rkYL(AbstractC3407b5.f12879IyS);
            this.f16964VA = c1606a8M7574Pq.m7591rkYL(AbstractC3407b5.f13012tAfC);
            this.f16961MiMN = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12917SKTn, 0);
            this.f16966YoKzxo = m13758wA(c1606a8M7574Pq.m7583YoKzxo(AbstractC3407b5.f12960dGDT));
            this.f16978rkYL = c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12904NV, 4096);
            this.f16976qGY = m13758wA(c1606a8M7574Pq.m7583YoKzxo(AbstractC3407b5.f12946Xxz));
            this.f16970fehf = c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12985knzZ, 4096);
            if (c1606a8M7574Pq.m7586fehf(AbstractC3407b5.f12950Zdbk)) {
                this.f16958IEE = c1606a8M7574Pq.m7588mjFkc(AbstractC3407b5.f12950Zdbk, false) ? 1 : 0;
            } else {
                this.f16958IEE = this.f16960KLFTb;
            }
            this.f16962Pq = c1606a8M7574Pq.m7588mjFkc(AbstractC3407b5.f12965eQ, false);
            this.f16968diqgf = c1606a8M7574Pq.m7588mjFkc(AbstractC3407b5.f12866FbxKQm, this.f16959JHa);
            this.f16969eyqo = c1606a8M7574Pq.m7588mjFkc(AbstractC3407b5.f13008rdJr, this.f16982xJ);
            this.f16963Ucbh = c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f13042ybBTr, -1);
            this.f16979vI = c1606a8M7574Pq.m7583YoKzxo(AbstractC3407b5.f12886Jk);
            this.f16971huTpC = c1606a8M7574Pq.m7581MiMN(AbstractC3407b5.f12891KRckQg, 0);
            this.f16956Gd = c1606a8M7574Pq.m7583YoKzxo(AbstractC3407b5.f12962dkKKW);
            String strM7583YoKzxo = c1606a8M7574Pq.m7583YoKzxo(AbstractC3407b5.f12990mPWV);
            this.f16957HGpJ = strM7583YoKzxo;
            boolean z = strM7583YoKzxo != null;
            if (z && this.f16971huTpC == 0 && this.f16956Gd == null) {
                AbstractC4793w7.m13819mjFkc(m13753KLFTb(strM7583YoKzxo, C4726v7.f16946JHa, C4726v7.this.f16948AZxh));
            } else if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f16965VocHEe = c1606a8M7574Pq.m7591rkYL(AbstractC3407b5.f12885Jidt);
            this.f16953BAnRFn = c1606a8M7574Pq.m7591rkYL(AbstractC3407b5.f13011sqndV);
            if (c1606a8M7574Pq.m7586fehf(AbstractC3407b5.f12848APn)) {
                this.f16981wJVbdd = AbstractC3397awnh.m11433ZfxDd(c1606a8M7574Pq.m7577Dt(AbstractC3407b5.f12848APn, -1), this.f16981wJVbdd);
            } else {
                this.f16981wJVbdd = null;
            }
            if (c1606a8M7574Pq.m7586fehf(AbstractC3407b5.f12878IvRQOa)) {
                this.f16972lB = c1606a8M7574Pq.m7592wA(AbstractC3407b5.f12878IvRQOa);
            } else {
                this.f16972lB = null;
            }
            c1606a8M7574Pq.m7585eyqo();
            this.f16973lgHUyS = false;
        }
    }

    /* renamed from: o.v7$mjFkc */
    public static class mjFkc implements MenuItem.OnMenuItemClickListener {

        /* renamed from: wA */
        public static final Class[] f16983wA = {MenuItem.class};

        /* renamed from: AZxh */
        public Method f16984AZxh;

        /* renamed from: mjFkc */
        public Object f16985mjFkc;

        public mjFkc(Object obj, String str) {
            this.f16985mjFkc = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f16984AZxh = cls.getMethod(str, f16983wA);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f16984AZxh.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f16984AZxh.invoke(this.f16985mjFkc, menuItem)).booleanValue();
                }
                this.f16984AZxh.invoke(this.f16985mjFkc, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f16947KLFTb = clsArr;
        f16946JHa = clsArr;
    }

    public C4726v7(Context context) {
        super(context);
        this.f16951wA = context;
        Object[] objArr = {context};
        this.f16950mjFkc = objArr;
        this.f16948AZxh = objArr;
    }

    /* renamed from: AZxh */
    public Object m13748AZxh() {
        if (this.f16949ZfxDd == null) {
            this.f16949ZfxDd = m13749mjFkc(this.f16951wA);
        }
        return this.f16949ZfxDd;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof InterfaceMenuC4661u7)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f16951wA.getResources().getLayout(i);
                    m13750wA(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    /* renamed from: mjFkc */
    public final Object m13749mjFkc(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m13749mjFkc(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: wA */
    public final void m13750wA(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        AZxh aZxh = new AZxh(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        z2 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        aZxh.m13755lgHUyS();
                    } else if (name2.equals("item")) {
                        if (!aZxh.m13754ZfxDd()) {
                            aZxh.m13756mjFkc();
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    aZxh.m13752JHa(attributeSet);
                } else if (name3.equals("item")) {
                    aZxh.m13759xJ(attributeSet);
                } else if (name3.equals("menu")) {
                    m13750wA(xmlPullParser, attributeSet, aZxh.m13751AZxh());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
