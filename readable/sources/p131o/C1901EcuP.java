package p131o;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;
import org.conscrypt.BuildConfig;

/* renamed from: o.EcuP */
/* loaded from: classes.dex */
public final class C1901EcuP {

    /* renamed from: mjFkc */
    public final JHa f8008mjFkc;

    /* renamed from: o.EcuP$AZxh */
    public static final class AZxh implements wA {

        /* renamed from: mjFkc */
        public final ContentInfo.Builder f8009mjFkc;

        public AZxh(ClipData clipData, int i) {
            this.f8009mjFkc = AbstractC3974joWJO.m12444mjFkc(clipData, i);
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: AZxh */
        public void mo8155AZxh(Uri uri) {
            this.f8009mjFkc.setLinkUri(uri);
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: build */
        public C1901EcuP mo8156build() {
            return new C1901EcuP(new KLFTb(this.f8009mjFkc.build()));
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: mjFkc */
        public void mo8157mjFkc(Bundle bundle) {
            this.f8009mjFkc.setExtras(bundle);
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: wA */
        public void mo8158wA(int i) {
            this.f8009mjFkc.setFlags(i);
        }
    }

    /* renamed from: o.EcuP$JHa */
    public interface JHa {
        /* renamed from: AZxh */
        int mo8159AZxh();

        int getSource();

        /* renamed from: mjFkc */
        ClipData mo8160mjFkc();

        /* renamed from: wA */
        ContentInfo mo8161wA();
    }

    /* renamed from: o.EcuP$KLFTb */
    public static final class KLFTb implements JHa {

        /* renamed from: mjFkc */
        public final ContentInfo f8010mjFkc;

        public KLFTb(ContentInfo contentInfo) {
            this.f8010mjFkc = AbstractC3309Zerm.m11211mjFkc(AbstractC2280K3.m9126xJ(contentInfo));
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: AZxh */
        public int mo8159AZxh() {
            return this.f8010mjFkc.getFlags();
        }

        @Override // p131o.C1901EcuP.JHa
        public int getSource() {
            return this.f8010mjFkc.getSource();
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: mjFkc */
        public ClipData mo8160mjFkc() {
            return this.f8010mjFkc.getClip();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f8010mjFkc + "}";
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: wA */
        public ContentInfo mo8161wA() {
            return this.f8010mjFkc;
        }
    }

    /* renamed from: o.EcuP$ZfxDd */
    public static final class ZfxDd implements wA {

        /* renamed from: AZxh */
        public int f8011AZxh;

        /* renamed from: KLFTb */
        public Bundle f8012KLFTb;

        /* renamed from: ZfxDd */
        public Uri f8013ZfxDd;

        /* renamed from: mjFkc */
        public ClipData f8014mjFkc;

        /* renamed from: wA */
        public int f8015wA;

        public ZfxDd(ClipData clipData, int i) {
            this.f8014mjFkc = clipData;
            this.f8011AZxh = i;
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: AZxh */
        public void mo8155AZxh(Uri uri) {
            this.f8013ZfxDd = uri;
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: build */
        public C1901EcuP mo8156build() {
            return new C1901EcuP(new xJ(this));
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: mjFkc */
        public void mo8157mjFkc(Bundle bundle) {
            this.f8012KLFTb = bundle;
        }

        @Override // p131o.C1901EcuP.wA
        /* renamed from: wA */
        public void mo8158wA(int i) {
            this.f8015wA = i;
        }
    }

    /* renamed from: o.EcuP$mjFkc */
    public static final class mjFkc {

        /* renamed from: mjFkc */
        public final wA f8016mjFkc;

        public mjFkc(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f8016mjFkc = new AZxh(clipData, i);
            } else {
                this.f8016mjFkc = new ZfxDd(clipData, i);
            }
        }

        /* renamed from: AZxh */
        public mjFkc m8162AZxh(Bundle bundle) {
            this.f8016mjFkc.mo8157mjFkc(bundle);
            return this;
        }

        /* renamed from: ZfxDd */
        public mjFkc m8163ZfxDd(Uri uri) {
            this.f8016mjFkc.mo8155AZxh(uri);
            return this;
        }

        /* renamed from: mjFkc */
        public C1901EcuP m8164mjFkc() {
            return this.f8016mjFkc.mo8156build();
        }

        /* renamed from: wA */
        public mjFkc m8165wA(int i) {
            this.f8016mjFkc.mo8158wA(i);
            return this;
        }
    }

    /* renamed from: o.EcuP$wA */
    public interface wA {
        /* renamed from: AZxh */
        void mo8155AZxh(Uri uri);

        /* renamed from: build */
        C1901EcuP mo8156build();

        /* renamed from: mjFkc */
        void mo8157mjFkc(Bundle bundle);

        /* renamed from: wA */
        void mo8158wA(int i);
    }

    /* renamed from: o.EcuP$xJ */
    public static final class xJ implements JHa {

        /* renamed from: AZxh */
        public final int f8017AZxh;

        /* renamed from: KLFTb */
        public final Bundle f8018KLFTb;

        /* renamed from: ZfxDd */
        public final Uri f8019ZfxDd;

        /* renamed from: mjFkc */
        public final ClipData f8020mjFkc;

        /* renamed from: wA */
        public final int f8021wA;

        public xJ(ZfxDd zfxDd) {
            this.f8020mjFkc = (ClipData) AbstractC2280K3.m9126xJ(zfxDd.f8014mjFkc);
            this.f8017AZxh = AbstractC2280K3.m9125wA(zfxDd.f8011AZxh, 0, 5, "source");
            this.f8021wA = AbstractC2280K3.m9119JHa(zfxDd.f8015wA, 1);
            this.f8019ZfxDd = zfxDd.f8013ZfxDd;
            this.f8018KLFTb = zfxDd.f8012KLFTb;
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: AZxh */
        public int mo8159AZxh() {
            return this.f8021wA;
        }

        @Override // p131o.C1901EcuP.JHa
        public int getSource() {
            return this.f8017AZxh;
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: mjFkc */
        public ClipData mo8160mjFkc() {
            return this.f8020mjFkc;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f8020mjFkc.getDescription());
            sb.append(", source=");
            sb.append(C1901EcuP.m8148KLFTb(this.f8017AZxh));
            sb.append(", flags=");
            sb.append(C1901EcuP.m8149mjFkc(this.f8021wA));
            Uri uri = this.f8019ZfxDd;
            String str2 = BuildConfig.f24315FLAVOR;
            if (uri == null) {
                str = BuildConfig.f24315FLAVOR;
            } else {
                str = ", hasLinkUri(" + this.f8019ZfxDd.toString().length() + ")";
            }
            sb.append(str);
            if (this.f8018KLFTb != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }

        @Override // p131o.C1901EcuP.JHa
        /* renamed from: wA */
        public ContentInfo mo8161wA() {
            return null;
        }
    }

    public C1901EcuP(JHa jHa) {
        this.f8008mjFkc = jHa;
    }

    /* renamed from: KLFTb */
    public static String m8148KLFTb(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    /* renamed from: mjFkc */
    public static String m8149mjFkc(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    /* renamed from: xJ */
    public static C1901EcuP m8150xJ(ContentInfo contentInfo) {
        return new C1901EcuP(new KLFTb(contentInfo));
    }

    /* renamed from: AZxh */
    public ClipData m8151AZxh() {
        return this.f8008mjFkc.mo8160mjFkc();
    }

    /* renamed from: JHa */
    public ContentInfo m8152JHa() {
        ContentInfo contentInfoMo8161wA = this.f8008mjFkc.mo8161wA();
        Objects.requireNonNull(contentInfoMo8161wA);
        return AbstractC3309Zerm.m11211mjFkc(contentInfoMo8161wA);
    }

    /* renamed from: ZfxDd */
    public int m8153ZfxDd() {
        return this.f8008mjFkc.getSource();
    }

    public String toString() {
        return this.f8008mjFkc.toString();
    }

    /* renamed from: wA */
    public int m8154wA() {
        return this.f8008mjFkc.mo8159AZxh();
    }
}
