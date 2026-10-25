package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.internal.Serialization;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class KeySerializer<KeyT extends AbstractC0308Key, SerializationT extends Serialization> {
    private final Class<KeyT> keyClass;
    private final Class<SerializationT> serializationClass;

    public interface KeySerializationFunction<KeyT extends AbstractC0308Key, SerializationT extends Serialization> {
        SerializationT serializeKey(KeyT keyt, @Nullable SecretKeyAccess secretKeyAccess);
    }

    /* renamed from: create */
    public static <KeyT extends AbstractC0308Key, SerializationT extends Serialization> KeySerializer<KeyT, SerializationT> m3486create(final KeySerializationFunction<KeyT, SerializationT> keySerializationFunction, Class<KeyT> cls, Class<SerializationT> cls2) {
        return (KeySerializer<KeyT, SerializationT>) new KeySerializer<KeyT, SerializationT>(cls, cls2) { // from class: com.google.crypto.tink.internal.KeySerializer.1
            @Override // com.p038google.p061crypto.p062tink.internal.KeySerializer
            public SerializationT serializeKey(KeyT keyt, @Nullable SecretKeyAccess secretKeyAccess) {
                return (SerializationT) keySerializationFunction.serializeKey(keyt, secretKeyAccess);
            }
        };
    }

    public Class<KeyT> getKeyClass() {
        return this.keyClass;
    }

    public Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract SerializationT serializeKey(KeyT keyt, @Nullable SecretKeyAccess secretKeyAccess);

    private KeySerializer(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.keyClass = cls;
        this.serializationClass = cls2;
    }
}
