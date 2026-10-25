package com.flyfishxu.p028kadb.p033pair;

import com.flyfishxu.p028kadb.p029cert.AdbKeyPair;
import com.flyfishxu.p028kadb.p029cert.AndroidPubkey;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.RangesKt;

@Metadata(m4987d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u00045678B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007H\u0002J\n\u0010)\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u00020\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx;", "Ljava/io/Closeable;", "host", BuildConfig.f24315FLAVOR, "mPort", BuildConfig.f24315FLAVOR, "pwd", BuildConfig.f24315FLAVOR, "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "deviceName", "<init>", "(Ljava/lang/String;I[BLcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/lang/String;)V", "mHost", "mPwd", "mPeerInfo", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", "mSslContext", "Ljavax/net/ssl/SSLContext;", "mRole", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$Role;", "mInputStream", "Ljava/io/DataInputStream;", "mOutputStream", "Ljava/io/DataOutputStream;", "mPairingAuthCtx", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "mState", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$State;", "start", BuildConfig.f24315FLAVOR, "notifyResult", "setupTlsConnection", "exportKeyingMaterial", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "length", "writeHeader", "header", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", "payload", "readHeader", "createHeader", "type", BuildConfig.f24315FLAVOR, "payloadSize", "checkHeaderType", BuildConfig.f24315FLAVOR, "expected", "actual", "doExchangeMsgs", "doExchangePeerInfo", "close", "State", "Role", "PeerInfo", "PairingPacketHeader", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingConnectionCtx implements Closeable {
    private final String mHost;
    private DataInputStream mInputStream;
    private DataOutputStream mOutputStream;
    private PairingAuthCtx mPairingAuthCtx;
    private final PeerInfo mPeerInfo;
    private final int mPort;
    private final byte[] mPwd;
    private final EnumC0194Role mRole;
    private final SSLContext mSslContext;
    private EnumC0195State mState;

    @Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", BuildConfig.f24315FLAVOR, "version", BuildConfig.f24315FLAVOR, "type", "payloadSize", BuildConfig.f24315FLAVOR, "<init>", "(BBI)V", "getType", "()B", "getPayloadSize", "()I", "writeTo", BuildConfig.f24315FLAVOR, "buffer", "Ljava/nio/ByteBuffer;", "toString", BuildConfig.f24315FLAVOR, "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class PairingPacketHeader {
        public static final byte CURRENT_KEY_HEADER_VERSION = 1;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int MAX_PAYLOAD_SIZE = 16384;
        public static final byte MAX_SUPPORTED_KEY_HEADER_VERSION = 1;
        public static final byte MIN_SUPPORTED_KEY_HEADER_VERSION = 1;
        public static final byte PAIRING_PACKET_HEADER_SIZE = 6;
        public static final byte PEER_INFO = 1;
        public static final byte SPAKE2_MSG = 0;
        private final int payloadSize;
        private final byte type;
        private final byte version;

        @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "CURRENT_KEY_HEADER_VERSION", BuildConfig.f24315FLAVOR, "MIN_SUPPORTED_KEY_HEADER_VERSION", "MAX_SUPPORTED_KEY_HEADER_VERSION", "MAX_PAYLOAD_SIZE", BuildConfig.f24315FLAVOR, "PAIRING_PACKET_HEADER_SIZE", "SPAKE2_MSG", "PEER_INFO", "readFrom", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", "buffer", "Ljava/nio/ByteBuffer;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PairingPacketHeader readFrom(ByteBuffer buffer) {
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                byte b = buffer.get();
                byte b2 = buffer.get();
                int i = buffer.getInt();
                if (b < 1 || b > 1) {
                    return null;
                }
                if ((b2 == 0 || b2 == 1) && i > 0 && i <= 16384) {
                    return new PairingPacketHeader(b, b2, i);
                }
                return null;
            }

            private Companion() {
            }
        }

        public PairingPacketHeader(byte b, byte b2, int i) {
            this.version = b;
            this.type = b2;
            this.payloadSize = i;
        }

        public final int getPayloadSize() {
            return this.payloadSize;
        }

        public final byte getType() {
            return this.type;
        }

        public String toString() {
            byte b = this.version;
            byte b2 = this.type;
            return "PairingPacketHeader{version=" + ((int) b) + ", type=" + ((int) b2) + ", payloadSize=" + this.payloadSize + "}";
        }

        /* renamed from: writeTo */
        public final void m2269writeTo(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            buffer.put(this.version).put(this.type).putInt(this.payloadSize);
        }
    }

    @Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", BuildConfig.f24315FLAVOR, "type", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "<init>", "(B[B)V", "writeTo", BuildConfig.f24315FLAVOR, "buffer", "Ljava/nio/ByteBuffer;", "toString", BuildConfig.f24315FLAVOR, "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class PeerInfo {
        public static final byte ADB_DEVICE_GUID = 1;
        public static final byte ADB_RSA_PUB_KEY = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int MAX_PEER_INFO_SIZE = 8192;
        private final byte[] data;
        private final byte type;

        @Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "MAX_PEER_INFO_SIZE", BuildConfig.f24315FLAVOR, "ADB_RSA_PUB_KEY", BuildConfig.f24315FLAVOR, "ADB_DEVICE_GUID", "readFrom", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", "buffer", "Ljava/nio/ByteBuffer;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PeerInfo readFrom(ByteBuffer buffer) {
                Intrinsics.checkNotNullParameter(buffer, "buffer");
                byte b = buffer.get();
                byte[] bArr = new byte[8191];
                buffer.get(bArr);
                return new PeerInfo(b, bArr);
            }

            private Companion() {
            }
        }

        public PeerInfo(byte b, byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.type = b;
            byte[] bArr = new byte[8191];
            this.data = bArr;
            System.arraycopy(data, 0, bArr, 0, RangesKt.coerceAtMost(data.length, 8191));
        }

        public String toString() {
            byte b = this.type;
            String string = Arrays.toString(this.data);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return "PeerInfo{type=" + ((int) b) + ", data=" + string + "}";
        }

        /* renamed from: writeTo */
        public final void m2270writeTo(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            buffer.put(this.type).put(this.data);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$Role;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Client", "Server", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.pair.PairingConnectionCtx$Role */
    public static final class EnumC0194Role {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ EnumC0194Role[] f2099$VALUES;

        /* renamed from: Client */
        public static final EnumC0194Role f2100Client = new EnumC0194Role("Client", 0);

        /* renamed from: Server */
        public static final EnumC0194Role f2101Server = new EnumC0194Role("Server", 1);

        /* renamed from: $values */
        private static final /* synthetic */ EnumC0194Role[] m2271$values() {
            return new EnumC0194Role[]{f2100Client, f2101Server};
        }

        static {
            EnumC0194Role[] enumC0194RoleArrM2271$values = m2271$values();
            f2099$VALUES = enumC0194RoleArrM2271$values;
            $ENTRIES = EnumEntriesKt.enumEntries(enumC0194RoleArrM2271$values);
        }

        private EnumC0194Role(String str, int i) {
        }

        public static EnumEntries<EnumC0194Role> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static EnumC0194Role m2272valueOf(String str) {
            return (EnumC0194Role) Enum.valueOf(EnumC0194Role.class, str);
        }

        /* renamed from: values */
        public static EnumC0194Role[] m2273values() {
            return (EnumC0194Role[]) f2099$VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$State;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Ready", "ExchangingMsgs", "ExchangingPeerInfo", "Stopped", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.pair.PairingConnectionCtx$State */
    public static final class EnumC0195State {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ EnumC0195State[] f2102$VALUES;

        /* renamed from: Ready */
        public static final EnumC0195State f2103Ready = new EnumC0195State("Ready", 0);
        public static final EnumC0195State ExchangingMsgs = new EnumC0195State("ExchangingMsgs", 1);
        public static final EnumC0195State ExchangingPeerInfo = new EnumC0195State("ExchangingPeerInfo", 2);

        /* renamed from: Stopped */
        public static final EnumC0195State f2104Stopped = new EnumC0195State("Stopped", 3);

        /* renamed from: $values */
        private static final /* synthetic */ EnumC0195State[] m2274$values() {
            return new EnumC0195State[]{f2103Ready, ExchangingMsgs, ExchangingPeerInfo, f2104Stopped};
        }

        static {
            EnumC0195State[] enumC0195StateArrM2274$values = m2274$values();
            f2102$VALUES = enumC0195StateArrM2274$values;
            $ENTRIES = EnumEntriesKt.enumEntries(enumC0195StateArrM2274$values);
        }

        private EnumC0195State(String str, int i) {
        }

        public static EnumEntries<EnumC0195State> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static EnumC0195State m2275valueOf(String str) {
            return (EnumC0195State) Enum.valueOf(EnumC0195State.class, str);
        }

        /* renamed from: values */
        public static EnumC0195State[] m2276values() {
            return (EnumC0195State[]) f2102$VALUES.clone();
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumC0195State.m2276values().length];
            try {
                iArr[EnumC0195State.ExchangingMsgs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0195State.ExchangingPeerInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0195State.f2103Ready.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC0195State.f2104Stopped.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PairingConnectionCtx(String host, int i, byte[] pwd, AdbKeyPair keyPair, String deviceName) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.mPort = i;
        Objects.requireNonNull(host);
        Intrinsics.checkNotNullExpressionValue(host, "requireNonNull(...)");
        this.mHost = host;
        Objects.requireNonNull(pwd);
        Intrinsics.checkNotNullExpressionValue(pwd, "requireNonNull(...)");
        this.mPwd = pwd;
        PublicKey publicKey = keyPair.getCertificate().getPublicKey();
        Intrinsics.checkNotNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
        Objects.requireNonNull(deviceName);
        Intrinsics.checkNotNullExpressionValue(deviceName, "requireNonNull(...)");
        this.mPeerInfo = new PeerInfo((byte) 0, AndroidPubkey.encodeWithName((RSAPublicKey) publicKey, deviceName));
        this.mSslContext = SslUtils.INSTANCE.getSslContext(keyPair);
        this.mRole = EnumC0194Role.f2100Client;
        this.mState = EnumC0195State.f2103Ready;
    }

    private final boolean checkHeaderType(byte expected, byte actual) {
        return expected == actual;
    }

    private final PairingPacketHeader createHeader(byte type, int payloadSize) {
        return new PairingPacketHeader((byte) 1, type, payloadSize);
    }

    private final boolean doExchangeMsgs() throws IOException {
        PairingAuthCtx pairingAuthCtx = this.mPairingAuthCtx;
        Intrinsics.checkNotNull(pairingAuthCtx);
        byte[] msg = pairingAuthCtx.getMsg();
        writeHeader(createHeader((byte) 0, msg.length), msg);
        PairingPacketHeader header = readHeader();
        if (header == null || !checkHeaderType((byte) 0, header.getType())) {
            return false;
        }
        byte[] bArr = new byte[header.getPayloadSize()];
        DataInputStream dataInputStream = this.mInputStream;
        Intrinsics.checkNotNull(dataInputStream);
        dataInputStream.readFully(bArr);
        try {
            PairingAuthCtx pairingAuthCtx2 = this.mPairingAuthCtx;
            Intrinsics.checkNotNull(pairingAuthCtx2);
            return pairingAuthCtx2.initCipher(bArr);
        } catch (Exception e) {
            Throwable thInitCause = new IOException().initCause(e);
            Intrinsics.checkNotNull(thInitCause, "null cannot be cast to non-null type java.io.IOException");
            throw ((IOException) thInitCause);
        }
    }

    private final boolean doExchangePeerInfo() throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(8192).order(ByteOrder.BIG_ENDIAN);
        PeerInfo peerInfo = this.mPeerInfo;
        Intrinsics.checkNotNull(byteBufferOrder);
        peerInfo.m2270writeTo(byteBufferOrder);
        PairingAuthCtx pairingAuthCtx = this.mPairingAuthCtx;
        Intrinsics.checkNotNull(pairingAuthCtx);
        byte[] bArrArray = byteBufferOrder.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        byte[] bArrM2264encrypt = pairingAuthCtx.m2264encrypt(bArrArray);
        if (bArrM2264encrypt == null) {
            return false;
        }
        writeHeader(createHeader((byte) 1, bArrM2264encrypt.length), bArrM2264encrypt);
        PairingPacketHeader header = readHeader();
        if (header == null || !checkHeaderType((byte) 1, header.getType())) {
            return false;
        }
        byte[] bArr = new byte[header.getPayloadSize()];
        DataInputStream dataInputStream = this.mInputStream;
        Intrinsics.checkNotNull(dataInputStream);
        dataInputStream.readFully(bArr);
        PairingAuthCtx pairingAuthCtx2 = this.mPairingAuthCtx;
        Intrinsics.checkNotNull(pairingAuthCtx2);
        byte[] bArrM2263decrypt = pairingAuthCtx2.m2263decrypt(bArr);
        if (bArrM2263decrypt == null || bArrM2263decrypt.length != 8192) {
            return false;
        }
        PeerInfo.Companion companion = PeerInfo.INSTANCE;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrM2263decrypt);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        companion.readFrom(byteBufferWrap);
        return true;
    }

    private final byte[] exportKeyingMaterial(SSLSocket sslSocket, int length) throws SSLException {
        try {
            Object objInvoke = PairingConnectionCtx_androidKt.getConscryptClass(this).getMethod("exportKeyingMaterial", SSLSocket.class, String.class, byte[].class, Integer.TYPE).invoke(null, sslSocket, "adb-label\u0000", null, Integer.valueOf(length));
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.ByteArray");
            return (byte[]) objInvoke;
        } catch (SSLException e) {
            throw e;
        } catch (Throwable th) {
            throw new SSLException(th);
        }
    }

    private final void notifyResult() {
        this.mState = EnumC0195State.f2104Stopped;
    }

    private final PairingPacketHeader readHeader() throws IOException {
        byte[] bArr = new byte[6];
        DataInputStream dataInputStream = this.mInputStream;
        Intrinsics.checkNotNull(dataInputStream);
        dataInputStream.readFully(bArr);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        PairingPacketHeader.Companion companion = PairingPacketHeader.INSTANCE;
        Intrinsics.checkNotNull(byteBufferOrder);
        return companion.readFrom(byteBufferOrder);
    }

    private final void setupTlsConnection() throws IOException {
        Socket socket;
        if (this.mRole == EnumC0194Role.f2101Server) {
            ServerSocket serverSocketCreateServerSocket = this.mSslContext.getServerSocketFactory().createServerSocket(this.mPort);
            Intrinsics.checkNotNull(serverSocketCreateServerSocket, "null cannot be cast to non-null type javax.net.ssl.SSLServerSocket");
            socket = ((SSLServerSocket) serverSocketCreateServerSocket).accept();
            Intrinsics.checkNotNull(socket);
        } else {
            socket = new Socket(this.mHost, this.mPort);
        }
        socket.setTcpNoDelay(true);
        Socket socketCreateSocket = this.mSslContext.getSocketFactory().createSocket(socket, this.mHost, this.mPort, true);
        Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
        sSLSocket.startHandshake();
        this.mInputStream = new DataInputStream(sSLSocket.getInputStream());
        this.mOutputStream = new DataOutputStream(sSLSocket.getOutputStream());
        byte[] bArrExportKeyingMaterial = exportKeyingMaterial(sSLSocket, 64);
        byte[] bArr = this.mPwd;
        byte[] bArr2 = new byte[bArr.length + bArrExportKeyingMaterial.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrExportKeyingMaterial, 0, bArr2, this.mPwd.length, bArrExportKeyingMaterial.length);
        PairingAuthCtx pairingAuthCtxCreateAlice = PairingAuthCtx_androidKt.createAlice(PairingAuthCtx.INSTANCE, bArr2);
        if (pairingAuthCtxCreateAlice == null) {
            throw new IOException("Unable to create PairingAuthCtx.");
        }
        this.mPairingAuthCtx = pairingAuthCtxCreateAlice;
    }

    private final void writeHeader(PairingPacketHeader header, byte[] payload) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(6).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNull(byteBufferOrder);
        header.m2269writeTo(byteBufferOrder);
        DataOutputStream dataOutputStream = this.mOutputStream;
        Intrinsics.checkNotNull(dataOutputStream);
        dataOutputStream.write(byteBufferOrder.array());
        DataOutputStream dataOutputStream2 = this.mOutputStream;
        Intrinsics.checkNotNull(dataOutputStream2);
        dataOutputStream2.write(payload);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PairingAuthCtx pairingAuthCtx;
        Arrays.fill(this.mPwd, (byte) 0);
        try {
            DataInputStream dataInputStream = this.mInputStream;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        } catch (IOException unused) {
        }
        try {
            DataOutputStream dataOutputStream = this.mOutputStream;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (IOException unused2) {
        }
        if (this.mState == EnumC0195State.f2103Ready || (pairingAuthCtx = this.mPairingAuthCtx) == null) {
            return;
        }
        pairingAuthCtx.destroy();
    }

    /* renamed from: start */
    public final void m2267start() throws IOException {
        if (this.mState != EnumC0195State.f2103Ready) {
            throw new IOException("Connection is not ready yet.");
        }
        this.mState = EnumC0195State.ExchangingMsgs;
        setupTlsConnection();
        while (true) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.mState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IOException("Connection closed with errors.");
                }
                if (doExchangePeerInfo()) {
                    notifyResult();
                    return;
                } else {
                    notifyResult();
                    throw new IOException("Could not exchange peer info.");
                }
            }
            if (!doExchangeMsgs()) {
                notifyResult();
                throw new IOException("Exchanging message wasn't successful.");
            }
            this.mState = EnumC0195State.ExchangingPeerInfo;
        }
    }
}
