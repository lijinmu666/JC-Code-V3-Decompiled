package p131o;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;

/* renamed from: o.if */
/* loaded from: classes.dex */
public final class C3898if implements InterfaceC3855hy {

    /* renamed from: mjFkc */
    public static final InterfaceC3855hy f14159mjFkc = new C3898if();

    @Override // p131o.InterfaceC3855hy
    /* renamed from: mjFkc */
    public final boolean mo7629mjFkc(int i) {
        if (i == 200 || i == 300 || i == 302 || i == 312 || i == 15000 || i == 304 || i == 305) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        return true;
                    default:
                        switch (i) {
                            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                                return true;
                            default:
                                switch (i) {
                                    case 220:
                                    case 221:
                                    case 222:
                                    case 223:
                                    case InterfaceC5102BERTags.f17976FLAGS /* 224 */:
                                    case 225:
                                    case 226:
                                    case 227:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 238:
                                            case 239:
                                            case 240:
                                            case 241:
                                            case 242:
                                            case 243:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 314:
                                                    case 315:
                                                    case 316:
                                                        return true;
                                                    default:
                                                        return false;
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
