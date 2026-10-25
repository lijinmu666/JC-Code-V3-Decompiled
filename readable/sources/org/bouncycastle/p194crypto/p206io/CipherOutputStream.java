package org.bouncycastle.p194crypto.p206io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p210modes.AEADBlockCipher;

/* loaded from: classes2.dex */
public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;

    /* renamed from: buf */
    private byte[] f20357buf;
    private BufferedBlockCipher bufferedBlockCipher;

    /* renamed from: oneByte */
    private final byte[] f20358oneByte;
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.f20358oneByte = new byte[1];
        this.bufferedBlockCipher = bufferedBlockCipher;
    }

    private void ensureCapacity(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                i = bufferedBlockCipher.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.f20357buf;
        if (bArr == null || bArr.length < i) {
            this.f20357buf = new byte[i];
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:0|2|(4:34|3|(2:5|(1:7))(2:12|(2:14|(1:16))(2:17|(1:19)))|20)|32|24|(1:30)(1:31)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws IOException {
        IOException cipherIOException;
        IOException iOException;
        ensureCapacity(0, true);
        try {
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                int iMo14951doFinal = bufferedBlockCipher.mo14951doFinal(this.f20357buf, 0);
                if (iMo14951doFinal != 0) {
                    ((FilterOutputStream) this).out.write(this.f20357buf, 0, iMo14951doFinal);
                }
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    int iMo15224doFinal = aEADBlockCipher.mo15224doFinal(this.f20357buf, 0);
                    if (iMo15224doFinal != 0) {
                        ((FilterOutputStream) this).out.write(this.f20357buf, 0, iMo15224doFinal);
                    }
                } else {
                    StreamCipher streamCipher = this.streamCipher;
                    if (streamCipher != null) {
                        streamCipher.mo14994reset();
                    }
                }
            }
            iOException = null;
        } catch (InvalidCipherTextException e) {
            cipherIOException = new InvalidCipherTextIOException("Error finalising cipher data", e);
            iOException = cipherIOException;
            flush();
            ((FilterOutputStream) this).out.close();
            if (iOException != null) {
            }
        } catch (Exception e2) {
            cipherIOException = new CipherIOException("Error closing stream: ", e2);
            iOException = cipherIOException;
            flush();
            ((FilterOutputStream) this).out.close();
            if (iOException != null) {
            }
        }
        flush();
        ((FilterOutputStream) this).out.close();
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f20358oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        StreamCipher streamCipher = this.streamCipher;
        if (streamCipher != null) {
            ((FilterOutputStream) this).out.write(streamCipher.returnByte(b));
        } else {
            write(bArr, 0, 1);
        }
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.f20358oneByte = new byte[1];
        this.streamCipher = streamCipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.f20358oneByte = new byte[1];
        this.aeadBlockCipher = aEADBlockCipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ensureCapacity(i2, false);
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            int iProcessBytes = bufferedBlockCipher.processBytes(bArr, i, i2, this.f20357buf, 0);
            if (iProcessBytes != 0) {
                ((FilterOutputStream) this).out.write(this.f20357buf, 0, iProcessBytes);
                return;
            }
            return;
        }
        AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
        if (aEADBlockCipher == null) {
            this.streamCipher.processBytes(bArr, i, i2, this.f20357buf, 0);
            ((FilterOutputStream) this).out.write(this.f20357buf, 0, i2);
        } else {
            int iProcessBytes2 = aEADBlockCipher.processBytes(bArr, i, i2, this.f20357buf, 0);
            if (iProcessBytes2 != 0) {
                ((FilterOutputStream) this).out.write(this.f20357buf, 0, iProcessBytes2);
            }
        }
    }
}
