package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

/* loaded from: classes.dex */
public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;

    /* renamed from: value */
    protected volatile MessageLite f3710value;

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        }
        if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).mo3555build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    /* renamed from: clear */
    public void m4051clear() {
        this.delayedBytes = null;
        this.f3710value = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        ByteString byteString;
        ByteString byteString2 = this.memoizedBytes;
        ByteString byteString3 = ByteString.f3559EMPTY;
        return byteString2 == byteString3 || (this.f3710value == null && ((byteString = this.delayedBytes) == null || byteString == byteString3));
    }

    public void ensureInitialized(MessageLite messageLite) {
        if (this.f3710value != null) {
            return;
        }
        synchronized (this) {
            if (this.f3710value != null) {
                return;
            }
            try {
                if (this.delayedBytes != null) {
                    this.f3710value = messageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);
                    this.memoizedBytes = this.delayedBytes;
                } else {
                    this.f3710value = messageLite;
                    this.memoizedBytes = ByteString.f3559EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f3710value = messageLite;
                this.memoizedBytes = ByteString.f3559EMPTY;
            }
        }
    }

    /* renamed from: equals */
    public boolean mo4050equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f3710value;
        MessageLite messageLite2 = lazyFieldLite.f3710value;
        return (messageLite == null && messageLite2 == null) ? toByteString().mo3942equals(lazyFieldLite.toByteString()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType())) : getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes.mo3944size();
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString.mo3944size();
        }
        if (this.f3710value != null) {
            return this.f3710value.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.f3710value;
    }

    public int hashCode() {
        return 1;
    }

    /* renamed from: merge */
    public void m4052merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (lazyFieldLite.containsDefaultInstance()) {
            return;
        }
        if (containsDefaultInstance()) {
            m4053set(lazyFieldLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = lazyFieldLite.extensionRegistry;
        }
        ByteString byteString2 = this.delayedBytes;
        if (byteString2 != null && (byteString = lazyFieldLite.delayedBytes) != null) {
            this.delayedBytes = byteString2.m3938concat(byteString);
            return;
        }
        if (this.f3710value == null && lazyFieldLite.f3710value != null) {
            setValue(mergeValueAndBytes(lazyFieldLite.f3710value, this.delayedBytes, this.extensionRegistry));
        } else if (this.f3710value == null || lazyFieldLite.f3710value != null) {
            setValue(this.f3710value.toBuilder().mergeFrom(lazyFieldLite.f3710value).mo3555build());
        } else {
            setValue(mergeValueAndBytes(this.f3710value, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = extensionRegistryLite;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            setByteString(byteString.m3938concat(codedInputStream.readBytes()), this.extensionRegistry);
        } else {
            try {
                setValue(this.f3710value.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).mo3555build());
            } catch (InvalidProtocolBufferException unused) {
            }
        }
    }

    /* renamed from: set */
    public void m4053set(LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.f3710value = lazyFieldLite.f3710value;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.extensionRegistry;
        if (extensionRegistryLite != null) {
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.f3710value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f3710value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.f3710value = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.memoizedBytes != null) {
                    return this.memoizedBytes;
                }
                if (this.f3710value == null) {
                    this.memoizedBytes = ByteString.f3559EMPTY;
                } else {
                    this.memoizedBytes = this.f3710value.toByteString();
                }
                return this.memoizedBytes;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: writeTo */
    public void m4054writeTo(InterfaceC0811Writer interfaceC0811Writer, int i) {
        if (this.memoizedBytes != null) {
            interfaceC0811Writer.writeBytes(i, this.memoizedBytes);
            return;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            interfaceC0811Writer.writeBytes(i, byteString);
        } else if (this.f3710value != null) {
            interfaceC0811Writer.writeMessage(i, this.f3710value);
        } else {
            interfaceC0811Writer.writeBytes(i, ByteString.f3559EMPTY);
        }
    }

    public LazyFieldLite() {
    }
}
