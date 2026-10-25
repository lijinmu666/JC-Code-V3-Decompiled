package p131o;

/* renamed from: o.Is */
/* loaded from: classes.dex */
public abstract class AbstractC2192Is extends AbstractC4444qs {

    /* renamed from: wA */
    public final CharSequence f8794wA;

    /* renamed from: ZfxDd */
    public int f8793ZfxDd = 0;

    /* renamed from: KLFTb */
    public int f8792KLFTb = Integer.MAX_VALUE;

    public AbstractC2192Is(C2267Js c2267Js, CharSequence charSequence) {
        this.f8794wA = charSequence;
    }

    @Override // p131o.AbstractC4444qs
    /* renamed from: AZxh */
    public final /* bridge */ /* synthetic */ Object mo8801AZxh() {
        int iMo8464ZfxDd;
        int i = this.f8793ZfxDd;
        while (true) {
            int i2 = this.f8793ZfxDd;
            if (i2 == -1) {
                m13308wA();
                return null;
            }
            int iMo8463KLFTb = mo8463KLFTb(i2);
            if (iMo8463KLFTb == -1) {
                iMo8463KLFTb = this.f8794wA.length();
                this.f8793ZfxDd = -1;
                iMo8464ZfxDd = -1;
            } else {
                iMo8464ZfxDd = mo8464ZfxDd(iMo8463KLFTb);
                this.f8793ZfxDd = iMo8464ZfxDd;
            }
            if (iMo8464ZfxDd != i) {
                if (i < iMo8463KLFTb) {
                    this.f8794wA.charAt(i);
                }
                if (i < iMo8463KLFTb) {
                    this.f8794wA.charAt(iMo8463KLFTb - 1);
                }
                int i3 = this.f8792KLFTb;
                if (i3 == 1) {
                    iMo8463KLFTb = this.f8794wA.length();
                    this.f8793ZfxDd = -1;
                    if (iMo8463KLFTb > i) {
                        this.f8794wA.charAt(iMo8463KLFTb - 1);
                    }
                } else {
                    this.f8792KLFTb = i3 - 1;
                }
                return this.f8794wA.subSequence(i, iMo8463KLFTb).toString();
            }
            int i4 = iMo8464ZfxDd + 1;
            this.f8793ZfxDd = i4;
            if (i4 > this.f8794wA.length()) {
                this.f8793ZfxDd = -1;
            }
        }
    }

    /* renamed from: KLFTb */
    public abstract int mo8463KLFTb(int i);

    /* renamed from: ZfxDd */
    public abstract int mo8464ZfxDd(int i);
}
