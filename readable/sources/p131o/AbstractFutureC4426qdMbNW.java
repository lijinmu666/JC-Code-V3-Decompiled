package p131o;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: o.qdMbNW */
/* loaded from: classes.dex */
public abstract class AbstractFutureC4426qdMbNW implements Future {

    /* renamed from: JHa */
    public static final AZxh f16196JHa;

    /* renamed from: xJ */
    public static final Object f16199xJ;

    /* renamed from: AZxh */
    public volatile KLFTb f16200AZxh;

    /* renamed from: mjFkc */
    public volatile Object f16201mjFkc;

    /* renamed from: wA */
    public volatile lgHUyS f16202wA;

    /* renamed from: ZfxDd */
    public static final boolean f16198ZfxDd = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: KLFTb */
    public static final Logger f16197KLFTb = Logger.getLogger(AbstractFutureC4426qdMbNW.class.getName());

    /* renamed from: o.qdMbNW$AZxh */
    public static abstract class AZxh {
        public AZxh() {
        }

        /* renamed from: AZxh */
        public abstract boolean mo13287AZxh(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, Object obj, Object obj2);

        /* renamed from: KLFTb */
        public abstract void mo13288KLFTb(lgHUyS lghuys, Thread thread);

        /* renamed from: ZfxDd */
        public abstract void mo13289ZfxDd(lgHUyS lghuys, lgHUyS lghuys2);

        /* renamed from: mjFkc */
        public abstract boolean mo13290mjFkc(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, KLFTb kLFTb, KLFTb kLFTb2);

        /* renamed from: wA */
        public abstract boolean mo13291wA(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, lgHUyS lghuys, lgHUyS lghuys2);
    }

    /* renamed from: o.qdMbNW$JHa */
    public static final class JHa extends AZxh {

        /* renamed from: AZxh */
        public final AtomicReferenceFieldUpdater f16203AZxh;

        /* renamed from: KLFTb */
        public final AtomicReferenceFieldUpdater f16204KLFTb;

        /* renamed from: ZfxDd */
        public final AtomicReferenceFieldUpdater f16205ZfxDd;

        /* renamed from: mjFkc */
        public final AtomicReferenceFieldUpdater f16206mjFkc;

        /* renamed from: wA */
        public final AtomicReferenceFieldUpdater f16207wA;

