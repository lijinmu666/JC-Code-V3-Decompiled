package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.internal.Serialization;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class KeyParser<SerializationT extends Serialization> {
    private final C0878Bytes objectIdentifier;
    private final Class<SerializationT> serializationClass;

    public interface KeyParsingFunction<SerializationT extends Serialization> {
        AbstractC0308Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess);
    }

    /* renamed from: create */
    public static <SerializationT extends Serialization> KeyParser<SerializationT> m3485create(final KeyParsingFunction<SerializationT> keyParsingFunction, C0878Bytes c0878Bytes, Class<SerializationT> cls) {
        return (KeyParser<SerializationT>) new KeyParser<SerializationT>(c0878Bytes, cls) { // from class: com.google.crypto.tink.internal.KeyParser.1
            @Override // com.p038google.p061crypto.p062tink.internal.KeyParser
            public AbstractC0308Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess) {
                return keyParsingFunction.parseKey(serializationt, secretKeyAccess);
            }
        };
    }

    public final C0878Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public final Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract AbstractC0308Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess);

    private KeyParser(C0878Bytes c0878Bytes, Class<SerializationT> cls) {
        this.objectIdentifier = c0878Bytes;
        this.serializationClass = cls;
    }
}
