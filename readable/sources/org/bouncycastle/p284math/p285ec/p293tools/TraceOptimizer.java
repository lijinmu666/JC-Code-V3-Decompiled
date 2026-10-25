package org.bouncycastle.p284math.p285ec.p293tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeSet;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class TraceOptimizer {

    /* renamed from: ONE */
    private static final BigInteger f22475ONE = BigInteger.valueOf(1);

    /* renamed from: R */
    private static final SecureRandom f22476R = new SecureRandom();

    private static int calculateTrace(ECFieldElement eCFieldElement) {
        int fieldSize = eCFieldElement.getFieldSize();
        int iBitLength = Integers.bitLength(fieldSize) - 1;
        ECFieldElement eCFieldElementMo16310add = eCFieldElement;
        int i = 1;
        while (iBitLength > 0) {
            eCFieldElementMo16310add = eCFieldElementMo16310add.squarePow(i).mo16310add(eCFieldElementMo16310add);
            iBitLength--;
            i = fieldSize >>> iBitLength;
            if ((i & 1) != 0) {
                eCFieldElementMo16310add = eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElement);
            }
        }
        if (eCFieldElementMo16310add.mo16315isZero()) {
            return 0;
        }
        if (eCFieldElementMo16310add.mo16314isOne()) {
            return 1;
        }
        throw new IllegalStateException("Internal error in trace calculation");
    }

    private static List enumToList(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static void implPrintNonZeroTraceBits(AbstractC5817ECCurve abstractC5817ECCurve) {
        PrintStream printStream;
        StringBuilder sb;
        int fieldSize = abstractC5817ECCurve.getFieldSize();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fieldSize; i++) {
            if ((i & 1) != 0 || i == 0) {
                if (calculateTrace(abstractC5817ECCurve.fromBigInteger(f22475ONE.shiftLeft(i))) != 0) {
                    arrayList.add(Integers.m18296valueOf(i));
                    printStream = System.out;
                    sb = new StringBuilder();
                    sb.append(" ");
                    sb.append(i);
                    printStream.print(sb.toString());
                }
            } else if (arrayList.contains(Integers.m18296valueOf(i >>> 1))) {
                arrayList.add(Integers.m18296valueOf(i));
                printStream = System.out;
                sb = new StringBuilder();
                sb.append(" ");
                sb.append(i);
                printStream.print(sb.toString());
            }
        }
        System.out.println();
        for (int i2 = 0; i2 < 1000; i2++) {
            BigInteger bigInteger = new BigInteger(fieldSize, f22476R);
            int iCalculateTrace = calculateTrace(abstractC5817ECCurve.fromBigInteger(bigInteger));
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (bigInteger.testBit(((Integer) arrayList.get(i4)).intValue())) {
                    i3 ^= 1;
                }
            }
            if (iCalculateTrace != i3) {
                throw new IllegalStateException("Optimized-trace sanity check failed");
            }
        }
    }

    /* renamed from: main */
    public static void m16873main(String[] strArr) {
        TreeSet<String> treeSet = new TreeSet(enumToList(ECNamedCurveTable.getNames()));
        treeSet.addAll(enumToList(CustomNamedCurves.getNames()));
        for (String str : treeSet) {
            X9ECParametersHolder byNameLazy = CustomNamedCurves.getByNameLazy(str);
            if (byNameLazy == null) {
                byNameLazy = ECNamedCurveTable.getByNameLazy(str);
            }
            if (byNameLazy != null) {
                AbstractC5817ECCurve curve = byNameLazy.getCurve();
                if (ECAlgorithms.isF2mCurve(curve)) {
                    System.out.print(str + ":");
                    implPrintNonZeroTraceBits(curve);
                }
            }
        }
    }

    public static void printNonZeroTraceBits(AbstractC5817ECCurve abstractC5817ECCurve) {
        if (!ECAlgorithms.isF2mCurve(abstractC5817ECCurve)) {
            throw new IllegalArgumentException("Trace only defined over characteristic-2 fields");
        }
        implPrintNonZeroTraceBits(abstractC5817ECCurve);
    }
}
