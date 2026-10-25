package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Properties;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
abstract class LowmcConstants {

    /* renamed from: KMatrix */
    protected KMatrices f23966KMatrix;
    protected KMatrices KMatrix_full;
    protected KMatrices KMatrix_inv;

    /* renamed from: LMatrix */
    protected KMatrices f23967LMatrix;
    protected KMatrices LMatrix_full;
    protected KMatrices LMatrix_inv;
    protected KMatrices RConstants;
    protected KMatrices RConstants_full;
    protected int[] keyMatrices;
    protected int[] keyMatrices_full;
    protected int[] keyMatrices_inv;
    protected int[] linearMatrices;
    protected int[] linearMatrices_full;
    protected int[] linearMatrices_inv;
    protected int[] roundConstants;
    protected int[] roundConstants_full;

    /* renamed from: GET_MAT */
    private KMatricesWithPointer m18084GET_MAT(KMatrices kMatrices, int i) {
        KMatricesWithPointer kMatricesWithPointer = new KMatricesWithPointer(kMatrices);
        kMatricesWithPointer.setMatrixPointer(i * kMatricesWithPointer.m18083getSize());
        return kMatricesWithPointer;
    }

    public static int[] ReadFromProperty(Properties properties, String str, int i) {
        byte[] bArrM18339decode = C6255Hex.m18339decode(removeCommas(properties.getProperty(str)));
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < bArrM18339decode.length / 4; i2++) {
            iArr[i2] = AbstractC6245Pack.littleEndianToInt(bArrM18339decode, i2 * 4);
        }
        return iArr;
    }

    public static int[] readArray(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 != i; i2++) {
            iArr[i2] = dataInputStream.readInt();
        }
        return iArr;
    }

    private static byte[] removeCommas(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != str.length(); i++) {
            if (str.charAt(i) != ',') {
                byteArrayOutputStream.write(str.charAt(i));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /* renamed from: KMatrix */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KMatricesWithPointer m18085KMatrix(PicnicEngine picnicEngine, int i) {
        KMatrices kMatrices;
        int i2 = picnicEngine.stateSizeBits;
        if (i2 != 128) {
            if (i2 != 129) {
                if (i2 == 192) {
                    if (picnicEngine.numRounds != 4) {
                        kMatrices = this.f23966KMatrix;
                    }
                } else if (i2 != 255) {
                    if (i2 != 256) {
                        return null;
                    }
                    kMatrices = this.f23966KMatrix;
                }
            }
            kMatrices = this.KMatrix_full;
        }
        return m18084GET_MAT(kMatrices, i);
    }

    public KMatricesWithPointer KMatrixInv(PicnicEngine picnicEngine) {
        int i = picnicEngine.stateSizeBits;
        if (i == 129 || ((i == 192 && picnicEngine.numRounds == 4) || i == 255)) {
            return m18084GET_MAT(this.KMatrix_inv, 0);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /* renamed from: LMatrix */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KMatricesWithPointer m18086LMatrix(PicnicEngine picnicEngine, int i) {
        KMatrices kMatrices;
        int i2 = picnicEngine.stateSizeBits;
        if (i2 != 128) {
            if (i2 != 129) {
                if (i2 == 192) {
                    if (picnicEngine.numRounds != 4) {
                        kMatrices = this.f23967LMatrix;
                    }
                } else if (i2 != 255) {
                    if (i2 != 256) {
                        return null;
                    }
                    kMatrices = this.f23967LMatrix;
                }
            }
            kMatrices = this.LMatrix_full;
        }
        return m18084GET_MAT(kMatrices, i);
    }

    public KMatricesWithPointer LMatrixInv(PicnicEngine picnicEngine, int i) {
        int i2 = picnicEngine.stateSizeBits;
        if (i2 == 129 || ((i2 == 192 && picnicEngine.numRounds == 4) || i2 == 255)) {
            return m18084GET_MAT(this.LMatrix_inv, i);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KMatricesWithPointer RConstant(PicnicEngine picnicEngine, int i) {
        KMatrices kMatrices;
        int i2 = picnicEngine.stateSizeBits;
        if (i2 != 128) {
            if (i2 != 129) {
                if (i2 == 192) {
                    if (picnicEngine.numRounds != 4) {
                        kMatrices = this.RConstants;
                    }
                } else if (i2 != 255) {
                    if (i2 != 256) {
                        return null;
                    }
                    kMatrices = this.RConstants;
                }
            }
            kMatrices = this.RConstants_full;
        }
        return m18084GET_MAT(kMatrices, i);
    }
}
