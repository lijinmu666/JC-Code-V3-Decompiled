package p131o;

import cafe.cryptography.curve25519.C0186Scalar;
import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.Constants;
import cafe.cryptography.curve25519.EdwardsPoint;
import cafe.cryptography.curve25519.InvalidEncodingException;
import cafe.cryptography.p026ed25519.Ed25519PublicKey;
import cafe.cryptography.p027subtle.ConstantTime;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.security.auth.Destroyable;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import p094kotlin.C1126UByte;

/* renamed from: o.b7 */
/* loaded from: classes.dex */
public class C3409b7 implements Destroyable, AutoCloseable {

    /* renamed from: MiMN */
    public static final byte[] f13047MiMN;

    /* renamed from: VA */
    public static final byte[] f13048VA;

    /* renamed from: YoKzxo */
    public static final byte[] f13049YoKzxo;

    /* renamed from: qGY */
    public static final EdwardsPoint f13050qGY;

    /* renamed from: rkYL */
    public static final EdwardsPoint f13051rkYL;

    /* renamed from: AZxh */
    public final byte[] f13052AZxh;

    /* renamed from: Dt */
    public boolean f13053Dt;

    /* renamed from: ETF */
    public boolean f13054ETF;

    /* renamed from: JHa */
    public final byte[] f13055JHa;

    /* renamed from: KLFTb */
    public final byte[] f13056KLFTb;

    /* renamed from: ZfxDd */
    public final byte[] f13057ZfxDd;

    /* renamed from: lgHUyS */
    public final SecureRandom f13058lgHUyS;

    /* renamed from: mjFkc */
    public final byte[] f13059mjFkc;

    /* renamed from: qdMbNW */
    public wA f13060qdMbNW;

    /* renamed from: wA */
    public final EnumC3476c7 f13061wA;

    /* renamed from: xJ */
    public final byte[] f13062xJ;

    /* renamed from: o.b7$AZxh */
    public static final class AZxh {

        /* renamed from: mjFkc */
        public static final SecureRandom f13063mjFkc = m11461AZxh();

