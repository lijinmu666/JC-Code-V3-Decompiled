package p131o;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.p022app.AbstractC0095lgHUyS;
import com.p038google.p039android.material.datepicker.C0253AZxh;
import com.p038google.p039android.material.datepicker.C0256mjFkc;
import com.p038google.p039android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p131o.C3372ab;

/* renamed from: o.M1 */
/* loaded from: classes.dex */
public final class C2409M1<S> extends DialogInterfaceOnCancelListenerC3318ZlB {

    /* renamed from: LREOK */
    public int f9503LREOK;

    /* renamed from: NKyg */
    public AbstractC4789w3 f9505NKyg;

    /* renamed from: Qr */
    public int f9506Qr;

    /* renamed from: Vgyli */
    public C2542O1 f9509Vgyli;

    /* renamed from: XD */
    public CharSequence f9510XD;

    /* renamed from: XFUzSY */
    public int f9511XFUzSY;

    /* renamed from: XbiWeM */
    public CharSequence f9512XbiWeM;

    /* renamed from: XtE */
    public CharSequence f9513XtE;

    /* renamed from: fFz */
    public int f9514fFz;

    /* renamed from: gYa */
    public boolean f9515gYa;

    /* renamed from: giT */
    public boolean f9516giT;

    /* renamed from: gtIJp */
    public C0256mjFkc f9517gtIJp;

    /* renamed from: jx */
    public TextView f9518jx;

    /* renamed from: kism */
    public C0253AZxh f9519kism;

    /* renamed from: lti */
    public Button f9520lti;

    /* renamed from: sRqPfw */
    public CharSequence f9521sRqPfw;

    /* renamed from: tISON */
    public CheckableImageButton f9522tISON;

    /* renamed from: tjSezt */
    public int f9523tjSezt;

    /* renamed from: uH */
    public TextView f9524uH;

    /* renamed from: yX */
    public CharSequence f9525yX;

    /* renamed from: gtr */
    public static final Object f9501gtr = "CONFIRM_BUTTON_TAG";

    /* renamed from: Dp */
    public static final Object f9499Dp = "CANCEL_BUTTON_TAG";

    /* renamed from: fLidf */
    public static final Object f9500fLidf = "TOGGLE_BUTTON_TAG";

    /* renamed from: IVlxe */
    public final LinkedHashSet f9502IVlxe = new LinkedHashSet();

    /* renamed from: Moer */
    public final LinkedHashSet f9504Moer = new LinkedHashSet();

    /* renamed from: SmIWf */
    public final LinkedHashSet f9508SmIWf = new LinkedHashSet();

    /* renamed from: SOS */
    public final LinkedHashSet f9507SOS = new LinkedHashSet();

    /* renamed from: o.M1$AZxh */
    public class AZxh extends AbstractC3601e3 {
        public AZxh() {
        }
    }

    /* renamed from: o.M1$mjFkc */
    public class mjFkc implements InterfaceC3134X2 {

        /* renamed from: AZxh */
        public final /* synthetic */ View f9527AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f9529mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ int f9530wA;

        public mjFkc(int i, View view, int i2) {
            this.f9529mjFkc = i;
            this.f9527AZxh = view;
            this.f9530wA = i2;
        }

        @Override // p131o.InterfaceC3134X2
        /* renamed from: mjFkc */
        public C3372ab mo535mjFkc(View view, C3372ab c3372ab) {
            int i = c3372ab.m11336JHa(C3372ab.VA.m11388ZfxDd()).f10506AZxh;
            if (this.f9529mjFkc >= 0) {
                this.f9527AZxh.getLayoutParams().height = this.f9529mjFkc + i;
                View view2 = this.f9527AZxh;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f9527AZxh;
            view3.setPadding(view3.getPaddingLeft(), this.f9530wA + i, this.f9527AZxh.getPaddingRight(), this.f9527AZxh.getPaddingBottom());
            return c3372ab;
        }
    }

    /* renamed from: o.M1$wA */
    public class wA implements View.OnClickListener {
        public wA() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button unused = C2409M1.this.f9520lti;
            C2409M1.m9411Xxz(C2409M1.this);
            throw null;
        }
    }

