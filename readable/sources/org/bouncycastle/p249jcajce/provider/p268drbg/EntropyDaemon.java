package org.bouncycastle.p249jcajce.provider.p268drbg;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
class EntropyDaemon implements Runnable {

    /* renamed from: LOG */
    private static final Logger f21707LOG = Logger.getLogger(EntropyDaemon.class.getName());

    /* renamed from: tasks */
    private final LinkedList<Runnable> f21708tasks = new LinkedList<>();

    /* renamed from: addTask */
    public void m16147addTask(Runnable runnable) {
        synchronized (this.f21708tasks) {
            this.f21708tasks.add(runnable);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        Runnable runnablePoll;
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (this.f21708tasks) {
                runnablePoll = this.f21708tasks.poll();
            }
            if (runnablePoll != null) {
                try {
                    runnablePoll.run();
                } catch (Throwable unused) {
                }
            } else {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        Logger logger = f21707LOG;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("entropy thread interrupted - exiting");
        }
    }
}
