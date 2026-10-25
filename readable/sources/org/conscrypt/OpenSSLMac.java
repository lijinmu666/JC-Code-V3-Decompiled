package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: classes2.dex */
public abstract class OpenSSLMac extends MacSpi {

    /* renamed from: ctx */
    private NativeRef.HMAC_CTX f24427ctx;

    /* renamed from: evp_md */
    private final long f24428evp_md;
    private byte[] keyBytes;
    private final byte[] singleByte;

    /* renamed from: size */
    private final int f24429size;

    /* renamed from: org.conscrypt.OpenSSLMac$HmacMD5 */
    public static final class C6320HmacMD5 extends OpenSSLMac {
        public C6320HmacMD5() {
            super(EvpMdRef.C6280MD5.f24355EVP_MD, EvpMdRef.C6280MD5.SIZE_BYTES);
        }
    }

    public static final class HmacSHA1 extends OpenSSLMac {
        public HmacSHA1() {
            super(EvpMdRef.C6281SHA1.f24357EVP_MD, EvpMdRef.C6281SHA1.SIZE_BYTES);
        }
    }

    public static final class HmacSHA224 extends OpenSSLMac {
        public HmacSHA224() {
            super(EvpMdRef.C6282SHA224.f24359EVP_MD, EvpMdRef.C6282SHA224.SIZE_BYTES);
        }
    }

    public static final class HmacSHA256 extends OpenSSLMac {
        public HmacSHA256() {
            super(EvpMdRef.C6283SHA256.f24361EVP_MD, EvpMdRef.C6283SHA256.SIZE_BYTES);
        }
    }

    public static final class HmacSHA384 extends OpenSSLMac {
        public HmacSHA384() {
            super(EvpMdRef.C6284SHA384.f24363EVP_MD, EvpMdRef.C6284SHA384.SIZE_BYTES);
        }
    }

    public static final class HmacSHA512 extends OpenSSLMac {
        public HmacSHA512() {
            super(EvpMdRef.C6285SHA512.f24365EVP_MD, EvpMdRef.C6285SHA512.SIZE_BYTES);
        }
    }

    private final void resetContext() {
        NativeRef.HMAC_CTX hmac_ctx = new NativeRef.HMAC_CTX(NativeCrypto.HMAC_CTX_new());
        byte[] bArr = this.keyBytes;
        if (bArr != null) {
            NativeCrypto.HMAC_Init_ex(hmac_ctx, bArr, this.f24428evp_md);
        }
        this.f24427ctx = hmac_ctx;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] bArrHMAC_Final = NativeCrypto.HMAC_Final(this.f24427ctx);
        resetContext();
        return bArrHMAC_Final;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.f24429size;
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("key must be a SecretKey");
        }
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type");
        }
        byte[] encoded = key.getEncoded();
        this.keyBytes = encoded;
        if (encoded == null) {
            throw new InvalidKeyException("key cannot be encoded");
        }
        resetContext();
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        resetContext();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    private OpenSSLMac(long j, int i) {
        this.singleByte = new byte[1];
        this.f24428evp_md = j;
        this.f24429size = i;
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        NativeCrypto.HMAC_Update(this.f24427ctx, bArr, i, i2);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(ByteBuffer byteBuffer) {
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
                    NativeCrypto.HMAC_UpdateDirect(this.f24427ctx, j, iRemaining);
                    byteBuffer.position(iPosition + iRemaining);
                    return;
                }
                throw new RuntimeException("Negative remaining amount");
            }
            throw new RuntimeException("Negative position");
        }
    }
}
