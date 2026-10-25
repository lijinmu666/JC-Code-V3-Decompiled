package org.bouncycastle.p194crypto.p199digests;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p201engines.ThreefishEngine;
import org.bouncycastle.p194crypto.p213params.SkeinParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public class SkeinEngine implements Memoable {
    private static final Hashtable INITIAL_STATES = new Hashtable();
    private static final int PARAM_TYPE_CONFIG = 4;
    private static final int PARAM_TYPE_KEY = 0;
    private static final int PARAM_TYPE_MESSAGE = 48;
    private static final int PARAM_TYPE_OUTPUT = 63;
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;

    /* renamed from: chain */
    long[] f19569chain;
    private long[] initialState;

    /* renamed from: key */
    private byte[] f19570key;
    private final int outputSizeBytes;
    private Parameter[] postMessageParameters;
    private Parameter[] preMessageParameters;
    private final byte[] singleByte;
    final ThreefishEngine threefish;

    /* renamed from: ubi */
    private final C5296UBI f19571ubi;

    public static class Configuration {

        /* renamed from: bytes */
        private byte[] f19572bytes;

        public Configuration(long j) {
            byte[] bArr = new byte[32];
            this.f19572bytes = bArr;
            bArr[0] = 83;
            bArr[1] = 72;
            bArr[2] = 65;
            bArr[3] = 51;
            bArr[4] = 1;
            bArr[5] = 0;
            AbstractC6245Pack.longToLittleEndian(j, bArr, 8);
        }

        public byte[] getBytes() {
            return this.f19572bytes;
        }
    }

    public static class Parameter {

        /* renamed from: type */
        private int f19573type;

        /* renamed from: value */
        private byte[] f19574value;

        public Parameter(int i, byte[] bArr) {
            this.f19573type = i;
            this.f19574value = bArr;
        }

        /* renamed from: getType */
        public int m15191getType() {
            return this.f19573type;
        }

        public byte[] getValue() {
            return this.f19574value;
        }
    }

    /* renamed from: org.bouncycastle.crypto.digests.SkeinEngine$UBI */
    public class C5296UBI {
        private byte[] currentBlock;
        private int currentOffset;

        /* renamed from: message */
        private long[] f19575message;

        /* renamed from: tweak */
        private final UbiTweak f19577tweak = new UbiTweak();

        public C5296UBI(int i) {
            byte[] bArr = new byte[i];
            this.currentBlock = bArr;
            this.f19575message = new long[bArr.length / 8];
        }

        private void processBlock(long[] jArr) {
            SkeinEngine skeinEngine = SkeinEngine.this;
            skeinEngine.threefish.m15436init(true, skeinEngine.f19569chain, this.f19577tweak.getWords());
            AbstractC6245Pack.littleEndianToLong(this.currentBlock, 0, this.f19575message);
            SkeinEngine.this.threefish.processBlock(this.f19575message, jArr);
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = jArr[i] ^ this.f19575message[i];
            }
        }

        /* renamed from: doFinal */
        public void m15192doFinal(long[] jArr) {
            int i = this.currentOffset;
            while (true) {
                byte[] bArr = this.currentBlock;
                if (i >= bArr.length) {
                    this.f19577tweak.setFinal(true);
                    processBlock(jArr);
                    return;
                } else {
                    bArr[i] = 0;
                    i++;
                }
            }
        }

        /* renamed from: reset */
        public void m15193reset(int i) {
            this.f19577tweak.m15199reset();
            this.f19577tweak.m15201setType(i);
            this.currentOffset = 0;
        }

        /* renamed from: update */
        public void m15195update(byte[] bArr, int i, int i2, long[] jArr) {
            int i3 = 0;
            while (i2 > i3) {
                if (this.currentOffset == this.currentBlock.length) {
                    processBlock(jArr);
                    this.f19577tweak.setFirst(false);
                    this.currentOffset = 0;
                }
                int iMin = Math.min(i2 - i3, this.currentBlock.length - this.currentOffset);
                System.arraycopy(bArr, i + i3, this.currentBlock, this.currentOffset, iMin);
                i3 += iMin;
                this.currentOffset += iMin;
                this.f19577tweak.advancePosition(iMin);
            }
        }

        /* renamed from: reset */
        public void m15194reset(C5296UBI c5296ubi) {
            this.currentBlock = C6238Arrays.m18232clone(c5296ubi.currentBlock, this.currentBlock);
            this.currentOffset = c5296ubi.currentOffset;
            this.f19575message = C6238Arrays.m18236clone(c5296ubi.f19575message, this.f19575message);
            this.f19577tweak.m15200reset(c5296ubi.f19577tweak);
        }
    }

    public static class UbiTweak {
        private static final long LOW_RANGE = 9223372034707292160L;
        private static final long T1_FINAL = Long.MIN_VALUE;
        private static final long T1_FIRST = 4611686018427387904L;
        private boolean extendedPosition;

        /* renamed from: tweak */
        private long[] f19578tweak = new long[2];

        public UbiTweak() {
            m15199reset();
        }

        public void advancePosition(int i) {
            if (!this.extendedPosition) {
                long[] jArr = this.f19578tweak;
                long j = jArr[0] + i;
                jArr[0] = j;
                if (j > LOW_RANGE) {
                    this.extendedPosition = true;
                    return;
                }
                return;
            }
            long[] jArr2 = new long[3];
            long[] jArr3 = this.f19578tweak;
            jArr2[0] = jArr3[0] & BodyPartID.bodyIdMax;
            jArr2[1] = (jArr3[0] >>> 32) & BodyPartID.bodyIdMax;
            jArr2[2] = jArr3[1] & BodyPartID.bodyIdMax;
            long j2 = i;
            for (int i2 = 0; i2 < 3; i2++) {
                long j3 = j2 + jArr2[i2];
                jArr2[i2] = j3;
                j2 = j3 >>> 32;
            }
            long[] jArr4 = this.f19578tweak;
            jArr4[0] = ((jArr2[1] & BodyPartID.bodyIdMax) << 32) | (jArr2[0] & BodyPartID.bodyIdMax);
            jArr4[1] = (jArr2[2] & BodyPartID.bodyIdMax) | (jArr4[1] & (-4294967296L));
        }

        /* renamed from: getType */
        public int m15196getType() {
            return (int) ((this.f19578tweak[1] >>> 56) & 63);
        }

        public long[] getWords() {
            return this.f19578tweak;
        }

        /* renamed from: isFinal */
        public boolean m15197isFinal() {
            return (this.f19578tweak[1] & Long.MIN_VALUE) != 0;
        }

        /* renamed from: isFirst */
        public boolean m15198isFirst() {
            return (this.f19578tweak[1] & T1_FIRST) != 0;
        }

        /* renamed from: reset */
        public void m15199reset() {
            long[] jArr = this.f19578tweak;
            jArr[0] = 0;
            jArr[1] = 0;
            this.extendedPosition = false;
            setFirst(true);
        }

        public void setFinal(boolean z) {
            long[] jArr = this.f19578tweak;
            if (z) {
                jArr[1] = jArr[1] | Long.MIN_VALUE;
            } else {
                jArr[1] = jArr[1] & LongCompanionObject.MAX_VALUE;
            }
        }

        public void setFirst(boolean z) {
            long[] jArr = this.f19578tweak;
            if (z) {
                jArr[1] = jArr[1] | T1_FIRST;
            } else {
                jArr[1] = jArr[1] & (-4611686018427387905L);
            }
        }

        /* renamed from: setType */
        public void m15201setType(int i) {
            long[] jArr = this.f19578tweak;
            jArr[1] = (jArr[1] & (-274877906944L)) | ((i & 63) << 56);
        }

        public String toString() {
            return m15196getType() + " first: " + m15198isFirst() + ", final: " + m15197isFinal();
        }

        /* renamed from: reset */
        public void m15200reset(UbiTweak ubiTweak) {
            this.f19578tweak = C6238Arrays.m18236clone(ubiTweak.f19578tweak, this.f19578tweak);
            this.extendedPosition = ubiTweak.extendedPosition;
        }
    }

    static {
        initialState(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        initialState(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        initialState(256, InterfaceC5102BERTags.f17976FLAGS, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        initialState(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        initialState(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        initialState(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        initialState(512, InterfaceC5102BERTags.f17976FLAGS, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        initialState(512, 384, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        initialState(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    public SkeinEngine(int i, int i2) {
        this.singleByte = new byte[1];
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("Output size must be a multiple of 8 bits. :" + i2);
        }
        this.outputSizeBytes = i2 / 8;
        ThreefishEngine threefishEngine = new ThreefishEngine(i);
        this.threefish = threefishEngine;
        this.f19571ubi = new C5296UBI(threefishEngine.getBlockSize());
    }

    private void checkInitialised() {
        if (this.f19571ubi == null) {
            throw new IllegalArgumentException("Skein engine is not initialised.");
        }
    }

    /* renamed from: clone */
    private static Parameter[] m15181clone(Parameter[] parameterArr, Parameter[] parameterArr2) {
        if (parameterArr == null) {
            return null;
        }
        if (parameterArr2 == null || parameterArr2.length != parameterArr.length) {
            parameterArr2 = new Parameter[parameterArr.length];
        }
        System.arraycopy(parameterArr, 0, parameterArr2, 0, parameterArr2.length);
        return parameterArr2;
    }

    /* renamed from: copyIn */
    private void m15182copyIn(SkeinEngine skeinEngine) {
        this.f19571ubi.m15194reset(skeinEngine.f19571ubi);
        this.f19569chain = C6238Arrays.m18236clone(skeinEngine.f19569chain, this.f19569chain);
        this.initialState = C6238Arrays.m18236clone(skeinEngine.initialState, this.initialState);
        this.f19570key = C6238Arrays.m18232clone(skeinEngine.f19570key, this.f19570key);
        this.preMessageParameters = m15181clone(skeinEngine.preMessageParameters, this.preMessageParameters);
        this.postMessageParameters = m15181clone(skeinEngine.postMessageParameters, this.postMessageParameters);
    }

    private void createInitialState() {
        long[] jArr = (long[]) INITIAL_STATES.get(variantIdentifier(getBlockSize(), getOutputSize()));
        int i = 0;
        if (this.f19570key != null || jArr == null) {
            this.f19569chain = new long[getBlockSize() / 8];
            byte[] bArr = this.f19570key;
            if (bArr != null) {
                ubiComplete(0, bArr);
            }
            ubiComplete(4, new Configuration(this.outputSizeBytes * 8).getBytes());
        } else {
            this.f19569chain = C6238Arrays.m18235clone(jArr);
        }
        if (this.preMessageParameters != null) {
            while (true) {
                Parameter[] parameterArr = this.preMessageParameters;
                if (i >= parameterArr.length) {
                    break;
                }
                Parameter parameter = parameterArr[i];
                ubiComplete(parameter.m15191getType(), parameter.getValue());
                i++;
            }
        }
        this.initialState = C6238Arrays.m18235clone(this.f19569chain);
    }

    private void initParams(Hashtable hashtable) {
        Enumeration enumerationKeys = hashtable.keys();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        while (enumerationKeys.hasMoreElements()) {
            Integer num = (Integer) enumerationKeys.nextElement();
            byte[] bArr = (byte[]) hashtable.get(num);
            if (num.intValue() == 0) {
                this.f19570key = bArr;
            } else if (num.intValue() < 48) {
                vector.addElement(new Parameter(num.intValue(), bArr));
            } else {
                vector2.addElement(new Parameter(num.intValue(), bArr));
            }
        }
        Parameter[] parameterArr = new Parameter[vector.size()];
        this.preMessageParameters = parameterArr;
        vector.copyInto(parameterArr);
        m15184sort(this.preMessageParameters);
        Parameter[] parameterArr2 = new Parameter[vector2.size()];
        this.postMessageParameters = parameterArr2;
        vector2.copyInto(parameterArr2);
        m15184sort(this.postMessageParameters);
    }

    private static void initialState(int i, int i2, long[] jArr) {
        INITIAL_STATES.put(variantIdentifier(i / 8, i2 / 8), jArr);
    }

    /* renamed from: output */
    private void m15183output(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[8];
        AbstractC6245Pack.longToLittleEndian(j, bArr2, 0);
        long[] jArr = new long[this.f19569chain.length];
        m15185ubiInit(63);
        this.f19571ubi.m15195update(bArr2, 0, 8, jArr);
        this.f19571ubi.m15192doFinal(jArr);
        int i3 = (i2 + 7) / 8;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 8;
            int iMin = Math.min(8, i2 - i5);
            if (iMin == 8) {
                AbstractC6245Pack.longToLittleEndian(jArr[i4], bArr, i5 + i);
            } else {
                AbstractC6245Pack.longToLittleEndian(jArr[i4], bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i5 + i, iMin);
            }
        }
    }

    /* renamed from: sort */
    private static void m15184sort(Parameter[] parameterArr) {
        if (parameterArr == null) {
            return;
        }
        for (int i = 1; i < parameterArr.length; i++) {
            Parameter parameter = parameterArr[i];
            int i2 = i;
            while (i2 > 0) {
                int i3 = i2 - 1;
                if (parameter.m15191getType() < parameterArr[i3].m15191getType()) {
                    parameterArr[i2] = parameterArr[i3];
                    i2 = i3;
                }
            }
            parameterArr[i2] = parameter;
        }
    }

    private void ubiComplete(int i, byte[] bArr) {
        m15185ubiInit(i);
        this.f19571ubi.m15195update(bArr, 0, bArr.length, this.f19569chain);
        ubiFinal();
    }

    private void ubiFinal() {
        this.f19571ubi.m15192doFinal(this.f19569chain);
    }

    /* renamed from: ubiInit */
    private void m15185ubiInit(int i) {
        this.f19571ubi.m15193reset(i);
    }

    private static Integer variantIdentifier(int i, int i2) {
        return Integers.m18296valueOf(i | (i2 << 16));
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SkeinEngine(this);
    }

    /* renamed from: doFinal */
    public int m15186doFinal(byte[] bArr, int i) {
        checkInitialised();
        if (bArr.length < this.outputSizeBytes + i) {
            throw new OutputLengthException("Output buffer is too short to hold output");
        }
        ubiFinal();
        if (this.postMessageParameters != null) {
            int i2 = 0;
            while (true) {
                Parameter[] parameterArr = this.postMessageParameters;
                if (i2 >= parameterArr.length) {
                    break;
                }
                Parameter parameter = parameterArr[i2];
                ubiComplete(parameter.m15191getType(), parameter.getValue());
                i2++;
            }
        }
        int blockSize = getBlockSize();
        int i3 = ((this.outputSizeBytes + blockSize) - 1) / blockSize;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * blockSize;
            m15183output(i4, bArr, i + i5, Math.min(blockSize, this.outputSizeBytes - i5));
        }
        m15188reset();
        return this.outputSizeBytes;
    }

    public int getBlockSize() {
        return this.threefish.getBlockSize();
    }

    public int getOutputSize() {
        return this.outputSizeBytes;
    }

    /* renamed from: init */
    public void m15187init(SkeinParameters skeinParameters) {
        this.f19569chain = null;
        this.f19570key = null;
        this.preMessageParameters = null;
        this.postMessageParameters = null;
        if (skeinParameters != null) {
            if (skeinParameters.m15827getKey().length < 16) {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
            initParams(skeinParameters.getParameters());
        }
        createInitialState();
        m15185ubiInit(48);
    }

    /* renamed from: reset */
    public void m15188reset() {
        long[] jArr = this.initialState;
        long[] jArr2 = this.f19569chain;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        m15185ubiInit(48);
    }

    /* renamed from: update */
    public void m15189update(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        m15190update(bArr, 0, 1);
    }

    public SkeinEngine(SkeinEngine skeinEngine) {
        this(skeinEngine.getBlockSize() * 8, skeinEngine.getOutputSize() * 8);
        m15182copyIn(skeinEngine);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        SkeinEngine skeinEngine = (SkeinEngine) memoable;
        if (getBlockSize() != skeinEngine.getBlockSize() || this.outputSizeBytes != skeinEngine.outputSizeBytes) {
            throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
        }
        m15182copyIn(skeinEngine);
    }

    /* renamed from: update */
    public void m15190update(byte[] bArr, int i, int i2) {
        checkInitialised();
        this.f19571ubi.m15195update(bArr, i, i2, this.f19569chain);
    }
}
