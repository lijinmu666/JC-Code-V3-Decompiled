package p131o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.Map;

/* renamed from: o.k3 */
/* loaded from: classes.dex */
public abstract class AbstractC3994k3 {

    /* renamed from: AZxh */
    public static final C2987UokA f14414AZxh;

    /* renamed from: BAnRFn */
    public static final AbstractC3414bC f14415BAnRFn;

    /* renamed from: Dt */
    public static final C2987UokA f14416Dt;

    /* renamed from: ETF */
    public static final C2987UokA f14417ETF;

    /* renamed from: Gd */
    public static final C2987UokA f14418Gd;

    /* renamed from: HGpJ */
    public static final C2987UokA f14419HGpJ;

    /* renamed from: IEE */
    public static final C2987UokA f14420IEE;

    /* renamed from: JHa */
    public static final C2987UokA f14421JHa;

    /* renamed from: KLFTb */
    public static final C2987UokA f14422KLFTb;

    /* renamed from: MiMN */
    public static final C2987UokA f14423MiMN;

    /* renamed from: Pq */
    public static final C2987UokA f14424Pq;

    /* renamed from: Ucbh */
    public static final C2987UokA f14425Ucbh;

    /* renamed from: VA */
    public static final C2987UokA f14426VA;

    /* renamed from: VocHEe */
    public static final AbstractC3414bC f14427VocHEe;

    /* renamed from: YoKzxo */
    public static final C2987UokA f14428YoKzxo;

    /* renamed from: ZfxDd */
    public static final C2987UokA f14429ZfxDd;

    /* renamed from: diqgf */
    public static final C2987UokA f14430diqgf;

    /* renamed from: eyqo */
    public static final C2987UokA f14431eyqo;

    /* renamed from: fehf */
    public static final C2987UokA f14432fehf;

    /* renamed from: huTpC */
    public static final C2987UokA f14433huTpC;

    /* renamed from: lgHUyS */
    public static final C2987UokA f14434lgHUyS;

    /* renamed from: mjFkc */
    public static final C2987UokA[] f14435mjFkc = new C2987UokA[0];

    /* renamed from: qGY */
    public static final C2987UokA f14436qGY;

    /* renamed from: qdMbNW */
    public static final C2987UokA f14437qdMbNW;

    /* renamed from: rkYL */
    public static final C2987UokA f14438rkYL;

    /* renamed from: vI */
    public static final C2987UokA f14439vI;

    /* renamed from: wA */
    public static final C2987UokA f14440wA;

    /* renamed from: xJ */
    public static final C2987UokA f14441xJ;

