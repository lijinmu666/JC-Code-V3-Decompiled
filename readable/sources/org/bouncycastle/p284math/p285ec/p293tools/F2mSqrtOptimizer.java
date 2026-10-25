package org.bouncycastle.p284math.p285ec.p293tools;

import java.math.BigInteger;
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
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class F2mSqrtOptimizer {
    private static List enumToList(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    private static void implPrintRootZ(AbstractC5817ECCurve abstractC5817ECCurve) {
        ECFieldElement eCFieldElementFromBigInteger = abstractC5817ECCurve.fromBigInteger(BigInteger.valueOf(2L));
        ECFieldElement eCFieldElementMo16317sqrt = eCFieldElementFromBigInteger.mo16317sqrt();
        System.out.println(C6250Strings.toUpperCase(eCFieldElementMo16317sqrt.toBigInteger().toString(16)));
        if (!eCFieldElementMo16317sqrt.mo16318square().equals(eCFieldElementFromBigInteger)) {
            throw new IllegalStateException("Optimized-sqrt sanity check failed");
        }
    }

    /* renamed from: main */
    public static void m16872main(String[] strArr) {
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
                    implPrintRootZ(curve);
                }
            }
        }
    }

    public static void printRootZ(AbstractC5817ECCurve abstractC5817ECCurve) {
        if (!ECAlgorithms.isF2mCurve(abstractC5817ECCurve)) {
            throw new IllegalArgumentException("Sqrt optimization only defined over characteristic-2 fields");
        }
        implPrintRootZ(abstractC5817ECCurve);
    }
}
