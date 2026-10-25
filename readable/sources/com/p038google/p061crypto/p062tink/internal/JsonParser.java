package com.p038google.p061crypto.p062tink.internal;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import javax.annotation.Nullable;
import p131o.AbstractC3867i9;
import p131o.AbstractC4187n0;
import p131o.C1598A0;
import p131o.C3858i0;
import p131o.C4318p0;
import p131o.C4385q0;
import p131o.C4520s0;
import p131o.C4587t0;
import p131o.EnumC4786w0;

/* loaded from: classes.dex */
public final class JsonParser {
    private static final JsonElementTypeAdapter JSON_ELEMENT = new JsonElementTypeAdapter(null);

    /* renamed from: com.google.crypto.tink.internal.JsonParser$1 */
    public static /* synthetic */ class C04151 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[EnumC4786w0.m13807values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[EnumC4786w0.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC4786w0.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC4786w0.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC4786w0.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC4786w0.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[EnumC4786w0.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class JsonElementTypeAdapter extends AbstractC3867i9 {
        private static final int RECURSION_LIMIT = 100;

        private JsonElementTypeAdapter() {
        }

        private AbstractC4187n0 readTerminal(C4587t0 c4587t0, EnumC4786w0 enumC4786w0) throws IOException {
            int i = C04151.$SwitchMap$com$google$gson$stream$JsonToken[enumC4786w0.ordinal()];
            if (i == 3) {
                String strMo13550OjSQV = c4587t0.mo13550OjSQV();
                if (JsonParser.isValidString(strMo13550OjSQV)) {
                    return new C4520s0(strMo13550OjSQV);
                }
                throw new IOException("illegal characters in string");
            }
            if (i == 4) {
                return new C4520s0(new LazilyParsedNumber(c4587t0.mo13550OjSQV()));
            }
            if (i == 5) {
                return new C4520s0(Boolean.valueOf(c4587t0.mo13543Gd()));
            }
            if (i == 6) {
                c4587t0.mo13569wJVbdd();
                return C4318p0.f15892mjFkc;
            }
            throw new IllegalStateException("Unexpected token: " + enumC4786w0);
        }

        @Nullable
        private AbstractC4187n0 tryBeginNesting(C4587t0 c4587t0, EnumC4786w0 enumC4786w0) throws IOException {
            int i = C04151.$SwitchMap$com$google$gson$stream$JsonToken[enumC4786w0.ordinal()];
            if (i == 1) {
                c4587t0.mo13556ZfxDd();
                return new C3858i0();
            }
            if (i != 2) {
                return null;
            }
            c4587t0.mo13545KLFTb();
            return new C4385q0();
        }

        public /* synthetic */ JsonElementTypeAdapter(C04151 c04151) {
            this();
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: read */
        public AbstractC4187n0 mo3481read(C4587t0 c4587t0) throws IOException {
            String strMo13541BAnRFn;
            EnumC4786w0 enumC4786w0Mo13542CqaNbM = c4587t0.mo13542CqaNbM();
            AbstractC4187n0 abstractC4187n0TryBeginNesting = tryBeginNesting(c4587t0, enumC4786w0Mo13542CqaNbM);
            if (abstractC4187n0TryBeginNesting == null) {
                return readTerminal(c4587t0, enumC4786w0Mo13542CqaNbM);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (c4587t0.mo13558diqgf()) {
                    if (abstractC4187n0TryBeginNesting instanceof C4385q0) {
                        strMo13541BAnRFn = c4587t0.mo13541BAnRFn();
                        if (!JsonParser.isValidString(strMo13541BAnRFn)) {
                            throw new IOException("illegal characters in string");
                        }
                    } else {
                        strMo13541BAnRFn = null;
                    }
                    EnumC4786w0 enumC4786w0Mo13542CqaNbM2 = c4587t0.mo13542CqaNbM();
                    AbstractC4187n0 abstractC4187n0TryBeginNesting2 = tryBeginNesting(c4587t0, enumC4786w0Mo13542CqaNbM2);
                    boolean z = abstractC4187n0TryBeginNesting2 != null;
                    if (abstractC4187n0TryBeginNesting2 == null) {
                        abstractC4187n0TryBeginNesting2 = readTerminal(c4587t0, enumC4786w0Mo13542CqaNbM2);
                    }
                    if (abstractC4187n0TryBeginNesting instanceof C3858i0) {
                        ((C3858i0) abstractC4187n0TryBeginNesting).m12264IEE(abstractC4187n0TryBeginNesting2);
                    } else {
                        C4385q0 c4385q0 = (C4385q0) abstractC4187n0TryBeginNesting;
                        if (c4385q0.m13151HGpJ(strMo13541BAnRFn)) {
                            throw new IOException("duplicate key: " + strMo13541BAnRFn);
                        }
                        c4385q0.m13158fehf(strMo13541BAnRFn, abstractC4187n0TryBeginNesting2);
                    }
                    if (z) {
                        arrayDeque.addLast(abstractC4187n0TryBeginNesting);
                        if (arrayDeque.size() > RECURSION_LIMIT) {
                            throw new IOException("too many recursions");
                        }
                        abstractC4187n0TryBeginNesting = abstractC4187n0TryBeginNesting2;
                    } else {
                        continue;
                    }
                } else {
                    if (abstractC4187n0TryBeginNesting instanceof C3858i0) {
                        c4587t0.mo13553VA();
                    } else {
                        c4587t0.mo13547MiMN();
                    }
                    if (arrayDeque.isEmpty()) {
                        return abstractC4187n0TryBeginNesting;
                    }
                    abstractC4187n0TryBeginNesting = (AbstractC4187n0) arrayDeque.removeLast();
                }
            }
        }

        @Override // p131o.AbstractC3867i9
        /* renamed from: write, reason: merged with bridge method [inline-methods] */
        public void mo3482write(C1598A0 c1598a0, AbstractC4187n0 abstractC4187n0) {
            throw new UnsupportedOperationException("write is not supported");
        }
    }

    public static final class LazilyParsedNumber extends Number {

        /* renamed from: value */
        private final String f3113value;

        public LazilyParsedNumber(String str) {
            this.f3113value = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        private Object writeReplace() throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.f3113value);
        }

        /* renamed from: equals */
        public boolean m3484equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LazilyParsedNumber) {
                return this.f3113value.equals(((LazilyParsedNumber) obj).f3113value);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.f3113value);
        }

        public int hashCode() {
            return this.f3113value.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.f3113value);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.f3113value);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.f3113value).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.f3113value);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f3113value).longValue();
            }
        }

        public String toString() {
            return this.f3113value;
        }
    }

    private JsonParser() {
    }

    public static long getParsedNumberAsLongOrThrow(AbstractC4187n0 abstractC4187n0) {
        if (abstractC4187n0.mo12263ETF() instanceof LazilyParsedNumber) {
            return Long.parseLong(abstractC4187n0.mo12263ETF().toString());
        }
        throw new IllegalArgumentException("does not contain a parsed number.");
    }

    public static boolean isValidString(String str) {
        int length = str.length();
        int i = 0;
        while (i != length) {
            char cCharAt = str.charAt(i);
            int i2 = i + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i = i2;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i2 == length || !Character.isLowSurrogate(str.charAt(i2))) {
                    return false;
                }
                i += 2;
            }
        }
        return true;
    }

    /* renamed from: parse */
    public static AbstractC4187n0 m3480parse(String str) throws IOException {
        try {
            C4587t0 c4587t0 = new C4587t0(new StringReader(str));
            c4587t0.m13566rWxwaT(false);
            return JSON_ELEMENT.mo3481read(c4587t0);
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }
}
