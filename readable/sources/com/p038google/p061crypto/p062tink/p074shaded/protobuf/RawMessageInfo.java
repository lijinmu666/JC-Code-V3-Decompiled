package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;

    /* renamed from: flags */
    private final int f3751flags;

    /* renamed from: info */
    private final String f3752info;

    /* renamed from: objects */
    private final Object[] f3753objects;

    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.defaultInstance = messageLite;
        this.f3752info = str;
        this.f3753objects = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f3751flags = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.f3751flags = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public Object[] getObjects() {
        return this.f3753objects;
    }

    public String getStringInfo() {
        return this.f3752info;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return (this.f3751flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return (this.f3751flags & 2) == 2;
    }
}
