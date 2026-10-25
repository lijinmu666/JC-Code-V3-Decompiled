package p131o;

import java.util.ArrayList;
import p131o.C3776gjvQ;

/* renamed from: o.FOJ */
/* loaded from: classes.dex */
public class C1957FOJ {

    /* renamed from: AZxh */
    public C3776gjvQ f8168AZxh;

    /* renamed from: Dt */
    public int f8169Dt;

    /* renamed from: ETF */
    public float f8170ETF = 0.0f;

    /* renamed from: IEE */
    public boolean f8171IEE;

    /* renamed from: JHa */
    public C3776gjvQ f8172JHa;

    /* renamed from: KLFTb */
    public C3776gjvQ f8173KLFTb;

    /* renamed from: MiMN */
    public int f8174MiMN;

    /* renamed from: Pq */
    public boolean f8175Pq;

    /* renamed from: Ucbh */
    public boolean f8176Ucbh;

    /* renamed from: VA */
    public int f8177VA;

    /* renamed from: YoKzxo */
    public int f8178YoKzxo;

    /* renamed from: ZfxDd */
    public C3776gjvQ f8179ZfxDd;

    /* renamed from: diqgf */
    public boolean f8180diqgf;

    /* renamed from: eyqo */
    public boolean f8181eyqo;

    /* renamed from: fehf */
    public boolean f8182fehf;

    /* renamed from: lgHUyS */
    public ArrayList f8183lgHUyS;

    /* renamed from: mjFkc */
    public C3776gjvQ f8184mjFkc;

    /* renamed from: qGY */
    public int f8185qGY;

    /* renamed from: qdMbNW */
    public int f8186qdMbNW;

    /* renamed from: rkYL */
    public boolean f8187rkYL;

    /* renamed from: wA */
    public C3776gjvQ f8188wA;

    /* renamed from: xJ */
    public C3776gjvQ f8189xJ;

    public C1957FOJ(C3776gjvQ c3776gjvQ, int i, boolean z) {
        this.f8184mjFkc = c3776gjvQ;
        this.f8185qGY = i;
        this.f8182fehf = z;
    }

    /* renamed from: wA */
    public static boolean m8278wA(C3776gjvQ c3776gjvQ, int i) {
        int i2;
        return c3776gjvQ.m12043NPj() != 8 && c3776gjvQ.f13821rWxwaT[i] == C3776gjvQ.AZxh.MATCH_CONSTRAINT && ((i2 = c3776gjvQ.f13800YoKzxo[i]) == 0 || i2 == 3);
    }

