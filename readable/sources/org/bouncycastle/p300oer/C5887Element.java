package org.bouncycastle.p300oer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p300oer.OERDefinition;
import org.conscrypt.BuildConfig;

/* renamed from: org.bouncycastle.oer.Element */
/* loaded from: classes2.dex */
public class C5887Element {

    /* renamed from: aSwitch */
    private final InterfaceC5893Switch f22540aSwitch;
    private final OERDefinition.BaseType baseType;

    /* renamed from: block */
    private final int f22541block;
    private final List<C5887Element> children;
    private final ASN1Encodable defaultValue;
    private final boolean defaultValuesInChildren;
    private final ElementSupplier elementSupplier;
    private final BigInteger enumValue;
    private final boolean explicit;
    private final boolean extensionsInDefinition;

    /* renamed from: label */
    private final String f22542label;
    private final BigInteger lowerBound;
    private final boolean mayRecurse;
    private List<C5887Element> optionalChildrenInOrder;
    private final int optionals;

    /* renamed from: parent */
    private C5887Element f22543parent;
    private final Map<String, ElementSupplier> supplierMap;
    private final String typeName;
    private final BigInteger upperBound;
    private List<ASN1Encodable> validSwitchValues;

    public C5887Element(C5887Element c5887Element, C5887Element c5887Element2) {
        this.baseType = c5887Element.baseType;
        ArrayList arrayList = new ArrayList(c5887Element.children);
        this.children = arrayList;
        this.explicit = c5887Element.explicit;
        this.f22542label = c5887Element.f22542label;
        this.lowerBound = c5887Element.lowerBound;
        this.upperBound = c5887Element.upperBound;
        this.extensionsInDefinition = c5887Element.extensionsInDefinition;
        this.enumValue = c5887Element.enumValue;
        this.defaultValue = c5887Element.defaultValue;
        this.f22540aSwitch = c5887Element.f22540aSwitch;
        this.validSwitchValues = c5887Element.validSwitchValues;
        this.elementSupplier = c5887Element.elementSupplier;
        this.mayRecurse = c5887Element.mayRecurse;
        this.typeName = c5887Element.typeName;
        this.supplierMap = c5887Element.supplierMap;
        this.f22543parent = c5887Element2;
        this.f22541block = c5887Element.f22541block;
        this.optionals = c5887Element.optionals;
        this.defaultValuesInChildren = c5887Element.defaultValuesInChildren;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C5887Element) it.next()).f22543parent = this;
        }
    }

    public static C5887Element expandDeferredDefinition(C5887Element c5887Element, C5887Element c5887Element2) {
        ElementSupplier elementSupplier = c5887Element.elementSupplier;
        if (elementSupplier == null) {
            return c5887Element;
        }
        C5887Element c5887ElementMo17122build = elementSupplier.mo17122build();
        return c5887ElementMo17122build.getParent() != c5887Element2 ? new C5887Element(c5887ElementMo17122build, c5887Element2) : c5887ElementMo17122build;
    }

    public String appendLabel(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String label = getLabel();
        String str2 = BuildConfig.f24315FLAVOR;
        sb.append(label == null ? BuildConfig.f24315FLAVOR : getLabel());
        if (isExplicit()) {
            str2 = " (E)";
        }
        sb.append(str2);
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    public boolean canBeNegative() {
        return getLowerBound() != null && BigInteger.ZERO.compareTo(getLowerBound()) > 0;
    }

    /* renamed from: equals */
    public boolean m17123equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5887Element c5887Element = (C5887Element) obj;
        if (this.explicit != c5887Element.explicit || this.extensionsInDefinition != c5887Element.extensionsInDefinition || this.defaultValuesInChildren != c5887Element.defaultValuesInChildren || this.mayRecurse != c5887Element.mayRecurse || this.optionals != c5887Element.optionals || this.f22541block != c5887Element.f22541block || this.baseType != c5887Element.baseType) {
            return false;
        }
        List<C5887Element> list = this.children;
        if (list == null ? c5887Element.children != null : !list.equals(c5887Element.children)) {
            return false;
        }
        String str = this.f22542label;
        if (str == null ? c5887Element.f22542label != null : !str.equals(c5887Element.f22542label)) {
            return false;
        }
        BigInteger bigInteger = this.lowerBound;
        if (bigInteger == null ? c5887Element.lowerBound != null : !bigInteger.equals(c5887Element.lowerBound)) {
            return false;
        }
        BigInteger bigInteger2 = this.upperBound;
        if (bigInteger2 == null ? c5887Element.upperBound != null : !bigInteger2.equals(c5887Element.upperBound)) {
            return false;
        }
        BigInteger bigInteger3 = this.enumValue;
        if (bigInteger3 == null ? c5887Element.enumValue != null : !bigInteger3.equals(c5887Element.enumValue)) {
            return false;
        }
        ASN1Encodable aSN1Encodable = this.defaultValue;
        if (aSN1Encodable == null ? c5887Element.defaultValue != null : !aSN1Encodable.equals(c5887Element.defaultValue)) {
            return false;
        }
        InterfaceC5893Switch interfaceC5893Switch = this.f22540aSwitch;
        if (interfaceC5893Switch == null ? c5887Element.f22540aSwitch != null : !interfaceC5893Switch.equals(c5887Element.f22540aSwitch)) {
            return false;
        }
        List<C5887Element> list2 = this.optionalChildrenInOrder;
        if (list2 == null ? c5887Element.optionalChildrenInOrder != null : !list2.equals(c5887Element.optionalChildrenInOrder)) {
            return false;
        }
        List<ASN1Encodable> list3 = this.validSwitchValues;
        if (list3 == null ? c5887Element.validSwitchValues != null : !list3.equals(c5887Element.validSwitchValues)) {
            return false;
        }
        ElementSupplier elementSupplier = this.elementSupplier;
        if (elementSupplier == null ? c5887Element.elementSupplier != null : !elementSupplier.equals(c5887Element.elementSupplier)) {
            return false;
        }
        String str2 = this.typeName;
        if (str2 == null ? c5887Element.typeName != null : !str2.equals(c5887Element.typeName)) {
            return false;
        }
        Map<String, ElementSupplier> map = this.supplierMap;
        if (map != null) {
            if (!map.equals(c5887Element.supplierMap)) {
                return true;
            }
        } else if (c5887Element.supplierMap != null) {
            return true;
        }
        return false;
    }

    public OERDefinition.BaseType getBaseType() {
        return this.baseType;
    }

    public int getBlock() {
        return this.f22541block;
    }

    public List<C5887Element> getChildren() {
        return this.children;
    }

    public ASN1Encodable getDefaultValue() {
        return this.defaultValue;
    }

    public String getDerivedTypeName() {
        String str = this.typeName;
        return str != null ? str : this.baseType.name();
    }

    public ElementSupplier getElementSupplier() {
        return this.elementSupplier;
    }

    public BigInteger getEnumValue() {
        return this.enumValue;
    }

    public C5887Element getFirstChid() {
        return getChildren().get(0);
    }

    public String getLabel() {
        return this.f22542label;
    }

    public BigInteger getLowerBound() {
        return this.lowerBound;
    }

    public List<C5887Element> getOptionalChildrenInOrder() {
        return this.optionalChildrenInOrder;
    }

    public int getOptionals() {
        return this.optionals;
    }

    public C5887Element getParent() {
        return this.f22543parent;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public BigInteger getUpperBound() {
        return this.upperBound;
    }

    public List<ASN1Encodable> getValidSwitchValues() {
        return this.validSwitchValues;
    }

    public InterfaceC5893Switch getaSwitch() {
        return this.f22540aSwitch;
    }

    public boolean hasDefaultChildren() {
        return this.defaultValuesInChildren;
    }

    public boolean hasPopulatedExtension() {
        return this.extensionsInDefinition;
    }

    public int hashCode() {
        OERDefinition.BaseType baseType = this.baseType;
        int iHashCode = (baseType != null ? baseType.hashCode() : 0) * 31;
        List<C5887Element> list = this.children;
        int iHashCode2 = (((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + (this.explicit ? 1 : 0)) * 31;
        String str = this.f22542label;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        BigInteger bigInteger = this.lowerBound;
        int iHashCode4 = (iHashCode3 + (bigInteger != null ? bigInteger.hashCode() : 0)) * 31;
        BigInteger bigInteger2 = this.upperBound;
        int iHashCode5 = (((iHashCode4 + (bigInteger2 != null ? bigInteger2.hashCode() : 0)) * 31) + (this.extensionsInDefinition ? 1 : 0)) * 31;
        BigInteger bigInteger3 = this.enumValue;
        int iHashCode6 = (iHashCode5 + (bigInteger3 != null ? bigInteger3.hashCode() : 0)) * 31;
        ASN1Encodable aSN1Encodable = this.defaultValue;
        int iHashCode7 = (iHashCode6 + (aSN1Encodable != null ? aSN1Encodable.hashCode() : 0)) * 31;
        InterfaceC5893Switch interfaceC5893Switch = this.f22540aSwitch;
        int iHashCode8 = (((iHashCode7 + (interfaceC5893Switch != null ? interfaceC5893Switch.hashCode() : 0)) * 31) + (this.defaultValuesInChildren ? 1 : 0)) * 31;
        List<C5887Element> list2 = this.optionalChildrenInOrder;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ASN1Encodable> list3 = this.validSwitchValues;
        int iHashCode10 = (iHashCode9 + (list3 != null ? list3.hashCode() : 0)) * 31;
        ElementSupplier elementSupplier = this.elementSupplier;
        int iHashCode11 = (((iHashCode10 + (elementSupplier != null ? elementSupplier.hashCode() : 0)) * 31) + (this.mayRecurse ? 1 : 0)) * 31;
        String str2 = this.typeName;
        int iHashCode12 = (iHashCode11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, ElementSupplier> map = this.supplierMap;
        return ((((iHashCode12 + (map != null ? map.hashCode() : 0)) * 31) + this.optionals) * 31) + this.f22541block;
    }

    public int intBytesForRange() {
        if (getLowerBound() != null && getUpperBound() != null) {
            int i = 1;
            if (!BigInteger.ZERO.equals(getLowerBound())) {
                int i2 = 0;
                int i3 = 1;
                while (true) {
                    BigInteger[][] bigIntegerArr = OERDefinition.sIntRange;
                    if (i2 >= bigIntegerArr.length) {
                        break;
                    }
                    if (getLowerBound().compareTo(bigIntegerArr[i2][0]) >= 0 && getUpperBound().compareTo(bigIntegerArr[i2][1]) < 0) {
                        return -i3;
                    }
                    i2++;
                    i3 *= 2;
                }
            } else {
                int i4 = 0;
                while (true) {
                    BigInteger[] bigIntegerArr2 = OERDefinition.f22544uIntMax;
                    if (i4 >= bigIntegerArr2.length) {
                        break;
                    }
                    if (getUpperBound().compareTo(bigIntegerArr2[i4]) < 0) {
                        return i;
                    }
                    i4++;
                    i *= 2;
                }
            }
        }
        return 0;
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    public boolean isExtensionsInDefinition() {
        return this.extensionsInDefinition;
    }

    public boolean isFixedLength() {
        return getLowerBound() != null && getLowerBound().equals(getUpperBound());
    }

    public boolean isLowerRangeZero() {
        return BigInteger.ZERO.equals(getLowerBound());
    }

    public boolean isMayRecurse() {
        return this.mayRecurse;
    }

    public boolean isUnbounded() {
        return getUpperBound() == null && getLowerBound() == null;
    }

    public boolean isUnsignedWithRange() {
        return isLowerRangeZero() && getUpperBound() != null && BigInteger.ZERO.compareTo(getUpperBound()) < 0;
    }

    public List<C5887Element> optionalOrDefaultChildrenInOrder() {
        List<C5887Element> optionalChildrenInOrder;
        synchronized (this) {
            try {
                if (getOptionalChildrenInOrder() == null) {
                    ArrayList arrayList = new ArrayList();
                    for (C5887Element c5887Element : getChildren()) {
                        if (!c5887Element.isExplicit() || c5887Element.getDefaultValue() != null) {
                            arrayList.add(c5887Element);
                        }
                    }
                    this.optionalChildrenInOrder = Collections.unmodifiableList(arrayList);
                }
                optionalChildrenInOrder = getOptionalChildrenInOrder();
            } catch (Throwable th) {
                throw th;
            }
        }
        return optionalChildrenInOrder;
    }

    public String rangeExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(getLowerBound() != null ? getLowerBound().toString() : "MIN");
        sb.append(" ... ");
        sb.append(getUpperBound() != null ? getUpperBound().toString() : "MAX");
        sb.append(")");
        return sb.toString();
    }

    public ElementSupplier resolveSupplier() {
        if (this.supplierMap.containsKey(this.f22542label)) {
            return this.supplierMap.get(this.f22542label);
        }
        C5887Element c5887Element = this.f22543parent;
        if (c5887Element != null) {
            return c5887Element.resolveSupplier(this.f22542label);
        }
        throw new IllegalStateException("unable to resolve: " + this.f22542label);
    }

    public String toString() {
        return "[" + this.typeName + " " + this.baseType.name() + " '" + getLabel() + "']";
    }

    public C5887Element(OERDefinition.BaseType baseType, List<C5887Element> list, boolean z, String str, BigInteger bigInteger, BigInteger bigInteger2, boolean z2, BigInteger bigInteger3, ASN1Encodable aSN1Encodable, InterfaceC5893Switch interfaceC5893Switch, List<ASN1Encodable> list2, ElementSupplier elementSupplier, boolean z3, String str2, Map<String, ElementSupplier> map, int i, int i2, boolean z4) {
        Map<String, ElementSupplier> map2 = map;
        this.baseType = baseType;
        this.children = list;
        this.explicit = z;
        this.f22542label = str;
        this.lowerBound = bigInteger;
        this.upperBound = bigInteger2;
        this.extensionsInDefinition = z2;
        this.enumValue = bigInteger3;
        this.defaultValue = aSN1Encodable;
        this.f22540aSwitch = interfaceC5893Switch;
        this.validSwitchValues = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.elementSupplier = elementSupplier;
        this.mayRecurse = z3;
        this.typeName = str2;
        this.f22541block = i;
        this.optionals = i2;
        this.defaultValuesInChildren = z4;
        this.supplierMap = map2 == null ? Collections.emptyMap() : map2;
        Iterator<C5887Element> it = list.iterator();
        while (it.hasNext()) {
            it.next().f22543parent = this;
        }
    }

    public ElementSupplier resolveSupplier(String str) {
        String str2 = this.f22542label + "." + str;
        if (this.supplierMap.containsKey(str2)) {
            return this.supplierMap.get(str2);
        }
        C5887Element c5887Element = this.f22543parent;
        if (c5887Element != null) {
            return c5887Element.resolveSupplier(str2);
        }
        throw new IllegalStateException("unable to resolve: " + str2);
    }
}
