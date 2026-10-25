package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.MessageDigestSpi;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: classes2.dex */
public class OpenSSLMessageDigestJDK extends MessageDigestSpi implements Cloneable {

    /* renamed from: ctx */
    private final NativeRef.EVP_MD_CTX f24430ctx;
    private boolean digestInitializedInContext;

    /* renamed from: evp_md */
    private final long f24431evp_md;
    private final byte[] singleByte;

    /* renamed from: size */
    private final int f24432size;

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$MD5 */
    public static final class C6322MD5 extends OpenSSLMessageDigestJDK {
        public C6322MD5() {
            super(EvpMdRef.C6280MD5.f24355EVP_MD, EvpMdRef.C6280MD5.SIZE_BYTES);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$SHA1 */
    public static final class C6323SHA1 extends OpenSSLMessageDigestJDK {
        public C6323SHA1() {
            super(EvpMdRef.C6281SHA1.f24357EVP_MD, EvpMdRef.C6281SHA1.SIZE_BYTES);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$SHA224 */
    public static final class C6324SHA224 extends OpenSSLMessageDigestJDK {
        public C6324SHA224() {
            super(EvpMdRef.C6282SHA224.f24359EVP_MD, EvpMdRef.C6282SHA224.SIZE_BYTES);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$SHA256 */
    public static final class C6325SHA256 extends OpenSSLMessageDigestJDK {
        public C6325SHA256() {
            super(EvpMdRef.C6283SHA256.f24361EVP_MD, EvpMdRef.C6283SHA256.SIZE_BYTES);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$SHA384 */
    public static final class C6326SHA384 extends OpenSSLMessageDigestJDK {
        public C6326SHA384() {
            super(EvpMdRef.C6284SHA384.f24363EVP_MD, EvpMdRef.C6284SHA384.SIZE_BYTES);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLMessageDigestJDK$SHA512 */
    public static final class C6327SHA512 extends OpenSSLMessageDigestJDK {
        public C6327SHA512() {
            super(EvpMdRef.C6285SHA512.f24365EVP_MD, EvpMdRef.C6285SHA512.SIZE_BYTES);
        }
    }

    private synchronized void ensureDigestInitializedInContext() {
        if (!this.digestInitializedInContext) {
            NativeCrypto.EVP_DigestInit_ex(this.f24430ctx, this.f24431evp_md);
            this.digestInitializedInContext = true;
        }
    }

    @Override // java.security.MessageDigestSpi
    public Object clone() {
        NativeRef.EVP_MD_CTX evp_md_ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
        if (this.digestInitializedInContext) {
            NativeCrypto.EVP_MD_CTX_copy_ex(evp_md_ctx, this.f24430ctx);
        }
        return new OpenSSLMessageDigestJDK(this.f24431evp_md, this.f24432size, evp_md_ctx, this.digestInitializedInContext);
    }

    @Override // java.security.MessageDigestSpi
    public synchronized byte[] engineDigest() {
        byte[] bArr;
        ensureDigestInitializedInContext();
        bArr = new byte[this.f24432size];
        NativeCrypto.EVP_DigestFinal_ex(this.f24430ctx, bArr, 0);
        this.digestInitializedInContext = false;
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.f24432size;
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineReset() {
        NativeCrypto.EVP_MD_CTX_cleanup(this.f24430ctx);
        this.digestInitializedInContext = false;
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    private OpenSSLMessageDigestJDK(long j, int i) {
        this.singleByte = new byte[1];
        this.f24431evp_md = j;
        this.f24432size = i;
        this.f24430ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(byte[] bArr, int i, int i2) {
        ensureDigestInitializedInContext();
        NativeCrypto.EVP_DigestUpdate(this.f24430ctx, bArr, i, i2);
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!byteBuffer.isDirect()) {
                super.engineUpdate(byteBuffer);
                return;
            }
            long directBufferAddress = NativeCrypto.getDirectBufferAddress(byteBuffer);
            if (directBufferAddress == 0) {
                super.engineUpdate(byteBuffer);
                return;
            }
            int iPosition = byteBuffer.position();
            if (iPosition >= 0) {
                long j = directBufferAddress + iPosition;
                int iRemaining = byteBuffer.remaining();
                if (iRemaining >= 0) {
                    ensureDigestInitializedInContext();
                    NativeCrypto.EVP_DigestUpdateDirect(this.f24430ctx, j, iRemaining);
                    byteBuffer.position(iPosition + iRemaining);
                    return;
                }
                throw new RuntimeException("Negative remaining amount");
            }
            throw new RuntimeException("Negative position");
        }
    }

    private OpenSSLMessageDigestJDK(long j, int i, NativeRef.EVP_MD_CTX evp_md_ctx, boolean z) {
        this.singleByte = new byte[1];
        this.f24431evp_md = j;
        this.f24432size = i;
        this.f24430ctx = evp_md_ctx;
        this.digestInitializedInContext = z;
    }
}
