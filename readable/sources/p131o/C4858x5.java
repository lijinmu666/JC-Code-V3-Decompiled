package p131o;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: o.x5 */
/* loaded from: classes.dex */
public final class C4858x5 extends AbstractC2225JHa {

    /* renamed from: AZxh */
    public final Set f17315AZxh;

    /* renamed from: JHa */
    public final Set f17316JHa;

    /* renamed from: KLFTb */
    public final Set f17317KLFTb;

    /* renamed from: ZfxDd */
    public final Set f17318ZfxDd;

    /* renamed from: mjFkc */
    public final Set f17319mjFkc;

    /* renamed from: wA */
    public final Set f17320wA;

    /* renamed from: xJ */
    public final InterfaceC4803wGscSa f17321xJ;

    /* renamed from: o.x5$mjFkc */
    public static class mjFkc implements InterfaceC3406b4 {

        /* renamed from: AZxh */
        public final InterfaceC3406b4 f17322AZxh;

        /* renamed from: mjFkc */
        public final Set f17323mjFkc;

        public mjFkc(Set set, InterfaceC3406b4 interfaceC3406b4) {
            this.f17323mjFkc = set;
            this.f17322AZxh = interfaceC3406b4;
        }
    }

    public C4858x5(C2957UOnCkw c2957UOnCkw, InterfaceC4803wGscSa interfaceC4803wGscSa) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (C4441qqdo c4441qqdo : c2957UOnCkw.m10498wA()) {
            if (c4441qqdo.m13304ZfxDd()) {
                if (c4441qqdo.m13302JHa()) {
                    hashSet4.add(c4441qqdo.m13301AZxh());
                } else {
                    hashSet.add(c4441qqdo.m13301AZxh());
                }
            } else if (c4441qqdo.m13306wA()) {
                hashSet3.add(c4441qqdo.m13301AZxh());
            } else if (c4441qqdo.m13302JHa()) {
                hashSet5.add(c4441qqdo.m13301AZxh());
            } else {
                hashSet2.add(c4441qqdo.m13301AZxh());
            }
        }
        if (!c2957UOnCkw.m10493JHa().isEmpty()) {
            hashSet.add(InterfaceC3406b4.class);
        }
        this.f17319mjFkc = Collections.unmodifiableSet(hashSet);
        this.f17315AZxh = Collections.unmodifiableSet(hashSet2);
        this.f17320wA = Collections.unmodifiableSet(hashSet3);
        this.f17318ZfxDd = Collections.unmodifiableSet(hashSet4);
        this.f17317KLFTb = Collections.unmodifiableSet(hashSet5);
        this.f17316JHa = c2957UOnCkw.m10493JHa();
        this.f17321xJ = interfaceC4803wGscSa;
    }

    @Override // p131o.AbstractC2225JHa, p131o.InterfaceC4803wGscSa
    /* renamed from: AZxh */
    public Set mo8923AZxh(Class cls) {
        if (this.f17318ZfxDd.contains(cls)) {
            return this.f17321xJ.mo8923AZxh(cls);
        }
        throw new C2269JtIAgM(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // p131o.InterfaceC4803wGscSa
    /* renamed from: ZfxDd */
    public InterfaceC3339a4 mo13844ZfxDd(Class cls) {
        if (this.f17317KLFTb.contains(cls)) {
            return this.f17321xJ.mo13844ZfxDd(cls);
        }
        throw new C2269JtIAgM(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // p131o.AbstractC2225JHa, p131o.InterfaceC4803wGscSa
    /* renamed from: mjFkc */
    public Object mo8924mjFkc(Class cls) {
        if (!this.f17319mjFkc.contains(cls)) {
            throw new C2269JtIAgM(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objMo8924mjFkc = this.f17321xJ.mo8924mjFkc(cls);
        return !cls.equals(InterfaceC3406b4.class) ? objMo8924mjFkc : new mjFkc(this.f17316JHa, (InterfaceC3406b4) objMo8924mjFkc);
    }

    @Override // p131o.InterfaceC4803wGscSa
    /* renamed from: wA */
    public InterfaceC3339a4 mo13845wA(Class cls) {
        if (this.f17315AZxh.contains(cls)) {
            return this.f17321xJ.mo13845wA(cls);
        }
        throw new C2269JtIAgM(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }
}
