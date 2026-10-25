package org.bouncycastle.p194crypto.p221util;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;

/* loaded from: classes2.dex */
public class ScryptConfig extends PBKDFConfig {
    private final int blockSize;
    private final int costParameter;
    private final int parallelizationParameter;
    private final int saltLength;

    /* renamed from: org.bouncycastle.crypto.util.ScryptConfig$Builder */
    public static class C5430Builder {
        private final int blockSize;
        private final int costParameter;
        private final int parallelizationParameter;
        private int saltLength = 16;

        public C5430Builder(int i, int i2, int i3) {
            if (i <= 1 || !isPowerOf2(i)) {
                throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
            }
            this.costParameter = i;
            this.blockSize = i2;
            this.parallelizationParameter = i3;
        }

        private static boolean isPowerOf2(int i) {
            return (i & (i + (-1))) == 0;
        }

        /* renamed from: build */
        public ScryptConfig m15934build() {
            return new ScryptConfig(this);
        }

        public C5430Builder withSaltLength(int i) {
            this.saltLength = i;
            return this;
        }
    }

    private ScryptConfig(C5430Builder c5430Builder) {
        super(MiscObjectIdentifiers.id_scrypt);
        this.costParameter = c5430Builder.costParameter;
        this.blockSize = c5430Builder.blockSize;
        this.parallelizationParameter = c5430Builder.parallelizationParameter;
        this.saltLength = c5430Builder.saltLength;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCostParameter() {
        return this.costParameter;
    }

    public int getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
