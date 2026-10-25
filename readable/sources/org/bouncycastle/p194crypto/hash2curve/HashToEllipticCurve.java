package org.bouncycastle.p194crypto.hash2curve;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.hash2curve.p203data.AffineXY;
import org.bouncycastle.p194crypto.hash2curve.p204impl.Elligator2MapToCurve;
import org.bouncycastle.p194crypto.hash2curve.p204impl.MontgomeryCurveProcessor;
import org.bouncycastle.p194crypto.hash2curve.p204impl.NistCurveProcessor;
import org.bouncycastle.p194crypto.hash2curve.p204impl.SimplifiedShallueVanDeWoestijneMapToCurve;
import org.bouncycastle.p194crypto.hash2curve.p204impl.XmdMessageExpansion;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.p286custom.p287djb.Curve25519;
import org.bouncycastle.p284math.p285ec.p286custom.p289sec.SecP256R1Curve;
import org.bouncycastle.p284math.p285ec.p286custom.p289sec.SecP384R1Curve;
import org.bouncycastle.p284math.p285ec.p286custom.p289sec.SecP521R1Curve;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class HashToEllipticCurve {
    protected final CurveProcessor curveProcessor;
    protected final HashToField hashToField;
    protected final MapToCurve mapToCurve;

    /* renamed from: org.bouncycastle.crypto.hash2curve.HashToEllipticCurve$1 */
    public static /* synthetic */ class C53471 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile;

        static {
            int[] iArr = new int[HashToCurveProfile.m15516values().length];
            $SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile = iArr;
            try {
                iArr[HashToCurveProfile.P256_XMD_SHA_256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile[HashToCurveProfile.P384_XMD_SHA_384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile[HashToCurveProfile.P521_XMD_SHA_512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile[HashToCurveProfile.CURVE25519W_XMD_SHA_512_ELL2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HashToEllipticCurve(HashToField hashToField, MapToCurve mapToCurve, CurveProcessor curveProcessor) {
        this.curveProcessor = curveProcessor;
        this.hashToField = hashToField;
        this.mapToCurve = mapToCurve;
    }

    public static HashToEllipticCurve getInstance(HashToCurveProfile hashToCurveProfile, String str) {
        byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(str);
        int i = C53471.$SwitchMap$org$bouncycastle$crypto$hash2curve$HashToCurveProfile[hashToCurveProfile.ordinal()];
        if (i == 1) {
            SecP256R1Curve secP256R1Curve = new SecP256R1Curve();
            return new HashToEllipticCurve(new HashToField(uTF8ByteArray, secP256R1Curve, new XmdMessageExpansion(new SHA256Digest(), hashToCurveProfile.m15518getK()), hashToCurveProfile.m15519getL()), new SimplifiedShallueVanDeWoestijneMapToCurve(secP256R1Curve, hashToCurveProfile.m15520getZ()), new NistCurveProcessor());
        }
        if (i == 2) {
            SecP384R1Curve secP384R1Curve = new SecP384R1Curve();
            return new HashToEllipticCurve(new HashToField(uTF8ByteArray, secP384R1Curve, new XmdMessageExpansion(new SHA384Digest(), hashToCurveProfile.m15518getK()), hashToCurveProfile.m15519getL()), new SimplifiedShallueVanDeWoestijneMapToCurve(secP384R1Curve, hashToCurveProfile.m15520getZ()), new NistCurveProcessor());
        }
        if (i == 3) {
            SecP521R1Curve secP521R1Curve = new SecP521R1Curve();
            return new HashToEllipticCurve(new HashToField(uTF8ByteArray, secP521R1Curve, new XmdMessageExpansion(new SHA512Digest(), hashToCurveProfile.m15518getK()), hashToCurveProfile.m15519getL()), new SimplifiedShallueVanDeWoestijneMapToCurve(secP521R1Curve, hashToCurveProfile.m15520getZ()), new NistCurveProcessor());
        }
        if (i == 4) {
            Curve25519 curve25519 = new Curve25519();
            return new HashToEllipticCurve(new HashToField(uTF8ByteArray, curve25519, new XmdMessageExpansion(new SHA512Digest(), hashToCurveProfile.m15518getK()), hashToCurveProfile.m15519getL()), new Elligator2MapToCurve(curve25519, hashToCurveProfile.m15520getZ(), BigInteger.valueOf(hashToCurveProfile.m15521getmJ().intValue()), BigInteger.valueOf(hashToCurveProfile.m15522getmK().intValue())), new MontgomeryCurveProcessor(curve25519, hashToCurveProfile.m15521getmJ().intValue(), hashToCurveProfile.m15522getmK().intValue(), hashToCurveProfile.m15517getH()));
        }
        throw new IllegalArgumentException("Unsupported profile: " + hashToCurveProfile);
    }

    public AbstractC5820ECPoint encodeToCurve(byte[] bArr) {
        return this.curveProcessor.clearCofactor(this.mapToCurve.mo15524process(this.hashToField.m15523process(bArr, 1)[0][0]));
    }

    public AffineXY getAffineXY(AbstractC5820ECPoint abstractC5820ECPoint) {
        return this.curveProcessor.mapToAffineXY(abstractC5820ECPoint);
    }

    public AbstractC5820ECPoint hashToCurve(byte[] bArr) {
        BigInteger[][] bigIntegerArrM15523process = this.hashToField.m15523process(bArr, 2);
        return this.curveProcessor.clearCofactor(this.curveProcessor.mo15506add(this.mapToCurve.mo15524process(bigIntegerArrM15523process[0][0]), this.mapToCurve.mo15524process(bigIntegerArrM15523process[1][0])));
    }
}
