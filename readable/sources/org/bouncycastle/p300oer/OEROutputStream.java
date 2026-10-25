package org.bouncycastle.p300oer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.SwitchIndexer;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class OEROutputStream extends OutputStream {

    /* renamed from: bits */
    private static final int[] f22571bits = {1, 2, 4, 8, 16, 32, 64, 128};
    protected PrintWriter debugOutput = null;

    /* renamed from: out */
    private final OutputStream f22572out;

    /* renamed from: org.bouncycastle.oer.OEROutputStream$1 */
    public static /* synthetic */ class C58921 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType;

        static {
            int[] iArr = new int[OERDefinition.BaseType.m17143values().length];
            $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType = iArr;
            try {
                iArr[OERDefinition.BaseType.Supplier.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ_OF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.CHOICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.IA5String.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BIT_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.EXTENSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM_ITEM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BOOLEAN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public OEROutputStream(OutputStream outputStream) {
        this.f22572out = outputStream;
    }

    public static int byteLength(long j) {
        int i = 8;
        while (i > 0 && ((-72057594037927936L) & j) == 0) {
            j <<= 8;
            i--;
        }
        return i;
    }

    private void encodeLength(long j) throws IOException {
        if (j <= 127) {
            this.f22572out.write((int) j);
            return;
        }
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(BigInteger.valueOf(j));
        this.f22572out.write(bArrAsUnsignedByteArray.length | 128);
        this.f22572out.write(bArrAsUnsignedByteArray);
    }

    private void encodeQuantity(long j) throws IOException {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(BigInteger.valueOf(j));
        this.f22572out.write(bArrAsUnsignedByteArray.length);
        this.f22572out.write(bArrAsUnsignedByteArray);
    }

    public void debugPrint(String str) {
        if (this.debugOutput == null) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = -1;
        for (int i2 = 0; i2 != stackTrace.length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement.getMethodName().equals("debugPrint")) {
                i = 0;
            } else if (stackTraceElement.getClassName().contains("OERInput")) {
                i++;
            }
        }
        while (true) {
            PrintWriter printWriter = this.debugOutput;
            if (i <= 0) {
                printWriter.append((CharSequence) str).append((CharSequence) "\n");
                this.debugOutput.flush();
                return;
            } else {
                printWriter.append((CharSequence) "    ");
                i--;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f22572out.write(i);
    }

    public void writePlainType(ASN1Encodable aSN1Encodable, C5887Element c5887Element) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OEROutputStream oEROutputStream = new OEROutputStream(byteArrayOutputStream);
        oEROutputStream.m17168write(aSN1Encodable, c5887Element);
        oEROutputStream.flush();
        oEROutputStream.close();
        encodeLength(byteArrayOutputStream.size());
        write(byteArrayOutputStream.toByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04a3  */
    /* renamed from: write */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m17168write(ASN1Encodable aSN1Encodable, C5887Element c5887Element) {
        boolean z;
        int i;
        List<C5887Element> children;
        int i2;
        int i3;
        Enumeration objects;
        int iMo14450size;
        String str;
        byte[] bArrLongToBigEndian;
        String strAppendLabel;
        if (aSN1Encodable == OEROptional.f22567ABSENT) {
            return;
        }
        if (aSN1Encodable instanceof OEROptional) {
            m17168write(((OEROptional) aSN1Encodable).m17167get(), c5887Element);
            return;
        }
        ASN1Primitive aSN1Primitive = aSN1Encodable.toASN1Primitive();
        int i4 = 6;
        switch (C58921.$SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[c5887Element.getBaseType().ordinal()]) {
            case 1:
                m17168write(aSN1Primitive, c5887Element.getElementSupplier().mo17122build());
                return;
            case 2:
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1Primitive);
                if (c5887Element.isExtensionsInDefinition()) {
                    for (int i5 = 0; i5 < c5887Element.getChildren().size(); i5++) {
                        C5887Element c5887Element2 = c5887Element.getChildren().get(i5);
                        if (c5887Element2.getBaseType() == OERDefinition.BaseType.EXTENSION) {
                            z = false;
                            i = z ? f22571bits[7] : 0;
                        } else if (c5887Element2.getBlock() > 0 && i5 < aSN1Sequence.mo14450size() && !OEROptional.f22567ABSENT.mo14431equals(aSN1Sequence.getObjectAt(i5))) {
                            z = true;
                            if (z) {
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    i4 = 7;
                    z = false;
                    i = 0;
                }
                for (int i6 = 0; i6 < c5887Element.getChildren().size(); i6++) {
                    C5887Element c5887Element3 = c5887Element.getChildren().get(i6);
                    if (c5887Element3.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                        if (c5887Element3.getBlock() > 0) {
                            if (i4 != 7) {
                                this.f22572out.write(i);
                            }
                            children = c5887Element.getChildren();
                            i2 = 0;
                            while (i2 < children.size()) {
                                C5887Element c5887ElementMo17170result = c5887Element.getChildren().get(i2);
                                if (c5887ElementMo17170result.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                                    if (c5887ElementMo17170result.getBlock() > 0) {
                                        if (z) {
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            int i7 = 7;
                                            int i8 = 0;
                                            for (int i9 = i2; i9 < children.size(); i9++) {
                                                if (i7 < 0) {
                                                    byteArrayOutputStream.write(i8);
                                                    i7 = 7;
                                                    i8 = 0;
                                                }
                                                if (i9 < aSN1Sequence.mo14450size() && !OEROptional.f22567ABSENT.mo14431equals(aSN1Sequence.getObjectAt(i9))) {
                                                    i8 |= f22571bits[i7];
                                                }
                                                i7--;
                                            }
                                            if (i7 != 7) {
                                                byteArrayOutputStream.write(i8);
                                            }
                                            encodeLength(byteArrayOutputStream.size() + 1);
                                            if (i7 == 7) {
                                                write(0);
                                            } else {
                                                write(i7 + 1);
                                            }
                                            write(byteArrayOutputStream.toByteArray());
                                            while (i2 < children.size()) {
                                                if (i2 < aSN1Sequence.mo14450size() && !OEROptional.f22567ABSENT.mo14431equals(aSN1Sequence.getObjectAt(i2))) {
                                                    writePlainType(aSN1Sequence.getObjectAt(i2), children.get(i2));
                                                }
                                                i2++;
                                            }
                                        }
                                        this.f22572out.flush();
                                        debugPrint(c5887Element.appendLabel(BuildConfig.f24315FLAVOR));
                                        return;
                                    }
                                    ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i2);
                                    if (c5887ElementMo17170result.getaSwitch() != null) {
                                        c5887ElementMo17170result = c5887ElementMo17170result.getaSwitch().mo17170result(new SwitchIndexer.Asn1SequenceIndexer(aSN1Sequence));
                                    }
                                    if (c5887ElementMo17170result.getDefaultValue() == null || !c5887ElementMo17170result.getDefaultValue().equals(objectAt)) {
                                        m17168write(objectAt, c5887ElementMo17170result);
                                    }
                                }
                                i2++;
                            }
                            if (z) {
                            }
                            this.f22572out.flush();
                            debugPrint(c5887Element.appendLabel(BuildConfig.f24315FLAVOR));
                            return;
                        }
                        C5887Element c5887ElementExpandDeferredDefinition = C5887Element.expandDeferredDefinition(c5887Element3, c5887Element);
                        if (c5887Element.getaSwitch() != null) {
                            c5887ElementExpandDeferredDefinition = C5887Element.expandDeferredDefinition(c5887Element.getaSwitch().mo17170result(new SwitchIndexer.Asn1SequenceIndexer(aSN1Sequence)), c5887Element);
                        }
                        if (i4 < 0) {
                            this.f22572out.write(i);
                            i4 = 7;
                            i = 0;
                        }
                        ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i6);
                        if (c5887ElementExpandDeferredDefinition.isExplicit() && (objectAt2 instanceof OEROptional)) {
                            throw new IllegalStateException("absent sequence element that is required by oer definition");
                        }
                        if (!c5887ElementExpandDeferredDefinition.isExplicit()) {
                            ASN1Encodable objectAt3 = aSN1Sequence.getObjectAt(i6);
                            if (c5887ElementExpandDeferredDefinition.getDefaultValue() == null) {
                                if (objectAt2 != OEROptional.f22567ABSENT) {
                                    i3 = f22571bits[i4];
                                    i |= i3;
                                }
                                i4--;
                            } else if (objectAt3 instanceof OEROptional) {
                                OEROptional oEROptional = (OEROptional) objectAt3;
                                if (oEROptional.isDefined() && !oEROptional.m17167get().equals(c5887ElementExpandDeferredDefinition.getDefaultValue())) {
                                    i3 = f22571bits[i4];
                                    i |= i3;
                                }
                                i4--;
                            } else {
                                if (!c5887ElementExpandDeferredDefinition.getDefaultValue().equals(objectAt3)) {
                                    i3 = f22571bits[i4];
                                    i |= i3;
                                }
                                i4--;
                            }
                        }
                    }
                }
                if (i4 != 7) {
                }
                children = c5887Element.getChildren();
                i2 = 0;
                while (i2 < children.size()) {
                }
                if (z) {
                }
                this.f22572out.flush();
                debugPrint(c5887Element.appendLabel(BuildConfig.f24315FLAVOR));
                return;
            case 3:
                if (aSN1Primitive instanceof AbstractC5093ASN1Set) {
                    AbstractC5093ASN1Set abstractC5093ASN1Set = (AbstractC5093ASN1Set) aSN1Primitive;
                    objects = abstractC5093ASN1Set.getObjects();
                    iMo14450size = abstractC5093ASN1Set.m14454size();
                } else {
                    if (!(aSN1Primitive instanceof ASN1Sequence)) {
                        throw new IllegalStateException("encodable at for SEQ_OF is not a container");
                    }
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Primitive;
                    objects = aSN1Sequence2.getObjects();
                    iMo14450size = aSN1Sequence2.mo14450size();
                }
                encodeQuantity(iMo14450size);
                C5887Element c5887ElementExpandDeferredDefinition2 = C5887Element.expandDeferredDefinition(c5887Element.getFirstChid(), c5887Element);
                while (objects.hasMoreElements()) {
                    m17168write((ASN1Encodable) objects.nextElement(), c5887ElementExpandDeferredDefinition2);
                }
                this.f22572out.flush();
                debugPrint(c5887Element.appendLabel(BuildConfig.f24315FLAVOR));
                return;
            case 4:
                ASN1Primitive aSN1Primitive2 = aSN1Primitive.toASN1Primitive();
                BitBuilder bitBuilder = new BitBuilder();
                if (!(aSN1Primitive2 instanceof ASN1TaggedObject)) {
                    throw new IllegalStateException("only support tagged objects");
                }
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive2;
                int tagClass = aSN1TaggedObject.getTagClass();
                bitBuilder.writeBit(tagClass & 128).writeBit(tagClass & 64);
                int tagNo = aSN1TaggedObject.getTagNo();
                ASN1Primitive aSN1Primitive3 = aSN1TaggedObject.getBaseObject().toASN1Primitive();
                if (tagNo <= 63) {
                    bitBuilder.writeBits(tagNo, 6);
                } else {
                    bitBuilder.writeBits(255L, 6);
                    bitBuilder.write7BitBytes(tagNo);
                }
                if (this.debugOutput != null && (aSN1Primitive2 instanceof ASN1TaggedObject)) {
                    int tagClass2 = aSN1TaggedObject.getTagClass();
                    if (tagClass2 == 64) {
                        str = "AS";
                    } else if (tagClass2 == 128) {
                        str = "CS";
                    } else if (tagClass2 == 192) {
                        str = "PR";
                    }
                    debugPrint(c5887Element.appendLabel(str));
                }
                bitBuilder.writeAndClear(this.f22572out);
                C5887Element c5887ElementExpandDeferredDefinition3 = C5887Element.expandDeferredDefinition(c5887Element.getChildren().get(tagNo), c5887Element);
                if (c5887ElementExpandDeferredDefinition3.getBlock() > 0) {
                    writePlainType(aSN1Primitive3, c5887ElementExpandDeferredDefinition3);
                } else {
                    m17168write(aSN1Primitive3, c5887ElementExpandDeferredDefinition3);
                }
                this.f22572out.flush();
                return;
            case 5:
                BigInteger value = aSN1Primitive instanceof ASN1Integer ? ASN1Integer.getInstance(aSN1Primitive).getValue() : ASN1Enumerated.getInstance(aSN1Primitive).getValue();
                Iterator<C5887Element> it = c5887Element.getChildren().iterator();
                while (it.hasNext()) {
                    if (C5887Element.expandDeferredDefinition(it.next(), c5887Element).getEnumValue().equals(value)) {
                        if (value.compareTo(BigInteger.valueOf(127L)) > 0) {
                            byte[] byteArray = value.toByteArray();
                            this.f22572out.write((byteArray.length & 255) | 128);
                            this.f22572out.write(byteArray);
                        } else {
                            this.f22572out.write(value.intValue() & 127);
                        }
                        this.f22572out.flush();
                        debugPrint(c5887Element.appendLabel(c5887Element.rangeExpression()));
                        return;
                    }
                }
                throw new IllegalArgumentException("enum value " + value + " " + C6255Hex.toHexString(value.toByteArray()) + " no in defined child list");
            case 6:
                ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Primitive);
                int iIntBytesForRange = c5887Element.intBytesForRange();
                if (iIntBytesForRange > 0) {
                    byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(iIntBytesForRange, aSN1Integer.getValue());
                    if (iIntBytesForRange != 1 && iIntBytesForRange != 2 && iIntBytesForRange != 4 && iIntBytesForRange != 8) {
                        throw new IllegalStateException("unknown uint length " + iIntBytesForRange);
                    }
                    this.f22572out.write(bArrAsUnsignedByteArray);
                } else if (iIntBytesForRange < 0) {
                    BigInteger value2 = aSN1Integer.getValue();
                    if (iIntBytesForRange == -8) {
                        bArrLongToBigEndian = AbstractC6245Pack.longToBigEndian(BigIntegers.longValueExact(value2));
                    } else if (iIntBytesForRange == -4) {
                        bArrLongToBigEndian = AbstractC6245Pack.intToBigEndian(BigIntegers.intValueExact(value2));
                    } else if (iIntBytesForRange == -2) {
                        bArrLongToBigEndian = AbstractC6245Pack.shortToBigEndian(BigIntegers.shortValueExact(value2));
                    } else {
                        if (iIntBytesForRange != -1) {
                            throw new IllegalStateException("unknown twos compliment length");
                        }
                        bArrLongToBigEndian = new byte[]{BigIntegers.byteValueExact(value2)};
                    }
                    this.f22572out.write(bArrLongToBigEndian);
                } else {
                    boolean zIsLowerRangeZero = c5887Element.isLowerRangeZero();
                    BigInteger value3 = aSN1Integer.getValue();
                    byte[] bArrAsUnsignedByteArray2 = zIsLowerRangeZero ? BigIntegers.asUnsignedByteArray(value3) : value3.toByteArray();
                    encodeLength(bArrAsUnsignedByteArray2.length);
                    this.f22572out.write(bArrAsUnsignedByteArray2);
                }
                strAppendLabel = c5887Element.appendLabel(c5887Element.rangeExpression());
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 7:
                byte[] octets = ASN1OctetString.getInstance(aSN1Primitive).getOctets();
                if (!c5887Element.isFixedLength()) {
                    encodeLength(octets.length);
                }
                this.f22572out.write(octets);
                strAppendLabel = c5887Element.appendLabel(c5887Element.rangeExpression());
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 8:
                byte[] octets2 = ASN1IA5String.getInstance(aSN1Primitive).getOctets();
                if (c5887Element.isFixedLength() && c5887Element.getUpperBound().intValue() != octets2.length) {
                    throw new IOException("IA5String string length does not equal declared fixed length " + octets2.length + " " + c5887Element.getUpperBound());
                }
                if (!c5887Element.isFixedLength()) {
                    encodeLength(octets2.length);
                }
                this.f22572out.write(octets2);
                strAppendLabel = c5887Element.appendLabel(BuildConfig.f24315FLAVOR);
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 9:
                byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(ASN1UTF8String.getInstance(aSN1Primitive).getString());
                encodeLength(uTF8ByteArray.length);
                this.f22572out.write(uTF8ByteArray);
                strAppendLabel = c5887Element.appendLabel(BuildConfig.f24315FLAVOR);
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 10:
                ASN1BitString aSN1BitString = ASN1BitString.getInstance(aSN1Primitive);
                byte[] bytes = aSN1BitString.getBytes();
                if (!c5887Element.isFixedLength()) {
                    int padBits = aSN1BitString.getPadBits();
                    encodeLength(bytes.length + 1);
                    this.f22572out.write(padBits);
                }
                this.f22572out.write(bytes);
                strAppendLabel = c5887Element.appendLabel(c5887Element.rangeExpression());
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 11:
            case 13:
            default:
                return;
            case 12:
                byte[] octets3 = ASN1OctetString.getInstance(aSN1Primitive).getOctets();
                if (!c5887Element.isFixedLength()) {
                    encodeLength(octets3.length);
                }
                this.f22572out.write(octets3);
                strAppendLabel = c5887Element.appendLabel(c5887Element.rangeExpression());
                debugPrint(strAppendLabel);
                this.f22572out.flush();
                return;
            case 14:
                debugPrint(c5887Element.getLabel());
                if (ASN1Boolean.getInstance(aSN1Primitive).m14419isTrue()) {
                    this.f22572out.write(255);
                } else {
                    this.f22572out.write(0);
                }
                this.f22572out.flush();
                return;
        }
    }
}
