package p131o;

import p131o.C3582dkKKW;
import p131o.C3776gjvQ;

/* renamed from: o.Da */
/* loaded from: classes.dex */
public abstract class AbstractC1832Da extends AbstractC4852x {

    /* renamed from: gYa */
    public int f7872gYa = 0;

    /* renamed from: LREOK */
    public int f7866LREOK = 0;

    /* renamed from: fFz */
    public int f7871fFz = 0;

    /* renamed from: XbiWeM */
    public int f7869XbiWeM = 0;

    /* renamed from: XFUzSY */
    public int f7868XFUzSY = 0;

    /* renamed from: XtE */
    public int f7870XtE = 0;

    /* renamed from: jx */
    public int f7874jx = 0;

    /* renamed from: uH */
    public int f7878uH = 0;

    /* renamed from: tISON */
    public boolean f7877tISON = false;

    /* renamed from: Vgyli */
    public int f7867Vgyli = 0;

    /* renamed from: lti */
    public int f7875lti = 0;

    /* renamed from: giT */
    public C3582dkKKW.mjFkc f7873giT = new C3582dkKKW.mjFkc();

    /* renamed from: sRqPfw */
    public C3582dkKKW.AZxh f7876sRqPfw = null;

    /* renamed from: Dp */
    public int m8001Dp() {
        return this.f7867Vgyli;
    }

    /* renamed from: FbxKQm */
    public boolean m8002FbxKQm() {
        return this.f7877tISON;
    }

    /* renamed from: IyS */
    public void m8003IyS(int i) {
        this.f7871fFz = i;
        this.f7872gYa = i;
        this.f7869XbiWeM = i;
        this.f7866LREOK = i;
        this.f7868XFUzSY = i;
        this.f7870XtE = i;
    }

    /* renamed from: Jk */
    public void m8004Jk(int i) {
        this.f7868XFUzSY = i;
        this.f7874jx = i;
        this.f7878uH = i;
    }

    /* renamed from: KRckQg */
    public void m8005KRckQg(int i) {
        this.f7872gYa = i;
    }

    /* renamed from: Rc */
    public int m8006Rc() {
        return this.f7878uH;
    }

    /* renamed from: SKTn */
    public int m8007SKTn() {
        return this.f7872gYa;
    }

    /* renamed from: XD */
    public void m8008XD() {
        for (int i = 0; i < this.f17301yX; i++) {
            C3776gjvQ c3776gjvQ = this.f17300tjSezt[i];
            if (c3776gjvQ != null) {
                c3776gjvQ.m12049SmIWf(true);
            }
        }
    }

    /* renamed from: XDdeP */
    public void m8009XDdeP(C3776gjvQ c3776gjvQ, C3776gjvQ.AZxh aZxh, int i, C3776gjvQ.AZxh aZxh2, int i2) {
        while (this.f7876sRqPfw == null && m12044Ne() != null) {
            this.f7876sRqPfw = ((C4052kw) m12044Ne()).m12625eQ();
        }
        C3582dkKKW.mjFkc mjfkc = this.f7873giT;
        mjfkc.f13387mjFkc = aZxh;
        mjfkc.f13381AZxh = aZxh2;
        mjfkc.f13389wA = i;
        mjfkc.f13385ZfxDd = i2;
        this.f7876sRqPfw.mo407AZxh(c3776gjvQ, mjfkc);
        c3776gjvQ.m12078jx(this.f7873giT.f13384KLFTb);
        c3776gjvQ.m12023ANMGZc(this.f7873giT.f13383JHa);
        c3776gjvQ.m12077jm(this.f7873giT.f13386lgHUyS);
        c3776gjvQ.m12059XV(this.f7873giT.f13390xJ);
    }

    /* renamed from: XgAT */
    public void m8010XgAT(int i, int i2) {
        this.f7867Vgyli = i;
        this.f7875lti = i2;
    }