    /* renamed from: IvRQOa */
    public static int m9408IvRQOa(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(AbstractC4191n4.f15307BAnRFn);
        int i = C4656u2.m13666ETF().f16767ZfxDd;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(AbstractC4191n4.f15347wJVbdd) * i) + ((i - 1) * resources.getDimensionPixelOffset(AbstractC4191n4.f15319Ne));
    }

    /* renamed from: Jk */
    public static Drawable m9409Jk(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AbstractC4768vjlshU.m13794AZxh(context, AbstractC4458r4.f16280AZxh));
        stateListDrawable.addState(new int[0], AbstractC4768vjlshU.m13794AZxh(context, AbstractC4458r4.f16285wA));
        return stateListDrawable;
    }

    /* renamed from: RWyiuY */
    public static boolean m9410RWyiuY(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1931F1.m8248ZfxDd(context, AbstractC3800h4.f13948qGY, C0253AZxh.class.getCanonicalName()), new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* renamed from: Xxz */
    public static /* synthetic */ InterfaceC2981UlIi m9411Xxz(C2409M1 c2409m1) {
        c2409m1.m9414mPWV();
        return null;
    }

    /* renamed from: dkKKW */
    public static CharSequence m9413dkKKW(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    /* renamed from: mPWV */
    private InterfaceC2981UlIi m9414mPWV() {
        AbstractC4793w7.m13819mjFkc(m789VA().getParcelable("DATE_SELECTOR_KEY"));
        return null;
    }

    /* renamed from: oaI */
    public static boolean m9415oaI(Context context) {
        return m9410RWyiuY(context, AbstractC3800h4.f13953wJVbdd);
    }

    /* renamed from: ybBTr */
    public static boolean m9416ybBTr(Context context) {
        return m9410RWyiuY(context, R.attr.windowFullscreen);
    }

    /* renamed from: APn */
    public final int m9417APn(Context context) {
        int i = this.f9506Qr;
        if (i != 0) {
            return i;
        }
        m9414mPWV();
        throw null;
    }

    /* renamed from: CTcA */
    public final void m9418CTcA(CheckableImageButton checkableImageButton) {
        this.f9522tISON.setContentDescription(this.f9522tISON.isChecked() ? checkableImageButton.getContext().getString(AbstractC2481N4.f9652rkYL) : checkableImageButton.getContext().getString(AbstractC2481N4.f9647fehf));
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB
    /* renamed from: FbxKQm */
    public final Dialog mo9419FbxKQm(Bundle bundle) {
        Dialog dialog = new Dialog(m810fFz(), m9417APn(m810fFz()));
        Context context = dialog.getContext();
        this.f9515gYa = m9416ybBTr(context);
        int iM8248ZfxDd = AbstractC1931F1.m8248ZfxDd(context, AbstractC3800h4.f13945lgHUyS, C2409M1.class.getCanonicalName());
        C2542O1 c2542o1 = new C2542O1(context, null, AbstractC3800h4.f13948qGY, AbstractC2737R4.f10369VA);
        this.f9509Vgyli = c2542o1;
        c2542o1.m9827cMLeY(context);
        this.f9509Vgyli.m9841uHVRx(ColorStateList.valueOf(iM8248ZfxDd));
        this.f9509Vgyli.m9801GMIER(AbstractC2876T9.m10231IEE(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB, androidx.fragment.p022app.Fragment
    /* renamed from: JYn */
    public final void mo772JYn(Bundle bundle) throws Resources.NotFoundException {
        super.mo772JYn(bundle);
        if (bundle == null) {
            bundle = m789VA();
        }
        this.f9506Qr = bundle.getInt("OVERRIDE_THEME_RES_ID");
        AbstractC4793w7.m13819mjFkc(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f9517gtIJp = (C0256mjFkc) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        AbstractC4793w7.m13819mjFkc(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f9523tjSezt = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f9525yX = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f9503LREOK = bundle.getInt("INPUT_MODE_KEY");
        this.f9514fFz = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9512XbiWeM = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f9511XFUzSY = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9513XtE = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence text = this.f9525yX;
        if (text == null) {
            text = m810fFz().getResources().getText(this.f9523tjSezt);
        }
        this.f9521sRqPfw = text;
        this.f9510XD = m9413dkKKW(text);
    }

    /* renamed from: Jidt */
    public String m9420Jidt() {
        m9414mPWV();
        m801YoKzxo();
        throw null;
    }

    /* renamed from: KRckQg */
    public final void m9421KRckQg(Window window) {
        if (this.f9516giT) {
            return;
        }
        View viewFindViewById = m799XbiWeM().findViewById(AbstractC1803D4.f7795JHa);
        AbstractC2405LyQ.m9405mjFkc(window, true, AbstractC4557sa.m13507wA(viewFindViewById), null);
        AbstractC2876T9.m10300yX(viewFindViewById, new mjFkc(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.f9516giT = true;
    }

    /* renamed from: NV */
    public final String m9422NV() {
        m9414mPWV();
        m810fFz();
        throw null;
    }

    /* renamed from: Vu */
    public final void m9423Vu() {
        AbstractC4789w3 abstractC4789w3M9995SKTn;
        int iM9417APn = m9417APn(m810fFz());
        m9414mPWV();
        this.f9519kism = C0253AZxh.m2887KRckQg(null, iM9417APn, this.f9517gtIJp, null);
        boolean zIsChecked = this.f9522tISON.isChecked();
        if (zIsChecked) {
            m9414mPWV();
            abstractC4789w3M9995SKTn = C2669Q1.m9995SKTn(null, iM9417APn, this.f9517gtIJp);
        } else {
            abstractC4789w3M9995SKTn = this.f9519kism;
        }
        this.f9505NKyg = abstractC4789w3M9995SKTn;
        m9425oVXlhB(zIsChecked);
        m9427uxlM(m9420Jidt());
        AbstractC0095lgHUyS abstractC0095lgHUySM864Dt = m777MiMN().m864Dt();
        abstractC0095lgHUySM864Dt.m963VA(AbstractC1803D4.f7802Ucbh, this.f9505NKyg);
        abstractC0095lgHUySM864Dt.mo969xJ();
        this.f9505NKyg.mo2902hvGY(new AZxh());
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB, androidx.fragment.p022app.Fragment
    /* renamed from: alEkx */
    public void mo802alEkx() throws Resources.NotFoundException {
        super.mo802alEkx();
        Window window = m11227tAfC().getWindow();
        if (this.f9515gYa) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f9509Vgyli);
            m9421KRckQg(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m782OjSQV().getDimensionPixelOffset(AbstractC4191n4.f15320OjSQV);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f9509Vgyli, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC2667Q(m11227tAfC(), rect));
        }
        m9423Vu();
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB, androidx.fragment.p022app.Fragment
    /* renamed from: dm */
    public void mo807dm() {
        this.f9505NKyg.m13816Rc();
        super.mo807dm();
    }

    /* renamed from: knzZ */
    public final void m9424knzZ(Context context) {
        this.f9522tISON.setTag(f9500fLidf);
        this.f9522tISON.setImageDrawable(m9409Jk(context));
        this.f9522tISON.setChecked(this.f9503LREOK != 0);
        AbstractC2876T9.m10265alEkx(this.f9522tISON, null);
        m9418CTcA(this.f9522tISON);
        this.f9522tISON.setOnClickListener(new wA());
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: nxI */
    public final View mo826nxI(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f9515gYa ? AbstractC2007G4.f8320eyqo : AbstractC2007G4.f8319diqgf, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f9515gYa) {
            viewInflate.findViewById(AbstractC1803D4.f7802Ucbh).setLayoutParams(new LinearLayout.LayoutParams(m9408IvRQOa(context), -2));
        } else {
            viewInflate.findViewById(AbstractC1803D4.f7812huTpC).setLayoutParams(new LinearLayout.LayoutParams(m9408IvRQOa(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(AbstractC1803D4.f7805VocHEe);
        this.f9524uH = textView;
        AbstractC2876T9.m10289tQ(textView, 1);
        this.f9522tISON = (CheckableImageButton) viewInflate.findViewById(AbstractC1803D4.f7788BAnRFn);
        this.f9518jx = (TextView) viewInflate.findViewById(AbstractC1803D4.f7813lB);
        m9424knzZ(context);
        this.f9520lti = (Button) viewInflate.findViewById(AbstractC1803D4.f7822wA);
        m9414mPWV();
        throw null;
    }

    /* renamed from: oVXlhB */
    public final void m9425oVXlhB(boolean z) {
        this.f9518jx.setText((z && m9426sqndV()) ? this.f9510XD : this.f9521sRqPfw);
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f9508SmIWf.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // p131o.DialogInterfaceOnCancelListenerC3318ZlB, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f9507SOS.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) m830rWxwaT();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    /* renamed from: sqndV */
    public final boolean m9426sqndV() {
        return m782OjSQV().getConfiguration().orientation == 2;
    }

    /* renamed from: uxlM */
    public void m9427uxlM(String str) {
        this.f9524uH.setContentDescription(m9422NV());
        this.f9524uH.setText(str);
    }
}
