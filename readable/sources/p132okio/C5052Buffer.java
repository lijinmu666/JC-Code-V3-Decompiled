package p132okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
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
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Charsets;
import p094kotlin.p117text.Typography;
import p132okio.internal.C5067Buffer;

@Metadata(m4987d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0094\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J \u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\nJ\u001a\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\nJ \u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b+J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\nH\u0016J\b\u00106\u001a\u000207H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0016J'\u00108\u001a\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020<2\f\u00109\u001a\b\u0012\u0004\u0012\u0002H;0=H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010E\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010DH\u0016J\b\u0010I\u001a\u00020DH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020/H\u0016J\b\u0010L\u001a\u00020MH\u0016J\u0010\u0010L\u001a\u00020M2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020MH\u0016J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020MH\u0016J \u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010@\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020\u0019J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u000207H\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u0002072\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020DH\u0016J \u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/H\u0016J\u0010\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020/H\u0016J\u0018\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0016J(\u0010Z\u001a\u00020\u00002\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020MH\u0016J \u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020M2\u0006\u0010!\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010[\u001a\u00020OH\u0016J\u0010\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020]H\u0016J\u0018\u0010R\u001a\u00020\u00002\u0006\u0010[\u001a\u00020]2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020/H\u0016J\u0010\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010b\u001a\u00020\u00002\u0006\u0010a\u001a\u00020/H\u0016J\u0010\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010d\u001a\u00020/H\u0016J\u0010\u0010f\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010h\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010i\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\nH\u0016J\u0015\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020/H\u0000¢\u0006\u0002\bmJ\u0018\u0010R\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010N\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\nH\u0016J \u0010n\u001a\u00020\n2\u0006\u0010_\u001a\u00020(2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J\u0018\u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J \u0010n\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0016J\u0010\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u000207H\u0016J\u0018\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u0002072\u0006\u0010o\u001a\u00020\nH\u0016J\u0018\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u000207H\u0016J(\u0010t\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010q\u001a\u0002072\u0006\u0010u\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020/H\u0016J\b\u0010v\u001a\u00020\u0019H\u0016J\b\u0010w\u001a\u00020\u0017H\u0016J\b\u0010x\u001a\u00020\u0019H\u0016J\b\u0010y\u001a\u00020zH\u0016J\u0006\u0010{\u001a\u000207J\u0006\u0010|\u001a\u000207J\u0006\u0010}\u001a\u000207J\u0006\u0010~\u001a\u000207J\u0011\u0010\u007f\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020DH\u0002J\u0010\u0010\u0081\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0083\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u0010\u0010\u0084\u0001\u001a\u0002072\u0007\u0010\u0082\u0001\u001a\u000207J\u001b\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020D2\u0007\u0010\u0082\u0001\u001a\u000207H\u0002J\u0015\u0010\u0086\u0001\u001a\u00020\u00172\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010<H\u0096\u0002J\t\u0010\u0088\u0001\u001a\u00020/H\u0016J\t\u0010\u0089\u0001\u001a\u00020DH\u0016J\u0007\u0010\u008a\u0001\u001a\u00020\u0000J\t\u0010\u008b\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010\u008c\u0001\u001a\u000207J\u000f\u0010\u008c\u0001\u001a\u0002072\u0006\u0010\u001a\u001a\u00020/J\u0016\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0016\u0010\u0090\u0001\u001a\u00030\u008e\u00012\n\b\u0002\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0017\u0010+\u001a\u00020(2\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0092\u0001J\u000e\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0003\b\u0093\u0001R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0095\u0001"}, m4988d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", BuildConfig.f24315FLAVOR, "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "head", "Lokio/Segment;", "value", BuildConfig.f24315FLAVOR, "size", "()J", "setSize$okio", "(J)V", "buffer", "getBuffer", "()Lokio/Buffer;", "outputStream", "Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", BuildConfig.f24315FLAVOR, "require", BuildConfig.f24315FLAVOR, "byteCount", "request", "peek", "inputStream", "Ljava/io/InputStream;", "copyTo", "out", "offset", "writeTo", "readFrom", "input", "forever", "completeSegmentByteCount", "readByte", BuildConfig.f24315FLAVOR, "get", "pos", "getByte", "readShort", BuildConfig.f24315FLAVOR, "readInt", BuildConfig.f24315FLAVOR, "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "Lokio/ByteString;", "select", "options", "Lokio/Options;", "T", BuildConfig.f24315FLAVOR, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readFully", "sink", "readAll", "Lokio/Sink;", "readUtf8", BuildConfig.f24315FLAVOR, "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readByteArray", BuildConfig.f24315FLAVOR, "read", "Ljava/nio/ByteBuffer;", "clear", "skip", "write", "byteString", "writeUtf8", "string", "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "source", "writeAll", "Lokio/Source;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "writableSegment", "minimumCapacity", "writableSegment$okio", "indexOf", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "flush", "isOpen", "close", "timeout", "Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", CMSAttributeTableGenerator.f18937DIGEST, "algorithm", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "equals", "other", "hashCode", "toString", "copy", "clone", "snapshot", "readUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "UnsafeCursor", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 Buffer.kt\nokio/internal/-Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 BufferedSource.kt\nokio/internal/-BufferedSource\n*L\n1#1,649:1\n90#2:650\n87#2:683\n87#2:685\n75#2:745\n75#2:771\n84#2:810\n78#2:821\n90#2:1014\n75#2:1029\n87#2:1133\n241#3,32:651\n276#3,10:686\n289#3,18:696\n411#3,2:714\n109#3:716\n413#3:717\n111#3,18:718\n310#3,9:736\n319#3,15:746\n337#3,10:761\n347#3,3:772\n345#3,25:775\n373#3,10:800\n383#3:811\n381#3,9:812\n390#3,7:822\n388#3,20:829\n651#3,60:849\n714#3,56:909\n772#3:965\n775#3:966\n776#3,6:968\n786#3,7:974\n796#3,6:984\n804#3,5:990\n836#3,6:995\n846#3:1001\n847#3,11:1003\n858#3,5:1015\n867#3,9:1020\n877#3,61:1030\n602#3:1091\n605#3:1092\n606#3,5:1094\n613#3:1099\n616#3,7:1100\n625#3,20:1107\n417#3:1127\n420#3,5:1128\n425#3,10:1134\n436#3,7:1144\n441#3,2:1151\n942#3:1153\n943#3,87:1155\n1033#3,48:1242\n572#3:1290\n579#3,21:1291\n1084#3,7:1312\n1094#3,7:1319\n1104#3,4:1326\n1111#3,8:1330\n1122#3,10:1338\n1135#3,14:1348\n446#3,35:1362\n512#3,40:1397\n555#3:1437\n557#3,13:1439\n1152#3:1452\n1203#3:1453\n1204#3,39:1455\n1245#3,2:1494\n1247#3,4:1497\n1254#3,3:1501\n1258#3,4:1505\n109#3:1509\n1262#3,22:1510\n111#3,18:1532\n1337#3,2:1550\n1340#3:1553\n109#3:1554\n1341#3,50:1555\n111#3,18:1605\n1400#3,12:1623\n1415#3,32:1635\n1450#3,12:1667\n1465#3,18:1679\n1487#3:1697\n1488#3:1699\n1493#3,34:1700\n1#4:684\n1#4:967\n1#4:1002\n1#4:1093\n1#4:1154\n1#4:1438\n1#4:1454\n1#4:1496\n1#4:1504\n1#4:1552\n1#4:1698\n27#5,3:981\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer\n*L\n167#1:650\n197#1:683\n235#1:685\n261#1:745\n264#1:771\n267#1:810\n267#1:821\n337#1:1014\n340#1:1029\n376#1:1133\n181#1:651,32\n252#1:686,10\n255#1:696,18\n258#1:714,2\n258#1:716\n258#1:717\n258#1:718,18\n261#1:736,9\n261#1:746,15\n264#1:761,10\n264#1:772,3\n264#1:775,25\n267#1:800,10\n267#1:811\n267#1:812,9\n267#1:822,7\n267#1:829,20\n279#1:849,60\n282#1:909,56\n284#1:965\n287#1:966\n287#1:968,6\n289#1:974,7\n294#1:984,6\n297#1:990,5\n331#1:995,6\n337#1:1001\n337#1:1003,11\n337#1:1015,5\n340#1:1020,9\n340#1:1030,61\n342#1:1091\n345#1:1092\n345#1:1094,5\n347#1:1099\n350#1:1100,7\n353#1:1107,20\n373#1:1127\n376#1:1128,5\n376#1:1134,10\n378#1:1144,7\n381#1:1151,2\n386#1:1153\n386#1:1155,87\n389#1:1242,48\n412#1:1290\n418#1:1291,21\n439#1:1312,7\n443#1:1319,7\n445#1:1326,4\n447#1:1330,8\n451#1:1338,10\n455#1:1348,14\n459#1:1362,35\n462#1:1397,40\n465#1:1437\n465#1:1439,13\n467#1:1452\n467#1:1453\n467#1:1455,39\n469#1:1494,2\n469#1:1497,4\n480#1:1501,3\n480#1:1505,4\n480#1:1509\n480#1:1510,22\n480#1:1532,18\n496#1:1550,2\n496#1:1553\n496#1:1554\n496#1:1555,50\n496#1:1605,18\n506#1:1623,12\n576#1:1635,32\n578#1:1667,12\n586#1:1679,18\n594#1:1697\n594#1:1699\n596#1:1700,34\n287#1:967\n337#1:1002\n345#1:1093\n386#1:1154\n465#1:1438\n467#1:1454\n469#1:1496\n480#1:1504\n496#1:1552\n594#1:1698\n291#1:981,3\n*E\n"})
/* renamed from: okio.Buffer */
/* loaded from: classes.dex */
public final class C5052Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    public C5059Segment head;
    private long size;

    @Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m4988d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "buffer", "Lokio/Buffer;", "readWrite", BuildConfig.f24315FLAVOR, "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "offset", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "start", BuildConfig.f24315FLAVOR, "end", "next", "seek", "resizeBuffer", "newSize", "expandBuffer", "minByteCount", "close", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n+ 2 Buffer.kt\nokio/internal/-Buffer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,649:1\n1546#2:650\n1547#2:652\n1551#2:653\n1552#2,68:655\n1623#2:723\n1624#2,32:725\n1656#2,18:758\n1677#2:776\n1678#2,18:778\n1700#2:796\n1702#2,7:798\n1#3:651\n1#3:654\n1#3:724\n1#3:777\n1#3:797\n87#4:757\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n*L\n636#1:650\n636#1:652\n638#1:653\n638#1:655,68\n640#1:723\n640#1:725,32\n640#1:758,18\n642#1:776\n642#1:778,18\n645#1:796\n645#1:798,7\n636#1:651\n638#1:654\n640#1:724\n642#1:777\n645#1:797\n640#1:757\n*E\n"})
    /* renamed from: okio.Buffer$UnsafeCursor */
    public static final class UnsafeCursor implements Closeable {

        @JvmField
        public C5052Buffer buffer;

        @JvmField
        public byte[] data;

        @JvmField
        public boolean readWrite;
        private C5059Segment segment;

        @JvmField
        public long offset = -1;

        @JvmField
        public int start = -1;

        @JvmField
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int minByteCount) {
            if (minByteCount <= 0) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + minByteCount).toString());
            }
            if (minByteCount > 8192) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + minByteCount).toString());
            }
            C5052Buffer c5052Buffer = this.buffer;
            if (c5052Buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long jM14225size = c5052Buffer.m14225size();
            C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(minByteCount);
            int i = 8192 - c5059SegmentWritableSegment$okio.limit;
            c5059SegmentWritableSegment$okio.limit = 8192;
            long j = i;
            c5052Buffer.setSize$okio(jM14225size + j);
            setSegment$okio(c5059SegmentWritableSegment$okio);
            this.offset = jM14225size;
            this.data = c5059SegmentWritableSegment$okio.data;
            this.start = 8192 - i;
            this.end = 8192;
            return j;
        }

        /* renamed from: getSegment$okio, reason: from getter */
        public final C5059Segment getSegment() {
            return this.segment;
        }

        /* renamed from: next */
        public final int m14234next() {
            long j = this.offset;
            C5052Buffer c5052Buffer = this.buffer;
            Intrinsics.checkNotNull(c5052Buffer);
            if (j == c5052Buffer.m14225size()) {
                throw new IllegalStateException("no more bytes");
            }
            long j2 = this.offset;
            return m14235seek(j2 == -1 ? 0L : j2 + (this.end - this.start));
        }

        public final long resizeBuffer(long newSize) {
            C5052Buffer c5052Buffer = this.buffer;
            if (c5052Buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long jM14225size = c5052Buffer.m14225size();
            if (newSize <= jM14225size) {
                if (newSize < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
                }
                long j = jM14225size - newSize;
                while (true) {
                    if (j <= 0) {
                        break;
                    }
                    C5059Segment c5059Segment = c5052Buffer.head;
                    Intrinsics.checkNotNull(c5059Segment);
                    C5059Segment c5059Segment2 = c5059Segment.prev;
                    Intrinsics.checkNotNull(c5059Segment2);
                    int i = c5059Segment2.limit;
                    long j2 = i - c5059Segment2.pos;
                    if (j2 > j) {
                        c5059Segment2.limit = i - ((int) j);
                        break;
                    }
                    c5052Buffer.head = c5059Segment2.m14380pop();
                    SegmentPool.m14384recycle(c5059Segment2);
                    j -= j2;
                }
                setSegment$okio(null);
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > jM14225size) {
                long j3 = newSize - jM14225size;
                boolean z = true;
                while (j3 > 0) {
                    C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(1);
                    int iMin = (int) Math.min(j3, 8192 - c5059SegmentWritableSegment$okio.limit);
                    c5059SegmentWritableSegment$okio.limit += iMin;
                    j3 -= iMin;
                    if (z) {
                        setSegment$okio(c5059SegmentWritableSegment$okio);
                        this.offset = jM14225size;
                        this.data = c5059SegmentWritableSegment$okio.data;
                        int i2 = c5059SegmentWritableSegment$okio.limit;
                        this.start = i2 - iMin;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            c5052Buffer.setSize$okio(newSize);
            return jM14225size;
        }

        /* renamed from: seek */
        public final int m14235seek(long offset) {
            C5059Segment c5059SegmentM14381push;
            C5052Buffer c5052Buffer = this.buffer;
            if (c5052Buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (offset < -1 || offset > c5052Buffer.m14225size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + c5052Buffer.m14225size());
            }
            if (offset == -1 || offset == c5052Buffer.m14225size()) {
                setSegment$okio(null);
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long jM14225size = c5052Buffer.m14225size();
            C5059Segment segment = c5052Buffer.head;
            long j = 0;
            if (getSegment() != null) {
                long j2 = this.offset;
                int i = this.start;
                Intrinsics.checkNotNull(getSegment());
                long j3 = j2 - (i - r9.pos);
                if (j3 > offset) {
                    c5059SegmentM14381push = segment;
                    segment = getSegment();
                    jM14225size = j3;
                } else {
                    c5059SegmentM14381push = getSegment();
                    j = j3;
                }
            } else {
                c5059SegmentM14381push = segment;
            }
            if (jM14225size - offset > offset - j) {
                while (true) {
                    Intrinsics.checkNotNull(c5059SegmentM14381push);
                    int i2 = c5059SegmentM14381push.limit;
                    int i3 = c5059SegmentM14381push.pos;
                    if (offset < (i2 - i3) + j) {
                        break;
                    }
                    j += i2 - i3;
                    c5059SegmentM14381push = c5059SegmentM14381push.next;
                }
            } else {
                while (jM14225size > offset) {
                    Intrinsics.checkNotNull(segment);
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    jM14225size -= segment.limit - segment.pos;
                }
                j = jM14225size;
                c5059SegmentM14381push = segment;
            }
            if (this.readWrite) {
                Intrinsics.checkNotNull(c5059SegmentM14381push);
                if (c5059SegmentM14381push.shared) {
                    C5059Segment c5059SegmentUnsharedCopy = c5059SegmentM14381push.unsharedCopy();
                    if (c5052Buffer.head == c5059SegmentM14381push) {
                        c5052Buffer.head = c5059SegmentUnsharedCopy;
                    }
                    c5059SegmentM14381push = c5059SegmentM14381push.m14381push(c5059SegmentUnsharedCopy);
                    C5059Segment c5059Segment = c5059SegmentM14381push.prev;
                    Intrinsics.checkNotNull(c5059Segment);
                    c5059Segment.m14380pop();
                }
            }
            setSegment$okio(c5059SegmentM14381push);
            this.offset = offset;
            Intrinsics.checkNotNull(c5059SegmentM14381push);
            this.data = c5059SegmentM14381push.data;
            int i4 = c5059SegmentM14381push.pos + ((int) (offset - j));
            this.start = i4;
            int i5 = c5059SegmentM14381push.limit;
            this.end = i5;
            return i5 - i4;
        }

        public final void setSegment$okio(C5059Segment c5059Segment) {
            this.segment = c5059Segment;
        }
    }

    public static /* synthetic */ C5052Buffer copyTo$default(C5052Buffer c5052Buffer, OutputStream outputStream, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = c5052Buffer.size - j3;
        }
        return c5052Buffer.m14200copyTo(outputStream, j3, j2);
    }

    /* renamed from: digest */
    private final ByteString m14191digest(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        C5059Segment c5059Segment = this.head;
        if (c5059Segment != null) {
            byte[] bArr = c5059Segment.data;
            int i = c5059Segment.pos;
            messageDigest.update(bArr, i, c5059Segment.limit - i);
            C5059Segment c5059Segment2 = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment2);
            while (c5059Segment2 != c5059Segment) {
                byte[] bArr2 = c5059Segment2.data;
                int i2 = c5059Segment2.pos;
                messageDigest.update(bArr2, i2, c5059Segment2.limit - i2);
                c5059Segment2 = c5059Segment2.next;
                Intrinsics.checkNotNull(c5059Segment2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return new ByteString(bArrDigest);
    }

    /* renamed from: hmac */
    private final ByteString m14192hmac(String algorithm, ByteString key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.internalArray$okio(), algorithm));
            C5059Segment c5059Segment = this.head;
            if (c5059Segment != null) {
                byte[] bArr = c5059Segment.data;
                int i = c5059Segment.pos;
                mac.update(bArr, i, c5059Segment.limit - i);
                C5059Segment c5059Segment2 = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment2);
                while (c5059Segment2 != c5059Segment) {
                    byte[] bArr2 = c5059Segment2.data;
                    int i2 = c5059Segment2.pos;
                    mac.update(bArr2, i2, c5059Segment2.limit - i2);
                    c5059Segment2 = c5059Segment2.next;
                    Intrinsics.checkNotNull(c5059Segment2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(C5052Buffer c5052Buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return c5052Buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(C5052Buffer c5052Buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return c5052Buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ C5052Buffer writeTo$default(C5052Buffer c5052Buffer, OutputStream outputStream, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = c5052Buffer.size;
        }
        return c5052Buffer.m14233writeTo(outputStream, j);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m20056deprecated_getByte(long index) {
        return m14205getByte(index);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "size", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    @Override // p132okio.BufferedSource, p132okio.BufferedSink
    /* renamed from: buffer */
    public C5052Buffer getBufferField() {
        return this;
    }

    /* renamed from: clear */
    public final void m14194clear() throws EOFException {
        mo14226skip(m14225size());
    }

    @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long jM14225size = m14225size();
        if (jM14225size == 0) {
            return 0L;
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        C5059Segment c5059Segment2 = c5059Segment.prev;
        Intrinsics.checkNotNull(c5059Segment2);
        if (c5059Segment2.limit < 8192 && c5059Segment2.owner) {
            jM14225size -= r2 - c5059Segment2.pos;
        }
        return jM14225size;
    }

    /* renamed from: copy */
    public final C5052Buffer m14197copy() {
        C5052Buffer c5052Buffer = new C5052Buffer();
        if (m14225size() != 0) {
            C5059Segment c5059Segment = this.head;
            Intrinsics.checkNotNull(c5059Segment);
            C5059Segment c5059SegmentSharedCopy = c5059Segment.sharedCopy();
            c5052Buffer.head = c5059SegmentSharedCopy;
            c5059SegmentSharedCopy.prev = c5059SegmentSharedCopy;
            c5059SegmentSharedCopy.next = c5059SegmentSharedCopy;
            for (C5059Segment c5059Segment2 = c5059Segment.next; c5059Segment2 != c5059Segment; c5059Segment2 = c5059Segment2.next) {
                C5059Segment c5059Segment3 = c5059SegmentSharedCopy.prev;
                Intrinsics.checkNotNull(c5059Segment3);
                Intrinsics.checkNotNull(c5059Segment2);
                c5059Segment3.m14381push(c5059Segment2.sharedCopy());
            }
            c5052Buffer.setSize$okio(m14225size());
        }
        return c5052Buffer;
    }

    @JvmOverloads
    /* renamed from: copyTo */
    public final C5052Buffer m14198copyTo(OutputStream out) {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, (Object) null);
    }

    @Override // p132okio.BufferedSink
    /* renamed from: emit */
    public C5052Buffer mo14203emit() {
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer emitCompleteSegments() {
        return this;
    }

    /* renamed from: equals */
    public boolean m14204equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof C5052Buffer) {
            C5052Buffer c5052Buffer = (C5052Buffer) other;
            if (m14225size() == c5052Buffer.m14225size()) {
                if (m14225size() == 0) {
                    return true;
                }
                C5059Segment c5059Segment = this.head;
                Intrinsics.checkNotNull(c5059Segment);
                C5059Segment c5059Segment2 = c5052Buffer.head;
                Intrinsics.checkNotNull(c5059Segment2);
                int i = c5059Segment.pos;
                int i2 = c5059Segment2.pos;
                long j = 0;
                while (j < m14225size()) {
                    long jMin = Math.min(c5059Segment.limit - i, c5059Segment2.limit - i2);
                    long j2 = 0;
                    while (j2 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (c5059Segment.data[i] == c5059Segment2.data[i2]) {
                            j2++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == c5059Segment.limit) {
                        c5059Segment = c5059Segment.next;
                        Intrinsics.checkNotNull(c5059Segment);
                        i = c5059Segment.pos;
                    }
                    if (i2 == c5059Segment2.limit) {
                        c5059Segment2 = c5059Segment2.next;
                        Intrinsics.checkNotNull(c5059Segment2);
                        i2 = c5059Segment2.pos;
                    }
                    j += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // p132okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // p132okio.BufferedSink, p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() {
    }

    @Override // p132okio.BufferedSource, p132okio.BufferedSink
    public C5052Buffer getBuffer() {
        return this;
    }

    @InterfaceC1231JvmName(m6260name = "getByte")
    /* renamed from: getByte */
    public final byte m14205getByte(long pos) {
        SegmentedByteString.checkOffsetAndCount(m14225size(), pos, 1L);
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (m14225size() - pos < pos) {
            long jM14225size = m14225size();
            while (jM14225size > pos) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            Intrinsics.checkNotNull(c5059Segment);
            return c5059Segment.data[(int) ((c5059Segment.pos + pos) - jM14225size)];
        }
        long j = 0;
        while (true) {
            long j2 = (c5059Segment.limit - c5059Segment.pos) + j;
            if (j2 > pos) {
                Intrinsics.checkNotNull(c5059Segment);
                return c5059Segment.data[(int) ((c5059Segment.pos + pos) - j)];
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            j = j2;
        }
    }

    public int hashCode() {
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c5059Segment.limit;
            for (int i3 = c5059Segment.pos; i3 < i2; i3++) {
                i = (i * 31) + c5059Segment.data[i3];
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
        } while (c5059Segment != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return m14192hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return m14192hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return m14192hmac("HmacSHA512", key);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14206indexOf(byte b) {
        return mo14208indexOf(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // p132okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(C5052Buffer.this.m14225size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (C5052Buffer.this.m14225size() > 0) {
                    return C5052Buffer.this.readByte() & C1126UByte.MAX_VALUE;
                }
                return -1;
            }

            public String toString() {
                return C5052Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return C5052Buffer.this.mo14215read(sink, offset, byteCount);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* renamed from: md5 */
    public final ByteString m14212md5() {
        return m14191digest("MD5");
    }

    @Override // p132okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return C5052Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int b) {
                C5052Buffer.this.writeByte(b);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                C5052Buffer.this.mo14231write(data, offset, byteCount);
            }
        };
    }

    @Override // p132okio.BufferedSource
    /* renamed from: peek */
    public BufferedSource mo14213peek() {
        return C5053Okio.m14316buffer(new PeekSource(this));
    }

    @Override // p132okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.m14252size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), c5059Segment.limit - c5059Segment.pos);
        sink.put(c5059Segment.data, c5059Segment.pos, iMin);
        int i = c5059Segment.pos + iMin;
        c5059Segment.pos = i;
        this.size -= iMin;
        if (i == c5059Segment.limit) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return iMin;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: readAll */
    public long mo14216readAll(InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long jM14225size = m14225size();
        if (jM14225size > 0) {
            sink.mo2303write(this, jM14225size);
        }
        return jM14225size;
    }

    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @Override // p132okio.BufferedSource
    public byte readByte() throws EOFException {
        if (m14225size() == 0) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        int i3 = i + 1;
        byte b = c5059Segment.data[i];
        setSize$okio(m14225size() - 1);
        if (i3 == i2) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i3;
        }
        return b;
    }

    @Override // p132okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(m14225size());
    }

    @Override // p132okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(m14225size());
    }

    @Override // p132okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (m14225size() == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j = 0;
        long j2 = -7;
        boolean z2 = false;
        do {
            C5059Segment c5059Segment = this.head;
            Intrinsics.checkNotNull(c5059Segment);
            byte[] bArr = c5059Segment.data;
            int i2 = c5059Segment.pos;
            int i3 = c5059Segment.limit;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j < C5067Buffer.OVERFLOW_ZONE || (j == C5067Buffer.OVERFLOW_ZONE && i4 < j2)) {
                        C5052Buffer c5052BufferWriteByte = new C5052Buffer().writeDecimalLong(j).writeByte((int) b);
                        if (!z) {
                            c5052BufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + c5052BufferWriteByte.readUtf8());
                    }
                    j = (j * 10) + i4;
                } else {
                    if (b != 45 || i != 0) {
                        z2 = true;
                        break;
                    }
                    j2--;
                    z = true;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                this.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            } else {
                c5059Segment.pos = i2;
            }
            if (z2) {
                break;
            }
        } while (this.head != null);
        setSize$okio(m14225size() - i);
        if (i >= (z ? 2 : 1)) {
            return z ? j : -j;
        }
        if (m14225size() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + SegmentedByteString.toHexString(m14205getByte(0L)));
    }

    public final C5052Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        readFrom(input, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    @Override // p132okio.BufferedSource
    public void readFully(C5052Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (m14225size() >= byteCount) {
            sink.mo2303write(this, byteCount);
        } else {
            sink.mo2303write(this, m14225size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7 A[EDGE_INSN: B:43:0x00a7->B:37:0x00a7 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // p132okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (m14225size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            C5059Segment c5059Segment = this.head;
            Intrinsics.checkNotNull(c5059Segment);
            byte[] bArr = c5059Segment.data;
            int i3 = c5059Segment.pos;
            int i4 = c5059Segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else if (b >= 65 && b <= 70) {
                    i = b - 55;
                } else {
                    if (i2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b));
                    }
                    z = true;
                    if (i3 != i4) {
                        this.head = c5059Segment.m14380pop();
                        SegmentPool.m14384recycle(c5059Segment);
                    } else {
                        c5059Segment.pos = i3;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new C5052Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (this.head != null);
        setSize$okio(m14225size() - i2);
        return j;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: readInt */
    public int mo14217readInt() throws EOFException {
        if (m14225size() < 4) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 4) {
            return (readByte() & C1126UByte.MAX_VALUE) | ((readByte() & C1126UByte.MAX_VALUE) << 24) | ((readByte() & C1126UByte.MAX_VALUE) << 16) | ((readByte() & C1126UByte.MAX_VALUE) << 8);
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i] & C1126UByte.MAX_VALUE) << 24) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & C1126UByte.MAX_VALUE) | i4;
        setSize$okio(m14225size() - 4);
        if (i5 == i2) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i5;
        }
        return i6;
    }

    @Override // p132okio.BufferedSource
    public int readIntLe() {
        return SegmentedByteString.reverseBytes(mo14217readInt());
    }

    @Override // p132okio.BufferedSource
    public long readLong() throws EOFException {
        if (m14225size() < 8) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 8) {
            return ((mo14217readInt() & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & mo14217readInt());
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 7;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        setSize$okio(m14225size() - 8);
        if (i4 == i2) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i4;
        }
        return j2;
    }

    @Override // p132okio.BufferedSource
    public long readLongLe() {
        return SegmentedByteString.reverseBytes(readLong());
    }

    @Override // p132okio.BufferedSource
    public short readShort() throws EOFException {
        if (m14225size() < 2) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 2) {
            return (short) ((readByte() & C1126UByte.MAX_VALUE) | ((readByte() & C1126UByte.MAX_VALUE) << 8));
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & C1126UByte.MAX_VALUE) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & C1126UByte.MAX_VALUE) | i4;
        setSize$okio(m14225size() - 2);
        if (i5 == i2) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // p132okio.BufferedSource
    public short readShortLe() {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @Override // p132okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @JvmOverloads
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @Override // p132okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // p132okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (m14225size() == 0) {
            throw new EOFException();
        }
        byte bM14205getByte = m14205getByte(0L);
        if ((bM14205getByte & ByteCompanionObject.MIN_VALUE) == 0) {
            i = bM14205getByte & ByteCompanionObject.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((bM14205getByte & 224) == 192) {
            i = bM14205getByte & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bM14205getByte & 240) == 224) {
            i = bM14205getByte & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bM14205getByte & 248) != 240) {
                mo14226skip(1L);
                return C5066Utf8.REPLACEMENT_CODE_POINT;
            }
            i = bM14205getByte & 7;
            i2 = 4;
            i3 = PKIFailureInfo.notAuthorized;
        }
        long j = i2;
        if (m14225size() < j) {
            throw new EOFException("size < " + i2 + ": " + m14225size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(bM14205getByte) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bM14205getByte2 = m14205getByte(j2);
            if ((bM14205getByte2 & 192) != 128) {
                mo14226skip(j2);
                return C5066Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (bM14205getByte2 & C5066Utf8.REPLACEMENT_BYTE);
        }
        mo14226skip(j);
        return i > 1114111 ? C5066Utf8.REPLACEMENT_CODE_POINT : ((55296 > i || i >= 57344) && i >= i3) ? i : C5066Utf8.REPLACEMENT_CODE_POINT;
    }

    @Override // p132okio.BufferedSource
    public String readUtf8Line() {
        long jMo14206indexOf = mo14206indexOf((byte) 10);
        if (jMo14206indexOf != -1) {
            return C5067Buffer.readUtf8Line(this, jMo14206indexOf);
        }
        if (m14225size() != 0) {
            return readUtf8(m14225size());
        }
        return null;
    }

    @Override // p132okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: request */
    public boolean mo14218request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: require */
    public void mo14219require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // p132okio.BufferedSource
    /* renamed from: select */
    public int mo14220select(C5054Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iSelectPrefix$default = C5067Buffer.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        mo14226skip(options.getByteStrings()[iSelectPrefix$default].m14252size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    /* renamed from: sha1 */
    public final ByteString m14222sha1() {
        return m14191digest("SHA-1");
    }

    /* renamed from: sha256 */
    public final ByteString m14223sha256() {
        return m14191digest(XMSSKeyParameters.f23621SHA_256);
    }

    /* renamed from: sha512 */
    public final ByteString m14224sha512() {
        return m14191digest(XMSSKeyParameters.f23622SHA_512);
    }

    @InterfaceC1231JvmName(m6260name = "size")
    /* renamed from: size */
    public final long m14225size() {
        return this.size;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: skip */
    public void mo14226skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            C5059Segment c5059Segment = this.head;
            if (c5059Segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
            long j = iMin;
            setSize$okio(m14225size() - j);
            byteCount -= j;
            int i = c5059Segment.pos + iMin;
            c5059Segment.pos = i;
            if (i == c5059Segment.limit) {
                this.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            }
        }
    }

    public final ByteString snapshot() {
        if (m14225size() <= 2147483647L) {
            return snapshot((int) m14225size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + m14225size()).toString());
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return C5065Timeout.f17852NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final C5059Segment writableSegment$okio(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            C5059Segment c5059SegmentM14385take = SegmentPool.m14385take();
            this.head = c5059SegmentM14385take;
            c5059SegmentM14385take.prev = c5059SegmentM14385take;
            c5059SegmentM14385take.next = c5059SegmentM14385take;
            return c5059SegmentM14385take;
        }
        Intrinsics.checkNotNull(c5059Segment);
        C5059Segment c5059SegmentM14381push = c5059Segment.prev;
        Intrinsics.checkNotNull(c5059SegmentM14381push);
        if (c5059SegmentM14381push.limit + minimumCapacity > 8192 || !c5059SegmentM14381push.owner) {
            c5059SegmentM14381push = c5059SegmentM14381push.m14381push(SegmentPool.m14385take());
        }
        return c5059SegmentM14381push;
    }

    @Override // p132okio.BufferedSink
    public long writeAll(InterfaceC5062Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long jMo2305read = source.mo2305read(this, 8192L);
            if (jMo2305read == -1) {
                return j;
            }
            j += jMo2305read;
        }
    }

    @JvmOverloads
    /* renamed from: writeTo */
    public final C5052Buffer m14232writeTo(OutputStream out) {
        Intrinsics.checkNotNullParameter(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C5052Buffer m14195clone() {
        return m14197copy();
    }

    @JvmOverloads
    /* renamed from: copyTo */
    public final C5052Buffer m14199copyTo(OutputStream out, long j) {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, j, 0L, 4, (Object) null);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14207indexOf(byte b, long fromIndex) {
        return mo14208indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long jM14225size = 0;
        if (fromIndex < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            return -1L;
        }
        if (m14225size() - fromIndex < fromIndex) {
            jM14225size = m14225size();
            while (jM14225size > fromIndex) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            if (targetBytes.m14252size() == 2) {
                byte bM14242getByte = targetBytes.m14242getByte(0);
                byte bM14242getByte2 = targetBytes.m14242getByte(1);
                while (jM14225size < m14225size()) {
                    byte[] bArr = c5059Segment.data;
                    i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
                    int i3 = c5059Segment.limit;
                    while (i < i3) {
                        byte b = bArr[i];
                        if (b == bM14242getByte || b == bM14242getByte2) {
                            i2 = c5059Segment.pos;
                        } else {
                            i++;
                        }
                    }
                    jM14225size += c5059Segment.limit - c5059Segment.pos;
                    c5059Segment = c5059Segment.next;
                    Intrinsics.checkNotNull(c5059Segment);
                    fromIndex = jM14225size;
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
            while (jM14225size < m14225size()) {
                byte[] bArr2 = c5059Segment.data;
                i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
                int i4 = c5059Segment.limit;
                while (i < i4) {
                    byte b2 = bArr2[i];
                    for (byte b3 : bArrInternalArray$okio) {
                        if (b2 == b3) {
                            i2 = c5059Segment.pos;
                        }
                    }
                    i++;
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                fromIndex = jM14225size;
            }
            return -1L;
        }
        while (true) {
            long j = (c5059Segment.limit - c5059Segment.pos) + jM14225size;
            if (j > fromIndex) {
                break;
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jM14225size = j;
        }
        if (targetBytes.m14252size() == 2) {
            byte bM14242getByte3 = targetBytes.m14242getByte(0);
            byte bM14242getByte4 = targetBytes.m14242getByte(1);
            while (jM14225size < m14225size()) {
                byte[] bArr3 = c5059Segment.data;
                i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
                int i5 = c5059Segment.limit;
                while (i < i5) {
                    byte b4 = bArr3[i];
                    if (b4 == bM14242getByte3 || b4 == bM14242getByte4) {
                        i2 = c5059Segment.pos;
                    } else {
                        i++;
                    }
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                fromIndex = jM14225size;
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
        while (jM14225size < m14225size()) {
            byte[] bArr4 = c5059Segment.data;
            i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
            int i6 = c5059Segment.limit;
            while (i < i6) {
                byte b5 = bArr4[i];
                for (byte b6 : bArrInternalArray$okio2) {
                    if (b5 == b6) {
                        i2 = c5059Segment.pos;
                    }
                }
                i++;
            }
            jM14225size += c5059Segment.limit - c5059Segment.pos;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            fromIndex = jM14225size;
        }
        return -1L;
        return (i - i2) + jM14225size;
    }

    @Override // p132okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (byteCount >= 0 && offset >= 0 && byteCount + offset <= m14225size() && bytesOffset >= 0 && bytesOffset + byteCount <= bytes.m14252size()) {
            return byteCount == 0 || C5067Buffer.commonIndexOf(this, bytes, offset, offset + 1, bytesOffset, byteCount) != -1;
        }
        return false;
    }

    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return C5067Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // p132okio.BufferedSource
    public byte[] readByteArray(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (m14225size() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        readFully(bArr);
        return bArr;
    }

    @Override // p132okio.BufferedSource
    public ByteString readByteString(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (m14225size() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < 4096) {
            return new ByteString(readByteArray(byteCount));
        }
        ByteString byteStringSnapshot = snapshot((int) byteCount);
        mo14226skip(byteCount);
        return byteStringSnapshot;
    }

    public final C5052Buffer readFrom(InputStream input, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        if (byteCount >= 0) {
            readFrom(input, byteCount, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
    }

    @Override // p132okio.BufferedSource
    public String readString(long byteCount, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        C5059Segment c5059Segment = this.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        if (i + byteCount > c5059Segment.limit) {
            return new String(readByteArray(byteCount), charset);
        }
        int i2 = (int) byteCount;
        String str = new String(c5059Segment.data, i, i2, charset);
        int i3 = c5059Segment.pos + i2;
        c5059Segment.pos = i3;
        this.size -= byteCount;
        if (i3 == c5059Segment.limit) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return str;
    }

    @JvmOverloads
    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return C5067Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // p132okio.BufferedSource
    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Charsets.UTF_8);
    }

    @Override // p132okio.BufferedSource
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = LongCompanionObject.MAX_VALUE;
        if (limit != LongCompanionObject.MAX_VALUE) {
            j = limit + 1;
        }
        long jMo14208indexOf = mo14208indexOf((byte) 10, 0L, j);
        if (jMo14208indexOf != -1) {
            return C5067Buffer.readUtf8Line(this, jMo14208indexOf);
        }
        if (j < m14225size() && m14205getByte(j - 1) == 13 && m14205getByte(j) == 10) {
            return C5067Buffer.readUtf8Line(this, j);
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        m14202copyTo(c5052Buffer, 0L, Math.min(32, m14225size()));
        throw new EOFException("\\n not found: limit=" + Math.min(m14225size(), limit) + " content=" + c5052Buffer.readByteString().mo14243hex() + Typography.ellipsis);
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeByte(int b) {
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit;
        c5059SegmentWritableSegment$okio.limit = i + 1;
        bArr[i] = (byte) b;
        setSize$okio(m14225size() + 1);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeDecimalLong(long v) {
        boolean z;
        if (v == 0) {
            return writeByte(48);
        }
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        int iCountDigitsIn = C5067Buffer.countDigitsIn(v);
        if (z) {
            iCountDigitsIn++;
        }
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(iCountDigitsIn);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit + iCountDigitsIn;
        while (v != 0) {
            long j = 10;
            i--;
            bArr[i] = C5067Buffer.getHEX_DIGIT_BYTES()[(int) (v % j)];
            v /= j;
        }
        if (z) {
            bArr[i - 1] = 45;
        }
        c5059SegmentWritableSegment$okio.limit += iCountDigitsIn;
        setSize$okio(m14225size() + iCountDigitsIn);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeHexadecimalUnsignedLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        long j = (v >>> 1) | v;
        long j2 = j | (j >>> 2);
        long j3 = j2 | (j2 >>> 4);
        long j4 = j3 | (j3 >>> 8);
        long j5 = j4 | (j4 >>> 16);
        long j6 = j5 | (j5 >>> 32);
        long j7 = j6 - ((j6 >>> 1) & 6148914691236517205L);
        long j8 = ((j7 >>> 2) & 3689348814741910323L) + (j7 & 3689348814741910323L);
        long j9 = ((j8 >>> 4) + j8) & 1085102592571150095L;
        long j10 = j9 + (j9 >>> 8);
        long j11 = j10 + (j10 >>> 16);
        int i = (int) ((((j11 & 63) + ((j11 >>> 32) & 63)) + 3) / 4);
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = C5067Buffer.getHEX_DIGIT_BYTES()[(int) (15 & v)];
            v >>>= 4;
        }
        c5059SegmentWritableSegment$okio.limit += i;
        setSize$okio(m14225size() + i);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeInt(int i) {
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        c5059SegmentWritableSegment$okio.limit = i2 + 4;
        setSize$okio(m14225size() + 4);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeIntLe(int i) {
        return writeInt(SegmentedByteString.reverseBytes(i));
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeLong(long v) {
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit;
        bArr[i] = (byte) ((v >>> 56) & 255);
        bArr[i + 1] = (byte) ((v >>> 48) & 255);
        bArr[i + 2] = (byte) ((v >>> 40) & 255);
        bArr[i + 3] = (byte) ((v >>> 32) & 255);
        bArr[i + 4] = (byte) ((v >>> 24) & 255);
        bArr[i + 5] = (byte) ((v >>> 16) & 255);
        bArr[i + 6] = (byte) ((v >>> 8) & 255);
        bArr[i + 7] = (byte) (v & 255);
        c5059SegmentWritableSegment$okio.limit = i + 8;
        setSize$okio(m14225size() + 8);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeLongLe(long v) {
        return writeLong(SegmentedByteString.reverseBytes(v));
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeShort(int s) {
        C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit;
        bArr[i] = (byte) ((s >>> 8) & 255);
        bArr[i + 1] = (byte) (s & 255);
        c5059SegmentWritableSegment$okio.limit = i + 2;
        setSize$okio(m14225size() + 2);
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeShortLe(int s) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) s));
    }

    @JvmOverloads
    /* renamed from: writeTo */
    public final C5052Buffer m14233writeTo(OutputStream out, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, byteCount);
        C5059Segment c5059Segment = this.head;
        while (byteCount > 0) {
            Intrinsics.checkNotNull(c5059Segment);
            int iMin = (int) Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
            out.write(c5059Segment.data, c5059Segment.pos, iMin);
            int i = c5059Segment.pos + iMin;
            c5059Segment.pos = i;
            long j = iMin;
            this.size -= j;
            byteCount -= j;
            if (i == c5059Segment.limit) {
                C5059Segment c5059SegmentM14380pop = c5059Segment.m14380pop();
                this.head = c5059SegmentM14380pop;
                SegmentPool.m14384recycle(c5059Segment);
                c5059Segment = c5059SegmentM14380pop;
            }
        }
        return this;
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = c5059SegmentWritableSegment$okio.data;
            int i = c5059SegmentWritableSegment$okio.limit;
            bArr[i] = (byte) ((codePoint >> 6) | 192);
            bArr[i + 1] = (byte) ((codePoint & 63) | 128);
            c5059SegmentWritableSegment$okio.limit = i + 2;
            setSize$okio(m14225size() + 2);
        } else if (55296 <= codePoint && codePoint < 57344) {
            writeByte(63);
        } else if (codePoint < 65536) {
            C5059Segment c5059SegmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = c5059SegmentWritableSegment$okio2.data;
            int i2 = c5059SegmentWritableSegment$okio2.limit;
            bArr2[i2] = (byte) ((codePoint >> 12) | InterfaceC5102BERTags.f17976FLAGS);
            bArr2[i2 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr2[i2 + 2] = (byte) ((codePoint & 63) | 128);
            c5059SegmentWritableSegment$okio2.limit = i2 + 3;
            setSize$okio(m14225size() + 3);
        } else {
            if (codePoint > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(codePoint));
            }
            C5059Segment c5059SegmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = c5059SegmentWritableSegment$okio3.data;
            int i3 = c5059SegmentWritableSegment$okio3.limit;
            bArr3[i3] = (byte) ((codePoint >> 18) | 240);
            bArr3[i3 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
            bArr3[i3 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr3[i3 + 3] = (byte) ((codePoint & 63) | 128);
            c5059SegmentWritableSegment$okio3.limit = i3 + 4;
            setSize$okio(m14225size() + 4);
        }
        return this;
    }

    public static /* synthetic */ C5052Buffer copyTo$default(C5052Buffer c5052Buffer, C5052Buffer c5052Buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return c5052Buffer.m14202copyTo(c5052Buffer2, j, j2);
    }

    @JvmOverloads
    /* renamed from: copyTo */
    public final C5052Buffer m14200copyTo(OutputStream out, long offset, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, offset, byteCount);
        if (byteCount == 0) {
            return this;
        }
        C5059Segment c5059Segment = this.head;
        while (true) {
            Intrinsics.checkNotNull(c5059Segment);
            int i = c5059Segment.limit;
            int i2 = c5059Segment.pos;
            if (offset < i - i2) {
                break;
            }
            offset -= i - i2;
            c5059Segment = c5059Segment.next;
        }
        while (byteCount > 0) {
            Intrinsics.checkNotNull(c5059Segment);
            int iMin = (int) Math.min(c5059Segment.limit - r9, byteCount);
            out.write(c5059Segment.data, (int) (c5059Segment.pos + offset), iMin);
            byteCount -= iMin;
            c5059Segment = c5059Segment.next;
            offset = 0;
        }
        return this;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14209indexOf(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return mo14210indexOf(bytes, 0L);
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    public static /* synthetic */ C5052Buffer copyTo$default(C5052Buffer c5052Buffer, C5052Buffer c5052Buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return c5052Buffer.m14201copyTo(c5052Buffer2, j);
    }

    private final void readFrom(InputStream input, long byteCount, boolean forever) throws IOException {
        while (true) {
            if (byteCount <= 0 && !forever) {
                return;
            }
            C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(1);
            int i = input.read(c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit, (int) Math.min(byteCount, 8192 - c5059SegmentWritableSegment$okio.limit));
            if (i == -1) {
                if (c5059SegmentWritableSegment$okio.pos == c5059SegmentWritableSegment$okio.limit) {
                    this.head = c5059SegmentWritableSegment$okio.m14380pop();
                    SegmentPool.m14384recycle(c5059SegmentWritableSegment$okio);
                }
                if (!forever) {
                    throw new EOFException();
                }
                return;
            }
            c5059SegmentWritableSegment$okio.limit += i;
            long j = i;
            this.size += j;
            byteCount -= j;
        }
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14210indexOf(ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return mo14211indexOf(bytes, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: select */
    public <T> T mo14221select(TypedOptions<T> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int iMo14220select = mo14220select(options.getOptions());
        if (iMo14220select == -1) {
            return null;
        }
        return options.get(iMo14220select);
    }

    public final ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.f17785EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(m14225size(), 0L, byteCount);
        C5059Segment c5059Segment = this.head;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < byteCount) {
            Intrinsics.checkNotNull(c5059Segment);
            int i4 = c5059Segment.limit;
            int i5 = c5059Segment.pos;
            if (i4 != i5) {
                i2 += i4 - i5;
                i3++;
                c5059Segment = c5059Segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i3][];
        int[] iArr = new int[i3 * 2];
        C5059Segment c5059Segment2 = this.head;
        int i6 = 0;
        while (i < byteCount) {
            Intrinsics.checkNotNull(c5059Segment2);
            bArr[i6] = c5059Segment2.data;
            i += c5059Segment2.limit - c5059Segment2.pos;
            iArr[i6] = Math.min(i, byteCount);
            iArr[i6 + i3] = c5059Segment2.pos;
            c5059Segment2.shared = true;
            i6++;
            c5059Segment2 = c5059Segment2.next;
        }
        return new C6370SegmentedByteString(bArr, iArr);
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeUtf8(String string, int beginIndex, int endIndex) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(string, "string");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex >= beginIndex) {
            if (endIndex > string.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
            }
            while (beginIndex < endIndex) {
                char cCharAt2 = string.charAt(beginIndex);
                if (cCharAt2 < 128) {
                    C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = c5059SegmentWritableSegment$okio.data;
                    int i = c5059SegmentWritableSegment$okio.limit - beginIndex;
                    int iMin = Math.min(endIndex, 8192 - i);
                    int i2 = beginIndex + 1;
                    bArr[beginIndex + i] = (byte) cCharAt2;
                    while (true) {
                        beginIndex = i2;
                        if (beginIndex >= iMin || (cCharAt = string.charAt(beginIndex)) >= 128) {
                            break;
                        }
                        i2 = beginIndex + 1;
                        bArr[beginIndex + i] = (byte) cCharAt;
                    }
                    int i3 = c5059SegmentWritableSegment$okio.limit;
                    int i4 = (i + beginIndex) - i3;
                    c5059SegmentWritableSegment$okio.limit = i3 + i4;
                    setSize$okio(m14225size() + i4);
                } else {
                    if (cCharAt2 < 2048) {
                        C5059Segment c5059SegmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = c5059SegmentWritableSegment$okio2.data;
                        int i5 = c5059SegmentWritableSegment$okio2.limit;
                        bArr2[i5] = (byte) ((cCharAt2 >> 6) | 192);
                        bArr2[i5 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        c5059SegmentWritableSegment$okio2.limit = i5 + 2;
                        setSize$okio(m14225size() + 2);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i6 = beginIndex + 1;
                        char cCharAt3 = i6 < endIndex ? string.charAt(i6) : (char) 0;
                        if (cCharAt2 <= 56319 && 56320 <= cCharAt3 && cCharAt3 < 57344) {
                            int i7 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + PKIFailureInfo.notAuthorized;
                            C5059Segment c5059SegmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = c5059SegmentWritableSegment$okio3.data;
                            int i8 = c5059SegmentWritableSegment$okio3.limit;
                            bArr3[i8] = (byte) ((i7 >> 18) | 240);
                            bArr3[i8 + 1] = (byte) (((i7 >> 12) & 63) | 128);
                            bArr3[i8 + 2] = (byte) (((i7 >> 6) & 63) | 128);
                            bArr3[i8 + 3] = (byte) ((i7 & 63) | 128);
                            c5059SegmentWritableSegment$okio3.limit = i8 + 4;
                            setSize$okio(m14225size() + 4);
                            beginIndex += 2;
                        } else {
                            writeByte(63);
                            beginIndex = i6;
                        }
                    } else {
                        C5059Segment c5059SegmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = c5059SegmentWritableSegment$okio4.data;
                        int i9 = c5059SegmentWritableSegment$okio4.limit;
                        bArr4[i9] = (byte) ((cCharAt2 >> '\f') | InterfaceC5102BERTags.f17976FLAGS);
                        bArr4[i9 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i9 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        c5059SegmentWritableSegment$okio4.limit = i9 + 3;
                        setSize$okio(m14225size() + 3);
                    }
                    beginIndex++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14211indexOf(ByteString bytes, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return C5067Buffer.commonIndexOf(this, bytes, fromIndex, (24 & 4) != 0 ? Long.MAX_VALUE : toIndex, (24 & 8) != 0 ? 0 : 0, (24 & 16) != 0 ? bytes.m14252size() : 0);
    }

    @Override // p132okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int iMo14215read = mo14215read(sink, i, sink.length - i);
            if (iMo14215read == -1) {
                throw new EOFException();
            }
            i += iMo14215read;
        }
    }

    @Override // p132okio.BufferedSink
    public C5052Buffer writeString(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex >= beginIndex) {
            if (endIndex <= string.length()) {
                if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                    return writeUtf8(string, beginIndex, endIndex);
                }
                String strSubstring = string.substring(beginIndex, endIndex);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                byte[] bytes = strSubstring.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return mo14231write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
    }

    @Override // p132okio.BufferedSource
    /* renamed from: indexOf */
    public long mo14208indexOf(byte b, long fromIndex, long toIndex) {
        C5059Segment c5059Segment;
        int i;
        long jM14225size = 0;
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("size=" + m14225size() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        if (toIndex > m14225size()) {
            toIndex = m14225size();
        }
        if (fromIndex == toIndex || (c5059Segment = this.head) == null) {
            return -1L;
        }
        if (m14225size() - fromIndex < fromIndex) {
            jM14225size = m14225size();
            while (jM14225size > fromIndex) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            while (jM14225size < toIndex) {
                byte[] bArr = c5059Segment.data;
                int iMin = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + toIndex) - jM14225size);
                i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                fromIndex = jM14225size;
            }
            return -1L;
        }
        while (true) {
            long j = (c5059Segment.limit - c5059Segment.pos) + jM14225size;
            if (j > fromIndex) {
                break;
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jM14225size = j;
        }
        while (jM14225size < toIndex) {
            byte[] bArr2 = c5059Segment.data;
            int iMin2 = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + toIndex) - jM14225size);
            i = (int) ((c5059Segment.pos + fromIndex) - jM14225size);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            jM14225size += c5059Segment.limit - c5059Segment.pos;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            fromIndex = jM14225size;
        }
        return -1L;
        return (i - c5059Segment.pos) + jM14225size;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - c5059SegmentWritableSegment$okio.limit);
            source.get(c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            c5059SegmentWritableSegment$okio.limit += iMin;
        }
        this.size += iRemaining;
        return iRemaining;
    }

    @Override // p132okio.BufferedSource
    /* renamed from: read */
    public int mo14214read(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return mo14215read(sink, 0, sink.length);
    }

    @Override // p132okio.BufferedSource
    /* renamed from: read */
    public int mo14215read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, byteCount);
        C5059Segment c5059Segment = this.head;
        if (c5059Segment == null) {
            return -1;
        }
        int iMin = Math.min(byteCount, c5059Segment.limit - c5059Segment.pos);
        byte[] bArr = c5059Segment.data;
        int i = c5059Segment.pos;
        ArraysKt.copyInto(bArr, sink, offset, i, i + iMin);
        c5059Segment.pos += iMin;
        setSize$okio(m14225size() - iMin);
        if (c5059Segment.pos == c5059Segment.limit) {
            this.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return iMin;
    }

    /* renamed from: copyTo */
    public final C5052Buffer m14201copyTo(C5052Buffer out, long offset) {
        Intrinsics.checkNotNullParameter(out, "out");
        return m14202copyTo(out, offset, this.size - offset);
    }

    @Override // p132okio.BufferedSink
    /* renamed from: write */
    public C5052Buffer mo14227write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.m14252size());
        return this;
    }

    /* renamed from: copyTo */
    public final C5052Buffer m14202copyTo(C5052Buffer out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.checkOffsetAndCount(m14225size(), offset, byteCount);
        if (byteCount != 0) {
            out.setSize$okio(out.m14225size() + byteCount);
            C5059Segment c5059Segment = this.head;
            while (true) {
                Intrinsics.checkNotNull(c5059Segment);
                int i = c5059Segment.limit;
                int i2 = c5059Segment.pos;
                if (offset < i - i2) {
                    break;
                }
                offset -= i - i2;
                c5059Segment = c5059Segment.next;
            }
            while (byteCount > 0) {
                Intrinsics.checkNotNull(c5059Segment);
                C5059Segment c5059SegmentSharedCopy = c5059Segment.sharedCopy();
                int i3 = c5059SegmentSharedCopy.pos + ((int) offset);
                c5059SegmentSharedCopy.pos = i3;
                c5059SegmentSharedCopy.limit = Math.min(i3 + ((int) byteCount), c5059SegmentSharedCopy.limit);
                C5059Segment c5059Segment2 = out.head;
                if (c5059Segment2 == null) {
                    c5059SegmentSharedCopy.prev = c5059SegmentSharedCopy;
                    c5059SegmentSharedCopy.next = c5059SegmentSharedCopy;
                    out.head = c5059SegmentSharedCopy;
                } else {
                    Intrinsics.checkNotNull(c5059Segment2);
                    C5059Segment c5059Segment3 = c5059Segment2.prev;
                    Intrinsics.checkNotNull(c5059Segment3);
                    c5059Segment3.m14381push(c5059SegmentSharedCopy);
                }
                byteCount -= c5059SegmentSharedCopy.limit - c5059SegmentSharedCopy.pos;
                c5059Segment = c5059Segment.next;
                offset = 0;
            }
        }
        return this;
    }

    @Override // p132okio.BufferedSink
    /* renamed from: write */
    public C5052Buffer mo14228write(ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, offset, byteCount);
        return this;
    }

    @Override // p132okio.BufferedSink
    /* renamed from: write */
    public C5052Buffer mo14230write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return mo14231write(source, 0, source.length);
    }

    @Override // p132okio.BufferedSink
    /* renamed from: write */
    public C5052Buffer mo14231write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = byteCount;
        SegmentedByteString.checkOffsetAndCount(source.length, offset, j);
        int i = byteCount + offset;
        while (offset < i) {
            C5059Segment c5059SegmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i - offset, 8192 - c5059SegmentWritableSegment$okio.limit);
            int i2 = offset + iMin;
            ArraysKt.copyInto(source, c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit, offset, i2);
            c5059SegmentWritableSegment$okio.limit += iMin;
            offset = i2;
        }
        setSize$okio(m14225size() + j);
        return this;
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: read */
    public long mo2305read(C5052Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (m14225size() == 0) {
            return -1L;
        }
        if (byteCount > m14225size()) {
            byteCount = m14225size();
        }
        sink.mo2303write(this, byteCount);
        return byteCount;
    }

    @Override // p132okio.BufferedSink
    /* renamed from: write */
    public C5052Buffer mo14229write(InterfaceC5062Source source, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (byteCount > 0) {
            long jMo2305read = source.mo2305read(this, byteCount);
            if (jMo2305read == -1) {
                throw new EOFException();
            }
            byteCount -= jMo2305read;
        }
        return this;
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) {
        C5059Segment c5059Segment;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != this) {
            SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, byteCount);
            while (byteCount > 0) {
                C5059Segment c5059Segment2 = source.head;
                Intrinsics.checkNotNull(c5059Segment2);
                int i = c5059Segment2.limit;
                Intrinsics.checkNotNull(source.head);
                if (byteCount < i - r1.pos) {
                    C5059Segment c5059Segment3 = this.head;
                    if (c5059Segment3 != null) {
                        Intrinsics.checkNotNull(c5059Segment3);
                        c5059Segment = c5059Segment3.prev;
                    } else {
                        c5059Segment = null;
                    }
                    if (c5059Segment != null && c5059Segment.owner) {
                        if ((c5059Segment.limit + byteCount) - (c5059Segment.shared ? 0 : c5059Segment.pos) <= 8192) {
                            C5059Segment c5059Segment4 = source.head;
                            Intrinsics.checkNotNull(c5059Segment4);
                            c5059Segment4.m14383writeTo(c5059Segment, (int) byteCount);
                            source.setSize$okio(source.m14225size() - byteCount);
                            setSize$okio(m14225size() + byteCount);
                            return;
                        }
                    }
                    C5059Segment c5059Segment5 = source.head;
                    Intrinsics.checkNotNull(c5059Segment5);
                    source.head = c5059Segment5.m14382split((int) byteCount);
                }
                C5059Segment c5059Segment6 = source.head;
                Intrinsics.checkNotNull(c5059Segment6);
                long j = c5059Segment6.limit - c5059Segment6.pos;
                source.head = c5059Segment6.m14380pop();
                C5059Segment c5059Segment7 = this.head;
                if (c5059Segment7 == null) {
                    this.head = c5059Segment6;
                    c5059Segment6.prev = c5059Segment6;
                    c5059Segment6.next = c5059Segment6;
                } else {
                    Intrinsics.checkNotNull(c5059Segment7);
                    C5059Segment c5059Segment8 = c5059Segment7.prev;
                    Intrinsics.checkNotNull(c5059Segment8);
                    c5059Segment8.m14381push(c5059Segment6).m14379compact();
                }
                source.setSize$okio(source.m14225size() - j);
                setSize$okio(m14225size() + j);
                byteCount -= j;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
