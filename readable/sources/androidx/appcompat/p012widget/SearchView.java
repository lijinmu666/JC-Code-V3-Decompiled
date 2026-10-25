package androidx.appcompat.p012widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import java.util.WeakHashMap;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1865E4;
import p131o.AbstractC2092HL;
import p131o.AbstractC2139I4;
import p131o.AbstractC2143I8;
import p131o.AbstractC2244JYgkl;
import p131o.AbstractC2545O4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.AbstractC3862i4;
import p131o.AbstractC4256o4;
import p131o.AbstractC4689ua;
import p131o.AbstractC4796wA;
import p131o.C1606A8;
import p131o.InterfaceC2923TvfBiy;
import p131o.ViewOnClickListenerC4461r7;

/* loaded from: classes.dex */
public class SearchView extends AbstractC0013AZxh implements InterfaceC2923TvfBiy {

    /* renamed from: tQ */
    public static final C0041rkYL f485tQ = null;

    /* renamed from: ANMGZc */
    public final AdapterView.OnItemClickListener f486ANMGZc;

    /* renamed from: BAnRFn */
    public int[] f487BAnRFn;

    /* renamed from: CqaNbM */
    public final Intent f488CqaNbM;

    /* renamed from: GMIER */
    public boolean f489GMIER;

    /* renamed from: Gd */
    public final View f490Gd;

    /* renamed from: HGpJ */
    public C0036fehf f491HGpJ;

    /* renamed from: IEE */
    public final View f492IEE;

    /* renamed from: JBhc */
    public final View.OnClickListener f493JBhc;

    /* renamed from: JYgkl */
    public boolean f494JYgkl;

    /* renamed from: JYn */
    public CharSequence f495JYn;

    /* renamed from: JrJO */
    public int f496JrJO;

    /* renamed from: KLMXS */
    public final CharSequence f497KLMXS;

    /* renamed from: KRTLGT */
    public int f498KRTLGT;

    /* renamed from: NPj */
    public AbstractC2092HL f499NPj;

    /* renamed from: Ne */
    public final int f500Ne;

    /* renamed from: OjSQV */
    public final int f501OjSQV;

    /* renamed from: Pq */
    public final View f502Pq;

    /* renamed from: SwgkN */
    public final WeakHashMap f503SwgkN;

    /* renamed from: Ucbh */
    public final ImageView f504Ucbh;

    /* renamed from: Vdz */
    public View.OnKeyListener f505Vdz;

    /* renamed from: Vnb */
    public boolean f506Vnb;

    /* renamed from: VocHEe */
    public Rect f507VocHEe;

    /* renamed from: WGXroI */
    public Bundle f508WGXroI;

    /* renamed from: WrLQs */
    public boolean f509WrLQs;

    /* renamed from: XV */
    public final Runnable f510XV;

    /* renamed from: alEkx */
    public final AdapterView.OnItemSelectedListener f511alEkx;

    /* renamed from: aqHPIZ */
    public boolean f512aqHPIZ;

    /* renamed from: bbzow */
    public Runnable f513bbzow;

    /* renamed from: cMLeY */
    public View.OnClickListener f514cMLeY;

    /* renamed from: diqgf */
    public final ImageView f515diqgf;

    /* renamed from: dm */
    public TextWatcher f516dm;

    /* renamed from: eyqo */
    public final ImageView f517eyqo;

    /* renamed from: fehf */
    public final View f518fehf;

    /* renamed from: huTpC */
    public final ImageView f519huTpC;

    /* renamed from: jm */
    public final TextView.OnEditorActionListener f520jm;

    /* renamed from: lB */
    public int[] f521lB;

    /* renamed from: mByQ */
    public final Drawable f522mByQ;

    /* renamed from: nxI */
    public SearchableInfo f523nxI;

    /* renamed from: oCFDzJ */
    public CharSequence f524oCFDzJ;

    /* renamed from: qGY */
    public final SearchAutoComplete f525qGY;

    /* renamed from: rWxwaT */
    public boolean f526rWxwaT;

