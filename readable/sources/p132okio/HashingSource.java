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

@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\r\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0019R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, m4988d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", CMSAttributeTableGenerator.f18937DIGEST, "Ljava/security/MessageDigest;", "<init>", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", BuildConfig.f24315FLAVOR, "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "read", BuildConfig.f24315FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class HashingSource extends ForwardingSource implements InterfaceC5062Source {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u0010"}, m4988d2 = {"Lokio/HashingSource$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "md5", "Lokio/HashingSource;", "source", "Lokio/Source;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HashingSource hmacSha1(InterfaceC5062Source source, ByteString key) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSource hmacSha256(InterfaceC5062Source source, ByteString key) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSource hmacSha512(InterfaceC5062Source source, ByteString key) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @JvmStatic
        /* renamed from: md5 */
        public final HashingSource m14307md5(InterfaceC5062Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, "MD5");
        }

        @JvmStatic
        /* renamed from: sha1 */
        public final HashingSource m14308sha1(InterfaceC5062Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @JvmStatic
        /* renamed from: sha256 */
        public final HashingSource m14309sha256(InterfaceC5062Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, XMSSKeyParameters.f23621SHA_256);
        }

        @JvmStatic
        /* renamed from: sha512 */
        public final HashingSource m14310sha512(InterfaceC5062Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new HashingSource(source, XMSSKeyParameters.f23622SHA_512);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(InterfaceC5062Source source, MessageDigest digest) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    @JvmStatic
    public static final HashingSource hmacSha1(InterfaceC5062Source interfaceC5062Source, ByteString byteString) {
        return INSTANCE.hmacSha1(interfaceC5062Source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(InterfaceC5062Source interfaceC5062Source, ByteString byteString) {
        return INSTANCE.hmacSha256(interfaceC5062Source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(InterfaceC5062Source interfaceC5062Source, ByteString byteString) {
        return INSTANCE.hmacSha512(interfaceC5062Source, byteString);
    }

    @JvmStatic
    /* renamed from: md5 */
    public static final HashingSource m14302md5(InterfaceC5062Source interfaceC5062Source) {
        return INSTANCE.m14307md5(interfaceC5062Source);
    }

    @JvmStatic
    /* renamed from: sha1 */
    public static final HashingSource m14303sha1(InterfaceC5062Source interfaceC5062Source) {
        return INSTANCE.m14308sha1(interfaceC5062Source);
    }

    @JvmStatic
    /* renamed from: sha256 */
    public static final HashingSource m14304sha256(InterfaceC5062Source interfaceC5062Source) {
        return INSTANCE.m14309sha256(interfaceC5062Source);
    }

    @JvmStatic
    /* renamed from: sha512 */
    public static final HashingSource m14305sha512(InterfaceC5062Source interfaceC5062Source) {
        return INSTANCE.m14310sha512(interfaceC5062Source);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_hash")
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m20073deprecated_hash() {
        return m14306hash();
    }

    @InterfaceC1231JvmName(m6260name = "hash")
    /* renamed from: hash */
    public final ByteString m14306hash() throws IllegalStateException {
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

    @Override // p132okio.ForwardingSource, p132okio.InterfaceC5062Source
    /* renamed from: read */
    public long mo2305read(C5052Buffer sink, long byteCount) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long jMo2305read = super.mo2305read(sink, byteCount);
        if (jMo2305read != -1) {
            long jM14225size = sink.m14225size() - jMo2305read;
            long jM14225size2 = sink.m14225size();
            C5059Segment c5059Segment = sink.head;
            Intrinsics.checkNotNull(c5059Segment);
            while (jM14225size2 > jM14225size) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size2 -= c5059Segment.limit - c5059Segment.pos;
            }
            while (jM14225size2 < sink.m14225size()) {
                int i = (int) ((c5059Segment.pos + jM14225size) - jM14225size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(c5059Segment.data, i, c5059Segment.limit - i);
                } else {
                    Mac mac = this.mac;
                    Intrinsics.checkNotNull(mac);
                    mac.update(c5059Segment.data, i, c5059Segment.limit - i);
                }
                jM14225size2 += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size = jM14225size2;
            }
        }
        return jMo2305read;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSource(InterfaceC5062Source source, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        this(source, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(InterfaceC5062Source source, Mac mac) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSource(InterfaceC5062Source source, ByteString key, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            Intrinsics.checkNotNull(mac);
            this(source, mac);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