    static {
        C2987UokA c2987UokA = new C2987UokA("vision.barcode", 1L);
        f14414AZxh = c2987UokA;
        C2987UokA c2987UokA2 = new C2987UokA("vision.custom.ica", 1L);
        f14440wA = c2987UokA2;
        C2987UokA c2987UokA3 = new C2987UokA("vision.face", 1L);
        f14429ZfxDd = c2987UokA3;
        C2987UokA c2987UokA4 = new C2987UokA("vision.ica", 1L);
        f14422KLFTb = c2987UokA4;
        C2987UokA c2987UokA5 = new C2987UokA("vision.ocr", 1L);
        f14421JHa = c2987UokA5;
        f14441xJ = new C2987UokA("mlkit.ocr.chinese", 1L);
        f14434lgHUyS = new C2987UokA("mlkit.ocr.common", 1L);
        f14437qdMbNW = new C2987UokA("mlkit.ocr.devanagari", 1L);
        f14416Dt = new C2987UokA("mlkit.ocr.japanese", 1L);
        f14417ETF = new C2987UokA("mlkit.ocr.korean", 1L);
        C2987UokA c2987UokA6 = new C2987UokA("mlkit.langid", 1L);
        f14426VA = c2987UokA6;
        C2987UokA c2987UokA7 = new C2987UokA("mlkit.nlclassifier", 1L);
        f14423MiMN = c2987UokA7;
        C2987UokA c2987UokA8 = new C2987UokA("tflite_dynamite", 1L);
        f14428YoKzxo = c2987UokA8;
        C2987UokA c2987UokA9 = new C2987UokA("mlkit.barcode.ui", 1L);
        f14438rkYL = c2987UokA9;
        C2987UokA c2987UokA10 = new C2987UokA("mlkit.smartreply", 1L);
        f14436qGY = c2987UokA10;
        f14432fehf = new C2987UokA("mlkit.image.caption", 1L);
        f14420IEE = new C2987UokA("mlkit.docscan.detect", 1L);
        f14424Pq = new C2987UokA("mlkit.docscan.crop", 1L);
        f14430diqgf = new C2987UokA("mlkit.docscan.enhance", 1L);
        f14431eyqo = new C2987UokA("mlkit.docscan.ui", 1L);
        f14425Ucbh = new C2987UokA("mlkit.docscan.stain", 1L);
        f14433huTpC = new C2987UokA("mlkit.docscan.shadow", 1L);
        f14418Gd = new C2987UokA("mlkit.quality.aesthetic", 1L);
        f14419HGpJ = new C2987UokA("mlkit.quality.technical", 1L);
        f14439vI = new C2987UokA("mlkit.segmentation.subject", 1L);
        C3143XB c3143xb = new C3143XB();
        c3143xb.m10912mjFkc("barcode", c2987UokA);
        c3143xb.m10912mjFkc("custom_ica", c2987UokA2);
        c3143xb.m10912mjFkc("face", c2987UokA3);
        c3143xb.m10912mjFkc("ica", c2987UokA4);
        c3143xb.m10912mjFkc("ocr", c2987UokA5);
        c3143xb.m10912mjFkc("langid", c2987UokA6);
        c3143xb.m10912mjFkc("nlclassifier", c2987UokA7);
        c3143xb.m10912mjFkc("tflite_dynamite", c2987UokA8);
        c3143xb.m10912mjFkc("barcode_ui", c2987UokA9);
        c3143xb.m10912mjFkc("smart_reply", c2987UokA10);
        f14427VocHEe = c3143xb.m10911AZxh();
        C3143XB c3143xb2 = new C3143XB();
        c3143xb2.m10912mjFkc("com.google.android.gms.vision.barcode", c2987UokA);
        c3143xb2.m10912mjFkc("com.google.android.gms.vision.custom.ica", c2987UokA2);
        c3143xb2.m10912mjFkc("com.google.android.gms.vision.face", c2987UokA3);
        c3143xb2.m10912mjFkc("com.google.android.gms.vision.ica", c2987UokA4);
        c3143xb2.m10912mjFkc("com.google.android.gms.vision.ocr", c2987UokA5);
        c3143xb2.m10912mjFkc("com.google.android.gms.mlkit.langid", c2987UokA6);
        c3143xb2.m10912mjFkc("com.google.android.gms.mlkit.nlclassifier", c2987UokA7);
        c3143xb2.m10912mjFkc("com.google.android.gms.tflite_dynamite", c2987UokA8);
        c3143xb2.m10912mjFkc("com.google.android.gms.mlkit_smartreply", c2987UokA10);
        f14415BAnRFn = c3143xb2.m10911AZxh();
    }

    /* renamed from: AZxh */
    public static void m12463AZxh(Context context, List list) {
        if (C3661f.m11873JHa().m11875mjFkc(context) >= 221500000) {
            m12466wA(context, m12464ZfxDd(f14427VocHEe, list));
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }

    /* renamed from: ZfxDd */
    public static C2987UokA[] m12464ZfxDd(Map map, List list) {
        C2987UokA[] c2987UokAArr = new C2987UokA[list.size()];
        for (int i = 0; i < list.size(); i++) {
            c2987UokAArr[i] = (C2987UokA) AbstractC2138I3.m8648xJ((C2987UokA) map.get(list.get(i)));
        }
        return c2987UokAArr;
    }

    /* renamed from: mjFkc */
    public static void m12465mjFkc(Context context, String str) {
        m12463AZxh(context, AbstractC2878TB.m10400Dt(str));
    }

    /* renamed from: wA */
    public static void m12466wA(Context context, final C2987UokA[] c2987UokAArr) {
        AbstractC4320p2.m13059mjFkc(context).mo9522AZxh(C4522s2.m13445ZfxDd().m13450mjFkc(new InterfaceC3923j3() { // from class: o.OR
            @Override // p131o.InterfaceC3923j3
            /* renamed from: ZfxDd */
            public final C2987UokA[] mo4301ZfxDd() {
                C2987UokA[] c2987UokAArr2 = AbstractC3994k3.f14435mjFkc;
                return c2987UokAArr;
            }
        }).m13449AZxh()).mo7670wA(new InterfaceC3405b3() { // from class: o.vS
            @Override // p131o.InterfaceC3405b3
            /* renamed from: mjFkc */
            public final void mo4877mjFkc(Exception exc) {
                Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
            }
        });
    }
}
