package androidx.p020emoji2.p021text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.p020emoji2.p021text.C0084wA;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import p131o.AbstractC2162IPpyV;
import p131o.AbstractC2280K3;
import p131o.AbstractC2352L8;
import p131o.AbstractC2927Tz;
import p131o.AbstractC4327p9;
import p131o.C3395avDfWJ;

/* renamed from: androidx.emoji2.text.KLFTb */
/* loaded from: classes.dex */
public class C0081KLFTb extends C0084wA.wA {

    /* renamed from: Dt */
    public static final mjFkc f1004Dt = new mjFkc();

    /* renamed from: androidx.emoji2.text.KLFTb$AZxh */
    public static class AZxh implements C0084wA.xJ {

        /* renamed from: AZxh */
        public final C3395avDfWJ f1005AZxh;

        /* renamed from: Dt */
        public Runnable f1006Dt;

        /* renamed from: JHa */
        public Executor f1007JHa;

        /* renamed from: KLFTb */
        public Handler f1008KLFTb;

        /* renamed from: ZfxDd */
        public final Object f1009ZfxDd = new Object();

        /* renamed from: lgHUyS */
        public C0084wA.lgHUyS f1010lgHUyS;

        /* renamed from: mjFkc */
        public final Context f1011mjFkc;

        /* renamed from: qdMbNW */
        public ContentObserver f1012qdMbNW;

        /* renamed from: wA */
        public final mjFkc f1013wA;

        /* renamed from: xJ */
        public ThreadPoolExecutor f1014xJ;

        public AZxh(Context context, C3395avDfWJ c3395avDfWJ, mjFkc mjfkc) {
            AbstractC2280K3.m9122lgHUyS(context, "Context cannot be null");
            AbstractC2280K3.m9122lgHUyS(c3395avDfWJ, "FontRequest cannot be null");
            this.f1011mjFkc = context.getApplicationContext();
            this.f1005AZxh = c3395avDfWJ;
            this.f1013wA = mjfkc;
        }

        /* renamed from: AZxh */
        public final void m650AZxh() {
            synchronized (this.f1009ZfxDd) {
                try {
                    this.f1010lgHUyS = null;
                    ContentObserver contentObserver = this.f1012qdMbNW;
                    if (contentObserver != null) {
                        this.f1013wA.m657wA(this.f1011mjFkc, contentObserver);
                        this.f1012qdMbNW = null;
                    }
                    Handler handler = this.f1008KLFTb;
                    if (handler != null) {
                        handler.removeCallbacks(this.f1006Dt);
                    }
                    this.f1008KLFTb = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f1014xJ;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f1007JHa = null;
                    this.f1014xJ = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: JHa */
        public void m651JHa(Executor executor) {
            synchronized (this.f1009ZfxDd) {
                this.f1007JHa = executor;
            }
        }

        /* renamed from: KLFTb */
        public final AbstractC2927Tz.AZxh m652KLFTb() {
            try {
                AbstractC2927Tz.mjFkc mjfkcM655AZxh = this.f1013wA.m655AZxh(this.f1011mjFkc, this.f1005AZxh);
                if (mjfkcM655AZxh.m10461wA() == 0) {
                    AbstractC2927Tz.AZxh[] aZxhArrM10460AZxh = mjfkcM655AZxh.m10460AZxh();
                    if (aZxhArrM10460AZxh == null || aZxhArrM10460AZxh.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return aZxhArrM10460AZxh[0];
                }
                throw new RuntimeException("fetchFonts failed (" + mjfkcM655AZxh.m10461wA() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        /* renamed from: ZfxDd */
        public void m653ZfxDd() {
            synchronized (this.f1009ZfxDd) {
                try {
                    if (this.f1010lgHUyS == null) {
                        return;
                    }
                    if (this.f1007JHa == null) {
                        ThreadPoolExecutor threadPoolExecutorM8723AZxh = AbstractC2162IPpyV.m8723AZxh("emojiCompat");
                        this.f1014xJ = threadPoolExecutorM8723AZxh;
                        this.f1007JHa = threadPoolExecutorM8723AZxh;
                    }
                    this.f1007JHa.execute(new Runnable() { // from class: o.WjcLD
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11488mjFkc.m654wA();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.xJ
        /* renamed from: mjFkc */
        public void mo634mjFkc(C0084wA.lgHUyS lghuys) {
            AbstractC2280K3.m9122lgHUyS(lghuys, "LoaderCallback cannot be null");
            synchronized (this.f1009ZfxDd) {
                this.f1010lgHUyS = lghuys;
            }
            m653ZfxDd();
        }

        /* renamed from: wA */
        public void m654wA() {
            synchronized (this.f1009ZfxDd) {
                try {
                    if (this.f1010lgHUyS == null) {
                        return;
                    }
                    try {
                        AbstractC2927Tz.AZxh aZxhM652KLFTb = m652KLFTb();
                        int iM10454AZxh = aZxhM652KLFTb.m10454AZxh();
                        if (iM10454AZxh == 2) {
                            synchronized (this.f1009ZfxDd) {
                            }
                        }
                        if (iM10454AZxh != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iM10454AZxh + ")");
                        }
                        try {
                            AbstractC2352L8.m9358mjFkc("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceM656mjFkc = this.f1013wA.m656mjFkc(this.f1011mjFkc, aZxhM652KLFTb);
                            ByteBuffer byteBufferM13069mjFkc = AbstractC4327p9.m13069mjFkc(this.f1011mjFkc, null, aZxhM652KLFTb.m10457ZfxDd());
                            if (byteBufferM13069mjFkc == null || typefaceM656mjFkc == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            C0080JHa c0080JHaM638AZxh = C0080JHa.m638AZxh(typefaceM656mjFkc, byteBufferM13069mjFkc);
                            AbstractC2352L8.m9357AZxh();
                            synchronized (this.f1009ZfxDd) {
                                try {
                                    C0084wA.lgHUyS lghuys = this.f1010lgHUyS;
                                    if (lghuys != null) {
                                        lghuys.mo636AZxh(c0080JHaM638AZxh);
                                    }
                                } finally {
                                }
                            }
                            m650AZxh();
                        } catch (Throwable th) {
                            AbstractC2352L8.m9357AZxh();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f1009ZfxDd) {
                            try {
                                C0084wA.lgHUyS lghuys2 = this.f1010lgHUyS;
                                if (lghuys2 != null) {
                                    lghuys2.mo637mjFkc(th2);
                                }
                                m650AZxh();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: androidx.emoji2.text.KLFTb$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public AbstractC2927Tz.mjFkc m655AZxh(Context context, C3395avDfWJ c3395avDfWJ) {
            return AbstractC2927Tz.m10450AZxh(context, null, c3395avDfWJ);
        }

        /* renamed from: mjFkc */
        public Typeface m656mjFkc(Context context, AbstractC2927Tz.AZxh aZxh) {
            return AbstractC2927Tz.m10451mjFkc(context, null, new AbstractC2927Tz.AZxh[]{aZxh});
        }

        /* renamed from: wA */
        public void m657wA(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public C0081KLFTb(Context context, C3395avDfWJ c3395avDfWJ) {
        super(new AZxh(context, c3395avDfWJ, f1004Dt));
    }

    /* renamed from: wA */
    public C0081KLFTb m649wA(Executor executor) {
        ((AZxh) m717mjFkc()).m651JHa(executor);
        return this;
    }
}
