package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C3787gtIJp;
import p131o.C3802h6;
import p131o.C4651tyXzYJ;
import p131o.InterfaceC3001V0;
import p131o.InterfaceC3068W0;

/* renamed from: androidx.lifecycle.JHa */
/* loaded from: classes.dex */
public class C0103JHa extends AbstractC0112wA {

    /* renamed from: Dt */
    public static final mjFkc f1343Dt = new mjFkc(null);

    /* renamed from: AZxh */
    public final boolean f1344AZxh;

    /* renamed from: JHa */
    public int f1345JHa;

    /* renamed from: KLFTb */
    public final WeakReference f1346KLFTb;

    /* renamed from: ZfxDd */
    public AbstractC0112wA.AZxh f1347ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f1348lgHUyS;

    /* renamed from: qdMbNW */
    public ArrayList f1349qdMbNW;

    /* renamed from: wA */
    public C4651tyXzYJ f1350wA;

    /* renamed from: xJ */
    public boolean f1351xJ;

    /* renamed from: androidx.lifecycle.JHa$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public InterfaceC0104KLFTb f1352AZxh;

        /* renamed from: mjFkc */
        public AbstractC0112wA.AZxh f1353mjFkc;

        public AZxh(InterfaceC3001V0 interfaceC3001V0, AbstractC0112wA.AZxh initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(interfaceC3001V0);
            this.f1352AZxh = C0113xJ.m1105JHa(interfaceC3001V0);
            this.f1353mjFkc = initialState;
        }

        /* renamed from: AZxh */
        public final AbstractC0112wA.AZxh m1048AZxh() {
            return this.f1353mjFkc;
        }

