package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.internal.Serialization;

/* loaded from: classes.dex */
public abstract class ParametersSerializer<ParametersT extends Parameters, SerializationT extends Serialization> {
    private final Class<ParametersT> parametersClass;
    private final Class<SerializationT> serializationClass;

    public interface ParametersSerializationFunction<ParametersT extends Parameters, SerializationT extends Serialization> {
        SerializationT serializeParameters(ParametersT parameterst);
    }

    /* renamed from: create */
    public static <ParametersT extends Parameters, SerializationT extends Serialization> ParametersSerializer<ParametersT, SerializationT> m3494create(final ParametersSerializationFunction<ParametersT, SerializationT> parametersSerializationFunction, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return (ParametersSerializer<ParametersT, SerializationT>) new ParametersSerializer<ParametersT, SerializationT>(cls, cls2) { // from class: com.google.crypto.tink.internal.ParametersSerializer.1
            @Override // com.p038google.p061crypto.p062tink.internal.ParametersSerializer
            public SerializationT serializeParameters(ParametersT parameterst) {
                return (SerializationT) parametersSerializationFunction.serializeParameters(parameterst);
            }
        };
    }

    public Class<ParametersT> getParametersClass() {
        return this.parametersClass;
    }

    public Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public abstract SerializationT serializeParameters(ParametersT parameterst);

    private ParametersSerializer(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.parametersClass = cls;
        this.serializationClass = cls2;
    }
}
