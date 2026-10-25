package com.flyfishxu.p028kadb.p036stream;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.BufferedSink;
import p132okio.BufferedSource;
import p132okio.C5052Buffer;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0007J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001c\u001a\u00020\u0007J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!2\u0006\u0010\u001c\u001a\u00020\u0007J(\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020$0!2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u000206H\u0002J\u0018\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0014H\u0002J\u001c\u00109\u001a\u00020\u000f*\u00020:2\u0006\u00105\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0014H\u0002J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0018\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010D\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\u0016H\u0002J\b\u0010I\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/AdbSyncStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "stream", "Lcom/flyfishxu/kadb/stream/AdbStream;", "features", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "<init>", "(Lcom/flyfishxu/kadb/stream/AdbStream;Ljava/util/Set;)V", "buffer", "Lokio/Buffer;", "isWindowsHost", BuildConfig.f24315FLAVOR, "send", BuildConfig.f24315FLAVOR, "source", "Lokio/Source;", "remotePath", "mode", BuildConfig.f24315FLAVOR, "lastModifiedMs", BuildConfig.f24315FLAVOR, "recv", "sink", "Lokio/Sink;", "statV2", "Lcom/flyfishxu/kadb/stream/AdbSyncStatV2;", "path", "lstatV2", "lstat", "Lcom/flyfishxu/kadb/stream/AdbSyncStat;", "listV2", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/stream/AdbSyncDirEntryV2;", "list", "Lcom/flyfishxu/kadb/stream/AdbSyncDirEntry;", "sendV1", "sendV2", "writeSourcePayload", "readSendStatus", "recvV1", "recvV2", "readRecvPayload", "readStatV2", "requestId", "apiName", "readLstatV1", "readListV1", "readListV2", "readDentV2", "Lcom/flyfishxu/kadb/stream/DentV2Fields;", "writeRequest", "id", BuildConfig.f24315FLAVOR, "writePacket", "arg", "writeFrameHeader", "Lokio/BufferedSink;", "readPacket", "Lcom/flyfishxu/kadb/stream/Packet;", "readSyncName", "length", "validateEntryName", "name", "supportsFeature", "feature", "requireFeature", "enforcePathLength", "readFailException", "Ljava/io/IOException;", "readSyncId", "readUInt32AsLong", "close", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbSyncStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbSyncStream.kt\ncom/flyfishxu/kadb/stream/AdbSyncStream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,522:1\n1739#2:523\n1814#2,2:524\n1816#2:527\n1#3:526\n*S KotlinDebug\n*F\n+ 1 AdbSyncStream.kt\ncom/flyfishxu/kadb/stream/AdbSyncStream\n*L\n157#1:523\n157#1:524,2\n157#1:527\n*E\n"})
/* loaded from: classes.dex */
public final class AdbSyncStream implements AutoCloseable {
    private final C5052Buffer buffer;
    private final Set<String> features;
    private final boolean isWindowsHost;
    private final AdbStream stream;

