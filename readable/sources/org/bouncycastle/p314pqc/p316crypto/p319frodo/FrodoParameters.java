package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.KEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoMatrixGenerator;
import p094kotlin.p105jvm.internal.ShortCompanionObject;

/* loaded from: classes2.dex */
public class FrodoParameters implements KEMParameters {
    private static final short[] cdf_table1344;
    private static final short[] cdf_table640;
    private static final short[] cdf_table976;
    public static final FrodoParameters frodokem1344aes;
    public static final FrodoParameters frodokem1344shake;
    public static final FrodoParameters frodokem640aes;
    public static final FrodoParameters frodokem640shake;
    public static final FrodoParameters frodokem976aes;
    public static final FrodoParameters frodokem976shake;

    /* renamed from: B */
    private final int f23171B;

    /* renamed from: D */
    private final int f23172D;
    private final int defaultKeySize;

    /* renamed from: engine */
    private final FrodoEngine f23173engine;

    /* renamed from: n */
    private final int f23174n;

    /* renamed from: name */
    private final String f23175name;

    static {
        short[] sArr = {4643, 13363, 20579, 25843, 29227, 31145, 32103, 32525, 32689, 32745, 32762, 32766, ShortCompanionObject.MAX_VALUE};
        cdf_table640 = sArr;
        short[] sArr2 = {5638, 15915, 23689, 28571, 31116, 32217, 32613, 32731, 32760, 32766, ShortCompanionObject.MAX_VALUE};
        cdf_table976 = sArr2;
        short[] sArr3 = {9142, 23462, 30338, 32361, 32725, 32765, ShortCompanionObject.MAX_VALUE};
        cdf_table1344 = sArr3;
        frodokem640aes = new FrodoParameters("frodokem640aes", 640, 15, 2, sArr, new SHAKEDigest(128), new FrodoMatrixGenerator.Aes128MatrixGenerator(640, 32768));
        frodokem640shake = new FrodoParameters("frodokem640shake", 640, 15, 2, sArr, new SHAKEDigest(128), new FrodoMatrixGenerator.Shake128MatrixGenerator(640, 32768));
        frodokem976aes = new FrodoParameters("frodokem976aes", 976, 16, 3, sArr2, new SHAKEDigest(256), new FrodoMatrixGenerator.Aes128MatrixGenerator(976, PKIFailureInfo.notAuthorized));
        frodokem976shake = new FrodoParameters("frodokem976shake", 976, 16, 3, sArr2, new SHAKEDigest(256), new FrodoMatrixGenerator.Shake128MatrixGenerator(976, PKIFailureInfo.notAuthorized));
        frodokem1344aes = new FrodoParameters("frodokem1344aes", 1344, 16, 4, sArr3, new SHAKEDigest(256), new FrodoMatrixGenerator.Aes128MatrixGenerator(1344, PKIFailureInfo.notAuthorized));
        frodokem1344shake = new FrodoParameters("frodokem1344shake", 1344, 16, 4, sArr3, new SHAKEDigest(256), new FrodoMatrixGenerator.Shake128MatrixGenerator(1344, PKIFailureInfo.notAuthorized));
    }

    private FrodoParameters(String str, int i, int i2, int i3, short[] sArr, InterfaceC5284Xof interfaceC5284Xof, FrodoMatrixGenerator frodoMatrixGenerator) {
        this.f23175name = str;
        this.f23174n = i;
        this.f23172D = i2;
        this.f23171B = i3;
        this.defaultKeySize = i3 * 64;
        this.f23173engine = new FrodoEngine(i, i2, i3, sArr, interfaceC5284Xof, frodoMatrixGenerator);
    }

    /* renamed from: getB */
    public int m17566getB() {
        return this.f23171B;
    }

    /* renamed from: getD */
    public int m17567getD() {
        return this.f23172D;
    }

    public FrodoEngine getEngine() {
        return this.f23173engine;
    }

    /* renamed from: getN */
    public int m17568getN() {
        return this.f23174n;
    }

    /* renamed from: getName */
    public String m17569getName() {
        return this.f23175name;
    }

    public int getSessionKeySize() {
        return this.defaultKeySize;
    }
}