        /* renamed from: AZxh */
        public static SecureRandom m11461AZxh() {
            try {
                return (SecureRandom) SecureRandom.class.getMethod("getInstanceStrong", null).invoke(null, null);
            } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | SecurityException unused) {
                return new SecureRandom();
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof NoSuchAlgorithmException) {
                    return new SecureRandom();
                }
                throw new IllegalStateException("Strong secure random factory failed.", e);
            }
        }
    }

    /* renamed from: o.b7$wA */
    public enum wA {
        Init,
        MsgGenerated,
        KeyGenerated
    }

    static {
        byte[] bArrM13977mjFkc = AbstractC4920y.m13977mjFkc("5ada7e4bf6ddd9adb6626d32131c6b5c51a1e347a3478f53cfcf441b88eed12e");
        f13048VA = bArrM13977mjFkc;
        byte[] bArrM13977mjFkc2 = AbstractC4920y.m13977mjFkc("10e3df0ae37d8e7a99b5fe74b44672103dbddcbd06af680d71329a11693bc778");
        f13047MiMN = bArrM13977mjFkc2;
        f13049YoKzxo = AbstractC4920y.m13977mjFkc("edd3f55c1a631258d69cf7a2def9de1400000000000000000000000000000010");
        try {
            f13051rkYL = new CompressedEdwardsY(bArrM13977mjFkc).decompress();
            f13050qGY = new CompressedEdwardsY(bArrM13977mjFkc2).decompress();
        } catch (InvalidEncodingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public C3409b7(EnumC3476c7 enumC3476c7, byte[] bArr, byte[] bArr2) {
        this(enumC3476c7, bArr, bArr2, null);
    }

    /* renamed from: MiMN */
    public static EdwardsPoint m11449MiMN(EdwardsPoint edwardsPoint, byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Scalar must be 32 bytes.");
        }
        EdwardsPoint[] edwardsPointArr = new EdwardsPoint[16];
        edwardsPointArr[0] = EdwardsPoint.IDENTITY;
        for (int i = 1; i < 16; i++) {
            edwardsPointArr[i] = edwardsPointArr[i - 1].m2108add(edwardsPoint);
        }
        EdwardsPoint edwardsPointM2108add = EdwardsPoint.IDENTITY;
        for (int i2 = 31; i2 >= 0; i2--) {
            byte b = bArr[i2];
            edwardsPointM2108add = m11450VA(m11450VA(edwardsPointM2108add).m2108add(m11451diqgf(edwardsPointArr, ((b & C1126UByte.MAX_VALUE) >>> 4) & 15))).m2108add(m11451diqgf(edwardsPointArr, b & 15));
        }
        return edwardsPointM2108add;
    }

    /* renamed from: VA */
    public static EdwardsPoint m11450VA(EdwardsPoint edwardsPoint) {
        for (int i = 0; i < 4; i++) {
            edwardsPoint = edwardsPoint.m2109dbl();
        }
        return edwardsPoint;
    }

    /* renamed from: diqgf */
    public static EdwardsPoint m11451diqgf(EdwardsPoint[] edwardsPointArr, int i) {
        EdwardsPoint edwardsPointCtSelect = edwardsPointArr[0];
        for (int i2 = 1; i2 < edwardsPointArr.length; i2++) {
            edwardsPointCtSelect = edwardsPointCtSelect.ctSelect(edwardsPointArr[i2], ConstantTime.m2145equal(i, i2));
        }
        return edwardsPointCtSelect;
    }

    /* renamed from: eyqo */
    public static void m11452eyqo(MessageDigest messageDigest, byte[] bArr, int i) {
        byte[] bArr2 = new byte[8];
        long j = i & BodyPartID.bodyIdMax;
        for (int i2 = 0; i2 < 8; i2++) {
            bArr2[i2] = (byte) (255 & j);
            j >>>= 8;
        }
        messageDigest.update(bArr2);
        messageDigest.update(bArr, 0, i);
    }

    /* renamed from: fehf */
    public static MessageDigest m11453fehf() {
        try {
            return MessageDigest.getInstance(XMSSKeyParameters.f23622SHA_512);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("SHA-512 algorithm is not supported.", e);
        }
    }

    /* renamed from: qdMbNW */
    public static void m11454qdMbNW(byte[] bArr) {
        int i = 0;
        byte b = 0;
        while (i < 32) {
            byte b2 = bArr[i];
            byte b3 = (byte) ((b2 & C1126UByte.MAX_VALUE) >>> 5);
            bArr[i] = (byte) (b | (b2 << 3));
            i++;
            b = b3;
        }
    }

    /* renamed from: xJ */
    public static byte[] m11455xJ(byte[] bArr) {
        MessageDigest messageDigestM11453fehf = m11453fehf();
        messageDigestM11453fehf.reset();
        return messageDigestM11453fehf.digest(bArr);
    }

    /* renamed from: KLFTb */
    public byte[] m11456KLFTb(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Invalid password input.");
        }
        if (bArr.length > 65536) {
            throw new IllegalArgumentException("Password too large.");
        }
        if (bArr2 == null || bArr2.length != 64) {
            throw new IllegalArgumentException("Invalid private key input.");
        }
        if (this.f13054ETF) {
            throw new IllegalStateException("The context was destroyed.");
        }
        if (this.f13060qdMbNW != wA.Init) {
            throw new IllegalStateException("Invalid state: " + this.f13060qdMbNW);
        }
        byte[] byteArray = C0186Scalar.fromBytesModOrderWide(bArr2).toByteArray();
        try {
            m11454qdMbNW(byteArray);
            byte[] bArr3 = this.f13057ZfxDd;
            System.arraycopy(byteArray, 0, bArr3, 0, bArr3.length);
            EdwardsPoint edwardsPointM11449MiMN = m11449MiMN(Constants.ED25519_BASEPOINT, this.f13057ZfxDd);
            byte[] bArrM11455xJ = m11455xJ(bArr);
            try {
                byte[] bArr4 = this.f13062xJ;
                System.arraycopy(bArrM11455xJ, 0, bArr4, 0, bArr4.length);
                byteArray = C0186Scalar.fromBytesModOrderWide(bArrM11455xJ).toByteArray();
                try {
                    byte[] bArrM11460lgHUyS = m11460lgHUyS(byteArray);
                    try {
                        byte[] bArr5 = this.f13055JHa;
                        System.arraycopy(bArrM11460lgHUyS, 0, bArr5, 0, bArr5.length);
                        Arrays.fill(bArrM11455xJ, (byte) 0);
                        byte[] byteArray2 = edwardsPointM11449MiMN.m2108add(m11449MiMN(this.f13061wA == EnumC3476c7.Alice ? f13051rkYL : f13050qGY, this.f13055JHa)).compress().toByteArray();
                        try {
                            try {
                                Ed25519PublicKey.fromByteArray(byteArray2);
                                byte[] bArr6 = this.f13056KLFTb;
                                System.arraycopy(byteArray2, 0, bArr6, 0, bArr6.length);
                                this.f13060qdMbNW = wA.MsgGenerated;
                                return (byte[]) this.f13056KLFTb.clone();
                            } finally {
                                Arrays.fill(byteArray2, (byte) 0);
                            }
                        } catch (InvalidEncodingException e) {
                            throw new IllegalStateException("Generated point cannot be encoded properly", e);
                        }
                    } finally {
                        Arrays.fill(bArrM11460lgHUyS, (byte) 0);
                    }
                } finally {
                    Arrays.fill(byteArray, (byte) 0);
                }
            } catch (Throwable th) {
                Arrays.fill(bArrM11455xJ, (byte) 0);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: Pq */
    public byte[] m11457Pq(byte[] bArr) throws Throwable {
        byte[] bArr2;
        try {
            if (this.f13054ETF) {
                throw new IllegalStateException("The context was destroyed.");
            }
            if (this.f13060qdMbNW != wA.MsgGenerated) {
                throw new IllegalStateException("Invalid state: " + this.f13060qdMbNW);
            }
            if (bArr == null || bArr.length != 32) {
                throw new IllegalArgumentException("Invalid peer message.");
            }
            bArr2 = (byte[]) bArr.clone();
            try {
                try {
                    Ed25519PublicKey.fromByteArray(bArr2);
                    try {
                        EdwardsPoint edwardsPointDecompress = new CompressedEdwardsY(bArr2).decompress();
                        EnumC3476c7 enumC3476c7 = this.f13061wA;
                        EnumC3476c7 enumC3476c72 = EnumC3476c7.Alice;
                        byte[] byteArray = m11449MiMN(edwardsPointDecompress.subtract(m11449MiMN(enumC3476c7 == enumC3476c72 ? f13050qGY : f13051rkYL, this.f13055JHa)), this.f13057ZfxDd).compress().toByteArray();
                        MessageDigest messageDigestM11453fehf = m11453fehf();
                        if (this.f13061wA == enumC3476c72) {
                            byte[] bArr3 = this.f13059mjFkc;
                            m11452eyqo(messageDigestM11453fehf, bArr3, bArr3.length);
                            byte[] bArr4 = this.f13052AZxh;
                            m11452eyqo(messageDigestM11453fehf, bArr4, bArr4.length);
                            byte[] bArr5 = this.f13056KLFTb;
                            m11452eyqo(messageDigestM11453fehf, bArr5, bArr5.length);
                            m11452eyqo(messageDigestM11453fehf, bArr2, 32);
                        } else {
                            byte[] bArr6 = this.f13052AZxh;
                            m11452eyqo(messageDigestM11453fehf, bArr6, bArr6.length);
                            byte[] bArr7 = this.f13059mjFkc;
                            m11452eyqo(messageDigestM11453fehf, bArr7, bArr7.length);
                            m11452eyqo(messageDigestM11453fehf, bArr2, 32);
                            byte[] bArr8 = this.f13056KLFTb;
                            m11452eyqo(messageDigestM11453fehf, bArr8, bArr8.length);
                        }
                        m11452eyqo(messageDigestM11453fehf, byteArray, byteArray.length);
                        byte[] bArr9 = this.f13062xJ;
                        m11452eyqo(messageDigestM11453fehf, bArr9, bArr9.length);
                        byte[] bArrDigest = messageDigestM11453fehf.digest();
                        byte[] bArr10 = (byte[]) bArrDigest.clone();
                        Arrays.fill(bArrDigest, (byte) 0);
                        this.f13060qdMbNW = wA.KeyGenerated;
                        Arrays.fill(byteArray, (byte) 0);
                        Arrays.fill(bArr2, (byte) 0);
                        m11458Ucbh();
                        return bArr10;
                    } catch (InvalidEncodingException e) {
                        throw new IllegalArgumentException("Point received from peer was not on the curve.", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        Arrays.fill((byte[]) null, (byte) 0);
                    }
                    if (bArr2 != null) {
                        Arrays.fill(bArr2, (byte) 0);
                    }
                    m11458Ucbh();
                    this.f13054ETF = true;
                    throw th;
                }
            } catch (InvalidEncodingException e2) {
                throw new IllegalArgumentException("Point received from peer was not on the curve.", e2);
            }
        } catch (Throwable th2) {
            th = th2;
            bArr2 = null;
        }
    }

    /* renamed from: Ucbh */
    public final void m11458Ucbh() {
        Arrays.fill(this.f13057ZfxDd, (byte) 0);
        Arrays.fill(this.f13055JHa, (byte) 0);
        Arrays.fill(this.f13062xJ, (byte) 0);
        Arrays.fill(this.f13059mjFkc, (byte) 0);
        Arrays.fill(this.f13052AZxh, (byte) 0);
        Arrays.fill(this.f13056KLFTb, (byte) 0);
    }

    /* renamed from: ZfxDd */
    public byte[] m11459ZfxDd(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Invalid password input.");
        }
        if (bArr.length > 65536) {
            throw new IllegalArgumentException("Password too large.");
        }
        byte[] bArr2 = new byte[64];
        this.f13058lgHUyS.nextBytes(bArr2);
        try {
            return m11456KLFTb(bArr, bArr2);
        } finally {
            Arrays.fill(bArr2, (byte) 0);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        destroy();
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.f13054ETF) {
            return;
        }
        this.f13054ETF = true;
        m11458Ucbh();
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.f13054ETF;
    }

    /* renamed from: lgHUyS */
    public final byte[] m11460lgHUyS(byte[] bArr) {
        mjFkc mjfkc = new mjFkc(bArr);
        mjFkc mjfkc2 = new mjFkc(f13049YoKzxo);
        mjFkc mjfkc3 = new mjFkc();
        try {
            if (!this.f13053Dt) {
                mjfkc3.m11464JHa();
                mjfkc3.m11463AZxh(mjfkc2, mjfkc3, ConstantTime.m2145equal(mjfkc.m11466ZfxDd(0) & 1, 1));
                mjfkc.m11467mjFkc(mjfkc3);
                mjfkc2.m11468wA();
                mjfkc3.m11464JHa();
                mjfkc3.m11463AZxh(mjfkc2, mjfkc3, ConstantTime.m2145equal(mjfkc.m11466ZfxDd(0) & 2, 2));
                mjfkc.m11467mjFkc(mjfkc3);
                mjfkc2.m11468wA();
                mjfkc3.m11464JHa();
                mjfkc3.m11463AZxh(mjfkc2, mjfkc3, ConstantTime.m2145equal(mjfkc.m11466ZfxDd(0) & 4, 4));
                mjfkc.m11467mjFkc(mjfkc3);
            }
            byte[] bArr2 = (byte[]) mjfkc.m11465KLFTb().clone();
            mjfkc.m11464JHa();
            mjfkc2.m11464JHa();
            mjfkc3.m11464JHa();
            return bArr2;
        } catch (Throwable th) {
            mjfkc.m11464JHa();
            mjfkc2.m11464JHa();
            mjfkc3.m11464JHa();
            throw th;
        }
    }

    public C3409b7(EnumC3476c7 enumC3476c7, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.f13057ZfxDd = new byte[32];
        this.f13056KLFTb = new byte[32];
        this.f13055JHa = new byte[32];
        this.f13062xJ = new byte[64];
        this.f13053Dt = false;
        this.f13054ETF = false;
        if (enumC3476c7 == null) {
            throw new IllegalArgumentException("Role must not be null.");
        }
        if (bArr == null || bArr2 == null) {
            throw new IllegalArgumentException("Participant names must not be null.");
        }
        if (bArr.length > 4096 || bArr2.length > 4096) {
            throw new IllegalArgumentException("Participant name too large.");
        }
        this.f13061wA = enumC3476c7;
        this.f13059mjFkc = (byte[]) bArr.clone();
        this.f13052AZxh = (byte[]) bArr2.clone();
        this.f13060qdMbNW = wA.Init;
        this.f13058lgHUyS = secureRandom == null ? AZxh.f13063mjFkc : secureRandom;
    }

    /* renamed from: o.b7$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public final byte[] f13064mjFkc;

        public mjFkc(byte[] bArr) {
            byte[] bArr2 = new byte[32];
            this.f13064mjFkc = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 32);
        }

        /* renamed from: AZxh */
        public void m11463AZxh(mjFkc mjfkc, mjFkc mjfkc2, long j) {
            int i = (int) (-((j | (-j)) >>> 63));
            for (int i2 = 0; i2 < 32; i2++) {
                this.f13064mjFkc[i2] = (byte) ((mjfkc.f13064mjFkc[i2] & C1126UByte.MAX_VALUE & i) | (mjfkc2.f13064mjFkc[i2] & C1126UByte.MAX_VALUE & (~i)));
            }
        }

        /* renamed from: JHa */
        public void m11464JHa() {
            Arrays.fill(this.f13064mjFkc, (byte) 0);
        }

        /* renamed from: KLFTb */
        public byte[] m11465KLFTb() {
            return this.f13064mjFkc;
        }

        /* renamed from: ZfxDd */
        public byte m11466ZfxDd(int i) {
            return this.f13064mjFkc[i];
        }

        /* renamed from: mjFkc */
        public mjFkc m11467mjFkc(mjFkc mjfkc) {
            int i = 0;
            for (int i2 = 0; i2 < 32; i2++) {
                int i3 = mjfkc.f13064mjFkc[i2] & C1126UByte.MAX_VALUE;
                byte[] bArr = this.f13064mjFkc;
                int i4 = i3 + (bArr[i2] & C1126UByte.MAX_VALUE) + i;
                bArr[i2] = (byte) i4;
                i = i4 >>> 8;
            }
            return this;
        }

        /* renamed from: wA */
        public mjFkc m11468wA() {
            int i = 0;
            int i2 = 0;
            while (i < 32) {
                byte[] bArr = this.f13064mjFkc;
                byte b = bArr[i];
                int i3 = (b & C1126UByte.MAX_VALUE) >>> 7;
                bArr[i] = (byte) (i2 | (b << 1));
                i++;
                i2 = i3;
            }
            return this;
        }

        public mjFkc() {
            this.f13064mjFkc = new byte[32];
        }
    }
}
