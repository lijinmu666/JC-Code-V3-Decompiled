package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.p036stream.AdbSyncStreamKt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.StringCompanionObject;
import p094kotlin.p117text.Charsets;
import p132okio.BufferedSource;
import p132okio.C5052Buffer;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbMessage;", BuildConfig.f24315FLAVOR, "command", BuildConfig.f24315FLAVOR, "arg0", "arg1", "payloadLength", "checksum", "magic", "payload", BuildConfig.f24315FLAVOR, "<init>", "(IIIIII[B)V", "getCommand", "()I", "getArg0", "getArg1", "getPayloadLength", "getChecksum", "getMagic", "getPayload", "()[B", "toString", BuildConfig.f24315FLAVOR, "payloadStr", "writePayloadStr", "shellPayloadStr", "syncPayloadStr", "getSource", "Lokio/BufferedSource;", "argStr", "arg", "commandStr", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbMessage.kt\ncom/flyfishxu/kadb/core/AdbMessage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
/* loaded from: classes.dex */
public final class AdbMessage {
    private final int arg0;
    private final int arg1;
    private final int checksum;
    private final int command;
    private final int magic;
    private final byte[] payload;
    private final int payloadLength;

    public AdbMessage(int i, int i2, int i3, int i4, int i5, int i6, byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.command = i;
        this.arg0 = i2;
        this.arg1 = i3;
        this.payloadLength = i4;
        this.checksum = i5;
        this.magic = i6;
        this.payload = payload;
    }

    /* renamed from: argStr */
    private final String m2208argStr(int arg) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%X", Arrays.copyOf(new Object[]{Integer.valueOf(arg)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String commandStr() {
        switch (this.command) {
            case AdbProtocol.CMD_CLSE /* 1163086915 */:
                return "CLSE";
            case AdbProtocol.CMD_WRTE /* 1163154007 */:
                return "WRTE";
            case AdbProtocol.CMD_AUTH /* 1213486401 */:
                return "AUTH";
            case AdbProtocol.CMD_OPEN /* 1313165391 */:
                return "OPEN";
            case AdbProtocol.CMD_CNXN /* 1314410051 */:
                return "CNXN";
            case AdbProtocol.CMD_OKAY /* 1497451343 */:
                return "OKAY";
            default:
                return "????";
        }
    }

    private final BufferedSource getSource() {
        C5052Buffer c5052Buffer = new C5052Buffer();
        c5052Buffer.mo14231write(this.payload, 0, this.payloadLength);
        return c5052Buffer;
    }

    private final String payloadStr() {
        int i = this.payloadLength;
        if (i == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        int i2 = this.command;
        if (i2 == 1163154007) {
            return writePayloadStr();
        }
        if (i2 != 1213486401) {
            if (i2 == 1313165391) {
                return new String(this.payload, 0, i - 1, Charsets.UTF_8);
            }
            return "payload[" + i + "]";
        }
        if (this.arg0 == 3) {
            return new String(this.payload, Charsets.UTF_8);
        }
        return "auth[" + i + "]";
    }

    private final String shellPayloadStr() {
        byte b;
        BufferedSource source = getSource();
        if (source.getBuffer().m14225size() < 5 || (b = source.readByte()) < 0 || b > 3 || source.readIntLe() != ((int) source.getBuffer().m14225size())) {
            return null;
        }
        if (b != 3) {
            return "[shell] " + new String(this.payload, 5, this.payloadLength - 5, Charsets.UTF_8);
        }
        return "[shell] exit(" + ((int) source.readByte()) + ")";
    }

    private final String syncPayloadStr() {
        BufferedSource source = getSource();
        if (source.getBuffer().m14225size() < 8) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String string = source.readString(4L, UTF_8);
        if (!AdbSyncStreamKt.getSYNC_IDS().contains(string)) {
            return null;
        }
        return "[sync] " + string + "(" + source.readIntLe() + ")";
    }

    private final String writePayloadStr() {
        String strShellPayloadStr = shellPayloadStr();
        if (strShellPayloadStr != null) {
            return strShellPayloadStr;
        }
        String strSyncPayloadStr = syncPayloadStr();
        if (strSyncPayloadStr != null) {
            return strSyncPayloadStr;
        }
        return "payload[" + this.payloadLength + "]";
    }

    public final int getArg0() {
        return this.arg0;
    }

    public final int getArg1() {
        return this.arg1;
    }

    public final int getChecksum() {
        return this.checksum;
    }

    public final int getCommand() {
        return this.command;
    }

    public final int getMagic() {
        return this.magic;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final int getPayloadLength() {
        return this.payloadLength;
    }

    public String toString() {
        return commandStr() + "[" + m2208argStr(this.arg0) + ", " + m2208argStr(this.arg1) + "] " + payloadStr();
    }
}
