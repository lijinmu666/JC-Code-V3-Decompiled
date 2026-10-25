package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.DelayedAckMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Charsets;

@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cJ \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J*\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010!H\u0002J:\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0006\u0010+\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbProtocol;", BuildConfig.f24315FLAVOR, "<init>", "()V", "ADB_HEADER_LENGTH", BuildConfig.f24315FLAVOR, "A_STLS", "A_STLS_VERSION", "AUTH_TYPE_TOKEN", "AUTH_TYPE_SIGNATURE", "AUTH_TYPE_RSA_PUBLIC", "CMD_AUTH", "CMD_CNXN", "CMD_OPEN", "CMD_OKAY", "CMD_CLSE", "CMD_WRTE", "CMD_STLS", "A_VERSION_MIN", "A_VERSION_SKIP_CHECKSUM", "A_VERSION", "CONNECT_VERSION", "MAX_PAYLOAD_V1", "CONNECT_MAXDATA", "INITIAL_DELAYED_ACK_BYTES", "FEATURE_DELAYED_ACK", BuildConfig.f24315FLAVOR, "IMPLEMENTED_CONNECT_FEATURES", BuildConfig.f24315FLAVOR, "connectFeatures", "delayedAckMode", "Lcom/flyfishxu/kadb/DelayedAckMode;", "connectPayload", BuildConfig.f24315FLAVOR, "features", "getPayloadChecksum", "data", "offset", "length", "generateMessage", "command", "arg0", "arg1", "generateStls", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbProtocol {
    public static final int ADB_HEADER_LENGTH = 24;
    public static final int AUTH_TYPE_RSA_PUBLIC = 3;
    public static final int AUTH_TYPE_SIGNATURE = 2;
    public static final int AUTH_TYPE_TOKEN = 1;
    public static final int A_STLS = 1397511251;
    public static final int A_STLS_VERSION = 16777216;
    public static final int A_VERSION = 16777217;
    public static final int A_VERSION_MIN = 16777216;
    public static final int A_VERSION_SKIP_CHECKSUM = 16777217;
    public static final int CMD_AUTH = 1213486401;
    public static final int CMD_CLSE = 1163086915;
    public static final int CMD_CNXN = 1314410051;
    public static final int CMD_OKAY = 1497451343;
    public static final int CMD_OPEN = 1313165391;
    public static final int CMD_STLS = 1397511251;
    public static final int CMD_WRTE = 1163154007;
    public static final int CONNECT_MAXDATA = 1048576;
    public static final int CONNECT_VERSION = 16777217;
    public static final String FEATURE_DELAYED_ACK = "delayed_ack";
    public static final int INITIAL_DELAYED_ACK_BYTES = 33554432;
    public static final int MAX_PAYLOAD_V1 = 4096;
    public static final AdbProtocol INSTANCE = new AdbProtocol();
    private static final List<String> IMPLEMENTED_CONNECT_FEATURES = CollectionsKt.m5806listOf((Object[]) new String[]{"shell_v2", "cmd", "abb_exec", "stat_v2", "ls_v2", "sendrecv_v2"});

    private AdbProtocol() {
    }

    public static /* synthetic */ List connectFeatures$default(AdbProtocol adbProtocol, DelayedAckMode delayedAckMode, int i, Object obj) {
        if ((i & 1) != 0) {
            delayedAckMode = DelayedAckMode.AOSP_DEFAULT;
        }
        return adbProtocol.connectFeatures(delayedAckMode);
    }

    private final byte[] generateMessage(int command, int arg0, int arg1, byte[] data) {
        return generateMessage(command, arg0, arg1, data, 0, data != null ? data.length : 0);
    }

    private final int getPayloadChecksum(byte[] data, int offset, int length) {
        int i = length + offset;
        int i2 = 0;
        while (offset < i) {
            i2 += data[offset] & C1126UByte.MAX_VALUE;
            offset++;
        }
        return i2;
    }

    public final List<String> connectFeatures(DelayedAckMode delayedAckMode) {
        Intrinsics.checkNotNullParameter(delayedAckMode, "delayedAckMode");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) IMPLEMENTED_CONNECT_FEATURES);
        if (HostFeaturePolicyKt.shouldAdvertiseDelayedAck(delayedAckMode)) {
            mutableList.add(FEATURE_DELAYED_ACK);
        }
        return mutableList;
    }

    public final byte[] connectPayload(List<String> features) {
        Intrinsics.checkNotNullParameter(features, "features");
        byte[] bytes = ("host::features=" + CollectionsKt.joinToString$default(CollectionsKt.distinct(features), ",", null, null, 0, null, null, 62, null)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (bytes.length <= 4096) {
            return bytes;
        }
        throw new IllegalArgumentException(("ADB connect banner is too long: " + bytes.length + " > 4096").toString());
    }

    public final byte[] generateStls() {
        return generateMessage(1397511251, 16777216, 0, null);
    }

    private final byte[] generateMessage(int command, int arg0, int arg1, byte[] data, int offset, int length) {
        ByteBuffer byteBufferOrder;
        if (data != null) {
            byteBufferOrder = ByteBuffer.allocate(length + 24).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNull(byteBufferOrder);
        } else {
            byteBufferOrder = ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNull(byteBufferOrder);
        }
        byteBufferOrder.putInt(command);
        byteBufferOrder.putInt(arg0);
        byteBufferOrder.putInt(arg1);
        if (data != null) {
            byteBufferOrder.putInt(length);
            byteBufferOrder.putInt(getPayloadChecksum(data, offset, length));
        } else {
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
        }
        byteBufferOrder.putInt(~command);
        if (data != null) {
            byteBufferOrder.put(data, offset, length);
        }
        byte[] bArrArray = byteBufferOrder.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }
}
