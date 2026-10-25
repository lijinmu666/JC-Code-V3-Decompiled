package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p314pqc.p316crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class LMSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {

    /* renamed from: T1 */
    private static CacheKey f23247T1;
    private static CacheKey[] internedKeys;

    /* renamed from: I */
    private final byte[] f23248I;
    private final byte[] masterSecret;
    private final int maxCacheR;

    /* renamed from: maxQ */
    private final int f23249maxQ;
    private final LMOtsParameters otsParameters;
    private final LMSigParameters parameters;
    private LMSPublicKeyParameters publicKey;

    /* renamed from: q */
    private int f23250q;

    /* renamed from: tCache */
    private final Map<CacheKey, byte[]> f23251tCache;

    /* renamed from: tDigest */
    private final InterfaceC5277Digest f23252tDigest;

    public static class CacheKey {

        /* renamed from: index */
        private final int f23253index;

        public CacheKey(int i) {
            this.f23253index = i;
        }

        /* renamed from: equals */
        public boolean m17644equals(Object obj) {
            return (obj instanceof CacheKey) && ((CacheKey) obj).f23253index == this.f23253index;
        }

        public int hashCode() {
            return this.f23253index;
        }
    }

    static {
        CacheKey cacheKey = new CacheKey(1);
        f23247T1 = cacheKey;
        CacheKey[] cacheKeyArr = new CacheKey[129];
        internedKeys = cacheKeyArr;
        cacheKeyArr[1] = cacheKey;
        int i = 2;
        while (true) {
            CacheKey[] cacheKeyArr2 = internedKeys;
            if (i >= cacheKeyArr2.length) {
                return;
            }
            cacheKeyArr2[i] = new CacheKey(i);
            i++;
        }
    }

    private LMSPrivateKeyParameters(LMSPrivateKeyParameters lMSPrivateKeyParameters, int i, int i2) {
        super(true);
        LMSigParameters lMSigParameters = lMSPrivateKeyParameters.parameters;
        this.parameters = lMSigParameters;
        this.otsParameters = lMSPrivateKeyParameters.otsParameters;
        this.f23250q = i;
        this.f23248I = lMSPrivateKeyParameters.f23248I;
        this.f23249maxQ = i2;
        this.masterSecret = lMSPrivateKeyParameters.masterSecret;
        this.maxCacheR = 1 << lMSigParameters.m17653getH();
        this.f23251tCache = lMSPrivateKeyParameters.f23251tCache;
        this.f23252tDigest = DigestUtil.getDigest(lMSigParameters);
        this.publicKey = lMSPrivateKeyParameters.publicKey;
    }

    /* renamed from: calcT */
    private byte[] m17639calcT(int i) {
        int iM17653getH = 1 << getSigParameters().m17653getH();
        if (i >= iM17653getH) {
            LmsUtils.byteArray(m17643getI(), this.f23252tDigest);
            LmsUtils.m17659u32str(i, this.f23252tDigest);
            LmsUtils.m17658u16str((short) -32126, this.f23252tDigest);
            LmsUtils.byteArray(C6070LM_OTS.lms_ots_generatePublicKey(getOtsParameters(), m17643getI(), i - iM17653getH, getMasterSecret()), this.f23252tDigest);
            byte[] bArr = new byte[this.f23252tDigest.getDigestSize()];
            this.f23252tDigest.mo14967doFinal(bArr, 0);
            return bArr;
        }
        int i2 = i * 2;
        byte[] bArrM17642findT = m17642findT(i2);
        byte[] bArrM17642findT2 = m17642findT(i2 + 1);
        LmsUtils.byteArray(m17643getI(), this.f23252tDigest);
        LmsUtils.m17659u32str(i, this.f23252tDigest);
        LmsUtils.m17658u16str((short) -31869, this.f23252tDigest);
        LmsUtils.byteArray(bArrM17642findT, this.f23252tDigest);
        LmsUtils.byteArray(bArrM17642findT2, this.f23252tDigest);
        byte[] bArr2 = new byte[this.f23252tDigest.getDigestSize()];
        this.f23252tDigest.mo14967doFinal(bArr2, 0);
        return bArr2;
    }

    public static LMSPrivateKeyParameters getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof LMSPrivateKeyParameters) {
            return (LMSPrivateKeyParameters) obj;
        }
        if (!(obj instanceof DataInputStream)) {
            if (!(obj instanceof byte[])) {
                if (obj instanceof InputStream) {
                    return getInstance(C6257Streams.m18363readAll((InputStream) obj));
                }
                throw new IllegalArgumentException("cannot parse " + obj);
            }
            DataInputStream dataInputStream2 = null;
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            } catch (Throwable th) {
                th = th;
            }
            try {
                LMSPrivateKeyParameters lMSPrivateKeyParameters = getInstance(dataInputStream);
                dataInputStream.close();
                return lMSPrivateKeyParameters;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        }
        DataInputStream dataInputStream3 = (DataInputStream) obj;
        if (dataInputStream3.readInt() != 0) {
            throw new IllegalStateException("expected version 0 lms private key");
        }
        LMSigParameters parametersForType = LMSigParameters.getParametersForType(dataInputStream3.readInt());
        LMOtsParameters parametersForType2 = LMOtsParameters.getParametersForType(dataInputStream3.readInt());
        byte[] bArr = new byte[16];
        dataInputStream3.readFully(bArr);
        int i = dataInputStream3.readInt();
        int i2 = dataInputStream3.readInt();
        int i3 = dataInputStream3.readInt();
        if (i3 < 0) {
            throw new IllegalStateException("secret length less than zero");
        }
        if (i3 <= dataInputStream3.available()) {
            byte[] bArr2 = new byte[i3];
            dataInputStream3.readFully(bArr2);
            return new LMSPrivateKeyParameters(parametersForType, parametersForType2, i, bArr, i2, bArr2);
        }
        throw new IOException("secret length exceeded " + dataInputStream3.available());
    }

    /* renamed from: equals */
    public boolean m17641equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters) obj;
        if (this.f23250q != lMSPrivateKeyParameters.f23250q || this.f23249maxQ != lMSPrivateKeyParameters.f23249maxQ || !C6238Arrays.areEqual(this.f23248I, lMSPrivateKeyParameters.f23248I)) {
            return false;
        }
        LMSigParameters lMSigParameters = this.parameters;
        if (lMSigParameters == null ? lMSPrivateKeyParameters.parameters != null : !lMSigParameters.equals(lMSPrivateKeyParameters.parameters)) {
            return false;
        }
        LMOtsParameters lMOtsParameters = this.otsParameters;
        if (lMOtsParameters == null ? lMSPrivateKeyParameters.otsParameters == null : lMOtsParameters.equals(lMSPrivateKeyParameters.otsParameters)) {
            return C6238Arrays.areEqual(this.masterSecret, lMSPrivateKeyParameters.masterSecret);
        }
        return false;
    }

    public LMSPrivateKeyParameters extractKeyShard(int i) {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        synchronized (this) {
            try {
                if (i < 0) {
                    throw new IllegalArgumentException("usageCount cannot be negative");
                }
                int i2 = this.f23249maxQ;
                int i3 = this.f23250q;
                if (i > i2 - i3) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                int i4 = i + i3;
                this.f23250q = i4;
                lMSPrivateKeyParameters = new LMSPrivateKeyParameters(this, i3, i4);
            } catch (Throwable th) {
                throw th;
            }
        }
        return lMSPrivateKeyParameters;
    }

    /* renamed from: findT */
    public byte[] m17642findT(int i) {
        if (i >= this.maxCacheR) {
            return m17639calcT(i);
        }
        CacheKey[] cacheKeyArr = internedKeys;
        return m17640findT(i < cacheKeyArr.length ? cacheKeyArr[i] : new CacheKey(i));
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public LMSContext generateLMSContext() {
        int iM17653getH = getSigParameters().m17653getH();
        int index = getIndex();
        LMOtsPrivateKey nextOtsPrivateKey = getNextOtsPrivateKey();
        int i = (1 << iM17653getH) + index;
        byte[][] bArr = new byte[iM17653getH][];
        for (int i2 = 0; i2 < iM17653getH; i2++) {
            bArr[i2] = m17642findT((i / (1 << i2)) ^ 1);
        }
        return nextOtsPrivateKey.getSignatureContext(getSigParameters(), bArr);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public byte[] generateSignature(LMSContext lMSContext) {
        try {
            return C6068LMS.generateSign(lMSContext).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    public LMOtsPrivateKey getCurrentOTSKey() {
        LMOtsPrivateKey lMOtsPrivateKey;
        synchronized (this) {
            try {
                int i = this.f23250q;
                if (i >= this.f23249maxQ) {
                    throw new ExhaustedPrivateKeyException("ots private keys expired");
                }
                lMOtsPrivateKey = new LMOtsPrivateKey(this.otsParameters, this.f23248I, i, this.masterSecret);
            } catch (Throwable th) {
                throw th;
            }
        }
        return lMOtsPrivateKey;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters, org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return Composer.m17598compose().m17609u32str(0).m17609u32str(this.parameters.m17655getType()).m17609u32str(this.otsParameters.m17624getType()).m17602bytes(this.f23248I).m17609u32str(this.f23250q).m17609u32str(this.f23249maxQ).m17609u32str(this.masterSecret.length).m17602bytes(this.masterSecret).m17600build();
    }

    /* renamed from: getI */
    public byte[] m17643getI() {
        return C6238Arrays.m18231clone(this.f23248I);
    }

    public synchronized int getIndex() {
        return this.f23250q;
    }

    public int getIndexLimit() {
        return this.f23249maxQ;
    }

    public byte[] getMasterSecret() {
        return C6238Arrays.m18231clone(this.masterSecret);
    }

    public LMOtsPrivateKey getNextOtsPrivateKey() {
        LMOtsPrivateKey lMOtsPrivateKey;
        synchronized (this) {
            try {
                int i = this.f23250q;
                if (i >= this.f23249maxQ) {
                    throw new ExhaustedPrivateKeyException("ots private key exhausted");
                }
                lMOtsPrivateKey = new LMOtsPrivateKey(this.otsParameters, this.f23248I, i, this.masterSecret);
                incIndex();
            } catch (Throwable th) {
                throw th;
            }
        }
        return lMOtsPrivateKey;
    }

    public LMOtsParameters getOtsParameters() {
        return this.otsParameters;
    }

    public LMSPublicKeyParameters getPublicKey() {
        LMSPublicKeyParameters lMSPublicKeyParameters;
        synchronized (this) {
            try {
                if (this.publicKey == null) {
                    this.publicKey = new LMSPublicKeyParameters(this.parameters, this.otsParameters, m17640findT(f23247T1), this.f23248I);
                }
                lMSPublicKeyParameters = this.publicKey;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lMSPublicKeyParameters;
    }

    public LMSigParameters getSigParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public long getUsagesRemaining() {
        return getIndexLimit() - getIndex();
    }

    public int hashCode() {
        int iHashCode = ((this.f23250q * 31) + C6238Arrays.hashCode(this.f23248I)) * 31;
        LMSigParameters lMSigParameters = this.parameters;
        int iHashCode2 = (iHashCode + (lMSigParameters != null ? lMSigParameters.hashCode() : 0)) * 31;
        LMOtsParameters lMOtsParameters = this.otsParameters;
        return ((((iHashCode2 + (lMOtsParameters != null ? lMOtsParameters.hashCode() : 0)) * 31) + this.f23249maxQ) * 31) + C6238Arrays.hashCode(this.masterSecret);
    }

    public synchronized void incIndex() {
        this.f23250q++;
    }

    public LMSPrivateKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i, byte[] bArr, int i2, byte[] bArr2) {
        super(true);
        this.parameters = lMSigParameters;
        this.otsParameters = lMOtsParameters;
        this.f23250q = i;
        this.f23248I = C6238Arrays.m18231clone(bArr);
        this.f23249maxQ = i2;
        this.masterSecret = C6238Arrays.m18231clone(bArr2);
        this.maxCacheR = 1 << (lMSigParameters.m17653getH() + 1);
        this.f23251tCache = new WeakHashMap();
        this.f23252tDigest = DigestUtil.getDigest(lMSigParameters);
    }

    /* renamed from: findT */
    private byte[] m17640findT(CacheKey cacheKey) {
        synchronized (this.f23251tCache) {
            try {
                byte[] bArr = this.f23251tCache.get(cacheKey);
                if (bArr != null) {
                    return bArr;
                }
                byte[] bArrM17639calcT = m17639calcT(cacheKey.f23253index);
                this.f23251tCache.put(cacheKey, bArrM17639calcT);
                return bArrM17639calcT;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static LMSPrivateKeyParameters getInstance(byte[] bArr, byte[] bArr2) throws Throwable {
        LMSPrivateKeyParameters lMSPrivateKeyParameters = getInstance(bArr);
        lMSPrivateKeyParameters.publicKey = LMSPublicKeyParameters.getInstance(bArr2);
        return lMSPrivateKeyParameters;
    }
}