    /* renamed from: Xxz */
    public void m8011Xxz(int i) {
        this.f7871fFz = i;
        this.f7874jx = i;
    }

    /* renamed from: Zdbk */
    public void m8012Zdbk(int i) {
        this.f7869XbiWeM = i;
        this.f7878uH = i;
    }

    /* renamed from: dGDT */
    public void m8013dGDT(int i) {
        this.f7870XtE = i;
    }

    /* renamed from: eQ */
    public boolean m8014eQ() {
        C3776gjvQ c3776gjvQ = this.f13795Vnb;
        C3582dkKKW.AZxh aZxhM12625eQ = c3776gjvQ != null ? ((C4052kw) c3776gjvQ).m12625eQ() : null;
        if (aZxhM12625eQ == null) {
            return false;
        }
        for (int i = 0; i < this.f17301yX; i++) {
            C3776gjvQ c3776gjvQ2 = this.f17300tjSezt[i];
            if (c3776gjvQ2 != null && !(c3776gjvQ2 instanceof C4186n)) {
                C3776gjvQ.AZxh aZxhM12046Pq = c3776gjvQ2.m12046Pq(0);
                C3776gjvQ.AZxh aZxhM12046Pq2 = c3776gjvQ2.m12046Pq(1);
                C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxhM12046Pq != aZxh || c3776gjvQ2.f13793VA == 1 || aZxhM12046Pq2 != aZxh || c3776gjvQ2.f13781MiMN == 1) {
                    if (aZxhM12046Pq == aZxh) {
                        aZxhM12046Pq = C3776gjvQ.AZxh.WRAP_CONTENT;
                    }
                    if (aZxhM12046Pq2 == aZxh) {
                        aZxhM12046Pq2 = C3776gjvQ.AZxh.WRAP_CONTENT;
                    }
                    C3582dkKKW.mjFkc mjfkc = this.f7873giT;
                    mjfkc.f13387mjFkc = aZxhM12046Pq;
                    mjfkc.f13381AZxh = aZxhM12046Pq2;
                    mjfkc.f13389wA = c3776gjvQ2.m12096vadzgd();
                    this.f7873giT.f13385ZfxDd = c3776gjvQ2.m12051Ucbh();
                    aZxhM12625eQ.mo407AZxh(c3776gjvQ2, this.f7873giT);
                    c3776gjvQ2.m12078jx(this.f7873giT.f13384KLFTb);
                    c3776gjvQ2.m12023ANMGZc(this.f7873giT.f13383JHa);
                    c3776gjvQ2.m12059XV(this.f7873giT.f13390xJ);
                }
            }
        }
        return true;
    }

    /* renamed from: fLidf */
    public int m8015fLidf() {
        return this.f7866LREOK;
    }

    /* renamed from: gtr */
    public int m8016gtr() {
        return this.f7875lti;
    }

    /* renamed from: hvGY */
    public int m8017hvGY() {
        return this.f7874jx;
    }

    /* renamed from: jtz */
    public void m8018jtz(boolean z) {
        this.f7877tISON = z;
    }

    @Override // p131o.AbstractC4852x, p131o.InterfaceC4718v
    /* renamed from: mjFkc */
    public void mo8019mjFkc(C4052kw c4052kw) {
        m8008XD();
    }

    /* renamed from: rdJr */
    public abstract void mo8020rdJr(int i, int i2, int i3, int i4);

    /* renamed from: sRqPfw */
    public void m8021sRqPfw(boolean z) {
        int i = this.f7868XFUzSY;
        if (i > 0 || this.f7870XtE > 0) {
            if (z) {
                this.f7874jx = this.f7870XtE;
                this.f7878uH = i;
            } else {
                this.f7874jx = i;
                this.f7878uH = this.f7870XtE;
            }
        }
    }

    /* renamed from: tAfC */
    public void m8022tAfC(int i) {
        this.f7866LREOK = i;
    }
}
