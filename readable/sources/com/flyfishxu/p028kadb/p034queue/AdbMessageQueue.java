package com.flyfishxu.p028kadb.p034queue;

import com.flyfishxu.p028kadb.p030core.AdbMessage;
import com.flyfishxu.p028kadb.p030core.AdbReader;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0004H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lcom/flyfishxu/kadb/queue/MessageQueue;", "Lcom/flyfishxu/kadb/core/AdbMessage;", "adbReader", "Lcom/flyfishxu/kadb/core/AdbReader;", "<init>", "(Lcom/flyfishxu/kadb/core/AdbReader;)V", "readMessage", "getLocalId", BuildConfig.f24315FLAVOR, "message", "getCommand", "close", BuildConfig.f24315FLAVOR, "isCloseCommand", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbMessageQueue extends MessageQueue<AdbMessage> implements AutoCloseable {
    private final AdbReader adbReader;

    public AdbMessageQueue(AdbReader adbReader) {
        Intrinsics.checkNotNullParameter(adbReader, "adbReader");
        this.adbReader = adbReader;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.adbReader.close();
    }

    @Override // com.flyfishxu.p028kadb.p034queue.MessageQueue
    public int getCommand(AdbMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.getCommand();
    }

    @Override // com.flyfishxu.p028kadb.p034queue.MessageQueue
    public int getLocalId(AdbMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.getArg1();
    }

    @Override // com.flyfishxu.p028kadb.p034queue.MessageQueue
    public boolean isCloseCommand(AdbMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.getCommand() == 1163086915;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.flyfishxu.p028kadb.p034queue.MessageQueue
    public AdbMessage readMessage() {
        return this.adbReader.readMessage();
    }
}
