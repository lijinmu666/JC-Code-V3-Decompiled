package org.bouncycastle.p300oer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;

/* loaded from: classes2.dex */
public class OERDefinition {

    /* renamed from: uIntMax */
    static final BigInteger[] f22544uIntMax = {new BigInteger("256"), new BigInteger("65536"), new BigInteger("4294967296"), new BigInteger("18446744073709551616")};
    static final BigInteger[][] sIntRange = {new BigInteger[]{new BigInteger("-128"), new BigInteger("127")}, new BigInteger[]{new BigInteger("-32768"), new BigInteger("32767")}, new BigInteger[]{new BigInteger("-2147483648"), new BigInteger("2147483647")}, new BigInteger[]{new BigInteger("-9223372036854775808"), new BigInteger("9223372036854775807")}};

    public enum BaseType {
        SEQ,
        SEQ_OF,
        CHOICE,
        ENUM,
        INT,
        OCTET_STRING,
        OPAQUE,
        UTF8_STRING,
        BIT_STRING,
        NULL,
        EXTENSION,
        ENUM_ITEM,
        BOOLEAN,
        IS0646String,
        PrintableString,
        NumericString,
        BMPString,
        UniversalString,
        IA5String,
        VisibleString,
        Switch,
        Supplier
    }

    /* renamed from: org.bouncycastle.oer.OERDefinition$Builder */
    public static class C5888Builder {

        /* renamed from: aSwitch */
        protected InterfaceC5893Switch f22555aSwitch;
        protected final BaseType baseType;

        /* renamed from: block */
        protected int f22556block;
        protected ASN1Encodable defaultValue;
        protected ElementSupplier elementSupplier;
        protected BigInteger enumValue;

        /* renamed from: inScope */
        protected Boolean f22557inScope;

        /* renamed from: label */
        protected String f22558label;
        protected BigInteger lowerBound;
        protected boolean mayRecurse;
        protected C5888Builder placeholderValue;
        protected String typeName;
        protected BigInteger upperBound;
        protected ArrayList<C5888Builder> children = new ArrayList<>();
        protected boolean explicit = true;
        protected ArrayList<ASN1Encodable> validSwitchValues = new ArrayList<>();
        protected Map<String, ElementSupplier> supplierMap = new HashMap();
        private final ItemProvider defaultItemProvider = new ItemProvider() { // from class: org.bouncycastle.oer.OERDefinition.Builder.1
            @Override // org.bouncycastle.oer.OERDefinition.ItemProvider
            public C5888Builder existingChild(int i, C5888Builder c5888Builder) {
                return c5888Builder.m17144copy(C5888Builder.this.defaultItemProvider);
            }
        };

        public C5888Builder(BaseType baseType) {
            this.baseType = baseType;
        }

        public void addExtensions(C5888Builder c5888Builder, ExtensionList extensionList) {
            if (extensionList.isEmpty()) {
                C5888Builder c5888Builder2 = new C5888Builder(BaseType.EXTENSION);
                c5888Builder2.f22556block = extensionList.f22561block;
                c5888Builder.children.add(c5888Builder2);
                return;
            }
            for (Object obj : extensionList) {
                if (obj instanceof OptionalList) {
                    addOptionals(c5888Builder, extensionList.f22561block, (OptionalList) obj);
                } else {
                    C5888Builder c5888BuilderM17153wrap = m17153wrap(true, obj);
                    c5888BuilderM17153wrap.f22556block = extensionList.f22561block;
                    c5888Builder.children.add(c5888BuilderM17153wrap);
                }
            }
        }

        public void addOptionals(C5888Builder c5888Builder, int i, OptionalList optionalList) {
            for (Object obj : optionalList) {
                if (obj instanceof ExtensionList) {
                    addExtensions(c5888Builder, (ExtensionList) obj);
                } else {
                    C5888Builder c5888BuilderM17153wrap = m17153wrap(false, obj);
                    c5888BuilderM17153wrap.f22556block = i;
                    c5888Builder.children.add(c5888BuilderM17153wrap);
                }
            }
        }