    /* renamed from: uHVRx */
    public CharSequence f527uHVRx;

    /* renamed from: vI */
    public Rect f528vI;

    /* renamed from: vadzgd */
    public boolean f529vadzgd;

    /* renamed from: wJVbdd */
    public final ImageView f530wJVbdd;

    /* renamed from: xrEuO */
    public final Intent f531xrEuO;

    /* renamed from: zvd */
    public View.OnFocusChangeListener f532zvd;

    /* renamed from: androidx.appcompat.widget.SearchView$AZxh */
    public class RunnableC0026AZxh implements Runnable {
        public RunnableC0026AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.m236JBhc();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$Dt */
    public class C0027Dt implements AdapterView.OnItemSelectedListener {
        public C0027Dt() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.m251WrLQs(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$ETF */
    public static class C0028ETF {
        /* renamed from: AZxh */
        public static void m269AZxh(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }

        /* renamed from: mjFkc */
        public static void m270mjFkc(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$JHa */
    public class ViewOnClickListenerC0029JHa implements View.OnClickListener {
        public ViewOnClickListenerC0029JHa() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f515diqgf) {
                searchView.m235GMIER();
                return;
            }
            if (view == searchView.f504Ucbh) {
                searchView.m261oCFDzJ();
                return;
            }
            if (view == searchView.f517eyqo) {
                searchView.m264uHVRx();
            } else if (view == searchView.f519huTpC) {
                searchView.m260nxI();
            } else if (view == searchView.f525qGY) {
                searchView.m244Ne();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$KLFTb */
    public class ViewOnLayoutChangeListenerC0030KLFTb implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0030KLFTb() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.m249VocHEe();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$MiMN */
    public interface InterfaceC0031MiMN {
    }

    public static class SearchAutoComplete extends AbstractC2244JYgkl {

        /* renamed from: JHa */
        public SearchView f537JHa;

        /* renamed from: KLFTb */
        public int f538KLFTb;

        /* renamed from: lgHUyS */
        public final Runnable f539lgHUyS;

        /* renamed from: xJ */
        public boolean f540xJ;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$mjFkc */
        public class RunnableC0032mjFkc implements Runnable {
            public RunnableC0032mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.m272ZfxDd();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC3862i4.f14121xJ);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* renamed from: AZxh */
        public void m271AZxh() {
            C0028ETF.m269AZxh(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        /* renamed from: ZfxDd */
        public void m272ZfxDd() {
            if (this.f540xJ) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f540xJ = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f538KLFTb <= 0 || super.enoughToFilter();
        }

        @Override // p131o.AbstractC2244JYgkl, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f540xJ) {
                removeCallbacks(this.f539lgHUyS);
                post(this.f539lgHUyS);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f537JHa.m239JrJO();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f537JHa.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f537JHa.hasFocus() && getVisibility() == 0) {
                this.f540xJ = true;
                if (SearchView.m230cMLeY(getContext())) {
                    m271AZxh();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f540xJ = false;
                removeCallbacks(this.f539lgHUyS);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f540xJ = true;
                    return;
                }
                this.f540xJ = false;
                removeCallbacks(this.f539lgHUyS);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f537JHa = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f538KLFTb = i;
        }

        /* renamed from: wA */
        public boolean m273wA() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f539lgHUyS = new RunnableC0032mjFkc();
            this.f538KLFTb = getThreshold();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$VA */
    public interface InterfaceC0033VA {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$YoKzxo */
    public interface InterfaceC0034YoKzxo {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$ZfxDd */
    public class ViewOnFocusChangeListenerC0035ZfxDd implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC0035ZfxDd() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f532zvd;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$fehf */
    public static class C0036fehf extends TouchDelegate {

        /* renamed from: AZxh */
        public final Rect f543AZxh;

        /* renamed from: JHa */
        public boolean f544JHa;

        /* renamed from: KLFTb */
        public final int f545KLFTb;

        /* renamed from: ZfxDd */
        public final Rect f546ZfxDd;

        /* renamed from: mjFkc */
        public final View f547mjFkc;

        /* renamed from: wA */
        public final Rect f548wA;

        public C0036fehf(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f545KLFTb = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f543AZxh = new Rect();
            this.f546ZfxDd = new Rect();
            this.f548wA = new Rect();
            m274mjFkc(rect, rect2);
            this.f547mjFkc = view;
        }

        /* renamed from: mjFkc */
        public void m274mjFkc(Rect rect, Rect rect2) {
            this.f543AZxh.set(rect);
            this.f546ZfxDd.set(rect);
            Rect rect3 = this.f546ZfxDd;
            int i = this.f545KLFTb;
            rect3.inset(-i, -i);
            this.f548wA.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f544JHa;
                    if (z2 && !this.f546ZfxDd.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f544JHa;
                        this.f544JHa = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.f543AZxh.contains(x, y)) {
                this.f544JHa = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.f548wA.contains(x, y)) {
                Rect rect = this.f548wA;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.f547mjFkc.getWidth() / 2, this.f547mjFkc.getHeight() / 2);
            }
            return this.f547mjFkc.dispatchTouchEvent(motionEvent);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$lgHUyS */
    public class C0037lgHUyS implements TextView.OnEditorActionListener {
        public C0037lgHUyS() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.m264uHVRx();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$mjFkc */
    public class C0038mjFkc implements TextWatcher {
        public C0038mjFkc() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.m237JYgkl(charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$qGY */
    public static class C0039qGY extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0039qGY> f551CREATOR = new mjFkc();

        /* renamed from: wA */
        public boolean f552wA;

        /* renamed from: androidx.appcompat.widget.SearchView$qGY$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0039qGY createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0039qGY(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0039qGY createFromParcel(Parcel parcel) {
                return new C0039qGY(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0039qGY[] newArray(int i) {
                return new C0039qGY[i];
            }
        }

        public C0039qGY(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f552wA + "}";
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f552wA));
        }

        public C0039qGY(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f552wA = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$qdMbNW */
    public class C0040qdMbNW implements AdapterView.OnItemClickListener {
        public C0040qdMbNW() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.m254aqHPIZ(i, 0, null);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$rkYL */
    public static class C0041rkYL {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$wA */
    public class RunnableC0042wA implements Runnable {
        public RunnableC0042wA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2092HL abstractC2092HL = SearchView.this.f499NPj;
            if (abstractC2092HL instanceof ViewOnClickListenerC4461r7) {
                abstractC2092HL.mo8541mjFkc(null);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$xJ */
    public class ViewOnKeyListenerC0043xJ implements View.OnKeyListener {
        public ViewOnKeyListenerC0043xJ() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f523nxI == null) {
                return false;
            }
            if (searchView.f525qGY.isPopupShowing() && SearchView.this.f525qGY.getListSelection() != -1) {
                return SearchView.this.m238JYn(view, i, keyEvent);
            }
            if (SearchView.this.f525qGY.m273wA() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.m243NPj(0, null, searchView2.f525qGY.getText().toString());
            return true;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    /* renamed from: cMLeY */
    public static boolean m230cMLeY(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(AbstractC4256o4.f15499KLFTb);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(AbstractC4256o4.f15498JHa);
    }

    private void setQuery(CharSequence charSequence) {
        this.f525qGY.setText(charSequence);
        this.f525qGY.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: ANMGZc */
    public final void m231ANMGZc() {
        this.f502Pq.setVisibility((m262rWxwaT() && (this.f517eyqo.getVisibility() == 0 || this.f519huTpC.getVisibility() == 0)) ? 0 : 8);
    }

    @Override // p131o.InterfaceC2923TvfBiy
    /* renamed from: AZxh */
    public void mo232AZxh() {
        if (this.f494JYgkl) {
            return;
        }
        this.f494JYgkl = true;
        int imeOptions = this.f525qGY.getImeOptions();
        this.f496JrJO = imeOptions;
        this.f525qGY.setImeOptions(imeOptions | AdbProtocol.INITIAL_DELAYED_ACK_BYTES);
        this.f525qGY.setText(BuildConfig.f24315FLAVOR);
        setIconified(false);
    }

    /* renamed from: BAnRFn */
    public final Intent m233BAnRFn(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f495JYn);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f508WGXroI;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f523nxI.getSearchActivity());
        return intent;
    }

    /* renamed from: CqaNbM */
    public final void m234CqaNbM(View view, Rect rect) {
        view.getLocationInWindow(this.f487BAnRFn);
        getLocationInWindow(this.f521lB);
        int[] iArr = this.f487BAnRFn;
        int i = iArr[1];
        int[] iArr2 = this.f521lB;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    /* renamed from: GMIER */
    public void m235GMIER() {
        m256dm(false);
        this.f525qGY.requestFocus();
        this.f525qGY.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f514cMLeY;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: JBhc */
    public void m236JBhc() {
        int[] iArr = this.f525qGY.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f492IEE.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f502Pq.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* renamed from: JYgkl */
    public void m237JYgkl(CharSequence charSequence) {
        Editable text = this.f525qGY.getText();
        this.f495JYn = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        m253alEkx(!zIsEmpty);
        m263tQ(zIsEmpty);
        m246SwgkN();
        m231ANMGZc();
        this.f527uHVRx = charSequence.toString();
    }

    /* renamed from: JYn */
    public boolean m238JYn(View view, int i, KeyEvent keyEvent) {
        if (this.f523nxI != null && this.f499NPj != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return m254aqHPIZ(this.f525qGY.getListSelection(), 0, null);
            }
            if (i == 21 || i == 22) {
                this.f525qGY.setSelection(i == 21 ? 0 : this.f525qGY.length());
                this.f525qGY.setListSelection(0);
                this.f525qGY.clearListSelection();
                this.f525qGY.m271AZxh();
                return true;
            }
            if (i == 19) {
                this.f525qGY.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* renamed from: JrJO */
    public void m239JrJO() {
        m256dm(m268zvd());
        m250WGXroI();
        if (this.f525qGY.hasFocus()) {
            m244Ne();
        }
    }

    @Override // p131o.InterfaceC2923TvfBiy
    /* renamed from: KLFTb */
    public void mo240KLFTb() {
        m255bbzow(BuildConfig.f24315FLAVOR, false);
        clearFocus();
        m256dm(true);
        this.f525qGY.setImeOptions(this.f496JrJO);
        this.f494JYgkl = false;
    }

    /* renamed from: KLMXS */
    public final boolean m241KLMXS() {
        SearchableInfo searchableInfo = this.f523nxI;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.f523nxI.getVoiceSearchLaunchWebSearch() ? this.f488CqaNbM : this.f523nxI.getVoiceSearchLaunchRecognizer() ? this.f531xrEuO : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, PKIFailureInfo.notAuthorized) == null) ? false : true;
    }

    /* renamed from: KRTLGT */
    public void m242KRTLGT(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: NPj */
    public void m243NPj(int i, String str, String str2) {
        getContext().startActivity(m233BAnRFn("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    /* renamed from: Ne */
    public void m244Ne() {
        C0028ETF.m270mjFkc(this.f525qGY);
    }

    /* renamed from: OjSQV */
    public final void m245OjSQV() {
        this.f525qGY.dismissDropDown();
    }

    /* renamed from: SwgkN */
    public final void m246SwgkN() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f525qGY.getText());
        this.f504Ucbh.setVisibility(!zIsEmpty || (this.f526rWxwaT && !this.f494JYgkl) ? 0 : 8);
        Drawable drawable = this.f504Ucbh.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* renamed from: Vdz */
    public final void m247Vdz() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f525qGY;
        if (queryHint == null) {
            queryHint = BuildConfig.f24315FLAVOR;
        }
        searchAutoComplete.setHint(m267xrEuO(queryHint));
    }

    /* renamed from: Vnb */
    public final void m248Vnb(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e("SearchView", "Failed launch activity: " + intent, e);
        }
    }

    /* renamed from: VocHEe */
    public void m249VocHEe() {
        if (this.f490Gd.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f492IEE.getPaddingLeft();
            Rect rect = new Rect();
            boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
            int dimensionPixelSize = this.f526rWxwaT ? resources.getDimensionPixelSize(AbstractC4256o4.f15504wA) + resources.getDimensionPixelSize(AbstractC4256o4.f15500ZfxDd) : 0;
            this.f525qGY.getDropDownBackground().getPadding(rect);
            this.f525qGY.setDropDownHorizontalOffset(zM13718mjFkc ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f525qGY.setDropDownWidth((((this.f490Gd.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* renamed from: WGXroI */
    public final void m250WGXroI() {
        post(this.f510XV);
    }

    /* renamed from: WrLQs */
    public boolean m251WrLQs(int i) {
        m252XV(i);
        return true;
    }

    /* renamed from: XV */
    public final void m252XV(int i) {
        Editable text = this.f525qGY.getText();
        Cursor cursorMo8536AZxh = this.f499NPj.mo8536AZxh();
        if (cursorMo8536AZxh == null) {
            return;
        }
        if (!cursorMo8536AZxh.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceMo8543wA = this.f499NPj.mo8543wA(cursorMo8536AZxh);
        if (charSequenceMo8543wA != null) {
            setQuery(charSequenceMo8543wA);
        } else {
            setQuery(text);
        }
    }

    /* renamed from: alEkx */
    public final void m253alEkx(boolean z) {
        this.f517eyqo.setVisibility((this.f529vadzgd && m262rWxwaT() && hasFocus() && (z || !this.f489GMIER)) ? 0 : 8);
    }

    /* renamed from: aqHPIZ */
    public boolean m254aqHPIZ(int i, int i2, String str) {
        m265vadzgd(i, 0, null);
        this.f525qGY.setImeVisibility(false);
        m245OjSQV();
        return true;
    }

    /* renamed from: bbzow */
    public void m255bbzow(CharSequence charSequence, boolean z) {
        this.f525qGY.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f525qGY;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f495JYn = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m264uHVRx();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f509WrLQs = true;
        super.clearFocus();
        this.f525qGY.clearFocus();
        this.f525qGY.setImeVisibility(false);
        this.f509WrLQs = false;
    }

    /* renamed from: dm */
    public final void m256dm(boolean z) {
        this.f506Vnb = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f525qGY.getText());
        this.f515diqgf.setVisibility(i2);
        m253alEkx(!zIsEmpty);
        this.f518fehf.setVisibility(z ? 8 : 0);
        if (this.f530wJVbdd.getDrawable() != null && !this.f526rWxwaT) {
            i = 0;
        }
        this.f530wJVbdd.setVisibility(i);
        m246SwgkN();
        m263tQ(zIsEmpty);
        m231ANMGZc();
    }

    public int getImeOptions() {
        return this.f525qGY.getImeOptions();
    }

    public int getInputType() {
        return this.f525qGY.getInputType();
    }

    public int getMaxWidth() {
        return this.f498KRTLGT;
    }

    public CharSequence getQuery() {
        return this.f525qGY.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f524oCFDzJ;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f523nxI;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f497KLMXS : getContext().getText(this.f523nxI.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f500Ne;
    }

    public int getSuggestionRowLayout() {
        return this.f501OjSQV;
    }

    public AbstractC2092HL getSuggestionsAdapter() {
        return this.f499NPj;
    }

    /* renamed from: jm */
    public final void m257jm() {
        this.f525qGY.setThreshold(this.f523nxI.getSuggestThreshold());
        this.f525qGY.setImeOptions(this.f523nxI.getImeOptions());
        int inputType = this.f523nxI.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f523nxI.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f525qGY.setInputType(inputType);
        AbstractC2092HL abstractC2092HL = this.f499NPj;
        if (abstractC2092HL != null) {
            abstractC2092HL.mo8541mjFkc(null);
        }
        if (this.f523nxI.getSuggestAuthority() != null) {
            ViewOnClickListenerC4461r7 viewOnClickListenerC4461r7 = new ViewOnClickListenerC4461r7(getContext(), this, this.f523nxI, this.f503SwgkN);
            this.f499NPj = viewOnClickListenerC4461r7;
            this.f525qGY.setAdapter(viewOnClickListenerC4461r7);
            ((ViewOnClickListenerC4461r7) this.f499NPj).m13341Gd(this.f512aqHPIZ ? 2 : 1);
        }
    }

    /* renamed from: lB */
    public final Intent m258lB(Cursor cursor, int i, String str) {
        int position;
        String strM13338rkYL;
        try {
            String strM13338rkYL2 = ViewOnClickListenerC4461r7.m13338rkYL(cursor, "suggest_intent_action");
            if (strM13338rkYL2 == null) {
                strM13338rkYL2 = this.f523nxI.getSuggestIntentAction();
            }
            if (strM13338rkYL2 == null) {
                strM13338rkYL2 = "android.intent.action.SEARCH";
            }
            String str2 = strM13338rkYL2;
            String strM13338rkYL3 = ViewOnClickListenerC4461r7.m13338rkYL(cursor, "suggest_intent_data");
            if (strM13338rkYL3 == null) {
                strM13338rkYL3 = this.f523nxI.getSuggestIntentData();
            }
            if (strM13338rkYL3 != null && (strM13338rkYL = ViewOnClickListenerC4461r7.m13338rkYL(cursor, "suggest_intent_data_id")) != null) {
                strM13338rkYL3 = strM13338rkYL3 + "/" + Uri.encode(strM13338rkYL);
            }
            return m233BAnRFn(str2, strM13338rkYL3 == null ? null : Uri.parse(strM13338rkYL3), ViewOnClickListenerC4461r7.m13338rkYL(cursor, "suggest_intent_extra_data"), ViewOnClickListenerC4461r7.m13338rkYL(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            return null;
        }
    }

    /* renamed from: mByQ */
    public final Intent m259mByQ(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: nxI */
    public void m260nxI() {
        SearchableInfo searchableInfo = this.f523nxI;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m259mByQ(this.f488CqaNbM, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m266wJVbdd(this.f531xrEuO, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* renamed from: oCFDzJ */
    public void m261oCFDzJ() {
        if (!TextUtils.isEmpty(this.f525qGY.getText())) {
            this.f525qGY.setText(BuildConfig.f24315FLAVOR);
            this.f525qGY.requestFocus();
            this.f525qGY.setImeVisibility(true);
        } else if (this.f526rWxwaT) {
            clearFocus();
            m256dm(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f510XV);
        post(this.f513bbzow);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m234CqaNbM(this.f525qGY, this.f528vI);
            Rect rect = this.f507VocHEe;
            Rect rect2 = this.f528vI;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            C0036fehf c0036fehf = this.f491HGpJ;
            if (c0036fehf != null) {
                c0036fehf.m274mjFkc(this.f507VocHEe, this.f528vI);
                return;
            }
            C0036fehf c0036fehf2 = new C0036fehf(this.f507VocHEe, this.f528vI, this.f525qGY);
            this.f491HGpJ = c0036fehf2;
            setTouchDelegate(c0036fehf2);
        }
    }

    @Override // androidx.appcompat.p012widget.AbstractC0013AZxh, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (m268zvd()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f498KRTLGT;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f498KRTLGT;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.f498KRTLGT) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0039qGY)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0039qGY c0039qGY = (C0039qGY) parcelable;
        super.onRestoreInstanceState(c0039qGY.m13824mjFkc());
        m256dm(c0039qGY.f552wA);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0039qGY c0039qGY = new C0039qGY(super.onSaveInstanceState());
        c0039qGY.f552wA = m268zvd();
        return c0039qGY;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m250WGXroI();
    }

    /* renamed from: rWxwaT */
    public final boolean m262rWxwaT() {
        return (this.f529vadzgd || this.f489GMIER) && !m268zvd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f509WrLQs || !isFocusable()) {
            return false;
        }
        if (m268zvd()) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.f525qGY.requestFocus(i, rect);
        if (zRequestFocus) {
            m256dm(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f508WGXroI = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m261oCFDzJ();
        } else {
            m235GMIER();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f526rWxwaT == z) {
            return;
        }
        this.f526rWxwaT = z;
        m256dm(z);
        m247Vdz();
    }

    public void setImeOptions(int i) {
        this.f525qGY.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f525qGY.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f498KRTLGT = i;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC0033VA interfaceC0033VA) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f532zvd = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0031MiMN interfaceC0031MiMN) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f514cMLeY = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC0034YoKzxo interfaceC0034YoKzxo) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f524oCFDzJ = charSequence;
        m247Vdz();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f512aqHPIZ = z;
        AbstractC2092HL abstractC2092HL = this.f499NPj;
        if (abstractC2092HL instanceof ViewOnClickListenerC4461r7) {
            ((ViewOnClickListenerC4461r7) abstractC2092HL).m13341Gd(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f523nxI = searchableInfo;
        if (searchableInfo != null) {
            m257jm();
            m247Vdz();
        }
        boolean zM241KLMXS = m241KLMXS();
        this.f489GMIER = zM241KLMXS;
        if (zM241KLMXS) {
            this.f525qGY.setPrivateImeOptions("nm");
        }
        m256dm(m268zvd());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f529vadzgd = z;
        m256dm(m268zvd());
    }

    public void setSuggestionsAdapter(AbstractC2092HL abstractC2092HL) {
        this.f499NPj = abstractC2092HL;
        this.f525qGY.setAdapter(abstractC2092HL);
    }

    /* renamed from: tQ */
    public final void m263tQ(boolean z) {
        int i = 8;
        if (this.f489GMIER && !m268zvd() && z) {
            this.f517eyqo.setVisibility(8);
            i = 0;
        }
        this.f519huTpC.setVisibility(i);
    }

    /* renamed from: uHVRx */
    public void m264uHVRx() {
        Editable text = this.f525qGY.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f523nxI != null) {
            m243NPj(0, null, text.toString());
        }
        this.f525qGY.setImeVisibility(false);
        m245OjSQV();
    }

    /* renamed from: vadzgd */
    public final boolean m265vadzgd(int i, int i2, String str) {
        Cursor cursorMo8536AZxh = this.f499NPj.mo8536AZxh();
        if (cursorMo8536AZxh == null || !cursorMo8536AZxh.moveToPosition(i)) {
            return false;
        }
        m248Vnb(m258lB(cursorMo8536AZxh, i2, str));
        return true;
    }

    /* renamed from: wJVbdd */
    public final Intent m266wJVbdd(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f508WGXroI;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: xrEuO */
    public final CharSequence m267xrEuO(CharSequence charSequence) {
        if (!this.f526rWxwaT || this.f522mByQ == null) {
            return charSequence;
        }
        int textSize = (int) (this.f525qGY.getTextSize() * 1.25d);
        this.f522mByQ.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f522mByQ), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: zvd */
    public boolean m268zvd() {
        return this.f506Vnb;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3862i4.f14114fehf);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f528vI = new Rect();
        this.f507VocHEe = new Rect();
        this.f487BAnRFn = new int[2];
        this.f521lB = new int[2];
        this.f510XV = new RunnableC0026AZxh();
        this.f513bbzow = new RunnableC0042wA();
        this.f503SwgkN = new WeakHashMap();
        ViewOnClickListenerC0029JHa viewOnClickListenerC0029JHa = new ViewOnClickListenerC0029JHa();
        this.f493JBhc = viewOnClickListenerC0029JHa;
        this.f505Vdz = new ViewOnKeyListenerC0043xJ();
        C0037lgHUyS c0037lgHUyS = new C0037lgHUyS();
        this.f520jm = c0037lgHUyS;
        C0040qdMbNW c0040qdMbNW = new C0040qdMbNW();
        this.f486ANMGZc = c0040qdMbNW;
        C0027Dt c0027Dt = new C0027Dt();
        this.f511alEkx = c0027Dt;
        this.f516dm = new C0038mjFkc();
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f12924Tw, i, 0);
        AbstractC2876T9.m10277jm(this, context, AbstractC3407b5.f12924Tw, attributeSet, c1606a8M7575diqgf.m7589qGY(), i, 0);
        LayoutInflater.from(context).inflate(c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13017tpGcn, AbstractC2139I4.f8672VA), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(AbstractC1865E4.f7945diqgf);
        this.f525qGY = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f518fehf = findViewById(AbstractC1865E4.f7951qGY);
        View viewFindViewById = findViewById(AbstractC1865E4.f7939Pq);
        this.f492IEE = viewFindViewById;
        View viewFindViewById2 = findViewById(AbstractC1865E4.f7954vI);
        this.f502Pq = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(AbstractC1865E4.f7943YoKzxo);
        this.f515diqgf = imageView;
        ImageView imageView2 = (ImageView) findViewById(AbstractC1865E4.f7947fehf);
        this.f517eyqo = imageView2;
        ImageView imageView3 = (ImageView) findViewById(AbstractC1865E4.f7953rkYL);
        this.f504Ucbh = imageView3;
        ImageView imageView4 = (ImageView) findViewById(AbstractC1865E4.f7946eyqo);
        this.f519huTpC = imageView4;
        ImageView imageView5 = (ImageView) findViewById(AbstractC1865E4.f7935IEE);
        this.f530wJVbdd = imageView5;
        AbstractC2876T9.m10294vjlshU(viewFindViewById, c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f13003qGgY));
        AbstractC2876T9.m10294vjlshU(viewFindViewById2, c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12882JOe));
        imageView.setImageDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12860ERt));
        imageView2.setImageDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f13040yP));
        imageView3.setImageDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f13033xCVa));
        imageView4.setImageDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12994np));
        imageView5.setImageDrawable(c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12860ERt));
        this.f522mByQ = c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12865FOJ);
        AbstractC2143I8.m8717mjFkc(imageView, getResources().getString(AbstractC2545O4.f9909VA));
        this.f501OjSQV = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f13000pJeaSR, AbstractC2139I4.f8669ETF);
        this.f500Ne = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12957bc, 0);
        imageView.setOnClickListener(viewOnClickListenerC0029JHa);
        imageView3.setOnClickListener(viewOnClickListenerC0029JHa);
        imageView2.setOnClickListener(viewOnClickListenerC0029JHa);
        imageView4.setOnClickListener(viewOnClickListenerC0029JHa);
        searchAutoComplete.setOnClickListener(viewOnClickListenerC0029JHa);
        searchAutoComplete.addTextChangedListener(this.f516dm);
        searchAutoComplete.setOnEditorActionListener(c0037lgHUyS);
        searchAutoComplete.setOnItemClickListener(c0040qdMbNW);
        searchAutoComplete.setOnItemSelectedListener(c0027Dt);
        searchAutoComplete.setOnKeyListener(this.f505Vdz);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0035ZfxDd());
        setIconifiedByDefault(c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f13021ui, true));
        int iM7579JHa = c1606a8M7575diqgf.m7579JHa(AbstractC3407b5.f12896LsBneK, -1);
        if (iM7579JHa != -1) {
            setMaxWidth(iM7579JHa);
        }
        this.f497KLMXS = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f13031wLtdyQ);
        this.f524oCFDzJ = c1606a8M7575diqgf.m7591rkYL(AbstractC3407b5.f13024vUsV);
        int iM7577Dt = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f13020ub, -1);
        if (iM7577Dt != -1) {
            setImeOptions(iM7577Dt);
        }
        int iM7577Dt2 = c1606a8M7575diqgf.m7577Dt(AbstractC3407b5.f12993nUaNy, -1);
        if (iM7577Dt2 != -1) {
            setInputType(iM7577Dt2);
        }
        setFocusable(c1606a8M7575diqgf.m7588mjFkc(AbstractC3407b5.f12912QyqF, true));
        c1606a8M7575diqgf.m7585eyqo();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f488CqaNbM = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f531xrEuO = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f490Gd = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0030KLFTb());
        }
        m256dm(this.f526rWxwaT);
        m247Vdz();
    }
}
