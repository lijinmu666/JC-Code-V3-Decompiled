package org.bouncycastle.p300oer;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.SwitchIndexer;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.bouncycastle.p361util.p362io.C6257Streams;
import org.conscrypt.BuildConfig;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class OERInputStream extends FilterInputStream {

    /* renamed from: bits */
    private static final int[] f22563bits = {1, 2, 4, 8, 16, 32, 64, 128};

    /* renamed from: bitsR */
    private static final int[] f22564bitsR = {128, 64, 32, 16, 8, 4, 2, 1};
    protected PrintWriter debugOutput;
    protected PrintWriter debugStream;
    private int maxByteAllocation;

    /* renamed from: org.bouncycastle.oer.OERInputStream$1 */
    public static /* synthetic */ class C58891 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType;

        static {
            int[] iArr = new int[OERDefinition.BaseType.m17143values().length];
            $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType = iArr;
            try {
                iArr[OERDefinition.BaseType.OPAQUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.Switch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.Supplier.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ_OF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.CHOICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.INT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.IA5String.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BIT_STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.NULL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.EXTENSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BOOLEAN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* renamed from: org.bouncycastle.oer.OERInputStream$Choice */
    public static class C5890Choice extends OERInputStream {
        final int preamble;

        /* renamed from: tag */
        final int f22565tag;
        final int tagClass;

        public C5890Choice(InputStream inputStream) throws IOException {
            int i;
            super(inputStream);
            int i2 = read();
            this.preamble = i2;
            if (i2 < 0) {
                throw new EOFException("expecting preamble byte of choice");
            }
            this.tagClass = i2 & 192;
            int i3 = i2 & 63;
            if (i3 >= 63) {
                i3 = 0;
                do {
                    i = inputStream.read();
                    if (i < 0) {
                        throw new EOFException("expecting further tag bytes");
                    }
                    i3 = (i3 << 7) | (i & 127);
                } while ((i & 128) != 0);
            }
            this.f22565tag = i3;
        }

        /* renamed from: getTag */
        public int m17166getTag() {
            return this.f22565tag;
        }

        public int getTagClass() {
            return this.tagClass;
        }

        public boolean isApplicationTagClass() {
            return this.tagClass == 64;
        }

        public boolean isContextSpecific() {
            return this.tagClass == 128;
        }

        public boolean isPrivateTagClass() {
            return this.tagClass == 192;
        }

        public boolean isUniversalTagClass() {
            return this.tagClass == 0;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("CHOICE(");
            int i = this.tagClass;
            if (i == 0) {
                str = "Universal ";
            } else if (i == 64) {
                str = "Application ";
            } else {
                if (i != 128) {
                    if (i == 192) {
                        str = "Private ";
                    }
                    sb.append("Tag = " + this.f22565tag);
                    sb.append(")");
                    return sb.toString();
                }
                str = "ContextSpecific ";
            }
            sb.append(str);
            sb.append("Tag = " + this.f22565tag);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class LengthInfo {

        /* renamed from: length */
        private final BigInteger f22566length;
        private final boolean shortForm;

        public LengthInfo(BigInteger bigInteger, boolean z) {
            this.f22566length = bigInteger;
            this.shortForm = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int intLength() {
            return BigIntegers.intValueExact(this.f22566length);
        }
    }

    public static class Sequence extends OERInputStream {
        private final boolean extensionFlagSet;
        private final int preamble;
        private final boolean[] valuePresent;

        public Sequence(InputStream inputStream, C5887Element c5887Element) throws IOException {
            int i;
            super(inputStream);
            if (!c5887Element.hasPopulatedExtension() && c5887Element.getOptionals() <= 0 && !c5887Element.hasDefaultChildren()) {
                this.preamble = 0;
                this.extensionFlagSet = false;
                this.valuePresent = null;
                return;
            }
            int i2 = ((FilterInputStream) this).in.read();
            this.preamble = i2;
            if (i2 < 0) {
                throw new EOFException("expecting preamble byte of sequence");
            }
            this.extensionFlagSet = c5887Element.hasPopulatedExtension() && (i2 & 128) == 128;
            this.valuePresent = new boolean[c5887Element.getChildren().size()];
            int i3 = c5887Element.hasPopulatedExtension() ? 6 : 7;
            int i4 = 0;
            for (C5887Element c5887Element2 : c5887Element.getChildren()) {
                if (c5887Element2.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                    if (c5887Element2.getBlock() != 0) {
                        return;
                    }
                    if (c5887Element2.isExplicit()) {
                        i = i4 + 1;
                        this.valuePresent[i4] = true;
                    } else {
                        if (i3 < 0) {
                            i2 = inputStream.read();
                            if (i2 < 0) {
                                throw new EOFException("expecting mask byte sequence");
                            }
                            i3 = 7;
                        }
                        i = i4 + 1;
                        this.valuePresent[i4] = (OERInputStream.f22563bits[i3] & i2) > 0;
                        i3--;
                    }
                    i4 = i;
                }
            }
        }

        public boolean hasExtension() {
            return this.extensionFlagSet;
        }

        public boolean hasOptional(int i) {
            return this.valuePresent[i];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SEQ(");
            sb.append(hasExtension() ? "Ext " : BuildConfig.f24315FLAVOR);
            if (this.valuePresent != null) {
                int i = 0;
                while (true) {
                    boolean[] zArr = this.valuePresent;
                    if (i >= zArr.length) {
                        break;
                    }
                    sb.append(zArr[i] ? "1" : "0");
                    i++;
                }
            } else {
                sb.append("*");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    public OERInputStream(InputStream inputStream) {
        super(inputStream);
        this.debugOutput = null;
        this.maxByteAllocation = 1048576;
        this.debugStream = null;
    }

    /* renamed from: absent */
    private ASN1Encodable m17154absent(C5887Element c5887Element) {
        debugPrint(c5887Element + "Absent");
        return OEROptional.f22567ABSENT;
    }

    private byte[] allocateArray(int i) {
        if (i <= this.maxByteAllocation) {
            return new byte[i];
        }
        throw new IllegalArgumentException("required byte array size " + i + " was greater than " + this.maxByteAllocation);
    }

    private int countOptionalChildTypes(C5887Element c5887Element) {
        Iterator<C5887Element> it = c5887Element.getChildren().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += !it.next().isExplicit() ? 1 : 0;
        }
        return i;
    }

    /* renamed from: parse */
    public static ASN1Encodable m17155parse(byte[] bArr, C5887Element c5887Element) {
        return new OERInputStream(new ByteArrayInputStream(bArr)).m17161parse(c5887Element);
    }

    /* renamed from: choice */
    public C5890Choice m17156choice() {
        return new C5890Choice(this);
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

    public BigInteger enumeration() throws IOException {
        int i = read();
        if (i == -1) {
            throw new EOFException("expecting prefix of enumeration");
        }
        if ((i & 128) != 128) {
            return BigInteger.valueOf(i);
        }
        int i2 = i & 127;
        if (i2 == 0) {
            return BigInteger.ZERO;
        }
        byte[] bArr = new byte[i2];
        if (C6257Streams.readFully(this, bArr) == i2) {
            return new BigInteger(1, bArr);
        }
        throw new EOFException("unable to fully read integer component of enumeration");
    }

    /* renamed from: int16 */
    public BigInteger m17157int16() {
        return parseInt(false, 2);
    }

    /* renamed from: int32 */
    public BigInteger m17158int32() {
        return parseInt(false, 4);
    }

    /* renamed from: int64 */
    public BigInteger m17159int64() {
        return parseInt(false, 8);
    }

    /* renamed from: int8 */
    public BigInteger m17160int8() {
        return parseInt(false, 1);
    }

    public BigInteger parseInt(boolean z, int i) {
        byte[] bArr = new byte[i];
        if (C6257Streams.readFully(this, bArr) == i) {
            return z ? new BigInteger(1, bArr) : new BigInteger(bArr);
        }
        throw new IllegalStateException("integer not fully read");
    }

    public ASN1Encodable parseOpenType(C5887Element c5887Element) throws Throwable {
        OERInputStream oERInputStream;
        Throwable th;
        byte[] bArrAllocateArray = allocateArray(readLength().intLength());
        if (C6257Streams.readFully(((FilterInputStream) this).in, bArrAllocateArray) != bArrAllocateArray.length) {
            throw new IOException("did not fully read open type as raw bytes");
        }
        try {
            oERInputStream = new OERInputStream(new ByteArrayInputStream(bArrAllocateArray));
            try {
                ASN1Object aSN1ObjectM17161parse = oERInputStream.m17161parse(c5887Element);
                oERInputStream.close();
                return aSN1ObjectM17161parse;
            } catch (Throwable th2) {
                th = th2;
                if (oERInputStream != null) {
                    oERInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            oERInputStream = null;
            th = th3;
        }
    }

    public LengthInfo readLength() throws IOException {
        int i = read();
        if (i == -1) {
            throw new EOFException("expecting length");
        }
        if ((i & 128) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Len (Short form): ");
            int i2 = i & 127;
            sb.append(i2);
            debugPrint(sb.toString());
            return new LengthInfo(BigInteger.valueOf(i2), true);
        }
        int i3 = i & 127;
        byte[] bArr = new byte[i3];
        if (C6257Streams.readFully(this, bArr) != i3) {
            throw new EOFException("did not read all bytes of length definition");
        }
        debugPrint("Len (Long Form): " + i3 + " actual len: " + C6255Hex.toHexString(bArr));
        return new LengthInfo(BigIntegers.fromUnsignedByteArray(bArr), false);
    }

    /* renamed from: uint16 */
    public BigInteger m17162uint16() {
        return parseInt(true, 2);
    }

    /* renamed from: uint32 */
    public BigInteger m17163uint32() {
        return parseInt(true, 4);
    }

    /* renamed from: uint64 */
    public BigInteger m17164uint64() {
        return parseInt(false, 8);
    }

    /* renamed from: uint8 */
    public BigInteger m17165uint8() {
        return parseInt(true, 1);
    }

    public OERInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.debugOutput = null;
        this.debugStream = null;
        this.maxByteAllocation = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02a8 A[PHI: r2
      0x02a8: PHI (r2v19 byte[]) = (r2v18 byte[]), (r2v20 byte[]) binds: [B:99:0x02a6, B:95:0x028c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x046c  */
    /* renamed from: parse */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ASN1Object m17161parse(C5887Element c5887Element) throws Throwable {
        ASN1Encodable openType;
        C5887Element c5887ElementMo17170result;
        byte[] bArrAllocateArray;
        BigInteger bigInteger;
        int i = 8;
        switch (C58891.$SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[c5887Element.getBaseType().ordinal()]) {
            case 1:
                return m17161parse(new C5887Element(c5887Element.resolveSupplier().mo17122build(), c5887Element));
            case 2:
                throw new IllegalStateException("A switch element should only be found within a sequence.");
            case 3:
                return m17161parse(new C5887Element(c5887Element.getElementSupplier().mo17122build(), c5887Element));
            case 4:
                byte[] bArrAllocateArray2 = allocateArray(readLength().intLength());
                if (C6257Streams.readFully(this, bArrAllocateArray2) != bArrAllocateArray2.length) {
                    throw new IOException("could not read all of count of seq-of values");
                }
                int iIntValue = BigIntegers.fromUnsignedByteArray(bArrAllocateArray2).intValue();
                debugPrint(c5887Element + "(len = " + iIntValue + ")");
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                if (c5887Element.getChildren().get(0).getaSwitch() != null) {
                    throw new IllegalStateException("element def for item in SEQ OF has a switch, switches only supported in sequences");
                }
                for (int i2 = 0; i2 < iIntValue; i2++) {
                    aSN1EncodableVector.m14420add(m17161parse(C5887Element.expandDeferredDefinition(c5887Element.getChildren().get(0), c5887Element)));
                }
                return new DERSequence(aSN1EncodableVector);
            case 5:
                Sequence sequence = new Sequence(((FilterInputStream) this).in, c5887Element);
                debugPrint(c5887Element + sequence.toString());
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                List<C5887Element> children = c5887Element.getChildren();
                int i3 = 0;
                while (i3 < children.size()) {
                    C5887Element c5887Element2 = children.get(i3);
                    if (c5887Element2.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                        if (c5887Element2.getBlock() > 0) {
                            if (sequence.extensionFlagSet) {
                                byte[] bArrAllocateArray3 = allocateArray(readLength().intLength());
                                if (C6257Streams.readFully(((FilterInputStream) this).in, bArrAllocateArray3) != bArrAllocateArray3.length) {
                                    throw new IOException("did not fully read presence list.");
                                }
                                int length = (bArrAllocateArray3.length * 8) - bArrAllocateArray3[0];
                                while (true) {
                                    if (i3 < children.size() || i < length) {
                                        C5887Element c5887Element3 = i3 < children.size() ? children.get(i3) : null;
                                        if (c5887Element3 != null) {
                                            if (i < length && (bArrAllocateArray3[i / 8] & f22564bitsR[i % 8]) != 0) {
                                                openType = parseOpenType(c5887Element3);
                                            } else {
                                                if (c5887Element3.isExplicit()) {
                                                    throw new IOException("extension is marked as explicit but is not defined in presence list");
                                                }
                                                openType = OEROptional.f22567ABSENT;
                                            }
                                            aSN1EncodableVector2.m14420add(openType);
                                        } else if ((bArrAllocateArray3[i / 8] & f22564bitsR[i % 8]) != 0) {
                                            int iIntLength = readLength().intLength();
                                            while (true) {
                                                iIntLength--;
                                                if (iIntLength >= 0) {
                                                    ((FilterInputStream) this).in.read();
                                                }
                                            }
                                        }
                                        i++;
                                        i3++;
                                    }
                                }
                            }
                            return new DERSequence(aSN1EncodableVector2);
                        }
                        C5887Element c5887ElementExpandDeferredDefinition = C5887Element.expandDeferredDefinition(c5887Element2, c5887Element);
                        if (c5887ElementExpandDeferredDefinition.getaSwitch() != null) {
                            c5887ElementMo17170result = c5887ElementExpandDeferredDefinition.getaSwitch().mo17170result(new SwitchIndexer.Asn1EncodableVectorIndexer(aSN1EncodableVector2));
                            if (c5887ElementMo17170result.getParent() != c5887Element) {
                                c5887ElementMo17170result = new C5887Element(c5887ElementMo17170result, c5887Element);
                            }
                        } else {
                            c5887ElementMo17170result = c5887ElementExpandDeferredDefinition;
                        }
                        if (sequence.valuePresent != null) {
                            ASN1Encodable aSN1EncodableM17161parse = sequence.valuePresent[i3] ? c5887ElementMo17170result.isExplicit() ? m17161parse(c5887ElementMo17170result) : OEROptional.getInstance(m17161parse(c5887ElementMo17170result)) : c5887ElementMo17170result.getDefaultValue() != null ? c5887ElementExpandDeferredDefinition.getDefaultValue() : m17154absent(c5887ElementExpandDeferredDefinition);
                            aSN1EncodableVector2.m14420add(aSN1EncodableM17161parse);
                        }
                    }
                    i3++;
                }
                if (sequence.extensionFlagSet) {
                }
                return new DERSequence(aSN1EncodableVector2);
            case 6:
                C5890Choice c5890ChoiceM17156choice = m17156choice();
                debugPrint(c5890ChoiceM17156choice.toString() + " " + c5890ChoiceM17156choice.f22565tag);
                if (!c5890ChoiceM17156choice.isContextSpecific()) {
                    if (c5890ChoiceM17156choice.isApplicationTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    if (c5890ChoiceM17156choice.isPrivateTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    if (c5890ChoiceM17156choice.isUniversalTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    throw new IllegalStateException("Unimplemented tag type");
                }
                C5887Element c5887ElementExpandDeferredDefinition2 = C5887Element.expandDeferredDefinition(c5887Element.getChildren().get(c5890ChoiceM17156choice.m17166getTag()), c5887Element);
                if (c5887ElementExpandDeferredDefinition2.getBlock() > 0) {
                    debugPrint("Chosen (Ext): " + c5887ElementExpandDeferredDefinition2);
                    return new DERTaggedObject(c5890ChoiceM17156choice.f22565tag, parseOpenType(c5887ElementExpandDeferredDefinition2));
                }
                debugPrint("Chosen: " + c5887ElementExpandDeferredDefinition2);
                return new DERTaggedObject(c5890ChoiceM17156choice.f22565tag, m17161parse(c5887ElementExpandDeferredDefinition2));
            case 7:
                BigInteger bigIntegerEnumeration = enumeration();
                debugPrint(c5887Element + "ENUM(" + bigIntegerEnumeration + ") = " + c5887Element.getChildren().get(bigIntegerEnumeration.intValue()).getLabel());
                return new ASN1Enumerated(bigIntegerEnumeration);
            case 8:
                int iIntBytesForRange = c5887Element.intBytesForRange();
                if (iIntBytesForRange != 0) {
                    bArrAllocateArray = allocateArray(Math.abs(iIntBytesForRange));
                    C6257Streams.readFully(this, bArrAllocateArray);
                    bigInteger = iIntBytesForRange < 0 ? new BigInteger(bArrAllocateArray) : BigIntegers.fromUnsignedByteArray(bArrAllocateArray);
                } else if (c5887Element.isLowerRangeZero()) {
                    bArrAllocateArray = allocateArray(readLength().intLength());
                    C6257Streams.readFully(this, bArrAllocateArray);
                    bigInteger = bArrAllocateArray.length == 0 ? BigInteger.ZERO : new BigInteger(1, bArrAllocateArray);
                } else {
                    bArrAllocateArray = allocateArray(readLength().intLength());
                    C6257Streams.readFully(this, bArrAllocateArray);
                    if (bArrAllocateArray.length != 0) {
                        bigInteger = new BigInteger(bArrAllocateArray);
                    }
                }
                if (this.debugOutput != null) {
                    debugPrint(c5887Element + "INTEGER byteLen= " + bArrAllocateArray.length + " hex= " + bigInteger.toString(16) + ")");
                }
                return new ASN1Integer(bigInteger);
            case 9:
                int iIntLength2 = (c5887Element.getUpperBound() == null || !c5887Element.getUpperBound().equals(c5887Element.getLowerBound())) ? readLength().intLength() : c5887Element.getUpperBound().intValue();
                byte[] bArrAllocateArray4 = allocateArray(iIntLength2);
                if (C6257Streams.readFully(this, bArrAllocateArray4) != iIntLength2) {
                    throw new IOException("did not read all of " + c5887Element.getLabel());
                }
                if (this.debugOutput != null) {
                    int iMin = Math.min(bArrAllocateArray4.length, 32);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c5887Element);
                    sb.append("OCTET STRING (");
                    sb.append(bArrAllocateArray4.length);
                    sb.append(") = ");
                    sb.append(C6255Hex.toHexString(bArrAllocateArray4, 0, iMin));
                    sb.append(" ");
                    sb.append(bArrAllocateArray4.length > 32 ? "..." : BuildConfig.f24315FLAVOR);
                    debugPrint(sb.toString());
                }
                return new DEROctetString(bArrAllocateArray4);
            case 10:
                byte[] bArrAllocateArray5 = allocateArray(c5887Element.isFixedLength() ? c5887Element.getUpperBound().intValue() : readLength().intLength());
                if (C6257Streams.readFully(this, bArrAllocateArray5) != bArrAllocateArray5.length) {
                    throw new IOException("could not read all of IA5 string");
                }
                String strFromByteArray = C6250Strings.fromByteArray(bArrAllocateArray5);
                if (this.debugOutput != null) {
                    debugPrint(c5887Element.appendLabel("IA5 String (" + bArrAllocateArray5.length + ") = " + strFromByteArray));
                }
                return new DERIA5String(strFromByteArray);
            case 11:
                byte[] bArrAllocateArray6 = allocateArray(readLength().intLength());
                if (C6257Streams.readFully(this, bArrAllocateArray6) != bArrAllocateArray6.length) {
                    throw new IOException("could not read all of utf 8 string");
                }
                String strFromUTF8ByteArray = C6250Strings.fromUTF8ByteArray(bArrAllocateArray6);
                if (this.debugOutput != null) {
                    debugPrint(c5887Element + "UTF8 String (" + bArrAllocateArray6.length + ") = " + strFromUTF8ByteArray);
                }
                return new DERUTF8String(strFromUTF8ByteArray);
            case 12:
                byte[] bArrAllocateArray7 = c5887Element.isFixedLength() ? new byte[c5887Element.getLowerBound().intValue() / 8] : allocateArray((BigInteger.ZERO.compareTo(c5887Element.getUpperBound()) > 0 ? c5887Element.getUpperBound().intValue() : readLength().intLength()) / 8);
                C6257Streams.readFully(this, bArrAllocateArray7);
                if (this.debugOutput != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("BIT STRING(" + (bArrAllocateArray7.length * 8) + ") = ");
                    for (int i4 = 0; i4 != bArrAllocateArray7.length; i4++) {
                        byte b = bArrAllocateArray7[i4];
                        for (int i5 = 0; i5 < 8; i5++) {
                            stringBuffer.append((b & ByteCompanionObject.MIN_VALUE) > 0 ? "1" : "0");
                            b = (byte) (b << 1);
                        }
                    }
                    debugPrint(c5887Element + stringBuffer.toString());
                }
                return new DERBitString(bArrAllocateArray7);
            case 13:
                debugPrint(c5887Element + "NULL");
                return C5103DERNull.INSTANCE;
            case 14:
                LengthInfo length2 = readLength();
                byte[] bArr = new byte[length2.intLength()];
                if (C6257Streams.readFully(this, bArr) != length2.intLength()) {
                    throw new IOException("could not read all of count of open value in choice (...) ");
                }
                debugPrint("ext " + length2.intLength() + " " + C6255Hex.toHexString(bArr));
                return new DEROctetString(bArr);
            case 15:
                return read() == 0 ? ASN1Boolean.f17897FALSE : ASN1Boolean.f17898TRUE;
            default:
                throw new IllegalStateException("Unhandled type " + c5887Element.getBaseType());
        }
    }
}
