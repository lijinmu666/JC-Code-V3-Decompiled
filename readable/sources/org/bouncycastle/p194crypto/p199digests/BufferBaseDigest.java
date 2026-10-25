package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
abstract class BufferBaseDigest implements ExtendedDigest {
    protected int BlockSize;
    protected int DigestSize;
    protected String algorithmName;

    /* renamed from: m_buf */
    protected byte[] f19336m_buf;
    protected int m_bufPos;
    protected ProcessingBuffer processor;

    public class BufferedProcessor implements ProcessingBuffer {
        private BufferedProcessor() {
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i, int i2) {
            return i > i2;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i, int i2) {
            return i <= i2;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        /* renamed from: update */
        public void mo15059update(byte b) {
            BufferBaseDigest bufferBaseDigest = BufferBaseDigest.this;
            if (bufferBaseDigest.m_bufPos == bufferBaseDigest.BlockSize) {
                bufferBaseDigest.processBytes(bufferBaseDigest.f19336m_buf, 0);
                BufferBaseDigest.this.m_bufPos = 0;
            }
            BufferBaseDigest bufferBaseDigest2 = BufferBaseDigest.this;
            byte[] bArr = bufferBaseDigest2.f19336m_buf;
            int i = bufferBaseDigest2.m_bufPos;
            bufferBaseDigest2.m_bufPos = i + 1;
            bArr[i] = b;
        }
    }

    public class ImmediateProcessor implements ProcessingBuffer {
        private ImmediateProcessor() {
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i, int i2) {
            return i >= i2;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i, int i2) {
            return i < i2;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        /* renamed from: update */
        public void mo15059update(byte b) {
            BufferBaseDigest bufferBaseDigest = BufferBaseDigest.this;
            byte[] bArr = bufferBaseDigest.f19336m_buf;
            int i = bufferBaseDigest.m_bufPos;
            bArr[i] = b;
            int i2 = i + 1;
            bufferBaseDigest.m_bufPos = i2;
            if (i2 == bufferBaseDigest.BlockSize) {
                bufferBaseDigest.processBytes(bArr, 0);
                BufferBaseDigest.this.m_bufPos = 0;
            }
        }
    }

    public interface ProcessingBuffer {
        boolean isLengthExceedingBlockSize(int i, int i2);

        boolean isLengthWithinAvailableSpace(int i, int i2);

        /* renamed from: update */
        void mo15059update(byte b);
    }

    public static class ProcessingBufferType {
        public static final int BUFFERED = 0;
        public static final int IMMEDIATE = 1;

        /* renamed from: ord */
        private final int f19339ord;
        public static final ProcessingBufferType Buffered = new ProcessingBufferType(0);
        public static final ProcessingBufferType Immediate = new ProcessingBufferType(1);

        public ProcessingBufferType(int i) {
            this.f19339ord = i;
        }
    }

    public BufferBaseDigest(ProcessingBufferType processingBufferType, int i) {
        ProcessingBuffer bufferedProcessor;
        this.BlockSize = i;
        this.f19336m_buf = new byte[i];
        int i2 = processingBufferType.f19339ord;
        if (i2 == 0) {
            bufferedProcessor = new BufferedProcessor();
        } else if (i2 != 1) {
            return;
        } else {
            bufferedProcessor = new ImmediateProcessor();
        }
        this.processor = bufferedProcessor;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        ensureSufficientOutputBuffer(bArr, i);
        mo15038finish(bArr, i);
        mo14968reset();
        return this.DigestSize;
    }

    public void ensureSufficientInputBuffer(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
    }

    public void ensureSufficientOutputBuffer(byte[] bArr, int i) {
        if (this.DigestSize + i > bArr.length) {
            throw new OutputLengthException("output buffer is too short");
        }
    }

    /* renamed from: finish */
    public abstract void mo15038finish(byte[] bArr, int i);

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.BlockSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.DigestSize;
    }

    public abstract void processBytes(byte[] bArr, int i);

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        C6238Arrays.m18227clear(this.f19336m_buf);
        this.m_bufPos = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.processor.mo15059update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        ensureSufficientInputBuffer(bArr, i, i2);
        int i3 = this.BlockSize - this.m_bufPos;
        if (this.processor.isLengthWithinAvailableSpace(i2, i3)) {
            System.arraycopy(bArr, i, this.f19336m_buf, this.m_bufPos, i2);
            this.m_bufPos += i2;
            return;
        }
        int i4 = this.m_bufPos;
        if (i4 > 0) {
            System.arraycopy(bArr, i, this.f19336m_buf, i4, i3);
            i += i3;
            i2 -= i3;
            processBytes(this.f19336m_buf, 0);
        }
        while (this.processor.isLengthExceedingBlockSize(i2, this.BlockSize)) {
            processBytes(bArr, i);
            int i5 = this.BlockSize;
            i += i5;
            i2 -= i5;
        }
        System.arraycopy(bArr, i, this.f19336m_buf, 0, i2);
        this.m_bufPos = i2;
    }
}
