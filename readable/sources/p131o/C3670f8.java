package p131o;

import com.p038google.p039android.p042gms.dynamite.descriptors.p049com.p050google.p051mlkit.dynamite.p052text.p054latin.ModuleDescriptor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.f8 */
/* loaded from: classes.dex */
public class C3670f8 implements InterfaceC3735g8 {

    /* renamed from: ZfxDd */
    public static final C3670f8 f13525ZfxDd = new mjFkc().m11896mjFkc();

    /* renamed from: AZxh */
    public final Executor f13526AZxh;

    /* renamed from: mjFkc */
    public final AtomicReference f13527mjFkc = new AtomicReference();

    /* renamed from: wA */
    public final String f13528wA = "taser_tflite_gocrlatin_mbv2_scriptid_aksara_layout_gcn_mobile";

    /* renamed from: o.f8$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public Executor f13529mjFkc;

        /* renamed from: mjFkc */
        public C3670f8 m11896mjFkc() {
            return new C3670f8(this.f13529mjFkc, "taser_tflite_gocrlatin_mbv2_scriptid_aksara_layout_gcn_mobile");
        }
    }

    public C3670f8(Executor executor, String str) {
        this.f13526AZxh = executor;
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: AZxh */
    public final String mo11886AZxh() {
        return this.f13528wA;
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: JHa */
    public final boolean mo11887JHa() {
        return AbstractC3804h8.m12211mjFkc(this.f13527mjFkc, ModuleDescriptor.MODULE_ID);
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: KLFTb */
    public final Executor mo11888KLFTb() {
        return this.f13526AZxh;
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: ZfxDd */
    public final String mo11889ZfxDd() {
        return "optional-module-text-latin";
    }

    /* renamed from: equals */
    public boolean m11890equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3670f8) {
            return AbstractC2931U2.m10465mjFkc(this.f13526AZxh, ((C3670f8) obj).f13526AZxh);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC2931U2.m10464AZxh(this.f13526AZxh);
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: lgHUyS */
    public final int mo11891lgHUyS() {
        return 1;
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: mjFkc */
    public final String mo11892mjFkc() {
        return "en";
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: qdMbNW */
    public final String mo11893qdMbNW() {
        return true != mo11887JHa() ? "com.google.android.gms.vision.ocr" : ModuleDescriptor.MODULE_ID;
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: wA */
    public final String mo11894wA() {
        return true != mo11887JHa() ? "play-services-mlkit-text-recognition" : "text-recognition";
    }

    @Override // p131o.InterfaceC3735g8
    /* renamed from: xJ */
    public final int mo11895xJ() {
        return mo11887JHa() ? 24317 : 24306;
    }
}
