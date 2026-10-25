package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p015widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p131o.AbstractC2079HBzZAD;
import p131o.AbstractC3005V4;
import p131o.AbstractC4723v4;
import p131o.C4143mL;

/* renamed from: androidx.constraintlayout.widget.wA */
/* loaded from: classes.dex */
public class C0057wA {

    /* renamed from: KLFTb */
    public static SparseIntArray f790KLFTb;

    /* renamed from: ZfxDd */
    public static final int[] f791ZfxDd = {0, 4, 8};

    /* renamed from: mjFkc */
    public HashMap f793mjFkc = new HashMap();

    /* renamed from: AZxh */
    public boolean f792AZxh = true;

    /* renamed from: wA */
    public HashMap f794wA = new HashMap();

    /* renamed from: androidx.constraintlayout.widget.wA$AZxh */
    public static class AZxh {

        /* renamed from: tQ */
        public static SparseIntArray f795tQ;

        /* renamed from: JBhc */
        public int[] f806JBhc;

        /* renamed from: Vdz */
        public String f822Vdz;

        /* renamed from: ZfxDd */
        public int f829ZfxDd;

        /* renamed from: jm */
        public String f839jm;

        /* renamed from: wA */
        public int f853wA;

        /* renamed from: mjFkc */
        public boolean f843mjFkc = false;

        /* renamed from: AZxh */
        public boolean f797AZxh = false;

        /* renamed from: KLFTb */
        public int f811KLFTb = -1;

        /* renamed from: JHa */
        public int f807JHa = -1;

        /* renamed from: xJ */
        public float f855xJ = -1.0f;

        /* renamed from: lgHUyS */
        public int f841lgHUyS = -1;

        /* renamed from: qdMbNW */
        public int f847qdMbNW = -1;

        /* renamed from: Dt */
        public int f800Dt = -1;

        /* renamed from: ETF */
        public int f801ETF = -1;

        /* renamed from: VA */
        public int f821VA = -1;

        /* renamed from: MiMN */
        public int f814MiMN = -1;

        /* renamed from: YoKzxo */
        public int f828YoKzxo = -1;

        /* renamed from: rkYL */
        public int f849rkYL = -1;

        /* renamed from: qGY */
        public int f846qGY = -1;

        /* renamed from: fehf */
        public int f837fehf = -1;

        /* renamed from: IEE */
        public int f805IEE = -1;

        /* renamed from: Pq */
        public int f818Pq = -1;

        /* renamed from: diqgf */
        public int f834diqgf = -1;

        /* renamed from: eyqo */
        public float f836eyqo = 0.5f;

        /* renamed from: Ucbh */
        public float f820Ucbh = 0.5f;

        /* renamed from: huTpC */
        public String f838huTpC = null;

        /* renamed from: Gd */
        public int f803Gd = -1;

        /* renamed from: HGpJ */
        public int f804HGpJ = 0;

        /* renamed from: vI */
        public float f851vI = 0.0f;

        /* renamed from: VocHEe */
        public int f824VocHEe = -1;

        /* renamed from: BAnRFn */
        public int f798BAnRFn = -1;

        /* renamed from: lB */
        public int f840lB = -1;

        /* renamed from: wJVbdd */
        public int f854wJVbdd = -1;

        /* renamed from: mByQ */
        public int f842mByQ = -1;

        /* renamed from: OjSQV */
        public int f817OjSQV = -1;

        /* renamed from: Ne */
        public int f816Ne = -1;

        /* renamed from: CqaNbM */
        public int f799CqaNbM = -1;

        /* renamed from: xrEuO */
        public int f856xrEuO = -1;

        /* renamed from: KLMXS */
        public int f812KLMXS = -1;

        /* renamed from: zvd */
        public int f857zvd = -1;

        /* renamed from: cMLeY */
        public int f833cMLeY = -1;

        /* renamed from: rWxwaT */
        public int f848rWxwaT = -1;

        /* renamed from: Vnb */
        public int f823Vnb = -1;

        /* renamed from: NPj */
        public int f815NPj = -1;

        /* renamed from: vadzgd */
        public float f852vadzgd = -1.0f;

        /* renamed from: oCFDzJ */
        public float f845oCFDzJ = -1.0f;

        /* renamed from: aqHPIZ */
        public int f831aqHPIZ = 0;

        /* renamed from: WrLQs */
        public int f826WrLQs = 0;

        /* renamed from: KRTLGT */
        public int f813KRTLGT = 0;

        /* renamed from: GMIER */
        public int f802GMIER = 0;

        /* renamed from: uHVRx */
        public int f850uHVRx = -1;

        /* renamed from: JYn */
        public int f809JYn = -1;

        /* renamed from: JYgkl */
        public int f808JYgkl = -1;

        /* renamed from: JrJO */
        public int f810JrJO = -1;

        /* renamed from: nxI */
        public float f844nxI = 1.0f;

        /* renamed from: WGXroI */
        public float f825WGXroI = 1.0f;

        /* renamed from: XV */
        public int f827XV = -1;

        /* renamed from: bbzow */
        public int f832bbzow = 0;

        /* renamed from: SwgkN */
        public int f819SwgkN = -1;

        /* renamed from: ANMGZc */
        public boolean f796ANMGZc = false;

        /* renamed from: alEkx */
        public boolean f830alEkx = false;

        /* renamed from: dm */
        public boolean f835dm = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f795tQ = sparseIntArray;
            sparseIntArray.append(AbstractC3005V4.f11253xM, 24);
            f795tQ.append(AbstractC3005V4.f10994Io, 25);
            f795tQ.append(AbstractC3005V4.f11266zabxk, 28);
            f795tQ.append(AbstractC3005V4.f10962Eey, 29);
            f795tQ.append(AbstractC3005V4.f11010JtIAgM, 35);
            f795tQ.append(AbstractC3005V4.f11180mZG, 34);
            f795tQ.append(AbstractC3005V4.f10972FoPRDo, 4);
            f795tQ.append(AbstractC3005V4.f11076UqgK, 3);
            f795tQ.append(AbstractC3005V4.f11000JBjLUy, 1);
            f795tQ.append(AbstractC3005V4.f10945CBEvIj, 6);
            f795tQ.append(AbstractC3005V4.f11142gYsXfP, 7);
            f795tQ.append(AbstractC3005V4.f11094XVrPFt, 17);
            f795tQ.append(AbstractC3005V4.f10981HBzZAD, 18);
            f795tQ.append(AbstractC3005V4.f11102YfFg, 19);
            f795tQ.append(AbstractC3005V4.f11125cQmsjG, 26);
            f795tQ.append(AbstractC3005V4.f11059SllyO, 31);
            f795tQ.append(AbstractC3005V4.f11202qqdo, 32);
            f795tQ.append(AbstractC3005V4.f11216sjsh, 10);
            f795tQ.append(AbstractC3005V4.f11265zZ, 9);
            f795tQ.append(AbstractC3005V4.f11112ZlB, 13);
            f795tQ.append(AbstractC3005V4.f11107ZODYfo, 16);
            f795tQ.append(AbstractC3005V4.f11043PvPg, 14);
            f795tQ.append(AbstractC3005V4.f11157jKf, 11);
            f795tQ.append(AbstractC3005V4.f11025MQhVKd, 15);
            f795tQ.append(AbstractC3005V4.f11001JGvOM, 12);
            f795tQ.append(AbstractC3005V4.f10965FBR, 38);
            f795tQ.append(AbstractC3005V4.f11074Ule, 37);
            f795tQ.append(AbstractC3005V4.f11085VzXmn, 39);
            f795tQ.append(AbstractC3005V4.f11209rdtF, 40);
            f795tQ.append(AbstractC3005V4.f11051RURGdp, 20);
            f795tQ.append(AbstractC3005V4.f11052RV, 36);
            f795tQ.append(AbstractC3005V4.f11073UlIi, 5);
            f795tQ.append(AbstractC3005V4.f11212sMIIyd, 76);
            f795tQ.append(AbstractC3005V4.f11045QQi, 76);
            f795tQ.append(AbstractC3005V4.f11184nTET, 76);
            f795tQ.append(AbstractC3005V4.f10992IRYXZ, 76);
            f795tQ.append(AbstractC3005V4.f11047QfniOH, 76);
            f795tQ.append(AbstractC3005V4.f11214sTX, 23);
            f795tQ.append(AbstractC3005V4.f10951CkG, 27);
            f795tQ.append(AbstractC3005V4.f10957EHujwx, 30);
            f795tQ.append(AbstractC3005V4.f11044QP, 8);
            f795tQ.append(AbstractC3005V4.f11024MLoZE, 33);
            f795tQ.append(AbstractC3005V4.f11068UMza, 2);
            f795tQ.append(AbstractC3005V4.f11224tnpR, 22);
            f795tQ.append(AbstractC3005V4.f10970Fncs, 21);
            f795tQ.append(AbstractC3005V4.f11138fTu, 61);
            f795tQ.append(AbstractC3005V4.f11152iEjzEW, 62);
            f795tQ.append(AbstractC3005V4.f11164jwyZcq, 63);
            f795tQ.append(AbstractC3005V4.f10938Ab, 69);
            f795tQ.append(AbstractC3005V4.f11061SrJcM, 70);
            f795tQ.append(AbstractC3005V4.f10973FrS, 71);
            f795tQ.append(AbstractC3005V4.f10978GaZ, 72);
            f795tQ.append(AbstractC3005V4.f11217speY, 73);
            f795tQ.append(AbstractC3005V4.f10985HL, 74);
            f795tQ.append(AbstractC3005V4.f11088WxE, 75);
        }

