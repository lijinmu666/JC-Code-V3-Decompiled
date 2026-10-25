package org.bouncycastle.p194crypto.p201engines;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p210modes.AEADCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
abstract class AEADBaseEngine implements AEADCipher {
    protected int AADBufferSize;
    protected int BlockSize;

    /* renamed from: IV_SIZE */
    protected int f19650IV_SIZE;
    protected int KEY_SIZE;
    protected int MAC_SIZE;
    protected AADOperator aadOperator;
    protected String algorithmName;
    protected DataOperator dataOperator;
    protected boolean forEncryption;
    protected byte[] initialAssociatedText;

    /* renamed from: m_aad */
    protected byte[] f19651m_aad;
    protected int m_aadPos;

    /* renamed from: m_buf */
    protected byte[] f19652m_buf;
    protected int m_bufPos;
    protected int m_bufferSizeDecrypt;

    /* renamed from: mac */
    protected byte[] f19654mac;
    protected AADProcessingBuffer processor;
    protected int macSizeLowerBound = 0;

    /* renamed from: m_state */
    protected C5335State f19653m_state = C5335State.Uninitialized;
    protected DecryptionFailureCounter decryptionFailureCounter = null;
    protected DataLimitCounter dataLimitCounter = null;

    public interface AADOperator {
        /* renamed from: getLen */
        int mo15230getLen();

        void processAADByte(byte b);

        void processAADBytes(byte[] bArr, int i, int i2);

        /* renamed from: reset */
        void mo15231reset();
    }

    public static class AADOperatorType {

        /* renamed from: COUNTER */
        public static final int f19655COUNTER = 1;
        public static final int DATA_LIMIT = 3;

        /* renamed from: DEFAULT */
        public static final int f19657DEFAULT = 0;

        /* renamed from: STREAM */
        public static final int f19659STREAM = 2;

        /* renamed from: ord */
        private final int f19661ord;

        /* renamed from: Default */
        public static final AADOperatorType f19658Default = new AADOperatorType(0);

        /* renamed from: Counter */
        public static final AADOperatorType f19656Counter = new AADOperatorType(1);

        /* renamed from: Stream */
        public static final AADOperatorType f19660Stream = new AADOperatorType(2);
        public static final AADOperatorType DataLimit = new AADOperatorType(3);

        public AADOperatorType(int i) {
            this.f19661ord = i;
        }
    }

    public interface AADProcessingBuffer {
        int getUpdateOutputSize(int i);

        boolean isLengthExceedingBlockSize(int i, int i2);

        boolean isLengthWithinAvailableSpace(int i, int i2);

        void processAADByte(byte b);

        int processByte(byte b, byte[] bArr, int i);
    }

