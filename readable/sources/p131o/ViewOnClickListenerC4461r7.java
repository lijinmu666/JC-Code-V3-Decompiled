package p131o;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.p012widget.SearchView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import org.conscrypt.BuildConfig;

/* renamed from: o.r7 */
/* loaded from: classes.dex */
public class ViewOnClickListenerC4461r7 extends AbstractC4323p5 implements View.OnClickListener {

    /* renamed from: Gd */
    public int f16288Gd;

    /* renamed from: HGpJ */
    public int f16289HGpJ;

    /* renamed from: IEE */
    public int f16290IEE;

    /* renamed from: MiMN */
    public final SearchableInfo f16291MiMN;

    /* renamed from: Pq */
    public ColorStateList f16292Pq;

    /* renamed from: Ucbh */
    public int f16293Ucbh;

    /* renamed from: VA */
    public final SearchView f16294VA;

    /* renamed from: YoKzxo */
    public final Context f16295YoKzxo;

    /* renamed from: diqgf */
    public int f16296diqgf;

    /* renamed from: eyqo */
    public int f16297eyqo;

    /* renamed from: fehf */
    public boolean f16298fehf;

    /* renamed from: huTpC */
    public int f16299huTpC;

    /* renamed from: qGY */
    public final int f16300qGY;

    /* renamed from: rkYL */
    public final WeakHashMap f16301rkYL;

    /* renamed from: o.r7$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public final TextView f16302AZxh;

        /* renamed from: KLFTb */
        public final ImageView f16303KLFTb;

        /* renamed from: ZfxDd */
        public final ImageView f16304ZfxDd;

        /* renamed from: mjFkc */
        public final TextView f16305mjFkc;

        /* renamed from: wA */
        public final ImageView f16306wA;