        /* renamed from: AZxh */
        public void m430AZxh(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f10967FVsTt);
            this.f797AZxh = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                int i2 = f795tQ.get(index);
                if (i2 == 80) {
                    this.f796ANMGZc = typedArrayObtainStyledAttributes.getBoolean(index, this.f796ANMGZc);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.f846qGY = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f846qGY);
                            break;
                        case 2:
                            this.f816Ne = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f816Ne);
                            break;
                        case 3:
                            this.f849rkYL = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f849rkYL);
                            break;
                        case 4:
                            this.f828YoKzxo = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f828YoKzxo);
                            break;
                        case 5:
                            this.f838huTpC = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.f824VocHEe = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f824VocHEe);
                            break;
                        case 7:
                            this.f798BAnRFn = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f798BAnRFn);
                            break;
                        case 8:
                            this.f799CqaNbM = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f799CqaNbM);
                            break;
                        case 9:
                            this.f834diqgf = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f834diqgf);
                            break;
                        case 10:
                            this.f818Pq = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f818Pq);
                            break;
                        case 11:
                            this.f848rWxwaT = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f848rWxwaT);
                            break;
                        case 12:
                            this.f823Vnb = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f823Vnb);
                            break;
                        case 13:
                            this.f812KLMXS = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f812KLMXS);
                            break;
                        case 14:
                            this.f833cMLeY = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f833cMLeY);
                            break;
                        case 15:
                            this.f815NPj = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f815NPj);
                            break;
                        case 16:
                            this.f857zvd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f857zvd);
                            break;
                        case 17:
                            this.f811KLFTb = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f811KLFTb);
                            break;
                        case 18:
                            this.f807JHa = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f807JHa);
                            break;
                        case 19:
                            this.f855xJ = typedArrayObtainStyledAttributes.getFloat(index, this.f855xJ);
                            break;
                        case 20:
                            this.f836eyqo = typedArrayObtainStyledAttributes.getFloat(index, this.f836eyqo);
                            break;
                        case 21:
                            this.f829ZfxDd = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f829ZfxDd);
                            break;
                        case 22:
                            this.f853wA = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f853wA);
                            break;
                        case 23:
                            this.f854wJVbdd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f854wJVbdd);
                            break;
                        case 24:
                            this.f841lgHUyS = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f841lgHUyS);
                            break;
                        case 25:
                            this.f847qdMbNW = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f847qdMbNW);
                            break;
                        case 26:
                            this.f840lB = typedArrayObtainStyledAttributes.getInt(index, this.f840lB);
                            break;
                        case 27:
                            this.f842mByQ = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f842mByQ);
                            break;
                        case 28:
                            this.f800Dt = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f800Dt);
                            break;
                        case 29:
                            this.f801ETF = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f801ETF);
                            break;
                        case 30:
                            this.f856xrEuO = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f856xrEuO);
                            break;
                        case InterfaceC5102BERTags.f17975DATE /* 31 */:
                            this.f837fehf = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f837fehf);
                            break;
                        case 32:
                            this.f805IEE = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f805IEE);
                            break;
                        case 33:
                            this.f817OjSQV = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f817OjSQV);
                            break;
                        case 34:
                            this.f814MiMN = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f814MiMN);
                            break;
                        case 35:
                            this.f821VA = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f821VA);
                            break;
                        case 36:
                            this.f820Ucbh = typedArrayObtainStyledAttributes.getFloat(index, this.f820Ucbh);
                            break;
                        case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                            this.f845oCFDzJ = typedArrayObtainStyledAttributes.getFloat(index, this.f845oCFDzJ);
                            break;
                        case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                            this.f852vadzgd = typedArrayObtainStyledAttributes.getFloat(index, this.f852vadzgd);
                            break;
                        case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                            this.f831aqHPIZ = typedArrayObtainStyledAttributes.getInt(index, this.f831aqHPIZ);
                            break;
                        case 40:
                            this.f826WrLQs = typedArrayObtainStyledAttributes.getInt(index, this.f826WrLQs);
                            break;
                        default:
                            switch (i2) {
                                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                                    this.f813KRTLGT = typedArrayObtainStyledAttributes.getInt(index, this.f813KRTLGT);
                                    break;
                                case 55:
                                    this.f802GMIER = typedArrayObtainStyledAttributes.getInt(index, this.f802GMIER);
                                    break;
                                case 56:
                                    this.f850uHVRx = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f850uHVRx);
                                    break;
                                case 57:
                                    this.f809JYn = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f809JYn);
                                    break;
                                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                                    this.f808JYgkl = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f808JYgkl);
                                    break;
                                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                    this.f810JrJO = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f810JrJO);
                                    break;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.f803Gd = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f803Gd);
                                            break;
                                        case 62:
                                            this.f804HGpJ = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f804HGpJ);
                                            break;
                                        case 63:
                                            this.f851vI = typedArrayObtainStyledAttributes.getFloat(index, this.f851vI);
                                            break;
                                        default:
                                            switch (i2) {
                                                case C5125EACTags.DISPLAY_IMAGE /* 69 */:
                                                    this.f844nxI = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f825WGXroI = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case C5125EACTags.MESSAGE_REFERENCE /* 71 */:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f827XV = typedArrayObtainStyledAttributes.getInt(index, this.f827XV);
                                                    break;
                                                case 73:
                                                    this.f832bbzow = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f832bbzow);
                                                    break;
                                                case C5125EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY /* 74 */:
                                                    this.f822Vdz = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case C5125EACTags.DEPRECATED /* 75 */:
                                                    this.f835dm = typedArrayObtainStyledAttributes.getBoolean(index, this.f835dm);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f795tQ.get(index));
                                                    break;
                                                case C5125EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                                                    this.f839jm = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f795tQ.get(index));
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    this.f830alEkx = typedArrayObtainStyledAttributes.getBoolean(index, this.f830alEkx);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: mjFkc */
        public void m431mjFkc(AZxh aZxh) {
            this.f843mjFkc = aZxh.f843mjFkc;
            this.f853wA = aZxh.f853wA;
            this.f797AZxh = aZxh.f797AZxh;
            this.f829ZfxDd = aZxh.f829ZfxDd;
            this.f811KLFTb = aZxh.f811KLFTb;
            this.f807JHa = aZxh.f807JHa;
            this.f855xJ = aZxh.f855xJ;
            this.f841lgHUyS = aZxh.f841lgHUyS;
            this.f847qdMbNW = aZxh.f847qdMbNW;
            this.f800Dt = aZxh.f800Dt;
            this.f801ETF = aZxh.f801ETF;
            this.f821VA = aZxh.f821VA;
            this.f814MiMN = aZxh.f814MiMN;
            this.f828YoKzxo = aZxh.f828YoKzxo;
            this.f849rkYL = aZxh.f849rkYL;
            this.f846qGY = aZxh.f846qGY;
            this.f837fehf = aZxh.f837fehf;
            this.f805IEE = aZxh.f805IEE;
            this.f818Pq = aZxh.f818Pq;
            this.f834diqgf = aZxh.f834diqgf;
            this.f836eyqo = aZxh.f836eyqo;
            this.f820Ucbh = aZxh.f820Ucbh;
            this.f838huTpC = aZxh.f838huTpC;
            this.f803Gd = aZxh.f803Gd;
            this.f804HGpJ = aZxh.f804HGpJ;
            this.f851vI = aZxh.f851vI;
            this.f824VocHEe = aZxh.f824VocHEe;
            this.f798BAnRFn = aZxh.f798BAnRFn;
            this.f840lB = aZxh.f840lB;
            this.f854wJVbdd = aZxh.f854wJVbdd;
            this.f842mByQ = aZxh.f842mByQ;
            this.f817OjSQV = aZxh.f817OjSQV;
            this.f816Ne = aZxh.f816Ne;
            this.f799CqaNbM = aZxh.f799CqaNbM;
            this.f856xrEuO = aZxh.f856xrEuO;
            this.f812KLMXS = aZxh.f812KLMXS;
            this.f857zvd = aZxh.f857zvd;
            this.f833cMLeY = aZxh.f833cMLeY;
            this.f848rWxwaT = aZxh.f848rWxwaT;
            this.f823Vnb = aZxh.f823Vnb;
            this.f815NPj = aZxh.f815NPj;
            this.f852vadzgd = aZxh.f852vadzgd;
            this.f845oCFDzJ = aZxh.f845oCFDzJ;
            this.f831aqHPIZ = aZxh.f831aqHPIZ;
            this.f826WrLQs = aZxh.f826WrLQs;
            this.f813KRTLGT = aZxh.f813KRTLGT;
            this.f802GMIER = aZxh.f802GMIER;
            this.f850uHVRx = aZxh.f850uHVRx;
            this.f809JYn = aZxh.f809JYn;
            this.f808JYgkl = aZxh.f808JYgkl;
            this.f810JrJO = aZxh.f810JrJO;
            this.f844nxI = aZxh.f844nxI;
            this.f825WGXroI = aZxh.f825WGXroI;
            this.f827XV = aZxh.f827XV;
            this.f832bbzow = aZxh.f832bbzow;
            this.f819SwgkN = aZxh.f819SwgkN;
            this.f839jm = aZxh.f839jm;
            int[] iArr = aZxh.f806JBhc;
            if (iArr != null) {
                this.f806JBhc = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f806JBhc = null;
            }
            this.f822Vdz = aZxh.f822Vdz;
            this.f796ANMGZc = aZxh.f796ANMGZc;
            this.f830alEkx = aZxh.f830alEkx;
            this.f835dm = aZxh.f835dm;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.wA$KLFTb */
    public static class KLFTb {

        /* renamed from: YoKzxo */
        public static SparseIntArray f858YoKzxo;

        /* renamed from: mjFkc */
        public boolean f868mjFkc = false;

        /* renamed from: AZxh */
        public float f859AZxh = 0.0f;

        /* renamed from: wA */
        public float f870wA = 0.0f;

        /* renamed from: ZfxDd */
        public float f866ZfxDd = 0.0f;

        /* renamed from: KLFTb */
        public float f863KLFTb = 1.0f;

        /* renamed from: JHa */
        public float f862JHa = 1.0f;

        /* renamed from: xJ */
        public float f871xJ = Float.NaN;

        /* renamed from: lgHUyS */
        public float f867lgHUyS = Float.NaN;

        /* renamed from: qdMbNW */
        public float f869qdMbNW = 0.0f;

        /* renamed from: Dt */
        public float f860Dt = 0.0f;

        /* renamed from: ETF */
        public float f861ETF = 0.0f;

        /* renamed from: VA */
        public boolean f865VA = false;

        /* renamed from: MiMN */
        public float f864MiMN = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f858YoKzxo = sparseIntArray;
            sparseIntArray.append(AbstractC3005V4.f11156jIShy, 1);
            f858YoKzxo.append(AbstractC3005V4.f11037ORe, 2);
            f858YoKzxo.append(AbstractC3005V4.f11193ofUPN, 3);
            f858YoKzxo.append(AbstractC3005V4.f11166jxC, 4);
            f858YoKzxo.append(AbstractC3005V4.f11128dXmy, 5);
            f858YoKzxo.append(AbstractC3005V4.f10995Ipwl, 6);
            f858YoKzxo.append(AbstractC3005V4.f11234vBFMCS, 7);
            f858YoKzxo.append(AbstractC3005V4.f11113ZxmHEb, 8);
            f858YoKzxo.append(AbstractC3005V4.f11179mYYU, 9);
            f858YoKzxo.append(AbstractC3005V4.f10946CBhInx, 10);
            f858YoKzxo.append(AbstractC3005V4.f11241vdbwS, 11);
        }

        /* renamed from: AZxh */
        public void m432AZxh(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f11182mz);
            this.f868mjFkc = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (f858YoKzxo.get(index)) {
                    case 1:
                        this.f859AZxh = typedArrayObtainStyledAttributes.getFloat(index, this.f859AZxh);
                        break;
                    case 2:
                        this.f870wA = typedArrayObtainStyledAttributes.getFloat(index, this.f870wA);
                        break;
                    case 3:
                        this.f866ZfxDd = typedArrayObtainStyledAttributes.getFloat(index, this.f866ZfxDd);
                        break;
                    case 4:
                        this.f863KLFTb = typedArrayObtainStyledAttributes.getFloat(index, this.f863KLFTb);
                        break;
                    case 5:
                        this.f862JHa = typedArrayObtainStyledAttributes.getFloat(index, this.f862JHa);
                        break;
                    case 6:
                        this.f871xJ = typedArrayObtainStyledAttributes.getDimension(index, this.f871xJ);
                        break;
                    case 7:
                        this.f867lgHUyS = typedArrayObtainStyledAttributes.getDimension(index, this.f867lgHUyS);
                        break;
                    case 8:
                        this.f869qdMbNW = typedArrayObtainStyledAttributes.getDimension(index, this.f869qdMbNW);
                        break;
                    case 9:
                        this.f860Dt = typedArrayObtainStyledAttributes.getDimension(index, this.f860Dt);
                        break;
                    case 10:
                        this.f861ETF = typedArrayObtainStyledAttributes.getDimension(index, this.f861ETF);
                        break;
                    case 11:
                        this.f865VA = true;
                        this.f864MiMN = typedArrayObtainStyledAttributes.getDimension(index, this.f864MiMN);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: mjFkc */
        public void m433mjFkc(KLFTb kLFTb) {
            this.f868mjFkc = kLFTb.f868mjFkc;
            this.f859AZxh = kLFTb.f859AZxh;
            this.f870wA = kLFTb.f870wA;
            this.f866ZfxDd = kLFTb.f866ZfxDd;
            this.f863KLFTb = kLFTb.f863KLFTb;
            this.f862JHa = kLFTb.f862JHa;
            this.f871xJ = kLFTb.f871xJ;
            this.f867lgHUyS = kLFTb.f867lgHUyS;
            this.f869qdMbNW = kLFTb.f869qdMbNW;
            this.f860Dt = kLFTb.f860Dt;
            this.f861ETF = kLFTb.f861ETF;
            this.f865VA = kLFTb.f865VA;
            this.f864MiMN = kLFTb.f864MiMN;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.wA$ZfxDd */
    public static class ZfxDd {

        /* renamed from: mjFkc */
        public boolean f875mjFkc = false;

        /* renamed from: AZxh */
        public int f872AZxh = 0;

        /* renamed from: wA */
        public int f876wA = 0;

        /* renamed from: ZfxDd */
        public float f874ZfxDd = 1.0f;

        /* renamed from: KLFTb */
        public float f873KLFTb = Float.NaN;

        /* renamed from: AZxh */
        public void m434AZxh(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f11177mL);
            this.f875mjFkc = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11021LyQ) {
                    this.f874ZfxDd = typedArrayObtainStyledAttributes.getFloat(index, this.f874ZfxDd);
                } else if (index == AbstractC3005V4.f11071UXIO) {
                    this.f872AZxh = typedArrayObtainStyledAttributes.getInt(index, this.f872AZxh);
                    this.f872AZxh = C0057wA.f791ZfxDd[this.f872AZxh];
                } else if (index == AbstractC3005V4.f11211rtBEoQ) {
                    this.f876wA = typedArrayObtainStyledAttributes.getInt(index, this.f876wA);
                } else if (index == AbstractC3005V4.f11206rKxis) {
                    this.f873KLFTb = typedArrayObtainStyledAttributes.getFloat(index, this.f873KLFTb);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: mjFkc */
        public void m435mjFkc(ZfxDd zfxDd) {
            this.f875mjFkc = zfxDd.f875mjFkc;
            this.f872AZxh = zfxDd.f872AZxh;
            this.f874ZfxDd = zfxDd.f874ZfxDd;
            this.f873KLFTb = zfxDd.f873KLFTb;
            this.f876wA = zfxDd.f876wA;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.wA$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public int f881mjFkc;

        /* renamed from: AZxh */
        public final ZfxDd f877AZxh = new ZfxDd();

        /* renamed from: wA */
        public final wA f882wA = new wA();

        /* renamed from: ZfxDd */
        public final AZxh f880ZfxDd = new AZxh();

        /* renamed from: KLFTb */
        public final KLFTb f879KLFTb = new KLFTb();

        /* renamed from: JHa */
        public HashMap f878JHa = new HashMap();

        /* renamed from: AZxh */
        public void m437AZxh(ConstraintLayout.C0052AZxh c0052AZxh) {
            AZxh aZxh = this.f880ZfxDd;
            c0052AZxh.f731ZfxDd = aZxh.f841lgHUyS;
            c0052AZxh.f713KLFTb = aZxh.f847qdMbNW;
            c0052AZxh.f709JHa = aZxh.f800Dt;
            c0052AZxh.f759xJ = aZxh.f801ETF;
            c0052AZxh.f743lgHUyS = aZxh.f821VA;
            c0052AZxh.f749qdMbNW = aZxh.f814MiMN;
            c0052AZxh.f701Dt = aZxh.f828YoKzxo;
            c0052AZxh.f702ETF = aZxh.f849rkYL;
            c0052AZxh.f723VA = aZxh.f846qGY;
            c0052AZxh.f748qGY = aZxh.f837fehf;
            c0052AZxh.f739fehf = aZxh.f805IEE;
            c0052AZxh.f706IEE = aZxh.f818Pq;
            c0052AZxh.f720Pq = aZxh.f834diqgf;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).leftMargin = aZxh.f854wJVbdd;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).rightMargin = aZxh.f842mByQ;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).topMargin = aZxh.f817OjSQV;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).bottomMargin = aZxh.f816Ne;
            c0052AZxh.f704Gd = aZxh.f815NPj;
            c0052AZxh.f705HGpJ = aZxh.f823Vnb;
            c0052AZxh.f738eyqo = aZxh.f857zvd;
            c0052AZxh.f740huTpC = aZxh.f848rWxwaT;
            c0052AZxh.f754vI = aZxh.f836eyqo;
            c0052AZxh.f726VocHEe = aZxh.f820Ucbh;
            c0052AZxh.f716MiMN = aZxh.f803Gd;
            c0052AZxh.f730YoKzxo = aZxh.f804HGpJ;
            c0052AZxh.f751rkYL = aZxh.f851vI;
            c0052AZxh.f699BAnRFn = aZxh.f838huTpC;
            c0052AZxh.f747oCFDzJ = aZxh.f824VocHEe;
            c0052AZxh.f733aqHPIZ = aZxh.f798BAnRFn;
            c0052AZxh.f719OjSQV = aZxh.f852vadzgd;
            c0052AZxh.f744mByQ = aZxh.f845oCFDzJ;
            c0052AZxh.f700CqaNbM = aZxh.f826WrLQs;
            c0052AZxh.f718Ne = aZxh.f831aqHPIZ;
            c0052AZxh.f715KRTLGT = aZxh.f796ANMGZc;
            c0052AZxh.f703GMIER = aZxh.f830alEkx;
            c0052AZxh.f761xrEuO = aZxh.f813KRTLGT;
            c0052AZxh.f714KLMXS = aZxh.f802GMIER;
            c0052AZxh.f750rWxwaT = aZxh.f850uHVRx;
            c0052AZxh.f725Vnb = aZxh.f809JYn;
            c0052AZxh.f763zvd = aZxh.f808JYgkl;
            c0052AZxh.f735cMLeY = aZxh.f810JrJO;
            c0052AZxh.f717NPj = aZxh.f844nxI;
            c0052AZxh.f755vadzgd = aZxh.f825WGXroI;
            c0052AZxh.f728WrLQs = aZxh.f840lB;
            c0052AZxh.f757wA = aZxh.f855xJ;
            c0052AZxh.f745mjFkc = aZxh.f811KLFTb;
            c0052AZxh.f698AZxh = aZxh.f807JHa;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).width = aZxh.f853wA;
            ((ViewGroup.MarginLayoutParams) c0052AZxh).height = aZxh.f829ZfxDd;
            String str = aZxh.f839jm;
            if (str != null) {
                c0052AZxh.f753uHVRx = str;
            }
            c0052AZxh.setMarginStart(aZxh.f856xrEuO);
            c0052AZxh.setMarginEnd(this.f880ZfxDd.f799CqaNbM);
            c0052AZxh.m406mjFkc();
        }

        /* renamed from: ZfxDd */
        public final void m438ZfxDd(int i, ConstraintLayout.C0052AZxh c0052AZxh) {
            this.f881mjFkc = i;
            AZxh aZxh = this.f880ZfxDd;
            aZxh.f841lgHUyS = c0052AZxh.f731ZfxDd;
            aZxh.f847qdMbNW = c0052AZxh.f713KLFTb;
            aZxh.f800Dt = c0052AZxh.f709JHa;
            aZxh.f801ETF = c0052AZxh.f759xJ;
            aZxh.f821VA = c0052AZxh.f743lgHUyS;
            aZxh.f814MiMN = c0052AZxh.f749qdMbNW;
            aZxh.f828YoKzxo = c0052AZxh.f701Dt;
            aZxh.f849rkYL = c0052AZxh.f702ETF;
            aZxh.f846qGY = c0052AZxh.f723VA;
            aZxh.f837fehf = c0052AZxh.f748qGY;
            aZxh.f805IEE = c0052AZxh.f739fehf;
            aZxh.f818Pq = c0052AZxh.f706IEE;
            aZxh.f834diqgf = c0052AZxh.f720Pq;
            aZxh.f836eyqo = c0052AZxh.f754vI;
            aZxh.f820Ucbh = c0052AZxh.f726VocHEe;
            aZxh.f838huTpC = c0052AZxh.f699BAnRFn;
            aZxh.f803Gd = c0052AZxh.f716MiMN;
            aZxh.f804HGpJ = c0052AZxh.f730YoKzxo;
            aZxh.f851vI = c0052AZxh.f751rkYL;
            aZxh.f824VocHEe = c0052AZxh.f747oCFDzJ;
            aZxh.f798BAnRFn = c0052AZxh.f733aqHPIZ;
            aZxh.f840lB = c0052AZxh.f728WrLQs;
            aZxh.f855xJ = c0052AZxh.f757wA;
            aZxh.f811KLFTb = c0052AZxh.f745mjFkc;
            aZxh.f807JHa = c0052AZxh.f698AZxh;
            aZxh.f853wA = ((ViewGroup.MarginLayoutParams) c0052AZxh).width;
            aZxh.f829ZfxDd = ((ViewGroup.MarginLayoutParams) c0052AZxh).height;
            aZxh.f854wJVbdd = ((ViewGroup.MarginLayoutParams) c0052AZxh).leftMargin;
            aZxh.f842mByQ = ((ViewGroup.MarginLayoutParams) c0052AZxh).rightMargin;
            aZxh.f817OjSQV = ((ViewGroup.MarginLayoutParams) c0052AZxh).topMargin;
            aZxh.f816Ne = ((ViewGroup.MarginLayoutParams) c0052AZxh).bottomMargin;
            aZxh.f852vadzgd = c0052AZxh.f719OjSQV;
            aZxh.f845oCFDzJ = c0052AZxh.f744mByQ;
            aZxh.f826WrLQs = c0052AZxh.f700CqaNbM;
            aZxh.f831aqHPIZ = c0052AZxh.f718Ne;
            aZxh.f796ANMGZc = c0052AZxh.f715KRTLGT;
            aZxh.f830alEkx = c0052AZxh.f703GMIER;
            aZxh.f813KRTLGT = c0052AZxh.f761xrEuO;
            aZxh.f802GMIER = c0052AZxh.f714KLMXS;
            aZxh.f850uHVRx = c0052AZxh.f750rWxwaT;
            aZxh.f809JYn = c0052AZxh.f725Vnb;
            aZxh.f808JYgkl = c0052AZxh.f763zvd;
            aZxh.f810JrJO = c0052AZxh.f735cMLeY;
            aZxh.f844nxI = c0052AZxh.f717NPj;
            aZxh.f825WGXroI = c0052AZxh.f755vadzgd;
            aZxh.f839jm = c0052AZxh.f753uHVRx;
            aZxh.f857zvd = c0052AZxh.f738eyqo;
            aZxh.f848rWxwaT = c0052AZxh.f740huTpC;
            aZxh.f812KLMXS = c0052AZxh.f736diqgf;
            aZxh.f833cMLeY = c0052AZxh.f722Ucbh;
            aZxh.f815NPj = c0052AZxh.f704Gd;
            aZxh.f823Vnb = c0052AZxh.f705HGpJ;
            aZxh.f799CqaNbM = c0052AZxh.getMarginEnd();
            this.f880ZfxDd.f856xrEuO = c0052AZxh.getMarginStart();
        }

        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public mjFkc m439clone() {
            mjFkc mjfkc = new mjFkc();
            mjfkc.f880ZfxDd.m431mjFkc(this.f880ZfxDd);
            mjfkc.f882wA.m442mjFkc(this.f882wA);
            mjfkc.f877AZxh.m435mjFkc(this.f877AZxh);
            mjfkc.f879KLFTb.m433mjFkc(this.f879KLFTb);
            mjfkc.f881mjFkc = this.f881mjFkc;
            return mjfkc;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.wA$wA */
    public static class wA {

        /* renamed from: lgHUyS */
        public static SparseIntArray f883lgHUyS;

        /* renamed from: mjFkc */
        public boolean f888mjFkc = false;

        /* renamed from: AZxh */
        public int f884AZxh = -1;

        /* renamed from: wA */
        public String f889wA = null;

        /* renamed from: ZfxDd */
        public int f887ZfxDd = -1;

        /* renamed from: KLFTb */
        public int f886KLFTb = 0;

        /* renamed from: JHa */
        public float f885JHa = Float.NaN;

        /* renamed from: xJ */
        public float f890xJ = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f883lgHUyS = sparseIntArray;
            sparseIntArray.append(AbstractC3005V4.f11117awnh, 1);
            f883lgHUyS.append(AbstractC3005V4.f11033NU, 2);
            f883lgHUyS.append(AbstractC3005V4.f11122boLb, 3);
            f883lgHUyS.append(AbstractC3005V4.f10980GmK, 4);
            f883lgHUyS.append(AbstractC3005V4.f11205rB, 5);
            f883lgHUyS.append(AbstractC3005V4.f11248wsbqN, 6);
        }

        /* renamed from: AZxh */
        public void m441AZxh(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f11196pCk);
            this.f888mjFkc = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (f883lgHUyS.get(index)) {
                    case 1:
                        this.f890xJ = typedArrayObtainStyledAttributes.getFloat(index, this.f890xJ);
                        break;
                    case 2:
                        this.f887ZfxDd = typedArrayObtainStyledAttributes.getInt(index, this.f887ZfxDd);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f889wA = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f889wA = C4143mL.f14899wA[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f886KLFTb = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f884AZxh = C0057wA.m417MiMN(typedArrayObtainStyledAttributes, index, this.f884AZxh);
                        break;
                    case 6:
                        this.f885JHa = typedArrayObtainStyledAttributes.getFloat(index, this.f885JHa);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: mjFkc */
        public void m442mjFkc(wA wAVar) {
            this.f888mjFkc = wAVar.f888mjFkc;
            this.f884AZxh = wAVar.f884AZxh;
            this.f889wA = wAVar.f889wA;
            this.f887ZfxDd = wAVar.f887ZfxDd;
            this.f886KLFTb = wAVar.f886KLFTb;
            this.f890xJ = wAVar.f890xJ;
            this.f885JHa = wAVar.f885JHa;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f790KLFTb = sparseIntArray;
        sparseIntArray.append(AbstractC3005V4.f11148gtIJp, 25);
        f790KLFTb.append(AbstractC3005V4.f11169kism, 26);
        f790KLFTb.append(AbstractC3005V4.f11261yX, 29);
        f790KLFTb.append(AbstractC3005V4.f11141gYa, 30);
        f790KLFTb.append(AbstractC3005V4.f11165jx, 36);
        f790KLFTb.append(AbstractC3005V4.f11097XtE, 35);
        f790KLFTb.append(AbstractC3005V4.f11120bbzow, 4);
        f790KLFTb.append(AbstractC3005V4.f11093XV, 3);
        f790KLFTb.append(AbstractC3005V4.f11187nxI, 1);
        f790KLFTb.append(AbstractC3005V4.f11149gtr, 6);
        f790KLFTb.append(AbstractC3005V4.f10954Dp, 7);
        f790KLFTb.append(AbstractC3005V4.f11131dm, 17);
        f790KLFTb.append(AbstractC3005V4.f11222tQ, 18);
        f790KLFTb.append(AbstractC3005V4.f11263yfx, 19);
        f790KLFTb.append(AbstractC3005V4.f11042Pq, 27);
        f790KLFTb.append(AbstractC3005V4.f11017LREOK, 32);
        f790KLFTb.append(AbstractC3005V4.f11136fFz, 33);
        f790KLFTb.append(AbstractC3005V4.f11115alEkx, 10);
        f790KLFTb.append(AbstractC3005V4.f10935ANMGZc, 9);
        f790KLFTb.append(AbstractC3005V4.f11055Rc, 13);
        f790KLFTb.append(AbstractC3005V4.f11091XDdeP, 16);
        f790KLFTb.append(AbstractC3005V4.f11057SKTn, 14);
        f790KLFTb.append(AbstractC3005V4.f11137fLidf, 11);
        f790KLFTb.append(AbstractC3005V4.f11208rdJr, 15);
        f790KLFTb.append(AbstractC3005V4.f11151hvGY, 12);
        f790KLFTb.append(AbstractC3005V4.f11080Vgyli, 40);
        f790KLFTb.append(AbstractC3005V4.f11048Qr, 39);
        f790KLFTb.append(AbstractC3005V4.f11058SOS, 41);
        f790KLFTb.append(AbstractC3005V4.f11220tISON, 42);
        f790KLFTb.append(AbstractC3005V4.f11060SmIWf, 20);
        f790KLFTb.append(AbstractC3005V4.f11227uH, 37);
        f790KLFTb.append(AbstractC3005V4.f11160jm, 5);
        f790KLFTb.append(AbstractC3005V4.f11031NKyg, 82);
        f790KLFTb.append(AbstractC3005V4.f11092XFUzSY, 82);
        f790KLFTb.append(AbstractC3005V4.f11223tjSezt, 82);
        f790KLFTb.append(AbstractC3005V4.f11086WGXroI, 82);
        f790KLFTb.append(AbstractC3005V4.f11009JrJO, 82);
        f790KLFTb.append(AbstractC3005V4.f10979Gd, 24);
        f790KLFTb.append(AbstractC3005V4.f11236vI, 28);
        f790KLFTb.append(AbstractC3005V4.f11123cMLeY, 31);
        f790KLFTb.append(AbstractC3005V4.f11207rWxwaT, 8);
        f790KLFTb.append(AbstractC3005V4.f10984HGpJ, 34);
        f790KLFTb.append(AbstractC3005V4.f11082VocHEe, 2);
        f790KLFTb.append(AbstractC3005V4.f11072Ucbh, 23);
        f790KLFTb.append(AbstractC3005V4.f11150huTpC, 21);
        f790KLFTb.append(AbstractC3005V4.f11135eyqo, 22);
        f790KLFTb.append(AbstractC3005V4.f10941BAnRFn, 43);
        f790KLFTb.append(AbstractC3005V4.f11032NPj, 44);
        f790KLFTb.append(AbstractC3005V4.f11012KLMXS, 45);
        f790KLFTb.append(AbstractC3005V4.f11268zvd, 46);
        f790KLFTb.append(AbstractC3005V4.f11258xrEuO, 60);
        f790KLFTb.append(AbstractC3005V4.f11035Ne, 47);
        f790KLFTb.append(AbstractC3005V4.f10953CqaNbM, 48);
        f790KLFTb.append(AbstractC3005V4.f11172lB, 49);
        f790KLFTb.append(AbstractC3005V4.f11245wJVbdd, 50);
        f790KLFTb.append(AbstractC3005V4.f11176mByQ, 51);
        f790KLFTb.append(AbstractC3005V4.f11038OjSQV, 52);
        f790KLFTb.append(AbstractC3005V4.f11081Vnb, 53);
        f790KLFTb.append(AbstractC3005V4.f11175lti, 54);
        f790KLFTb.append(AbstractC3005V4.f11242vjlshU, 55);
        f790KLFTb.append(AbstractC3005V4.f11145giT, 56);
        f790KLFTb.append(AbstractC3005V4.f11254xROA, 57);
        f790KLFTb.append(AbstractC3005V4.f11213sRqPfw, 58);
        f790KLFTb.append(AbstractC3005V4.f10993IVlxe, 59);
        f790KLFTb.append(AbstractC3005V4.f11062SwgkN, 61);
        f790KLFTb.append(AbstractC3005V4.f11078Vdz, 62);
        f790KLFTb.append(AbstractC3005V4.f10999JBhc, 63);
        f790KLFTb.append(AbstractC3005V4.f11240vadzgd, 64);
        f790KLFTb.append(AbstractC3005V4.f11096XgAT, 65);
        f790KLFTb.append(AbstractC3005V4.f11228uHVRx, 66);
        f790KLFTb.append(AbstractC3005V4.f10998IyS, 67);
        f790KLFTb.append(AbstractC3005V4.f10968FbxKQm, 79);
        f790KLFTb.append(AbstractC3005V4.f11129diqgf, 38);
        f790KLFTb.append(AbstractC3005V4.f11134eQ, 68);
        f790KLFTb.append(AbstractC3005V4.f11089XD, 69);
        f790KLFTb.append(AbstractC3005V4.f11028Moer, 70);
        f790KLFTb.append(AbstractC3005V4.f11013KRTLGT, 71);
        f790KLFTb.append(AbstractC3005V4.f11116aqHPIZ, 72);
        f790KLFTb.append(AbstractC3005V4.f11087WrLQs, 73);
        f790KLFTb.append(AbstractC3005V4.f10977GMIER, 74);
        f790KLFTb.append(AbstractC3005V4.f11188oCFDzJ, 75);
        f790KLFTb.append(AbstractC3005V4.f11163jtz, 76);
        f790KLFTb.append(AbstractC3005V4.f11095XbiWeM, 77);
        f790KLFTb.append(AbstractC3005V4.f11219tAfC, 78);
        f790KLFTb.append(AbstractC3005V4.f11004JYgkl, 80);
        f790KLFTb.append(AbstractC3005V4.f11005JYn, 81);
    }

    /* renamed from: MiMN */
    public static int m417MiMN(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* renamed from: Dt */
    public final mjFkc m419Dt(int i) {
        if (!this.f794wA.containsKey(Integer.valueOf(i))) {
            this.f794wA.put(Integer.valueOf(i), new mjFkc());
        }
        return (mjFkc) this.f794wA.get(Integer.valueOf(i));
    }

    /* renamed from: ETF */
    public void m420ETF(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    mjFkc mjfkcM427qdMbNW = m427qdMbNW(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        mjfkcM427qdMbNW.f880ZfxDd.f843mjFkc = true;
                    }
                    this.f794wA.put(Integer.valueOf(mjfkcM427qdMbNW.f881mjFkc), mjfkcM427qdMbNW);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: JHa */
    public void m421JHa(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f794wA.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.C0052AZxh c0052AZxh = (ConstraintLayout.C0052AZxh) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f792AZxh && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f794wA.containsKey(Integer.valueOf(id))) {
                this.f794wA.put(Integer.valueOf(id), new mjFkc());
            }
            mjFkc mjfkc = (mjFkc) this.f794wA.get(Integer.valueOf(id));
            mjfkc.f878JHa = C0056mjFkc.m411mjFkc(this.f793mjFkc, childAt);
            mjfkc.m438ZfxDd(id, c0052AZxh);
            mjfkc.f877AZxh.f872AZxh = childAt.getVisibility();
            mjfkc.f877AZxh.f874ZfxDd = childAt.getAlpha();
            mjfkc.f879KLFTb.f859AZxh = childAt.getRotation();
            mjfkc.f879KLFTb.f870wA = childAt.getRotationX();
            mjfkc.f879KLFTb.f866ZfxDd = childAt.getRotationY();
            mjfkc.f879KLFTb.f863KLFTb = childAt.getScaleX();
            mjfkc.f879KLFTb.f862JHa = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                KLFTb kLFTb = mjfkc.f879KLFTb;
                kLFTb.f871xJ = pivotX;
                kLFTb.f867lgHUyS = pivotY;
            }
            mjfkc.f879KLFTb.f869qdMbNW = childAt.getTranslationX();
            mjfkc.f879KLFTb.f860Dt = childAt.getTranslationY();
            mjfkc.f879KLFTb.f861ETF = childAt.getTranslationZ();
            KLFTb kLFTb2 = mjfkc.f879KLFTb;
            if (kLFTb2.f865VA) {
                kLFTb2.f864MiMN = childAt.getElevation();
            }
            if (childAt instanceof C0051Barrier) {
                C0051Barrier c0051Barrier = (C0051Barrier) childAt;
                mjfkc.f880ZfxDd.f835dm = c0051Barrier.m384YoKzxo();
                mjfkc.f880ZfxDd.f806JBhc = c0051Barrier.getReferencedIds();
                mjfkc.f880ZfxDd.f827XV = c0051Barrier.m385getType();
                mjfkc.f880ZfxDd.f832bbzow = c0051Barrier.getMargin();
            }
        }
    }

    /* renamed from: KLFTb */
    public void m422KLFTb(Context context, int i) {
        m421JHa((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017d, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* renamed from: VA */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m423VA(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        try {
            int eventType = xmlPullParser.getEventType();
            mjFkc mjfkcM427qdMbNW = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c = 3;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (!name.equals("Layout")) {
                                    c = 65535;
                                    break;
                                } else {
                                    c = 5;
                                    break;
                                }
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    break;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                mjfkcM427qdMbNW = m427qdMbNW(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 1:
                                mjfkcM427qdMbNW = m427qdMbNW(context, Xml.asAttributeSet(xmlPullParser));
                                AZxh aZxh = mjfkcM427qdMbNW.f880ZfxDd;
                                aZxh.f843mjFkc = true;
                                aZxh.f797AZxh = true;
                                break;
                            case 2:
                                mjfkcM427qdMbNW = m427qdMbNW(context, Xml.asAttributeSet(xmlPullParser));
                                mjfkcM427qdMbNW.f880ZfxDd.f819SwgkN = 1;
                                break;
                            case 3:
                                if (mjfkcM427qdMbNW == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                mjfkcM427qdMbNW.f877AZxh.m434AZxh(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 4:
                                if (mjfkcM427qdMbNW == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                mjfkcM427qdMbNW.f879KLFTb.m432AZxh(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 5:
                                if (mjfkcM427qdMbNW == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                mjfkcM427qdMbNW.f880ZfxDd.m430AZxh(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 6:
                                if (mjfkcM427qdMbNW == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                mjfkcM427qdMbNW.f882wA.m441AZxh(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 7:
                                if (mjfkcM427qdMbNW == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                C0056mjFkc.m410AZxh(context, xmlPullParser, mjfkcM427qdMbNW.f878JHa);
                                break;
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if ("ConstraintSet".equals(name2)) {
                            return;
                        }
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.f794wA.put(Integer.valueOf(mjfkcM427qdMbNW.f881mjFkc), mjfkcM427qdMbNW);
                            mjfkcM427qdMbNW = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: YoKzxo */
    public final void m424YoKzxo(Context context, mjFkc mjfkc, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != AbstractC3005V4.f11129diqgf && AbstractC3005V4.f11123cMLeY != index && AbstractC3005V4.f11207rWxwaT != index) {
                mjfkc.f882wA.f888mjFkc = true;
                mjfkc.f880ZfxDd.f797AZxh = true;
                mjfkc.f877AZxh.f875mjFkc = true;
                mjfkc.f879KLFTb.f868mjFkc = true;
            }
            switch (f790KLFTb.get(index)) {
                case 1:
                    AZxh aZxh = mjfkc.f880ZfxDd;
                    aZxh.f846qGY = m417MiMN(typedArray, index, aZxh.f846qGY);
                    break;
                case 2:
                    AZxh aZxh2 = mjfkc.f880ZfxDd;
                    aZxh2.f816Ne = typedArray.getDimensionPixelSize(index, aZxh2.f816Ne);
                    break;
                case 3:
                    AZxh aZxh3 = mjfkc.f880ZfxDd;
                    aZxh3.f849rkYL = m417MiMN(typedArray, index, aZxh3.f849rkYL);
                    break;
                case 4:
                    AZxh aZxh4 = mjfkc.f880ZfxDd;
                    aZxh4.f828YoKzxo = m417MiMN(typedArray, index, aZxh4.f828YoKzxo);
                    break;
                case 5:
                    mjfkc.f880ZfxDd.f838huTpC = typedArray.getString(index);
                    break;
                case 6:
                    AZxh aZxh5 = mjfkc.f880ZfxDd;
                    aZxh5.f824VocHEe = typedArray.getDimensionPixelOffset(index, aZxh5.f824VocHEe);
                    break;
                case 7:
                    AZxh aZxh6 = mjfkc.f880ZfxDd;
                    aZxh6.f798BAnRFn = typedArray.getDimensionPixelOffset(index, aZxh6.f798BAnRFn);
                    break;
                case 8:
                    AZxh aZxh7 = mjfkc.f880ZfxDd;
                    aZxh7.f799CqaNbM = typedArray.getDimensionPixelSize(index, aZxh7.f799CqaNbM);
                    break;
                case 9:
                    AZxh aZxh8 = mjfkc.f880ZfxDd;
                    aZxh8.f834diqgf = m417MiMN(typedArray, index, aZxh8.f834diqgf);
                    break;
                case 10:
                    AZxh aZxh9 = mjfkc.f880ZfxDd;
                    aZxh9.f818Pq = m417MiMN(typedArray, index, aZxh9.f818Pq);
                    break;
                case 11:
                    AZxh aZxh10 = mjfkc.f880ZfxDd;
                    aZxh10.f848rWxwaT = typedArray.getDimensionPixelSize(index, aZxh10.f848rWxwaT);
                    break;
                case 12:
                    AZxh aZxh11 = mjfkc.f880ZfxDd;
                    aZxh11.f823Vnb = typedArray.getDimensionPixelSize(index, aZxh11.f823Vnb);
                    break;
                case 13:
                    AZxh aZxh12 = mjfkc.f880ZfxDd;
                    aZxh12.f812KLMXS = typedArray.getDimensionPixelSize(index, aZxh12.f812KLMXS);
                    break;
                case 14:
                    AZxh aZxh13 = mjfkc.f880ZfxDd;
                    aZxh13.f833cMLeY = typedArray.getDimensionPixelSize(index, aZxh13.f833cMLeY);
                    break;
                case 15:
                    AZxh aZxh14 = mjfkc.f880ZfxDd;
                    aZxh14.f815NPj = typedArray.getDimensionPixelSize(index, aZxh14.f815NPj);
                    break;
                case 16:
                    AZxh aZxh15 = mjfkc.f880ZfxDd;
                    aZxh15.f857zvd = typedArray.getDimensionPixelSize(index, aZxh15.f857zvd);
                    break;
                case 17:
                    AZxh aZxh16 = mjfkc.f880ZfxDd;
                    aZxh16.f811KLFTb = typedArray.getDimensionPixelOffset(index, aZxh16.f811KLFTb);
                    break;
                case 18:
                    AZxh aZxh17 = mjfkc.f880ZfxDd;
                    aZxh17.f807JHa = typedArray.getDimensionPixelOffset(index, aZxh17.f807JHa);
                    break;
                case 19:
                    AZxh aZxh18 = mjfkc.f880ZfxDd;
                    aZxh18.f855xJ = typedArray.getFloat(index, aZxh18.f855xJ);
                    break;
                case 20:
                    AZxh aZxh19 = mjfkc.f880ZfxDd;
                    aZxh19.f836eyqo = typedArray.getFloat(index, aZxh19.f836eyqo);
                    break;
                case 21:
                    AZxh aZxh20 = mjfkc.f880ZfxDd;
                    aZxh20.f829ZfxDd = typedArray.getLayoutDimension(index, aZxh20.f829ZfxDd);
                    break;
                case 22:
                    ZfxDd zfxDd = mjfkc.f877AZxh;
                    zfxDd.f872AZxh = typedArray.getInt(index, zfxDd.f872AZxh);
                    ZfxDd zfxDd2 = mjfkc.f877AZxh;
                    zfxDd2.f872AZxh = f791ZfxDd[zfxDd2.f872AZxh];
                    break;
                case 23:
                    AZxh aZxh21 = mjfkc.f880ZfxDd;
                    aZxh21.f853wA = typedArray.getLayoutDimension(index, aZxh21.f853wA);
                    break;
                case 24:
                    AZxh aZxh22 = mjfkc.f880ZfxDd;
                    aZxh22.f854wJVbdd = typedArray.getDimensionPixelSize(index, aZxh22.f854wJVbdd);
                    break;
                case 25:
                    AZxh aZxh23 = mjfkc.f880ZfxDd;
                    aZxh23.f841lgHUyS = m417MiMN(typedArray, index, aZxh23.f841lgHUyS);
                    break;
                case 26:
                    AZxh aZxh24 = mjfkc.f880ZfxDd;
                    aZxh24.f847qdMbNW = m417MiMN(typedArray, index, aZxh24.f847qdMbNW);
                    break;
                case 27:
                    AZxh aZxh25 = mjfkc.f880ZfxDd;
                    aZxh25.f840lB = typedArray.getInt(index, aZxh25.f840lB);
                    break;
                case 28:
                    AZxh aZxh26 = mjfkc.f880ZfxDd;
                    aZxh26.f842mByQ = typedArray.getDimensionPixelSize(index, aZxh26.f842mByQ);
                    break;
                case 29:
                    AZxh aZxh27 = mjfkc.f880ZfxDd;
                    aZxh27.f800Dt = m417MiMN(typedArray, index, aZxh27.f800Dt);
                    break;
                case 30:
                    AZxh aZxh28 = mjfkc.f880ZfxDd;
                    aZxh28.f801ETF = m417MiMN(typedArray, index, aZxh28.f801ETF);
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    AZxh aZxh29 = mjfkc.f880ZfxDd;
                    aZxh29.f856xrEuO = typedArray.getDimensionPixelSize(index, aZxh29.f856xrEuO);
                    break;
                case 32:
                    AZxh aZxh30 = mjfkc.f880ZfxDd;
                    aZxh30.f837fehf = m417MiMN(typedArray, index, aZxh30.f837fehf);
                    break;
                case 33:
                    AZxh aZxh31 = mjfkc.f880ZfxDd;
                    aZxh31.f805IEE = m417MiMN(typedArray, index, aZxh31.f805IEE);
                    break;
                case 34:
                    AZxh aZxh32 = mjfkc.f880ZfxDd;
                    aZxh32.f817OjSQV = typedArray.getDimensionPixelSize(index, aZxh32.f817OjSQV);
                    break;
                case 35:
                    AZxh aZxh33 = mjfkc.f880ZfxDd;
                    aZxh33.f814MiMN = m417MiMN(typedArray, index, aZxh33.f814MiMN);
                    break;
                case 36:
                    AZxh aZxh34 = mjfkc.f880ZfxDd;
                    aZxh34.f821VA = m417MiMN(typedArray, index, aZxh34.f821VA);
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    AZxh aZxh35 = mjfkc.f880ZfxDd;
                    aZxh35.f820Ucbh = typedArray.getFloat(index, aZxh35.f820Ucbh);
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    mjfkc.f881mjFkc = typedArray.getResourceId(index, mjfkc.f881mjFkc);
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    AZxh aZxh36 = mjfkc.f880ZfxDd;
                    aZxh36.f845oCFDzJ = typedArray.getFloat(index, aZxh36.f845oCFDzJ);
                    break;
                case 40:
                    AZxh aZxh37 = mjfkc.f880ZfxDd;
                    aZxh37.f852vadzgd = typedArray.getFloat(index, aZxh37.f852vadzgd);
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    AZxh aZxh38 = mjfkc.f880ZfxDd;
                    aZxh38.f831aqHPIZ = typedArray.getInt(index, aZxh38.f831aqHPIZ);
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    AZxh aZxh39 = mjfkc.f880ZfxDd;
                    aZxh39.f826WrLQs = typedArray.getInt(index, aZxh39.f826WrLQs);
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    ZfxDd zfxDd3 = mjfkc.f877AZxh;
                    zfxDd3.f874ZfxDd = typedArray.getFloat(index, zfxDd3.f874ZfxDd);
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    KLFTb kLFTb = mjfkc.f879KLFTb;
                    kLFTb.f865VA = true;
                    kLFTb.f864MiMN = typedArray.getDimension(index, kLFTb.f864MiMN);
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    KLFTb kLFTb2 = mjfkc.f879KLFTb;
                    kLFTb2.f870wA = typedArray.getFloat(index, kLFTb2.f870wA);
                    break;
                case 46:
                    KLFTb kLFTb3 = mjfkc.f879KLFTb;
                    kLFTb3.f866ZfxDd = typedArray.getFloat(index, kLFTb3.f866ZfxDd);
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    KLFTb kLFTb4 = mjfkc.f879KLFTb;
                    kLFTb4.f863KLFTb = typedArray.getFloat(index, kLFTb4.f863KLFTb);
                    break;
                case 48:
                    KLFTb kLFTb5 = mjfkc.f879KLFTb;
                    kLFTb5.f862JHa = typedArray.getFloat(index, kLFTb5.f862JHa);
                    break;
                case 49:
                    KLFTb kLFTb6 = mjfkc.f879KLFTb;
                    kLFTb6.f871xJ = typedArray.getDimension(index, kLFTb6.f871xJ);
                    break;
                case 50:
                    KLFTb kLFTb7 = mjfkc.f879KLFTb;
                    kLFTb7.f867lgHUyS = typedArray.getDimension(index, kLFTb7.f867lgHUyS);
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                    KLFTb kLFTb8 = mjfkc.f879KLFTb;
                    kLFTb8.f869qdMbNW = typedArray.getDimension(index, kLFTb8.f869qdMbNW);
                    break;
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    KLFTb kLFTb9 = mjfkc.f879KLFTb;
                    kLFTb9.f860Dt = typedArray.getDimension(index, kLFTb9.f860Dt);
                    break;
                case C5125EACTags.f18346SEX /* 53 */:
                    KLFTb kLFTb10 = mjfkc.f879KLFTb;
                    kLFTb10.f861ETF = typedArray.getDimension(index, kLFTb10.f861ETF);
                    break;
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    AZxh aZxh40 = mjfkc.f880ZfxDd;
                    aZxh40.f813KRTLGT = typedArray.getInt(index, aZxh40.f813KRTLGT);
                    break;
                case 55:
                    AZxh aZxh41 = mjfkc.f880ZfxDd;
                    aZxh41.f802GMIER = typedArray.getInt(index, aZxh41.f802GMIER);
                    break;
                case 56:
                    AZxh aZxh42 = mjfkc.f880ZfxDd;
                    aZxh42.f850uHVRx = typedArray.getDimensionPixelSize(index, aZxh42.f850uHVRx);
                    break;
                case 57:
                    AZxh aZxh43 = mjfkc.f880ZfxDd;
                    aZxh43.f809JYn = typedArray.getDimensionPixelSize(index, aZxh43.f809JYn);
                    break;
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    AZxh aZxh44 = mjfkc.f880ZfxDd;
                    aZxh44.f808JYgkl = typedArray.getDimensionPixelSize(index, aZxh44.f808JYgkl);
                    break;
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    AZxh aZxh45 = mjfkc.f880ZfxDd;
                    aZxh45.f810JrJO = typedArray.getDimensionPixelSize(index, aZxh45.f810JrJO);
                    break;
                case 60:
                    KLFTb kLFTb11 = mjfkc.f879KLFTb;
                    kLFTb11.f859AZxh = typedArray.getFloat(index, kLFTb11.f859AZxh);
                    break;
                case 61:
                    AZxh aZxh46 = mjfkc.f880ZfxDd;
                    aZxh46.f803Gd = m417MiMN(typedArray, index, aZxh46.f803Gd);
                    break;
                case 62:
                    AZxh aZxh47 = mjfkc.f880ZfxDd;
                    aZxh47.f804HGpJ = typedArray.getDimensionPixelSize(index, aZxh47.f804HGpJ);
                    break;
                case 63:
                    AZxh aZxh48 = mjfkc.f880ZfxDd;
                    aZxh48.f851vI = typedArray.getFloat(index, aZxh48.f851vI);
                    break;
                case 64:
                    wA wAVar = mjfkc.f882wA;
                    wAVar.f884AZxh = m417MiMN(typedArray, index, wAVar.f884AZxh);
                    break;
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (typedArray.peekValue(index).type == 3) {
                        mjfkc.f882wA.f889wA = typedArray.getString(index);
                        break;
                    } else {
                        mjfkc.f882wA.f889wA = C4143mL.f14899wA[typedArray.getInteger(index, 0)];
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    mjfkc.f882wA.f886KLFTb = typedArray.getInt(index, 0);
                    break;
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    wA wAVar2 = mjfkc.f882wA;
                    wAVar2.f890xJ = typedArray.getFloat(index, wAVar2.f890xJ);
                    break;
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    ZfxDd zfxDd4 = mjfkc.f877AZxh;
                    zfxDd4.f873KLFTb = typedArray.getFloat(index, zfxDd4.f873KLFTb);
                    break;
                case C5125EACTags.DISPLAY_IMAGE /* 69 */:
                    mjfkc.f880ZfxDd.f844nxI = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    mjfkc.f880ZfxDd.f825WGXroI = typedArray.getFloat(index, 1.0f);
                    break;
                case C5125EACTags.MESSAGE_REFERENCE /* 71 */:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    AZxh aZxh49 = mjfkc.f880ZfxDd;
                    aZxh49.f827XV = typedArray.getInt(index, aZxh49.f827XV);
                    break;
                case 73:
                    AZxh aZxh50 = mjfkc.f880ZfxDd;
                    aZxh50.f832bbzow = typedArray.getDimensionPixelSize(index, aZxh50.f832bbzow);
                    break;
                case C5125EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY /* 74 */:
                    mjfkc.f880ZfxDd.f822Vdz = typedArray.getString(index);
                    break;
                case C5125EACTags.DEPRECATED /* 75 */:
                    AZxh aZxh51 = mjfkc.f880ZfxDd;
                    aZxh51.f835dm = typedArray.getBoolean(index, aZxh51.f835dm);
                    break;
                case 76:
                    wA wAVar3 = mjfkc.f882wA;
                    wAVar3.f887ZfxDd = typedArray.getInt(index, wAVar3.f887ZfxDd);
                    break;
                case C5125EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                    mjfkc.f880ZfxDd.f839jm = typedArray.getString(index);
                    break;
                case 78:
                    ZfxDd zfxDd5 = mjfkc.f877AZxh;
                    zfxDd5.f876wA = typedArray.getInt(index, zfxDd5.f876wA);
                    break;
                case 79:
                    wA wAVar4 = mjfkc.f882wA;
                    wAVar4.f885JHa = typedArray.getFloat(index, wAVar4.f885JHa);
                    break;
                case C5125EACTags.UNIFORM_RESOURCE_LOCATOR /* 80 */:
                    AZxh aZxh52 = mjfkc.f880ZfxDd;
                    aZxh52.f796ANMGZc = typedArray.getBoolean(index, aZxh52.f796ANMGZc);
                    break;
                case C5125EACTags.ANSWER_TO_RESET /* 81 */:
                    AZxh aZxh53 = mjfkc.f880ZfxDd;
                    aZxh53.f830alEkx = typedArray.getBoolean(index, aZxh53.f830alEkx);
                    break;
                case C5125EACTags.HISTORICAL_BYTES /* 82 */:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f790KLFTb.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f790KLFTb.get(index));
                    break;
            }
        }
    }

    /* renamed from: ZfxDd */
    public void m425ZfxDd(ConstraintLayout constraintLayout, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f794wA.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f794wA.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + AbstractC2079HBzZAD.m8524mjFkc(childAt));
            } else {
                if (this.f792AZxh && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f794wA.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        mjFkc mjfkc = (mjFkc) this.f794wA.get(Integer.valueOf(id));
                        if (childAt instanceof C0051Barrier) {
                            mjfkc.f880ZfxDd.f819SwgkN = 1;
                        }
                        int i2 = mjfkc.f880ZfxDd.f819SwgkN;
                        if (i2 != -1 && i2 == 1) {
                            C0051Barrier c0051Barrier = (C0051Barrier) childAt;
                            c0051Barrier.setId(id);
                            c0051Barrier.m387setType(mjfkc.f880ZfxDd.f827XV);
                            c0051Barrier.setMargin(mjfkc.f880ZfxDd.f832bbzow);
                            c0051Barrier.setAllowsGoneWidget(mjfkc.f880ZfxDd.f835dm);
                            AZxh aZxh = mjfkc.f880ZfxDd;
                            int[] iArr = aZxh.f806JBhc;
                            if (iArr != null) {
                                c0051Barrier.setReferencedIds(iArr);
                            } else {
                                String str = aZxh.f822Vdz;
                                if (str != null) {
                                    aZxh.f806JBhc = m426lgHUyS(c0051Barrier, str);
                                    c0051Barrier.setReferencedIds(mjfkc.f880ZfxDd.f806JBhc);
                                }
                            }
                        }
                        ConstraintLayout.C0052AZxh c0052AZxh = (ConstraintLayout.C0052AZxh) childAt.getLayoutParams();
                        c0052AZxh.m406mjFkc();
                        mjfkc.m437AZxh(c0052AZxh);
                        if (z) {
                            C0056mjFkc.m412wA(childAt, mjfkc.f878JHa);
                        }
                        childAt.setLayoutParams(c0052AZxh);
                        ZfxDd zfxDd = mjfkc.f877AZxh;
                        if (zfxDd.f876wA == 0) {
                            childAt.setVisibility(zfxDd.f872AZxh);
                        }
                        childAt.setAlpha(mjfkc.f877AZxh.f874ZfxDd);
                        childAt.setRotation(mjfkc.f879KLFTb.f859AZxh);
                        childAt.setRotationX(mjfkc.f879KLFTb.f870wA);
                        childAt.setRotationY(mjfkc.f879KLFTb.f866ZfxDd);
                        childAt.setScaleX(mjfkc.f879KLFTb.f863KLFTb);
                        childAt.setScaleY(mjfkc.f879KLFTb.f862JHa);
                        if (!Float.isNaN(mjfkc.f879KLFTb.f871xJ)) {
                            childAt.setPivotX(mjfkc.f879KLFTb.f871xJ);
                        }
                        if (!Float.isNaN(mjfkc.f879KLFTb.f867lgHUyS)) {
                            childAt.setPivotY(mjfkc.f879KLFTb.f867lgHUyS);
                        }
                        childAt.setTranslationX(mjfkc.f879KLFTb.f869qdMbNW);
                        childAt.setTranslationY(mjfkc.f879KLFTb.f860Dt);
                        childAt.setTranslationZ(mjfkc.f879KLFTb.f861ETF);
                        KLFTb kLFTb = mjfkc.f879KLFTb;
                        if (kLFTb.f865VA) {
                            childAt.setElevation(kLFTb.f864MiMN);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            mjFkc mjfkc2 = (mjFkc) this.f794wA.get(num);
            int i3 = mjfkc2.f880ZfxDd.f819SwgkN;
            if (i3 != -1 && i3 == 1) {
                C0051Barrier c0051Barrier2 = new C0051Barrier(constraintLayout.getContext());
                c0051Barrier2.setId(num.intValue());
                AZxh aZxh2 = mjfkc2.f880ZfxDd;
                int[] iArr2 = aZxh2.f806JBhc;
                if (iArr2 != null) {
                    c0051Barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = aZxh2.f822Vdz;
                    if (str2 != null) {
                        aZxh2.f806JBhc = m426lgHUyS(c0051Barrier2, str2);
                        c0051Barrier2.setReferencedIds(mjfkc2.f880ZfxDd.f806JBhc);
                    }
                }
                c0051Barrier2.m387setType(mjfkc2.f880ZfxDd.f827XV);
                c0051Barrier2.setMargin(mjfkc2.f880ZfxDd.f832bbzow);
                ConstraintLayout.C0052AZxh c0052AZxhM398ZfxDd = constraintLayout.generateDefaultLayoutParams();
                c0051Barrier2.m377MiMN();
                mjfkc2.m437AZxh(c0052AZxhM398ZfxDd);
                constraintLayout.addView(c0051Barrier2, c0052AZxhM398ZfxDd);
            }
            if (mjfkc2.f880ZfxDd.f843mjFkc) {
                View c0055ZfxDd = new C0055ZfxDd(constraintLayout.getContext());
                c0055ZfxDd.setId(num.intValue());
                ConstraintLayout.C0052AZxh c0052AZxhM398ZfxDd2 = constraintLayout.generateDefaultLayoutParams();
                mjfkc2.m437AZxh(c0052AZxhM398ZfxDd2);
                constraintLayout.addView(c0055ZfxDd, c0052AZxhM398ZfxDd2);
            }
        }
    }

    /* renamed from: lgHUyS */
    public final int[] m426lgHUyS(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objM392JHa;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            try {
                iIntValue = AbstractC4723v4.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objM392JHa = ((ConstraintLayout) view.getParent()).m392JHa(0, strTrim)) != null && (objM392JHa instanceof Integer)) {
                iIntValue = ((Integer) objM392JHa).intValue();
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    /* renamed from: qdMbNW */
    public final mjFkc m427qdMbNW(Context context, AttributeSet attributeSet) {
        mjFkc mjfkc = new mjFkc();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f10990IEE);
        m424YoKzxo(context, mjfkc, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return mjfkc;
    }

    /* renamed from: wA */
    public void m428wA(ConstraintLayout constraintLayout) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m425ZfxDd(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* renamed from: xJ */
    public void m429xJ(int i, int i2, int i3, float f) {
        AZxh aZxh = m419Dt(i).f880ZfxDd;
        aZxh.f803Gd = i2;
        aZxh.f804HGpJ = i3;
        aZxh.f851vI = f;
    }
}
