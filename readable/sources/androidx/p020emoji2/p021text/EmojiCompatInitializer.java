package androidx.p020emoji2.p021text;

import android.content.Context;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.p020emoji2.p021text.C0084wA;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import p131o.AbstractC2162IPpyV;
import p131o.AbstractC2352L8;
import p131o.C2825SOS;
import p131o.InterfaceC2343L;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC4543sMIIyd;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC2343L {

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$AZxh */
    public static class C0077AZxh implements C0084wA.xJ {

        /* renamed from: mjFkc */
        public final Context f994mjFkc;

        /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$AZxh$mjFkc */
        public class mjFkc extends C0084wA.lgHUyS {

            /* renamed from: AZxh */
            public final /* synthetic */ ThreadPoolExecutor f995AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ C0084wA.lgHUyS f996mjFkc;

            public mjFkc(C0084wA.lgHUyS lghuys, ThreadPoolExecutor threadPoolExecutor) {
                this.f996mjFkc = lghuys;
                this.f995AZxh = threadPoolExecutor;
            }

            @Override // androidx.p020emoji2.p021text.C0084wA.lgHUyS
            /* renamed from: AZxh */
            public void mo636AZxh(C0080JHa c0080JHa) {
                try {
                    this.f996mjFkc.mo636AZxh(c0080JHa);
                } finally {
                    this.f995AZxh.shutdown();
                }
            }

            @Override // androidx.p020emoji2.p021text.C0084wA.lgHUyS
            /* renamed from: mjFkc */
            public void mo637mjFkc(Throwable th) {
                try {
                    this.f996mjFkc.mo637mjFkc(th);
                } finally {
                    this.f995AZxh.shutdown();
                }
            }
        }

        public C0077AZxh(Context context) {
            this.f994mjFkc = context.getApplicationContext();
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.xJ
        /* renamed from: mjFkc */
        public void mo634mjFkc(final C0084wA.lgHUyS lghuys) {
            final ThreadPoolExecutor threadPoolExecutorM8723AZxh = AbstractC2162IPpyV.m8723AZxh("EmojiCompatInitializer");
            threadPoolExecutorM8723AZxh.execute(new Runnable() { // from class: o.gb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13738mjFkc.m633ZfxDd(lghuys, threadPoolExecutorM8723AZxh);
                }
            });
        }

        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public void m633ZfxDd(C0084wA.lgHUyS lghuys, ThreadPoolExecutor threadPoolExecutor) {
            try {
                C0081KLFTb c0081KLFTbM676mjFkc = AbstractC0083mjFkc.m676mjFkc(this.f994mjFkc);
                if (c0081KLFTbM676mjFkc == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                c0081KLFTbM676mjFkc.m649wA(threadPoolExecutor);
                c0081KLFTbM676mjFkc.m717mjFkc().mo634mjFkc(new mjFkc(lghuys, threadPoolExecutor));
            } catch (Throwable th) {
                lghuys.mo637mjFkc(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$mjFkc */
    public static class C0078mjFkc extends C0084wA.wA {
        public C0078mjFkc(Context context) {
            super(new C0077AZxh(context));
            m716AZxh(1);
        }
    }

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$wA */
    public static class RunnableC0079wA implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractC2352L8.m9358mjFkc("EmojiCompat.EmojiCompatInitializer.run");
                if (C0084wA.m691lgHUyS()) {
                    C0084wA.m688AZxh().m695ETF();
                }
            } finally {
                AbstractC2352L8.m9357AZxh();
            }
        }
    }

    /* renamed from: KLFTb */
    public void m627KLFTb() {
        AbstractC2162IPpyV.m8724ZfxDd().postDelayed(new RunnableC0079wA(), 500L);
    }

    /* renamed from: ZfxDd */
    public void m628ZfxDd(Context context) {
        final AbstractC0112wA abstractC0112wAMo770JHa = ((InterfaceC3068W0) C2825SOS.m10142KLFTb(context).m10144JHa(ProcessLifecycleInitializer.class)).mo770JHa();
        abstractC0112wAMo770JHa.mo1044mjFkc(new InterfaceC4543sMIIyd() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // p131o.InterfaceC4543sMIIyd
            /* renamed from: lgHUyS */
            public void mo631lgHUyS(InterfaceC3068W0 interfaceC3068W0) {
                EmojiCompatInitializer.this.m627KLFTb();
                abstractC0112wAMo770JHa.mo1046wA(this);
            }
        });
    }

    @Override // p131o.InterfaceC2343L
    /* renamed from: mjFkc */
    public List mo629mjFkc() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p131o.InterfaceC2343L
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public Boolean mo626AZxh(Context context) {
        C0084wA.m693xJ(new C0078mjFkc(context));
        m628ZfxDd(context);
        return Boolean.TRUE;
    }
}
