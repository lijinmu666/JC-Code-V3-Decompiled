package p131o;

/* renamed from: o.Gs */
/* loaded from: classes.dex */
public final class C2058Gs extends AbstractC2192Is {

    /* renamed from: JHa */
    public final /* synthetic */ C2125Hs f8447JHa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2058Gs(C2125Hs c2125Hs, C2267Js c2267Js, CharSequence charSequence) {
        super(c2267Js, charSequence);
        this.f8447JHa = c2125Hs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r7 = r7 + 1;
     */
    @Override // p131o.AbstractC2192Is
    /* renamed from: KLFTb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo8463KLFTb(int i) {
        int length = this.f8794wA.length();
        int length2 = this.f8447JHa.f8658mjFkc.length();
        int i2 = length - length2;
        while (i <= i2) {
            for (int i3 = 0; i3 < length2; i3++) {
                if (this.f8794wA.charAt(i3 + i) != this.f8447JHa.f8658mjFkc.charAt(i3)) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    @Override // p131o.AbstractC2192Is
    /* renamed from: ZfxDd */
    public final int mo8464ZfxDd(int i) {
        return i + this.f8447JHa.f8658mjFkc.length();
    }
}
