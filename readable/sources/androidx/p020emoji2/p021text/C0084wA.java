package androidx.p020emoji2.p021text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p131o.AbstractC1992Frh;
import p131o.AbstractC2280K3;
import p131o.C3762gYa;
import p131o.C4394q9;
import p131o.C4742vL;

/* renamed from: androidx.emoji2.text.wA */
/* loaded from: classes.dex */
public class C0084wA {

    /* renamed from: qGY */
    public static volatile C0084wA f1030qGY;

    /* renamed from: AZxh */
    public final Set f1032AZxh;

    /* renamed from: Dt */
    public final boolean f1033Dt;

    /* renamed from: ETF */
    public final int f1034ETF;

    /* renamed from: JHa */
    public final xJ f1035JHa;

    /* renamed from: KLFTb */
    public final AZxh f1036KLFTb;

    /* renamed from: MiMN */
    public final ZfxDd f1037MiMN;

    /* renamed from: VA */
    public final int f1038VA;

    /* renamed from: lgHUyS */
    public final boolean f1040lgHUyS;

    /* renamed from: qdMbNW */
    public final int[] f1042qdMbNW;

    /* renamed from: xJ */
    public final boolean f1044xJ;

    /* renamed from: YoKzxo */
    public static final Object f1029YoKzxo = new Object();

    /* renamed from: rkYL */
    public static final Object f1031rkYL = new Object();

    /* renamed from: mjFkc */
    public final ReadWriteLock f1041mjFkc = new ReentrantReadWriteLock();

    /* renamed from: wA */
    public volatile int f1043wA = 3;

    /* renamed from: ZfxDd */
    public final Handler f1039ZfxDd = new Handler(Looper.getMainLooper());

    /* renamed from: androidx.emoji2.text.wA$AZxh */
    public static class AZxh {

        /* renamed from: mjFkc */
        public final C0084wA f1045mjFkc;

        public AZxh(C0084wA c0084wA) {
            this.f1045mjFkc = c0084wA;
        }

        /* renamed from: AZxh */
        public abstract CharSequence mo709AZxh(CharSequence charSequence, int i, int i2, int i3, boolean z);

        /* renamed from: mjFkc */
        public abstract void mo710mjFkc();

        /* renamed from: wA */
        public abstract void mo711wA(EditorInfo editorInfo);
    }

    /* renamed from: androidx.emoji2.text.wA$JHa */
    public static class JHa implements Runnable {

        /* renamed from: AZxh */
        public final Throwable f1046AZxh;

        /* renamed from: mjFkc */
        public final List f1047mjFkc;

        /* renamed from: wA */
        public final int f1048wA;

        public JHa(KLFTb kLFTb, int i) {
            this(Arrays.asList((KLFTb) AbstractC2280K3.m9122lgHUyS(kLFTb, "initCallback cannot be null")), i, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1047mjFkc.size();
            int i = 0;
            if (this.f1048wA != 1) {
                while (i < size) {
                    ((KLFTb) this.f1047mjFkc.get(i)).m713mjFkc(this.f1046AZxh);
                    i++;
                }
            } else {
                while (i < size) {
                    ((KLFTb) this.f1047mjFkc.get(i)).mo712AZxh();
                    i++;
                }
            }
        }

        public JHa(Collection collection, int i) {
            this(collection, i, null);
        }

        public JHa(Collection collection, int i, Throwable th) {
            AbstractC2280K3.m9122lgHUyS(collection, "initCallbacks cannot be null");
            this.f1047mjFkc = new ArrayList(collection);
            this.f1048wA = i;
            this.f1046AZxh = th;
        }
    }

    /* renamed from: androidx.emoji2.text.wA$KLFTb */
    public static abstract class KLFTb {
        /* renamed from: AZxh */
        public void mo712AZxh() {
        }

        /* renamed from: mjFkc */
        public void m713mjFkc(Throwable th) {
        }
    }

    /* renamed from: androidx.emoji2.text.wA$ZfxDd */
    public interface ZfxDd {
        /* renamed from: mjFkc */
        boolean mo625mjFkc(CharSequence charSequence, int i, int i2, int i3);
    }

