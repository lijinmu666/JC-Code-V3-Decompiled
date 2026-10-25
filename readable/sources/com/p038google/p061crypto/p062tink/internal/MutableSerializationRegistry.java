package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.internal.SerializationRegistry;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class MutableSerializationRegistry {
    private static final MutableSerializationRegistry GLOBAL_INSTANCE = new MutableSerializationRegistry();
    private final AtomicReference<SerializationRegistry> registry = new AtomicReference<>(new SerializationRegistry.C0430Builder().m3502build());

    public static MutableSerializationRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public <SerializationT extends Serialization> boolean hasParserForKey(SerializationT serializationt) {
        return this.registry.get().hasParserForKey(serializationt);
    }

    public <SerializationT extends Serialization> boolean hasParserForParameters(SerializationT serializationt) {
        return this.registry.get().hasParserForParameters(serializationt);
    }

    public <KeyT extends AbstractC0308Key, SerializationT extends Serialization> boolean hasSerializerForKey(KeyT keyt, Class<SerializationT> cls) {
        return this.registry.get().hasSerializerForKey(keyt, cls);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> boolean hasSerializerForParameters(ParametersT parameterst, Class<SerializationT> cls) {
        return this.registry.get().hasSerializerForParameters(parameterst, cls);
    }

    public <SerializationT extends Serialization> AbstractC0308Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess) {
        return this.registry.get().parseKey(serializationt, secretKeyAccess);
    }

    public AbstractC0308Key parseKeyWithLegacyFallback(ProtoKeySerialization protoKeySerialization, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("access cannot be null");
        }
        if (hasParserForKey(protoKeySerialization)) {
            return parseKey(protoKeySerialization, secretKeyAccess);
        }
        try {
            return new LegacyProtoKey(protoKeySerialization, secretKeyAccess);
        } catch (GeneralSecurityException e) {
            throw new TinkBugException("Creating a LegacyProtoKey failed", e);
        }
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializationt) {
        return this.registry.get().parseParameters(serializationt);
    }

    public Parameters parseParametersWithLegacyFallback(ProtoParametersSerialization protoParametersSerialization) {
        try {
            return parseParameters(protoParametersSerialization);
        } catch (GeneralSecurityException unused) {
            return new LegacyProtoParameters(protoParametersSerialization);
        }
    }

    public synchronized <SerializationT extends Serialization> void registerKeyParser(KeyParser<SerializationT> keyParser) {
        this.registry.set(new SerializationRegistry.C0430Builder(this.registry.get()).registerKeyParser(keyParser).m3502build());
    }

    public synchronized <KeyT extends AbstractC0308Key, SerializationT extends Serialization> void registerKeySerializer(KeySerializer<KeyT, SerializationT> keySerializer) {
        this.registry.set(new SerializationRegistry.C0430Builder(this.registry.get()).registerKeySerializer(keySerializer).m3502build());
    }

    public synchronized <SerializationT extends Serialization> void registerParametersParser(ParametersParser<SerializationT> parametersParser) {
        this.registry.set(new SerializationRegistry.C0430Builder(this.registry.get()).registerParametersParser(parametersParser).m3502build());
    }

    public synchronized <ParametersT extends Parameters, SerializationT extends Serialization> void registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> parametersSerializer) {
        this.registry.set(new SerializationRegistry.C0430Builder(this.registry.get()).registerParametersSerializer(parametersSerializer).m3502build());
    }

    public <KeyT extends AbstractC0308Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT keyt, Class<SerializationT> cls, @Nullable SecretKeyAccess secretKeyAccess) {
        return (SerializationT) this.registry.get().serializeKey(keyt, cls, secretKeyAccess);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT parameterst, Class<SerializationT> cls) {
        return (SerializationT) this.registry.get().serializeParameters(parameterst, cls);
    }
}
