package p132okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.JvmOverloads;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Charsets;
import p094kotlin.p117text.StringsKt;
import p132okio.internal.ByteStringNonJs;

@Metadata(m4987d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ^2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001^B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0000J\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u001d\u0010$\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0000H\u0010¢\u0006\u0002\b%J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0000H\u0016J\b\u0010)\u001a\u00020\u0000H\u0016J\u001c\u0010*\u001a\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\nH\u0017J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\u0016\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b3J\r\u00105\u001a\u00020\nH\u0010¢\u0006\u0002\b6J\b\u00107\u001a\u00020\u0004H\u0016J\r\u00108\u001a\u00020\u0004H\u0010¢\u0006\u0002\b9J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J%\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0010¢\u0006\u0002\bDJ(\u0010E\u001a\u00020F2\u0006\u0010B\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J(\u0010E\u001a\u00020F2\u0006\u0010B\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J,\u0010I\u001a\u00020=2\b\b\u0002\u0010B\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\b\b\u0002\u0010K\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J\u000e\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u0000J\u000e\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u0004J\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020\u0000J\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020\u0004J\u001a\u0010P\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\nH\u0007J\u001a\u0010P\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\nH\u0017J\u001a\u0010R\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\nH\u0007J\u001a\u0010R\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\nH\u0017J\u0013\u0010S\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010TH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010U\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u0000H\u0096\u0002J\b\u0010V\u001a\u00020\u0010H\u0016J\u0010\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020=2\u0006\u0010>\u001a\u00020[H\u0002J\u0015\u00103\u001a\u00020.2\u0006\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\b\\J\r\u00104\u001a\u00020\nH\u0007¢\u0006\u0002\b]R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u00104\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b4\u0010\f¨\u0006_"}, m4988d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "<init>", "([B)V", "getData$okio", "()[B", "hashCode", BuildConfig.f24315FLAVOR, "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "utf8", BuildConfig.f24315FLAVOR, "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "string", "charset", "Ljava/nio/charset/Charset;", "base64", "md5", "sha1", "sha256", "sha512", CMSAttributeTableGenerator.f18937DIGEST, "algorithm", "digest$okio", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "hmac$okio", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "substring", "beginIndex", "endIndex", "internalGet", BuildConfig.f24315FLAVOR, "pos", "internalGet$okio", "get", "index", "getByte", "size", "getSize", "getSize$okio", "toByteArray", "internalArray", "internalArray$okio", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", BuildConfig.f24315FLAVOR, "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", BuildConfig.f24315FLAVOR, "other", "otherOffset", "copyInto", "target", "targetOffset", "startsWith", "prefix", "endsWith", "suffix", "indexOf", "fromIndex", "lastIndexOf", "equals", BuildConfig.f24315FLAVOR, "compareTo", "toString", "readObject", "in", "Ljava/io/ObjectInputStream;", "writeObject", "Ljava/io/ObjectOutputStream;", "-deprecated_getByte", "-deprecated_size", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n41#2,7:365\n51#2:372\n54#2:373\n61#2,4:374\n65#2:379\n67#2:381\n73#2,23:382\n101#2,23:405\n128#2:428\n129#2,9:430\n141#2:439\n144#2:440\n147#2:441\n150#2:442\n158#2:443\n168#2,3:444\n167#2:447\n181#2,2:448\n186#2:450\n190#2:451\n194#2:452\n198#2:453\n202#2,7:454\n215#2:461\n219#2,7:462\n230#2,4:469\n239#2,5:473\n248#2,6:478\n254#2,9:485\n297#2,8:494\n128#2:502\n129#2,9:504\n308#2,9:513\n69#3:378\n75#3:380\n75#3:484\n1#4:429\n1#4:503\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString\n*L\n66#1:365,7\n71#1:372\n108#1:373\n110#1:374,4\n110#1:379\n110#1:381\n112#1:382,23\n114#1:405,23\n118#1:428\n118#1:430,9\n120#1:439\n129#1:440\n131#1:441\n133#1:442\n152#1:443\n159#1:444,3\n159#1:447\n166#1:448,2\n168#1:450\n170#1:451\n172#1:452\n174#1:453\n180#1:454,7\n183#1:461\n186#1:462,7\n188#1:469,4\n190#1:473,5\n192#1:478,6\n192#1:485,9\n194#1:494,8\n194#1:502\n194#1:504,9\n194#1:513,9\n110#1:378\n110#1:380\n192#1:484\n118#1:429\n194#1:503\n*E\n"})
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: EMPTY */
    @JvmField
    public static final ByteString f17785EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @Metadata(m4987d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u00020\n\"\u00020\u000bH\u0007J%\u0010\f\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\bJ\u0011\u0010\f\u001a\u00020\u0007*\u00020\u0010H\u0007¢\u0006\u0002\b\bJ\f\u0010\u0011\u001a\u00020\u0007*\u00020\u0012H\u0007J\u001b\u0010\u0013\u001a\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0007J\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0012H\u0007J\u0019\u0010\u0019\u001a\u00020\u0007*\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u001bJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u001dJ\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u001eJ\u001d\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u001fJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\"J%\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\"J\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m4988d2 = {"Lokio/ByteString$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "serialVersionUID", BuildConfig.f24315FLAVOR, "EMPTY", "Lokio/ByteString;", "of", "data", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "toByteString", "offset", BuildConfig.f24315FLAVOR, "byteCount", "Ljava/nio/ByteBuffer;", "encodeUtf8", BuildConfig.f24315FLAVOR, "encode", "charset", "Ljava/nio/charset/Charset;", "encodeString", "decodeBase64", "decodeHex", "readByteString", "Ljava/io/InputStream;", "read", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 ByteStringNonJs.kt\nokio/internal/-ByteStringNonJs\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n266#2:365\n270#2,2:366\n276#2,3:368\n283#2,2:371\n25#3:373\n27#3,7:375\n1#4:374\n1#4:382\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n*L\n234#1:365\n239#1:366,2\n251#1:368,3\n259#1:371,2\n262#1:373\n262#1:375,7\n262#1:374\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return companion.m14258of(bArr, i, i2);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", m5048imports = {"okio.ByteString.Companion.decodeBase64"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_decodeBase64")
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m20060deprecated_decodeBase64(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", m5048imports = {"okio.ByteString.Companion.decodeHex"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_decodeHex")
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m20061deprecated_decodeHex(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeHex(string);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", m5048imports = {"okio.ByteString.Companion.encode"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_encodeString")
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m20062deprecated_encodeString(String string, Charset charset) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", m5048imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_encodeUtf8")
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m20063deprecated_encodeUtf8(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", m5048imports = {"okio.ByteString.Companion.toByteString"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m20064deprecated_of(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            return m14256of(buffer);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", m5048imports = {"okio.ByteString.Companion.readByteString"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_read")
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m20066deprecated_read(InputStream inputstream, int byteCount) {
            Intrinsics.checkNotNullParameter(inputstream, "inputstream");
            return m14259read(inputstream, byteCount);
        }

        @JvmStatic
        public final ByteString decodeBase64(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bArrDecodeBase64ToArray = C5049Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        public final ByteString decodeHex(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((ByteStringNonJs.decodeHexDigit(str.charAt(i2)) << 4) + ByteStringNonJs.decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @InterfaceC1231JvmName(m6260name = "encodeString")
        public final ByteString encodeString(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        @JvmStatic
        public final ByteString encodeUtf8(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @InterfaceC1231JvmName(m6260name = "of")
        /* renamed from: of */
        public final ByteString m14256of(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @InterfaceC1231JvmName(m6260name = "read")
        /* renamed from: read */
        public final ByteString m14259read(InputStream inputStream, int i) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            if (i < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i).toString());
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    throw new EOFException();
                }
                i2 += i3;
            }
            return new ByteString(bArr);
        }

        private Companion() {
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", m5048imports = {"okio.ByteString.Companion.toByteString"}))
        @InterfaceC1231JvmName(m6260name = "-deprecated_of")
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m20065deprecated_of(byte[] array, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(array, "array");
            return m14258of(array, offset, byteCount);
        }

        @JvmStatic
        /* renamed from: of */
        public final ByteString m14257of(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            return new ByteString(bArrCopyOf);
        }

        @JvmStatic
        @InterfaceC1231JvmName(m6260name = "of")
        /* renamed from: of */
        public final ByteString m14258of(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            SegmentedByteString.checkOffsetAndCount(bArr.length, i, i2);
            return new ByteString(ArraysKt.copyOfRange(bArr, i, i2 + i));
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        byteString.copyInto(i, bArr, i2, i3);
    }

    @JvmStatic
    public static final ByteString decodeBase64(String str) {
        return INSTANCE.decodeBase64(str);
    }

    @JvmStatic
    public static final ByteString decodeHex(String str) {
        return INSTANCE.decodeHex(str);
    }

    @JvmStatic
    @InterfaceC1231JvmName(m6260name = "encodeString")
    public static final ByteString encodeString(String str, Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.m14245indexOf(byteString2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.m14252size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    @JvmStatic
    @InterfaceC1231JvmName(m6260name = "of")
    /* renamed from: of */
    public static final ByteString m14236of(ByteBuffer byteBuffer) {
        return INSTANCE.m14256of(byteBuffer);
    }

    @JvmStatic
    @InterfaceC1231JvmName(m6260name = "read")
    /* renamed from: read */
    public static final ByteString m14239read(InputStream inputStream, int i) {
        return INSTANCE.m14259read(inputStream, i);
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        ByteString byteStringM14259read = INSTANCE.m14259read(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteStringM14259read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.m14252size();
        }
        return byteString.substring(i, i2);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m20058deprecated_getByte(int index) {
        return m14242getByte(index);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "size", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m20059deprecated_size() {
        return m14252size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    /* renamed from: base64 */
    public String mo14240base64() {
        return C5049Base64.encodeBase64$default(getData(), null, 1, null);
    }

    public String base64Url() {
        return C5049Base64.encodeBase64(getData(), C5049Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto(getData(), target, targetOffset, offset, byteCount + offset);
    }

    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, m14252size());
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNull(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(m14252size() - suffix.m14252size(), suffix, 0, suffix.m14252size());
    }

    /* renamed from: equals */
    public boolean mo14241equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.m14252size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    @InterfaceC1231JvmName(m6260name = "getByte")
    /* renamed from: getByte */
    public final byte m14242getByte(int index) {
        return internalGet$okio(index);
    }

    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    /* renamed from: hex */
    public String mo14243hex() {
        char[] cArr = new char[getData().length * 2];
        int i = 0;
        for (byte b : getData()) {
            int i2 = i + 1;
            cArr[i] = p132okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = p132okio.internal.ByteString.getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    /* renamed from: indexOf */
    public final int m14244indexOf(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    /* renamed from: md5 */
    public final ByteString m14248md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    /* renamed from: sha1 */
    public final ByteString m14249sha1() {
        return digest$okio("SHA-1");
    }

    /* renamed from: sha256 */
    public final ByteString m14250sha256() {
        return digest$okio(XMSSKeyParameters.f23621SHA_256);
    }

    /* renamed from: sha512 */
    public final ByteString m14251sha512() {
        return digest$okio(XMSSKeyParameters.f23622SHA_512);
    }

    @InterfaceC1231JvmName(m6260name = "size")
    /* renamed from: size */
    public final int m14252size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.m14252size());
    }

    /* renamed from: string */
    public String mo14253string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 65 && b <= 90) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 97 && b <= 122) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        bArrCopyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = p132okio.internal.ByteString.codePointIndexToCharIndex(getData(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strM14254utf8 = m14254utf8();
            String strSubstring = strM14254utf8.substring(0, iCodePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (iCodePointIndexToCharIndex >= strM14254utf8.length()) {
                return "[text=" + strReplace$default + ']';
            }
            return "[size=" + getData().length + " text=" + strReplace$default + "…]";
        }
        if (getData().length <= 64) {
            return "[hex=" + mo14243hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(getData().length);
        sb.append(" hex=");
        if (64 <= getData().length) {
            sb.append((64 == getData().length ? this : new ByteString(ArraysKt.copyOfRange(getData(), 0, 64))).mo14243hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    /* renamed from: utf8 */
    public String m14254utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    /* renamed from: write */
    public void mo14255write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.write(this.data);
    }

    public void write$okio(C5052Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        p132okio.internal.ByteString.commonWrite(this, buffer, offset, byteCount);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.mo14247indexOf(bArr, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.m14252size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    @JvmStatic
    /* renamed from: of */
    public static final ByteString m14237of(byte... bArr) {
        return INSTANCE.m14257of(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM14252size = m14252size();
        int iM14252size2 = other.m14252size();
        int iMin = Math.min(iM14252size, iM14252size2);
        for (int i = 0; i < iMin; i++) {
            int iM14242getByte = m14242getByte(i) & C1126UByte.MAX_VALUE;
            int iM14242getByte2 = other.m14242getByte(i) & C1126UByte.MAX_VALUE;
            if (iM14242getByte == iM14242getByte2) {
            }
        }
        if (iM14252size == iM14252size2) {
            return 0;
        }
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(m14252size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    /* renamed from: indexOf */
    public final int m14246indexOf(byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && SegmentedByteString.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @JvmOverloads
    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    @JvmStatic
    @InterfaceC1231JvmName(m6260name = "of")
    /* renamed from: of */
    public static final ByteString m14238of(byte[] bArr, int i, int i2) {
        return INSTANCE.m14258of(bArr, i, i2);
    }

    @JvmOverloads
    /* renamed from: indexOf */
    public final int m14245indexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return mo14247indexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public ByteString substring(int beginIndex, int endIndex) {
        if (beginIndex >= 0) {
            if (endIndex <= getData().length) {
                if (endIndex - beginIndex >= 0) {
                    return (beginIndex == 0 && endIndex == getData().length) ? this : new ByteString(ArraysKt.copyOfRange(getData(), beginIndex, endIndex));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @JvmOverloads
    /* renamed from: indexOf */
    public int mo14247indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = getData().length - other.length;
        int iMax = Math.max(fromIndex, 0);
        if (iMax <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int iMin = Math.min(fromIndex, getData().length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }
}