        /* renamed from: block */
        public C5888Builder m17145block(int i) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.f22556block = i;
            return c5888BuilderM17147copy;
        }

        /* renamed from: build */
        public C5887Element m17146build() {
            ArrayList arrayList = new ArrayList();
            if (this.baseType == BaseType.ENUM) {
                HashSet hashSet = new HashSet();
                int i = 0;
                for (int i2 = 0; i2 < this.children.size(); i2++) {
                    C5888Builder c5888Builder = this.children.get(i2);
                    if (c5888Builder.enumValue == null) {
                        c5888Builder.enumValue = BigInteger.valueOf(i);
                        i++;
                    }
                    if (hashSet.contains(c5888Builder.enumValue)) {
                        throw new IllegalStateException("duplicate enum value at index " + i2);
                    }
                    hashSet.add(c5888Builder.enumValue);
                }
            }
            Iterator<C5888Builder> it = this.children.iterator();
            boolean z = false;
            int i3 = 0;
            boolean z2 = false;
            while (it.hasNext()) {
                C5888Builder next = it.next();
                if (!z && next.f22556block > 0) {
                    z = true;
                }
                if (!next.explicit) {
                    i3++;
                }
                if (!z2 && next.defaultValue != null) {
                    z2 = true;
                }
                arrayList.add(next.m17146build());
            }
            BaseType baseType = this.baseType;
            ASN1Encodable aSN1Encodable = this.defaultValue;
            return new C5887Element(baseType, arrayList, aSN1Encodable == null && this.explicit, this.f22558label, this.lowerBound, this.upperBound, z, this.enumValue, aSN1Encodable, this.f22555aSwitch, this.validSwitchValues.isEmpty() ? null : this.validSwitchValues, this.elementSupplier, this.mayRecurse, this.typeName, this.supplierMap.isEmpty() ? null : this.supplierMap, this.f22556block, i3, z2);
        }

        /* renamed from: copy */
        public C5888Builder m17147copy() {
            return m17144copy(this.defaultItemProvider);
        }