    /* renamed from: androidx.emoji2.text.wA$lgHUyS */
    public static abstract class lgHUyS {
        /* renamed from: AZxh */
        public abstract void mo636AZxh(C0080JHa c0080JHa);

        /* renamed from: mjFkc */
        public abstract void mo637mjFkc(Throwable th);
    }

    /* renamed from: androidx.emoji2.text.wA$mjFkc */
    public static final class mjFkc extends AZxh {

        /* renamed from: AZxh */
        public volatile C0082ZfxDd f1049AZxh;

        /* renamed from: wA */
        public volatile C0080JHa f1050wA;

        /* renamed from: androidx.emoji2.text.wA$mjFkc$mjFkc, reason: collision with other inner class name */
        public class C6345mjFkc extends lgHUyS {
            public C6345mjFkc() {
            }

            @Override // androidx.p020emoji2.p021text.C0084wA.lgHUyS
            /* renamed from: AZxh */
            public void mo636AZxh(C0080JHa c0080JHa) {
                mjFkc.this.m714ZfxDd(c0080JHa);
            }

            @Override // androidx.p020emoji2.p021text.C0084wA.lgHUyS
            /* renamed from: mjFkc */
            public void mo637mjFkc(Throwable th) {
                mjFkc.this.f1045mjFkc.m697MiMN(th);
            }
        }

