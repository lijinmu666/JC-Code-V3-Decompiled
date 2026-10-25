package com.flyfishxu.p028kadb.p035shell;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Charsets;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellPacket;", BuildConfig.f24315FLAVOR, "payload", BuildConfig.f24315FLAVOR, "<init>", "([B)V", "getPayload", "()[B", "id", BuildConfig.f24315FLAVOR, "getId", "()I", "StdOut", "StdError", "Exit", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$Exit;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdError;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdOut;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AdbShellPacket {
    private final byte[] payload;

    @Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellPacket$Exit;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", BuildConfig.f24315FLAVOR, "<init>", "([B)V", "getPayload", "()[B", "id", BuildConfig.f24315FLAVOR, "getId", "()I", "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.shell.AdbShellPacket$Exit */
    public static final class C0197Exit extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0197Exit(byte[] payload) {
            super(payload, null);
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.payload = payload;
            this.id = 3;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public int getId() {
            return this.id;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "EXIT: " + ((int) getPayload()[0]);
        }
    }

    @Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdError;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", BuildConfig.f24315FLAVOR, "<init>", "([B)V", "getPayload", "()[B", "id", BuildConfig.f24315FLAVOR, "getId", "()I", "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class StdError extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StdError(byte[] payload) {
            super(payload, null);
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.payload = payload;
            this.id = 2;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public int getId() {
            return this.id;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "STDERR: " + new String(getPayload(), Charsets.UTF_8);
        }
    }

    @Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdOut;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", BuildConfig.f24315FLAVOR, "<init>", "([B)V", "getPayload", "()[B", "id", BuildConfig.f24315FLAVOR, "getId", "()I", "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.shell.AdbShellPacket$StdOut */
    public static final class C0198StdOut extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0198StdOut(byte[] payload) {
            super(payload, null);
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.payload = payload;
            this.id = 1;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public int getId() {
            return this.id;
        }

        @Override // com.flyfishxu.p028kadb.p035shell.AdbShellPacket
        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "STDOUT: " + new String(getPayload(), Charsets.UTF_8);
        }
    }

    public /* synthetic */ AdbShellPacket(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    public abstract int getId();

    public byte[] getPayload() {
        return this.payload;
    }

    private AdbShellPacket(byte[] bArr) {
        this.payload = bArr;
    }
}
