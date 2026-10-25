package p131o;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: o.UOnCkw */
/* loaded from: classes.dex */
public final class C2957UOnCkw {

    /* renamed from: AZxh */
    public final Set f10822AZxh;

    /* renamed from: JHa */
    public final Set f10823JHa;

    /* renamed from: KLFTb */
    public final InterfaceC2597Otxclu f10824KLFTb;

    /* renamed from: ZfxDd */
    public final int f10825ZfxDd;

    /* renamed from: mjFkc */
    public final Set f10826mjFkc;

    /* renamed from: wA */
    public final int f10827wA;

    /* renamed from: o.UOnCkw$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public final Set f10828AZxh;

        /* renamed from: JHa */
        public Set f10829JHa;

        /* renamed from: KLFTb */
        public InterfaceC2597Otxclu f10830KLFTb;

        /* renamed from: ZfxDd */
        public int f10831ZfxDd;

        /* renamed from: mjFkc */
        public final Set f10832mjFkc;

        /* renamed from: wA */
        public int f10833wA;

        /* renamed from: AZxh */
        public AZxh m10500AZxh(C4441qqdo c4441qqdo) {
            AbstractC2207J3.m8886wA(c4441qqdo, "Null dependency");
            m10501JHa(c4441qqdo.m13301AZxh());
            this.f10828AZxh.add(c4441qqdo);
            return this;
        }

        /* renamed from: JHa */
        public final void m10501JHa(Class cls) {
            AbstractC2207J3.m8885mjFkc(!this.f10832mjFkc.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        /* renamed from: KLFTb */
        public final AZxh m10502KLFTb() {
            this.f10831ZfxDd = 1;
            return this;
        }

        /* renamed from: ZfxDd */
        public AZxh m10503ZfxDd(InterfaceC2597Otxclu interfaceC2597Otxclu) {
            this.f10830KLFTb = (InterfaceC2597Otxclu) AbstractC2207J3.m8886wA(interfaceC2597Otxclu, "Null factory");
            return this;
        }

        /* renamed from: wA */
        public C2957UOnCkw m10504wA() {
            AbstractC2207J3.m8884ZfxDd(this.f10830KLFTb != null, "Missing required property: factory.");
            return new C2957UOnCkw(new HashSet(this.f10832mjFkc), new HashSet(this.f10828AZxh), this.f10833wA, this.f10831ZfxDd, this.f10830KLFTb, this.f10829JHa);
        }

        public AZxh(Class cls, Class... clsArr) {
            HashSet hashSet = new HashSet();
            this.f10832mjFkc = hashSet;
            this.f10828AZxh = new HashSet();
            this.f10833wA = 0;
            this.f10831ZfxDd = 0;
            this.f10829JHa = new HashSet();
            AbstractC2207J3.m8886wA(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                AbstractC2207J3.m8886wA(cls2, "Null interface");
            }
            Collections.addAll(this.f10832mjFkc, clsArr);
        }
    }

    /* renamed from: AZxh */
    public static AZxh m10487AZxh(Class cls, Class... clsArr) {
        return new AZxh(cls, clsArr);
    }

    /* renamed from: ETF */
    public static /* synthetic */ Object m10488ETF(Object obj, InterfaceC4803wGscSa interfaceC4803wGscSa) {
        return obj;
    }

    /* renamed from: VA */
    public static C2957UOnCkw m10489VA(Object obj, Class cls, Class... clsArr) {
        return m10487AZxh(cls, clsArr).m10503ZfxDd(C3957jY.m12438AZxh(obj)).m10504wA();
    }

    /* renamed from: mjFkc */
    public static AZxh m10490mjFkc(Class cls) {
        return new AZxh(cls, new Class[0]);
    }

    /* renamed from: xJ */
    public static AZxh m10491xJ(Class cls) {
        return m10490mjFkc(cls).m10502KLFTb();
    }

    /* renamed from: Dt */
    public boolean m10492Dt() {
        return this.f10825ZfxDd == 0;
    }

    /* renamed from: JHa */
    public Set m10493JHa() {
        return this.f10823JHa;
    }

    /* renamed from: KLFTb */
    public Set m10494KLFTb() {
        return this.f10826mjFkc;
    }

    /* renamed from: ZfxDd */
    public InterfaceC2597Otxclu m10495ZfxDd() {
        return this.f10824KLFTb;
    }

    /* renamed from: lgHUyS */
    public boolean m10496lgHUyS() {
        return this.f10827wA == 1;
    }

    /* renamed from: qdMbNW */
    public boolean m10497qdMbNW() {
        return this.f10827wA == 2;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f10826mjFkc.toArray()) + ">{" + this.f10827wA + ", type=" + this.f10825ZfxDd + ", deps=" + Arrays.toString(this.f10822AZxh.toArray()) + "}";
    }

    /* renamed from: wA */
    public Set m10498wA() {
        return this.f10822AZxh;
    }

    public C2957UOnCkw(Set set, Set set2, int i, int i2, InterfaceC2597Otxclu interfaceC2597Otxclu, Set set3) {
        this.f10826mjFkc = Collections.unmodifiableSet(set);
        this.f10822AZxh = Collections.unmodifiableSet(set2);
        this.f10827wA = i;
        this.f10825ZfxDd = i2;
        this.f10824KLFTb = interfaceC2597Otxclu;
        this.f10823JHa = Collections.unmodifiableSet(set3);
    }
}