        public mjFkc(C0084wA c0084wA) {
            super(c0084wA);
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.AZxh
        /* renamed from: AZxh */
        public CharSequence mo709AZxh(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.f1049AZxh.m664lgHUyS(charSequence, i, i2, i3, z);
        }

        /* renamed from: ZfxDd */
        public void m714ZfxDd(C0080JHa c0080JHa) {
            if (c0080JHa == null) {
                this.f1045mjFkc.m697MiMN(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f1050wA = c0080JHa;
            C0080JHa c0080JHa2 = this.f1050wA;
            qdMbNW qdmbnw = new qdMbNW();
            ZfxDd zfxDd = this.f1045mjFkc.f1037MiMN;
            C0084wA c0084wA = this.f1045mjFkc;
            this.f1049AZxh = new C0082ZfxDd(c0080JHa2, qdmbnw, zfxDd, c0084wA.f1040lgHUyS, c0084wA.f1042qdMbNW);
            this.f1045mjFkc.m700YoKzxo();
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.AZxh
        /* renamed from: mjFkc */
        public void mo710mjFkc() {
            try {
                this.f1045mjFkc.f1035JHa.mo634mjFkc(new C6345mjFkc());
            } catch (Throwable th) {
                this.f1045mjFkc.m697MiMN(th);
            }
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.AZxh
        /* renamed from: wA */
        public void mo711wA(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f1050wA.m640KLFTb());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f1045mjFkc.f1044xJ);
        }
    }

    /* renamed from: androidx.emoji2.text.wA$qdMbNW */
    public static class qdMbNW {
        /* renamed from: mjFkc */
        public AbstractC1992Frh m715mjFkc(C4742vL c4742vL) {
            return new C4394q9(c4742vL);
        }
    }

    /* renamed from: androidx.emoji2.text.wA$wA */
    public static abstract class wA {

        /* renamed from: AZxh */
        public boolean f1052AZxh;

        /* renamed from: JHa */
        public boolean f1053JHa;

        /* renamed from: KLFTb */
        public Set f1054KLFTb;

        /* renamed from: ZfxDd */
        public int[] f1055ZfxDd;

        /* renamed from: mjFkc */
        public final xJ f1057mjFkc;

        /* renamed from: wA */
        public boolean f1059wA;

        /* renamed from: xJ */
        public int f1060xJ = -16711936;

        /* renamed from: lgHUyS */
        public int f1056lgHUyS = 0;

        /* renamed from: qdMbNW */
        public ZfxDd f1058qdMbNW = new C0075AZxh();

        public wA(xJ xJVar) {
            AbstractC2280K3.m9122lgHUyS(xJVar, "metadataLoader cannot be null.");
            this.f1057mjFkc = xJVar;
        }

        /* renamed from: AZxh */
        public wA m716AZxh(int i) {
            this.f1056lgHUyS = i;
            return this;
        }

        /* renamed from: mjFkc */
        public final xJ m717mjFkc() {
            return this.f1057mjFkc;
        }
    }

    /* renamed from: androidx.emoji2.text.wA$xJ */
    public interface xJ {
        /* renamed from: mjFkc */
        void mo634mjFkc(lgHUyS lghuys);
    }

    public C0084wA(wA wAVar) {
        this.f1044xJ = wAVar.f1052AZxh;
        this.f1040lgHUyS = wAVar.f1059wA;
        this.f1042qdMbNW = wAVar.f1055ZfxDd;
        this.f1033Dt = wAVar.f1053JHa;
        this.f1034ETF = wAVar.f1060xJ;
        this.f1035JHa = wAVar.f1057mjFkc;
        this.f1038VA = wAVar.f1056lgHUyS;
        this.f1037MiMN = wAVar.f1058qdMbNW;
        C3762gYa c3762gYa = new C3762gYa();
        this.f1032AZxh = c3762gYa;
        Set set = wAVar.f1054KLFTb;
        if (set != null && !set.isEmpty()) {
            c3762gYa.addAll(wAVar.f1054KLFTb);
        }
        this.f1036KLFTb = new mjFkc(this);
        m699VA();
    }

    /* renamed from: AZxh */
    public static C0084wA m688AZxh() {
        C0084wA c0084wA;
        synchronized (f1029YoKzxo) {
            c0084wA = f1030qGY;
            AbstractC2280K3.m9124qdMbNW(c0084wA != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return c0084wA;
    }

    /* renamed from: JHa */
    public static boolean m689JHa(Editable editable, int i, KeyEvent keyEvent) {
        return C0082ZfxDd.m660ZfxDd(editable, i, keyEvent);
    }

    /* renamed from: KLFTb */
    public static boolean m690KLFTb(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        return C0082ZfxDd.m661wA(inputConnection, editable, i, i2, z);
    }

    /* renamed from: lgHUyS */
    public static boolean m691lgHUyS() {
        return f1030qGY != null;
    }

    /* renamed from: xJ */
    public static C0084wA m693xJ(wA wAVar) {
        C0084wA c0084wA = f1030qGY;
        if (c0084wA == null) {
            synchronized (f1029YoKzxo) {
                try {
                    c0084wA = f1030qGY;
                    if (c0084wA == null) {
                        c0084wA = new C0084wA(wAVar);
                        f1030qGY = c0084wA;
                    }
                } finally {
                }
            }
        }
        return c0084wA;
    }

    /* renamed from: Dt */
    public final boolean m694Dt() {
        return m701ZfxDd() == 1;
    }

    /* renamed from: ETF */
    public void m695ETF() {
        AbstractC2280K3.m9124qdMbNW(this.f1038VA == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (m694Dt()) {
            return;
        }
        this.f1041mjFkc.writeLock().lock();
        try {
            if (this.f1043wA == 0) {
                return;
            }
            this.f1043wA = 0;
            this.f1041mjFkc.writeLock().unlock();
            this.f1036KLFTb.mo710mjFkc();
        } finally {
            this.f1041mjFkc.writeLock().unlock();
        }
    }

    /* renamed from: IEE */
    public CharSequence m696IEE(CharSequence charSequence, int i, int i2, int i3, int i4) {
        boolean z;
        AbstractC2280K3.m9124qdMbNW(m694Dt(), "Not initialized yet");
        AbstractC2280K3.m9120KLFTb(i, "start cannot be negative");
        AbstractC2280K3.m9120KLFTb(i2, "end cannot be negative");
        AbstractC2280K3.m9120KLFTb(i3, "maxEmojiCount cannot be negative");
        AbstractC2280K3.m9118AZxh(i <= i2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        AbstractC2280K3.m9118AZxh(i <= charSequence.length(), "start should be < than charSequence length");
        AbstractC2280K3.m9118AZxh(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.f1044xJ : false;
        } else {
            z = true;
        }
        return this.f1036KLFTb.mo709AZxh(charSequence, i, i2, i3, z);
    }

    /* renamed from: MiMN */
    public void m697MiMN(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1041mjFkc.writeLock().lock();
        try {
            this.f1043wA = 2;
            arrayList.addAll(this.f1032AZxh);
            this.f1032AZxh.clear();
            this.f1041mjFkc.writeLock().unlock();
            this.f1039ZfxDd.post(new JHa(arrayList, this.f1043wA, th));
        } catch (Throwable th2) {
            this.f1041mjFkc.writeLock().unlock();
            throw th2;
        }
    }

    /* renamed from: Pq */
    public void m698Pq(KLFTb kLFTb) {
        AbstractC2280K3.m9122lgHUyS(kLFTb, "initCallback cannot be null");
        this.f1041mjFkc.writeLock().lock();
        try {
            if (this.f1043wA == 1 || this.f1043wA == 2) {
                this.f1039ZfxDd.post(new JHa(kLFTb, this.f1043wA));
            } else {
                this.f1032AZxh.add(kLFTb);
            }
            this.f1041mjFkc.writeLock().unlock();
        } catch (Throwable th) {
            this.f1041mjFkc.writeLock().unlock();
            throw th;
        }
    }

    /* renamed from: VA */
    public final void m699VA() {
        this.f1041mjFkc.writeLock().lock();
        try {
            if (this.f1038VA == 0) {
                this.f1043wA = 0;
            }
            this.f1041mjFkc.writeLock().unlock();
            if (m701ZfxDd() == 0) {
                this.f1036KLFTb.mo710mjFkc();
            }
        } catch (Throwable th) {
            this.f1041mjFkc.writeLock().unlock();
            throw th;
        }
    }

    /* renamed from: YoKzxo */
    public void m700YoKzxo() {
        ArrayList arrayList = new ArrayList();
        this.f1041mjFkc.writeLock().lock();
        try {
            this.f1043wA = 1;
            arrayList.addAll(this.f1032AZxh);
            this.f1032AZxh.clear();
            this.f1041mjFkc.writeLock().unlock();
            this.f1039ZfxDd.post(new JHa(arrayList, this.f1043wA));
        } catch (Throwable th) {
            this.f1041mjFkc.writeLock().unlock();
            throw th;
        }
    }

    /* renamed from: ZfxDd */
    public int m701ZfxDd() {
        this.f1041mjFkc.readLock().lock();
        try {
            return this.f1043wA;
        } finally {
            this.f1041mjFkc.readLock().unlock();
        }
    }

    /* renamed from: diqgf */
    public void m702diqgf(KLFTb kLFTb) {
        AbstractC2280K3.m9122lgHUyS(kLFTb, "initCallback cannot be null");
        this.f1041mjFkc.writeLock().lock();
        try {
            this.f1032AZxh.remove(kLFTb);
        } finally {
            this.f1041mjFkc.writeLock().unlock();
        }
    }

    /* renamed from: eyqo */
    public void m703eyqo(EditorInfo editorInfo) {
        if (!m694Dt() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f1036KLFTb.mo711wA(editorInfo);
    }

    /* renamed from: fehf */
    public CharSequence m704fehf(CharSequence charSequence, int i, int i2, int i3) {
        return m696IEE(charSequence, i, i2, i3, 0);
    }

    /* renamed from: qGY */
    public CharSequence m705qGY(CharSequence charSequence, int i, int i2) {
        return m704fehf(charSequence, i, i2, Integer.MAX_VALUE);
    }

    /* renamed from: qdMbNW */
    public boolean m706qdMbNW() {
        return this.f1033Dt;
    }

    /* renamed from: rkYL */
    public CharSequence m707rkYL(CharSequence charSequence) {
        return m705qGY(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    /* renamed from: wA */
    public int m708wA() {
        return this.f1034ETF;
    }
}
