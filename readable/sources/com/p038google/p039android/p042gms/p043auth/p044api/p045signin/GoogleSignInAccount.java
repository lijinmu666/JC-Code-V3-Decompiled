package com.p038google.p039android.p042gms.p043auth.p044api.p045signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.p038google.p039android.p042gms.p046common.internal.ReflectedParcelable;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p131o.AbstractC1893ETF;
import p131o.AbstractC2138I3;
import p131o.AbstractC3997k6;
import p131o.C2982Ule;
import p131o.C3572dc;
import p131o.InterfaceC2420MC;

@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractC1893ETF implements ReflectedParcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<GoogleSignInAccount> f2226CREATOR = new C3572dc();

    /* renamed from: YoKzxo */
    public static final InterfaceC2420MC f2227YoKzxo = C2982Ule.m10642mjFkc();

    /* renamed from: AZxh */
    public final String f2228AZxh;

    /* renamed from: Dt */
    public final List f2229Dt;

    /* renamed from: ETF */
    public final String f2230ETF;

    /* renamed from: JHa */
    public final Uri f2231JHa;

    /* renamed from: KLFTb */
    public final String f2232KLFTb;

    /* renamed from: MiMN */
    public final Set f2233MiMN = new HashSet();

    /* renamed from: VA */
    public final String f2234VA;

    /* renamed from: ZfxDd */
    public final String f2235ZfxDd;

    /* renamed from: lgHUyS */
    public final long f2236lgHUyS;

    /* renamed from: mjFkc */
    public final int f2237mjFkc;

    /* renamed from: qdMbNW */
    public final String f2238qdMbNW;

    /* renamed from: wA */
    public final String f2239wA;

    /* renamed from: xJ */
    public String f2240xJ;

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.f2237mjFkc = i;
        this.f2228AZxh = str;
        this.f2239wA = str2;
        this.f2235ZfxDd = str3;
        this.f2232KLFTb = str4;
        this.f2231JHa = uri;
        this.f2240xJ = str5;
        this.f2236lgHUyS = j;
        this.f2238qdMbNW = str6;
        this.f2229Dt = list;
        this.f2230ETF = str7;
        this.f2234VA = str8;
    }

    /* renamed from: ETF */
    public static GoogleSignInAccount m2358ETF(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), AbstractC2138I3.m8642KLFTb(str7), new ArrayList((Collection) AbstractC2138I3.m8648xJ(set)), str5, str6);
    }

    /* renamed from: VA */
    public static GoogleSignInAccount m2359VA(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new C0209Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount googleSignInAccountM2358ETF = m2358ETF(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountM2358ETF.f2240xJ = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountM2358ETF;
    }

    /* renamed from: AZxh */
    public String m2360AZxh() {
        return this.f2235ZfxDd;
    }

    /* renamed from: Dt */
    public String m2361Dt() {
        return this.f2240xJ;
    }

    /* renamed from: JHa */
    public String m2362JHa() {
        return this.f2228AZxh;
    }

    /* renamed from: ZfxDd */
    public String m2363ZfxDd() {
        return this.f2230ETF;
    }

    /* renamed from: equals */
    public boolean m2364equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f2238qdMbNW.equals(this.f2238qdMbNW) && googleSignInAccount.m2367qdMbNW().equals(m2367qdMbNW());
    }

    public int hashCode() {
        return ((this.f2238qdMbNW.hashCode() + 527) * 31) + m2367qdMbNW().hashCode();
    }

    /* renamed from: lgHUyS */
    public Uri m2365lgHUyS() {
        return this.f2231JHa;
    }

    /* renamed from: mjFkc */
    public String m2366mjFkc() {
        return this.f2232KLFTb;
    }

    /* renamed from: qdMbNW */
    public Set m2367qdMbNW() {
        HashSet hashSet = new HashSet(this.f2229Dt);
        hashSet.addAll(this.f2233MiMN);
        return hashSet;
    }

    /* renamed from: wA */
    public String m2368wA() {
        return this.f2234VA;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f2237mjFkc);
        AbstractC3997k6.m12469ETF(parcel, 2, m2362JHa(), false);
        AbstractC3997k6.m12469ETF(parcel, 3, m2369xJ(), false);
        AbstractC3997k6.m12469ETF(parcel, 4, m2360AZxh(), false);
        AbstractC3997k6.m12469ETF(parcel, 5, m2366mjFkc(), false);
        AbstractC3997k6.m12468Dt(parcel, 6, m2365lgHUyS(), i, false);
        AbstractC3997k6.m12469ETF(parcel, 7, m2361Dt(), false);
        AbstractC3997k6.m12481qdMbNW(parcel, 8, this.f2236lgHUyS);
        AbstractC3997k6.m12469ETF(parcel, 9, this.f2238qdMbNW, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 10, this.f2229Dt, false);
        AbstractC3997k6.m12469ETF(parcel, 11, m2363ZfxDd(), false);
        AbstractC3997k6.m12469ETF(parcel, 12, m2368wA(), false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    /* renamed from: xJ */
    public String m2369xJ() {
        return this.f2239wA;
    }
}
