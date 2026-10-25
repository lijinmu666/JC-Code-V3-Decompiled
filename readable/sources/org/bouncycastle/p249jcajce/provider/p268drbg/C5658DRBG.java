package org.bouncycastle.p249jcajce.provider.p268drbg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p194crypto.p215prng.EntropySourceProvider;
import org.bouncycastle.p194crypto.p215prng.SP800SecureRandom;
import org.bouncycastle.p194crypto.p215prng.SP800SecureRandomBuilder;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.ClassUtil;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Properties;

/* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG */
/* loaded from: classes2.dex */
public class C5658DRBG {

    /* renamed from: PREFIX */
    private static final String f21690PREFIX = "org.bouncycastle.jcajce.provider.drbg.DRBG";
    private static final String[][] initialEntropySourceNames = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};
    private static final EntropyDaemon ENTROPY_DAEMON = new EntropyDaemon();
    private static Thread ENTROPY_THREAD = null;

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$CoreSecureRandom */
    public static class CoreSecureRandom extends SecureRandom {
        public CoreSecureRandom(Object[] objArr) {
            super((SecureRandomSpi) objArr[1], (Provider) objArr[0]);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$Default */
    public static class Default extends SecureRandomSpi {

        /* renamed from: random */
        private static final SecureRandom f21691random = C5658DRBG.createBaseRandom(true);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i) {
            return f21691random.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            f21691random.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            f21691random.setSeed(bArr);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$HybridEntropySource */
    public static class HybridEntropySource implements EntropySource {
        private final byte[] additionalInput;
        private final int bytesRequired;

        /* renamed from: drbg */
        private final SP800SecureRandom f21692drbg;
        private final SignallingEntropySource entropySource;

        /* renamed from: samples */
        private final AtomicInteger f21693samples;
        private final AtomicBoolean seedAvailable;

        /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$HybridEntropySource$SignallingEntropySource */
        public static class SignallingEntropySource implements IncrementalEntropySource {
            private final int byteLength;
            private final EntropyDaemon entropyDaemon;
            private final IncrementalEntropySource entropySource;
            private final AtomicBoolean seedAvailable;

            /* renamed from: entropy */
            private final AtomicReference f21695entropy = new AtomicReference();
            private final AtomicBoolean scheduled = new AtomicBoolean(false);

            public SignallingEntropySource(EntropyDaemon entropyDaemon, AtomicBoolean atomicBoolean, EntropySourceProvider entropySourceProvider, int i) {
                this.entropyDaemon = entropyDaemon;
                this.seedAvailable = atomicBoolean;
                this.entropySource = (IncrementalEntropySource) entropySourceProvider.mo15836get(i);
                this.byteLength = (i + 7) / 8;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public int entropySize() {
                return this.byteLength * 8;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public byte[] getEntropy() {
                try {
                    return getEntropy(0L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("initial entropy fetch interrupted");
                }
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public boolean isPredictionResistant() {
                return true;
            }

            public void schedule() {
                if (this.scheduled.getAndSet(true)) {
                    return;
                }
                this.entropyDaemon.m16147addTask(new EntropyGatherer(this.entropySource, this.seedAvailable, this.f21695entropy));
            }

            @Override // org.bouncycastle.p249jcajce.provider.p268drbg.IncrementalEntropySource
            public byte[] getEntropy(long j) {
                byte[] bArr = (byte[]) this.f21695entropy.getAndSet(null);
                if (bArr == null || bArr.length != this.byteLength) {
                    return this.entropySource.getEntropy(j);
                }
                this.scheduled.set(false);
                return bArr;
            }
        }

        public HybridEntropySource(EntropyDaemon entropyDaemon, int i) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.seedAvailable = atomicBoolean;
            this.f21693samples = new AtomicInteger(0);
            this.additionalInput = AbstractC6245Pack.longToBigEndian(System.currentTimeMillis());
            EntropySourceProvider entropySourceProviderCreateCoreEntropySourceProvider = C5658DRBG.createCoreEntropySourceProvider();
            this.bytesRequired = (i + 7) / 8;
            SignallingEntropySource signallingEntropySource = new SignallingEntropySource(entropyDaemon, atomicBoolean, entropySourceProviderCreateCoreEntropySourceProvider, C5658DRBG.get256BitsEffectiveEntropySize());
            this.entropySource = signallingEntropySource;
            this.f21692drbg = new SP800SecureRandomBuilder(new EntropySourceProvider() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.HybridEntropySource.1
                @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
                /* renamed from: get */
                public EntropySource mo15836get(int i2) {
                    return HybridEntropySource.this.entropySource;
                }
            }).setPersonalizationString(C6250Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new C5360HMac(new SHA512Digest()), signallingEntropySource.getEntropy(), false);
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public int entropySize() {
            return this.bytesRequired * 8;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public byte[] getEntropy() {
            byte[] bArr = new byte[this.bytesRequired];
            if (this.f21693samples.getAndIncrement() > 128) {
                if (this.seedAvailable.getAndSet(false)) {
                    this.f21693samples.set(0);
                    this.f21692drbg.m15838reseed(this.additionalInput);
                } else {
                    this.entropySource.schedule();
                }
            }
            this.f21692drbg.nextBytes(bArr);
            return bArr;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public boolean isPredictionResistant() {
            return true;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("SecureRandom.DEFAULT", C5658DRBG.f21690PREFIX + "$Default");
            configurableProvider.addAlgorithm("SecureRandom.NONCEANDIV", C5658DRBG.f21690PREFIX + "$NonceAndIV");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$NonceAndIV */
    public static class NonceAndIV extends SecureRandomSpi {

        /* renamed from: random */
        private static final SecureRandom f21696random = C5658DRBG.createBaseRandom(false);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i) {
            return f21696random.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            f21696random.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            f21696random.setSeed(bArr);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$OneShotHybridEntropySource */
    public static class OneShotHybridEntropySource implements EntropySource {
        private final byte[] additionalInput;
        private final int bytesRequired;

        /* renamed from: drbg */
        private final SP800SecureRandom f21697drbg;
        private final OneShotSignallingEntropySource entropySource;

        /* renamed from: samples */
        private final AtomicInteger f21698samples;
        private final AtomicBoolean seedAvailable;

        /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$OneShotHybridEntropySource$OneShotSignallingEntropySource */
        public static class OneShotSignallingEntropySource implements IncrementalEntropySource {
            private final int byteLength;
            private final IncrementalEntropySource entropySource;
            private final AtomicBoolean seedAvailable;

            /* renamed from: entropy */
            private final AtomicReference f21700entropy = new AtomicReference();
            private final AtomicBoolean scheduled = new AtomicBoolean(false);

            public OneShotSignallingEntropySource(AtomicBoolean atomicBoolean, EntropySourceProvider entropySourceProvider, int i) {
                this.seedAvailable = atomicBoolean;
                this.entropySource = (IncrementalEntropySource) entropySourceProvider.mo15836get(i);
                this.byteLength = (i + 7) / 8;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public int entropySize() {
                return this.byteLength * 8;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public byte[] getEntropy() {
                try {
                    return getEntropy(0L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("initial entropy fetch interrupted");
                }
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public boolean isPredictionResistant() {
                return true;
            }

            public void schedule() {
                if (this.scheduled.getAndSet(true)) {
                    return;
                }
                Thread thread = new Thread(new EntropyGatherer(this.entropySource, this.seedAvailable, this.f21700entropy));
                thread.setDaemon(true);
                thread.start();
            }

            @Override // org.bouncycastle.p249jcajce.provider.p268drbg.IncrementalEntropySource
            public byte[] getEntropy(long j) {
                byte[] bArr = (byte[]) this.f21700entropy.getAndSet(null);
                if (bArr == null || bArr.length != this.byteLength) {
                    return this.entropySource.getEntropy(j);
                }
                this.scheduled.set(false);
                return bArr;
            }
        }

        public OneShotHybridEntropySource(int i) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.seedAvailable = atomicBoolean;
            this.f21698samples = new AtomicInteger(0);
            this.additionalInput = AbstractC6245Pack.longToBigEndian(System.currentTimeMillis());
            EntropySourceProvider entropySourceProviderCreateCoreEntropySourceProvider = C5658DRBG.createCoreEntropySourceProvider();
            this.bytesRequired = (i + 7) / 8;
            OneShotSignallingEntropySource oneShotSignallingEntropySource = new OneShotSignallingEntropySource(atomicBoolean, entropySourceProviderCreateCoreEntropySourceProvider, C5658DRBG.get256BitsEffectiveEntropySize());
            this.entropySource = oneShotSignallingEntropySource;
            this.f21697drbg = new SP800SecureRandomBuilder(new EntropySourceProvider() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.OneShotHybridEntropySource.1
                @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
                /* renamed from: get */
                public EntropySource mo15836get(int i2) {
                    return OneShotHybridEntropySource.this.entropySource;
                }
            }).setPersonalizationString(C6250Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new C5360HMac(new SHA512Digest()), oneShotSignallingEntropySource.getEntropy(), false);
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public int entropySize() {
            return this.bytesRequired * 8;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public byte[] getEntropy() {
            byte[] bArr = new byte[this.bytesRequired];
            if (this.f21698samples.getAndIncrement() > 1024) {
                if (this.seedAvailable.getAndSet(false)) {
                    this.f21698samples.set(0);
                    this.f21697drbg.m15838reseed(this.additionalInput);
                } else {
                    this.entropySource.schedule();
                }
            }
            this.f21697drbg.nextBytes(bArr);
            return bArr;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
        public boolean isPredictionResistant() {
            return true;
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.drbg.DRBG$URLSeededEntropySourceProvider */
    public static class URLSeededEntropySourceProvider implements EntropySourceProvider {
        private final InputStream seedStream;

        public URLSeededEntropySourceProvider(final URL url) {
            this.seedStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>(this) { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.URLSeededEntropySourceProvider.1

                /* renamed from: this$0 */
                final /* synthetic */ URLSeededEntropySourceProvider f21701this$0;

                {
                    this.f21701this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public InputStream run() {
                    try {
                        return url.openStream();
                    } catch (IOException unused) {
                        throw new IllegalStateException("unable to open random source");
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int privilegedRead(final byte[] bArr, final int i, final int i2) {
            return ((Integer) AccessController.doPrivileged(new PrivilegedAction<Integer>(this) { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.URLSeededEntropySourceProvider.2

                /* renamed from: this$0 */
                final /* synthetic */ URLSeededEntropySourceProvider f21703this$0;

                {
                    this.f21703this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Integer run() {
                    try {
                        return Integer.valueOf(this.f21703this$0.seedStream.read(bArr, i, i2));
                    } catch (IOException unused) {
                        throw new InternalError("unable to read random source");
                    }
                }
            })).intValue();
        }

        @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
        /* renamed from: get */
        public EntropySource mo15836get(int i) {
            return new IncrementalEntropySource(this, i) { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.URLSeededEntropySourceProvider.3
                private final int numBytes;

                /* renamed from: this$0 */
                final /* synthetic */ URLSeededEntropySourceProvider f21706this$0;
                final /* synthetic */ int val$bitsRequired;

                {
                    this.val$bitsRequired = i;
                    this.f21706this$0 = this;
                    this.numBytes = (i + 7) / 8;
                }

                @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
                public int entropySize() {
                    return this.val$bitsRequired;
                }

                @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
                public byte[] getEntropy() {
                    try {
                        return getEntropy(0L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException("initial entropy fetch interrupted");
                    }
                }

                @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
                public boolean isPredictionResistant() {
                    return true;
                }

                @Override // org.bouncycastle.p249jcajce.provider.p268drbg.IncrementalEntropySource
                public byte[] getEntropy(long j) throws InterruptedException {
                    int i2 = this.numBytes;
                    byte[] bArr = new byte[i2];
                    int i3 = 0;
                    while (i3 != i2) {
                        int iPrivilegedRead = this.f21706this$0.privilegedRead(bArr, i3, i2 - i3);
                        if (iPrivilegedRead <= -1) {
                            break;
                        }
                        i3 += iPrivilegedRead;
                        C5658DRBG.m16146sleep(j);
                    }
                    if (i3 == i2) {
                        return bArr;
                    }
                    throw new InternalError("unable to fully read random source");
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom createBaseRandom(boolean z) {
        if (Properties.getPropertyValue("org.bouncycastle.drbg.entropysource") != null) {
            return createBaseRandom(z, 128, createEntropySource());
        }
        if (!Properties.isOverrideSet("org.bouncycastle.drbg.entropy_thread")) {
            return createBaseRandom(z, 256, new EntropySourceProvider() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.2
                @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
                /* renamed from: get */
                public EntropySource mo15836get(int i) {
                    return new OneShotHybridEntropySource(i);
                }
            });
        }
        initEntropyThread();
        return createBaseRandom(z, 256, new EntropySourceProvider() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.1
            @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
            /* renamed from: get */
            public EntropySource mo15836get(int i) {
                return new HybridEntropySource(C5658DRBG.ENTROPY_DAEMON, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EntropySourceProvider createCoreEntropySourceProvider() {
        SecureRandom secureRandom;
        if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                try {
                    return Boolean.valueOf(SecureRandom.class.getMethod("getInstanceStrong", null) != null);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
        })).booleanValue() && (secureRandom = (SecureRandom) AccessController.doPrivileged(new PrivilegedAction<SecureRandom>() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.4
            @Override // java.security.PrivilegedAction
            public SecureRandom run() {
                try {
                    return (SecureRandom) SecureRandom.class.getMethod("getInstanceStrong", null).invoke(null, null);
                } catch (Exception unused) {
                    return null;
                }
            }
        })) != null) {
            return new IncrementalEntropySourceProvider(secureRandom, true);
        }
        return createInitialEntropySource();
    }

    private static EntropySourceProvider createEntropySource() {
        final String propertyValue = Properties.getPropertyValue("org.bouncycastle.drbg.entropysource");
        return (EntropySourceProvider) AccessController.doPrivileged(new PrivilegedAction<EntropySourceProvider>() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.6
            @Override // java.security.PrivilegedAction
            public EntropySourceProvider run() {
                try {
                    return (EntropySourceProvider) ClassUtil.loadClass(C5658DRBG.class, propertyValue).newInstance();
                } catch (Exception e) {
                    throw new IllegalStateException("entropy source " + propertyValue + " not created: " + e.getMessage(), e);
                }
            }
        });
    }

    private static EntropySourceProvider createInitialEntropySource() {
        String str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.bouncycastle.jcajce.provider.drbg.DRBG.5
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty("securerandom.source");
            }
        });
        if (str == null) {
            return new IncrementalEntropySourceProvider(new CoreSecureRandom(findSource()), true);
        }
        try {
            return new URLSeededEntropySourceProvider(new URL(str));
        } catch (Exception unused) {
            return new IncrementalEntropySourceProvider(new CoreSecureRandom(findSource()), true);
        }
    }

    private static final Object[] findSource() {
        char c = 0;
        int i = 0;
        while (true) {
            String[][] strArr = initialEntropySourceNames;
            if (i >= strArr.length) {
                return null;
            }
            String[] strArr2 = strArr[i];
            try {
                return new Object[]{Class.forName(strArr2[c]).newInstance(), Class.forName(strArr2[1]).newInstance()};
            } catch (Throwable unused) {
                i++;
            }
        }
    }

    private static byte[] generateDefaultPersonalizationString(byte[] bArr) {
        return C6238Arrays.concatenate(C6250Strings.toByteArray("Default"), bArr, AbstractC6245Pack.longToBigEndian(Thread.currentThread().getId()), AbstractC6245Pack.longToBigEndian(System.currentTimeMillis()));
    }

    private static byte[] generateNonceIVPersonalizationString(byte[] bArr) {
        return C6238Arrays.concatenate(C6250Strings.toByteArray("Nonce"), bArr, AbstractC6245Pack.longToLittleEndian(Thread.currentThread().getId()), AbstractC6245Pack.longToLittleEndian(System.currentTimeMillis()));
    }

    private static byte[] generatePersonalizationString(boolean z, EntropySource entropySource) {
        byte[] entropy = entropySource.getEntropy();
        return z ? generateDefaultPersonalizationString(entropy) : generateNonceIVPersonalizationString(entropy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int get256BitsEffectiveEntropySize() {
        return ((Properties.asInteger("org.bouncycastle.drbg.effective_256bits_entropy", 282) + 7) / 8) * 8;
    }

    private static void initEntropyThread() {
        EntropyDaemon entropyDaemon = ENTROPY_DAEMON;
        synchronized (entropyDaemon) {
            try {
                if (ENTROPY_THREAD == null) {
                    Thread thread = new Thread(entropyDaemon, "BC Entropy Daemon");
                    ENTROPY_THREAD = thread;
                    thread.setDaemon(true);
                    ENTROPY_THREAD.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sleep */
    public static void m16146sleep(long j) throws InterruptedException {
        if (j != 0) {
            Thread.sleep(j);
        }
    }

    private static SecureRandom createBaseRandom(boolean z, int i, EntropySourceProvider entropySourceProvider) {
        EntropySource entropySourceMo15836get = entropySourceProvider.mo15836get(i);
        return new SP800SecureRandomBuilder(entropySourceProvider).setPersonalizationString(generatePersonalizationString(z, entropySourceMo15836get)).buildHash(new SHA512Digest(), entropySourceMo15836get.getEntropy(), z);
    }
}
