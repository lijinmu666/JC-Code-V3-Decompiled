package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class SerializationRegistry {
    private final Map<ParserIndex, KeyParser<?>> keyParserMap;
    private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
    private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
    private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

    public static class ParserIndex {
        private final Class<? extends Serialization> keySerializationClass;
        private final C0878Bytes serializationIdentifier;

        /* renamed from: equals */
        public boolean m3503equals(Object obj) {
            if (!(obj instanceof ParserIndex)) {
                return false;
            }
            ParserIndex parserIndex = (ParserIndex) obj;
            return parserIndex.keySerializationClass.equals(this.keySerializationClass) && parserIndex.serializationIdentifier.m4291equals(this.serializationIdentifier);
        }

        public int hashCode() {
            return Objects.hash(this.keySerializationClass, this.serializationIdentifier);
        }

        public String toString() {
            return this.keySerializationClass.getSimpleName() + ", object identifier: " + this.serializationIdentifier;
        }

        private ParserIndex(Class<? extends Serialization> cls, C0878Bytes c0878Bytes) {
            this.keySerializationClass = cls;
            this.serializationIdentifier = c0878Bytes;
        }
    }

    public static class SerializerIndex {
        private final Class<?> keyClass;
        private final Class<? extends Serialization> keySerializationClass;

        /* renamed from: equals */
        public boolean m3504equals(Object obj) {
            if (!(obj instanceof SerializerIndex)) {
                return false;
            }
            SerializerIndex serializerIndex = (SerializerIndex) obj;
            return serializerIndex.keyClass.equals(this.keyClass) && serializerIndex.keySerializationClass.equals(this.keySerializationClass);
        }

        public int hashCode() {
            return Objects.hash(this.keyClass, this.keySerializationClass);
        }

        public String toString() {
            return this.keyClass.getSimpleName() + " with serialization type: " + this.keySerializationClass.getSimpleName();
        }

        private SerializerIndex(Class<?> cls, Class<? extends Serialization> cls2) {
            this.keyClass = cls;
            this.keySerializationClass = cls2;
        }
    }

    public <SerializationT extends Serialization> boolean hasParserForKey(SerializationT serializationt) {
        return this.keyParserMap.containsKey(new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier()));
    }

    public <SerializationT extends Serialization> boolean hasParserForParameters(SerializationT serializationt) {
        return this.parametersParserMap.containsKey(new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier()));
    }

    public <KeyT extends AbstractC0308Key, SerializationT extends Serialization> boolean hasSerializerForKey(KeyT keyt, Class<SerializationT> cls) {
        return this.keySerializerMap.containsKey(new SerializerIndex(keyt.getClass(), cls));
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> boolean hasSerializerForParameters(ParametersT parameterst, Class<SerializationT> cls) {
        return this.parametersSerializerMap.containsKey(new SerializerIndex(parameterst.getClass(), cls));
    }

    public <SerializationT extends Serialization> AbstractC0308Key parseKey(SerializationT serializationt, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        ParserIndex parserIndex = new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier());
        if (this.keyParserMap.containsKey(parserIndex)) {
            return this.keyParserMap.get(parserIndex).parseKey(serializationt, secretKeyAccess);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + parserIndex + " available");
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializationt) throws GeneralSecurityException {
        ParserIndex parserIndex = new ParserIndex(serializationt.getClass(), serializationt.getObjectIdentifier());
        if (this.parametersParserMap.containsKey(parserIndex)) {
            return this.parametersParserMap.get(parserIndex).parseParameters(serializationt);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + parserIndex + " available");
    }

    public <KeyT extends AbstractC0308Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT keyt, Class<SerializationT> cls, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        SerializerIndex serializerIndex = new SerializerIndex(keyt.getClass(), cls);
        if (this.keySerializerMap.containsKey(serializerIndex)) {
            return (SerializationT) this.keySerializerMap.get(serializerIndex).serializeKey(keyt, secretKeyAccess);
        }
        throw new GeneralSecurityException("No Key serializer for " + serializerIndex + " available");
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        SerializerIndex serializerIndex = new SerializerIndex(parameterst.getClass(), cls);
        if (this.parametersSerializerMap.containsKey(serializerIndex)) {
            return (SerializationT) this.parametersSerializerMap.get(serializerIndex).serializeParameters(parameterst);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + serializerIndex + " available");
    }

    private SerializationRegistry(C0430Builder c0430Builder) {
        this.keySerializerMap = new HashMap(c0430Builder.keySerializerMap);
        this.keyParserMap = new HashMap(c0430Builder.keyParserMap);
        this.parametersSerializerMap = new HashMap(c0430Builder.parametersSerializerMap);
        this.parametersParserMap = new HashMap(c0430Builder.parametersParserMap);
    }

    /* renamed from: com.google.crypto.tink.internal.SerializationRegistry$Builder */
    public static final class C0430Builder {
        private final Map<ParserIndex, KeyParser<?>> keyParserMap;
        private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
        private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
        private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

        public C0430Builder() {
            this.keySerializerMap = new HashMap();
            this.keyParserMap = new HashMap();
            this.parametersSerializerMap = new HashMap();
            this.parametersParserMap = new HashMap();
        }

        /* renamed from: build */
        public SerializationRegistry m3502build() {
            return new SerializationRegistry(this);
        }

        public <SerializationT extends Serialization> C0430Builder registerKeyParser(KeyParser<SerializationT> keyParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(keyParser.getSerializationClass(), keyParser.getObjectIdentifier());
            if (this.keyParserMap.containsKey(parserIndex)) {
                KeyParser<?> keyParser2 = this.keyParserMap.get(parserIndex);
                if (!keyParser2.equals(keyParser) || !keyParser.equals(keyParser2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + parserIndex);
                }
            } else {
                this.keyParserMap.put(parserIndex, keyParser);
            }
            return this;
        }

        public <KeyT extends AbstractC0308Key, SerializationT extends Serialization> C0430Builder registerKeySerializer(KeySerializer<KeyT, SerializationT> keySerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(keySerializer.getKeyClass(), keySerializer.getSerializationClass());
            if (this.keySerializerMap.containsKey(serializerIndex)) {
                KeySerializer<?, ?> keySerializer2 = this.keySerializerMap.get(serializerIndex);
                if (!keySerializer2.equals(keySerializer) || !keySerializer.equals(keySerializer2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + serializerIndex);
                }
            } else {
                this.keySerializerMap.put(serializerIndex, keySerializer);
            }
            return this;
        }

        public <SerializationT extends Serialization> C0430Builder registerParametersParser(ParametersParser<SerializationT> parametersParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(parametersParser.getSerializationClass(), parametersParser.getObjectIdentifier());
            if (this.parametersParserMap.containsKey(parserIndex)) {
                ParametersParser<?> parametersParser2 = this.parametersParserMap.get(parserIndex);
                if (!parametersParser2.equals(parametersParser) || !parametersParser.equals(parametersParser2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + parserIndex);
                }
            } else {
                this.parametersParserMap.put(parserIndex, parametersParser);
            }
            return this;
        }

        public <ParametersT extends Parameters, SerializationT extends Serialization> C0430Builder registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> parametersSerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(parametersSerializer.getParametersClass(), parametersSerializer.getSerializationClass());
            if (this.parametersSerializerMap.containsKey(serializerIndex)) {
                ParametersSerializer<?, ?> parametersSerializer2 = this.parametersSerializerMap.get(serializerIndex);
                if (!parametersSerializer2.equals(parametersSerializer) || !parametersSerializer.equals(parametersSerializer2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + serializerIndex);
                }
            } else {
                this.parametersSerializerMap.put(serializerIndex, parametersSerializer);
            }
            return this;
        }

        public C0430Builder(SerializationRegistry serializationRegistry) {
            this.keySerializerMap = new HashMap(serializationRegistry.keySerializerMap);
            this.keyParserMap = new HashMap(serializationRegistry.keyParserMap);
            this.parametersSerializerMap = new HashMap(serializationRegistry.parametersSerializerMap);
            this.parametersParserMap = new HashMap(serializationRegistry.parametersParserMap);
        }
    }
}