        /* renamed from: mjFkc */
        public final void m1049mjFkc(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AbstractC0112wA.AZxh aZxhM1102lgHUyS = event.m1102lgHUyS();
            this.f1353mjFkc = C0103JHa.f1343Dt.m1050mjFkc(this.f1353mjFkc, aZxhM1102lgHUyS);
            InterfaceC0104KLFTb interfaceC0104KLFTb = this.f1352AZxh;
            Intrinsics.checkNotNull(interfaceC3068W0);
            interfaceC0104KLFTb.mo4VA(interfaceC3068W0, event);
            this.f1353mjFkc = aZxhM1102lgHUyS;
        }
    }

    /* renamed from: androidx.lifecycle.JHa$mjFkc */
    public static final class mjFkc {
        public /* synthetic */ mjFkc(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: mjFkc */
        public final AbstractC0112wA.AZxh m1050mjFkc(AbstractC0112wA.AZxh state1, AbstractC0112wA.AZxh aZxh) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            return (aZxh == null || aZxh.compareTo(state1) >= 0) ? state1 : aZxh;
        }

        public mjFkc() {
        }
    }

    public C0103JHa(InterfaceC3068W0 interfaceC3068W0, boolean z) {
        this.f1344AZxh = z;
        this.f1350wA = new C4651tyXzYJ();
        this.f1347ZfxDd = AbstractC0112wA.AZxh.INITIALIZED;
        this.f1349qdMbNW = new ArrayList();
        this.f1346KLFTb = new WeakReference(interfaceC3068W0);
    }

    @Override // androidx.lifecycle.AbstractC0112wA
    /* renamed from: AZxh */
    public AbstractC0112wA.AZxh mo1035AZxh() {
        return this.f1347ZfxDd;
    }

    /* renamed from: Dt */
    public final void m1036Dt(AbstractC0112wA.AZxh aZxh) {
        AbstractC0112wA.AZxh aZxh2 = this.f1347ZfxDd;
        if (aZxh2 == aZxh) {
            return;
        }
        if (aZxh2 == AbstractC0112wA.AZxh.INITIALIZED && aZxh == AbstractC0112wA.AZxh.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f1347ZfxDd + " in component " + this.f1346KLFTb.get()).toString());
        }
        this.f1347ZfxDd = aZxh;
        if (this.f1351xJ || this.f1345JHa != 0) {
            this.f1348lgHUyS = true;
            return;
        }
        this.f1351xJ = true;
        m1040MiMN();
        this.f1351xJ = false;
        if (this.f1347ZfxDd == AbstractC0112wA.AZxh.DESTROYED) {
            this.f1350wA = new C4651tyXzYJ();
        }
    }

    /* renamed from: ETF */
    public final void m1037ETF() {
        this.f1349qdMbNW.remove(r1.size() - 1);
    }

    /* renamed from: JHa */
    public final void m1038JHa(String str) {
        if (!this.f1344AZxh || C3787gtIJp.m12108JHa().mo8107AZxh()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    /* renamed from: KLFTb */
    public final AbstractC0112wA.AZxh m1039KLFTb(InterfaceC3001V0 interfaceC3001V0) {
        AZxh aZxh;
        Map.Entry entryM13659VA = this.f1350wA.m13659VA(interfaceC3001V0);
        AbstractC0112wA.AZxh aZxh2 = null;
        AbstractC0112wA.AZxh aZxhM1048AZxh = (entryM13659VA == null || (aZxh = (AZxh) entryM13659VA.getValue()) == null) ? null : aZxh.m1048AZxh();
        if (!this.f1349qdMbNW.isEmpty()) {
            aZxh2 = (AbstractC0112wA.AZxh) this.f1349qdMbNW.get(r0.size() - 1);
        }
        mjFkc mjfkc = f1343Dt;
        return mjfkc.m1050mjFkc(mjfkc.m1050mjFkc(this.f1347ZfxDd, aZxhM1048AZxh), aZxh2);
    }

    /* renamed from: MiMN */
    public final void m1040MiMN() {
        InterfaceC3068W0 interfaceC3068W0 = (InterfaceC3068W0) this.f1346KLFTb.get();
        if (interfaceC3068W0 == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!m1045qdMbNW()) {
            this.f1348lgHUyS = false;
            AbstractC0112wA.AZxh aZxh = this.f1347ZfxDd;
            Map.Entry entryM12170ZfxDd = this.f1350wA.m12170ZfxDd();
            Intrinsics.checkNotNull(entryM12170ZfxDd);
            if (aZxh.compareTo(((AZxh) entryM12170ZfxDd.getValue()).m1048AZxh()) < 0) {
                m1042ZfxDd(interfaceC3068W0);
            }
            Map.Entry entryM12172lgHUyS = this.f1350wA.m12172lgHUyS();
            if (!this.f1348lgHUyS && entryM12172lgHUyS != null && this.f1347ZfxDd.compareTo(((AZxh) entryM12172lgHUyS.getValue()).m1048AZxh()) > 0) {
                m1047xJ(interfaceC3068W0);
            }
        }
        this.f1348lgHUyS = false;
    }

    /* renamed from: VA */
    public final void m1041VA(AbstractC0112wA.AZxh aZxh) {
        this.f1349qdMbNW.add(aZxh);
    }

    /* renamed from: ZfxDd */
    public final void m1042ZfxDd(InterfaceC3068W0 interfaceC3068W0) {
        Iterator itM12173mjFkc = this.f1350wA.m12173mjFkc();
        Intrinsics.checkNotNullExpressionValue(itM12173mjFkc, "observerMap.descendingIterator()");
        while (itM12173mjFkc.hasNext() && !this.f1348lgHUyS) {
            Map.Entry entry = (Map.Entry) itM12173mjFkc.next();
            Intrinsics.checkNotNullExpressionValue(entry, "next()");
            InterfaceC3001V0 interfaceC3001V0 = (InterfaceC3001V0) entry.getKey();
            AZxh aZxh = (AZxh) entry.getValue();
            while (aZxh.m1048AZxh().compareTo(this.f1347ZfxDd) > 0 && !this.f1348lgHUyS && this.f1350wA.contains(interfaceC3001V0)) {
                AbstractC0112wA.mjFkc mjfkcM1104mjFkc = AbstractC0112wA.mjFkc.Companion.m1104mjFkc(aZxh.m1048AZxh());
                if (mjfkcM1104mjFkc == null) {
                    throw new IllegalStateException("no event down from " + aZxh.m1048AZxh());
                }
                m1041VA(mjfkcM1104mjFkc.m1102lgHUyS());
                aZxh.m1049mjFkc(interfaceC3068W0, mjfkcM1104mjFkc);
                m1037ETF();
            }
        }
    }

    /* renamed from: lgHUyS */
    public void m1043lgHUyS(AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(event, "event");
        m1038JHa("handleLifecycleEvent");
        m1036Dt(event.m1102lgHUyS());
    }

    @Override // androidx.lifecycle.AbstractC0112wA
    /* renamed from: mjFkc */
    public void mo1044mjFkc(InterfaceC3001V0 observer) {
        InterfaceC3068W0 interfaceC3068W0;
        Intrinsics.checkNotNullParameter(observer, "observer");
        m1038JHa("addObserver");
        AbstractC0112wA.AZxh aZxh = this.f1347ZfxDd;
        AbstractC0112wA.AZxh aZxh2 = AbstractC0112wA.AZxh.DESTROYED;
        if (aZxh != aZxh2) {
            aZxh2 = AbstractC0112wA.AZxh.INITIALIZED;
        }
        AZxh aZxh3 = new AZxh(observer, aZxh2);
        if (((AZxh) this.f1350wA.mo12167Dt(observer, aZxh3)) == null && (interfaceC3068W0 = (InterfaceC3068W0) this.f1346KLFTb.get()) != null) {
            boolean z = this.f1345JHa != 0 || this.f1351xJ;
            AbstractC0112wA.AZxh aZxhM1039KLFTb = m1039KLFTb(observer);
            this.f1345JHa++;
            while (aZxh3.m1048AZxh().compareTo(aZxhM1039KLFTb) < 0 && this.f1350wA.contains(observer)) {
                m1041VA(aZxh3.m1048AZxh());
                AbstractC0112wA.mjFkc mjfkcM1103AZxh = AbstractC0112wA.mjFkc.Companion.m1103AZxh(aZxh3.m1048AZxh());
                if (mjfkcM1103AZxh == null) {
                    throw new IllegalStateException("no event up from " + aZxh3.m1048AZxh());
                }
                aZxh3.m1049mjFkc(interfaceC3068W0, mjfkcM1103AZxh);
                m1037ETF();
                aZxhM1039KLFTb = m1039KLFTb(observer);
            }
            if (!z) {
                m1040MiMN();
            }
            this.f1345JHa--;
        }
    }

    /* renamed from: qdMbNW */
    public final boolean m1045qdMbNW() {
        if (this.f1350wA.m12175size() == 0) {
            return true;
        }
        Map.Entry entryM12170ZfxDd = this.f1350wA.m12170ZfxDd();
        Intrinsics.checkNotNull(entryM12170ZfxDd);
        AbstractC0112wA.AZxh aZxhM1048AZxh = ((AZxh) entryM12170ZfxDd.getValue()).m1048AZxh();
        Map.Entry entryM12172lgHUyS = this.f1350wA.m12172lgHUyS();
        Intrinsics.checkNotNull(entryM12172lgHUyS);
        AbstractC0112wA.AZxh aZxhM1048AZxh2 = ((AZxh) entryM12172lgHUyS.getValue()).m1048AZxh();
        return aZxhM1048AZxh == aZxhM1048AZxh2 && this.f1347ZfxDd == aZxhM1048AZxh2;
    }

    @Override // androidx.lifecycle.AbstractC0112wA
    /* renamed from: wA */
    public void mo1046wA(InterfaceC3001V0 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        m1038JHa("removeObserver");
        this.f1350wA.mo12168ETF(observer);
    }

    /* renamed from: xJ */
    public final void m1047xJ(InterfaceC3068W0 interfaceC3068W0) {
        C3802h6.ZfxDd zfxDdM12176xJ = this.f1350wA.m12176xJ();
        Intrinsics.checkNotNullExpressionValue(zfxDdM12176xJ, "observerMap.iteratorWithAdditions()");
        while (zfxDdM12176xJ.hasNext() && !this.f1348lgHUyS) {
            Map.Entry entry = (Map.Entry) zfxDdM12176xJ.next();
            InterfaceC3001V0 interfaceC3001V0 = (InterfaceC3001V0) entry.getKey();
            AZxh aZxh = (AZxh) entry.getValue();
            while (aZxh.m1048AZxh().compareTo(this.f1347ZfxDd) < 0 && !this.f1348lgHUyS && this.f1350wA.contains(interfaceC3001V0)) {
                m1041VA(aZxh.m1048AZxh());
                AbstractC0112wA.mjFkc mjfkcM1103AZxh = AbstractC0112wA.mjFkc.Companion.m1103AZxh(aZxh.m1048AZxh());
                if (mjfkcM1103AZxh == null) {
                    throw new IllegalStateException("no event up from " + aZxh.m1048AZxh());
                }
                aZxh.m1049mjFkc(interfaceC3068W0, mjfkcM1103AZxh);
                m1037ETF();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0103JHa(InterfaceC3068W0 provider) {
        this(provider, true);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