    /* renamed from: AZxh */
    public final void m8279AZxh() {
        int i = this.f8185qGY * 2;
        C3776gjvQ c3776gjvQ = this.f8184mjFkc;
        this.f8187rkYL = true;
        C3776gjvQ c3776gjvQ2 = c3776gjvQ;
        boolean z = false;
        while (!z) {
            this.f8186qdMbNW++;
            C3776gjvQ[] c3776gjvQArr = c3776gjvQ.f13788Qr;
            int i2 = this.f8185qGY;
            C3776gjvQ c3776gjvQ3 = null;
            c3776gjvQArr[i2] = null;
            c3776gjvQ.f13789SOS[i2] = null;
            if (c3776gjvQ.m12043NPj() != 8) {
                this.f8177VA++;
                C3776gjvQ.AZxh aZxhM12046Pq = c3776gjvQ.m12046Pq(this.f8185qGY);
                C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxhM12046Pq != aZxh) {
                    this.f8174MiMN += c3776gjvQ.m12056VocHEe(this.f8185qGY);
                }
                int iM13321wA = this.f8174MiMN + c3776gjvQ.f13779KLMXS[i].m13321wA();
                this.f8174MiMN = iM13321wA;
                int i3 = i + 1;
                this.f8174MiMN = iM13321wA + c3776gjvQ.f13779KLMXS[i3].m13321wA();
                int iM13321wA2 = this.f8178YoKzxo + c3776gjvQ.f13779KLMXS[i].m13321wA();
                this.f8178YoKzxo = iM13321wA2;
                this.f8178YoKzxo = iM13321wA2 + c3776gjvQ.f13779KLMXS[i3].m13321wA();
                if (this.f8168AZxh == null) {
                    this.f8168AZxh = c3776gjvQ;
                }
                this.f8179ZfxDd = c3776gjvQ;
                C3776gjvQ.AZxh[] aZxhArr = c3776gjvQ.f13821rWxwaT;
                int i4 = this.f8185qGY;
                if (aZxhArr[i4] == aZxh) {
                    int i5 = c3776gjvQ.f13800YoKzxo[i4];
                    if (i5 == 0 || i5 == 3 || i5 == 2) {
                        this.f8169Dt++;
                        float f = c3776gjvQ.f13790SmIWf[i4];
                        if (f > 0.0f) {
                            this.f8170ETF += f;
                        }
                        if (m8278wA(c3776gjvQ, i4)) {
                            if (f < 0.0f) {
                                this.f8171IEE = true;
                            } else {
                                this.f8175Pq = true;
                            }
                            if (this.f8183lgHUyS == null) {
                                this.f8183lgHUyS = new ArrayList();
                            }
                            this.f8183lgHUyS.add(c3776gjvQ);
                        }
                        if (this.f8172JHa == null) {
                            this.f8172JHa = c3776gjvQ;
                        }
                        C3776gjvQ c3776gjvQ4 = this.f8189xJ;
                        if (c3776gjvQ4 != null) {
                            c3776gjvQ4.f13789SOS[this.f8185qGY] = c3776gjvQ;
                        }
                        this.f8189xJ = c3776gjvQ;
                    }
                    if (this.f8185qGY == 0) {
                        if (c3776gjvQ.f13793VA != 0 || c3776gjvQ.f13822rkYL != 0 || c3776gjvQ.f13819qGY != 0) {
                            this.f8187rkYL = false;
                        }
                    } else if (c3776gjvQ.f13781MiMN != 0 || c3776gjvQ.f13771IEE != 0 || c3776gjvQ.f13787Pq != 0) {
                        this.f8187rkYL = false;
                    }
                    if (c3776gjvQ.f13818oCFDzJ != 0.0f) {
                        this.f8187rkYL = false;
                        this.f8181eyqo = true;
                    }
                }
            }
            if (c3776gjvQ2 != c3776gjvQ) {
                c3776gjvQ2.f13788Qr[this.f8185qGY] = c3776gjvQ;
            }
            C4446qtZIjO c4446qtZIjO = c3776gjvQ.f13779KLMXS[i + 1].f16248ZfxDd;
            if (c4446qtZIjO != null) {
                C3776gjvQ c3776gjvQ5 = c4446qtZIjO.f16245AZxh;
                C4446qtZIjO c4446qtZIjO2 = c3776gjvQ5.f13779KLMXS[i].f16248ZfxDd;
                if (c4446qtZIjO2 != null && c4446qtZIjO2.f16245AZxh == c3776gjvQ) {
                    c3776gjvQ3 = c3776gjvQ5;
                }
            }
            if (c3776gjvQ3 == null) {
                c3776gjvQ3 = c3776gjvQ;
                z = true;
            }
            c3776gjvQ2 = c3776gjvQ;
            c3776gjvQ = c3776gjvQ3;
        }
        C3776gjvQ c3776gjvQ6 = this.f8168AZxh;
        if (c3776gjvQ6 != null) {
            this.f8174MiMN -= c3776gjvQ6.f13779KLMXS[i].m13321wA();
        }
        C3776gjvQ c3776gjvQ7 = this.f8179ZfxDd;
        if (c3776gjvQ7 != null) {
            this.f8174MiMN -= c3776gjvQ7.f13779KLMXS[i + 1].m13321wA();
        }
        this.f8188wA = c3776gjvQ;
        if (this.f8185qGY == 0 && this.f8182fehf) {
            this.f8173KLFTb = c3776gjvQ;
        } else {
            this.f8173KLFTb = this.f8184mjFkc;
        }
        this.f8180diqgf = this.f8175Pq && this.f8171IEE;
    }

    /* renamed from: mjFkc */
    public void m8280mjFkc() {
        if (!this.f8176Ucbh) {
            m8279AZxh();
        }
        this.f8176Ucbh = true;
    }
}