        public mjFkc(View view) {
            this.f16305mjFkc = (TextView) view.findViewById(R.id.text1);
            this.f16302AZxh = (TextView) view.findViewById(R.id.text2);
            this.f16306wA = (ImageView) view.findViewById(R.id.icon1);
            this.f16304ZfxDd = (ImageView) view.findViewById(R.id.icon2);
            this.f16303KLFTb = (ImageView) view.findViewById(AbstractC1865E4.f7941VA);
        }
    }

    public ViewOnClickListenerC4461r7(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f16298fehf = false;
        this.f16290IEE = 1;
        this.f16296diqgf = -1;
        this.f16297eyqo = -1;
        this.f16293Ucbh = -1;
        this.f16299huTpC = -1;
        this.f16288Gd = -1;
        this.f16289HGpJ = -1;
        this.f16294VA = searchView;
        this.f16291MiMN = searchableInfo;
        this.f16300qGY = searchView.getSuggestionCommitIconResId();
        this.f16295YoKzxo = context;
        this.f16301rkYL = weakHashMap;
    }

    /* renamed from: huTpC */
    public static String m13337huTpC(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: rkYL */
    public static String m13338rkYL(Cursor cursor, String str) {
        return m13337huTpC(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: BAnRFn */
    public final void m13339BAnRFn(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    /* renamed from: ETF */
    public final Drawable m13340ETF(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f16301rkYL.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: Gd */
    public void m13341Gd(int i) {
        this.f16290IEE = i;
    }

    /* renamed from: HGpJ */
    public final void m13342HGpJ(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: IEE */
    public Drawable m13343IEE(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f16295YoKzxo.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // p131o.AbstractC2092HL
    /* renamed from: KLFTb */
    public void mo8539KLFTb(View view, Context context, Cursor cursor) {
        mjFkc mjfkc = (mjFkc) view.getTag();
        int i = this.f16289HGpJ;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (mjfkc.f16305mjFkc != null) {
            m13354vI(mjfkc.f16305mjFkc, m13337huTpC(cursor, this.f16296diqgf));
        }
        if (mjfkc.f16302AZxh != null) {
            String strM13337huTpC = m13337huTpC(cursor, this.f16293Ucbh);
            CharSequence charSequenceM13347VA = strM13337huTpC != null ? m13347VA(strM13337huTpC) : m13337huTpC(cursor, this.f16297eyqo);
            if (TextUtils.isEmpty(charSequenceM13347VA)) {
                TextView textView = mjfkc.f16305mjFkc;
                if (textView != null) {
                    textView.setSingleLine(false);
                    mjfkc.f16305mjFkc.setMaxLines(2);
                }
            } else {
                TextView textView2 = mjfkc.f16305mjFkc;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    mjfkc.f16305mjFkc.setMaxLines(1);
                }
            }
            m13354vI(mjfkc.f16302AZxh, charSequenceM13347VA);
        }
        ImageView imageView = mjfkc.f16306wA;
        if (imageView != null) {
            m13342HGpJ(imageView, m13350diqgf(cursor), 4);
        }
        ImageView imageView2 = mjfkc.f16304ZfxDd;
        if (imageView2 != null) {
            m13342HGpJ(imageView2, m13351eyqo(cursor), 8);
        }
        int i3 = this.f16290IEE;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            mjfkc.f16303KLFTb.setVisibility(8);
            return;
        }
        mjfkc.f16303KLFTb.setVisibility(0);
        mjfkc.f16303KLFTb.setTag(mjfkc.f16305mjFkc.getText());
        mjfkc.f16303KLFTb.setOnClickListener(this);
    }

    /* renamed from: MiMN */
    public final Drawable m13344MiMN(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f16295YoKzxo.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* renamed from: Pq */
    public final Drawable m13345Pq(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f16295YoKzxo.getPackageName() + "/" + i;
            Drawable drawableM13340ETF = m13340ETF(str2);
            if (drawableM13340ETF != null) {
                return drawableM13340ETF;
            }
            Drawable drawableM12997wA = AbstractC4294ofHOBL.m12997wA(this.f16295YoKzxo, i);
            m13348VocHEe(str2, drawableM12997wA);
            return drawableM12997wA;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableM13340ETF2 = m13340ETF(str);
            if (drawableM13340ETF2 != null) {
                return drawableM13340ETF2;
            }
            Drawable drawableM13352fehf = m13352fehf(Uri.parse(str));
            m13348VocHEe(str, drawableM13352fehf);
            return drawableM13352fehf;
        }
    }

    /* renamed from: Ucbh */
    public Cursor m13346Ucbh(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.f24315FLAVOR).fragment(BuildConfig.f24315FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f16295YoKzxo.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    /* renamed from: VA */
    public final CharSequence m13347VA(CharSequence charSequence) {
        if (this.f16292Pq == null) {
            TypedValue typedValue = new TypedValue();
            this.f16295YoKzxo.getTheme().resolveAttribute(AbstractC3862i4.f14105IEE, typedValue, true);
            this.f16292Pq = this.f16295YoKzxo.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f16292Pq, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: VocHEe */
    public final void m13348VocHEe(String str, Drawable drawable) {
        if (drawable != null) {
            this.f16301rkYL.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: YoKzxo */
    public final Drawable m13349YoKzxo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f16301rkYL.containsKey(strFlattenToShortString)) {
            Drawable drawableM13344MiMN = m13344MiMN(componentName);
            this.f16301rkYL.put(strFlattenToShortString, drawableM13344MiMN != null ? drawableM13344MiMN.getConstantState() : null);
            return drawableM13344MiMN;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f16301rkYL.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f16295YoKzxo.getResources());
    }

    @Override // p131o.C2709QfniOH.mjFkc
    /* renamed from: ZfxDd */
    public Cursor mo10016ZfxDd(CharSequence charSequence) {
        String string = charSequence == null ? BuildConfig.f24315FLAVOR : charSequence.toString();
        if (this.f16294VA.getVisibility() == 0 && this.f16294VA.getWindowVisibility() == 0) {
            try {
                Cursor cursorM13346Ucbh = m13346Ucbh(this.f16291MiMN, string, 50);
                if (cursorM13346Ucbh != null) {
                    cursorM13346Ucbh.getCount();
                    return cursorM13346Ucbh;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    /* renamed from: diqgf */
    public final Drawable m13350diqgf(Cursor cursor) throws NumberFormatException, IOException {
        int i = this.f16299huTpC;
        if (i == -1) {
            return null;
        }
        Drawable drawableM13345Pq = m13345Pq(cursor.getString(i));
        return drawableM13345Pq != null ? drawableM13345Pq : m13353qGY();
    }

    /* renamed from: eyqo */
    public final Drawable m13351eyqo(Cursor cursor) {
        int i = this.f16288Gd;
        if (i == -1) {
            return null;
        }
        return m13345Pq(cursor.getString(i));
    }

    /* renamed from: fehf */
    public final Drawable m13352fehf(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m13343IEE(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f16295YoKzxo.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    @Override // p131o.AbstractC2092HL, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo8544xJ = this.mo8544xJ(this.f16295YoKzxo, this.mo8536AZxh(), viewGroup);
            if (viewMo8544xJ != null) {
                ((mjFkc) viewMo8544xJ.getTag()).f16305mjFkc.setText(e.toString());
            }
            return viewMo8544xJ;
        }
    }

    @Override // p131o.AbstractC2092HL, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo8540lgHUyS = this.mo8540lgHUyS(this.f16295YoKzxo, this.mo8536AZxh(), viewGroup);
            if (viewMo8540lgHUyS != null) {
                ((mjFkc) viewMo8540lgHUyS.getTag()).f16305mjFkc.setText(e.toString());
            }
            return viewMo8540lgHUyS;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // p131o.AbstractC4323p5, p131o.AbstractC2092HL
    /* renamed from: lgHUyS */
    public View mo8540lgHUyS(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo8540lgHUyS = super.mo8540lgHUyS(context, cursor, viewGroup);
        viewMo8540lgHUyS.setTag(new mjFkc(viewMo8540lgHUyS));
        ((ImageView) viewMo8540lgHUyS.findViewById(AbstractC1865E4.f7941VA)).setImageResource(this.f16300qGY);
        return viewMo8540lgHUyS;
    }

    @Override // p131o.AbstractC2092HL, p131o.C2709QfniOH.mjFkc
    /* renamed from: mjFkc */
    public void mo8541mjFkc(Cursor cursor) {
        if (this.f16298fehf) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo8541mjFkc(cursor);
            if (cursor != null) {
                this.f16296diqgf = cursor.getColumnIndex("suggest_text_1");
                this.f16297eyqo = cursor.getColumnIndex("suggest_text_2");
                this.f16293Ucbh = cursor.getColumnIndex("suggest_text_2_url");
                this.f16299huTpC = cursor.getColumnIndex("suggest_icon_1");
                this.f16288Gd = cursor.getColumnIndex("suggest_icon_2");
                this.f16289HGpJ = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m13339BAnRFn(mo8536AZxh());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m13339BAnRFn(mo8536AZxh());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f16294VA.m242KRTLGT((CharSequence) tag);
        }
    }

    /* renamed from: qGY */
    public final Drawable m13353qGY() throws PackageManager.NameNotFoundException {
        Drawable drawableM13349YoKzxo = m13349YoKzxo(this.f16291MiMN.getSearchActivity());
        return drawableM13349YoKzxo != null ? drawableM13349YoKzxo : this.f16295YoKzxo.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: vI */
    public final void m13354vI(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // p131o.AbstractC2092HL, p131o.C2709QfniOH.mjFkc
    /* renamed from: wA */
    public CharSequence mo8543wA(Cursor cursor) {
        String strM13338rkYL;
        String strM13338rkYL2;
        if (cursor == null) {
            return null;
        }
        String strM13338rkYL3 = m13338rkYL(cursor, "suggest_intent_query");
        if (strM13338rkYL3 != null) {
            return strM13338rkYL3;
        }
        if (this.f16291MiMN.shouldRewriteQueryFromData() && (strM13338rkYL2 = m13338rkYL(cursor, "suggest_intent_data")) != null) {
            return strM13338rkYL2;
        }
        if (!this.f16291MiMN.shouldRewriteQueryFromText() || (strM13338rkYL = m13338rkYL(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM13338rkYL;
    }
}
