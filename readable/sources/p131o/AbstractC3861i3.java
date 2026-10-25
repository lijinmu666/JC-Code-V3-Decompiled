package p131o;

import p131o.C3776gjvQ;

/* renamed from: o.i3 */
/* loaded from: classes.dex */
public abstract class AbstractC3861i3 {

    /* renamed from: mjFkc */
    public static boolean[] f14101mjFkc = new boolean[3];

    /* renamed from: AZxh */
    public static final boolean m12277AZxh(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: mjFkc */
    public static void m12278mjFkc(C4052kw c4052kw, C3202Y0 c3202y0, C3776gjvQ c3776gjvQ) {
        c3776gjvQ.f13766Dt = -1;
        c3776gjvQ.f13767ETF = -1;
        C3776gjvQ.AZxh aZxh = c4052kw.f13821rWxwaT[0];
        C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.WRAP_CONTENT;
        if (aZxh != aZxh2 && c3776gjvQ.f13821rWxwaT[0] == C3776gjvQ.AZxh.MATCH_PARENT) {
            int i = c3776gjvQ.f13764BAnRFn.f16247KLFTb;
            int iM12096vadzgd = c4052kw.m12096vadzgd() - c3776gjvQ.f13829wJVbdd.f16247KLFTb;
            C4446qtZIjO c4446qtZIjO = c3776gjvQ.f13764BAnRFn;
            c4446qtZIjO.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO);
            C4446qtZIjO c4446qtZIjO2 = c3776gjvQ.f13829wJVbdd;
            c4446qtZIjO2.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO2);
            c3202y0.m11015JHa(c3776gjvQ.f13764BAnRFn.f16251xJ, i);
            c3202y0.m11015JHa(c3776gjvQ.f13829wJVbdd.f16251xJ, iM12096vadzgd);
            c3776gjvQ.f13766Dt = 2;
            c3776gjvQ.m12091tQ(i, iM12096vadzgd);
        }
        if (c4052kw.f13821rWxwaT[1] == aZxh2 || c3776gjvQ.f13821rWxwaT[1] != C3776gjvQ.AZxh.MATCH_PARENT) {
            return;
        }
        int i2 = c3776gjvQ.f13813lB.f16247KLFTb;
        int iM12051Ucbh = c4052kw.m12051Ucbh() - c3776gjvQ.f13815mByQ.f16247KLFTb;
        C4446qtZIjO c4446qtZIjO3 = c3776gjvQ.f13813lB;
        c4446qtZIjO3.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO3);
        C4446qtZIjO c4446qtZIjO4 = c3776gjvQ.f13815mByQ;
        c4446qtZIjO4.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO4);
        c3202y0.m11015JHa(c3776gjvQ.f13813lB.f16251xJ, i2);
        c3202y0.m11015JHa(c3776gjvQ.f13815mByQ.f16251xJ, iM12051Ucbh);
        if (c3776gjvQ.f13777JrJO > 0 || c3776gjvQ.m12043NPj() == 8) {
            C4446qtZIjO c4446qtZIjO5 = c3776gjvQ.f13786OjSQV;
            c4446qtZIjO5.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO5);
            c3202y0.m11015JHa(c3776gjvQ.f13786OjSQV.f16251xJ, c3776gjvQ.f13777JrJO + i2);
        }
        c3776gjvQ.f13767ETF = 2;
        c3776gjvQ.m12039LREOK(i2, iM12051Ucbh);
    }
}