    public class BufferedAADProcessor implements AADProcessingBuffer {
        private BufferedAADProcessor() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public int getUpdateOutputSize(int i) {
            return Math.max(0, i) - 1;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i, int i2) {
            return i > i2;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i, int i2) {
            return i <= i2;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public void processAADByte(byte b) {
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            if (aEADBaseEngine.m_aadPos == aEADBaseEngine.AADBufferSize) {
                aEADBaseEngine.processBufferAAD(aEADBaseEngine.f19651m_aad, 0);
                AEADBaseEngine.this.m_aadPos = 0;
            }
            AEADBaseEngine aEADBaseEngine2 = AEADBaseEngine.this;
            byte[] bArr = aEADBaseEngine2.f19651m_aad;
            int i = aEADBaseEngine2.m_aadPos;
            aEADBaseEngine2.m_aadPos = i + 1;
            bArr[i] = b;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public int processByte(byte b, byte[] bArr, int i) {
            AEADBaseEngine.this.checkData(false);
            int iProcessEncDecByte = AEADBaseEngine.this.processEncDecByte(bArr, i);
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            byte[] bArr2 = aEADBaseEngine.f19652m_buf;
            int i2 = aEADBaseEngine.m_bufPos;
            aEADBaseEngine.m_bufPos = i2 + 1;
            bArr2[i2] = b;
            return iProcessEncDecByte;
        }
    }

    public class CounterAADOperator implements AADOperator {

        /* renamed from: aadLen */
        private int f19663aadLen;

        private CounterAADOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: getLen */
        public int mo15230getLen() {
            return this.f19663aadLen;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADByte(byte b) {
            this.f19663aadLen++;
            AEADBaseEngine.this.processor.processAADByte(b);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADBytes(byte[] bArr, int i, int i2) {
            this.f19663aadLen += i2;
            AEADBaseEngine.this.processAadBytes(bArr, i, i2);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: reset */
        public void mo15231reset() {
            this.f19663aadLen = 0;
        }
    }

    public class CounterDataOperator implements DataOperator {
        private int messegeLen;

        private CounterDataOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: getLen */
        public int mo15232getLen() {
            return this.messegeLen;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processByte(byte b, byte[] bArr, int i) {
            this.messegeLen++;
            return AEADBaseEngine.this.processor.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            this.messegeLen += i2;
            return AEADBaseEngine.this.processEncDecBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: reset */
        public void mo15233reset() {
            this.messegeLen = 0;
        }
    }

    public class DataLimitAADOperator implements AADOperator {
        private DataLimitAADOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: getLen */
        public int mo15230getLen() {
            return AEADBaseEngine.this.m_aadPos;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADByte(byte b) {
            AEADBaseEngine.this.dataLimitCounter.increment();
            AEADBaseEngine.this.processor.processAADByte(b);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADBytes(byte[] bArr, int i, int i2) {
            AEADBaseEngine.this.dataLimitCounter.increment(i2);
            AEADBaseEngine.this.processAadBytes(bArr, i, i2);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: reset */
        public void mo15231reset() {
        }
    }

    public static class DataLimitCounter {

        /* renamed from: count */
        private long f19667count;

        /* renamed from: max */
        private long f19668max;

        /* renamed from: n */
        private int f19669n;

        public void increment() {
            long j = this.f19667count + 1;
            this.f19667count = j;
            if (j <= this.f19668max) {
                return;
            }
            throw new IllegalStateException("Total data limit exceeded: maximum 2^" + this.f19669n + " bytes per key (including nonce, AAD, and message)");
        }

        /* renamed from: init */
        public void m15234init(int i) {
            this.f19669n = i;
            this.f19668max = 1 << i;
        }

        /* renamed from: reset */
        public void m15235reset() {
            this.f19667count = 0L;
        }

        public void increment(int i) {
            long j = this.f19667count + i;
            this.f19667count = j;
            if (j <= this.f19668max) {
                return;
            }
            throw new IllegalStateException("Total data limit exceeded: maximum 2^" + i + " bytes per key (including nonce, AAD, and message)");
        }
    }

    public class DataLimitDataOperator implements DataOperator {
        private DataLimitDataOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: getLen */
        public int mo15232getLen() {
            return AEADBaseEngine.this.m_bufPos;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processByte(byte b, byte[] bArr, int i) {
            AEADBaseEngine.this.dataLimitCounter.increment();
            return AEADBaseEngine.this.processor.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            AEADBaseEngine.this.dataLimitCounter.increment(i2);
            return AEADBaseEngine.this.processEncDecBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: reset */
        public void mo15233reset() {
        }
    }

    public interface DataOperator {
        /* renamed from: getLen */
        int mo15232getLen();

        int processByte(byte b, byte[] bArr, int i);

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

        /* renamed from: reset */
        void mo15233reset();
    }

    public static class DataOperatorType {

        /* renamed from: COUNTER */
        public static final int f19671COUNTER = 1;
        public static final int DATA_LIMIT = 4;

        /* renamed from: DEFAULT */
        public static final int f19673DEFAULT = 0;

        /* renamed from: STREAM */
        public static final int f19675STREAM = 2;
        public static final int STREAM_CIPHER = 3;

        /* renamed from: ord */
        private final int f19677ord;

        /* renamed from: Default */
        public static final DataOperatorType f19674Default = new DataOperatorType(0);

        /* renamed from: Counter */
        public static final DataOperatorType f19672Counter = new DataOperatorType(1);

        /* renamed from: Stream */
        public static final DataOperatorType f19676Stream = new DataOperatorType(2);
        public static final DataOperatorType StreamCipher = new DataOperatorType(3);
        public static final DataOperatorType DataLimit = new DataOperatorType(4);

        public DataOperatorType(int i) {
            this.f19677ord = i;
        }
    }

    public static class DecryptionFailureCounter {

        /* renamed from: counter */
        private int[] f19678counter;

        /* renamed from: n */
        private int f19679n;

        public boolean increment() {
            int i;
            int length = this.f19678counter.length;
            do {
                length--;
                if (length < 0) {
                    break;
                }
                int[] iArr = this.f19678counter;
                i = iArr[length] + 1;
                iArr[length] = i;
            } while (i == 0);
            int i2 = this.f19679n & 31;
            if (length <= 0) {
                if (this.f19678counter[0] == (i2 == 0 ? 0 : 1 << i2)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: init */
        public void m15236init(int i) {
            if (this.f19679n != i) {
                this.f19679n = i;
                int i2 = (i + 31) >>> 5;
                int[] iArr = this.f19678counter;
                if (iArr == null || i2 != iArr.length) {
                    this.f19678counter = new int[i2];
                } else {
                    m15237reset();
                }
            }
        }

        /* renamed from: reset */
        public void m15237reset() {
            C6238Arrays.m18253fill(this.f19678counter, 0);
        }
    }

    public class DefaultAADOperator implements AADOperator {
        private DefaultAADOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: getLen */
        public int mo15230getLen() {
            return AEADBaseEngine.this.m_aadPos;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADByte(byte b) {
            AEADBaseEngine.this.processor.processAADByte(b);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADBytes(byte[] bArr, int i, int i2) {
            AEADBaseEngine.this.processAadBytes(bArr, i, i2);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: reset */
        public void mo15231reset() {
        }
    }

    public class DefaultDataOperator implements DataOperator {
        private DefaultDataOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: getLen */
        public int mo15232getLen() {
            return AEADBaseEngine.this.m_bufPos;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processByte(byte b, byte[] bArr, int i) {
            return AEADBaseEngine.this.processor.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return AEADBaseEngine.this.processEncDecBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: reset */
        public void mo15233reset() {
        }
    }

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        /* renamed from: getBuf */
        public byte[] m15238getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public class ImmediateAADProcessor implements AADProcessingBuffer {
        private ImmediateAADProcessor() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public int getUpdateOutputSize(int i) {
            return Math.max(0, i);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i, int i2) {
            return i >= i2;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i, int i2) {
            return i < i2;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public void processAADByte(byte b) {
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            byte[] bArr = aEADBaseEngine.f19651m_aad;
            int i = aEADBaseEngine.m_aadPos;
            int i2 = i + 1;
            aEADBaseEngine.m_aadPos = i2;
            bArr[i] = b;
            if (i2 == aEADBaseEngine.AADBufferSize) {
                aEADBaseEngine.processBufferAAD(bArr, 0);
                AEADBaseEngine.this.m_aadPos = 0;
            }
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADProcessingBuffer
        public int processByte(byte b, byte[] bArr, int i) {
            AEADBaseEngine.this.checkData(false);
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            byte[] bArr2 = aEADBaseEngine.f19652m_buf;
            int i2 = aEADBaseEngine.m_bufPos;
            aEADBaseEngine.m_bufPos = i2 + 1;
            bArr2[i2] = b;
            return aEADBaseEngine.processEncDecByte(bArr, i);
        }
    }

    public static class ProcessingBufferType {
        public static final int BUFFERED = 0;
        public static final int IMMEDIATE = 1;

        /* renamed from: ord */
        private final int f19683ord;
        public static final ProcessingBufferType Buffered = new ProcessingBufferType(0);
        public static final ProcessingBufferType Immediate = new ProcessingBufferType(1);

        public ProcessingBufferType(int i) {
            this.f19683ord = i;
        }
    }

    /* renamed from: org.bouncycastle.crypto.engines.AEADBaseEngine$State */
    public static class C5335State {

        /* renamed from: DEC_AAD */
        public static final int f19684DEC_AAD = 6;
        public static final int DEC_DATA = 7;
        public static final int DEC_FINAL = 8;
        public static final int DEC_INIT = 5;

        /* renamed from: ENC_AAD */
        public static final int f19688ENC_AAD = 2;
        public static final int ENC_DATA = 3;
        public static final int ENC_FINAL = 4;
        public static final int ENC_INIT = 1;
        public static final int UNINITIALIZED = 0;

        /* renamed from: ord */
        final int f19692ord;
        public static final C5335State Uninitialized = new C5335State(0);

        /* renamed from: EncInit */
        public static final C5335State f19691EncInit = new C5335State(1);

        /* renamed from: EncAad */
        public static final C5335State f19689EncAad = new C5335State(2);

        /* renamed from: EncData */
        public static final C5335State f19690EncData = new C5335State(3);
        public static final C5335State EncFinal = new C5335State(4);

        /* renamed from: DecInit */
        public static final C5335State f19687DecInit = new C5335State(5);

        /* renamed from: DecAad */
        public static final C5335State f19685DecAad = new C5335State(6);

        /* renamed from: DecData */
        public static final C5335State f19686DecData = new C5335State(7);
        public static final C5335State DecFinal = new C5335State(8);

        public C5335State(int i) {
            this.f19692ord = i;
        }
    }

    public static class StreamAADOperator implements AADOperator {

        /* renamed from: stream */
        private final ErasableOutputStream f19693stream = new ErasableOutputStream();

        public byte[] getBytes() {
            return this.f19693stream.m15238getBuf();
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: getLen */
        public int mo15230getLen() {
            return this.f19693stream.size();
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADByte(byte b) throws IOException {
            this.f19693stream.write(b);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        public void processAADBytes(byte[] bArr, int i, int i2) throws IOException {
            this.f19693stream.write(bArr, i, i2);
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperator
        /* renamed from: reset */
        public void mo15231reset() {
            this.f19693stream.reset();
        }
    }

    public class StreamCipherOperator implements DataOperator {

        /* renamed from: len */
        private int f19694len;

        private StreamCipherOperator() {
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: getLen */
        public int mo15232getLen() {
            return this.f19694len;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processByte(byte b, byte[] bArr, int i) {
            if (AEADBaseEngine.this.checkData(false)) {
                this.f19694len = 1;
                AEADBaseEngine.this.processBufferEncrypt(new byte[]{b}, 0, bArr, i);
                return 1;
            }
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            int i2 = aEADBaseEngine.m_bufPos;
            if (i2 != aEADBaseEngine.MAC_SIZE) {
                byte[] bArr2 = aEADBaseEngine.f19652m_buf;
                aEADBaseEngine.m_bufPos = 1 + i2;
                bArr2[i2] = b;
                return 0;
            }
            this.f19694len = 1;
            aEADBaseEngine.processBufferDecrypt(aEADBaseEngine.f19652m_buf, 0, bArr, i);
            AEADBaseEngine aEADBaseEngine2 = AEADBaseEngine.this;
            byte[] bArr3 = aEADBaseEngine2.f19652m_buf;
            System.arraycopy(bArr3, 1, bArr3, 0, aEADBaseEngine2.m_bufPos - 1);
            AEADBaseEngine aEADBaseEngine3 = AEADBaseEngine.this;
            aEADBaseEngine3.f19652m_buf[aEADBaseEngine3.m_bufPos - 1] = b;
            return 1;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            int i4 = 0;
            if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, AEADBaseEngine.this.processor.getUpdateOutputSize(i2))) {
                bArr = new byte[i2];
                System.arraycopy(bArr2, i, bArr, 0, i2);
                i = 0;
            }
            if (AEADBaseEngine.this.checkData(false)) {
                this.f19694len = i2;
                AEADBaseEngine.this.processBufferEncrypt(bArr, i, bArr2, i3);
                return i2;
            }
            AEADBaseEngine aEADBaseEngine = AEADBaseEngine.this;
            int iMax = Math.max((aEADBaseEngine.m_bufPos + i2) - aEADBaseEngine.MAC_SIZE, 0);
            int i5 = AEADBaseEngine.this.m_bufPos;
            if (i5 > 0) {
                int iMin = Math.min(iMax, i5);
                this.f19694len = iMin;
                AEADBaseEngine aEADBaseEngine2 = AEADBaseEngine.this;
                aEADBaseEngine2.processBufferDecrypt(aEADBaseEngine2.f19652m_buf, 0, bArr2, i3);
                iMax -= iMin;
                AEADBaseEngine aEADBaseEngine3 = AEADBaseEngine.this;
                int i6 = aEADBaseEngine3.m_bufPos - iMin;
                aEADBaseEngine3.m_bufPos = i6;
                byte[] bArr3 = aEADBaseEngine3.f19652m_buf;
                System.arraycopy(bArr3, iMin, bArr3, 0, i6);
                i4 = iMin;
            }
            if (iMax > 0) {
                this.f19694len = iMax;
                AEADBaseEngine.this.processBufferDecrypt(bArr, i, bArr2, i3);
                i4 += iMax;
                i2 -= iMax;
                i += iMax;
            }
            AEADBaseEngine aEADBaseEngine4 = AEADBaseEngine.this;
            System.arraycopy(bArr, i, aEADBaseEngine4.f19652m_buf, aEADBaseEngine4.m_bufPos, i2);
            AEADBaseEngine.this.m_bufPos += i2;
            return i4;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: reset */
        public void mo15233reset() {
        }
    }

    public class StreamDataOperator implements DataOperator {

        /* renamed from: stream */
        private final ErasableOutputStream f19696stream = new ErasableOutputStream();

        public StreamDataOperator() {
        }

        public byte[] getBytes() {
            return this.f19696stream.m15238getBuf();
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: getLen */
        public int mo15232getLen() {
            return this.f19696stream.size();
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processByte(byte b, byte[] bArr, int i) throws IOException {
            AEADBaseEngine.this.checkData(false);
            AEADBaseEngine.this.ensureInitialized();
            this.f19696stream.write(b);
            AEADBaseEngine.this.m_bufPos = this.f19696stream.size();
            return 0;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
            AEADBaseEngine.this.checkData(false);
            AEADBaseEngine.this.ensureInitialized();
            this.f19696stream.write(bArr, i, i2);
            AEADBaseEngine.this.m_bufPos = this.f19696stream.size();
            return 0;
        }

        @Override // org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperator
        /* renamed from: reset */
        public void mo15233reset() {
            this.f19696stream.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAadBytes(byte[] bArr, int i, int i2) {
        int i3 = this.m_aadPos;
        if (i3 > 0) {
            int i4 = this.AADBufferSize - i3;
            if (this.processor.isLengthWithinAvailableSpace(i2, i4)) {
                System.arraycopy(bArr, i, this.f19651m_aad, this.m_aadPos, i2);
                this.m_aadPos += i2;
                return;
            } else {
                System.arraycopy(bArr, i, this.f19651m_aad, this.m_aadPos, i4);
                i += i4;
                i2 -= i4;
                processBufferAAD(this.f19651m_aad, 0);
            }
        }
        while (this.processor.isLengthExceedingBlockSize(i2, this.AADBufferSize)) {
            processBufferAAD(bArr, i);
            int i5 = this.AADBufferSize;
            i += i5;
            i2 -= i5;
        }
        System.arraycopy(bArr, i, this.f19651m_aad, 0, i2);
        this.m_aadPos = i2;
    }

    public void checkAAD() {
        C5335State c5335State;
        int i = this.f19653m_state.f19692ord;
        if (i == 1) {
            c5335State = C5335State.f19689EncAad;
        } else {
            if (i == 2) {
                return;
            }
            if (i == 4) {
                throw new IllegalStateException(getAlgorithmName() + " cannot be reused for encryption");
            }
            if (i != 5) {
                if (i == 6) {
                    return;
                }
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
            }
            c5335State = C5335State.f19685DecAad;
        }
        this.f19653m_state = c5335State;
    }

    public boolean checkData(boolean z) {
        switch (this.f19653m_state.f19692ord) {
            case 1:
            case 2:
                finishAAD(C5335State.f19690EncData, z);
                return true;
            case 3:
                return true;
            case 4:
                throw new IllegalStateException(getAlgorithmName() + " cannot be reused for encryption");
            case 5:
            case 6:
                finishAAD(C5335State.f19686DecData, z);
                return false;
            case 7:
                return false;
            default:
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        int i2;
        boolean zCheckData = checkData(true);
        int i3 = this.m_bufPos;
        int i4 = this.MAC_SIZE;
        if (zCheckData) {
            i2 = i3 + i4;
        } else {
            if (i3 < i4) {
                throw new InvalidCipherTextException("data too short");
            }
            i2 = i3 - i4;
            this.m_bufPos = i2;
        }
        ensureSufficientOutputBuffer(bArr, i, i2);
        this.f19654mac = new byte[this.MAC_SIZE];
        processFinalBlock(bArr, i);
        if (zCheckData) {
            byte[] bArr2 = this.f19654mac;
            int i5 = this.MAC_SIZE;
            System.arraycopy(bArr2, 0, bArr, (i + i2) - i5, i5);
        } else if (!C6238Arrays.constantTimeAreEqual(this.MAC_SIZE, this.f19654mac, 0, this.f19652m_buf, this.m_bufPos)) {
            DecryptionFailureCounter decryptionFailureCounter = this.decryptionFailureCounter;
            if (decryptionFailureCounter == null || !decryptionFailureCounter.increment()) {
                throw new InvalidCipherTextException(this.algorithmName + " mac does not match");
            }
            throw new InvalidCipherTextException(this.algorithmName + " decryption failure limit exceeded");
        }
        mo15229reset(!zCheckData);
        return i2;
    }

    public final void ensureInitialized() {
        if (this.f19653m_state == C5335State.Uninitialized) {
            throw new IllegalStateException("Need to call init function before operation");
        }
    }

    public final void ensureSufficientInputBuffer(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
    }

    public final void ensureSufficientOutputBuffer(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public abstract void finishAAD(C5335State c5335State, boolean z);

    public void finishAAD1(C5335State c5335State) {
        int i = this.f19653m_state.f19692ord;
        if (i == 1 || i == 2 || i == 5 || i == 6) {
            processFinalAAD();
        }
        this.f19653m_state = c5335State;
    }

    public void finishAAD2(C5335State c5335State) {
        int i = this.f19653m_state.f19692ord;
        if (i == 2 || i == 6) {
            processFinalAAD();
        }
        this.m_aadPos = 0;
        this.f19653m_state = c5335State;
    }

    public void finishAAD3(C5335State c5335State, boolean z) {
        int i = this.f19653m_state.f19692ord;
        if (i == 1 || i == 2) {
            processFinalAAD();
        } else if (i == 5 || i == 6) {
            if (!z && this.dataOperator.mo15232getLen() <= this.MAC_SIZE) {
                return;
            }
            processFinalAAD();
        }
        this.m_aadPos = 0;
        this.f19653m_state = c5335State;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    public final int getBlockSize() {
        return this.BlockSize;
    }

    public int getIVBytesSize() {
        return this.f19650IV_SIZE;
    }

    public int getKeyBytesSize() {
        return this.KEY_SIZE;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        return this.f19654mac;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int iMax = Math.max(0, i);
        switch (this.f19653m_state.f19692ord) {
            case 3:
            case 4:
                iMax += this.m_bufPos;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                return Math.max(0, (iMax + this.m_bufPos) - this.MAC_SIZE);
        }
        return iMax + this.MAC_SIZE;
    }

    public int getTotalBytesForUpdate(int i) {
        int i2;
        int updateOutputSize = this.processor.getUpdateOutputSize(i);
        switch (this.f19653m_state.f19692ord) {
            case 3:
            case 4:
                i2 = updateOutputSize + this.m_bufPos;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = (updateOutputSize + this.m_bufPos) - this.MAC_SIZE;
                break;
            default:
                return updateOutputSize;
        }
        return Math.max(0, i2);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        int totalBytesForUpdate = getTotalBytesForUpdate(i);
        return totalBytesForUpdate - (totalBytesForUpdate % this.BlockSize);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameterM15664getKey;
        byte[] bArrM15801getIV;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            keyParameterM15664getKey = aEADParameters.m15664getKey();
            bArrM15801getIV = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            int i = this.macSizeLowerBound;
            if (i == 0) {
                if (macSize != (this.MAC_SIZE << 3)) {
                    throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
                }
            } else {
                if (macSize > 128 || macSize < (i << 3) || (macSize & 7) != 0) {
                    throw new IllegalArgumentException("MAC size must be between " + (this.macSizeLowerBound << 3) + " and 128 bits for " + this.algorithmName);
                }
                this.MAC_SIZE = macSize >>> 3;
            }
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to " + this.algorithmName);
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
            bArrM15801getIV = parametersWithIV.m15801getIV();
            this.initialAssociatedText = null;
        }
        if (keyParameterM15664getKey == null) {
            throw new IllegalArgumentException(this.algorithmName + " Init parameters must include a key");
        }
        if (bArrM15801getIV == null || bArrM15801getIV.length != this.f19650IV_SIZE) {
            throw new IllegalArgumentException(this.algorithmName + " requires exactly " + this.f19650IV_SIZE + " bytes of IV");
        }
        byte[] bArrM15773getKey = keyParameterM15664getKey.m15773getKey();
        if (bArrM15773getKey.length != this.KEY_SIZE) {
            throw new IllegalArgumentException(this.algorithmName + " key must be " + this.KEY_SIZE + " bytes long");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, C5342Utils.getPurpose(z)));
        this.f19653m_state = z ? C5335State.f19691EncInit : C5335State.f19687DecInit;
        mo15227init(bArrM15773getKey, bArrM15801getIV);
        DataLimitCounter dataLimitCounter = this.dataLimitCounter;
        if (dataLimitCounter != null) {
            dataLimitCounter.increment(bArrM15801getIV.length);
        }
        mo15229reset(true);
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    /* renamed from: init */
    public abstract void mo15227init(byte[] bArr, byte[] bArr2);

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        checkAAD();
        this.aadOperator.processAADByte(b);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        ensureSufficientInputBuffer(bArr, i, i2);
        if (i2 <= 0) {
            return;
        }
        checkAAD();
        this.aadOperator.processAADBytes(bArr, i, i2);
    }

    public abstract void processBufferAAD(byte[] bArr, int i);

    public abstract void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2);

    public abstract void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2);

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) {
        return this.dataOperator.processByte(b, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        ensureSufficientInputBuffer(bArr, i, i2);
        return this.dataOperator.processBytes(bArr, i, i2, bArr2, i3);
    }

    public int processEncDecByte(byte[] bArr, int i) {
        if ((this.forEncryption ? this.BlockSize : this.m_bufferSizeDecrypt) - this.m_bufPos != 0) {
            return 0;
        }
        ensureSufficientOutputBuffer(bArr, i, this.BlockSize);
        if (this.forEncryption) {
            processBufferEncrypt(this.f19652m_buf, 0, bArr, i);
        } else {
            processBufferDecrypt(this.f19652m_buf, 0, bArr, i);
            byte[] bArr2 = this.f19652m_buf;
            int i2 = this.BlockSize;
            System.arraycopy(bArr2, i2, bArr2, 0, this.m_bufPos - i2);
        }
        int i3 = this.m_bufPos;
        int i4 = this.BlockSize;
        this.m_bufPos = i3 - i4;
        return i4;
    }

    public int processEncDecBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        boolean zCheckData = checkData(false);
        int i5 = (zCheckData ? this.BlockSize : this.m_bufferSizeDecrypt) - this.m_bufPos;
        if (this.processor.isLengthWithinAvailableSpace(i2, i5)) {
            System.arraycopy(bArr, i, this.f19652m_buf, this.m_bufPos, i2);
            this.m_bufPos += i2;
            return 0;
        }
        int updateOutputSize = this.processor.getUpdateOutputSize(i2);
        int i6 = (this.m_bufPos + updateOutputSize) - (zCheckData ? 0 : this.MAC_SIZE);
        ensureSufficientOutputBuffer(bArr2, i3, i6 - (i6 % this.BlockSize));
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, updateOutputSize)) {
            bArr = new byte[i2];
            System.arraycopy(bArr2, i, bArr, 0, i2);
            i = 0;
        }
        if (zCheckData) {
            int i7 = this.m_bufPos;
            if (i7 > 0) {
                System.arraycopy(bArr, i, this.f19652m_buf, i7, i5);
                i += i5;
                i2 -= i5;
                processBufferEncrypt(this.f19652m_buf, 0, bArr2, i3);
                i4 = this.BlockSize;
            } else {
                i4 = 0;
            }
            while (this.processor.isLengthExceedingBlockSize(i2, this.BlockSize)) {
                processBufferEncrypt(bArr, i, bArr2, i3 + i4);
                int i8 = this.BlockSize;
                i += i8;
                i2 -= i8;
                i4 += i8;
            }
        } else {
            i4 = 0;
            while (this.processor.isLengthExceedingBlockSize(this.m_bufPos, this.BlockSize) && this.processor.isLengthExceedingBlockSize(this.m_bufPos + i2, this.m_bufferSizeDecrypt)) {
                processBufferDecrypt(this.f19652m_buf, i4, bArr2, i3 + i4);
                int i9 = this.m_bufPos;
                int i10 = this.BlockSize;
                this.m_bufPos = i9 - i10;
                i4 += i10;
            }
            int i11 = this.m_bufPos;
            if (i11 > 0) {
                byte[] bArr3 = this.f19652m_buf;
                System.arraycopy(bArr3, i4, bArr3, 0, i11);
                if (this.processor.isLengthWithinAvailableSpace(this.m_bufPos + i2, this.m_bufferSizeDecrypt)) {
                    System.arraycopy(bArr, i, this.f19652m_buf, this.m_bufPos, i2);
                    this.m_bufPos += i2;
                    return i4;
                }
                int iMax = Math.max(this.BlockSize - this.m_bufPos, 0);
                System.arraycopy(bArr, i, this.f19652m_buf, this.m_bufPos, iMax);
                i += iMax;
                i2 -= iMax;
                processBufferDecrypt(this.f19652m_buf, 0, bArr2, i3 + i4);
                i4 += this.BlockSize;
            }
            while (this.processor.isLengthExceedingBlockSize(i2, this.m_bufferSizeDecrypt)) {
                processBufferDecrypt(bArr, i, bArr2, i3 + i4);
                int i12 = this.BlockSize;
                i += i12;
                i2 -= i12;
                i4 += i12;
            }
        }
        System.arraycopy(bArr, i, this.f19652m_buf, 0, i2);
        this.m_bufPos = i2;
        return i4;
    }

    public abstract void processFinalAAD();

    public abstract void processFinalBlock(byte[] bArr, int i);

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        mo15229reset(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setInnerMembers(ProcessingBufferType processingBufferType, AADOperatorType aADOperatorType, DataOperatorType dataOperatorType) {
        AADProcessingBuffer bufferedAADProcessor;
        int i;
        AADOperator defaultAADOperator;
        int i2;
        DataOperator defaultDataOperator;
        int i3 = processingBufferType.f19683ord;
        if (i3 != 0) {
            if (i3 == 1) {
                bufferedAADProcessor = new ImmediateAADProcessor();
            }
            this.m_bufferSizeDecrypt = this.BlockSize + this.MAC_SIZE;
            i = aADOperatorType.f19661ord;
            if (i != 0) {
                this.f19651m_aad = new byte[this.AADBufferSize];
                defaultAADOperator = new DefaultAADOperator();
            } else if (i == 1) {
                this.f19651m_aad = new byte[this.AADBufferSize];
                defaultAADOperator = new CounterAADOperator();
            } else {
                if (i != 2) {
                    if (i == 3) {
                        this.f19651m_aad = new byte[this.AADBufferSize];
                        this.dataLimitCounter = new DataLimitCounter();
                        defaultAADOperator = new DataLimitAADOperator();
                    }
                    i2 = dataOperatorType.f19677ord;
                    if (i2 == 0) {
                        this.f19652m_buf = new byte[this.m_bufferSizeDecrypt];
                        defaultDataOperator = new DefaultDataOperator();
                    } else if (i2 == 1) {
                        this.f19652m_buf = new byte[this.m_bufferSizeDecrypt];
                        defaultDataOperator = new CounterDataOperator();
                    } else if (i2 == 2) {
                        this.f19652m_buf = new byte[this.MAC_SIZE];
                        defaultDataOperator = new StreamDataOperator();
                    } else if (i2 == 3) {
                        this.BlockSize = 0;
                        this.f19652m_buf = new byte[this.m_bufferSizeDecrypt];
                        defaultDataOperator = new StreamCipherOperator();
                    } else {
                        if (i2 != 4) {
                            return;
                        }
                        this.f19652m_buf = new byte[this.m_bufferSizeDecrypt];
                        defaultDataOperator = new DataLimitDataOperator();
                    }
                    this.dataOperator = defaultDataOperator;
                }
                this.AADBufferSize = 0;
                defaultAADOperator = new StreamAADOperator();
            }
            this.aadOperator = defaultAADOperator;
            i2 = dataOperatorType.f19677ord;
            if (i2 == 0) {
            }
            this.dataOperator = defaultDataOperator;
        }
        bufferedAADProcessor = new BufferedAADProcessor();
        this.processor = bufferedAADProcessor;
        this.m_bufferSizeDecrypt = this.BlockSize + this.MAC_SIZE;
        i = aADOperatorType.f19661ord;
        if (i != 0) {
        }
        this.aadOperator = defaultAADOperator;
        i2 = dataOperatorType.f19677ord;
        if (i2 == 0) {
        }
        this.dataOperator = defaultDataOperator;
    }

    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        ensureInitialized();
        if (z) {
            this.f19654mac = null;
        }
        byte[] bArr = this.f19652m_buf;
        if (bArr != null) {
            C6238Arrays.m18249fill(bArr, (byte) 0);
            this.m_bufPos = 0;
        }
        byte[] bArr2 = this.f19651m_aad;
        if (bArr2 != null) {
            C6238Arrays.m18249fill(bArr2, (byte) 0);
            this.m_aadPos = 0;
        }
        switch (this.f19653m_state.f19692ord) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.f19653m_state = C5335State.EncFinal;
                return;
            case 6:
            case 7:
            case 8:
                this.f19653m_state = C5335State.DecFinal;
                break;
            default:
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
        }
        this.aadOperator.mo15231reset();
        this.dataOperator.mo15233reset();
    }
}
