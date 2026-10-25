package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.internal.Serialization;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

/* loaded from: classes.dex */
public abstract class ParametersParser<SerializationT extends Serialization> {
    private final C0878Bytes objectIdentifier;
    private final Class<SerializationT> serializationClass;

    public interface ParametersParsingFunction<SerializationT extends Serialization> {
        Parameters parseParameters(SerializationT serializationt);
    }

    /* renamed from: create */
    public static <SerializationT extends Serialization> ParametersParser<SerializationT> m3493create(final ParametersParsingFunction<SerializationT> parametersParsingFunction, C0878Bytes c0878Bytes, Class<SerializationT> cls) {
        return (ParametersParser<SerializationT>) new ParametersParser<SerializationT>(c0878Bytes, cls) { // from class: com.google.crypto.tink.internal.ParametersParser.1
            @Override // com.p038google.p061crypto.p062tink.internal.ParametersParser
            public Parameters parseParameters(SerializationT serializationt) {
                return parametersParsingFunction.parseParameters(serializationt);
            }
        };
    }

    public final C0878Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public final Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract Parameters parseParameters(SerializationT serializationt);

    private ParametersParser(C0878Bytes c0878Bytes, Class<SerializationT> cls) {
        this.objectIdentifier = c0878Bytes;
        this.serializationClass = cls;
    }
}