        public JHa(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f16206mjFkc = atomicReferenceFieldUpdater;
            this.f16203AZxh = atomicReferenceFieldUpdater2;
            this.f16207wA = atomicReferenceFieldUpdater3;
            this.f16205ZfxDd = atomicReferenceFieldUpdater4;
            this.f16204KLFTb = atomicReferenceFieldUpdater5;
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: AZxh */
        public boolean mo13287AZxh(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, Object obj, Object obj2) {
            return AbstractC1852Dt.m8064mjFkc(this.f16204KLFTb, abstractFutureC4426qdMbNW, obj, obj2);
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: KLFTb */
        public void mo13288KLFTb(lgHUyS lghuys, Thread thread) {
            this.f16206mjFkc.lazySet(lghuys, thread);
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: ZfxDd */
        public void mo13289ZfxDd(lgHUyS lghuys, lgHUyS lghuys2) {
            this.f16203AZxh.lazySet(lghuys, lghuys2);
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: mjFkc */
        public boolean mo13290mjFkc(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, KLFTb kLFTb, KLFTb kLFTb2) {
            return AbstractC1852Dt.m8064mjFkc(this.f16205ZfxDd, abstractFutureC4426qdMbNW, kLFTb, kLFTb2);
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: wA */
        public boolean mo13291wA(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, lgHUyS lghuys, lgHUyS lghuys2) {
            return AbstractC1852Dt.m8064mjFkc(this.f16207wA, abstractFutureC4426qdMbNW, lghuys, lghuys2);
        }
    }

    /* renamed from: o.qdMbNW$KLFTb */
    public static final class KLFTb {

        /* renamed from: ZfxDd */
        public static final KLFTb f16208ZfxDd = new KLFTb(null, null);

        /* renamed from: AZxh */
        public final Executor f16209AZxh;

        /* renamed from: mjFkc */
        public final Runnable f16210mjFkc;

        /* renamed from: wA */
        public KLFTb f16211wA;

        public KLFTb(Runnable runnable, Executor executor) {
            this.f16210mjFkc = runnable;
            this.f16209AZxh = executor;
        }
    }

    /* renamed from: o.qdMbNW$ZfxDd */
    public static final class ZfxDd {

        /* renamed from: mjFkc */
        public final Throwable f16212mjFkc;
    }

    /* renamed from: o.qdMbNW$lgHUyS */
    public static final class lgHUyS {

        /* renamed from: wA */
        public static final lgHUyS f16213wA = new lgHUyS(false);

        /* renamed from: AZxh */
        public volatile lgHUyS f16214AZxh;

        /* renamed from: mjFkc */
        public volatile Thread f16215mjFkc;

        public lgHUyS(boolean z) {
        }

        /* renamed from: AZxh */
        public void m13292AZxh() {
            Thread thread = this.f16215mjFkc;
            if (thread != null) {
                this.f16215mjFkc = null;
                LockSupport.unpark(thread);
            }
        }

        /* renamed from: mjFkc */
        public void m13293mjFkc(lgHUyS lghuys) {
            AbstractFutureC4426qdMbNW.f16196JHa.mo13289ZfxDd(this, lghuys);
        }

        public lgHUyS() {
            AbstractFutureC4426qdMbNW.f16196JHa.mo13288KLFTb(this, Thread.currentThread());
        }
    }

    /* renamed from: o.qdMbNW$wA */
    public static final class wA {

        /* renamed from: ZfxDd */
        public static final wA f16216ZfxDd;

        /* renamed from: wA */
        public static final wA f16217wA;

        /* renamed from: AZxh */
        public final Throwable f16218AZxh;

        /* renamed from: mjFkc */
        public final boolean f16219mjFkc;

        static {
            if (AbstractFutureC4426qdMbNW.f16198ZfxDd) {
                f16216ZfxDd = null;
                f16217wA = null;
            } else {
                f16216ZfxDd = new wA(false, null);
                f16217wA = new wA(true, null);
            }
        }

        public wA(boolean z, Throwable th) {
            this.f16219mjFkc = z;
            this.f16218AZxh = th;
        }
    }

    /* renamed from: o.qdMbNW$xJ */
    public static final class xJ extends AZxh {
        public xJ() {
            super();
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: AZxh */
        public boolean mo13287AZxh(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, Object obj, Object obj2) {
            synchronized (abstractFutureC4426qdMbNW) {
                try {
                    if (abstractFutureC4426qdMbNW.f16201mjFkc != obj) {
                        return false;
                    }
                    abstractFutureC4426qdMbNW.f16201mjFkc = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: KLFTb */
        public void mo13288KLFTb(lgHUyS lghuys, Thread thread) {
            lghuys.f16215mjFkc = thread;
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: ZfxDd */
        public void mo13289ZfxDd(lgHUyS lghuys, lgHUyS lghuys2) {
            lghuys.f16214AZxh = lghuys2;
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: mjFkc */
        public boolean mo13290mjFkc(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, KLFTb kLFTb, KLFTb kLFTb2) {
            synchronized (abstractFutureC4426qdMbNW) {
                try {
                    if (abstractFutureC4426qdMbNW.f16200AZxh != kLFTb) {
                        return false;
                    }
                    abstractFutureC4426qdMbNW.f16200AZxh = kLFTb2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // p131o.AbstractFutureC4426qdMbNW.AZxh
        /* renamed from: wA */
        public boolean mo13291wA(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW, lgHUyS lghuys, lgHUyS lghuys2) {
            synchronized (abstractFutureC4426qdMbNW) {
                try {
                    if (abstractFutureC4426qdMbNW.f16202wA != lghuys) {
                        return false;
                    }
                    abstractFutureC4426qdMbNW.f16202wA = lghuys2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static {
        AZxh xJVar;
        try {
            xJVar = new JHa(AtomicReferenceFieldUpdater.newUpdater(lgHUyS.class, Thread.class, "mjFkc"), AtomicReferenceFieldUpdater.newUpdater(lgHUyS.class, lgHUyS.class, "AZxh"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC4426qdMbNW.class, lgHUyS.class, "wA"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC4426qdMbNW.class, KLFTb.class, "AZxh"), AtomicReferenceFieldUpdater.newUpdater(AbstractFutureC4426qdMbNW.class, Object.class, "mjFkc"));
            th = null;
        } catch (Throwable th) {
            th = th;
            xJVar = new xJ();
        }
        f16196JHa = xJVar;
        if (th != null) {
            f16197KLFTb.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f16199xJ = new Object();
    }

    /* renamed from: JHa */
    public static void m13274JHa(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            f16197KLFTb.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* renamed from: KLFTb */
    public static void m13275KLFTb(AbstractFutureC4426qdMbNW abstractFutureC4426qdMbNW) {
        abstractFutureC4426qdMbNW.m13280ETF();
        abstractFutureC4426qdMbNW.m13278AZxh();
        KLFTb kLFTbM13283ZfxDd = abstractFutureC4426qdMbNW.m13283ZfxDd(null);
        while (kLFTbM13283ZfxDd != null) {
            KLFTb kLFTb = kLFTbM13283ZfxDd.f16211wA;
            m13274JHa(kLFTbM13283ZfxDd.f16210mjFkc, kLFTbM13283ZfxDd.f16209AZxh);
            kLFTbM13283ZfxDd = kLFTb;
        }
    }

    /* renamed from: lgHUyS */
    public static Object m13276lgHUyS(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    /* renamed from: wA */
    public static CancellationException m13277wA(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* renamed from: AZxh */
    public void m13278AZxh() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Dt */
    public String m13279Dt() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* renamed from: ETF */
    public final void m13280ETF() {
        lgHUyS lghuys;
        do {
            lghuys = this.f16202wA;
        } while (!f16196JHa.mo13291wA(this, lghuys, lgHUyS.f16213wA));
        while (lghuys != null) {
            lghuys.m13292AZxh();
            lghuys = lghuys.f16214AZxh;
        }
    }

    /* renamed from: MiMN */
    public boolean mo12933MiMN(Object obj) {
        if (obj == null) {
            obj = f16199xJ;
        }
        if (!f16196JHa.mo13287AZxh(this, null, obj)) {
            return false;
        }
        m13275KLFTb(this);
        return true;
    }

    /* renamed from: VA */
    public final void m13281VA(lgHUyS lghuys) {
        lghuys.f16215mjFkc = null;
        while (true) {
            lgHUyS lghuys2 = this.f16202wA;
            if (lghuys2 == lgHUyS.f16213wA) {
                return;
            }
            lgHUyS lghuys3 = null;
            while (lghuys2 != null) {
                lgHUyS lghuys4 = lghuys2.f16214AZxh;
                if (lghuys2.f16215mjFkc != null) {
                    lghuys3 = lghuys2;
                } else if (lghuys3 != null) {
                    lghuys3.f16214AZxh = lghuys4;
                    if (lghuys3.f16215mjFkc == null) {
                        break;
                    }
                } else if (!f16196JHa.mo13291wA(this, lghuys2, lghuys4)) {
                    break;
                }
                lghuys2 = lghuys4;
            }
            return;
        }
    }

    /* renamed from: YoKzxo */
    public final String m13282YoKzxo(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    /* renamed from: ZfxDd */
    public final KLFTb m13283ZfxDd(KLFTb kLFTb) {
        KLFTb kLFTb2;
        do {
            kLFTb2 = this.f16200AZxh;
        } while (!f16196JHa.mo13290mjFkc(this, kLFTb2, KLFTb.f16208ZfxDd));
        while (true) {
            KLFTb kLFTb3 = kLFTb;
            kLFTb = kLFTb2;
            if (kLFTb == null) {
                return kLFTb3;
            }
            kLFTb2 = kLFTb.f16211wA;
            kLFTb.f16211wA = kLFTb3;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f16201mjFkc;
        if (obj == null) {
            if (f16196JHa.mo13287AZxh(this, obj, f16198ZfxDd ? new wA(z, new CancellationException("Future.cancel() was called.")) : z ? wA.f16217wA : wA.f16216ZfxDd)) {
                if (z) {
                    m13285qdMbNW();
                }
                m13275KLFTb(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f16201mjFkc;
        if (obj != null) {
            return m13286xJ(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            lgHUyS lghuys = this.f16202wA;
            if (lghuys != lgHUyS.f16213wA) {
                lgHUyS lghuys2 = new lgHUyS();
                do {
                    lghuys2.m13293mjFkc(lghuys);
                    if (f16196JHa.mo13291wA(this, lghuys, lghuys2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                m13281VA(lghuys2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f16201mjFkc;
                            if (obj2 != null) {
                                return m13286xJ(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m13281VA(lghuys2);
                    } else {
                        lghuys = this.f16202wA;
                    }
                } while (lghuys != lgHUyS.f16213wA);
            }
            return m13286xJ(this.f16201mjFkc);
        }
        while (nanos > 0) {
            Object obj3 = this.f16201mjFkc;
            if (obj3 != null) {
                return m13286xJ(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f16201mjFkc instanceof wA;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f16201mjFkc != null;
    }

    /* renamed from: mjFkc */
    public final void m13284mjFkc(StringBuilder sb) {
        try {
            Object objM13276lgHUyS = m13276lgHUyS(this);
            sb.append("SUCCESS, result=[");
            sb.append(m13282YoKzxo(objM13276lgHUyS));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    /* renamed from: qdMbNW */
    public void m13285qdMbNW() {
    }

    public String toString() {
        String strM13279Dt;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m13284mjFkc(sb);
        } else {
            try {
                strM13279Dt = m13279Dt();
            } catch (RuntimeException e) {
                strM13279Dt = "Exception thrown from implementation: " + e.getClass();
            }
            if (strM13279Dt != null && !strM13279Dt.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strM13279Dt);
                sb.append("]");
            } else if (isDone()) {
                m13284mjFkc(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: xJ */
    public final Object m13286xJ(Object obj) throws ExecutionException {
        if (obj instanceof wA) {
            throw m13277wA("Task was cancelled.", ((wA) obj).f16218AZxh);
        }
        if (obj instanceof ZfxDd) {
            throw new ExecutionException(((ZfxDd) obj).f16212mjFkc);
        }
        if (obj == f16199xJ) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f16201mjFkc;
            if (obj2 != null) {
                return m13286xJ(obj2);
            }
            lgHUyS lghuys = this.f16202wA;
            if (lghuys != lgHUyS.f16213wA) {
                lgHUyS lghuys2 = new lgHUyS();
                do {
                    lghuys2.m13293mjFkc(lghuys);
                    if (f16196JHa.mo13291wA(this, lghuys, lghuys2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f16201mjFkc;
                            } else {
                                m13281VA(lghuys2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return m13286xJ(obj);
                    }
                    lghuys = this.f16202wA;
                } while (lghuys != lgHUyS.f16213wA);
            }
            return m13286xJ(this.f16201mjFkc);
        }
        throw new InterruptedException();
    }
}
