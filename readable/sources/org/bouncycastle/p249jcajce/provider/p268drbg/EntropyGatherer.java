package org.bouncycastle.p249jcajce.provider.p268drbg;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
class EntropyGatherer implements Runnable {

    /* renamed from: LOG */
    private static final Logger f21709LOG = Logger.getLogger(EntropyGatherer.class.getName());
    private final IncrementalEntropySource baseRandom;

    /* renamed from: entropy */
    private final AtomicReference<byte[]> f21710entropy;

    /* renamed from: pause */
    private final long f21711pause = getPause();
    private final AtomicBoolean seedAvailable;

    public EntropyGatherer(IncrementalEntropySource incrementalEntropySource, AtomicBoolean atomicBoolean, AtomicReference<byte[]> atomicReference) {
        this.baseRandom = incrementalEntropySource;
        this.seedAvailable = atomicBoolean;
        this.f21710entropy = atomicReference;
    }

    private static long getPause() {
        String propertyValue = Properties.getPropertyValue("org.bouncycastle.drbg.gather_pause_secs");
        if (propertyValue != null) {
            try {
                return Long.parseLong(propertyValue) * 1000;
            } catch (Exception unused) {
            }
        }
        return 5000L;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f21710entropy.set(this.baseRandom.getEntropy(this.f21711pause));
            this.seedAvailable.set(true);
        } catch (InterruptedException unused) {
            Logger logger = f21709LOG;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("entropy request interrupted - exiting");
            }
            Thread.currentThread().interrupt();
        }
    }
}
