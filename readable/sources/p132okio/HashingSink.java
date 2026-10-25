package p132okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\r\u0010\u0018\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u001aR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m4988d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", CMSAttributeTableGenerator.f18937DIGEST, "Ljava/security/MessageDigest;", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", BuildConfig.f24315FLAVOR, "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nHashingSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashingSink.kt\nokio/HashingSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,149:1\n87#2:150\n*S KotlinDebug\n*F\n+ 1 HashingSink.kt\nokio/HashingSink\n*L\n76#1:150\n*E\n"})
/* loaded from: classes.dex */
public final class HashingSink extends ForwardingSink implements InterfaceC5060Sink {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u0010"}, m4988d2 = {"Lokio/HashingSink$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "md5", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HashingSink hmacSha1(InterfaceC5060Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(InterfaceC5060Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(InterfaceC5060Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @JvmStatic
        /* renamed from: md5 */
        public final HashingSink m14298md5(InterfaceC5060Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        /* renamed from: sha1 */
        public final HashingSink m14299sha1(InterfaceC5060Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        /* renamed from: sha256 */
        public final HashingSink m14300sha256(InterfaceC5060Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, XMSSKeyParameters.f23621SHA_256);
        }

        @JvmStatic
        /* renamed from: sha512 */
        public final HashingSink m14301sha512(InterfaceC5060Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, XMSSKeyParameters.f23622SHA_512);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(InterfaceC5060Sink sink, MessageDigest digest) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    @JvmStatic
    public static final HashingSink hmacSha1(InterfaceC5060Sink interfaceC5060Sink, ByteString byteString) {
        return INSTANCE.hmacSha1(interfaceC5060Sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(InterfaceC5060Sink interfaceC5060Sink, ByteString byteString) {
        return INSTANCE.hmacSha256(interfaceC5060Sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(InterfaceC5060Sink interfaceC5060Sink, ByteString byteString) {
        return INSTANCE.hmacSha512(interfaceC5060Sink, byteString);
    }

    @JvmStatic
    /* renamed from: md5 */
    public static final HashingSink m14293md5(InterfaceC5060Sink interfaceC5060Sink) {
        return INSTANCE.m14298md5(interfaceC5060Sink);
    }

    @JvmStatic
    /* renamed from: sha1 */
    public static final HashingSink m14294sha1(InterfaceC5060Sink interfaceC5060Sink) {
        return INSTANCE.m14299sha1(interfaceC5060Sink);
    }

    @JvmStatic
    /* renamed from: sha256 */
    public static final HashingSink m14295sha256(InterfaceC5060Sink interfaceC5060Sink) {
        return INSTANCE.m14300sha256(interfaceC5060Sink);
    }

    @JvmStatic
    /* renamed from: sha512 */
    public static final HashingSink m14296sha512(InterfaceC5060Sink interfaceC5060Sink) {
        return INSTANCE.m14301sha512(interfaceC5060Sink);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_hash")
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m20072deprecated_hash() {
        return m14297hash();
    }

    @InterfaceC1231JvmName(m6260name = "hash")
    /* renamed from: hash */
    public final ByteString m14297hash() throws IllegalStateException {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.checkNotNull(mac);
            bArrDoFinal = mac.doFinal();
        }
        Intrinsics.checkNotNull(bArrDoFinal);
        return new ByteString(bArrDoFinal);
    }

    @Override // p132okio.ForwardingSink, p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
        C5059Segment c5059Segment = source.head;
        Intrinsics.checkNotNull(c5059Segment);
        long j = 0;
        while (j < byteCount) {
            int iMin = (int) Math.min(byteCount - j, c5059Segment.limit - c5059Segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(c5059Segment.data, c5059Segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                Intrinsics.checkNotNull(mac);
                mac.update(c5059Segment.data, c5059Segment.pos, iMin);
            }
            j += iMin;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
        }
        super.mo2303write(source, byteCount);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(InterfaceC5060Sink sink, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        this(sink, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(InterfaceC5060Sink sink, Mac mac) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(InterfaceC5060Sink sink, ByteString key, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            Intrinsics.checkNotNull(mac);
            this(sink, mac);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