    public AdbSyncStream(AdbStream stream, Set<String> features) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(features, "features");
        this.stream = stream;
        this.features = features;
        this.buffer = new C5052Buffer();
        String property = System.getProperty("os.name");
        boolean z = false;
        if (property != null && StringsKt.startsWith(property, "Windows", true)) {
            z = true;
        }
        this.isWindowsHost = z;
    }

    private final void enforcePathLength(int length, String id) {
        if (length <= 1024) {
            return;
        }
        throw new IllegalArgumentException(("Sync path too long for " + id + ": " + length + " > 1024").toString());
    }

    private final DentV2Fields readDentV2() throws IOException {
        int intLe = this.stream.getSource().readIntLe();
        long longLe = this.stream.getSource().readLongLe();
        long longLe2 = this.stream.getSource().readLongLe();
        int intLe2 = this.stream.getSource().readIntLe();
        int intLe3 = this.stream.getSource().readIntLe();
        int intLe4 = this.stream.getSource().readIntLe();
        int intLe5 = this.stream.getSource().readIntLe();
        long longLe3 = this.stream.getSource().readLongLe();
        long longLe4 = this.stream.getSource().readLongLe();
        long longLe5 = this.stream.getSource().readLongLe();
        long longLe6 = this.stream.getSource().readLongLe();
        String syncName = readSyncName(this.stream.getSource().readIntLe());
        validateEntryName(syncName);
        return new DentV2Fields(intLe, longLe, longLe2, intLe2, intLe3, intLe4, intLe5, longLe3, longLe4, longLe5, longLe6, syncName);
    }

    private final IOException readFailException() {
        int intLe = this.stream.getSource().readIntLe();
        if (intLe < 0) {
            return new IOException("Sync failed with invalid message length: " + intLe);
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new IOException("Sync failed: " + this.stream.getSource().readString(intLe, UTF_8));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a3, code lost:
    
        throw new java.io.IOException("Unexpected sync list id: " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AdbSyncDirEntry> readListV1(String path) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = path.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "LIST");
        writeRequest("LIST", bytes);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String syncId = readSyncId();
            int iHashCode = syncId.hashCode();
            if (iHashCode == 2094599) {
                if (!syncId.equals("DENT")) {
                    break;
                }
                int intLe = this.stream.getSource().readIntLe();
                long uInt32AsLong = readUInt32AsLong();
                long uInt32AsLong2 = readUInt32AsLong();
                String syncName = readSyncName(this.stream.getSource().readIntLe());
                validateEntryName(syncName);
                arrayList.add(new AdbSyncDirEntry(syncName, intLe, uInt32AsLong, uInt32AsLong2, null));
            } else if (iHashCode != 2104194) {
                if (iHashCode == 2150174 && syncId.equals("FAIL")) {
                    throw readFailException();
                }
            } else if (syncId.equals("DONE")) {
                this.stream.getSource().mo14226skip(16L);
                return arrayList;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
    
        throw new java.io.IOException("Unexpected sync list id: " + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AdbSyncDirEntryV2> readListV2(String path) throws IOException {
        AdbSyncStream adbSyncStream = this;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = path.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        adbSyncStream.enforcePathLength(bytes.length, "LIS2");
        adbSyncStream.writeRequest("LIS2", bytes);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String syncId = readSyncId();
            int iHashCode = syncId.hashCode();
            if (iHashCode == 2103400) {
                if (!syncId.equals("DNT2")) {
                    break;
                }
                DentV2Fields dentV2 = readDentV2();
                arrayList.add(new AdbSyncDirEntryV2(dentV2.getName(), dentV2.getErrorCode(), dentV2.getDev(), dentV2.getIno(), dentV2.getMode(), dentV2.getNlink(), dentV2.getUid(), dentV2.getGid(), dentV2.getSize(), dentV2.getAtimeSec(), dentV2.getMtimeSec(), dentV2.getCtimeSec()));
                adbSyncStream = this;
            } else if (iHashCode != 2104194) {
                if (iHashCode == 2150174 && syncId.equals("FAIL")) {
                    throw readFailException();
                }
            } else if (syncId.equals("DONE")) {
                adbSyncStream.stream.getSource().mo14226skip(72L);
                return arrayList;
            }
        }
    }

    private final AdbSyncStat readLstatV1(String path) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = path.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "STAT");
        writeRequest("STAT", bytes);
        String syncId = readSyncId();
        if (!Intrinsics.areEqual(syncId, "STAT")) {
            throw new IOException("Unexpected sync lstat id: " + syncId);
        }
        int intLe = this.stream.getSource().readIntLe();
        long uInt32AsLong = readUInt32AsLong();
        long uInt32AsLong2 = readUInt32AsLong();
        if (intLe == 0 && uInt32AsLong == 0 && uInt32AsLong2 == 0) {
            throw new IOException("Sync lstat failed: unknown error");
        }
        return new AdbSyncStat(intLe, uInt32AsLong, uInt32AsLong2);
    }

    private final C0199Packet readPacket() {
        return new C0199Packet(readSyncId(), this.stream.getSource().readIntLe());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
    
        throw new java.io.IOException("Unexpected sync packet id: " + r0.getId());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void readRecvPayload(InterfaceC5060Sink sink) throws IOException {
        int arg;
        this.buffer.m14194clear();
        while (true) {
            C0199Packet packet = readPacket();
            String id = packet.getId();
            int iHashCode = id.hashCode();
            if (iHashCode == 2090922) {
                if (!id.equals("DATA")) {
                    break;
                }
                arg = packet.getArg();
                if (arg < 0 || arg > 65536) {
                    break;
                }
                this.stream.getSource().readFully(this.buffer, arg);
                this.buffer.mo14216readAll(sink);
            } else if (iHashCode != 2104194) {
                if (iHashCode == 2150174 && id.equals("FAIL")) {
                    BufferedSource source = this.stream.getSource();
                    long arg2 = packet.getArg();
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    throw new IOException("Sync failed: " + source.readString(arg2, UTF_8));
                }
            } else if (id.equals("DONE")) {
                sink.flush();
                return;
            }
        }
        throw new IOException("Sync DATA chunk too large: " + arg + " > 65536");
    }

    private final void readSendStatus() throws IOException {
        C0199Packet packet = readPacket();
        String id = packet.getId();
        if (Intrinsics.areEqual(id, "OKAY")) {
            return;
        }
        if (!Intrinsics.areEqual(id, "FAIL")) {
            throw new IOException("Unexpected sync packet id: " + packet.getId());
        }
        BufferedSource source = this.stream.getSource();
        long arg = packet.getArg();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        throw new IOException("Sync failed: " + source.readString(arg, UTF_8));
    }

    private final AdbSyncStatV2 readStatV2(String path, String requestId, String apiName) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = path.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, requestId);
        writeRequest(requestId, bytes);
        String syncId = readSyncId();
        if (!Intrinsics.areEqual(syncId, "STA2") && !Intrinsics.areEqual(syncId, "LST2")) {
            throw new IOException("Unexpected sync stat id: " + syncId);
        }
        AdbSyncStatV2 adbSyncStatV2 = new AdbSyncStatV2(this.stream.getSource().readIntLe(), this.stream.getSource().readLongLe(), this.stream.getSource().readLongLe(), this.stream.getSource().readIntLe(), this.stream.getSource().readIntLe(), this.stream.getSource().readIntLe(), this.stream.getSource().readIntLe(), this.stream.getSource().readLongLe(), this.stream.getSource().readLongLe(), this.stream.getSource().readLongLe(), this.stream.getSource().readLongLe());
        if (adbSyncStatV2.getErrorCode() == 0) {
            return adbSyncStatV2;
        }
        throw new IOException(apiName + " failed with error code: " + adbSyncStatV2.getErrorCode());
    }

    private final String readSyncId() {
        BufferedSource source = this.stream.getSource();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return source.readString(4L, UTF_8);
    }

    private final String readSyncName(int length) throws IOException {
        if (length < 0 || length > 255) {
            throw new IOException("Invalid sync name length: " + length);
        }
        BufferedSource source = this.stream.getSource();
        long j = length;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return source.readString(j, UTF_8);
    }

    private final long readUInt32AsLong() {
        return this.stream.getSource().readIntLe() & BodyPartID.bodyIdMax;
    }

    /* renamed from: recvV1 */
    private final void m2325recvV1(InterfaceC5060Sink sink, String remotePath) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = remotePath.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "RECV");
        writeRequest("RECV", bytes);
        readRecvPayload(sink);
    }

    /* renamed from: recvV2 */
    private final void m2326recvV2(InterfaceC5060Sink sink, String remotePath) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = remotePath.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "RCV2");
        BufferedSink sink2 = this.stream.getSink();
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sink2.writeString("RCV2", UTF_8);
        sink2.writeIntLe(bytes.length);
        sink2.mo14230write(bytes);
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sink2.writeString("RCV2", UTF_8);
        sink2.writeIntLe(0);
        sink2.flush();
        readRecvPayload(sink);
    }

    private final void requireFeature(String feature, String apiName) {
        if (supportsFeature(feature)) {
            return;
        }
        throw new UnsupportedOperationException(apiName + " requires peer feature '" + feature + "'");
    }

    /* renamed from: sendV1 */
    private final void m2327sendV1(InterfaceC5062Source source, String remotePath, int mode, long lastModifiedMs) throws IOException {
        String str = remotePath + "," + mode;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = str.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "SEND");
        writeRequest("SEND", bytes);
        writeSourcePayload(source, lastModifiedMs);
        readSendStatus();
    }

    /* renamed from: sendV2 */
    private final void m2328sendV2(InterfaceC5062Source source, String remotePath, int mode, long lastModifiedMs) throws IOException {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = remotePath.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        enforcePathLength(bytes.length, "SND2");
        BufferedSink sink = this.stream.getSink();
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sink.writeString("SND2", UTF_8);
        sink.writeIntLe(bytes.length);
        sink.mo14230write(bytes);
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sink.writeString("SND2", UTF_8);
        sink.writeIntLe(mode);
        sink.writeIntLe(0);
        sink.flush();
        writeSourcePayload(source, lastModifiedMs);
        readSendStatus();
    }

    private final boolean supportsFeature(String feature) {
        return this.features.contains(feature);
    }

    private final void validateEntryName(String name) throws IOException {
        if (StringsKt.contains$default((CharSequence) name, '/', false, 2, (Object) null)) {
            throw new IOException("Invalid sync entry name: " + name);
        }
        if (this.isWindowsHost && StringsKt.contains$default((CharSequence) name, '\\', false, 2, (Object) null)) {
            throw new IOException("Invalid sync entry name: " + name);
        }
    }

    private final void writeFrameHeader(BufferedSink bufferedSink, String str, int i) {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        bufferedSink.writeString(str, UTF_8);
        bufferedSink.writeIntLe(i);
    }

    private final void writePacket(String id, int arg) {
        BufferedSink sink = this.stream.getSink();
        writeFrameHeader(sink, id, arg);
        sink.flush();
    }

    private final void writeRequest(String id, byte[] path) {
        BufferedSink sink = this.stream.getSink();
        writeFrameHeader(sink, id, path.length);
        sink.mo14230write(path);
        sink.flush();
    }

    private final void writeSourcePayload(InterfaceC5062Source source, long lastModifiedMs) throws EOFException {
        this.buffer.m14194clear();
        while (true) {
            long jMo2305read = source.mo2305read(this.buffer, 65536L);
            if (jMo2305read == -1) {
                BufferedSink sink = this.stream.getSink();
                writeFrameHeader(sink, "DONE", (int) (lastModifiedMs / NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE));
                sink.flush();
                return;
            } else {
                BufferedSink sink2 = this.stream.getSink();
                writeFrameHeader(sink2, "DATA", (int) jMo2305read);
                if (jMo2305read != sink2.writeAll(this.buffer)) {
                    throw new IllegalStateException("Check failed.");
                }
                sink2.flush();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        writePacket("QUIT", 0);
        this.stream.close();
    }

    /* renamed from: list */
    public final List<AdbSyncDirEntry> m2329list(String path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!supportsFeature("ls_v2")) {
            return readListV1(path);
        }
        List<AdbSyncDirEntryV2> listV2 = readListV2(path);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listV2, 10));
        for (AdbSyncDirEntryV2 adbSyncDirEntryV2 : listV2) {
            String name = adbSyncDirEntryV2.getName();
            int mode = adbSyncDirEntryV2.getMode();
            long size = adbSyncDirEntryV2.getSize();
            long mtimeSec = adbSyncDirEntryV2.getMtimeSec();
            Integer numValueOf = Integer.valueOf(adbSyncDirEntryV2.getErrorCode());
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            arrayList.add(new AdbSyncDirEntry(name, mode, size, mtimeSec, numValueOf));
        }
        return arrayList;
    }

    /* renamed from: listV2 */
    public final List<AdbSyncDirEntryV2> m2330listV2(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        requireFeature("ls_v2", "listV2");
        return readListV2(path);
    }

    /* renamed from: lstat */
    public final AdbSyncStat m2331lstat(String path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!supportsFeature("stat_v2")) {
            return readLstatV1(path);
        }
        AdbSyncStatV2 statV2 = readStatV2(path, "LST2", "lstat");
        return new AdbSyncStat(statV2.getMode(), statV2.getSize(), statV2.getMtimeSec());
    }

    /* renamed from: lstatV2 */
    public final AdbSyncStatV2 m2332lstatV2(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        requireFeature("stat_v2", "lstatV2");
        return readStatV2(path, "LST2", "lstatV2");
    }

    /* renamed from: recv */
    public final void m2333recv(InterfaceC5060Sink sink, String remotePath) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        if (supportsFeature("sendrecv_v2")) {
            m2326recvV2(sink, remotePath);
        } else {
            m2325recvV1(sink, remotePath);
        }
    }

    /* renamed from: send */
    public final void m2334send(InterfaceC5062Source source, String remotePath, int mode, long lastModifiedMs) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        if (supportsFeature("sendrecv_v2")) {
            m2328sendV2(source, remotePath, mode, lastModifiedMs);
        } else {
            m2327sendV1(source, remotePath, mode, lastModifiedMs);
        }
    }

    /* renamed from: statV2 */
    public final AdbSyncStatV2 m2335statV2(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        requireFeature("stat_v2", "statV2");
        return readStatV2(path, "STA2", "statV2");
    }

    public /* synthetic */ AdbSyncStream(AdbStream adbStream, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adbStream, (i & 2) != 0 ? C1159SetsKt.emptySet() : set);
    }
}
