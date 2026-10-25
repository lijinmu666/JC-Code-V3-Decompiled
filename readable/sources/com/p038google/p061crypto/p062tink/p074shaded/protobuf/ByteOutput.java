package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class ByteOutput {
    /* renamed from: write */
    public abstract void mo3922write(byte b);

    /* renamed from: write */
    public abstract void mo3923write(ByteBuffer byteBuffer);

    /* renamed from: write */
    public abstract void mo3924write(byte[] bArr, int i, int i2);

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i, int i2);
}