        public C5888Builder decodeSwitch(InterfaceC5893Switch interfaceC5893Switch) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.f22555aSwitch = interfaceC5893Switch;
            return c5888BuilderM17147copy;
        }

        public C5888Builder defaultValue(ASN1Encodable aSN1Encodable) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.defaultValue = aSN1Encodable;
            return c5888BuilderM17147copy;
        }

        public C5888Builder elementSupplier(ElementSupplier elementSupplier) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.elementSupplier = elementSupplier;
            return c5888BuilderM17147copy;
        }

        public C5888Builder enumValue(BigInteger bigInteger) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            this.enumValue = bigInteger;
            return c5888BuilderM17147copy;
        }

        public C5888Builder explicit(boolean z) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.explicit = z;
            return c5888BuilderM17147copy;
        }

        public C5888Builder fixedSize(long j) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.upperBound = BigInteger.valueOf(j);
            c5888BuilderM17147copy.lowerBound = BigInteger.valueOf(j);
            return c5888BuilderM17147copy;
        }

        /* renamed from: inScope */
        public C5888Builder m17148inScope(boolean z) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.f22557inScope = Boolean.valueOf(z);
            return c5888BuilderM17147copy;
        }

        /* renamed from: items */
        public C5888Builder m17149items(Object... objArr) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            for (int i = 0; i != objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof ExtensionList) {
                    addExtensions(c5888BuilderM17147copy, (ExtensionList) obj);
                } else if (obj instanceof OptionalList) {
                    addOptionals(c5888BuilderM17147copy, c5888BuilderM17147copy.f22556block, (OptionalList) obj);
                } else if (obj.getClass().isArray()) {
                    int i2 = 0;
                    while (true) {
                        Object[] objArr2 = (Object[]) obj;
                        if (i2 < objArr2.length) {
                            c5888BuilderM17147copy.children.add(m17153wrap(true, objArr2[i2]));
                            i2++;
                        }
                    }
                } else {
                    c5888BuilderM17147copy.children.add(m17153wrap(true, obj));
                }
            }
            return c5888BuilderM17147copy;
        }

        /* renamed from: label */
        public C5888Builder mo17150label(String str) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.f22558label = str;
            return c5888BuilderM17147copy;
        }

        public C5888Builder labelPrefix(String str) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.f22558label = str + " " + this.f22558label;
            return c5888BuilderM17147copy;
        }

        public C5888Builder limitScopeTo(String... strArr) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(strArr));
            ArrayList<C5888Builder> arrayList = new ArrayList<>();
            Iterator<C5888Builder> it = this.children.iterator();
            while (it.hasNext()) {
                C5888Builder next = it.next();
                arrayList.add(next.m17147copy().m17148inScope(hashSet.contains(next.f22558label)));
            }
            c5888BuilderM17147copy.children = arrayList;
            return c5888BuilderM17147copy;
        }

        public C5888Builder mayRecurse(boolean z) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.mayRecurse = z;
            return c5888BuilderM17147copy;
        }

        /* renamed from: range */
        public C5888Builder m17151range(long j, long j2, ASN1Encodable aSN1Encodable) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.lowerBound = BigInteger.valueOf(j);
            c5888BuilderM17147copy.upperBound = BigInteger.valueOf(j2);
            c5888BuilderM17147copy.defaultValue = aSN1Encodable;
            return c5888BuilderM17147copy;
        }

        public C5888Builder rangeToMAXFrom(long j) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.lowerBound = BigInteger.valueOf(j);
            c5888BuilderM17147copy.upperBound = null;
            return c5888BuilderM17147copy;
        }

        public C5888Builder rangeZeroTo(long j) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.upperBound = BigInteger.valueOf(j);
            c5888BuilderM17147copy.lowerBound = BigInteger.ZERO;
            return c5888BuilderM17147copy;
        }

        public C5888Builder replaceChild(final int i, final C5888Builder c5888Builder) {
            return m17144copy(new ItemProvider(this) { // from class: org.bouncycastle.oer.OERDefinition.Builder.2

                /* renamed from: this$0 */
                final /* synthetic */ C5888Builder f22560this$0;

                {
                    this.f22560this$0 = this;
                }

                @Override // org.bouncycastle.oer.OERDefinition.ItemProvider
                public C5888Builder existingChild(int i2, C5888Builder c5888Builder2) {
                    return i == i2 ? c5888Builder : c5888Builder2;
                }
            });
        }

        public C5888Builder typeName(String str) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.typeName = str;
            if (c5888BuilderM17147copy.f22558label == null) {
                c5888BuilderM17147copy.f22558label = str;
            }
            return c5888BuilderM17147copy;
        }

        public C5888Builder unbounded() {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.lowerBound = null;
            c5888BuilderM17147copy.upperBound = null;
            return c5888BuilderM17147copy;
        }

        public C5888Builder validSwitchValue(ASN1Encodable... aSN1EncodableArr) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.validSwitchValues.addAll(Arrays.asList(aSN1EncodableArr));
            return c5888BuilderM17147copy;
        }

        /* renamed from: wrap */
        public C5888Builder m17153wrap(boolean z, Object obj) {
            if (obj instanceof C5888Builder) {
                return ((C5888Builder) obj).explicit(z);
            }
            if (obj instanceof BaseType) {
                return new C5888Builder((BaseType) obj).explicit(z);
            }
            if (obj instanceof String) {
                return OERDefinition.enumItem((String) obj);
            }
            throw new IllegalStateException("Unable to wrap item in builder");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: copy */
        public C5888Builder m17144copy(ItemProvider itemProvider) {
            C5888Builder c5888Builder = new C5888Builder(this.baseType);
            Iterator<C5888Builder> it = this.children.iterator();
            int i = 0;
            while (it.hasNext()) {
                c5888Builder.children.add(itemProvider.existingChild(i, it.next()));
                i++;
            }
            c5888Builder.explicit = this.explicit;
            c5888Builder.f22558label = this.f22558label;
            c5888Builder.upperBound = this.upperBound;
            c5888Builder.lowerBound = this.lowerBound;
            c5888Builder.defaultValue = this.defaultValue;
            c5888Builder.enumValue = this.enumValue;
            c5888Builder.f22557inScope = this.f22557inScope;
            c5888Builder.f22555aSwitch = this.f22555aSwitch;
            c5888Builder.validSwitchValues = new ArrayList<>(this.validSwitchValues);
            c5888Builder.elementSupplier = this.elementSupplier;
            c5888Builder.mayRecurse = this.mayRecurse;
            c5888Builder.typeName = this.typeName;
            c5888Builder.supplierMap = new HashMap(this.supplierMap);
            c5888Builder.f22556block = this.f22556block;
            return c5888Builder;
        }

        /* renamed from: range */
        public C5888Builder m17152range(BigInteger bigInteger, BigInteger bigInteger2) {
            C5888Builder c5888BuilderM17147copy = m17147copy();
            c5888BuilderM17147copy.lowerBound = bigInteger;
            c5888BuilderM17147copy.upperBound = bigInteger2;
            return c5888BuilderM17147copy;
        }
    }

    public static class ExtensionList extends ArrayList<Object> {

        /* renamed from: block */
        protected final int f22561block;

        public ExtensionList(int i, List<Object> list) {
            this.f22561block = i;
            addAll(list);
        }
    }

    public interface ItemProvider {
        C5888Builder existingChild(int i, C5888Builder c5888Builder);
    }

    public static class MutableBuilder extends C5888Builder {

        /* renamed from: frozen */
        private boolean f22562frozen;

        public MutableBuilder(BaseType baseType) {
            super(baseType);
            this.f22562frozen = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MutableBuilder addItemsAndFreeze(C5888Builder... c5888BuilderArr) {
            if (this.f22562frozen) {
                throw new IllegalStateException("build cannot be modified and must be copied only");
            }
            for (int i = 0; i != c5888BuilderArr.length; i++) {
                Object[] objArr = c5888BuilderArr[i];
                if (objArr.getClass().isArray()) {
                    for (Object obj : objArr) {
                        this.children.add(m17153wrap(true, obj));
                    }
                } else {
                    this.children.add(m17153wrap(true, objArr));
                }
            }
            this.f22562frozen = true;
            return this;
        }

        @Override // org.bouncycastle.p300oer.OERDefinition.C5888Builder
        /* renamed from: label */
        public MutableBuilder mo17150label(String str) {
            this.f22558label = str;
            return this;
        }
    }

    public static class OptionalList extends ArrayList<Object> {
        public OptionalList(List<Object> list) {
            addAll(list);
        }
    }

    /* renamed from: aSwitch */
    public static C5888Builder m17126aSwitch(InterfaceC5893Switch interfaceC5893Switch) {
        return new C5888Builder(BaseType.Switch).decodeSwitch(interfaceC5893Switch);
    }

    public static C5888Builder bitString(long j) {
        return new C5888Builder(BaseType.BIT_STRING).fixedSize(j);
    }

    /* renamed from: bool */
    public static C5888Builder m17127bool() {
        return new C5888Builder(BaseType.BOOLEAN);
    }

    /* renamed from: choice */
    public static C5888Builder m17128choice(Object... objArr) {
        return new C5888Builder(BaseType.CHOICE).m17149items(objArr);
    }

    public static C5888Builder deferred(ElementSupplier elementSupplier) {
        return new C5888Builder(BaseType.Supplier).elementSupplier(elementSupplier);
    }

    public static C5888Builder enumItem(String str) {
        return new C5888Builder(BaseType.ENUM_ITEM).mo17150label(str);
    }

    public static C5888Builder enumeration(Object... objArr) {
        return new C5888Builder(BaseType.ENUM).m17149items(objArr);
    }

    public static ExtensionList extension(int i, Object... objArr) {
        return new ExtensionList(i, Arrays.asList(objArr));
    }

    public static C5888Builder ia5String() {
        return new C5888Builder(BaseType.IA5String);
    }

    /* renamed from: integer */
    public static C5888Builder m17129integer() {
        return new C5888Builder(BaseType.INT);
    }

    public static C5888Builder nullValue() {
        return new C5888Builder(BaseType.NULL);
    }

    /* renamed from: octets */
    public static C5888Builder m17134octets() {
        return new C5888Builder(BaseType.OCTET_STRING).unbounded();
    }

    /* renamed from: opaque */
    public static C5888Builder m17137opaque() {
        return new C5888Builder(BaseType.OPAQUE);
    }

    public static List<Object> optional(Object... objArr) {
        return new OptionalList(Arrays.asList(objArr));
    }

    public static C5888Builder placeholder() {
        return new C5888Builder(null);
    }

    /* renamed from: seq */
    public static C5888Builder m17138seq() {
        return new C5888Builder(BaseType.SEQ);
    }

    /* renamed from: seqof */
    public static C5888Builder m17140seqof(Object... objArr) {
        return new C5888Builder(BaseType.SEQ_OF).m17149items(objArr);
    }

    public static C5888Builder utf8String() {
        return new C5888Builder(BaseType.UTF8_STRING);
    }

    public static C5888Builder enumItem(String str, BigInteger bigInteger) {
        return new C5888Builder(BaseType.ENUM_ITEM).enumValue(bigInteger).mo17150label(str);
    }

    public static ExtensionList extension(Object... objArr) {
        return new ExtensionList(1, Arrays.asList(objArr));
    }

    /* renamed from: integer */
    public static C5888Builder m17130integer(long j) {
        return new C5888Builder(BaseType.INT).defaultValue(ASN1Integer.m14430valueOf(j));
    }

    /* renamed from: octets */
    public static C5888Builder m17135octets(int i) {
        return new C5888Builder(BaseType.OCTET_STRING).fixedSize(i);
    }

    /* renamed from: seq */
    public static C5888Builder m17139seq(Object... objArr) {
        return new C5888Builder(BaseType.SEQ).m17149items(objArr);
    }

    public static C5888Builder utf8String(int i) {
        return new C5888Builder(BaseType.UTF8_STRING).rangeToMAXFrom(i);
    }

    /* renamed from: integer */
    public static C5888Builder m17131integer(long j, long j2) {
        return new C5888Builder(BaseType.INT).m17152range(BigInteger.valueOf(j), BigInteger.valueOf(j2));
    }

    /* renamed from: octets */
    public static C5888Builder m17136octets(int i, int i2) {
        return new C5888Builder(BaseType.OCTET_STRING).m17152range(BigInteger.valueOf(i), BigInteger.valueOf(i2));
    }

    public static C5888Builder utf8String(int i, int i2) {
        return new C5888Builder(BaseType.UTF8_STRING).m17152range(BigInteger.valueOf(i), BigInteger.valueOf(i2));
    }

    /* renamed from: integer */
    public static C5888Builder m17132integer(long j, long j2, ASN1Encodable aSN1Encodable) {
        return new C5888Builder(BaseType.INT).m17151range(j, j2, aSN1Encodable);
    }

    /* renamed from: integer */
    public static C5888Builder m17133integer(BigInteger bigInteger, BigInteger bigInteger2) {
        return new C5888Builder(BaseType.INT).m17152range(bigInteger, bigInteger2);
    }
}
