package p131o;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: o.zPp */
/* loaded from: classes.dex */
public final class C5011zPp {

    /* renamed from: AZxh */
    public final Set f17659AZxh;

    /* renamed from: Dt */
    public Integer f17660Dt;

    /* renamed from: JHa */
    public final View f17661JHa;

    /* renamed from: KLFTb */
    public final int f17662KLFTb;

    /* renamed from: ZfxDd */
    public final Map f17663ZfxDd;

    /* renamed from: lgHUyS */
    public final String f17664lgHUyS;

    /* renamed from: mjFkc */
    public final Account f17665mjFkc;

    /* renamed from: qdMbNW */
    public final C3007V6 f17666qdMbNW;

    /* renamed from: wA */
    public final Set f17667wA;

    /* renamed from: xJ */
    public final String f17668xJ;

    /* renamed from: o.zPp$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public C3762gYa f17669AZxh;

        /* renamed from: KLFTb */
        public final C3007V6 f17670KLFTb = C3007V6.f11270ETF;

        /* renamed from: ZfxDd */
        public String f17671ZfxDd;

        /* renamed from: mjFkc */
        public Account f17672mjFkc;

        /* renamed from: wA */
        public String f17673wA;

        /* renamed from: AZxh */
        public mjFkc m14106AZxh(String str) {
            this.f17673wA = str;
            return this;
        }

        /* renamed from: KLFTb */
        public final mjFkc m14107KLFTb(String str) {
            this.f17671ZfxDd = str;
            return this;
        }

        /* renamed from: ZfxDd */
        public final mjFkc m14108ZfxDd(Account account) {
            this.f17672mjFkc = account;
            return this;
        }

        /* renamed from: mjFkc */
        public C5011zPp m14109mjFkc() {
            return new C5011zPp(this.f17672mjFkc, this.f17669AZxh, null, 0, null, this.f17673wA, this.f17671ZfxDd, this.f17670KLFTb, false);
        }

        /* renamed from: wA */
        public final mjFkc m14110wA(Collection collection) {
            if (this.f17669AZxh == null) {
                this.f17669AZxh = new C3762gYa();
            }
            this.f17669AZxh.addAll(collection);
            return this;
        }
    }

    public C5011zPp(Account account, Set set, Map map, int i, View view, String str, String str2, C3007V6 c3007v6, boolean z) {
        this.f17665mjFkc = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f17659AZxh = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f17663ZfxDd = map;
        this.f17661JHa = view;
        this.f17662KLFTb = i;
        this.f17668xJ = str;
        this.f17664lgHUyS = str2;
        this.f17666qdMbNW = c3007v6 == null ? C3007V6.f11270ETF : c3007v6;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
        this.f17667wA = Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: AZxh */
    public Account m14097AZxh() {
        Account account = this.f17665mjFkc;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    /* renamed from: JHa */
    public final C3007V6 m14098JHa() {
        return this.f17666qdMbNW;
    }

    /* renamed from: KLFTb */
    public Set m14099KLFTb() {
        return this.f17659AZxh;
    }

    /* renamed from: ZfxDd */
    public String m14100ZfxDd() {
        return this.f17668xJ;
    }

    /* renamed from: lgHUyS */
    public final String m14101lgHUyS() {
        return this.f17664lgHUyS;
    }

    /* renamed from: mjFkc */
    public Account m14102mjFkc() {
        return this.f17665mjFkc;
    }

    /* renamed from: qdMbNW */
    public final void m14103qdMbNW(Integer num) {
        this.f17660Dt = num;
    }

    /* renamed from: wA */
    public Set m14104wA() {
        return this.f17667wA;
    }

    /* renamed from: xJ */
    public final Integer m14105xJ() {
        return this.f17660Dt;
    }
}
