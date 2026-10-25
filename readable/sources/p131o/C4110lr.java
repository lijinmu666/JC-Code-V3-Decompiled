package p131o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.p038google.p039android.libraries.p055vision.visionkit.pipeline.AndroidAssetUtil;
import com.p038google.p039android.libraries.p055vision.visionkit.pipeline.p056alt.PipelineException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: o.lr */
/* loaded from: classes.dex */
public final class C4110lr {

    /* renamed from: AZxh */
    public final AbstractC2038Ga f14833AZxh;

    /* renamed from: KLFTb */
    public boolean f14834KLFTb = true;

    /* renamed from: ZfxDd */
    public boolean f14835ZfxDd;

    /* renamed from: mjFkc */
    public final Context f14836mjFkc;

    /* renamed from: wA */
    public C2123Hq f14837wA;

    public C4110lr(Context context, AbstractC2038Ga abstractC2038Ga) {
        this.f14836mjFkc = context;
        this.f14833AZxh = abstractC2038Ga;
    }

    /* renamed from: mjFkc */
    public static C4110lr m12712mjFkc(Context context, AbstractC2038Ga abstractC2038Ga) {
        return new C4110lr(context, abstractC2038Ga);
    }

    /* renamed from: AZxh */
    public final AbstractC3720fu m12713AZxh(InterfaceC1929F interfaceC1929F, C1923Eu c1923Eu, boolean z) throws C3993k2 {
        AbstractC1790Cs abstractC1790CsM2415KLFTb;
        C2658Ps c2658Ps;
        C2658Ps c2658Ps2;
        C2658Ps c2658Ps3;
        AbstractC2194Iu abstractC2194IuM12715wA = m12715wA();
        if (!abstractC2194IuM12715wA.m8804ZfxDd()) {
            return AbstractC3720fu.m11965KLFTb(abstractC2194IuM12715wA);
        }
        try {
            int i = 3;
            int i2 = 1;
            if (c1923Eu.m8228AZxh() == -1) {
                Log.d("PipelineManager", "Start process bitmap");
                Bitmap bitmapCopy = (Bitmap) AbstractC2138I3.m8648xJ((Bitmap) BinderC2869T2.m10214xJ(interfaceC1929F));
                Bitmap.Config config = bitmapCopy.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    Log.d("PipelineManager", "Input bitmap is not ARGB_8888 config. Converting it to ARGB_8888 from " + String.valueOf(bitmapCopy.getConfig()));
                    bitmapCopy = bitmapCopy.copy(config2, bitmapCopy.isMutable());
                }
                abstractC1790CsM2415KLFTb = ((C2123Hq) AbstractC2138I3.m8648xJ(this.f14837wA)).m2419qdMbNW(SystemClock.elapsedRealtime() * 1000, bitmapCopy, AbstractC2594Or.m9909AZxh(c1923Eu.m8232wA()));
            } else if (c1923Eu.m8228AZxh() == 35) {
                Log.d("PipelineManager", "Start process YUV");
                Image.Plane[] planes = ((Image) AbstractC2138I3.m8648xJ(BinderC2869T2.m10214xJ(interfaceC1929F))).getPlanes();
                abstractC1790CsM2415KLFTb = ((C2123Hq) AbstractC2138I3.m8648xJ(this.f14837wA)).m2413Dt(SystemClock.elapsedRealtime() * 1000, ((Image.Plane) AbstractC2138I3.m8648xJ(planes[0])).getBuffer(), ((Image.Plane) AbstractC2138I3.m8648xJ(planes[1])).getBuffer(), ((Image.Plane) AbstractC2138I3.m8648xJ(planes[2])).getBuffer(), c1923Eu.m8230ZfxDd(), c1923Eu.m8231mjFkc(), ((Image.Plane) AbstractC2138I3.m8648xJ(planes[0])).getRowStride(), ((Image.Plane) AbstractC2138I3.m8648xJ(planes[1])).getRowStride(), ((Image.Plane) AbstractC2138I3.m8648xJ(planes[1])).getPixelStride(), AbstractC2594Or.m9909AZxh(c1923Eu.m8232wA()));
            } else if (c1923Eu.m8228AZxh() == 17) {
                Log.d("PipelineManager", "Start process NV21");
                abstractC1790CsM2415KLFTb = ((C2123Hq) AbstractC2138I3.m8648xJ(this.f14837wA)).m2415KLFTb(AbstractC2594Or.m9910mjFkc(C2066H.m8482mjFkc((ByteBuffer) AbstractC2138I3.m8648xJ((ByteBuffer) BinderC2869T2.m10214xJ(interfaceC1929F))), c1923Eu));
            } else {
                if (c1923Eu.m8228AZxh() != 842094169) {
                    throw new C3993k2("Unsupported image format: " + c1923Eu.m8228AZxh(), 3);
                }
                Log.d("PipelineManager", "Start process YV12");
                abstractC1790CsM2415KLFTb = ((C2123Hq) AbstractC2138I3.m8648xJ(this.f14837wA)).m2415KLFTb(AbstractC2594Or.m9910mjFkc(C2066H.m8481lgHUyS((ByteBuffer) AbstractC2138I3.m8648xJ(BinderC2869T2.m10214xJ(interfaceC1929F)), true), c1923Eu));
            }
            if (!abstractC1790CsM2415KLFTb.mo7940wA()) {
                return AbstractC3720fu.m11965KLFTb(AbstractC2194Iu.m8802wA(3, new RemoteException("VisionKit pipeline returns empty result.")));
            }
            Log.d("PipelineManager", "OCR process succeeded via visionkit pipeline.");
            C3907in c3907in = (C3907in) abstractC1790CsM2415KLFTb.mo7939mjFkc();
            Matrix matrixM8635KLFTb = C2134I.m8634AZxh().m8635KLFTb(c1923Eu.m8230ZfxDd(), c1923Eu.m8231mjFkc(), c1923Eu.m8232wA());
            boolean z2 = this.f14834KLFTb;
            C3583dl c3583dl = new C3583dl(0, AbstractC1790Cs.m7936ZfxDd());
            List<C2043Ge> listM8797xrEuO = c3907in.m12319KLMXS().m8797xrEuO();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            for (C2043Ge c2043Ge : listM8797xrEuO) {
                if (c2043Ge.m8450CqaNbM() == 6) {
                    C4312ov c4312ovM13867AZxh = AbstractC4840wp.m13867AZxh(c2043Ge.m8455zvd());
                    List listM13869wA = AbstractC4840wp.m13869wA(c4312ovM13867AZxh);
                    C3327Zu c3327Zu = new C3327Zu(c2043Ge.m8452Ne(), AbstractC4840wp.m13868mjFkc(listM13869wA, matrixM8635KLFTb), listM13869wA, c2043Ge.m8454xrEuO(), c4312ovM13867AZxh.m13046OjSQV());
                    Integer numValueOf = Integer.valueOf(c2043Ge.m8451KLMXS());
                    if (map2.containsKey(numValueOf)) {
                        c2658Ps3 = (C2658Ps) map2.get(numValueOf);
                    } else {
                        C2658Ps c2658Ps4 = new C2658Ps();
                        map2.put(numValueOf, c2658Ps4);
                        c2658Ps3 = c2658Ps4;
                    }
                    ((C2658Ps) AbstractC2138I3.m8648xJ(c2658Ps3)).m9967mjFkc(c3327Zu);
                }
            }
            int i3 = 0;
            while (i3 < listM8797xrEuO.size()) {
                C2043Ge c2043Ge2 = (C2043Ge) listM8797xrEuO.get(i3);
                if (c2043Ge2.m8450CqaNbM() == i2) {
                    C4312ov c4312ovM13867AZxh2 = AbstractC4840wp.m13867AZxh(c2043Ge2.m8455zvd());
                    List listM13869wA2 = AbstractC4840wp.m13869wA(c4312ovM13867AZxh2);
                    Integer numValueOf2 = Integer.valueOf(i3);
                    C2725Qu c2725Qu = new C2725Qu(c2043Ge2.m8452Ne(), AbstractC4840wp.m13868mjFkc(listM13869wA2, matrixM8635KLFTb), listM13869wA2, AbstractC3587dq.m11746mjFkc(c2043Ge2.m8453cMLeY().m13520CqaNbM()), c2043Ge2.m8454xrEuO(), c4312ovM13867AZxh2.m13046OjSQV(), (List) AbstractC2138I3.m8648xJ(map2.containsKey(numValueOf2) ? ((C2658Ps) AbstractC2138I3.m8648xJ((C2658Ps) map2.get(numValueOf2))).m9966AZxh() : AbstractC2919Ts.m10439Dt()));
                    Integer numValueOf3 = Integer.valueOf(c2043Ge2.m8451KLMXS());
                    if (map.containsKey(numValueOf3)) {
                        c2658Ps2 = (C2658Ps) map.get(numValueOf3);
                    } else {
                        C2658Ps c2658Ps5 = new C2658Ps();
                        map.put(numValueOf3, c2658Ps5);
                        c2658Ps2 = c2658Ps5;
                    }
                    ((C2658Ps) AbstractC2138I3.m8648xJ(c2658Ps2)).m9967mjFkc(c2725Qu);
                }
                i3++;
                i2 = 1;
            }
            int i4 = 0;
            while (i4 < listM8797xrEuO.size()) {
                C2043Ge c2043Ge3 = (C2043Ge) listM8797xrEuO.get(i4);
                if (c2043Ge3.m8450CqaNbM() == i) {
                    C4312ov c4312ovM13867AZxh3 = AbstractC4840wp.m13867AZxh(c2043Ge3.m8455zvd());
                    List listM13869wA3 = AbstractC4840wp.m13869wA(c4312ovM13867AZxh3);
                    Integer numValueOf4 = Integer.valueOf(i4);
                    C2859Su c2859Su = new C2859Su(c2043Ge3.m8452Ne(), AbstractC4840wp.m13868mjFkc(listM13869wA3, matrixM8635KLFTb), listM13869wA3, AbstractC3587dq.m11746mjFkc(c2043Ge3.m8453cMLeY().m13520CqaNbM()), (List) AbstractC2138I3.m8648xJ(map.containsKey(numValueOf4) ? ((C2658Ps) AbstractC2138I3.m8648xJ((C2658Ps) map.get(numValueOf4))).m9966AZxh() : AbstractC2919Ts.m10439Dt()), c2043Ge3.m8454xrEuO(), c4312ovM13867AZxh3.m13046OjSQV());
                    Integer numValueOf5 = Integer.valueOf(c2043Ge3.m8451KLMXS());
                    if (map3.containsKey(numValueOf5)) {
                        c2658Ps = (C2658Ps) map3.get(numValueOf5);
                    } else {
                        C2658Ps c2658Ps6 = new C2658Ps();
                        map3.put(Integer.valueOf(c2043Ge3.m8451KLMXS()), c2658Ps6);
                        c2658Ps = c2658Ps6;
                    }
                    ((C2658Ps) AbstractC2138I3.m8648xJ(c2658Ps)).m9967mjFkc(c2859Su);
                }
                i4++;
                i = 3;
            }
            C2658Ps c2658Ps7 = new C2658Ps();
            for (int i5 = 0; i5 < listM8797xrEuO.size(); i5++) {
                C2043Ge c2043Ge4 = (C2043Ge) listM8797xrEuO.get(i5);
                if (c2043Ge4.m8450CqaNbM() == 4) {
                    List listM13869wA4 = AbstractC4840wp.m13869wA(AbstractC4840wp.m13867AZxh(c2043Ge4.m8455zvd()));
                    AbstractC2919Ts abstractC2919TsM10439Dt = AbstractC2919Ts.m10439Dt();
                    Integer numValueOf6 = Integer.valueOf(i5);
                    if (map3.containsKey(numValueOf6)) {
                        abstractC2919TsM10439Dt = ((C2658Ps) AbstractC2138I3.m8648xJ((C2658Ps) map3.get(numValueOf6))).m9966AZxh();
                        map3.remove(numValueOf6);
                    }
                    c2658Ps7.m9967mjFkc(new C2598Ou(AbstractC1721Bt.f7538mjFkc.m7638AZxh(AbstractC3461bt.m11575mjFkc(abstractC2919TsM10439Dt, new InterfaceC5040zs() { // from class: o.ss
                        @Override // p131o.InterfaceC5040zs
                        /* renamed from: mjFkc */
                        public final Object mo10957mjFkc(Object obj) {
                            return ((C2859Su) obj).m10200wA();
                        }
                    })), AbstractC4840wp.m13868mjFkc(listM13869wA4, matrixM8635KLFTb), listM13869wA4, AbstractC3587dq.m11746mjFkc(c2043Ge4.m8453cMLeY().m13520CqaNbM()), (List) AbstractC2138I3.m8648xJ(abstractC2919TsM10439Dt)));
                }
            }
            Iterator it = map3.values().iterator();
            while (it.hasNext()) {
                AbstractC2919Ts abstractC2919TsM9966AZxh = ((C2658Ps) it.next()).m9966AZxh();
                int size = abstractC2919TsM9966AZxh.size();
                int i6 = 0;
                while (i6 < size) {
                    C2859Su c2859Su2 = (C2859Su) abstractC2919TsM9966AZxh.get(i6);
                    c2658Ps7.m9967mjFkc(new C2598Ou(c2859Su2.m10200wA(), c2859Su2.m10199mjFkc(), c2859Su2.m10198ZfxDd(), c2859Su2.m10197AZxh(), AbstractC2919Ts.m10440ETF(c2859Su2)));
                    i6++;
                    it = it;
                }
            }
            AbstractC2919Ts abstractC2919TsM9966AZxh2 = c2658Ps7.m9966AZxh();
            C2772Rd c2772Rd = new C2772Rd(c3583dl, new C2994Uu(AbstractC1721Bt.f7538mjFkc.m7638AZxh(AbstractC3461bt.m11575mjFkc(abstractC2919TsM9966AZxh2, new InterfaceC5040zs() { // from class: o.Xs
                @Override // p131o.InterfaceC5040zs
                /* renamed from: mjFkc */
                public final Object mo10957mjFkc(Object obj) {
                    return ((C2598Ou) obj).m9916mjFkc();
                }
            })), abstractC2919TsM9966AZxh2), AbstractC2919Ts.m10439Dt(), z2);
            this.f14834KLFTb = false;
            return c2772Rd;
        } catch (C3993k2 e) {
            return AbstractC3720fu.m11965KLFTb(AbstractC2194Iu.m8802wA(2, new RemoteException("Failed to process input image.".concat(String.valueOf(e.getMessage())))));
        }
    }

    /* renamed from: ZfxDd */
    public final void m12714ZfxDd() {
        C2123Hq c2123Hq = this.f14837wA;
        if (c2123Hq != null) {
            if (this.f14835ZfxDd) {
                c2123Hq.m2417lgHUyS();
            }
            this.f14837wA.m2414JHa();
            this.f14837wA = null;
        }
        this.f14835ZfxDd = false;
        this.f14834KLFTb = true;
    }

    /* renamed from: wA */
    public final AbstractC2194Iu m12715wA() {
        if (this.f14835ZfxDd) {
            return new C3583dl(0, AbstractC1790Cs.m7936ZfxDd());
        }
        if (this.f14837wA == null) {
            if (!AndroidAssetUtil.m2406mjFkc(this.f14836mjFkc)) {
                Log.d("PipelineManager", "Failed to initiate native asset manager.");
            }
            AbstractC2038Ga abstractC2038Ga = this.f14833AZxh;
            String strMo8429AZxh = abstractC2038Ga.mo8429AZxh();
            String strMo8431ZfxDd = abstractC2038Ga.mo8431ZfxDd();
            String strMo8432wA = abstractC2038Ga.mo8432wA();
            boolean zMo8430KLFTb = abstractC2038Ga.mo8430KLFTb();
            C3646em c3646emM12600Ne = C4041km.m12600Ne();
            int i = zMo8430KLFTb ? 4 : 0;
            C2330Kn c2330KnM10021Ne = C2717Qn.m10021Ne();
            C3904il c3904ilM13031OjSQV = C4301ol.m13031OjSQV();
            c3904ilM13031OjSQV.m12309Pq(strMo8431ZfxDd);
            c3904ilM13031OjSQV.m12312qGY(strMo8429AZxh);
            c3904ilM13031OjSQV.m12310diqgf(true);
            c3904ilM13031OjSQV.m12311fehf(true);
            if (!strMo8432wA.isEmpty()) {
                C4581sv c4581svM13658OjSQV = C4647tv.m13658OjSQV();
                C4780vv c4780vvM13972OjSQV = C4915xv.m13972OjSQV();
                c4780vvM13972OjSQV.m13799qGY(strMo8432wA);
                c4581svM13658OjSQV.m13529qGY(c4780vvM13972OjSQV);
                c3904ilM13031OjSQV.m12308IEE(c4581svM13658OjSQV);
            }
            c2330KnM10021Ne.m9276IEE(c3904ilM13031OjSQV);
            int iM11409mjFkc = AbstractC3385an.m11409mjFkc(i);
            C3115Wm c3115WmM11619OjSQV = C3520cn.m11619OjSQV();
            c3115WmM11619OjSQV.m10841qGY(iM11409mjFkc);
            c2330KnM10021Ne.m9277Pq(c3115WmM11619OjSQV);
            C2124Hr c2124HrM9282OjSQV = C2334Kr.m9282OjSQV();
            c2124HrM9282OjSQV.m8590qGY("PassThroughCoarseClassifier");
            c2330KnM10021Ne.m9278fehf(c2124HrM9282OjSQV);
            c3646emM12600Ne.m11863qGY(c2330KnM10021Ne);
            C1650Ap c1650ApM7860OjSQV = C1784Cp.m7860OjSQV();
            c1650ApM7860OjSQV.m7635qGY(2);
            c3646emM12600Ne.m11862fehf(c1650ApM7860OjSQV);
            this.f14837wA = new C2123Hq((C4041km) c3646emM12600Ne.mo9070ZfxDd(), this.f14833AZxh.mo8429AZxh(), "mlkit_google_ocr_pipeline");
        }
        try {
            ((C2123Hq) AbstractC2138I3.m8648xJ(this.f14837wA)).m2421xJ();
            this.f14835ZfxDd = true;
            return new C3583dl(0, AbstractC1790Cs.m7936ZfxDd());
        } catch (PipelineException e) {
            return AbstractC2194Iu.m8802wA(1, new RemoteException("Failed to initialize detector. ".concat((String) e.getRootCauseMessage().mo7937AZxh(BuildConfig.f24315FLAVOR))));
        }
    }
}
