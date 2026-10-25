package p131o;

/* renamed from: o.n1 */
/* loaded from: classes.dex */
public abstract class AbstractC4188n1 {
    /* renamed from: AZxh */
    public static void m12837AZxh(C3697fW c3697fW, final boolean z, final EnumC4087lS enumC4087lS) {
        c3697fW.m11952JHa(new InterfaceC3632eW() { // from class: o.SO
            @Override // p131o.InterfaceC3632eW
            /* renamed from: zza */
            public final InterfaceC2443MV mo10141zza() {
                C4215nS c4215nS = new C4215nS();
                EnumC4020kS enumC4020kS = z ? EnumC4020kS.TYPE_THICK : EnumC4020kS.TYPE_THIN;
                EnumC4087lS enumC4087lS2 = enumC4087lS;
                c4215nS.m12876KLFTb(enumC4020kS);
                C3890iU c3890iU = new C3890iU();
                c3890iU.m12296AZxh(enumC4087lS2);
                c4215nS.m12880xJ(c3890iU.m12297wA());
                return C3892iW.m12299KLFTb(c4215nS);
            }
        }, EnumC4151mS.ON_DEVICE_TEXT_LOAD);
    }

    /* renamed from: mjFkc */
    public static EnumC5016zU m12838mjFkc(int i) {
        switch (i) {
            case 1:
                return EnumC5016zU.LATIN;
            case 2:
                return EnumC5016zU.LATIN_AND_CHINESE;
            case 3:
                return EnumC5016zU.LATIN_AND_DEVANAGARI;
            case 4:
                return EnumC5016zU.LATIN_AND_JAPANESE;
            case 5:
                return EnumC5016zU.LATIN_AND_KOREAN;
            case 6:
                return EnumC5016zU.CREDIT_CARD;
            case 7:
                return EnumC5016zU.DOCUMENT;
            case 8:
                return EnumC5016zU.PIXEL_AI;
            default:
                return EnumC5016zU.TYPE_UNKNOWN;
        }
    }
}
