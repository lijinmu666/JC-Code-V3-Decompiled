package p131o;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* renamed from: o.O */
/* loaded from: classes.dex */
public final class C2540O {

    /* renamed from: mjFkc */
    public final AZxh f9848mjFkc;

    /* renamed from: o.O$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        Object mo9785AZxh();

        /* renamed from: KLFTb */
        Uri mo9786KLFTb();

        /* renamed from: ZfxDd */
        void mo9787ZfxDd();

        /* renamed from: mjFkc */
        ClipDescription mo9788mjFkc();

        /* renamed from: wA */
        Uri mo9789wA();
    }

    /* renamed from: o.O$mjFkc */
    public static final class mjFkc implements AZxh {

        /* renamed from: mjFkc */
        public final InputContentInfo f9849mjFkc;

        public mjFkc(Object obj) {
            this.f9849mjFkc = (InputContentInfo) obj;
        }

        @Override // p131o.C2540O.AZxh
        /* renamed from: AZxh */
        public Object mo9785AZxh() {
            return this.f9849mjFkc;
        }

        @Override // p131o.C2540O.AZxh
        /* renamed from: KLFTb */
        public Uri mo9786KLFTb() {
            return this.f9849mjFkc.getLinkUri();
        }

        @Override // p131o.C2540O.AZxh
        /* renamed from: ZfxDd */
        public void mo9787ZfxDd() {
            this.f9849mjFkc.requestPermission();
        }

        @Override // p131o.C2540O.AZxh
        /* renamed from: mjFkc */
        public ClipDescription mo9788mjFkc() {
            return this.f9849mjFkc.getDescription();
        }

        @Override // p131o.C2540O.AZxh
        /* renamed from: wA */
        public Uri mo9789wA() {
            return this.f9849mjFkc.getContentUri();
        }
    }

    public C2540O(AZxh aZxh) {
        this.f9848mjFkc = aZxh;
    }

    /* renamed from: JHa */
    public static C2540O m9779JHa(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C2540O(new mjFkc(obj));
    }

    /* renamed from: AZxh */
    public ClipDescription m9780AZxh() {
        return this.f9848mjFkc.mo9788mjFkc();
    }

    /* renamed from: KLFTb */
    public Object m9781KLFTb() {
        return this.f9848mjFkc.mo9785AZxh();
    }

    /* renamed from: ZfxDd */
    public void m9782ZfxDd() {
        this.f9848mjFkc.mo9787ZfxDd();
    }

    /* renamed from: mjFkc */
    public Uri m9783mjFkc() {
        return this.f9848mjFkc.mo9789wA();
    }

    /* renamed from: wA */
    public Uri m9784wA() {
        return this.f9848mjFkc.mo9786KLFTb();
    }
}
